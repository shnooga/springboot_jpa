package com.example.hellospringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * If Exception not here and missing @ResponseStatus, a 500 will be returned see IamTeaPotException
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(IamTeaPotException.class)
//    public final ResponseEntity<ErrorResponse> handleDefaults(IamTeaPotException ex, WebRequest request) {
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse error = new ErrorResponse(IamTeaPotException.class.getSimpleName(), details);
//        return new ResponseEntity<>(error, HttpStatus.I_AM_A_TEAPOT);
//    }

    @ExceptionHandler(ConflictException.class)
    public final ResponseEntity<ErrorResponse> handleConflict(ConflictException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(ConflictException.class.getSimpleName(), details);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(BadRequestException.class.getSimpleName(), details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}