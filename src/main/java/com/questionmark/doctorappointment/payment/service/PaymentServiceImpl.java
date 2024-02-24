package com.questionmark.doctorappointment.payment.service;

import com.questionmark.doctorappointment.payment.dao.PaymentRepository;
import com.questionmark.doctorappointment.payment.entity.Payment;
import com.questionmark.doctorappointment.payment.exceptions.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Payment getPaymentByPaymentId(Integer id) throws PaymentException {
        Payment payment = this.paymentRepository.getPaymentByPaymentId(id);
        if(payment==null){
            throw new PaymentException("Payment with given id not found");
        }
        return payment;
    }

    @Override
    public Payment createPayment(Payment payment) throws PaymentException {
        return this.paymentRepository.save(payment);
    }

    @Override
    public Payment deletePaymentById(Integer id) throws PaymentException {
        Payment payment=this.paymentRepository.getPaymentByPaymentId(id);
        if(payment==null){
            throw new PaymentException("Payment with given id not found");
        }
        this.paymentRepository.deleteById(id);
        return payment;
    }

    @Override
    public Payment updatePaymentCancellation(Integer id) throws PaymentException {
        Optional<Payment> paymentOpt= this.paymentRepository.findById(id);
        if(paymentOpt.isEmpty()){
            throw new PaymentException("Payment with given id not found");
        }
        Payment payment=paymentOpt.get();
        payment.setCancelled(true);
        return this.paymentRepository.save(payment);
    }
}
