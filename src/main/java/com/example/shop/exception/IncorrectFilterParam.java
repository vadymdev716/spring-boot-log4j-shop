package com.example.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Incorrect entered parameter!")
public class IncorrectFilterParam extends IllegalArgumentException {

    public IncorrectFilterParam(String message) {
        super(message);
    }
}
