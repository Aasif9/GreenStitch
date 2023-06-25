package com.example.GreenStitchAssignment.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorHandler> myExceptionHandler(UserException pe , WebRequest req)
    {
        ErrorHandler err  = new ErrorHandler();
        err.setDescription(req.getDescription(false));
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(pe.getMessage());

        return new ResponseEntity<ErrorHandler>(err,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorHandler> myExceptionHandler(MethodArgumentNotValidException pe)
    {
        ErrorHandler err  = new ErrorHandler();
        err.setDescription("getting Error");
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(pe.getFieldError().getDefaultMessage());

        return new ResponseEntity<ErrorHandler>(err,HttpStatus.BAD_REQUEST);

    }
}