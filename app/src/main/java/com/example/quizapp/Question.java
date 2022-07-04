package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class Question {
    final String question;
    final List<String> options;
    final String answerIndex;
    String selectedIndex;


    public Question(String question, List<String> options, String answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }
}


