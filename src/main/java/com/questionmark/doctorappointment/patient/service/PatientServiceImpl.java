package com.questionmark.doctorappointment.patient.service;


import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import com.questionmark.doctorappointment.patient.dto.LoginDTO;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.patient.exceptions.PatientExceptions;
import com.questionmark.doctorappointment.payment.dao.PaymentRepository;
import com.questionmark.doctorappointment.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PaymentRepository paymentRepository){
        this.patientRepository=patientRepository;
        this.appointmentRepository=appointmentRepository;
        this.doctorRepository=doctorRepository;
        this.paymentRepository=paymentRepository;
    }

    @Override
    public Patient addPatient(Patient patient) throws PatientExceptions{
        if (patient == null){
            throw new PatientExceptions("Patient cannot be null");
        }
        patient.setAppointments(new ArrayList<>());
        return this.patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Integer patientId) throws PatientExceptions {
        Optional<Patient> optionalPatient = this.patientRepository.findById(patientId);
        if (optionalPatient.isEmpty()){
            throw new PatientExceptions("Patient not found");
        }
        return optionalPatient.get();
    }

    public List<Patient> getAllPatient(){

        return this.patientRepository.findAll();
    }

    @Override
    public Payment performPaymentForAppointment(String method, Integer appointmentId) throws PatientExceptions {
        Optional<Appointment> appointmentOptional = this.appointmentRepository.findById(appointmentId);
        if (appointmentOptional.isEmpty()){
            throw new PatientExceptions("Appointment not found");
        }
        Appointment appointment = appointmentOptional.get();
        Payment payment = appointment.getPayment();
        payment.setSuccessful(true);
        payment.setCancelled(false);
        payment.setPaymentMethod(method);
        payment.setPaymentDate(LocalDate.now());
        appointment.setPayment(payment);

        this.appointmentRepository.save(appointment);
        return this.paymentRepository.save(payment);
    }

    @Override
    public List<Doctor> getDoctorsBySpec(String spec) {
        ArrayList<Doctor> doctorList = (ArrayList<Doctor>) this.doctorRepository.findAll();

        List<Doctor> specDoctors = new ArrayList<>();
        for(Doctor d: doctorList){
            if (Objects.equals(d.getSpec(), spec)) {
                specDoctors.add(d);
            }
        }
        return specDoctors;
    }

    @Override
    public String getStatusofAppointment(Integer patientId, Integer appointmentId){
        Optional<Appointment> appointmentOptional = this.appointmentRepository.findById(appointmentId);
        if (appointmentOptional.isEmpty()){
            return("Appointment not found / Appointment cancelled by doctor");
        }

        if(appointmentOptional.get().getStatus()!=null)
            return("Appointment got accepted");
        else
            return("Appointment in process");
    }

    @Override
    public List<Appointment> getAllAppointmentOfPatient(Integer patientId) throws PatientExceptions{
        Optional<Patient> optionalPatient = this.patientRepository.findById(patientId);
        if (optionalPatient.isEmpty()){
            throw new PatientExceptions("Patient is not available");
        }
        Patient patient = optionalPatient.get();
        return patient.getAppointments();
    }

    @Override
    public Patient login(LoginDTO loginDTO)throws PatientExceptions {
        Optional<Patient> patientOptional = Optional.ofNullable(this.patientRepository.findByEmail(loginDTO.getEmail()));
        if(patientOptional.isEmpty())
            throw new PatientExceptions("Account does not exists for :"+loginDTO.getEmail());

        Patient patientAccount = patientOptional.get();

        if(patientAccount.getPassword().trim().equals(loginDTO.getPassword().trim()))
            return patientAccount;
        else
            throw new PatientExceptions("Password does not match");
    }
}