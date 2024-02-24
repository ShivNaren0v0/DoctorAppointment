package com.questionmark.doctorappointment.doctorReview.controller;

import com.questionmark.doctorappointment.doctorReview.dto.CreateDTO;
import com.questionmark.doctorappointment.doctorReview.entity.DoctorReview;
import com.questionmark.doctorappointment.doctorReview.service.DoctorReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorReviewController {
    @Autowired
    private DoctorReviewService doctorReviewService;
    @PostMapping("DoctorReview/{doc_id}")
    public DoctorReview addNewReview(@RequestBody CreateDTO createDTO, @PathVariable Integer doc_id){
        return this.doctorReviewService.createReview(createDTO.getDoctorReview(),doc_id, createDTO.getPatient_ID());
    }
}
