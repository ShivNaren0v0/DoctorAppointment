package com.questionmark.doctorappointment.doctor.controller;


import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;


}
