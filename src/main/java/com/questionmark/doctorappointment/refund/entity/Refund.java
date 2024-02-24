package com.questionmark.doctorappointment.refund.entity;

import com.questionmark.doctorappointment.payment.entity.Payment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Refund {
    @GeneratedValue
    @Id
    private Integer id;
    private String refund_status;
    private Double refund_amount;
//    @OneToOne
//    Payment payment;

//    public Payment getPayment() {
//        return payment;
//    }
//
//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }

    public Refund(Integer id, String refund_status, Double refund_amount, Payment payment) {
        this.id = id;
        this.refund_status = refund_status;
        this.refund_amount = refund_amount;
//        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public Double getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(Double refund_amount) {
        this.refund_amount = refund_amount;
    }

    public Refund() {
    }

    public Refund(Integer id, String refund_status, Double refund_amount) {
        this.id = id;
        this.refund_status = refund_status;
        this.refund_amount = refund_amount;
    }
}
