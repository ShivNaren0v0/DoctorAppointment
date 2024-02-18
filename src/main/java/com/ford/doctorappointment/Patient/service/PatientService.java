package com.ford.doctorappointment.Patient.service;

import com.ford.doctorappointment.Appointment.entity.Appointment;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import com.ford.doctorappointment.Patient.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    Patient getPatientById(Integer patientId);
    Patient addAppointmentToPatient(Integer patientId, Appointment appointment);

    List<Appointment> getAllAppointmentOfPatient(Integer patientId);
    List<Patient> getAllPatient();

    List<Doctor> getDoctorsBySpec(String spec);
}
