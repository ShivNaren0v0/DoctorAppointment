package com.questionmark.doctorappointment.appointment.dao;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;


public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    boolean existsByDoctorIdAndDateAndTiming(Integer doctorId, LocalDate date, LocalTime timing);
    boolean existsByPatientIdAndDateAndTiming(Integer patientId, LocalDate date, LocalTime timing);
}
