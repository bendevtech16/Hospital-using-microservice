package uy1.inf331.patientservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uy1.inf331.patientservice.entities.RendezVous;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MedecinDTO {
    private long id;
    private String name;
    private String specialite;
    private String email;
    private String telephone;
    private List<RendezVous> listRendeVous;
}
