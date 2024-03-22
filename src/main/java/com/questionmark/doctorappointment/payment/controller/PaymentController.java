package com.questionmark.doctorappointment.payment.controller;

import com.questionmark.doctorappointment.payment.entity.Payment;
import com.questionmark.doctorappointment.payment.exceptions.PaymentException;
import com.questionmark.doctorappointment.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4200/")
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("payment/{id}")
    public Payment getPaymentById(@PathVariable ("id") Integer paymentId )throws PaymentException{
        Payment payment=null;
        try{
            payment=this.paymentService.getPaymentByPaymentId(paymentId);
        }
        catch (PaymentException e){
            e.printStackTrace();
        }
        return payment;
    }
    @PostMapping("payment")
    public Payment createPayment(@RequestBody Payment payment)throws PaymentException{
        payment.setCancelled(false);
        return this.paymentService.createPayment(payment);
    }
    @DeleteMapping("payment/{id}")
    public Payment deletePayment(@PathVariable ("id") Integer paymentId) throws PaymentException{
        Payment payment=null;
        try{
            payment=this.paymentService.deletePaymentById(paymentId);
        }
        catch (PaymentException e){
            e.printStackTrace();
        }
        return payment;
    }
    @PatchMapping("cancelled/{id}")
    public Payment cancelledPayment(@PathVariable ("id") Integer paymentId)throws PaymentException{
        Payment payment=null;
        try{
            payment=this.paymentService.updatePaymentCancellation(paymentId);
        }
        catch (PaymentException e){
            e.printStackTrace();
        }
        return payment;
    }
}
