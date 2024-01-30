package com.m2ouazar.Sport.QCM.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "quiz")
public class quiz {
    @Id
    private String id;
    private List<String> questions;


    public quiz(String id, List<String> questions) {
        this.questions = questions;
    }

    public quiz() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }
}
