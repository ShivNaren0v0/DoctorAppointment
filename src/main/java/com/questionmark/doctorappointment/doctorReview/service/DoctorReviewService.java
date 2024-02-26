package com.questionmark.doctorappointment.doctorReview.service;

import com.questionmark.doctorappointment.doctorReview.entity.DoctorReview;

public interface DoctorReviewService {
    DoctorReview createReview(DoctorReview doctorReview,int doctorId, int patientId, int appointment_ID);
    DoctorReview updateReview(DoctorReview doctorReview,int doctorId, int patientId, int appointment_ID);
}
