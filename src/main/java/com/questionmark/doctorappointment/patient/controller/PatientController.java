package com.questionmark.doctorappointment.patient.controller;


import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.dto.AppointmentRequestDTO;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.service.PatientService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    //code not working from here
    @PostMapping("patient/request_appointment")
    public Patient createAppointmentRequest(@RequestBody AppointmentRequestDTO appointmentRequestDTO){
        return this.patientService.addAppointmentToPatient(appointmentRequestDTO.getPatientId(),appointmentRequestDTO.getAppointment());}
    @GetMapping("patient/get_appointments")
    public List<Appointment> getAppointments(@RequestBody Integer patientId){return this.patientService.getAllAppointmentOfPatient(patientId);}

    @GetMapping("patient/get_doctors/{spec}")
    public List<Doctor> getDoctorsBySpec(@PathVariable String spec){return this.patientService.getDoctorsBySpec(spec);}

}
