package com.questionmark.doctorappointment.doctor.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.questionmark.doctorappointment.appointment.entity.Appointment;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Integer cancelAppointment(Integer appointmentId) {

        this.appointmentRepository.deleteById(appointmentId);
        return appointmentId;
    }

    @Override
    public Appointment confirmAppointment(Integer appointmentId) {
        Optional<Appointment> appointmentOptional =  this.appointmentRepository.findById(appointmentId);
        if (appointmentOptional.get() == null){
            System.out.println("Appointment is not available");//Handle exception later
            return null;
        }

        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(true);
        this.appointmentRepository.save(appointment);
        return appointment;
    }


}
