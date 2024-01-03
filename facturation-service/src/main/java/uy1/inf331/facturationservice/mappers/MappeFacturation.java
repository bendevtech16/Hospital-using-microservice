package uy1.inf331.facturationservice.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import uy1.inf331.facturationservice.dto.FacturationDTO;
import uy1.inf331.facturationservice.entities.Facturation;
import uy1.inf331.facturationservice.model.Patient;

@Service
public class MappeFacturation {

    private final ModelMapper modelMapper = new ModelMapper();

    public FacturationDTO fromFacturation(Facturation optional) {

        return modelMapper.map(optional, FacturationDTO.class);

    }

    public Facturation fromFacturationDTO(FacturationDTO facturationDTO) {
        return modelMapper.map(facturationDTO, Facturation.class);
    }

}
