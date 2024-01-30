package com.m2ouazar.Sport.QCM.controller;

import com.m2ouazar.Sport.QCM.model.question;
import com.m2ouazar.Sport.QCM.model.quiz;
import com.m2ouazar.Sport.QCM.service.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class quizController {

    final quizService quizService;

    @Autowired
    public quizController(quizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<quiz> getQuiz(){
        quiz quiz;

            quiz= quizService.GenerateRandomQuiz();

        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }
}
