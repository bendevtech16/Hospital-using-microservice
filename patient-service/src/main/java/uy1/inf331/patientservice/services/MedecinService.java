package uy1.inf331.patientservice.services;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import uy1.inf331.patientservice.dto.MedecinDTO;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.enums.Specialiste;
import uy1.inf331.patientservice.mappers.MapperMedecin;
import uy1.inf331.patientservice.repository.MedecinRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
public class MedecinService {
    private MedecinRepository medecinRepository;
    private MapperMedecin mapperMedecin;

    public MedecinDTO saveMedecin(MedecinDTO medecinDTO) {
        log.info("Saving Medecin in progress...");
        Medecin medecin = mapperMedecin.fromMedecinDTO(medecinDTO);
        return mapperMedecin.fromMedecin(medecinRepository.save(medecin));
    }
    public List<MedecinDTO> getAllMedecins(){
    log.info("getting all medecin in progress...");
    List<Medecin> medecinList = new ArrayList<>();
    List<MedecinDTO> medecinDTOList = new ArrayList<>();
    medecinList = medecinRepository.findAll();
        for (Medecin m:medecinList) {
           MedecinDTO medecinDTO =mapperMedecin.fromMedecin(m);
           medecinDTOList.add(medecinDTO);
        }
        return medecinDTOList;
    }

    public List<MedecinDTO> findAllBySpecialist(Specialiste specialite){
        log.info("getting medecin from one specialist");
        List<Medecin> medecinList = new ArrayList<>();
        List<MedecinDTO> medecinDTOList = new ArrayList<>();

        medecinList = medecinRepository.findBySpecialistContaining(specialite);
        for (Medecin m:medecinList) {
            MedecinDTO medecinDTO =mapperMedecin.fromMedecin(m);
            medecinDTOList.add(medecinDTO);
        }
        return medecinDTOList;
    }

}