package uy1.inf331.patientservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uy1.inf331.patientservice.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.name like :name")
    public Patient findByName(@Param("name") String name);

    @Query("select p from Patient p where p.telephone like :telephone")
    public Patient findByTelephone(@Param("telephone") String telephone);

    @Query("select p from Patient p where p.age like :age")
    public Patient findByAge(@Param("age") String age);

    @Query("select p from Patient p where p.name like :name")
    public void deleteByName(@Param("name") String name);

    @Query("select p from Patient p where p.name like %:keyName% or p.email like %:keyName%")
    public List<Patient> findByNameContaining(@Param("keyName") String motCle);

}