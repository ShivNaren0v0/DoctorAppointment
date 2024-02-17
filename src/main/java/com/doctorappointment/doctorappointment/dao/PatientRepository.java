package com.doctorappointment.doctorappointment.dao;

import com.doctorappointment.doctorappointment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {


}
