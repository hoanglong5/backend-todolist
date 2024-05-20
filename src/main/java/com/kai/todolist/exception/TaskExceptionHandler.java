package com.kai.todolist.exception;

import com.kai.todolist.enums.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> HandelItemNotFound(ItemNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(IllegalFieldException.class)
    public ResponseEntity<String> HandleCustomerNotFound(IllegalFieldException ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> HandleMethodArgument(MethodArgumentNotValidException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessage.PARAMETER_CANNOT_BE_NULL.getDetail());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> HandleEmptyJSon(HttpMessageNotReadableException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessage.REQUEST_BODY_IS_MISSING.getDetail());
    }
}
