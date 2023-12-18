package uy1.inf331.facturationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uy1.inf331.facturationservice.entities.Facturation;

public interface FacturationRepository extends JpaRepository<Facturation, Long> {
}
