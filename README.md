# NETA.live 2025. október 29. - Spring AI

Viczián István (istvan.viczian a training360.com domainen)

[NETA.LIVE](https://netacademia.hu/pages/neta-live)

## Projekt létrehozása

- `
- Függőségek: OpenAI, Web, Lombok, Actuator
- Csomag: `training`

Projekt inicializálása:

- `application.properties`

## Chat Client

Cél:

- Szabad szövegesen tudjon válaszolni
- Jelen esetben: még általános kérdésekre

```properties
spring.config.import=optional:classpath:application-secret.properties

spring.ai.openai.chat.options.model=gpt-5-mini
spring.ai.openai.chat.options.temperature=1

management.endpoints.web.exposure.include=*
```

- `.gitignore`

```gitignore
target/
.idea/
application-secret.properties
```

- `application-secret.properties` átmásolása

```properties
spring.ai.openai.api-key=...
spring.ai.openai.project-id=...
```

```java
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatModel chatModel;

    @PostMapping("/ask")
    public String ask(@RequestBody String question) {
        return chatModel.call(question);
    }
}
```

## RAG betöltés

Cél:

- Saját dokumentumainkat figyelembe véve válaszoljon
- Jelen esetben: ismerje a tanfolyamok kódjait, leírását, tematikáját

* Be kell tenni azokat is a kontextusba
* Költséges az összes dokumentumunkat a kontextusba tenni (token)
* A kérdéshez kapcsolódó dokumentumokat kell csak átadni
* Embedding: az a folyamat, mely során egy modell számok sorozatává, azaz vektorrá alakítja
* A vektor a térben egy irányt és nagyságot jelent (több dimenzió)
* A vektorok közötti távolság azt mutatja meg, hogy a jelentésük mennyire hasonló

- Input könyvtár átmásolása

```shell
docker run -d -p 6333:6333 -p 6334:6334 --name qdrant qdrant/qdrant
```

http://localhost:6333/dashboard

- Függőség: Qdrant

```properties
spring.ai.vectorstore.qdrant.collection-name=java-trainings
spring.ai.vectorstore.qdrant.initialize-schema=true
```

```java
@Component
@RequiredArgsConstructor
@Slf4j
public class TrainingsLoader {

    private final VectorStore vectorStore;

    @PostConstruct
    void loadTrainings() throws IOException {
        var documents = Files.list(Path.of("input"))
                .flatMap(file -> {
                        DocumentReader reader = new TextReader(new FileSystemResource(file));
                        return reader.read().stream();
                }).toList();
        vectorStore.accept(documents);
        log.info("Loaded {} documents", documents.size());
    }
}
```

- Megnézni a Dashboardon, vector, metaadatok

## RAG használata a Chat Clientben

- Loadert kikapcsolni
- Függőség: Advisors

```xml
<dependency>
   <groupId>org.springframework.ai</groupId>
   <artifactId>spring-ai-advisors-vector-store</artifactId>
</dependency>
```

`VectorStore` injektálása

```java
return ChatClient.builder(chatModel)
        .build()
        .prompt()
        .advisors(new QuestionAnswerAdvisor(vectorStore))
        .system("""
                Te a Training360 chatbotja vagy, aki a Training360 tanfolyamokkal kapcsolatos kérdésekre válaszol.
                """)
        .user(question)
        .call()
        .content();
```

"Mely tanfolyam szól a Spring AI-ról?"

Breakpoint: `QuestionAnswerAdvisor` 119. sorába

## MCP bemutatás

- Cél:

- Saját rendszerből származó élő adatokat szeretnénk használni
- Jelen esetben: képzések indulásának az időpontja

[Model Context Protocol (MCP)](https://modelcontextprotocol.io/introduction)

AI model tudjon kommunikálni külső eszközökkel. Client - server modell.

Host - MCP Client - MCP Server - app.

Host: Claude Desktop, IDE-k, stb.

Transport:

- Stdio
- SSE (deprecated)
- Streamable HTTP (leváltotta az SSE-t), JSON-RPC, optional Server-Sent Events (SSE) streams for server-to-client communication

Miben más, mint a REST?

- Stateful (context)
- Kétirányú

[MCP Proxy](https://github.com/sparfenyuk/mcp-proxy)

Tulajdonságai:

- Van egy initialization fázis
- Request-response
- Notification

[Servers](https://github.com/modelcontextprotocol/servers?tab=readme-ov-file)

[Clients](https://modelcontextprotocol.io/clients), pl. VS Code GitHub Copilot

## Visual Studio Code

- DBCode Extension
- Start
- Toggle chat - Ask Copilot
- Mode: Agent
- Select Tools: MCP Server

"Milyen táblák vannak az adatbázisban?"

"Van-e JAVA-SPRINGAI kódú tanfolyam?"

## Docker Desktop

- Docker MCP Toolkit

## MCP Server implementálása

Cél:

- Olyan MCP szerver implementálása, amely kód alapján visszaadja az induló tanfolyamokat

Projekt létrehozása:

- `java-trainings-mcp-server`
- Függőségek: JPA, Web, Lombok, PostgreSQL
- Csomag: `training`

Az 1.0 még nem tartalmazza a Streamable HTTP protokollt.

```xml
<spring-ai.version>1.1.0-M3</spring-ai.version>
```

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-mcp-server-webmvc</artifactId>
</dependency>
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/java-trainings
spring.datasource.username=java-trainings
spring.datasource.password=java-trainings
server.port=8081

spring.ai.mcp.server.protocol=streamable
```

- Create Data Source

- Create entity

```java
@Entity
@Table(name = "courses")
@Getter @Setter
public class Course {
    @Id
    private Long id;

    @Column(name = "shortid")
    private String code;

    private String title;

    @Column(name = "startdate")
    private LocalDate startDate;
}
```

- Create repository

```java
@Component
@RequiredArgsConstructor
@Slf4j
public class CourseTool {

    private final CourseRepository courseRepository;

    @McpTool(name = "findCourseByCode", description = "Visszaadja a tanfolyamok adatait, időpontjait a tanfolyam kódja alapján")
    public List<Course> findCourseByCode(String code) {
        log.info("find course by code: {}", code);
        return courseRepository.findByCode(code);
    }
}
```

## Hívás MCP Inspector használatával

```shell
docker run -d --name mcp-inspector -p 6274:6274 -p 6277:6277 -e HOST=0.0.0.0 -e DANGEROUSLY_OMIT_AUTH=true ghcr.io/modelcontextprotocol/inspector:0.17.2
```

http://localhost:6274/

- Streamable HTTP
- http://host.docker.internal:8081/mcp
- Tools, List tools, Run Tool

### Hívás IDEA használatával

Settings / Tools / GitHub Copilot / Model Context Protocol (MCP) / Configure

```json
"java-trainings": {
  "type": "streamable-http",
  "url": "http://localhost:8081/mcp"
}
```

"A java-trainings MCP szervert használva mikor lesz a következő JAVA-SPRINGAI kódú kurzus?"

### MCP client implementálása

Függőség:

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-mcp-client</artifactId>
</dependency>
```

```xml
<spring-ai.version>1.1.0-M3</spring-ai.version>
```

Tool

```java
private final ToolCallbackProvider tools;
```

```java
.toolCallbacks(tools)
```

```
A tanfolyamok kódja és tematikája megtalálható vektor adatbázisban.

A tanfolyamok időpontja pedig a java-trainings MCP szerveren.
```

"Mikor lesz legközelebb Spring AI tanfolyam?"

`java-trainings-mcp-server` log

### Actuator

```
GET http://localhost:8080/actuator/metrics/gen_ai.client.token.usage
```
