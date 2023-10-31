package uy1.inf331.patientservice.web;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import uy1.inf331.patientservice.dto.PatientDTO;
import uy1.inf331.patientservice.entities.Patient;
import uy1.inf331.patientservice.exceptions.FindByNameOrPhoneNotFoundExeception;
import uy1.inf331.patientservice.exceptions.NoSavingException;
import uy1.inf331.patientservice.exceptions.PatientListNotFoundException;
import uy1.inf331.patientservice.services.PatientServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/service-patient")
public class PatientRestController {
    private final PatientServiceImpl patientServiceImpl;
    /**
     * returne la liste des patients
     *
     * @return return la liste des patient en Dto
     * @throws PatientListNotFoundException
     */
    @GetMapping(value = "/patients")
    public List<PatientDTO> findAllPatient() throws PatientListNotFoundException {

        return patientServiceImpl.getAllPatients();
    }

    /**
     * get dto , convert in to patient , get saving entity patient an reconvert dto
     * to
     * retun dto
     *
     * @param patientDTO
     * @return
     * @throws NoSavingException
     */
    @PostMapping("/save")
    public PatientDTO savingPatient(@RequestBody PatientDTO patientDTO) {

        System.out.println(patientDTO.toString());
        return patientServiceImpl.savePatient(patientDTO);
//        return patientServiceImpl.savePatient(patientDTO);

    }

    @DeleteMapping("delete/{id}")
    public void getPatientDTO(Long id) throws FindByNameOrPhoneNotFoundExeception {

        patientServiceImpl.deleleteById(id);
    }

    @GetMapping("search/{id}")
    public Optional<Patient> handlefindById(@PathVariable long id) {

        return patientServiceImpl.handleFindById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientDTO> handleUpdate(
            @PathVariable long id,
            @RequestBody PatientDTO patientDTO) throws FindByNameOrPhoneNotFoundExeception {
            patientDTO.setId(id);
        return patientServiceImpl.update(id, patientDTO);
    }

    @GetMapping("pastientsList/{keyName}")
    public List<PatientDTO> handleListByKeyName(@PathVariable String keyName) {
        return patientServiceImpl.trouverPatientsParMotCle(keyName);
    }

    @GetMapping("/phones/{phone}")
    public PatientDTO handleFindByPhone(@PathVariable String phone) throws FindByNameOrPhoneNotFoundExeception {
        return patientServiceImpl.findByPhone(phone);
    }
}