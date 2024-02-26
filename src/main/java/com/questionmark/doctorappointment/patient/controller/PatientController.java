package com.questionmark.doctorappointment.patient.controller;


import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.service.AppointmentService;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.exceptions.PatientExceptions;
import com.questionmark.doctorappointment.patient.service.PatientService;
import com.questionmark.doctorappointment.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired private AppointmentService appointmentService;
    @GetMapping("patient/get_all_patient")
    public List<Patient> getAllPatients(){return this.patientService.getAllPatient();}

    @PostMapping("patient/create_account")
    public Patient createAccount(@RequestBody Patient patient) throws PatientExceptions {
        return this.patientService.addPatient(patient);
    }
    //code not working from here

    @GetMapping("patient/get_appointments")
    public List<Appointment> getAppointments(@RequestBody Integer patientId){return this.patientService.getAllAppointmentOfPatient(patientId);}

    @GetMapping("patient/get_doctors/{spec}")
    public List<Doctor> getDoctorsBySpec(@PathVariable String spec){return this.patientService.getDoctorsBySpec(spec);}

    @PostMapping("patient/perform_payment/{id}")
    public Payment performPayment(@RequestBody String method, @PathVariable Integer id) throws PatientExceptions {
        return this.patientService.performPaymentForAppointment(method,id);
    }
    @PostMapping("patient/AppoinmentStaus/{id}")
    public String getAppointmentStatus(@RequestBody Integer appointmentId, @PathVariable Integer id) {
        return this.patientService.getStatusofAppointment(id,appointmentId);
    }

}
