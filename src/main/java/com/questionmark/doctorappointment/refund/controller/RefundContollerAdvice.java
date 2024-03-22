package com.questionmark.doctorappointment.refund.controller;

import com.questionmark.doctorappointment.refund.exceptions.RefundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RefundContollerAdvice {
    @ExceptionHandler(value = {RefundException.class })
    public ResponseEntity<String> handleAccountException(RefundException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
