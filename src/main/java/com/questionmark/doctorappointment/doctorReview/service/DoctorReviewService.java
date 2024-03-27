package com.questionmark.doctorappointment.doctorReview.service;

import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.doctorReview.entity.DoctorReview;

import java.util.List;

public interface DoctorReviewService {
    DoctorReview createReview(DoctorReview doctorReview,int doctorId, int patientId, int appointment_ID);
    List<DoctorReview> getallReviews();
    DoctorReview updateReview(DoctorReview doctorReview,int doctorId, int patientId, int appointment_ID);
}
