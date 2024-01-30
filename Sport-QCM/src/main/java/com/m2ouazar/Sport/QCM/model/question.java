package com.m2ouazar.Sport.QCM.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

@Document(collection = "questions")
public class question {

    @Id
    private String id;
    private String question;
    private List<String> options;
    private String correctAnswer;
    private String rubrique;


    public question() {
    }

    public question(String question, List<String> options, String correctAnswer, String rubrique) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.rubrique = rubrique;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getRubrique() {
        return rubrique;
    }

    public void setRubrique(String rubrique) {
        this.rubrique = rubrique;
    }
}
