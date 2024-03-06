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

    /**
     * <h3>findByEmail(String email)</h3>
     * Returns the Patient Entity in the repository corresponding to the e-mail ID.
     * @param email email ID string
     * @return Patient
     * @author  Thanush A A
     * @version 1.0
     * @since   2024-02-28
     */
    Patient findByEmail(String email);
}
