package com.questionmark.doctorappointment.patient.controller;


import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.dto.LoginDTO;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.exceptions.PatientExceptions;
import com.questionmark.doctorappointment.patient.service.PatientService;
import com.questionmark.doctorappointment.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <h3>Patient Controller</h3>
 * APIs for patient services
 *
 * @author  Thanush A A
 * @version 1.0
 * @since   2024-02-19
 */
@CrossOrigin
@RestController
public class PatientController {
    private final PatientService patientService;


    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }
    @GetMapping("patient/get_all_patient")
    public List<Patient> getAllPatients(){return this.patientService.getAllPatient();}
    @PostMapping("patient/create_account")
    public Patient createAccount(@RequestBody Patient patient) throws PatientExceptions {
        return this.patientService.addPatient(patient);
    }
    @GetMapping("patient/get_appointments/{patientId}")
    public List<Appointment> getAppointments(@PathVariable Integer patientId) throws PatientExceptions {return this.patientService.getAllAppointmentOfPatient(patientId);}
    @GetMapping("patient/get_doctors/{spec}")
    public List<Doctor> getDoctorsBySpec(@PathVariable String spec){return this.patientService.getDoctorsBySpec(spec);}
    @PostMapping("patient/perform_payment/{id}")
    public Payment performPayment(@RequestBody String method, @PathVariable Integer id) throws PatientExceptions {
        return this.patientService.performPaymentForAppointment(method,id);
    }
    @PostMapping("patient/AppointmentStatus/{id}")
    public String getAppointmentStatus(@RequestBody Integer appointmentId, @PathVariable Integer id){
        return this.patientService.getStatusofAppointment(id,appointmentId);
    }
    @PostMapping("patient/login")
    public Patient loginPatient(@RequestBody LoginDTO loginDTO) throws PatientExceptions{
        return this.patientService.login(loginDTO);
    }



}
