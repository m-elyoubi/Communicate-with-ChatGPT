package com.izicap.chattochatgpt.testModel;

import com.izicap.chattochatgpt.model.ChatRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestConstructorAndGetter {
    @Test
    public void TestConstructorAndGetterOfChatRequest() {
        String question="What is your name?";
        ChatRequest chatRequest = new ChatRequest(question);
        assertEquals(question, chatRequest.getQuestion());
    }
    @Test
    public void TestConstructorAndGetterOfChatResponse() {
        ChatRequest chatRequest = new ChatRequest("What is the weather like today?");
        assertEquals("What is the weather like today?", chatRequest.getQuestion());
    }


}
