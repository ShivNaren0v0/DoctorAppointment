package com.ford.doctorappointment.Admin.dao;

import com.ford.doctorappointment.Admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
