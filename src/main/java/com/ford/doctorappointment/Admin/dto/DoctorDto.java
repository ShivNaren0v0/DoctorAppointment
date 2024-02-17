package com.ford.doctorappointment.Admin.dto;

public class DoctorDto {
    private Integer docId;
    private String name;
    private String spec;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
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

    public DoctorDto(Integer docId, String name, String spec) {
        this.docId = docId;
        this.name = name;
        this.spec = spec;
    }
}
