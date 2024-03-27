package com.questionmark.doctorappointment.doctorReview.controller;
import com.questionmark.doctorappointment.doctorReview.dto.CreateDTO;
import com.questionmark.doctorappointment.doctorReview.entity.DoctorReview;
import com.questionmark.doctorappointment.doctorReview.service.DoctorReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
public class DoctorReviewController {
    @Autowired
    private DoctorReviewService doctorReviewService;
    @PostMapping("AddDoctorReview/{appointment_ID}")
    public DoctorReview addNewReview(@RequestBody CreateDTO createDTO, @PathVariable Integer appointment_ID){
        return this.doctorReviewService.createReview(createDTO.getDoctorReview(), createDTO.getDoctor_ID(), createDTO.getPatient_ID(),appointment_ID);
    }
    @PostMapping("UpdateDoctorReview/{appointment_ID}")
    public DoctorReview updateReview(@RequestBody CreateDTO createDTO,@PathVariable Integer appointment_ID){
        return this.doctorReviewService.updateReview(createDTO.getDoctorReview(), createDTO.getDoctor_ID(), createDTO.getPatient_ID(),appointment_ID);
    }
    @GetMapping("review")
    public List<DoctorReview> getallReviews(){
        return this.doctorReviewService.getallReviews();
    }

}
