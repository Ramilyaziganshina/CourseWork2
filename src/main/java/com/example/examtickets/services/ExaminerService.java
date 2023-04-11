package com.example.examtickets.services;

import com.example.examtickets.entities.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
