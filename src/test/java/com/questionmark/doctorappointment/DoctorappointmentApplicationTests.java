package com.questionmark.doctorappointment;

import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.service.PatientService;
import jakarta.annotation.security.RunAs;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class DoctorappointmentApplicationTests {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;


	@Test
	 void testAccountCreation() {
        Patient patient = new Patient();
        patient.setAge(20);
        patient.setName("Thanush");
        patient.setEmail("tananth5@ford.com");
        patient.setGender("Sung Jinwoo");

        this.patientService.addPatient(patient);
        assertTrue(this.patientRepository.findById(patient.getPatientId()).isPresent());
	}




}
