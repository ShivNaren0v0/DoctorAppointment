package com.ford.doctorappointment.Doctor.service;

import com.ford.doctorappointment.Doctor.entity.Doctor;
import com.ford.doctorappointment.Appointment.entity.Appointment;

public interface DoctorService {
    //Doctor DoctorLogin(String userName,String userPassword);

    public Appointment cancelAppointment(Appointment appointment);
    public Appointment confirmAppointment(Appointment appointment);

}
