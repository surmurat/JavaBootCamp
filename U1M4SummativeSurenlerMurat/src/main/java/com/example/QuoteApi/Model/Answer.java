package com.example.QuoteApi.Model;

import javax.validation.constraints.NotEmpty;

public class Answer {




    @NotEmpty(message = "Please pick an question")
    private String question;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
