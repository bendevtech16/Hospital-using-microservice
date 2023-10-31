package uy1.inf331.patientservice.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import uy1.inf331.patientservice.dto.MedecinDTO;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.services.MedecinService;

@RestController
@RequestMapping("/medecin-service")
@AllArgsConstructor
public class MedecinRestController {
    private final MedecinService medecinService;

    @PostMapping("/save")
    public MedecinDTO handleSaveMedecin(@RequestBody MedecinDTO medecinDTO){
            return medecinService.saveMedecin(medecinDTO);
    }
}