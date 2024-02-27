package com.questionmark.doctorappointment.doctor.service;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.exceptions.DoctorExceptions;

import java.util.List;

public interface DoctorService {
    //Doctor DoctorLogin(String userName,String userPassword);

    public Integer cancelAppointment(Integer appointmentId) throws DoctorExceptions;
    public Appointment confirmAppointment (Integer appointmentId, Double amount) throws DoctorExceptions;

    List<Appointment> getAllAppointmentOfDoctor(Integer doctorId) throws DoctorExceptions;
}
