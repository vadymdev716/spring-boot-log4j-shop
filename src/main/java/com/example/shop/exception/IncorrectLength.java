package com.example.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Incorrect entered parameter length!")
public class IncorrectLength extends RuntimeException {

    public IncorrectLength(String message) {
        super(message);
    }
}
