package cm.uy1.patientservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cm.uy1.patientservice.entities.Patient;
import cm.uy1.patientservice.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PatientImpl implements PatientInterface {
    private PatientRepository patientRepository;
    private PatientImpl patientImpl;

    public Patient savePatient(Patient patient) {
        return (Patient) patientRepository.save(patient);
    }

    @Override
    public List<Patient> findByName(String name) {
        // TODO Auto-generated method stub
        patientImpl.findByName(name);
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public List<Patient> findByPhone(String phone) {
        // TODO Auto-generated method stub
        patientImpl.findByPhone(phone);
        throw new UnsupportedOperationException("Unimplemented method 'findByPhone'");
    }

    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

}