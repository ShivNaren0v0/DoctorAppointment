package com.ford.doctorappointment.Patient.controller;


import com.ford.doctorappointment.Appointment.entity.Appointment;
import com.ford.doctorappointment.Patient.entity.Patient;
import com.ford.doctorappointment.Patient.service.PatientService;
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

    @PostMapping("patient/request_appointment")
    public Patient createAppointment(@RequestBody Appointment appointment){return null;}

}
