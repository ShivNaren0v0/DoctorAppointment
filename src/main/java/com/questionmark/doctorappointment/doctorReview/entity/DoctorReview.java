package com.questionmark.doctorappointment.doctorReview.entity;
import com.questionmark.doctorappointment.doctor.entity.Doctor;
import com.questionmark.doctorappointment.patient.entity.Patient;
import jakarta.persistence.*;

@Entity
public class DoctorReview {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Doctor doctor; // Reference to the doctor being reviewed

    @ManyToOne
    private Patient patient;
    private int rating; // Rating (e.g., 1 to 5 stars for now)
    private String reviewText;

    public DoctorReview(int id, Doctor doctor, Patient patient, int rating, String reviewText) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public DoctorReview() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}