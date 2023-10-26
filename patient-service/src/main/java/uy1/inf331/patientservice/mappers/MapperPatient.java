package uy1.inf331.patientservice.mappers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import uy1.inf331.patientservice.dto.PatientDTO;
import uy1.inf331.patientservice.entities.Patient;

@Component
public class MapperPatient {

    public PatientDTO fromPatient(Patient savedPatient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName(savedPatient.getName());
        patientDTO.setEmail(savedPatient.getEmail());
        patientDTO.setAge(savedPatient.getAge());
        patientDTO.setId(savedPatient.getId());
        patientDTO.setTelephone(savedPatient.getTelephone());
        return patientDTO;

    }

    public Patient fromPatientDTO(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());
        patient.setAge(patientDTO.getAge());
        patient.setId(patientDTO.getId());
        patient.setTelephone(patientDTO.getTelephone());
        return patient;

    }

}