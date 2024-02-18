package com.ford.doctorappointment.Patient.controller;


import com.ford.doctorappointment.Appointment.entity.Appointment;
import com.ford.doctorappointment.Patient.entity.Patient;
import com.ford.doctorappointment.Patient.service.PatientService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("patient/get_all_patient")
    public List<Patient> getAllPatients(){return this.patientService.getAllPatient();}

    @PostMapping("patient/create_account")
    public Patient createAccount(@RequestBody Patient patient) {
        return this.patientService.addPatient(patient);
    }
    //not working from here
    @PostMapping("patient/request_appointment")
    public Patient createAppointmentRequest(@RequestBody Appointment appointment, @RequestBody Integer patientId){return this.patientService.addAppointmentToPatient(patientId,appointment);}
    @GetMapping("patient/get_appointments")
    public List<Appointment> getAppointments(@RequestBody Integer patientId){return this.patientService.getAllAppointmentOfPatient(patientId);}
}
