package code.with.vanilson.fullstack.contact.service;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Flux;

/**
 * AiService
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-09-08
 */
@AnonymousAllowed
@BrowserCallable
@CrossOrigin(origins = "http://localhost:8081")
@SuppressWarnings("unused")
public class AiService {

    private final ChatClient chatClient;

    // Constructor to build the ChatClient and set the API key using advisors
    public AiService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(
                        advisorSpec -> advisorSpec.param("Authorization", "Bearer " + System.getenv("OPENAI_API_KEY")))
                .build();
    }

    // Method to call the AI service and get a response
    public Flux<String> getCompilation(String prompt) {
        return chatClient
                .prompt()
                .user(prompt)
                .stream()
                .content();  // Get the content from the response
    }

}