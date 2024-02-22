package com.questionmark.doctorappointment.appointment.service;

import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.appointment.exceptions.AppointmentExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment newAppointment) {

        return this.appointmentRepository.save(newAppointment);
    }

    @Override
    public Appointment getAppointmentById(Integer id) throws AppointmentExceptions{
        Optional<Appointment> appointmentOpt=this.appointmentRepository.findById(id);
        if(appointmentOpt.isEmpty())
            throw new AppointmentExceptions("Appointment doesn't exists:"+id);
        return this.appointmentRepository.findById(id).get();
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
