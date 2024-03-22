package com.questionmark.doctorappointment.doctor.controller;


import com.questionmark.doctorappointment.appointment.controller.AppointmentController;
import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.dto.ConfirmationDTO;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.doctor.exceptions.DoctorExceptions;
import com.questionmark.doctorappointment.doctor.service.DoctorService;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.PathIterator;
import java.util.List;
@CrossOrigin("http://localhost:4200/")
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
    Appointment confirmAppointment(@RequestBody ConfirmationDTO confirmationDTO) throws DoctorExceptions {
        return this.doctorService.confirmAppointment(confirmationDTO.getAppointmentId(), confirmationDTO.getAmount());
    }

    @PostMapping("doctor/cancel_appointment/{appointmentId}")
    Appointment cancelAppointment(@PathVariable Integer appointmentId) throws DoctorExceptions {
        return this.doctorService.cancelAppointment(appointmentId);
    }

    @GetMapping("doctor/get_appointment/{doctorId}")
    List<Appointment> getAppointments(@PathVariable Integer doctorId) throws DoctorExceptions{
        return this.doctorService.getAllAppointmentOfDoctor(doctorId);
    }



}
