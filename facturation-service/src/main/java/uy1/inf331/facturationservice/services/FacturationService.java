package uy1.inf331.facturationservice.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import uy1.inf331.facturationservice.dto.FacturationDTO;
import uy1.inf331.facturationservice.entities.Facturation;
import uy1.inf331.facturationservice.mappers.MappeFacturation;
import uy1.inf331.facturationservice.repository.FacturationRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
@Getter
@Setter
public class FacturationService implements Ifacturation {

    private final FacturationRepository facturationRepository;
    private final MappeFacturation mappeFacturation;

    public FacturationDTO savingFacturation(FacturationDTO facturationDTO) {
        Facturation facturation = mappeFacturation.fromFacturationDTO(facturationDTO);
        Facturation f = facturationRepository.save(facturation);

        return mappeFacturation.fromFacturation(f);
    }

    // public FacturationDTO update(Long id, FacturationDTO facturationDTO) {
    // if (facturationRepository.findById(id) == null) {
    // System.out.println("facture not found...");
    // } else {
    // Facturation facturation = mappeFacturation.fromFacturation(facturationDTO);
    // facturation.setId(id);
    // return
    // mappeFacturation.retourneFacturationDTO(facturationRepository.save(facturation));
    // }
    // return facturationDTO;
    // }

    public void delete(Long id) {
        facturationRepository.deleteById(id);
    }

    public List<FacturationDTO> findAll() {
        log.info("getting ressource in progress...");
        if (facturationRepository.findAll() != null) {
            List<Facturation> list = new ArrayList<>();
            list = facturationRepository.findAll();
            List<FacturationDTO> listDTO = new ArrayList<>();
            for (Facturation f : list) {
                FacturationDTO facturationDTO = new FacturationDTO();
                facturationDTO = mappeFacturation.fromFacturation(f);
                listDTO.add(facturationDTO);
            }
            return listDTO;
        } else {
            return null;
        }

    }

    public FacturationDTO findById(Long id) {
        if (facturationRepository.findById(id) != null) {
            Facturation facturation = new Facturation();
            facturation = facturationRepository.findById(id).get();
            return mappeFacturation.fromFacturation(facturation);
        } else {
            return null;
        }
    }

}
