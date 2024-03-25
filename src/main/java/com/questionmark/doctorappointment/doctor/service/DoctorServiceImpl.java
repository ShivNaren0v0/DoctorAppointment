package com.questionmark.doctorappointment.doctor.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.doctor.exceptions.DoctorExceptions;
import com.questionmark.doctorappointment.doctor.dto.LoginDTo;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.exceptions.PatientExceptions;
import com.questionmark.doctorappointment.payment.dao.PaymentRepository;
import com.questionmark.doctorappointment.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.questionmark.doctorappointment.appointment.entity.Appointment;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, PaymentRepository paymentRepository){
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Appointment cancelAppointment(Integer appointmentId) throws DoctorExceptions{

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
            this.appointmentRepository.delete(appointment);
        }

        return appointment;
    }


    @Override
    public Appointment confirmAppointment(Integer appointmentId, Double amount) throws DoctorExceptions{
        Optional<Appointment> appointmentOptional =  this.appointmentRepository.findById(appointmentId);
        if (appointmentOptional.isEmpty()){

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
    public List<Appointment> getAllAppointmentOfDoctor(Integer doctorId) throws DoctorExceptions {
        Optional<Doctor> optionalDoctor = this.doctorRepository.findById(doctorId);
        if(optionalDoctor.isEmpty()){
            throw new DoctorExceptions("Doctor not found. Please try again");
        }
        return optionalDoctor.get().getAppointmentList();
    }

    @Override
    public Doctor login(LoginDTo loginDTo) throws DoctorExceptions {
        Optional<Doctor> doctorOptional = Optional.ofNullable(this.doctorRepository.findByName(loginDTo.getName()));
        if(doctorOptional.isEmpty())
                throw new DoctorExceptions("Account does not exists for :"+loginDTo.getName());

        Doctor doctorAccount = doctorOptional.get();

        if(doctorAccount.getSpec().trim().equals(loginDTo.getSpec().trim()))
            return doctorAccount;
        else
            throw new DoctorExceptions("Spec does not match");
    }



}
