package uy1.inf331.patientservice.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uy1.inf331.patientservice.dto.PatientDTO;
import uy1.inf331.patientservice.dto.RendezVousDTO;
import uy1.inf331.patientservice.entities.Patient;
import uy1.inf331.patientservice.entities.RendezVous;

@Component
public class MapperRendezVous {
    private final ModelMapper modelMapper = new ModelMapper();
    public RendezVousDTO fromRendezVous(RendezVous rendezVous) {

        return modelMapper.map(rendezVous , RendezVousDTO.class);

    }
    public RendezVous fromRendezVousDTO(RendezVousDTO rendezVousDTO) {
        return  modelMapper.map(rendezVousDTO, RendezVous.class);
    }
}
