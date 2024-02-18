package com.ford.doctorappointment.Patient.dto;

import com.ford.doctorappointment.Appointment.entity.Appointment;

public class AppointmentRequestDTO {
    private Appointment appointment;
    private Integer patientId;

    public AppointmentRequestDTO(Appointment appointment, Integer patientId) {
        this.appointment = appointment;
        this.patientId = patientId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
}
