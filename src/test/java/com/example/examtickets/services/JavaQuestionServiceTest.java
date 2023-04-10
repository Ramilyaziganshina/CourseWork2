package com.example.examtickets.services;

import com.example.examtickets.entities.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {JavaQuestionService.class})
@ExtendWith(SpringExtension.class)
class JavaQuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    void add_success() {
        String question = "1";
        String answer = "11";

        Question expectedQuestion = new Question(question, answer);

        Question actualQuestion = questionService.add(question, answer);

        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void remove_success() {
        String question = "1";
        String answer = "11";

        Question expectedQuestion = new Question(question, answer);

        Question actualQuestion = questionService.remove(question, answer);

        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void getAll() {
        Question q1 = new Question("1", "11");
        Question q2 = new Question("2", "22");
        Collection<Question> questions = Set.of(q1, q2);

        Collection<Question> expectedQuestions = questions;

        Collection<Question> actualQuestions = questionService.getAll();

        assertEquals(expectedQuestions, actualQuestions);
    }
}