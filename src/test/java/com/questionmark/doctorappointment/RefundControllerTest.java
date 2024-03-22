package com.questionmark.doctorappointment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionmark.doctorappointment.appointment.entity.Appointment;
import com.questionmark.doctorappointment.doctor.dto.ConfirmationDTO;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.entity.Patient;
import com.questionmark.doctorappointment.payment.entity.Payment;
import com.questionmark.doctorappointment.refund.entity.Refund;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
public class RefundControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(1)
    @Test
    public void createRefundTest() throws Exception{
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
        Payment payment=new Payment();
        payment.setAmount(confirmationDTO.getAmount());
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentMethod("UPI");
        mvc.perform(MockMvcRequestBuilders.post("/payment").content(objectMapper.writeValueAsString(payment)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        Refund refund=new Refund();
        refund.setRefund_amount(payment.getAmount());
        mvc.perform(MockMvcRequestBuilders.post("/refund").content(objectMapper.writeValueAsString(refund)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(2)
    @Test
    public void getRefundByIdTest() throws Exception{
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
        Payment payment=new Payment();
        payment.setAmount(confirmationDTO.getAmount());
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentMethod("UPI");
        mvc.perform(MockMvcRequestBuilders.post("/payment").content(objectMapper.writeValueAsString(payment)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.patch("/payment/cancelled/{id}",1));
        mvc.perform(MockMvcRequestBuilders.get("/refund/{id}",1)).andExpect(status().isOk());
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(3)
    @Test
    public void getRefundByidExceptionTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/refund/{id}",1)).andExpect(status().isBadRequest()).andExpect(content().string(equalTo("No Refund Exists")));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(4)
    @Test
    public void updateRefundStatusTest() throws Exception{
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
        Payment payment=new Payment();
        payment.setAmount(confirmationDTO.getAmount());
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentMethod("UPI");
        mvc.perform(MockMvcRequestBuilders.post("/payment").content(objectMapper.writeValueAsString(payment)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.patch("/payment/cancelled/{id}",1));
        mvc.perform(MockMvcRequestBuilders.patch("/refund/updateStatus/{id}",1)).andExpect(status().isOk());

    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Order(5)
    @Test
    public void updateRefundStatusExceptionTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.patch("/refund/updateStatus/{id}",1)).andExpect(status().isBadRequest()).andExpect(content().string(equalTo("No Refund Exists")));
    }
}
