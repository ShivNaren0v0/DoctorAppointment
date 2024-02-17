package com.ford.doctorappointment.Doctor.dao;

import com.ford.doctorappointment.Doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
