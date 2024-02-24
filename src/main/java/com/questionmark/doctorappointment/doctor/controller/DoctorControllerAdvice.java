package com.questionmark.doctorappointment.doctor.controller;

import com.questionmark.doctorappointment.doctor.exceptions.DoctorExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class DoctorControllerAdvice {
    @ExceptionHandler(value = {DoctorExceptions.class })
    public ResponseEntity<String> handleAccountException(DoctorExceptions e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}