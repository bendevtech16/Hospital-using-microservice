package uy1.inf331.patientservice.dto;

import java.util.Date;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jdk.jfr.Timestamp;
import lombok.Data;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.entities.Patient;

@Data
public class RendezVousDTO {
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
}