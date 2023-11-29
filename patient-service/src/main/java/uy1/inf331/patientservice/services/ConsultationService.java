package uy1.inf331.patientservice.services;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uy1.inf331.patientservice.dto.ConsultationDTO;
import uy1.inf331.patientservice.dto.MedecinDTO;
import uy1.inf331.patientservice.entities.Consultation;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.exceptions.FindByNameOrPhoneNotFoundExeception;
import uy1.inf331.patientservice.mappers.MapperConsultation;
import uy1.inf331.patientservice.repository.ConsultationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
public class ConsultationService implements Iconsultation{
    private ConsultationRepository consultationRepository;
    private  final MapperConsultation mapperConsultation = new MapperConsultation();

    /**
     *
     * @param consultationDTO est celui qui est passe en parametre
     * @return un ConsultationDTO
     */
    public ConsultationDTO saving(ConsultationDTO consultationDTO){
       Consultation consultation = mapperConsultation.fromConsultationDTO(consultationDTO);
       return  mapperConsultation.fromConsultation(consultationRepository.save(consultation));
    }
    public List<ConsultationDTO> findAll(){
        List<Consultation> consultationList = new ArrayList<>();
        List<ConsultationDTO> consultationDTOS = new ArrayList<>();
        consultationList = consultationRepository.findAll();
        for (Consultation consultation:consultationList) {
            consultationDTOS.add(mapperConsultation.fromConsultation(consultation));
        }
        return consultationDTOS;
    }

    public void deleleteById(Long id) throws FindByNameOrPhoneNotFoundExeception {
        log.info("Consultation Deleting...");
        if (id != null)
            consultationRepository.deleteById(id);
        else
            throw new FindByNameOrPhoneNotFoundExeception(" patient" + id + "non existant");
    }

    public ResponseEntity<ConsultationDTO> update(long id, ConsultationDTO consultationModifieDTO)
            throws FindByNameOrPhoneNotFoundExeception {
        log.info("Consultation Updating...");
        Optional<Consultation> optionalConsultation = consultationRepository.findById(id);
        if (optionalConsultation.isPresent()) {
            Consultation consultation = optionalConsultation.get();
            consultation.setId(id);
            consultation.setDateConsultation(consultationModifieDTO.getDateConsultation());
            consultation.setRapportConsultation(consultationModifieDTO.getRapportConsultation());
           consultation.setPrixConsultation(consultationModifieDTO.getPrixConsultation());

            Consultation consultationEnregistrer = consultationRepository.save(consultation);
           ConsultationDTO consultationDTO = mapperConsultation.fromConsultation(consultationEnregistrer);
            return ResponseEntity.ok(consultationDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
