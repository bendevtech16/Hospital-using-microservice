package enums;

import jakarta.persistence.*;
import lombok.*;
import model.Patient;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate dateCreation;
    private  String idPatient;
    @Transient
    Patient patient;
}
