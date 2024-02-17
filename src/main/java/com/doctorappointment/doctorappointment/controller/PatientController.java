package com.doctorappointment.doctorappointment.controller;

import com.doctorappointment.doctorappointment.entity.Patient;
import com.doctorappointment.doctorappointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("patient")
    public Patient createAccount(@RequestBody Patient patient) {
        return this.patientService.addPatient(patient);
    }

}
