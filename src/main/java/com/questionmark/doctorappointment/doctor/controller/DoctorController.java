package com.questionmark.doctorappointment.doctor.controller;


import com.questionmark.doctorappointment.appointment.controller.AppointmentController;
import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.doctor.service.DoctorService;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.PathIterator;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("doctor/confirm_appointment")
    Appointment confirmAppointment(@RequestBody Integer appointmentId){
        
    }

}
