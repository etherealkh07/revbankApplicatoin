package com.bankApplication.Bank.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handelUserNotFound(UserNotFoundException ex)
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handelValidationError(MethodArgumentNotValidException ex)
    {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        return new ResponseEntity<>("Valid Error"+message,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handelOtherException(Exception ex)
    {
        return new ResponseEntity<>("Server error: "+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
