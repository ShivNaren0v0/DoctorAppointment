package com.questionmark.doctorappointment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.dto.ConfirmationDTO;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.entity.Patient;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DoctorControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(1)
    @Test
    void getAppointmentsTest() throws Exception{
        Doctor doctor=new Doctor();
        doctor.setName("Raja");
        doctor.setSpec("Cardiologist");
        mvc.perform(MockMvcRequestBuilders.post("/addDoctor").
                content(objectMapper.writeValueAsString(doctor)).
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON));

        mvc.perform(MockMvcRequestBuilders.get("/doctor/get_appointment/{doctorId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(2)
    @Test
    void confirmAppointmentTest() throws Exception{
        Doctor doctor=new Doctor();
        doctor.setName("Raja");
        doctor.setSpec("Cardiologist");
        mvc.perform(MockMvcRequestBuilders.post("/addDoctor").content(objectMapper.writeValueAsString(doctor)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        Patient patient=new Patient();
        patient.setAge(23);
        patient.setName("Gajju");
        patient.setGender("Male");
        patient.setPassword("Gajju");
        patient.setEmail("Gajju@gmail.com");
        mvc.perform(MockMvcRequestBuilders.post("/patient/create_account").content(objectMapper.writeValueAsString(patient)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        Appointment appointment=new Appointment();
        appointment.setDoctorId(1);
        appointment.setDate(LocalDate.parse("2024-12-12"));
        appointment.setStatus(false);
        appointment.setPayment(null);
        appointment.setTiming(LocalTime.parse("23:23:23"));
        appointment.setDescription("LELO");
        appointment.setPatientId(1);
        mvc.perform(MockMvcRequestBuilders.post("/appointment").content(objectMapper.writeValueAsString(appointment)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        ConfirmationDTO confirmationDTO= new ConfirmationDTO();
        confirmationDTO.setAmount(678.7);
        confirmationDTO.setAppointmentId(1);
        mvc.perform(MockMvcRequestBuilders.post("/doctor/confirm_appointment").content(objectMapper.writeValueAsString(confirmationDTO)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(3)
    @Test
    void cancelAppointmentTest() throws Exception{
        Doctor doctor=new Doctor();
        doctor.setName("Raja");
        doctor.setSpec("Cardiologist");
        mvc.perform(MockMvcRequestBuilders.post("/addDoctor").content(objectMapper.writeValueAsString(doctor)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        Patient patient=new Patient();
        patient.setAge(23);
        patient.setName("Gajju");
        patient.setGender("Male");
        patient.setPassword("Gajju");
        patient.setEmail("Gajju@gmail.com");
        mvc.perform(MockMvcRequestBuilders.post("/patient/create_account").content(objectMapper.writeValueAsString(patient)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        Appointment appointment=new Appointment();
        appointment.setDoctorId(1);
        appointment.setDate(LocalDate.parse("2024-12-12"));
        appointment.setStatus(false);
        appointment.setPayment(null);
        appointment.setTiming(LocalTime.parse("23:23:23"));
        appointment.setDescription("LELO");
        appointment.setPatientId(1);
        mvc.perform(MockMvcRequestBuilders.post("/appointment").content(objectMapper.writeValueAsString(appointment)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        ConfirmationDTO confirmationDTO= new ConfirmationDTO();
        confirmationDTO.setAmount(678.7);
        confirmationDTO.setAppointmentId(1);
        mvc.perform(MockMvcRequestBuilders.post("/doctor/confirm_appointment").content(objectMapper.writeValueAsString(confirmationDTO)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.post("/doctor/cancel_appointment/{appointmentId}",1).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(4)
    @Test
    void getAppointmentsTestException() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/doctor/get_appointment/{doctorId}", 1))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("Please enter a valid Doctor ID")));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(5)
    @Test
    void cancelAppointmentTestException() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/doctor/cancel_appointment/{appointmentId}",1))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("Appointment ID not found. Hence it cannot be cancelled by the doctor")));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(6)
    @Test
    void confirmAppoinmentTestException() throws Exception{
        ConfirmationDTO confirmationDTO= new ConfirmationDTO();
        confirmationDTO.setAmount(678.7);
        confirmationDTO.setAppointmentId(1);
        mvc.perform(MockMvcRequestBuilders.post("/doctor/confirm_appointment").content(objectMapper.writeValueAsString(confirmationDTO)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("Appointment is not available")));
    }

}
