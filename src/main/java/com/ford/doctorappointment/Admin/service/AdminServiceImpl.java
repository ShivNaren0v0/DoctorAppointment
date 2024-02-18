package com.ford.doctorappointment.Admin.service;

import com.ford.doctorappointment.Doctor.dao.DoctorRepository;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import com.ford.doctorappointment.Patient.entity.Patient;
import java.util.List;

@Service
public class AdminServiceImpl implements  AdminService{

    @Override
    public Doctor addDoctor(Doctor product) {
        return null;
    }

    @Override
    public Doctor removeDoctor(Doctor doctor) {
        return null;
    }

    @Override
    public Patient removePatient(Patient patient) {
        return null;
    }
}
