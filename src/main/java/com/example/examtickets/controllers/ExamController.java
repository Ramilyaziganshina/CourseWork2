package com.example.examtickets.controllers;

import com.example.examtickets.entities.Question;
import com.example.examtickets.exceptions.QuestionAmountException;
import com.example.examtickets.services.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({QuestionAmountException.class})
    public String handleException(RuntimeException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @RequestMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}