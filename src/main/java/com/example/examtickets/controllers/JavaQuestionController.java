package com.example.examtickets.controllers;

import com.example.examtickets.entities.Question;
import com.example.examtickets.exceptions.QuestionNotFoundException;
import com.example.examtickets.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/exam/java")
@RestController
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(QuestionNotFoundException.class)
    public String handlerException(QuestionNotFoundException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @RequestMapping("/add")
    public Question addQuestion(String question, String answer) {
        return questionService.add(question, answer);
    }

    @RequestMapping("/remove")
    public Question removeQuestion(String question, String answer) {
        return questionService.remove(question, answer);
    }

    @RequestMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
