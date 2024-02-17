package com.ford.doctorappointment.Doctor.entity;
import com.ford.doctorappointment.Appointment.entity.Appointment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private Integer docId;
    private String name;
    private String spec;
    private LocalTime from;
    private LocalTime to;
    private Double rating;
    @OneToMany
    private List<Appointment> appointmentList = new ArrayList<>();


    public Doctor() {
        super();
    }
    public Doctor(Integer docId, String name, String spec, LocalTime from, LocalTime to, Double rating, List<Appointment> appointmentList) {
        this.docId = docId;
        this.name = name;
        this.spec = spec;
        this.from = from;
        this.to = to;
        this.rating = rating;
        this.appointmentList = appointmentList;
    }



    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }


}
