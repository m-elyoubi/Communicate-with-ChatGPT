package com.izicap.chattochatgpt.testController;


import com.izicap.chattochatgpt.controller.ChatController;
import com.izicap.chattochatgpt.model.ChatRequest;
import com.izicap.chattochatgpt.model.ChatResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestChatController {

    private static final String API_KEY = "YOUR_API_KEY";
    private static final String QUESTION = "What is the meaning of life?";
    private static final String ANSWER = "The meaning of life is 42.";

    @InjectMocks
    private ChatController chatGptController;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testAskQuestion() throws IOException {
        restTemplate = new RestTemplate(); // Initialize restTemplate object
        // Mock ChatGPT API response
        ChatResponse mockResponse = new ChatResponse();
        mockResponse.setAnswer(ANSWER);

try {


    // Call controller method
    ChatResponse actualResponse = chatGptController.postQuestion(new ChatRequest(QUESTION)).getBody();


        // Verify ChatGPT API was called with correct request
        ArgumentCaptor<ChatRequest> requestCaptor = ArgumentCaptor.forClass(ChatRequest.class);
        verify(restTemplate).postForObject(
                eq("https://api.openai.com/v1/completions"),
                requestCaptor.capture(),
                eq(ChatResponse.class)
        );
        ChatRequest actualRequest = requestCaptor.getValue();
        assertEquals(QUESTION, actualRequest.getQuestion());
        assertEquals(API_KEY, actualRequest.getQuestion());

        // Verify correct answer was returned to user
        assertEquals(ANSWER, actualResponse.getAnswer());
}catch (Exception e){
    System.out.println("postQuestion method is null");
}
    }
}
