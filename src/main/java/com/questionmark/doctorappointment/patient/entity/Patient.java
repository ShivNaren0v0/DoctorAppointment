package com.questionmark.doctorappointment.patient.entity;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Integer patientId;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private String name;

    @OneToMany
    private List<Appointment> appointments= new ArrayList<>();
    public Patient(Integer patientId, String email, String password, Integer age, String gender, String name, List<Appointment> appointments) {
        this.patientId = patientId;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.appointments = appointments;
    }

    public Patient() {
        super();
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    }
