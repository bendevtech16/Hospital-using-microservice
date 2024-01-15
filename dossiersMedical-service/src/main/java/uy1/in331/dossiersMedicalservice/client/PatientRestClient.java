package uy1.in331.dossiersMedicalservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uy1.in331.dossiersMedicalservice.model.Patient;

import java.util.List;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientRestClient {
    @GetMapping("/service-patient/search/{id}")
    @CircuitBreaker(name = "patientService", fallbackMethod = "getDefaultPatient")
    Patient findPatientById(@PathVariable Long id);

    @GetMapping("/service-patient/patients")
    @CircuitBreaker(name = "patientService", fallbackMethod = "getAllDefaultPatient")
    List<Patient> allPatient();
    default Patient getDefaultPatient(Long id, Exception exception) {
        Patient patient = new Patient();
        patient.setId(id);
        patient.setName("Not vailable");
        patient.setAge(0);
        patient.setEmail("notAvailabletEmail");
        patient.setTelephone("not available");
        return patient;
    }
    default List<Patient> getAllDefaultPatient(Exception exception) {
        return List.of();

    }
}
