package uy1.inf331.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uy1.inf331.patientservice.entities.RendezVous;


public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
