package com.questionmark.doctorappointment.refund.controller;

import com.questionmark.doctorappointment.payment.entity.Payment;
import com.questionmark.doctorappointment.refund.entity.Refund;
import com.questionmark.doctorappointment.refund.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefundController {
    @Autowired
    RefundService refundService;

    @PostMapping("refund")
    public Refund createRefund(@RequestBody Refund refund){
        return this.refundService.createRefund(refund);
    }
}
