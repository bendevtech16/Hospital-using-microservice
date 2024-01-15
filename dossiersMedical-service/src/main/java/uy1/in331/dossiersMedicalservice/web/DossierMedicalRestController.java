package uy1.in331.dossiersMedicalservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uy1.in331.dossiersMedicalservice.client.PatientRestClient;
import uy1.in331.dossiersMedicalservice.dto.DossierMedicalDTO;
import uy1.in331.dossiersMedicalservice.entities.DossierMedical;
import uy1.in331.dossiersMedicalservice.exceptions.DossierMedicalException;
import uy1.in331.dossiersMedicalservice.exceptions.FindByIdNotFoundExeception;
import uy1.in331.dossiersMedicalservice.model.Patient;
import uy1.in331.dossiersMedicalservice.services.DossierMedicalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dossier-medical")
public class DossierMedicalRestController {
    @Autowired
    private DossierMedicalService dossierMedicalService;
    @Autowired
    private PatientRestClient patientRestClient;
    @GetMapping("/dossiers")
    public List<DossierMedicalDTO> handleFindAll() throws DossierMedicalException {
        List<DossierMedicalDTO> list = dossierMedicalService.getAllDossiersMedicaux();
        list.forEach(dossierMedicalDTO -> {
            dossierMedicalDTO.setPatient(patientRestClient.findPatientById(dossierMedicalDTO.getPatientId()));
        });
        return list;
    }
    @GetMapping("/dossiers/{id}")
    public DossierMedicalDTO handlegetOne(@PathVariable long id){
        DossierMedicalDTO dossierMedicalDTO =dossierMedicalService.getDossierMedicalById(id);
        Patient patient = patientRestClient.findPatientById(dossierMedicalDTO.getPatientId());
        dossierMedicalDTO.setPatient(patient);
        return dossierMedicalDTO;
    }
    @PostMapping("/save")
    public  DossierMedicalDTO handleSaving(@RequestBody DossierMedicalDTO dossierMedicalDTO){
        return  dossierMedicalService.createDossierMedical(dossierMedicalDTO);
    }
    @DeleteMapping("/delete/{id}")
    public  void  handleDeleteById(long id) throws FindByIdNotFoundExeception {
        dossierMedicalService.deleteDossierMedical(id);
    }
    @PutMapping("/update/{id}")
    public DossierMedicalDTO handleUpdate(@PathVariable long id, @RequestBody DossierMedicalDTO dossierMedicalDTO){
       return dossierMedicalService.updateDossierMedical(id, dossierMedicalDTO);
    }
}
