package com.ford.doctorappointment.Payment.dao;

import com.ford.doctorappointment.Payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
