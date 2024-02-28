package com.questionmark.doctorappointment.patient.dao;

import com.questionmark.doctorappointment.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    Patient findByEmail(String email);
}
