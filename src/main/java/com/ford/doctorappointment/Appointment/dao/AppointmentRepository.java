package com.ford.doctorappointment.Appointment.dao;

import com.ford.doctorappointment.Appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
