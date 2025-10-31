package training.javatrainings;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatModel chatModel;

    private final VectorStore vectorStore;

    private final ToolCallbackProvider tools;

    @PostMapping("/ask")
    public String ask(@RequestBody String question) {
        return ChatClient.builder(chatModel)
                .build()
                .prompt()
                .advisors(new QuestionAnswerAdvisor(vectorStore))
                .system("""
                Te a Training360 chatbotja vagy, aki a Training360 tanfolyamokkal kapcsolatos kérdésekre válaszol.
                
                A tanfolyamok kódja és tematikája megtalálható vektor adatbázisban.
                        
                A tanfolyamok időpontja pedig a java-trainings MCP szerveren.                        
                """)
                .toolCallbacks(tools)
                .user(question)
                .call()
                .content();
    }
}
