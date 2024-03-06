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

    /**
     * <h3>getEmail()</h3>
     * For getting email address stored in the DTO
     *
     * @author  Thanush A A
     * @version 1.0
     * @since   2024-02-28
     */
    public String getEmail() {
        return email;
    }

    /**
     * <h3>setEmail()</h3>
     * For setting email address variable in the DTO
     *
     * @author  Thanush A A
     * @version 1.0
     * @since   2024-02-28
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <h3>getPassword</h3>
     * For getting password data stored in the DTO
     *
     * @author  Thanush A A
     * @version 1.0
     * @since   2024-02-28
     */
    public String getPassword() {
        return password;
    }
    /**
     * <h3>setPassword</h3>
     * For setting a password in the LoginDTO
     *
     * @author  Thanush A A
     * @version 1.0
     * @since   2024-02-28
     */


    public void setPassword(String password) {
        this.password = password;
    }
}
