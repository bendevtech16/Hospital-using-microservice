package uy1.inf331.patientservice.dto;

import lombok.Data;
import uy1.inf331.patientservice.enums.Specialiste;

@Data
public class MedecinDTO {
    private long id;
    private String name;
    private Specialiste specialiste;
    private String email;
    private String telephone;
}
