package com.questionmark.doctorappointment.payment.service;

import com.questionmark.doctorappointment.payment.dao.PaymentRepository;
import com.questionmark.doctorappointment.payment.entity.Payment;
import com.questionmark.doctorappointment.payment.exceptions.PaymentException;
import com.questionmark.doctorappointment.refund.dao.RefundRepository;
import com.questionmark.doctorappointment.refund.entity.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private RefundRepository refundRepository;

    @Override
    public Payment getPaymentByPaymentId(Integer id) throws PaymentException {
        Optional<Payment> paymentOptional=this.paymentRepository.findById(id);
        if(paymentOptional.isEmpty()){
            throw new PaymentException("Payment with given id not found");
        }
        return paymentOptional.get();
    }

    @Override
    public Payment createPayment(Payment payment) throws PaymentException {
        payment.setSuccessful(true);
        payment.setCancelled(false);
        payment.setRefund(null);
        return this.paymentRepository.save(payment);
    }

    @Override
    public Payment updatePaymentCancellation(Integer id) throws PaymentException {
        Optional<Payment> paymentOpt= this.paymentRepository.findById(id);
        if(paymentOpt.isEmpty()){
            throw new PaymentException("Payment with given id not found");
        }
        Payment payment=paymentOpt.get();
        payment.setCancelled(true);
        Double amount=payment.getAmount();
        payment.setRefund(new Refund("In Progress",amount));
        Refund refund=payment.getRefund();
        this.refundRepository.save(refund);
        return this.paymentRepository.save(payment);
    }
}
