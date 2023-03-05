package com.izicap.chattochatgpt.service;

import com.izicap.chattochatgpt.model.ChatRequest;
import com.izicap.chattochatgpt.model.ChatResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class ChatService {
    @Value("${openai.endpointUrl}")
    private String endpointUrl;

    @Value("${openai.apiKey}")
    private String apiKey;


    public ChatResponse getChatGPTResponse(ChatRequest request) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(endpointUrl);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer "+apiKey);

        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "text-davinci-003");
        requestBody.put("prompt", request.getQuestion());
        requestBody.put("max_tokens", 4000);
        requestBody.put("temperature", 1.0);


        StringEntity stringEntity = new StringEntity(requestBody.toString());
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        try {
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            JSONObject responseJson = new JSONObject(responseString);
            System.out.println("Answer from chatGPT "+responseJson);
            String answer=responseJson.getJSONArray("choices").getJSONObject(0).getString("text");

            return new ChatResponse(answer);
        } finally {
            httpResponse.close();
        }
    }

    public String getApikey() {
        return apiKey;
    }
}

