package com.ford.doctorappointment.Patient.dao;

import com.ford.doctorappointment.Doctor.entity.Doctor;
import com.ford.doctorappointment.Patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {



}
