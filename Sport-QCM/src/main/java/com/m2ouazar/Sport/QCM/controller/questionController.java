package com.m2ouazar.Sport.QCM.controller;

import com.m2ouazar.Sport.QCM.model.question;
import com.m2ouazar.Sport.QCM.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class questionController {

    private final questionService questionService;

    @Autowired
    public questionController(questionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<question>> getQuestionsByRubrique(
            @RequestParam(name= "rubrique",required = false,defaultValue = "all") String rubrique){
        List<question> questions;
        if(rubrique.equals("all")){
           questions= questionService.getAllQuestions();
        }else {
           questions= questionService.getQuestionsByRubrique(rubrique);
        }

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    //GET QUESTION BY ID
    @GetMapping("/{id}")
    public ResponseEntity<question> questionById(@PathVariable String id){
        question question= questionService.questionById(id);

        if (question != null){
           return new ResponseEntity<>(question, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<question>(question, HttpStatus.NOT_FOUND);
        }
    }

    //POST QUESTION
    @PostMapping
    public ResponseEntity<question> postQuestion(@RequestBody question questionBody){
        question question= questionService.saveQuestion(questionBody);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }


    //PUT QUESTION
    @PutMapping("/{id}")
    public ResponseEntity<question> putQuestion(@RequestBody question questionBody, @PathVariable String id){
        question question= questionService.updateQuestion(id, questionBody);
        if (question != null){
            return new ResponseEntity<>(question, HttpStatus.OK);
        }

        else return new ResponseEntity<>(question, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<question> putQuestion(@PathVariable String id){
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
