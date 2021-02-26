package edu.arf4.motivationbalance.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(value = "edu.arf4.motivationbalance.controller")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { AuthenticationException.class, IllegalArgumentException.class} )
    protected ResponseEntity<Object> handleExceptions(RuntimeException ex, WebRequest request) {
        String errorBody = "UNKNOWN";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ex instanceof AuthenticationException) {
            errorBody = "BAD_CREDENTIALS";
            status = HttpStatus.FORBIDDEN;
        } else if (ex instanceof IllegalArgumentException) {
            if (ex.getMessage().equals("EMAIL_EXISTS"))
            errorBody = ex.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }
        return handleExceptionInternal(ex, errorBody, new HttpHeaders(), status, request);
    }

}
