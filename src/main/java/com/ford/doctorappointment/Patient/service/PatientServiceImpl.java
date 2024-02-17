package com.ford.doctorappointment.Patient.service;


import com.ford.doctorappointment.Patient.dao.PatientRepository;
import com.ford.doctorappointment.Patient.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

}
