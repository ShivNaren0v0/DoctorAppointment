package com.questionmark.doctorappointment.doctorReview.dto;

import com.questionmark.doctorappointment.doctorReview.entity.DoctorReview;

public class CreateDTO {
    private DoctorReview doctorReview;
    private Integer patient_ID;
    private Integer doctor_ID;

    public DoctorReview getDoctorReview() {
        return doctorReview;
    }

    public void setDoctorReview(DoctorReview doctorReview) {
        this.doctorReview = doctorReview;
    }

    public Integer getPatient_ID() {
        return patient_ID;
    }

    public void setPatient_ID(Integer patient_ID) {
        this.patient_ID = patient_ID;
    }

    public Integer getDoctor_ID() {
        return doctor_ID;
    }

    public void setDoctor_ID(Integer doctor_ID) {
        this.doctor_ID = doctor_ID;
    }
}
