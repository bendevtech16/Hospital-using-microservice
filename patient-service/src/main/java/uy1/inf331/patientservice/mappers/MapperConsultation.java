package uy1.inf331.patientservice.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uy1.inf331.patientservice.dto.ConsultationDTO;
import uy1.inf331.patientservice.entities.Consultation;


@Component
@AllArgsConstructor
public class MapperConsultation {

    private  final ModelMapper modelMapper = new ModelMapper();

    /**
     * get consultation parameter to return ConsultationDTO
     * @param consultation
     * @return
     */
    public ConsultationDTO fromConsultation(Consultation consultation) {
        return modelMapper.map(consultation , ConsultationDTO.class);
    }

    /**
     * get parameter consultationDTO to return Consultation object
     * @param consultationDTO
     * @return
     */
    public Consultation fromConsultationDTO(ConsultationDTO consultationDTO) {
        return  modelMapper.map(consultationDTO, Consultation.class);
    }
}
