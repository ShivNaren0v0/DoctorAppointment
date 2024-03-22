package com.questionmark.doctorappointment.admin.controller;
import com.questionmark.doctorappointment.admin.service.AdminService;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("addDoctor")
    public Doctor registerNewDoctor(@RequestBody Doctor doctor) {

        return this.adminService.addDoctor(doctor);
    }
    @DeleteMapping("delDoctor/{id}")
    public List<Doctor> deleteDoctorById(@PathVariable Integer id){
        return this.adminService.removeDoctorById(id);

    }
    @GetMapping("Doctor/{id}")
    public Doctor getDoctorById(@PathVariable Integer id){
        return this.adminService.getDocotrById(id);
    }
    @GetMapping("Doctor")
    public List<Doctor> viewAllDoctor(){
        return this.adminService.getallDoctors();
    }


}