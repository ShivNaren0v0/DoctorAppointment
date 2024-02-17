package com.doctorappointment.doctorappointment.entity;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;

public class Payment {
    private LocalDate paymentDate;
    private Double amount;
    private Boolean successful;

//    @OneToOne
   // private Appointment appointment;


}
