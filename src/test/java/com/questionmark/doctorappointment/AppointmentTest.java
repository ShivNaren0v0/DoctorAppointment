package com.questionmark.doctorappointment;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import com.questionmark.doctorappointment.appointment.service.AppointmentService;
import com.questionmark.doctorappointment.appointment.service.AppointmentServiceImpl;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import com.questionmark.doctorappointment.patient.entity.Patient;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AppointmentTest {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentServiceImpl appointmentServiceImpl;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    void createAppointmentTest() throws AppointmentExceptions {

        try {
            Doctor doctor = new Doctor();
            doctor.setName("GK");
            doctor.setSpec("heart");
            doctor.setAppointmentList(null);
            doctorRepository.save(doctor);

            Patient patient = new Patient();
            patient.setName("Thanush");
            patient.setAge(20);
            patient.setGender("batman");
            patient.setEmail("thanush@student.tce.edu");
            patient.setPassword("a secret");
            patient.setAppointments(null);
            patientRepository.save(patient);

            Appointment newAppointment=new Appointment();
            newAppointment.setDoctorId(1);
            newAppointment.setTiming(LocalTime.of(11,22,33));
            newAppointment.setPatientId(1);
            newAppointment.setDate(LocalDate.of(2024,12,13));
            newAppointment.setDescription("heart");
            newAppointment.setStatus(false);
            newAppointment.setPayment(null);
            appointmentRepository.save(newAppointment);
            Appointment createdAppointment;
            createdAppointment = appointmentServiceImpl.createAppointment(newAppointment);
            Assertions.assertNotNull(createdAppointment, "Appointment has been created successfully");
        }
        catch (AssertionError e) {
            e.printStackTrace();
        }
    }
}
