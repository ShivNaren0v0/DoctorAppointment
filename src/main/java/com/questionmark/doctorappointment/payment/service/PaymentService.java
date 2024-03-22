package com.questionmark.doctorappointment.payment.service;

import com.questionmark.doctorappointment.payment.entity.Payment;
import com.questionmark.doctorappointment.payment.exceptions.PaymentException;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Optional;

public interface PaymentService {
    public Payment getPaymentByPaymentId(Integer id) throws PaymentException;
    public Payment createPayment(Payment payment) throws PaymentException;
    public Payment updatePaymentCancellation(Integer id) throws PaymentException;
}
