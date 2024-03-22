package com.questionmark.doctorappointment.appointment.controller;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import com.questionmark.doctorappointment.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@CrossOrigin("http://localhost:4200/")
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
    public Appointment deleteAppointmentById(@PathVariable Integer id) throws AppointmentExceptions
    {
        return this.appointmentService.deleteAppointmentById(id);
    }
    @GetMapping
    public List<Appointment> getAllAppointments() throws AppointmentExceptions {
        return this.appointmentService.getAllAppointments();
    }

    @PutMapping("appointment/changeDate/{id}")
    public Appointment changeAppointmentByDate(@PathVariable Integer id, @RequestBody Appointment newDate) throws AppointmentExceptions
    {
        return this.appointmentService.changeAppointmentByDate(id,newDate);
    }
    @PutMapping("appointment/changeTime/{id}")
    public Appointment changeAppointmentByTiming(@PathVariable Integer id, @RequestBody Appointment newTiming) throws AppointmentExceptions
    {
        return this.appointmentService.changeAppointmentByTiming(id,newTiming);
    }
    @DeleteMapping("appointment/deleteAll")
    public void deleteAllAppointment() throws AppointmentExceptions
    {
        this.appointmentService.deleteAllAppointment();
    }



}
