package com.anderson.chatbot.services;

import com.anderson.chatbot.domain.FaqAnswer;
import com.anderson.chatbot.utils.FaqAnswers;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class FaqService {

    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswer(String question){
        String[] words = question.toLowerCase().split("\\s+");
        List wordsList = Arrays.asList(words).stream().map(String::toLowerCase).map(this::replaceForbiddenChar).toList();

        for (FaqAnswer entry : faqAnswers.getAnswers()) {
            for (String keyword : entry.getKeywords()) {
                if (wordsList.contains(keyword.toLowerCase())) {
                    return entry.getAnswer();
                }
            }
        }

        return faqAnswers.getDefaultAnswer();

    }

    public String replaceForbiddenChar(String question){
        return question.replace("?","");
    }

}