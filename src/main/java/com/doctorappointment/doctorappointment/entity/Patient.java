package com.doctorappointment.doctorappointment.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public class Patient {
    @Id
    @GeneratedValue
    private Integer patientId;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private String name;
    private String info;

    @OneToMany
    private List<Appointment> appointments;

}
