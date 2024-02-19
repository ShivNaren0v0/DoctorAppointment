package com.questionmark.doctorappointment.admin.service;

import com.questionmark.doctorappointment.doctor.entity.Doctor;
import java.util.List;
import com.questionmark.doctorappointment.patient.entity.Patient;

public interface AdminService {

    Doctor addDoctor(Doctor product);
    List<Doctor> removeDoctorById(Integer doctorID);

    Doctor getDocotrById(Integer doctorID);
    List<Doctor> getallDoctors();
    Patient removePatient(Patient patient);

}
