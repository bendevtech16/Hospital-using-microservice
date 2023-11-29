package uy1.inf331.patientservice.web;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy1.inf331.patientservice.dto.ConsultationDTO;
import uy1.inf331.patientservice.dto.MedecinDTO;
import uy1.inf331.patientservice.entities.Consultation;
import uy1.inf331.patientservice.exceptions.FindByNameOrPhoneNotFoundExeception;
import uy1.inf331.patientservice.services.ConsultationService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/consultation-service")
public class ConsultationRestController {
    private ConsultationService consultationService;

    @GetMapping("/Consultations")
    public List<ConsultationDTO> findAll(){
        return consultationService.findAll();
    }

    @PostMapping("/saving")
    public  ConsultationDTO handleSave(@RequestBody ConsultationDTO consultationDTO){
        return consultationService.saving(consultationDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void getPatientDTO(Long id) throws FindByNameOrPhoneNotFoundExeception {
        consultationService.deleleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConsultationDTO> handleUpdate(
            @PathVariable long id,
            @RequestBody ConsultationDTO consultationDTO) throws FindByNameOrPhoneNotFoundExeception {
        consultationDTO.setId(id);
        return consultationService.update(id, consultationDTO);
    }
}
