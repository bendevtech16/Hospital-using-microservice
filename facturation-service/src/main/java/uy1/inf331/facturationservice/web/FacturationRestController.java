package uy1.inf331.facturationservice.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uy1.inf331.facturationservice.clients.PatientRestClient;
import uy1.inf331.facturationservice.dto.FacturationDTO;
import uy1.inf331.facturationservice.model.Patient;
import uy1.inf331.facturationservice.services.FacturationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@AllArgsConstructor
@RequestMapping("/facturation-service")
public class FacturationRestController {

    private final FacturationService facturationService;
    private final PatientRestClient patientRestClient;

    @GetMapping("/facturations")
    public List<FacturationDTO> handLeFindAll() {
        List<FacturationDTO> facturationDTOList = facturationService.findAll();
        facturationDTOList.forEach(facture->{
            facture.setPatient(patientRestClient.findPatientById(facture.getPatientId()));
        });
        return facturationDTOList;
    }

    @GetMapping("/facturations/{id}")
    public FacturationDTO handLeFindById(@PathVariable Long id) {
        FacturationDTO facturationDTO =facturationService.findById(id);
        Patient patient =patientRestClient.findPatientById(facturationDTO.getPatientId());
        facturationDTO.setPatient(patient);
        return facturationDTO;
    }

    @DeleteMapping("/delete/{id}")
    public void handLeDeleById(@PathVariable Long id) {
        facturationService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public FacturationDTO handleUpdate(@PathVariable long id, @RequestBody FacturationDTO facturationDTO) {
        return facturationService.update(id, facturationDTO);
    }

    @PostMapping("/save")
    public FacturationDTO handLeSave(@RequestBody FacturationDTO facturationDTO ) {
        Patient patient =patientRestClient.findPatientById(facturationDTO.getPatientId());
        facturationDTO.setPatient(patient);
        return facturationService.savingFacturation(facturationDTO);
    }

}