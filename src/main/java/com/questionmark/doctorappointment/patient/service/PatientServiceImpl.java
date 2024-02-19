package com.questionmark.doctorappointment.patient.service;


import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Patient addPatient(Patient patient) {
        patient.setAppointments(new ArrayList<Appointment>());
        return this.patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Integer patientId) {
        Optional<Patient> optionalPatient = this.patientRepository.findById(patientId);

        return optionalPatient.get();
    }

    public List<Patient> getAllPatient(){
        return this.patientRepository.findAll();
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
    public Patient addAppointmentToPatient(Integer patientId, Appointment appointment) {
        Optional<Patient> PatientOpt = this.patientRepository.findById(patientId);

        Patient patient = PatientOpt.get();
        if(patient.getAppointments()==null){
            patient.setAppointments(new ArrayList<Appointment>());
        }
        List<Appointment> appointments = patient.getAppointments();
        appointments.add(appointment);
        patient.setAppointments(appointments);

        this.appointmentRepository.save(appointment);
        return this.patientRepository.save(patient);

    }

    @Override
    public List<Appointment> getAllAppointmentOfPatient(Integer patientId) {
        Optional<Patient> optionalPatient = this.patientRepository.findById(patientId);
        return optionalPatient.get().getAppointments();
    }





}
