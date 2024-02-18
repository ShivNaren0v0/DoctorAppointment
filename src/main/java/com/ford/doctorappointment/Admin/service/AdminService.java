package com.ford.doctorappointment.Admin.service;

import com.ford.doctorappointment.Doctor.entity.Doctor;
import com.ford.doctorappointment.Patient.entity.Patient;

public interface AdminService {
    Doctor addDoctor(Doctor product);
    Doctor removeDoctor(Doctor doctor);
    Patient removePatient(Patient patient);
}
