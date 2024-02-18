package com.ford.doctorappointment.Patient.service;


import com.ford.doctorappointment.Appointment.dao.AppointmentRepository;
import com.ford.doctorappointment.Appointment.entity.Appointment;
import com.ford.doctorappointment.Doctor.dao.DoctorRepository;
import com.ford.doctorappointment.Doctor.entity.Doctor;
import com.ford.doctorappointment.Patient.dao.PatientRepository;
import com.ford.doctorappointment.Patient.entity.Patient;
import com.ford.doctorappointment.Payment.entity.Payment;
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
            };
        }
        return specDoctors;
    }

    @Override
    public Patient addAppointmentToPatient(Integer patientId, Appointment appointment) {
        Appointment newAppointment = new Appointment(appointment.getId(),appointment.getTiming(),appointment.getStatus(),new Payment());
        Optional<Patient> PatientOpt = this.patientRepository.findById(patientId);

        Patient patient = PatientOpt.get();
        if(patient.getAppointments()==null){
            patient.setAppointments(new ArrayList<Appointment>());
        }

        patient.getAppointments().add(appointment);
        this.appointmentRepository.save(newAppointment);
        patient.getAppointments().add(appointment);
        return this.patientRepository.save(patient);
    }

    @Override
    public List<Appointment> getAllAppointmentOfPatient(Integer patientId) {
        Optional<Patient> optionalPatient = this.patientRepository.findById(patientId);
        return optionalPatient.get().getAppointments();
    }





}
