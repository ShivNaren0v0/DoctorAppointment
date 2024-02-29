package com.questionmark.doctorappointment.admin.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements  AdminService{

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Doctor addDoctor(Doctor doctor) {
        doctor.setAppointmentList(new ArrayList<>());
        doctor.setRating(0.0);
        return this.doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> removeDoctorById(Integer doctorID) {
        Optional<Doctor> doctorOpt = this.doctorRepository.findById(doctorID);
        // exception handling
        this.doctorRepository.deleteById(doctorID);
        return this.doctorRepository.findAll();
    }

    @Override
    public Doctor getDocotrById(Integer doctorID) {
        Optional<Doctor> doctorOpt = this.doctorRepository.findById(doctorID);

        return doctorOpt.get();
    }

    @Override
    public List<Doctor> getallDoctors() {
        return this.doctorRepository.findAll();
    }

    @Override
    public Patient removePatient(Patient patient) {
        return null;
    }
}
