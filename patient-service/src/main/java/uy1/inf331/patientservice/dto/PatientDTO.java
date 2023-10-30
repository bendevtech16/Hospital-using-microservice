package uy1.inf331.patientservice.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private long id;
    private String name;
    private String email;
    private int age;
    private String telephone;

}