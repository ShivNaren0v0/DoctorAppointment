package com.questionmark.doctorappointment.patient.service;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.dto.LoginDTO;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.exceptions.PatientExceptions;
import com.questionmark.doctorappointment.payment.entity.Payment;
import java.util.List;
/**
 * <h3>Patient Service</h3>
 * Interface for Patient to access services
 *
 * @author  Thanush A A
 * @version 1.0
 * @since   2024-02-16
 */
public interface PatientService{
    Patient addPatient(Patient patient) throws PatientExceptions;

    Patient getPatientById(Integer patientId) throws PatientExceptions;
    List<Appointment> getAllAppointmentOfPatient(Integer patientId) throws PatientExceptions;
    List<Patient> getAllPatient();
    Payment performPaymentForAppointment(String method,Integer appointmentId) throws PatientExceptions;
    List<Doctor> getDoctorsBySpec(String spec);
    String getStatusofAppointment(Integer patientId,Integer appointmentId);

    Patient login(LoginDTO loginDTO) throws PatientExceptions;
}
