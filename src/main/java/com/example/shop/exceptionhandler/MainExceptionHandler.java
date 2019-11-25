package com.example.shop.exceptionhandler;

import com.example.shop.encoding.decoding.RegExpressionDecodingImpl;
import com.example.shop.product.ProductController;
import com.example.shop.product.filter.ProductFilterImpl;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.regex.PatternSyntaxException;

@Log4j
@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(PatternSyntaxException.class)
    public ResponseEntity patternSyntaxException(PatternSyntaxException exception) {
        log.error(String.format("\n This error related to %s and class %s. " +
                "\n Message = %s", ProductController.class, ProductFilterImpl.class, exception.getMessage()));
        return new ResponseEntity<>("Incorrect entered parameter!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity illegalArgumentException(IllegalArgumentException exception) {
        log.error(String.format("\n This error related to class %s and class %s. \n Message = %s", ProductController.class,
                RegExpressionDecodingImpl.class, exception.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect entered parameter!");
    }
}
