package uy1.inf331.patientservice.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uy1.inf331.patientservice.dto.RendezVousDTO;
import uy1.inf331.patientservice.entities.RendezVous;
import uy1.inf331.patientservice.mappers.MapperRendezVous;
import uy1.inf331.patientservice.repository.RendezVousRepository;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
public class RendezVousService implements IrendezVous {
    private RendezVousRepository rendezVousRepository;
    private final MapperRendezVous mapperRendezVous;

    public RendezVousDTO savingRDV(RendezVousDTO rendezVousDTO) {
        RendezVous rendezVous = new RendezVous();
        rendezVous = mapperRendezVous.fromRendezVousDTO(rendezVousDTO);
        return mapperRendezVous.fromRendezVous(rendezVousRepository.save(rendezVous));
    }
}
