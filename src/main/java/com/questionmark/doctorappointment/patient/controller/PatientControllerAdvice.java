package com.questionmark.doctorappointment.patient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.questionmark.doctorappointment.patient.exceptions.PatientExceptions;
/**
 * <h3>Patient Controller Advice</h3>
 * Used for handling the patient exceptions
 *
 * @author  Thanush A A
 * @version 1.0
 * @since   2024-02-24
 */
@RestControllerAdvice
public class PatientControllerAdvice {

    /**
     * <h3>ResponseEntity<> handlePatientException(PatientExceptions e)</h3>
     * redirecting the patient exceptions
     * @param e Patient Exception class
     * @author  Thanush A A
     * @version 1.0
     * @since   2024-02-24
     */

    @ExceptionHandler(value = {PatientExceptions.class })
    public ResponseEntity<String> handlePatientException(PatientExceptions e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}