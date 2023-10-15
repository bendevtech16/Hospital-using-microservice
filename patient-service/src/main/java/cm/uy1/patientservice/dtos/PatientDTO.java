package cm.uy1.patientservice.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class PatientDTO {
    private long id;
    private String name;
    private String address;
    private String phone;
    private Date dateOfBirth;

}