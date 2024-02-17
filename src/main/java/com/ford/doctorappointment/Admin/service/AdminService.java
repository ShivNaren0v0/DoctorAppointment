package com.ford.doctorappointment.Admin.service;

import com.ford.doctorappointment.Doctor.entity.Doctor;

import java.util.List;

public interface AdminService {
    Doctor addDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
}
