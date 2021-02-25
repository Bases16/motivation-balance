package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.security.JwtAuthenticationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { AuthenticationException.class, IllegalArgumentException.class} )
    protected ResponseEntity<Object> handleExceptions(RuntimeException ex, WebRequest request) {
        String message = "an unknown error occurred";
        if (ex instanceof JwtAuthenticationException) {
            message = "JWT token is expired or invalid";
        } else if (ex instanceof IllegalArgumentException) {
            if (ex.getMessage().equals("user with such email already exists"))
            message = ex.getMessage();
        }
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
