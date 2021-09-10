package com.todo.restapp.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomResponse {
    String reason;
    HttpStatus statusCode;
    String exception;

    public CustomResponse(String reason, HttpStatus statusCode, String exception) {
        this.reason = reason;
        this.statusCode = statusCode;
        this.exception = exception;
    }
}
