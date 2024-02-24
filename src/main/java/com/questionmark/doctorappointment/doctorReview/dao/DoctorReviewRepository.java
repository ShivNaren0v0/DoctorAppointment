package com.questionmark.doctorappointment.doctorReview.dao;

import com.questionmark.doctorappointment.doctorReview.entity.DoctorReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorReviewRepository extends JpaRepository<DoctorReview,Integer> {
}
