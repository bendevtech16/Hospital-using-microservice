package uy1.inf331.patientservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uy1.inf331.patientservice.entities.RendezVous;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ConsultationDTO {
    private long id;
    private Date dateConsultation;
    private String rapportConsultation;
    private double prixConsultation;
    private RendezVous rendezVous;
}