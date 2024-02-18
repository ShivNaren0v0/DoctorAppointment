package com.ford.doctorappointment.Doctor.service;

import com.ford.doctorappointment.Appointment.entity.Appointment;

public interface DoctorService {
    public Appointment cancelAppointment(Appointment appointment);
    public Appointment confirmAppointment(Appointment appointment);

}
