package com.example.examtickets.services;

import com.example.examtickets.entities.Question;
import com.example.examtickets.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new LinkedHashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
            questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
            questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionForDelete = new Question(question, answer);
        if (!(questions.contains(questionForDelete))) {
            throw new QuestionNotFoundException("Такой билет не найден");
        } else {
            questions.remove(questionForDelete);
        }
        return questionForDelete;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(questions);
        Random random = new Random();
        return questionList.get(random.nextInt(questionList.size()));
    }
}
