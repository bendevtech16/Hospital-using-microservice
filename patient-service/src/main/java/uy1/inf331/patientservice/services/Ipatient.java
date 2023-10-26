package uy1.inf331.patientservice.services;

import java.util.List;

import uy1.inf331.patientservice.dto.PatientDTO;
import uy1.inf331.patientservice.exceptions.PatientListNotFoundException;

public interface Ipatient {

    public List<PatientDTO> getAllPatients() throws PatientListNotFoundException;

}