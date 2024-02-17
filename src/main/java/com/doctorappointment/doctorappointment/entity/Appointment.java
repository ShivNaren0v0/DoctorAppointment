package com.doctorappointment.doctorappointment.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Appointment {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate timing;
    private Boolean status;

//    @OneToOne
//    private Payment payment;


}
