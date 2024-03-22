package com.questionmark.doctorappointment.refund.service;

import com.questionmark.doctorappointment.refund.dao.RefundRepository;
import com.questionmark.doctorappointment.refund.entity.Refund;
import com.questionmark.doctorappointment.refund.exceptions.RefundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RefundServiceImpl implements  RefundService {
    @Autowired
    RefundRepository refundRepository;
    @Override
    public Refund createRefund(Refund refund) throws RefundException{
        refund.setRefund_status("In progress");
        return this.refundRepository.save(refund);
    }

    @Override
    public Refund getRefundById(Integer refundId) throws RefundException {
        Optional<Refund> optionalRefund=this.refundRepository.findById(refundId);
        if(optionalRefund.isEmpty()){
            throw  new RefundException("No Refund Exists");
        }
        return optionalRefund.get();
    }

    @Override
    public Refund updateRefundStatus(Integer refundId) throws RefundException{
        Optional<Refund> optionalRefund=this.refundRepository.findById(refundId);
        if(optionalRefund.isEmpty()){
            throw  new RefundException("No Refund Exists");
        }
        Refund refund=optionalRefund.get();
        refund.setRefund_status("Completed");
        return this.refundRepository.save(refund);
    }

}
