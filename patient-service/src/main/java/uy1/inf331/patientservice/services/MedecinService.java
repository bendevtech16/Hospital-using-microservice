package uy1.inf331.patientservice.services;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.repository.MedecinRepository;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
public class MedecinService {
    private MedecinRepository medecinRepository;

    public Medecin saveMedecin(Medecin medecin) {
        log.info("Saving Medecin");
        return medecinRepository.save(medecin);
    }

}