package uy1.inf331.patientservice.dto;

import java.util.Date;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.entities.Patient;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RendezVousDTO {
    private long id;
    private Date dateRDV;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
}