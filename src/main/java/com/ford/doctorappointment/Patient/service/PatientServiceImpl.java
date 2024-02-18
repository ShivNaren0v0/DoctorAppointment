package com.ford.doctorappointment.Patient.service;


import com.ford.doctorappointment.Appointment.dao.AppointmentRepository;
import com.ford.doctorappointment.Appointment.entity.Appointment;
import com.ford.doctorappointment.Patient.dao.PatientRepository;
import com.ford.doctorappointment.Patient.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    private AppointmentRepository appointmentRepository;

    @Override
    public Patient addPatient(Patient patient) {
        patient.setAppointments(null);
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
    public Patient addAppointmentToPatient(Integer patientId, Appointment appointment) {

        Optional<Patient> PatientOpt = this.patientRepository.findById(patientId);

        Patient patient = PatientOpt.get();
        patient.getAppointments().add(appointment);
        this.appointmentRepository.save(appointment);
        patient.getAppointments().add(appointment);
        this.patientRepository.save(patient);

        return patient;
    }

    @Override
    public List<Appointment> getAllAppointmentOfPatient(Integer patientId) {
        Optional<Patient> optionalPatient = this.patientRepository.findById(patientId);
        Patient patient = optionalPatient.get();
        return patient.getAppointments();
    }

}
