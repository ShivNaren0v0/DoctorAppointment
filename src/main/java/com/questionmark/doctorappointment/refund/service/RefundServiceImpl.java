package com.questionmark.doctorappointment.refund.service;

import com.questionmark.doctorappointment.refund.dao.RefundRepository;
import com.questionmark.doctorappointment.refund.entity.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundServiceImpl implements  RefundService {
    @Autowired
    RefundRepository refundRepository;
    @Override
    public Refund createRefund(Refund refund) {
        return this.refundRepository.save(refund);
    }
}
