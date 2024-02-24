package com.questionmark.doctorappointment.appointment.controller;

import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppointmentControllerAdvice {
    @ExceptionHandler(value = {AppointmentExceptions.class })
    public ResponseEntity<String> handleAccountException(AppointmentExceptions e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}