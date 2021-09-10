package com.todo.restapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> handleException(ItemNotFoundException e){
        CustomResponse ex = new CustomResponse("Item not found in the list", HttpStatus.NOT_FOUND,e.getMessage());
        return new ResponseEntity<Object>(ex,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DuplicateItemException.class)
    public ResponseEntity<Object> handlePersonalDetailsNotFoundException(DuplicateItemException e){
        CustomResponse ex = new CustomResponse("Item already exists in the list", HttpStatus.CONFLICT,e.getMessage());
        return new ResponseEntity<Object>(ex,HttpStatus.CONFLICT);
    }

}
