package uy1.in331.dossiersMedicalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uy1.in331.dossiersMedicalservice.entities.DossierMedical;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
}
