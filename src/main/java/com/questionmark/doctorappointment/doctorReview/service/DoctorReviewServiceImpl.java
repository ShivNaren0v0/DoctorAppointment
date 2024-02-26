package com.questionmark.doctorappointment.doctorReview.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.doctorReview.dao.DoctorReviewRepository;
import com.questionmark.doctorappointment.doctorReview.entity.DoctorReview;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import com.questionmark.doctorappointment.patient.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorReviewServiceImpl implements DoctorReviewService{
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorReviewRepository doctorReviewRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public DoctorReview createReview(DoctorReview doctorReview, int doctorId, int patientId,int appointment_ID) {
        Optional<Doctor> doctorOptional = this.doctorRepository.findById(doctorId);
        Optional<Patient> patientOptional = this.patientRepository.findById(patientId);
        Optional<Appointment> appointmentOptional = this.appointmentRepository.findById(appointment_ID);
        Doctor doctor=doctorOptional.get();
        Patient patient=patientOptional.get();
        Appointment appointment=appointmentOptional.get();

        doctorReview.setDoctor(doctor);
        doctorReview.setPatient(patient);

        return doctorReviewRepository.save(doctorReview);
    }

    @Override
    public DoctorReview updateReview(DoctorReview doctorReview, int doctorId, int patientId, int appointment_ID) {
        Optional<Doctor> doctorOptional = this.doctorRepository.findById(doctorId);
        Optional<Patient> patientOptional = this.patientRepository.findById(patientId);
        Optional<Appointment> appointmentOptional = this.appointmentRepository.findById(appointment_ID);
        Doctor doctor=doctorOptional.get();
        Patient patient=patientOptional.get();
        Appointment appointment=appointmentOptional.get();

        return doctorReviewRepository.save(doctorReview);
    }
}
