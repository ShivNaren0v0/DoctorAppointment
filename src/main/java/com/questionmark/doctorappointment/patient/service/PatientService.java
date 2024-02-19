package com.questionmark.doctorappointment.patient.service;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    Patient getPatientById(Integer patientId);
    Patient addAppointmentToPatient(Integer patientId, Appointment appointment);

    List<Appointment> getAllAppointmentOfPatient(Integer patientId);
    List<Patient> getAllPatient();

    List<Doctor> getDoctorsBySpec(String spec);
}
