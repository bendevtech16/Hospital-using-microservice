package uy1.inf331.patientservice.services;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uy1.inf331.patientservice.dto.ConsultationDTO;
import uy1.inf331.patientservice.entities.Consultation;
import uy1.inf331.patientservice.exceptions.FindByNameOrPhoneNotFoundExeception;
import uy1.inf331.patientservice.mappers.MapperConsultation;
import uy1.inf331.patientservice.repository.ConsultationRepository;

import java.util.ArrayList;
import java.util.List;

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
}
