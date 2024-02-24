package com.questionmark.doctorappointment.payment.dao;

import com.questionmark.doctorappointment.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment getPaymentByPaymentId(Integer id);
}
