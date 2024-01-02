package uy1.inf331.facturationservice.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import uy1.inf331.facturationservice.dto.FacturationDTO;
import uy1.inf331.facturationservice.entities.Facturation;
import uy1.inf331.facturationservice.mappers.MappeFacturation;
import uy1.inf331.facturationservice.model.Patient;
import uy1.inf331.facturationservice.repository.FacturationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
public class FacturationService implements Ifacturation {

    private final FacturationRepository facturationRepository;
    private final MappeFacturation mappeFacturation;

    // public FacturationDTO savingFacturation(FacturationDTO facturationDTO) {
    // FacturationDTO facturationDTO2 = new FacturationDTO();
    // facturationDTO2 = facturationDTO;

    // Facturation facturation =
    // mappeFacturation.fromFacturationDTO(facturationDTO2);
    // Facturation f = facturationRepository.save(facturation);

    // return mappeFacturation.fromFacturation(f);
    // }

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

    // public List<FacturationDTO> findAll() {
    // log.info("getting ressource in progress...");

    // List<Facturation> list = new ArrayList<>();
    // list = facturationRepository.findAll();
    // List<FacturationDTO> listDTO = new ArrayList<>();
    // for (Facturation f : list) {
    // FacturationDTO facturationDTO = new FacturationDTO();
    // facturationDTO = mappeFacturation.fromFacturation(f);
    // listDTO.add(facturationDTO);
    // }
    // return listDTO;

    // }

    public FacturationDTO handleFindById(long id) {
        log.info("Finding facture...");
        if (facturationRepository.findById(id).isPresent()) {
            return mappeFacturation.fromFacturation(facturationRepository.findById(id));
        } else
            throw new RuntimeException("la facture avec l'identifiant " + id + "est introuvable");
    }

    // public FacturationDTO findById(Long id) {
    // if (facturationRepository.findById(id) != null) {
    // Facturation facturation = new Facturation();
    // facturation = facturationRepository.findById(id).get();
    // return mappeFacturation.fromFacturation(facturation);
    // } else {
    // return null;
    // }
    // }

}
