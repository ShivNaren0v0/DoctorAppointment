package com.questionmark.doctorappointment.patient.entity;

import com.questionmark.doctorappointment.appointment.entity.Appointment;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Patient Entity</h3>
 * The class implements patient entity, its attributes, and getters and setters
 *
 * @author  Thanush A A
 * @version 1.0
 * @since   2024-02-16
 */
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

    /**
     * <h3>getPatientId()</h3>
     * returns the ID of the patient entity
     * @return Patient ID (Integer)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * <h3>setPatientId(Integer patientId)</h3>
     * sets the ID of the patient entity
     * @param patientId ID of the patient
     * @author  Thanush A A
     * @since   2024-02-16
     *
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    /**
     * <h3>getEmail()</h3>
     * gets the Email ID of the patient
     *
     * @return Email ID (String)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public String getEmail() {
        return email;
    }

    /**
     * <h3>setEmail(String email)</h3>
     * sets the Email ID of the patient
     *
     * @param email Email ID (String)
     * @author  Thanush A A
     * @since   2024-02-16
     */

    public void setEmail(String email) {


        this.email = email;
    }

    /**
     * <h3>getPassword()</h3>
     * gets the password of the patient
     *
     * @return password (String)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public String getPassword() {
        return password;
    }

    /**
     * <h3>setPassword(String password)</h3>
     * sets the password of the patient
     *
     * @param password password (String)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <h3>getAge()</h3>
     * gets the age of the patient
     * @return Age (Integer)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public Integer getAge() {
        return age;
    }
    /**
     * <h3>setAge()</h3>
     * sets the age of the patient
     * @param age age (Integer)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * <h3>getGender()</h3>
     * gets the gender of the patient
     * @return Gender (String)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public String getGender() {
        return gender;
    }

    /**
     * <h3>setGender(String gender)</h3>
     * sets the password of the patient
     * @param gender  Gender (String)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * <h3>getName()</h3>
     * gets the name of the patient
     * @return Name (String)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public String getName() {
        return name;
    }

    /**
     * <h3>setName(String name)</h3>
     * sets the name of the patient
     * @param name  Name (String)
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * <h3>getAppointments()</h3>
     * gets the list of appointments of the patient
     * @return List of appointments
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }
    /**
     * <h3>setAppointments()</h3>
     * sets the list of appointments of the patient
     * @param appointments List of appointments
     * @author  Thanush A A
     * @since   2024-02-16
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    }
