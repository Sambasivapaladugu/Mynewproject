package com.shiva.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> exceptionhandler(UserNotFoundException e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = UserAlreadyPresentException.class)
    public ResponseEntity<String> exceptionhandler(UserAlreadyPresentException e) {
        return new ResponseEntity<>("erorr exception occured in Global " + e.getMessage(), HttpStatus.CONFLICT);
    }

}
