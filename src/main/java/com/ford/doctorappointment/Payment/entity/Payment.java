package com.ford.doctorappointment.Payment.entity;
import com.ford.doctorappointment.Appointment.entity.Appointment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Payment {
    public Payment() {
        super();
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public Payment(Integer paymentId, LocalDate paymentDate, Double amount, Boolean successful, Appointment appointment) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.successful = successful;
        this.appointment = appointment;
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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Id
    @GeneratedValue
    private Integer paymentId;
    private LocalDate paymentDate;
    private Double amount;
    private Boolean successful;

    @OneToOne
    private Appointment appointment;


}
