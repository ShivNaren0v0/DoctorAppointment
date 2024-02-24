package com.questionmark.doctorappointment.appointment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.payment.entity.Payment;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer patientId;


    private Integer doctorId;
    private String description;
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime timing;
    @OneToOne
    private Payment payment;
    private Boolean status;

    public Appointment() {
    }

    public Appointment(Integer id, Integer patientId, Integer doctorId, LocalDate date, LocalTime timing, String description, Boolean status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.timing = timing;
        this.payment = null;
        this.status = status;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTiming() {
        return timing;
    }

    public void setTiming(LocalTime timing) {
        this.timing = timing;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
