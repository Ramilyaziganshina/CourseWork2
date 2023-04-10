package com.example.examtickets.services;

import com.example.examtickets.entities.Question;
import com.example.examtickets.exceptions.QuestionAmountException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1) {
            throw new QuestionAmountException("Вопросов в билете не может быть меньше одного");
        }
        if (amount > questionService.getAll().size()) {
            throw new QuestionAmountException("В списке нет столько вопросов");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
