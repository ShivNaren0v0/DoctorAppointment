package com.ford.doctorappointment.Doctor.service;

import com.ford.doctorappointment.Doctor.dao.DoctorRepository;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

}
