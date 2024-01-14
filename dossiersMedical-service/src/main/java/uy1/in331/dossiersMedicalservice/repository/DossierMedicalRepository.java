package uy1.in331.dossiersMedicalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uy1.in331.dossiersMedicalservice.entities.DossierMedical;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
}
