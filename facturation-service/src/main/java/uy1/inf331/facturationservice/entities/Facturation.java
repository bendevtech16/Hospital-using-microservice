package uy1.inf331.facturationservice.entities;


import jakarta.persistence.*;
import lombok.*;
import uy1.inf331.facturationservice.model.Patient;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class Facturation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate createdAt;

    private Double montant;
    @Transient //ignore cet attribut lors de la persistence des donnees...
    private Patient patient;
    private Long patientId;
}
