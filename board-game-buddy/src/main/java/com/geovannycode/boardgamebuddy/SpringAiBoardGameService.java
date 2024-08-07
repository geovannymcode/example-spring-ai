package com.geovannycode.boardgamebuddy;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class SpringAiBoardGameService implements BoardGameService {

    private final ChatClient chatClient;

    public SpringAiBoardGameService(ChatClient.Builder chatClientBuilder) { // <1>
        this.chatClient = chatClientBuilder.build(); // <2>
    }

    @Override
    public Answer askQuestion(Question question) {
        String answerText = chatClient.prompt()
                .user(question.question())      // <3>
                .call()
                .content();
        return new Answer(answerText);
    }

}
