package com.questionmark.doctorappointment.appointment.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import com.questionmark.doctorappointment.patient.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public Appointment createAppointment(Appointment newAppointment) throws AppointmentExceptions {
        Optional<Doctor> doctorOptional = this.doctorRepository.findById(newAppointment.getDoctorId());
        if(doctorOptional.isEmpty()){
            throw new AppointmentExceptions("Doctor with ID does not exist");
        }
        List<Appointment> temp= doctorOptional.get().getAppointmentList();
        temp.add(newAppointment);
        doctorOptional.get().setAppointmentList(temp);

        Optional<Patient> patientOptional = this.patientRepository.findById(newAppointment.getPatientId());
        if(patientOptional.isEmpty()){
            throw new AppointmentExceptions("Patient with ID does not exist");
        }

        List<Appointment> temp2 = patientOptional.get().getAppointments();
        temp2.add(newAppointment);
        doctorOptional.get().setAppointmentList(temp);

        this.appointmentRepository.save(newAppointment);
        this.doctorRepository.save(doctorOptional.get());
        this.patientRepository.save(patientOptional.get());
        return newAppointment;
    }

    @Override
    public Appointment getAppointmentById(Integer id) throws AppointmentExceptions{
        Optional<Appointment> appointmentOpt=this.appointmentRepository.findById(id);
        if(appointmentOpt.isEmpty())
            throw new AppointmentExceptions("Appointment doesn't exists:"+id);
        return appointmentOpt.get();
    }

    @Override
    public Appointment deleteAppointmentById(Integer id) throws AppointmentExceptions{
        Optional<Appointment> appointmentOpt=this.appointmentRepository.findById(id);
        if(appointmentOpt.isEmpty())
            throw new AppointmentExceptions("No such Appointment exists:"+id);
        this.appointmentRepository.deleteById(id);
        return appointmentOpt.get();
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
    public Appointment changeAppointmentByDate(Integer id, Appointment newDate) throws AppointmentExceptions
    {
        Optional<Appointment> appointmentOpt=this.appointmentRepository.findById(id);
        if(appointmentOpt.isEmpty())
            throw new AppointmentExceptions("Appointment doesn't exist for this ID:"+id);
        Appointment appointment=appointmentOpt.get();
        appointment.setDate(newDate.getDate());
        return this.appointmentRepository.save(appointment);
    }
    @Override
    public Appointment changeAppointmentByTiming(Integer id, Appointment newTiming) throws AppointmentExceptions {
        Optional<Appointment> appointmentOpt=this.appointmentRepository.findById(id);
        if(appointmentOpt.isEmpty())
            throw new AppointmentExceptions("Appointment doesn't exist for this ID:"+id);
        Appointment appointment=appointmentOpt.get();
        appointment.setTiming(newTiming.getTiming());
        return this.appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAllAppointment() throws AppointmentExceptions {
        this.appointmentRepository.deleteAll();
    }

}
