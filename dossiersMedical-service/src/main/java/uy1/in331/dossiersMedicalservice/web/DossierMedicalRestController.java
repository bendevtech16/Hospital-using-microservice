package uy1.in331.dossiersMedicalservice.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;
import uy1.in331.dossiersMedicalservice.client.PatientRestClient;
import uy1.in331.dossiersMedicalservice.dto.DossierMedicalDTO;
import uy1.in331.dossiersMedicalservice.exceptions.DossierMedicalException;
import uy1.in331.dossiersMedicalservice.exceptions.FindByIdNotFoundExeception;
import uy1.in331.dossiersMedicalservice.model.Patient;
import uy1.in331.dossiersMedicalservice.services.DossierMedicalService;

import java.util.List;


@RestController
@EnableFeignClients
@AllArgsConstructor
@RequestMapping("/dossier-medical")
public class DossierMedicalRestController {
    @Autowired
    private DossierMedicalService dossierMedicalService;
    @Autowired
    private PatientRestClient patientRestClient;

    /**
     *
     * @return la liste des dossiers medicaux...
     * @throws DossierMedicalException
     */
    @GetMapping("/dossiers")
    public List<DossierMedicalDTO> handleFindAll() throws DossierMedicalException {
        List<DossierMedicalDTO> list = dossierMedicalService.getAllDossiersMedicaux();
        list.forEach(dossierMedicalDTO -> {
            dossierMedicalDTO.setPatient(patientRestClient.findPatientById(dossierMedicalDTO.getPatientId()));
        });
        return list;
    }

    /**
     * returne un dossier medical par id...
     * @param id
     * @return
     */
    @GetMapping("/dossiers/{id}")
    public DossierMedicalDTO handlegetOne(@PathVariable long id){
        DossierMedicalDTO dossierMedicalDTO =dossierMedicalService.getDossierMedicalById(id);
        Patient patient = patientRestClient.findPatientById(dossierMedicalDTO.getPatientId());
        dossierMedicalDTO.setPatient(patient);
        return dossierMedicalDTO;
    }
    @PostMapping("/save")
    public  DossierMedicalDTO handleSaving(@RequestBody DossierMedicalDTO dossierMedicalDTO){
        Patient patient =patientRestClient.findPatientById(dossierMedicalDTO.getPatientId());
        dossierMedicalDTO.setPatient(patient);
        return  dossierMedicalService.createDossierMedical(dossierMedicalDTO);
    }
    /**
     * supression du dossier medical par id.
     * @param id
     * @throws FindByIdNotFoundExeception
     */
    @DeleteMapping("/delete/{id}")
    public  void  handleDeleteById(long id) throws FindByIdNotFoundExeception {
        dossierMedicalService.deleteDossierMedical(id);
    }

    /**
     * la mise a jour  du  dossier medical...
     * @param id
     * @param dossierMedicalDTO
     * @return
     */
    @PutMapping("/update/{id}")
    public DossierMedicalDTO handleUpdate(@PathVariable long id, @RequestBody DossierMedicalDTO dossierMedicalDTO){
       return dossierMedicalService.updateDossierMedical(id, dossierMedicalDTO);
    }
}
