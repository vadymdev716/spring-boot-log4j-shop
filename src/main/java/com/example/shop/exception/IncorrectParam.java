package com.example.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Incorrect entered parameter length! You not entered any characters or only spaces!")
public class IncorrectParam extends RuntimeException {

    public IncorrectParam(String message) {
        super(message);
    }
}
