package com.questionmark.doctorappointment.patient.dao;

import com.questionmark.doctorappointment.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <h3>Patient Repository</h3>
 * Patient Repository
 *
 * @author  Thanush A A
 * @version 1.0
 * @since   2024-02-19
 */

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    Patient findByEmail(String email);
}
