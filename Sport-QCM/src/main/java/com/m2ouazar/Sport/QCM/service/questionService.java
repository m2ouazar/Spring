package com.m2ouazar.Sport.QCM.service;

import com.m2ouazar.Sport.QCM.model.question;
import com.m2ouazar.Sport.QCM.repository.questionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionService {

    private questionRepository questionRepository;

    @Autowired
    public questionService(questionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    //CRUD Operations
    //GET ALL QUESTIONS
    public List<question> getAllQuestions(){
        return questionRepository.findAll();
    }

    //GET QUESTION BY ID
    public question questionById(String id){
        return questionRepository.findById(id).orElse(null);
    }

    //POST QUESTION
    public question saveQuestion(question question){
        return questionRepository.save(question);
    }

    //PUT QUESTION
    public question updateQuestion(String id, question question){
        if(questionRepository.existsById(id)){
            question.setId(id);
            return questionRepository.save(question);
        }
        else return null;
    }

    //DELETE QUESTION
    public void deleteQuestion(String id){
        questionRepository.deleteById(id);
    }

    //TODO
}
