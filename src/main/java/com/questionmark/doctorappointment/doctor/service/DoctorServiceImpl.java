package com.questionmark.doctorappointment.doctor.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.questionmark.doctorappointment.appointment.entity.Appointment;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment cancelAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment confirmAppointment(Appointment appointment) {
        return null;
    }


}
