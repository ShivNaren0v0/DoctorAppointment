package com.questionmark.doctorappointment.appointment.controller;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import com.questionmark.doctorappointment.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@CrossOrigin
@RestController
public class AppointmentController {
    @Autowired
    public AppointmentService appointmentService;

    @PostMapping("appointment")
    public Appointment createAppointment(@RequestBody Appointment newAppointment) throws AppointmentExceptions
    {
        return this.appointmentService.createAppointment(newAppointment);
    }
    @GetMapping("appointment/{id}")
    public Appointment getAppointmentById(@PathVariable Integer id) throws AppointmentExceptions
    {
        return this.appointmentService.getAppointmentById(id);
    }
    @DeleteMapping("appointment/delete/{id}")
    public ResponseEntity<String> deleteAppointmentById(@PathVariable Integer id) throws AppointmentExceptions
    {
        this.appointmentService.deleteAppointmentById(id);
        return ResponseEntity.ok("Appointment deleted successfully");
    }
    @GetMapping
    public List<Appointment> getAllAppointments() throws AppointmentExceptions {
        return this.appointmentService.getAllAppointments();
    }

    @PutMapping("appointment/changeDate/{id}")
    public Appointment changeAppointmentByDate(@PathVariable Integer id, @RequestBody LocalDate newDate) throws AppointmentExceptions
    {
        return this.appointmentService.changeAppointmentByDate(id,newDate);
    }
    @PutMapping("appointment/changeTime/{id}")
    public Appointment changeAppointmentByTiming(@PathVariable Integer id, @RequestBody LocalTime newTiming) throws AppointmentExceptions
    {
        return this.appointmentService.changeAppointmentByTiming(id,newTiming);
    }
    @DeleteMapping("appointment/deleteAll")
    public void deleteAllAppointment() throws AppointmentExceptions
    {
        appointmentService.deleteAllAppointment();
    }
}
