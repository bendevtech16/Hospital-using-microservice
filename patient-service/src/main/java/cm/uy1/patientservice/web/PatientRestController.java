package cm.uy1.patientservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cm.uy1.patientservice.entities.Patient;
import cm.uy1.patientservice.service.PatientImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PatientRestController {
    private PatientImpl patientImpl;

    @GetMapping("/patients")
    public List<Patient> patientList() {
        return patientImpl.findAllPatient();
    }

}