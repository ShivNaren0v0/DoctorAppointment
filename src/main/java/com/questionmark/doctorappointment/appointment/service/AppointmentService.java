package com.questionmark.doctorappointment.appointment.service;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment newAppointment) throws AppointmentExceptions;

    Appointment getAppointmentById(Integer id) throws AppointmentExceptions;

    ResponseEntity<String> deleteAppointmentById(Integer id) throws AppointmentExceptions;

    List<Appointment> getAllAppointments() throws AppointmentExceptions;

    Appointment changeAppointmentByDate(Integer id, LocalDate newDate)throws AppointmentExceptions;

    Appointment changeAppointmentByTiming(Integer id, LocalTime newTiming) throws AppointmentExceptions;

    void deleteAllAppointment() throws AppointmentExceptions;
}
