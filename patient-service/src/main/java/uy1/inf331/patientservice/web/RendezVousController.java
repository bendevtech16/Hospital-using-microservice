package uy1.inf331.patientservice.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy1.inf331.patientservice.dto.RendezVousDTO;
import uy1.inf331.patientservice.services.RendezVousService;

@RestController
@AllArgsConstructor
@RequestMapping("/rendezVous")
public class RendezVousController {
    private RendezVousService rendezVousService;

    @PostMapping("/savingRDV")
    public RendezVousDTO handleSaving(@RequestBody RendezVousDTO rendezVousDTO){
        return  rendezVousService.savingRDV(rendezVousDTO);
    }
}
