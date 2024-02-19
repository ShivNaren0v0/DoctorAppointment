package com.questionmark.doctorappointment.admin.dao;

import com.questionmark.doctorappointment.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
