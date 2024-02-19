package com.questionmark.doctorappointment.appointment.entity;

import com.questionmark.doctorappointment.payment.entity.Payment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Calendar;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Integer id;
    private Calendar timing;
    private Boolean status;
    public Appointment(Integer id, Calendar timing, Boolean status, Payment payment) {
        this.id = id;
        this.timing = timing;
        this.status = status;
        this.payment = payment;
    }
    public Appointment(Integer id, Calendar timing, Boolean status) {
        this.id = id;
        this.timing = timing;
        this.status = status;
        this.payment = new Payment();
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

    public Calendar getTiming() {
        return timing;
    }

    public void setTiming(Calendar timing) {
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
