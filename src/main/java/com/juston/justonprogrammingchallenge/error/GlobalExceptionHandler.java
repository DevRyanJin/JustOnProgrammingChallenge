package com.juston.justonprogrammingchallenge.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.juston.justonprogrammingchallenge.exception.InvalidDigitException;
import com.juston.justonprogrammingchallenge.exception.NoValueException;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError noHandlerFoundException(
            NoHandlerFoundException ex) {

        int code = 404;
        String message = "No handler found for your request.";
        return new ApiError(code, message,ex.getRequestURL());
    }
    
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError badRequestException(
    		InvalidFormatException ex) {

        int code = 400;
        String message = "Must Pass Valid Format";
        return new ApiError(code, message,ex.getMessage());
    }
    
    @ExceptionHandler(JsonEOFException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError jsonEOFException(
    		JsonEOFException ex) {
        int code = 400;
        String message = "Must Pass Valid json Format";
        return new ApiError(code, message, ex.getMessage());
    }
    
    @ExceptionHandler(JsonParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError jsonParseException(
    		JsonParseException ex) {
        int code = 400;
        String message = "Must Pass Valid json Format";
        return new ApiError(code, message,ex.getMessage());
    }
    

    @ExceptionHandler(JsonMappingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError jsonMappingException(
    		JsonMappingException ex) {
        int code = 400;
        String message = "Must Pass Valid json Format";
        return new ApiError(code, message,ex.getMessage());
    }
    

    @ExceptionHandler(NoValueException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError noValueException(
    		NoValueException ex) {
        int code = 500;
        String message = "Must Pass Valid Format";
        return new ApiError(code, message, ex.getMessage());
    }
    

    @ExceptionHandler(InvalidDigitException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError invalidDigitException(
    		InvalidDigitException ex) {
        int code = 500;
        String message = "Must Pass Valid Format";
        return new ApiError(code, message, ex.getMessage());
    }
    
    
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError nullPointerException(
    		NullPointerException ex) {
        int code = 500;
        String message = "Must Pass Valid json Format" ;
        return new ApiError(code, message, "NullPointerException");
        
    }
       
}