package com.anderson.chatbot.controllers;


import com.anderson.chatbot.dto.MessageRequest;
import com.anderson.chatbot.utils.FaqAnswers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class FaqController {
    @PostMapping
    public ResponseEntity<String> answerQuestion(@RequestBody MessageRequest request){
        FaqAnswers faqAnswers = new FaqAnswers();
        System.out.println(faqAnswers.getAnswers().get(1).getAnswer());
        return ResponseEntity.ok("Ok");
    }
}
