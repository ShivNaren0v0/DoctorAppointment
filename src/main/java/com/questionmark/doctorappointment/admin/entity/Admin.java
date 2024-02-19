package com.questionmark.doctorappointment.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Admin {


    @GeneratedValue
    @Id
    private Integer id;



    private String name;
    private String password;



}
