package cm.uy1.patientservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.uy1.patientservice.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}