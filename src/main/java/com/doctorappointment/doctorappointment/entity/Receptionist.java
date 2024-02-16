package com.doctorappointment.doctorappointment.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Receptionist {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

}
