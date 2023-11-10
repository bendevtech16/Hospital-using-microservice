package uy1.inf331.patientservice.dto;

import java.util.Date;

import lombok.Data;
import uy1.inf331.patientservice.entities.RendezVous;

@Data
public class ConsultationDTO {
    private long id;
    private Date dateConsultation;
    private String rapportConsultation;
    private double prixConsultation;

}