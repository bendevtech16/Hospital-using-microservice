package uy1.in331.dossiersMedicalservice.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uy1.in331.dossiersMedicalservice.dto.DossierMedicalDTO;
import uy1.in331.dossiersMedicalservice.entities.DossierMedical;

import java.util.Optional;

@Service
public class MappeDossierMedical {
    private final ModelMapper modelMapper = new ModelMapper();
    public DossierMedicalDTO fromDossierMedical(DossierMedical dossierMedical){
        return modelMapper.map(dossierMedical, DossierMedicalDTO.class);
    }
    public DossierMedical fromDossierMedicalDTO(DossierMedicalDTO dossierMedicalDTO){
        return  modelMapper.map(dossierMedicalDTO, DossierMedical.class);
    }



}
