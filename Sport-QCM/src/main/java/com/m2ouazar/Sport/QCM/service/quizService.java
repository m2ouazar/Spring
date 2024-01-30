package com.m2ouazar.Sport.QCM.service;

import com.m2ouazar.Sport.QCM.model.question;
import com.m2ouazar.Sport.QCM.model.quiz;
import com.m2ouazar.Sport.QCM.repository.questionRepository;
import com.m2ouazar.Sport.QCM.repository.quizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class quizService {

    private questionService questionService;
    private quizRepository quizRepository;

    @Autowired
    public quizService(questionService questionService, quizRepository quizRepository) {
        this.questionService = questionService;
        this.quizRepository = quizRepository;
    }



    public quiz GenerateRandomQuiz(){

        quiz quiz= new quiz();
        List<String> questions = new ArrayList<>();
        questionService.getAllQuestions().subList(0,5).forEach(a->questions.add(a.getId()));
        quiz.setQuestions(questions);
        return quizRepository.save(quiz);

    }



}
