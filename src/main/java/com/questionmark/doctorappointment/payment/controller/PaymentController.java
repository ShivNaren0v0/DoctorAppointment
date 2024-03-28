package com.questionmark.doctorappointment.payment.controller;

import com.questionmark.doctorappointment.payment.entity.Payment;
import com.questionmark.doctorappointment.payment.exceptions.PaymentException;
import com.questionmark.doctorappointment.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("payment/{id}")
    public Payment getPaymentById(@PathVariable ("id") Integer paymentId)throws PaymentException{
        return paymentService.getPaymentByPaymentId(paymentId);
    }
    @PostMapping("payment")
    public Payment createPayment(@RequestBody Payment payment)throws PaymentException{
        payment.setCancelled(false);
        payment.setRefund(null);
        return this.paymentService.createPayment(payment);
    }
    @PatchMapping("payment/cancelled/{id}")
    public Payment cancelledPayment(@PathVariable ("id") Integer paymentId)throws PaymentException{
        return paymentService.updatePaymentCancellation(paymentId);

    }
}
