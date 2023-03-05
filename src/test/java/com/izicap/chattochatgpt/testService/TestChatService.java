package com.izicap.chattochatgpt.testService;

import com.izicap.chattochatgpt.model.ChatRequest;
import com.izicap.chattochatgpt.service.ChatService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChatService {

    @Autowired
    ChatService chatService;

    @Test
    void testGenerateResponse() throws IOException {
        ChatRequest chatRequest=new ChatRequest("What is ChatGPT AI?");
        String expectedResponseText = "ChatGPT is a large language model created by OpenAI, a leading artificial intelligence research organization.";
        String response= String.valueOf(chatService.getChatGPTResponse(chatRequest));

        assertEquals(response,expectedResponseText);
    }

}
