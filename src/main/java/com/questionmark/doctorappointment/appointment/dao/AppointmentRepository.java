package com.questionmark.doctorappointment.appointment.dao;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
