package com.questionmark.doctorappointment;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
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

public class AdminControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Order(1)
    @Test
    void viewAllDoctorTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/Doctor").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Order(2)
    @Test
    void registerNewDoctorTest() throws Exception {
        Doctor doctor = new Doctor();
        doctor.setName("Shiv Naren");
        doctor.setDocId(20);
        doctor.setSpec("Cardiologist");
        doctor.setRating(4.0);
        doctor.setAppointmentList(new ArrayList<>());
        mvc.perform(MockMvcRequestBuilders.post("/addDoctor").content(objectMapper.writeValueAsString(doctor)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Order(3)
    @Test
    void registerNewDoctorException() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/addDoctor").content(objectMapper.writeValueAsString(null)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }

    @Order(4)
    @Test
    void testDoctorIdEmpty() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/Doctor/{Id}",1)).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
    }

}
