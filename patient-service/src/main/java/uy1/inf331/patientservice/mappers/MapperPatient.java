package uy1.inf331.patientservice.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import uy1.inf331.patientservice.dto.PatientDTO;
import uy1.inf331.patientservice.entities.Patient;

@Service
public class MapperPatient {

    private ModelMapper modelMapper = new ModelMapper();
    public PatientDTO fromPatient(Patient patient) {

        return modelMapper.map(patient , PatientDTO.class);

    }

    public Patient fromPatientDTO(PatientDTO patientDTO) {
        return  modelMapper.map(patientDTO, Patient.class);
    }

}