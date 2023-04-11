package com.example.examtickets.exceptions;

public class QuestionAmountException extends RuntimeException {
    public QuestionAmountException(String message) {
        super(message);
    }
}