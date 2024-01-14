package uy1.in331.dossiersMedicalservice.dto;

import jakarta.persistence.Transient;
import lombok.*;
import uy1.in331.dossiersMedicalservice.model.Patient;

import java.time.LocalDate;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DossierMedicalDTO {
    private Long id;
    private String nom;
    private LocalDate dateCreation;
    private String diagnostique;
    private String antecedents;
    private String traitement;
    private long patientId;
    private Patient patient;
}
