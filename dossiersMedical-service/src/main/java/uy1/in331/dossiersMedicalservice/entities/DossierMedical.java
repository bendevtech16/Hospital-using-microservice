package uy1.in331.dossiersMedicalservice.entities;

import jakarta.persistence.*;
import lombok.*;
import uy1.in331.dossiersMedicalservice.model.Patient;

import java.time.LocalDate;

@Entity @AllArgsConstructor @NoArgsConstructor @Builder @ToString @Data
public class DossierMedical {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private LocalDate  dateCreation;
    private String diagnostique;
    private  String antecedents;
    private     String traitement;
    private long patientId;
    @Transient
    private Patient patient;

}
