package com.ford.doctorappointment.Admin.service;

import com.ford.doctorappointment.Doctor.dao.DoctorRepository;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements  AdminService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor addDoctor(Doctor doctor) {
        return this.doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return this.doctorRepository.findAll();
    }
}
