package com.ford.doctorappointment.Patient.service;

import com.ford.doctorappointment.Appointment.entity.Appointment;
import com.ford.doctorappointment.Patient.entity.Patient;

public interface PatientService {
    Patient addPatient(Patient patient);
    Patient addAppointment(Appointment appointment);
}
