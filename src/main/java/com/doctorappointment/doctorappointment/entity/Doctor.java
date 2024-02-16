package com.doctorappointment.doctorappointment.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalTime;
import java.util.List;

public class Doctor {

    @Id
    @GeneratedValue
    private Integer docId;
    private String name;
    private String spec;
    private LocalTime from;

    private LocalTime to;

    @OneToMany
    private List<Appointment> appointmentList;

}
