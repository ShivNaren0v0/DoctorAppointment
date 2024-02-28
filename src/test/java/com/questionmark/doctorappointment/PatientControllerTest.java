package com.questionmark.doctorappointment;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionmark.doctorappointment.patient.dto.LoginDTO;
import com.questionmark.doctorappointment.patient.entity.Patient;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Order(1)
    @Test
    void getPatients() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/patient/get_all_patient").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Order(2)
    @Test
    void createAccount() throws Exception {
        Patient patient = new Patient();
        patient.setName("Thanush");
        patient.setAge(20);
        patient.setGender("batman");
        patient.setEmail("thanush@student.tce.edu");
        patient.setPassword("a secret");
        patient.setAppointments(new ArrayList<>());
        mvc.perform(MockMvcRequestBuilders.post("/patient/create_account").content(objectMapper.writeValueAsString(patient)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Order(3)
    @Test
    void createAccountException() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/patient/create_account").content(objectMapper.writeValueAsString(null)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }

    @Order(4)
    @Test
    void getAppointmentsTest() throws Exception{
        Patient patient = new Patient();
        patient.setName("Thanush");
        patient.setAge(20);
        patient.setGender("batman");
        patient.setEmail("thanush@student.tce.edu");
        patient.setPassword("a secret");
        patient.setAppointments(new ArrayList<>());
        mvc.perform(MockMvcRequestBuilders.post("/patient/create_account").content(objectMapper.writeValueAsString(patient)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.get("/patient/get_appointments/{patientId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }

    @Order(5)
    @Test
    void performPaymentExceptionTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/patient/perform_payment/{id}",1).content(objectMapper.writeValueAsString("cash")).contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN)).andExpect(status().isBadRequest());
    }

    @Order(6)
    @Test
    void testGetAppointmentStatus() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/patient/AppointmentStatus/{id}",10).content(objectMapper.writeValueAsString(1)).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andExpect(content().string(equalTo("Appointment not found / Appointment cancelled by doctor")));
    }


    @Order(7)
    @Test
    void loginTest() throws Exception {

        Patient patient = new Patient();
        patient.setName("Thanush");
        patient.setAge(20);
        patient.setGender("batman");
        patient.setEmail("thanush@student.tce.edu");
        patient.setPassword("a secret");
        patient.setAppointments(new ArrayList<>());
        LoginDTO loginDTO = new LoginDTO(patient.getEmail(), patient.getPassword());
        mvc.perform(MockMvcRequestBuilders.post("/patient/create_account").content(objectMapper.writeValueAsString(patient)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.post("/patient/login").content(objectMapper.writeValueAsString(loginDTO)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json("{\n" +
                "  \"patientId\": 1,\n" +
                "  \"email\": \"thanush@student.tce.edu\",\n" +
                "  \"password\": \"a secret\",\n" +
                "  \"age\": 20,\n" +
                "  \"gender\": \"batman\",\n" +
                "  \"name\": \"Thanush\",\n" +
                "  \"appointments\": []\n" +
                "}"));
    }

    @Order(8)
    @Test
    void loginTestWrongPassword() throws Exception {
        Patient patient = new Patient();
        patient.setName("Thanush");
        patient.setAge(20);
        patient.setGender("batman");
        patient.setEmail("thanush@student.tce.edu");
        patient.setPassword("a secret");
        patient.setAppointments(new ArrayList<>());
        LoginDTO loginDTO = new LoginDTO("thanush@student.tce.edu", "wrong password");
        mvc.perform(MockMvcRequestBuilders.post("/patient/login").content(objectMapper.writeValueAsString(loginDTO)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }

    @Order(9)
    @Test
    void testLoginNotFoundException() throws Exception {
        LoginDTO loginDTO = new LoginDTO("wrong@email.com","some password");
        mvc.perform(MockMvcRequestBuilders.post("/patient/login").content(objectMapper.writeValueAsString(loginDTO)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }

}