package com.questionmark.doctorappointment.appointmentTest;

import com.questionmark.doctorappointment.appointment.controller.AppointmentController;
import com.questionmark.doctorappointment.appointment.dao.AppointmentRepository;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.dao.DoctorRepository;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.dao.PatientRepository;
import com.questionmark.doctorappointment.patient.entity.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AppointmentControllerTest {
    @Autowired
    private AppointmentController appointmentController;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    List<Appointment> appointmentList=new ArrayList<>();
    @BeforeEach
    public void appointmentSetup() {
        appointmentList.add(new Appointment(1,1,1,LocalDate.of(2024,5,6),LocalTime.of(12,12,12),"skin",false));
        appointmentList.add(new Appointment(2,1,1,LocalDate.of(2024,5,7),LocalTime.of(13,12,15),"ortho",false));
        appointmentList.add(new Appointment(3,1,1,LocalDate.of(2024,5,8),LocalTime.of(12,12,12),"heart",false));
        appointmentList.add(new Appointment(4,1,1,LocalDate.of(2024,5,9),LocalTime.of(13,12,15),"brain",false));
        appointmentList.add(new Appointment(5,1,1,LocalDate.of(2024,5,10),LocalTime.of(13,12,15),"lungs",false));
        this.appointmentRepository.saveAll(appointmentList);
        Doctor doctor = new Doctor();
        doctor.setName("GK");
        doctor.setSpec("heart");
        doctor.setAppointmentList(null);
        doctorRepository.save(doctor);
        Patient patient = new Patient();
        patient.setName("Thanush");
        patient.setAge(20);
        patient.setGender("batman");
        patient.setEmail("thanush@student.tce.edu");
        patient.setPassword("a secret");
        patient.setAppointments(null);
        patientRepository.save(patient);
    }
    @Test
    void createAppointmentTest() {
//        List<Appointment> appointmentList1=new ArrayList<>();
//        appointmentList1.add(new Appointment(null,1,1,LocalDate.of(2024,5,9),LocalTime.of(13,12,15),"brain",false));

        try {
            Appointment createdAppointment;
            for (Appointment appointment : appointmentList) {
                createdAppointment = appointmentController.createAppointment(appointment);
                Assertions.assertNotNull(createdAppointment, "Appointment has been created successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void getAppointmentByIdTest()
    {
        try {
            Appointment foundAppointment = appointmentController.getAppointmentById(2);
            Assertions.assertNotNull(foundAppointment);
            Assertions.assertEquals("ortho",foundAppointment.getDescription());
        }
        catch (Exception e)
        {
            Assertions.fail("An exception occurred while getting the appointment : " + e.getMessage());
        }

    }
    @Test
    void deleteAppointmentByIdTest ()
    {
        appointmentSetup();
        try {
            ResponseEntity<String> response= appointmentController.deleteAppointmentById(4);
            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
            Assertions.assertEquals("Appointment deleted successfully", response.getBody());
        }
        catch (Exception e)
        {
            Assertions.fail("An exception occurred during appointment deletion: " + e.getMessage());
        }
    }
    @Test
    void getAllAppointmentsTest()
    {
        try {
            List<Appointment> appointmentList1;
            appointmentList1=appointmentController.getAllAppointments();
            Assertions.assertNotNull(appointmentList1);
        }
        catch (Exception e)
        {
            Assertions.fail("An exception occurred while getting all the appointments : " + e.getMessage());

        }
    }
    @Test
    void  changeAppointmentByDateTest()
    {
        appointmentSetup();
        try{
            Appointment appointment1 = appointmentController.changeAppointmentByDate(1, LocalDate.of(2024, 7, 23));
            appointmentRepository.save(appointment1);
            Appointment updatedAppointment = appointmentController.getAppointmentById(1);
            Assertions.assertEquals(LocalDate.of(2024, 7, 23),updatedAppointment.getDate(),"Appointment updated successfully");

        }
        catch (Exception e)
        {
            Assertions.fail("An exception occurred while changing the appointments : " + e.getMessage());

        }
    }
    @Test
    void  changeAppointmentByTimeTest()
    {
        appointmentSetup();
        try {
            Appointment appointment1 = appointmentController.changeAppointmentByTiming(5, LocalTime.of(18,7,23));
            appointmentRepository.save(appointment1);
            Appointment updatedAppointment = appointmentController.getAppointmentById(5);
            Assertions.assertEquals(LocalTime.of(18,7,23),updatedAppointment.getTiming(),"Appointment updated successfully");
        }
        catch (Exception e)
        {
            Assertions.fail("An exception occurred while changing the appointments : " + e.getMessage());

        }
    }
@Test
void deleteAllAppointmentTest()
    {
        appointmentSetup();
        try {
            appointmentController.deleteAllAppointment();
            List<Appointment> allAppointments = appointmentRepository.findAll();
            Assertions.assertTrue(allAppointments.isEmpty(), "All appointments should have been deleted");
        }
        catch (Exception e)
        {
            Assertions.fail("An exception occurred while changing the appointments : " + e.getMessage());

        }
    }
}
