package com.ford.doctorappointment.Doctor.controller;


import com.ford.doctorappointment.Doctor.entity.Doctor;
import com.ford.doctorappointment.Doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ford.doctorappointment.Patient.entity.Patient;
import com.ford.doctorappointment.Patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;


}
