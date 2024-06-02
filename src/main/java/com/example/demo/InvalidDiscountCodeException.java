package com.example.demo;

public class InvalidDiscountCodeException extends RuntimeException {
    public InvalidDiscountCodeException(String message) {
        super(message);
    }
}
