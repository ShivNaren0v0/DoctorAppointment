package com.questionmark.doctorappointment.patient.dto;

/**
 * <h3>Login DTO</h3>
 * DTO Object for patient login operations
 *
 * @author  Thanush A A
 * @version 1.0
 * @since   2024-02-28
 */
public class LoginDTO {
    private String email;
    private String password;

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
