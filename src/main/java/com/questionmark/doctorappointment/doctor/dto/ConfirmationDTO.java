package com.questionmark.doctorappointment.doctor.dto;

public class ConfirmationDTO {
    private Integer appointmentId;
    private Double amount;


    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
