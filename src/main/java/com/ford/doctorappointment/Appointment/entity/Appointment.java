package com.ford.doctorappointment.Appointment.entity;

import com.ford.doctorappointment.Payment.entity.Payment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate timing;
    private Boolean status;

    public Appointment(Integer id, LocalDate timing, Boolean status, Payment payment) {
        this.id = id;
        this.timing = timing;
        this.status = status;
        this.payment = payment;
    }

    @OneToOne
    private Payment payment;


    public Appointment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getTiming() {
        return timing;
    }

    public void setTiming(LocalDate timing) {
        this.timing = timing;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
