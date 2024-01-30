package com.m2ouazar.Sport.QCM.service;

import com.m2ouazar.Sport.QCM.model.question;
import com.m2ouazar.Sport.QCM.repository.questionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class questionService {

    private final questionRepository questionRepository;

    @Autowired
    public questionService(questionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    //CRUD OPERATIONS

    //GET ALL QUESTIONS
    //RANDOM ORDER FOR QUESTIONS
    //RANDOM ORDER FOR ANSWERS OF A QUESTION
    public List<question> getAllQuestions(){
        List<question> randomList= new ArrayList<>(questionRepository.findAll());
        randomList.forEach(a->{
            List<String> opt=a.getOptions();
            Collections.shuffle(opt);
        });
        Collections.shuffle(randomList);
        return randomList;
    }

    //GET QUESTION BY ID
    //RANDOM ORDER FOR ANSWERS OF A QUESTION
    public question questionById(String id){
        question question=questionRepository.findById(id).orElse(null);
        if (question != null){
            Collections.shuffle(question.getOptions());
            return question;
        }
        return null;
    }


    //GET ALL QUESTIONS
    //RANDOM ORDER FOR QUESTIONS
    //RANDOM ORDER FOR ANSWERS OF A QUESTION
    public List<question> getQuestionsByRubrique(String rubrique){
        List<question> randomList= new ArrayList<>(questionRepository.findByRubrique(rubrique));
        randomList.forEach(a->{
            List<String> opt=a.getOptions();
            Collections.shuffle(opt);
        });
        Collections.shuffle(randomList);
        return randomList;
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
