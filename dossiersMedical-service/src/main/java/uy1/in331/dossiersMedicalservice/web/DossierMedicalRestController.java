package uy1.in331.dossiersMedicalservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uy1.in331.dossiersMedicalservice.dto.DossierMedicalDTO;
import uy1.in331.dossiersMedicalservice.entities.DossierMedical;
import uy1.in331.dossiersMedicalservice.exceptions.DossierMedicalException;
import uy1.in331.dossiersMedicalservice.exceptions.FindByIdNotFoundExeception;
import uy1.in331.dossiersMedicalservice.services.DossierMedicalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dossier-medical")
public class DossierMedicalRestController {
    @Autowired
    private DossierMedicalService dossierMedicalService;
    @GetMapping("/dossiers")
    public List<DossierMedicalDTO> handleFindAll() throws DossierMedicalException {
        List<DossierMedicalDTO> list = dossierMedicalService.getAllDossiersMedicaux();
        System.out.println("***************************************");
        for (DossierMedicalDTO dto:list
             ) {
            System.out.println(dto.toString());
        }
        System.out.println("****************************************");
        return list;
    }
    @GetMapping("get/{id}")
    public Optional<DossierMedical> handlegetOne(@PathVariable long id){
        return  dossierMedicalService.getDossierMedicalById(id);
    }
    @PostMapping("/save")
    public  DossierMedicalDTO handleSaving(@RequestBody DossierMedicalDTO dossierMedicalDTO){
        return  dossierMedicalService.createDossierMedical(dossierMedicalDTO);
    }
    @DeleteMapping("delete/{id}")
    public  void  handleDeleteById(long id) throws FindByIdNotFoundExeception {
        dossierMedicalService.deleteDossierMedical(id);
    }
    @PutMapping("/update/{id}")
    public DossierMedicalDTO handleUpdate(@PathVariable long id, @RequestBody DossierMedicalDTO dossierMedicalDTO){
       return dossierMedicalService.updateDossierMedical(id, dossierMedicalDTO);
    }
}
