package com.example.examtickets.services;

import com.example.examtickets.entities.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ExaminerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ExaminerServiceImplTest {

    @Autowired
    private ExaminerService examinerService;

    @MockBean
    private QuestionService questionService;

    @Test
    void getQuestions_success() {
        int amount = 1;
        Question q1 = new Question("1", "11");
        Question q2 = new Question("2", "22");
        Collection<Question> questions = Set.of(q1, q2);

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(q1);
        Collection<Question> expectedQuestions = Set.of(q1);

        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        assertEquals(expectedQuestions, actualQuestions);
        verify(questionService).getAll();
        verify(questionService).getRandomQuestion();
        assertEquals(amount, actualQuestions.size());
    }
}