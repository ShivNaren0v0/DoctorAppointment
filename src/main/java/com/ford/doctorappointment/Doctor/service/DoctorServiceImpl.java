package com.ford.doctorappointment.Doctor.service;

import com.ford.doctorappointment.Appointment.dao.AppointmentRepository;
import com.ford.doctorappointment.Doctor.dao.DoctorRepository;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ford.doctorappointment.Appointment.entity.Appointment;

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
