package uy1.inf331.patientservice.web;

import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;


import lombok.AllArgsConstructor;
import uy1.inf331.patientservice.dto.MedecinDTO;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.services.MedecinService;

import java.util.List;

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

}