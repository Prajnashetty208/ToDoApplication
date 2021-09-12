package com.todo.restapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomResponse ex = new CustomResponse(e.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST,e.getMessage());
        return new ResponseEntity<Object>(ex,HttpStatus.BAD_REQUEST);
    }

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
