package com.questionmark.doctorappointment.doctor.dao;

import com.questionmark.doctorappointment.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
