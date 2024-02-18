package com.ford.doctorappointment.Admin.service;

import com.ford.doctorappointment.Appointment.dao.AppointmentRepository;
import com.ford.doctorappointment.Appointment.entity.Appointment;
import com.ford.doctorappointment.Doctor.dao.DoctorRepository;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import com.ford.doctorappointment.Patient.entity.Patient;
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
        doctor.setAppointmentList(null);
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
