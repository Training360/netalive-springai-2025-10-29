# Bevezetés a Spring AI használatába (JAVA-SPRINGAI) (2 nap)

Mesterséges intelligencia, LLM, chat, text to image, transcription, text to speech

[A képzés oldala](https://www.training360.com/bevezetes-a-spring-ai-hasznalataba-tanfolyam-java-springai)

## Ismertető

A mesterséges intelligencia integrálása a modern alkalmazásokba egyre fontosabbá válik, és a Spring AI erre kínál hatékony és 
könnyen használható megoldásokat. A Spring ökoszisztémába illeszkedő Spring AI modul lehetővé teszi, hogy különféle 
AI-szolgáltatókat – mint például az OpenAI, Perplexity, Ollama vagy Groq – egyszerűen, deklaratív módon használjunk fel Java alapú alkalmazásokban. 
Legyen szó szöveggenerálásról, képelemzésről vagy nyelvi modellek alkalmazásáról, a Spring AI biztosítja a megszokott Spring-es élményt, 
így a fejlesztők gyorsan és hatékonyan építhetnek intelligens megoldásokat.

Ez a képzés célja, hogy gyakorlati példákon keresztül mutassa be a Spring AI alapvető képességeit, felépítését és használatát. 
Megismerkedünk az AI-szolgáltatók integrálásával, prompt kezelésével, valamint a streaming válaszok feldolgozásával is. 
A képzés során végig Spring Boot alapú alkalmazásokon dolgozunk, így a résztvevők már meglévő tudásukra építve sajátíthatják 
el az AI-megoldások hatékony beépítését a vállalati környezetbe is.

## Szükséges előképzettség

Alapszintű Java programozási ismeretek.

## Tematika

* Bevezetés az AI alkalmazások világába
  * Mesterséges intelligencia használata a vállalati alkalmazásokban
  * Használati esetek
  * LLM-ek és generatív AI szerepe
  * AI API-k és szolgáltatók rövid áttekintése
  * Modellek
  * Prompt, prompt enginieering
  * Zero-shot és few-shot prompting
  * Tokenizálás, tokenhasználat, context window
* Spring AI alapok
  * A Spring AI célja és helye a Spring ökoszisztémában
  * Támogatott szolgáltatók (OpenAI, Azure OpenAI, Hugging Face, stb.)
  * Konfiguráció Spring Boot-ban
  * API kulcsok kezelése biztonságosan
* Szöveggenerálás gyakorlata
  * Promptok kezelése Java-ból
  * System / user / assistant promptok megkülönböztetése
  * Prompt legjobb gyakorlatok
  * PromptTemplate használata változókkal, Template DSL (változók, elágazások és ciklusok)
  * Chat Conversation Memory
  * Streamelt válasz kezelése Spring WebFlux-szal, Server-Sent Events UI
  * Advisor
  * Moderation
  * Scope
* Struktúrált kimenet
  * Structured output
  * JSON, JSON Schema
  * Response metadata
* Real-time adatok használata
  * Tool Calling
  * Tool Specification
  * Tool Execution
* RAG
  * Dokumentum betöltés, ETL (`DocumentReader`, `DocumentTransformer`, `DocumentWriter`)
  * Chunk stratégiák
  * Különböző formátumok kezelése (JSON, text, HTML, Markdown, PDF)
  * Embedding
  * Vektor adatbázisok
  * Similarity search, relevancia rangsorolás
  * Lekérdezés
  * Metadata filter
* Text to Image
  * Képgenerálás
* Hang kezelése
  * Audio Transcription
  * Text to Speech
* Tesztelés és best practice-ek
  * Prompt tesztelés és validálás
  * AI válaszok determinisztikussá tétele (temperature, top-p)
  * Hatékonyság, költség és naplózás kezelése
  * Optimalizálás
  * Observability
  * Hibakezelés és fallback stratégiák
