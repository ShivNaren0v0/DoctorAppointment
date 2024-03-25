package com.questionmark.doctorappointment.doctor.dto;

public class LoginDTo {
    private String name;
    private String spec;

    public LoginDTo(String name, String spec) {
        this.name = name;
        this.spec = spec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
