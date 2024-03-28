package com.questionmark.doctorappointment.refund.controller;

import com.questionmark.doctorappointment.payment.entity.Payment;
import com.questionmark.doctorappointment.refund.entity.Refund;
import com.questionmark.doctorappointment.refund.exceptions.RefundException;
import com.questionmark.doctorappointment.refund.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RefundController {
    @Autowired
    RefundService refundService;

    @PostMapping("refund")
    public Refund createRefund(@RequestBody Refund refund) throws RefundException {
        return this.refundService.createRefund(refund);
    }

    @GetMapping("refund/{id}")
    public Refund getRefundById(@PathVariable ("id") Integer refundId) throws RefundException{
        return this.refundService.getRefundById(refundId);
    }

    @PatchMapping("refund/updateStatus/{id}")
    public Refund updateRefundStatus(@PathVariable("id") Integer refundId) throws RefundException{
        return this.refundService.updateRefundStatus(refundId);
    }
}
