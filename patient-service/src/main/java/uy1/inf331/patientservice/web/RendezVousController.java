package uy1.inf331.patientservice.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uy1.inf331.patientservice.dto.RendezVousDTO;
import uy1.inf331.patientservice.services.RendezVousService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rendezVous")
public class RendezVousController {
    private RendezVousService rendezVousService;

    @PostMapping("/saveRDV")
    public RendezVousDTO ajouterRendezVous(@RequestBody RendezVousDTO rendezVousDTO) {
        return rendezVousService.ajouterRendezVous(rendezVousDTO);
    }

    @DeleteMapping("/deleteOneRDV/{rendezVousId}")
    public void supprimerRendezVous(@PathVariable long rendezVousId) {
        rendezVousService.supprimerRendezVous(rendezVousId);
    }

    @PutMapping("/{rendezVousId}")
    public RendezVousDTO modifierRendezVous(@PathVariable long rendezVousId, @RequestBody RendezVousDTO rendezVousDTO) {
        return rendezVousService.modifierRendezVous(rendezVousId, rendezVousDTO);
    }

    @GetMapping("/rendezVousList")
    public List<RendezVousDTO> recupererListeRendezVous() {
        return rendezVousService.recupererListeRendezVous();
    }

    @GetMapping("/getOneRDV/{rendezVousId}")
    public RendezVousDTO rechercherRendezVous(@PathVariable long rendezVousId) {
        return rendezVousService.rechercherRendezVous(rendezVousId);
    }
}
