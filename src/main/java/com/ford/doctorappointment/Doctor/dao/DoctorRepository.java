package com.ford.doctorappointment.Doctor.dao;

import com.ford.doctorappointment.Doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
