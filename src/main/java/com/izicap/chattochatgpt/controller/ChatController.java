package com.izicap.chattochatgpt.controller;

import com.izicap.chattochatgpt.model.ChatRequest;
import com.izicap.chattochatgpt.model.ChatResponse;
import com.izicap.chattochatgpt.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/question")
    public ResponseEntity<ChatResponse> postQuestion(@RequestBody ChatRequest request) {
        try {
            // Call the ChatGPTService to get the answer
            ChatResponse response = chatService.getChatGPTResponse(request);

            // Append the question and answer to a CSV file
            String filename="data/questions.csv";
            PrintWriter pw = new PrintWriter(new FileWriter(filename, true));

            // Read the first line of the file and add "Question;answer" if it is not already present
            if ( new File(filename).length() == 0) {
                pw.append("Question;answer\n");
            }

                    pw.append(request.getQuestion()+";" + response.getAnswer() +"\n");
                    pw.close();




            // Return the response to the user
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
