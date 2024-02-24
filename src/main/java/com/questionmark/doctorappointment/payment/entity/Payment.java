package com.questionmark.doctorappointment.payment.entity;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.refund.entity.Refund;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer paymentId;
    private LocalDate paymentDate;
    private Double amount;
    private Boolean successful;

    @Value(value = "false")
    private Boolean cancelled;
    private String paymentMethod;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Payment(Integer paymentId, LocalDate paymentDate, Double amount, Boolean successful, Boolean cancelled, String paymentMethod, Refund refund) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.successful = successful;
        this.cancelled = cancelled;
        this.paymentMethod = paymentMethod;
        this.refund = refund;
    }

    public Payment(Integer paymentId, LocalDate paymentDate, Double amount, Boolean successful, Boolean cancelled, String paymentMethod) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.successful = successful;
        this.cancelled = cancelled;
        this.paymentMethod = paymentMethod;
    }

    @OneToOne
    private Refund refund;
    public Payment(Integer paymentId, LocalDate paymentDate, Double amount, Boolean successful, Boolean cancelled) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.successful = successful;
        this.cancelled = cancelled;
    }

    public Refund getRefund() {
        return refund;
    }

    public void setRefund(Refund refund) {
        this.refund = refund;
    }

    public Payment(Integer paymentId, LocalDate paymentDate, Double amount, Boolean successful, Boolean cancelled, Refund refund) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.successful = successful;
        this.cancelled = cancelled;
        this.refund = refund;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Payment() {
        super();
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public Payment(Integer paymentId, LocalDate paymentDate, Double amount, Boolean successful) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.successful = successful;

    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }






}
