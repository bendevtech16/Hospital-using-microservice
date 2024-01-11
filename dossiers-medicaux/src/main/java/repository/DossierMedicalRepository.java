package repository;

import entities.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
}
