package com.doctorappointment.doctorappointment.service;

import com.doctorappointment.doctorappointment.dao.PatientRepository;
import com.doctorappointment.doctorappointment.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

}
