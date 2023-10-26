package uy1.inf331.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PatientDTO {
    private long id;
    private String name;
    private String email;
    private int age;
    private String telephone;

}