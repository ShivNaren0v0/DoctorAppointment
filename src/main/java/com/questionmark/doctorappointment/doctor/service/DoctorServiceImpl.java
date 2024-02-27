package com.questionmark.doctorappointment.doctor.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.doctor.exceptions.DoctorExceptions;
import com.questionmark.doctorappointment.payment.dao.PaymentRepository;
import com.questionmark.doctorappointment.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.questionmark.doctorappointment.appointment.entity.Appointment;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Integer cancelAppointment(Integer appointmentId) throws DoctorExceptions{

        Optional<Appointment> appointmentOptional = this.appointmentRepository.findById(appointmentId);
        if(appointmentOptional.isEmpty()){
            throw new DoctorExceptions("Appointment does not exist.");
        }



        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(false);
        Payment payment = appointment.getPayment();
        if (payment != null) {
            payment.setCancelled(true);
            payment.setSuccessful(false);
            this.appointmentRepository.save(appointment);
            this.paymentRepository.save(payment);
        }
        else{
            this.appointmentRepository.save(appointment);
        }

        return appointmentId;
    }


    @Override
    public Appointment confirmAppointment(Integer appointmentId, Double amount) throws DoctorExceptions{
        Optional<Appointment> appointmentOptional =  this.appointmentRepository.findById(appointmentId);
        if (appointmentOptional.get() == null){

            throw new DoctorExceptions("Appointment is not available");
        }

        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(true);
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setSuccessful(false);
        payment.setCancelled(false);
        appointment.setPayment(payment);
        this.paymentRepository.save(payment);
        this.appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointmentOfDoctor(Integer doctorId) {
        Optional<Doctor> optionalDoctor = this.doctorRepository.findById(doctorId);

        return optionalDoctor.get().getAppointmentList();
    }


}
