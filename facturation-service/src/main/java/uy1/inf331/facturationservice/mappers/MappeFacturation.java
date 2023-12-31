package uy1.inf331.facturationservice.mappers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import uy1.inf331.facturationservice.dto.FacturationDTO;
import uy1.inf331.facturationservice.entities.Facturation;
import uy1.inf331.facturationservice.model.Patient;

@Service
public class MappeFacturation {

    private final ModelMapper modelMapper = new ModelMapper();

    public FacturationDTO fromFacturation(Facturation facturation) {

        return modelMapper.map(facturation, FacturationDTO.class);

    }

    public Facturation fromFacturationDTO(FacturationDTO facturationDTO) {
        return modelMapper.map(facturationDTO, Facturation.class);
    }

}
