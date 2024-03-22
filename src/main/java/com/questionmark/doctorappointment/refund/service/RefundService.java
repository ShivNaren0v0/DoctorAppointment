package com.questionmark.doctorappointment.refund.service;

import com.questionmark.doctorappointment.refund.entity.Refund;
import com.questionmark.doctorappointment.refund.exceptions.RefundException;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface RefundService {
    public Refund createRefund(Refund refund) throws RefundException;
    public Refund getRefundById(Integer refundId)throws RefundException;
    public  Refund updateRefundStatus(Integer refundId) throws RefundException;
}
