package cm.uy1.patientservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.uy1.patientservice.entities.Patient;

public interface PatientInterface {

    @Query("select c from Patient c where c.name like :mc")
    public List<Patient> findByName(@Param("mc") String name);

    @Query("select P from Patient  where P.name like :phone")
    public List<Patient> findByPhone(@Param("phone") String phone);

}