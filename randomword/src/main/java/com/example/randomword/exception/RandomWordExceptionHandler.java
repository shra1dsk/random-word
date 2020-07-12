package com.example.randomword.exception;

import com.example.randomword.response.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestControllerAdvice
public class RandomWordExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IOException.class)
    public ServiceResponse handleIOException(IOException e) {
        ServiceResponse response = new ServiceResponse();
        response.setResponseCode("server_error");
        response.setResponseMessage(e.getMessage());
        return response;
    }
}
