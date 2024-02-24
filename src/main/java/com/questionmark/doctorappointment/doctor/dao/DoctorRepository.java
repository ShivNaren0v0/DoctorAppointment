package com.questionmark.doctorappointment.doctor.dao;

import com.questionmark.doctorappointment.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
