package com.questionmark.doctorappointment.appointment.service;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment newAppointment);

    Appointment getAppointmentById(Integer id) throws AppointmentExceptions;

    Appointment deleteAppointmentById(Integer id) throws AppointmentExceptions;

    List<Appointment> getAllAppointments() throws AppointmentExceptions;

    Appointment changeAppointmentByDate(Integer id, Appointment newDate)throws AppointmentExceptions;

    Appointment changeAppointmentByTiming(Integer id, Appointment newTiming) throws AppointmentExceptions;

    void deleteAllAppointment() throws AppointmentExceptions;
}
