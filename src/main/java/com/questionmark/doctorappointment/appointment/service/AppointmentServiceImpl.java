package com.questionmark.doctorappointment.appointment.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.doctor.service.DoctorServiceImpl;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import com.questionmark.doctorappointment.patient.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorServiceImpl doctorServiceImpl;

    @Override
    public Appointment createAppointment(Appointment newAppointment) throws AppointmentExceptions {
        Doctor doctor = this.doctorRepository.findById(newAppointment.getDoctorId())
                .orElseThrow(() -> new AppointmentExceptions("Doctor with ID does not exist"));

        List<Appointment> temp = doctor.getAppointmentList();
        temp.add(newAppointment);
        doctor.setAppointmentList(temp);

        Patient patient = this.patientRepository.findById(newAppointment.getPatientId())
                .orElseThrow(() -> new AppointmentExceptions("Doctor with ID does not exist"));

        List<Appointment> temp2 = patient.getAppointments();
        temp2.add(newAppointment);
        doctor.setAppointmentList(temp);

        boolean doctorUnavailable = appointmentRepository.existsByDoctorIdAndDateAndTiming(
                newAppointment.getDoctorId(), newAppointment.getDate(), newAppointment.getTiming());
        if (doctorUnavailable) {
            throw new AppointmentExceptions("The doctor is not available at the specified date and time.");
        }
        boolean patientUnavailable = appointmentRepository.existsByPatientIdAndDateAndTiming(
                newAppointment.getPatientId(), newAppointment.getDate(), newAppointment.getTiming());
        if (patientUnavailable) {
            throw new AppointmentExceptions("The patient already has an appointment at the specified date and time.");
        }
        this.appointmentRepository.save(newAppointment);
        this.doctorRepository.save(doctor);
        this.patientRepository.save(patient);
        return newAppointment;
    }

    @Override
    public Appointment getAppointmentById(Integer id) throws AppointmentExceptions {
        Optional<Appointment> appointmentOpt = this.appointmentRepository.findById(id);
        if (appointmentOpt.isEmpty())
            throw new AppointmentExceptions("Appointment doesn't exists:" + id);
        return appointmentOpt.get();
    }

    @Override
    public ResponseEntity<String> deleteAppointmentById(Integer id) throws AppointmentExceptions {
        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentExceptions("Appointment not found with id: " + id));

        // Retrieve patientId and doctorId
        Integer patientId = appointment.getPatientId();
        Integer doctorId = appointment.getDoctorId();

        // Delete appointment from doctor's list (if applicable)
        if (doctorId != null) {
            Doctor doctor = this.doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new AppointmentExceptions("Doctor not found with id: " + doctorId));
            doctor.getAppointmentList().remove(appointment);
            this.doctorRepository.save(doctor);
        }

        // Delete appointment from patient's list (if applicable)
        if (patientId != null) {
            Patient patient = this.patientRepository.findById(patientId)
                    .orElseThrow(() -> new AppointmentExceptions("Patient not found with id: " + patientId));
            patient.getAppointments().remove(appointment);
            this.patientRepository.save(patient);
        }

        // Finally, delete the appointment
        this.appointmentRepository.delete(appointment);

        return ResponseEntity.ok("Appointment deleted successfully.");
    }


    @Override
    public List<Appointment> getAllAppointments() throws AppointmentExceptions
    {
        long accountOpt=this.appointmentRepository.count();
        if(accountOpt<1)
            throw new AppointmentExceptions("Appointments not available");
        return this.appointmentRepository.findAll();
    }

    @Override
    public Appointment changeAppointmentByDate(Integer id, LocalDate newDate) throws AppointmentExceptions
    {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentExceptions("Appointment doesn't exist for this ID: " + id));
        boolean exists = appointmentRepository.existsByDoctorIdAndDateAndTiming(appointment.getDoctorId(), newDate, appointment.getTiming());
        if (exists) {
            throw new AppointmentExceptions("Another appointment already exists with the same date and timing for this doctor.");
        }
        appointment.setDate(newDate);
        return this.appointmentRepository.save(appointment);
    }
    @Override
    public Appointment changeAppointmentByTiming(Integer id, LocalTime newTiming) throws AppointmentExceptions {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentExceptions("Appointment doesn't exist for this ID: " + id));
        boolean exists = appointmentRepository.existsByDoctorIdAndDateAndTiming(appointment.getDoctorId(), appointment.getDate(), newTiming);
        if (exists) {
            throw new AppointmentExceptions("Another appointment already exists with the same date and timing for this doctor.");
        }
        appointment.setTiming(newTiming);
        return this.appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAllAppointment() throws AppointmentExceptions {
        List<Appointment> appointmentOpt=this.appointmentRepository.findAll();
        if(appointmentOpt.isEmpty())
            throw new AppointmentExceptions("There is no appointments");
        else {

            this.appointmentRepository.deleteAll();
        }

    }


}