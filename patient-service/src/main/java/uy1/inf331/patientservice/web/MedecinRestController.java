package uy1.inf331.patientservice.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.AllArgsConstructor;
import uy1.inf331.patientservice.dto.MedecinDTO;
import uy1.inf331.patientservice.enums.Specialiste;
import uy1.inf331.patientservice.exceptions.FindByNameOrPhoneNotFoundExeception;
import uy1.inf331.patientservice.services.MedecinService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/medecin-service")
@AllArgsConstructor
public class MedecinRestController {
    private final MedecinService medecinService;

    @PostMapping("/medecin/save")
    public MedecinDTO handleSaveMedecin(@RequestBody MedecinDTO medecinDTO){
            return medecinService.saveMedecin(medecinDTO);
    }
    @GetMapping(value = "/medecins")
    public List<MedecinDTO> hanndleFindAllMedecins(){
        return medecinService.getAllMedecins();
     }

     @GetMapping("/medecinSpecialist/{keyWord}")
     public List<MedecinDTO> handlefAllMedecinOfSpecialistWord(@PathVariable Specialiste keyWord){
        return  medecinService.findAllBySpecialist(keyWord);
     }

    @GetMapping("getOne/{id}")
    public Optional<MedecinDTO> handlefindById(@PathVariable long id) {
        return medecinService.handleFindById(id);
    }

    @GetMapping("/search/{name}")
    public  MedecinDTO handleFindByNameDoctor(@PathVariable String name) throws FindByNameOrPhoneNotFoundExeception {
        return medecinService.handlefindByName(name);
    }

    @DeleteMapping("delete/{id}")
    public void deleteMedecinDTO(Long id) throws FindByNameOrPhoneNotFoundExeception {
        medecinService.deleleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MedecinDTO> handleUpdate(
            @PathVariable long id,
            @RequestBody MedecinDTO medecinDTO) throws FindByNameOrPhoneNotFoundExeception {
        medecinDTO.setId(id);
        return medecinService.update(id, medecinDTO);
    }

}