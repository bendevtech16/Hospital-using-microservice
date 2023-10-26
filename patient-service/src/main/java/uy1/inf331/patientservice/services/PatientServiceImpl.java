package uy1.inf331.patientservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import uy1.inf331.patientservice.dto.PatientDTO;
import uy1.inf331.patientservice.entities.Patient;
import uy1.inf331.patientservice.exceptions.FindByNameOrPhoneNotFoundExeception;
import uy1.inf331.patientservice.exceptions.PatientListNotFoundException;
import uy1.inf331.patientservice.mappers.MapperPatient;
import uy1.inf331.patientservice.repository.PatientRepository;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
public class PatientServiceImpl implements Ipatient {
    private PatientRepository patientRepository;
    private MapperPatient mapperPatient;

    /**
     * cette methode retourne ula listee des patient disponible
     * 
     * @param patientRepository
     * @return get all patient
     */
    @Override
    public List<PatientDTO> getAllPatients() throws PatientListNotFoundException {
        log.info("get All Patients...");
        if (patientRepository.findAll() != null) {
            List<Patient> patients = new ArrayList();
            patients = patientRepository.findAll();
            List<PatientDTO> patientDtos = new ArrayList();
            for (Patient p : patients) {
                PatientDTO dto = new PatientDTO();
                dto = mapperPatient.fromPatient(p);
                patientDtos.add(dto);
            }
            return patientDtos;

        } else {
            throw new PatientListNotFoundException("aucun patient trouve");
        }

    }

    public Optional<Patient> handleFindById(long id) {
        log.info("Finding Patient...");
        if (patientRepository.findById(id) != null) {
            return patientRepository.findById(id);
        } else
            throw new RuntimeException("le patient avec l'identifiant " + id + "est introuvable");

    }

    /**
     * 
     * @param patientDTO le patient a enregistrer
     * @return patient saved in database
     *         on recuperere un dto et on le convertit en entite patient et on save
     *         puis
     *         on recuperere le patient sauvegarder et reconvertit en dto
     */
    public PatientDTO savePatient(PatientDTO patientDTO) {
        log.info("Saving Ptient...");
        Patient patient2 = mapperPatient.fromPatientDTO(patientDTO);
        Patient patient3 = patientRepository.save(patient2);
        return mapperPatient.fromPatient(patient3);
    }

    /**
     * recherche un patien par son nom.
     * 
     * @param name le parametre de recherche du patient
     * @return returne le patient s'il existe.
     * @throws FindByNameOrPhoneNotFoundExeception exeception generee en cas de
     *                                             soucis.
     */
    public Patient findByName(String name) throws FindByNameOrPhoneNotFoundExeception {
        if (name != null)
            return patientRepository.findByName(name);
        else
            throw new FindByNameOrPhoneNotFoundExeception("patient non trouvé");
    }

    /**
     * recherche une patiet pas phone
     * 
     * @param phone le numero de telephone du patient a rechercher.
     * @return return un patient si il existe
     * @throws FindByNameOrPhoneNotFoundExeception genere une exception en cas de
     *                                             soucis de non disponibilite
     */
    public PatientDTO findByPhone(String phone) throws FindByNameOrPhoneNotFoundExeception {

        if (phone != null) {
            Patient patient = patientRepository.findByTelephone(phone);
            PatientDTO patientDTO = mapperPatient.fromPatient(patient);
            return patientDTO;
        }

        else
            throw new FindByNameOrPhoneNotFoundExeception("patient non trouvé");
    }

    /**
     * 
     * @param id id du patient a suprimer
     * @throws FindByNameOrPhoneNotFoundExeception l'exection generer en cas de
     *                                             soucis
     *                                             elle ne retoune rien
     */
    public void deleleteById(Long id) throws FindByNameOrPhoneNotFoundExeception {
        log.info("Patient Deleting...");
        if (id != null)
            patientRepository.deleteById(id);
        else
            throw new FindByNameOrPhoneNotFoundExeception(" patient" + id + "non existant");
    }

    /**
     * methode pour modifirer un patient
     * 
     * @param id             id du patien a modifier
     * @param patientModifie nouveau patient a remplacer
     * @return returne le patient modifie
     * @throws FindByNameOrPhoneNotFoundExeception
     */
    public ResponseEntity<PatientDTO> update(long id, PatientDTO patientModifieDTO)
            throws FindByNameOrPhoneNotFoundExeception {
        log.info("Patient Updating...");
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setId(id);
            patient.setId(patientModifieDTO.getId());
            patient.setAge(patientModifieDTO.getAge());
            patient.setEmail(patientModifieDTO.getEmail());
            patient.setTelephone(patientModifieDTO.getTelephone());
            patient.setName(patientModifieDTO.getName());

            Patient patientEnregistrer = patientRepository.save(patient);
            PatientDTO patientDTO = mapperPatient.fromPatient(patientEnregistrer);
            return ResponseEntity.ok(patientDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * return la liste des patient dont leur nom contient un motcles
     * 
     * @param motCle le mot cle a rechercher
     * @return returne la liste des patients contenant le motCles.
     */
    public List<PatientDTO> trouverPatientsParMotCle(String motCle) {
        List<Patient> listPatients = new ArrayList<Patient>();
        List<PatientDTO> listDtos = new ArrayList();
        listPatients = patientRepository.findByNameContaining(motCle);
        for (Patient p : listPatients) {
            PatientDTO patientDTO = mapperPatient.fromPatient(p);
            listDtos.add(patientDTO);
        }
        return listDtos;
    }

}