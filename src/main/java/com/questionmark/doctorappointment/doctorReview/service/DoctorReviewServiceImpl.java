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
    @Override
    public DoctorReview createReview(DoctorReview review, int doctorId, int patientId) {
        Optional<Doctor> doctorOptional = this.doctorRepository.findById(doctorId);
        Optional<Patient> patientOptional = this.patientRepository.findById(patientId);
        Doctor doctor=doctorOptional.get();
        Patient patient=patientOptional.get();
        review.setDoctor(doctor);
        review.setPatient(patient);

        return doctorReviewRepository.save(review);
    }
}
