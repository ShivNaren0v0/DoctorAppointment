package com.questionmark.doctorappointment.doctor.service;

import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.appointment.entity.Appointment;

public interface DoctorService {
    //Doctor DoctorLogin(String userName,String userPassword);

    public Appointment cancelAppointment(Appointment appointment);
    public Appointment confirmAppointment(Appointment appointment);

}
