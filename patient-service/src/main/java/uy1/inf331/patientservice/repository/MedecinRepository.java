package uy1.inf331.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.enums.Specialiste;

import java.util.List;


public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    @Query("select m from Medecin m where m.specialiste like :keyword ")
    public List<Medecin> findBySpecialiste(@Param("keyword") String specialiste);
    public Medecin findByNameContaining(String name);
}