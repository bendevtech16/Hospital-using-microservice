package uy1.inf331.patientservice.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uy1.inf331.patientservice.dto.MedecinDTO;
import uy1.inf331.patientservice.entities.Medecin;


@Service
@AllArgsConstructor
public class MapperMedecin {
    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * get medecin parameter to return medecinDTO
     * @param medecin
     * @return
     */
    public MedecinDTO fromMedecin(Medecin medecin) {
        return modelMapper.map(medecin , MedecinDTO.class);
    }

    /**
     * get parameter medecinDTO to return Medecin object
     * @param medecinDTO
     * @return
     */
    public Medecin fromMedecinDTO(MedecinDTO medecinDTO) {
        return  modelMapper.map(medecinDTO, Medecin.class);
    }

}
