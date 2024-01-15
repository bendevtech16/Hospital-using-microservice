package uy1.inf331.facturationservice.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class FacturationService implements Ifacturation {

    private final FacturationRepository facturationRepository;
    private final MappeFacturation mappeFacturation;

    public FacturationDTO savingFacturation(FacturationDTO facturationDTO) {
        FacturationDTO facturationDTO2 = new FacturationDTO();
        facturationDTO2.setId(facturationDTO.getId());
        facturationDTO2.setCreatedAt(facturationDTO.getCreatedAt());
        facturationDTO2.setMontant(facturationDTO.getMontant());
        facturationDTO2.setPatientId(facturationDTO.getPatientId());
        facturationDTO2.setPatient(facturationDTO.getPatient());

        Facturation facturation = new Facturation();
        facturation.setId(facturationDTO2.getId());
        facturation.setCreatedAt(facturationDTO2.getCreatedAt());
        facturation.setMontant(facturationDTO2.getMontant());
        facturation.setPatientId(facturationDTO2.getPatientId());
        facturationDTO2.setPatient(facturationDTO2.getPatient());
        Facturation facturationEnregistrer = facturationRepository.save(facturation);

        FacturationDTO facturationDTO1 = new FacturationDTO();
        facturationDTO1.setId(facturationEnregistrer.getId());
        facturationDTO1.setCreatedAt(facturationEnregistrer.getCreatedAt());
        facturationDTO1.setPatient(facturationEnregistrer.getPatient());
        facturationDTO1.setMontant(facturationEnregistrer.getMontant());
        facturationDTO1.setPatientId(facturationEnregistrer.getPatientId());
        return facturationDTO1;
    }

    public FacturationDTO update(Long id, FacturationDTO facturationDTO) {
        if (facturationRepository.findById(id) == null) {
            System.out.println("facture not found...");
            return null;
        } else {
            Facturation facturation = facturationRepository.findById(id).get();
            facturation.setId(id);
            facturation.setCreatedAt(facturationDTO.getCreatedAt());
            facturation.setMontant(facturationDTO.getMontant());
            facturation.setPatientId(facturationDTO.getPatientId());
            Facturation facturationEnregistrer = facturationRepository.save(facturation);

            FacturationDTO facturationDTO2 = new FacturationDTO();
            facturationDTO2.setId(facturationEnregistrer.getId());
            facturationDTO2.setCreatedAt(facturationEnregistrer.getCreatedAt());
            facturationDTO2.setMontant(facturationEnregistrer.getMontant());
            facturationDTO2.setPatientId(facturationEnregistrer.getPatientId());

            return facturationDTO2;
        }

    }

    public void deleteById(Long id) {
        facturationRepository.deleteById(id);
    }

    public List<FacturationDTO> findAll() {
        log.info("getting ressource in progress...");

        List<Facturation> list = new ArrayList<>();
        list = facturationRepository.findAll();
        List<FacturationDTO> listDTO = new ArrayList<>();
        for (Facturation f : list) {
            FacturationDTO facturationDTO = new FacturationDTO();
            facturationDTO.setId(f.getId());
            facturationDTO.setCreatedAt(f.getCreatedAt());
            facturationDTO.setMontant(f.getMontant());
            facturationDTO.setPatientId(f.getPatientId());
            // facturationDTO = mappeFacturation.fromFacturation(f);
            listDTO.add(facturationDTO);
        }
        return listDTO;

    }
    public FacturationDTO findById(Long id) {
        if (facturationRepository.findById(id) != null) {
            Facturation facturation = new Facturation();
            facturation = facturationRepository.findById(id).get();
            FacturationDTO facturationDTO = new FacturationDTO();
            facturationDTO.setId(facturation.getId());
            facturationDTO.setCreatedAt(facturation.getCreatedAt());
            facturationDTO.setMontant(facturation.getMontant());
            facturationDTO.setPatientId(facturation.getPatientId());
            return facturationDTO;
        } else {
            return null;
        }
    }

}
