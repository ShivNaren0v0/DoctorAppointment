package com.questionmark.doctorappointment.payment.controller;

import com.questionmark.doctorappointment.payment.entity.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.questionmark.doctorappointment.payment.exceptions.PaymentException;

@RestControllerAdvice
public class PaymentContollerAdvice {

    @ExceptionHandler(value = {PaymentException.class })
    public ResponseEntity<String> handleAccountException(PaymentException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}