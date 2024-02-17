package com.ford.doctorappointment.Admin.controller;

import com.ford.doctorappointment.Admin.service.AdminService;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController{
        @Autowired
        private AdminService adminService;
    @PostMapping("doctor")
    public Doctor addNewDoctor(@RequestBody Doctor doctor) {
        return this.adminService.addDoctor(doctor);

    }

    @GetMapping("doctors")
    public List<Doctor> getAllDoctor() {
        return this.adminService.getAllDoctors();

    }

}
