package com.example.subscriptionservice.exception;

public class InvalidSubscriptionException  extends RuntimeException {
    public InvalidSubscriptionException(String message) {
        super(message);
    }
}