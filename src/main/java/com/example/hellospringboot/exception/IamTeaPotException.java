package com.example.hellospringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
//@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class IamTeaPotException extends RuntimeException {
    public IamTeaPotException(String message) {
        super(message);
    }
}