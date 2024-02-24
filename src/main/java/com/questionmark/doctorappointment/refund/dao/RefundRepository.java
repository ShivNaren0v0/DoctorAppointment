package com.questionmark.doctorappointment.refund.dao;

import com.questionmark.doctorappointment.refund.entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepository extends JpaRepository<Refund,Integer> {
}
