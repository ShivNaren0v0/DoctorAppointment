package com.questionmark.doctorappointment.patient.service;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.exceptions.PatientExceptions;
import com.questionmark.doctorappointment.payment.entity.Payment;
import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);

    Patient getPatientById(Integer patientId) throws PatientExceptions;
    List<Appointment> getAllAppointmentOfPatient(Integer patientId);
    List<Patient> getAllPatient();
    Payment performPaymentForAppointment(String method,Integer appointmentId) throws PatientExceptions;
    List<Doctor> getDoctorsBySpec(String spec);
}
