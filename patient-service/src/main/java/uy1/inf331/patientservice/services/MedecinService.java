package uy1.inf331.patientservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import uy1.inf331.patientservice.dto.MedecinDTO;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.enums.Specialiste;
import uy1.inf331.patientservice.exceptions.FindByNameOrPhoneNotFoundExeception;
import uy1.inf331.patientservice.mappers.MapperMedecin;
import uy1.inf331.patientservice.repository.MedecinRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
public class MedecinService implements Imedecin {
    private MedecinRepository medecinRepository;
    private MapperMedecin mapperMedecin;

    public MedecinDTO saveMedecin(MedecinDTO medecinDTO) {
        log.info("Saving Medecin in progress...");
        Medecin medecin = mapperMedecin.fromMedecinDTO(medecinDTO);
        return mapperMedecin.fromMedecin(Optional.of(medecinRepository.save(medecin)));
    }

    public List<MedecinDTO> getAllMedecins() {
        log.info("getting all medecin in progress...");
        List<Medecin> medecinList = new ArrayList<>();
        List<MedecinDTO> medecinDTOList = new ArrayList<>();
        medecinList = medecinRepository.findAll();
        for (Medecin m : medecinList) {
            MedecinDTO medecinDTO = mapperMedecin.fromMedecin(Optional.ofNullable(m));
            medecinDTOList.add(medecinDTO);
        }
        return medecinDTOList;
    }

    public List<MedecinDTO> findAllBySpecialist(Specialiste specialite) {
        log.info("getting medecin from one specialist");
        List<Medecin> medecinList = new ArrayList<>();
        List<MedecinDTO> medecinDTOList = new ArrayList<>();

        medecinList = medecinRepository.findBySpecialistContaining(specialite);
        for (Medecin m : medecinList) {
            MedecinDTO medecinDTO = mapperMedecin.fromMedecin(Optional.ofNullable(m));
            medecinDTOList.add(medecinDTO);
        }
        return medecinDTOList;
    }



    public Optional<MedecinDTO> handleFindById(long id) {
        Optional<Medecin> medecin = Optional.of(new Medecin());
        log.info("Finding doctor...");
        if (medecinRepository.findById(id).isPresent()) {
            medecin = medecinRepository.findById(id);
            return Optional.ofNullable(mapperMedecin.fromMedecin(medecin));
        } else
            throw new RuntimeException("le medecin avec l'identifiant " + id + "est introuvable");
    }

    public MedecinDTO handlefindByName(String name) throws FindByNameOrPhoneNotFoundExeception {
        log.info("medecin finding in progress...");
        Medecin medecin = new Medecin();
        if (name != null) {
            medecin = medecinRepository.findByName(name);
            return mapperMedecin.fromMedecin(Optional.ofNullable(medecin));
        } else
            throw new FindByNameOrPhoneNotFoundExeception("medecin non trouvé");
    }

    /**
     * @param id id du medecin suprimer
     * @throws FindByNameOrPhoneNotFoundExeception l'exection generer en cas de
     *                                             soucis
     *                                             elle ne retoune rien
     */
    public void deleleteById(Long id) throws FindByNameOrPhoneNotFoundExeception {
        log.info("Medecin Deleting...");
        if (id != null)
            medecinRepository.deleteById(id);
        else
            throw new FindByNameOrPhoneNotFoundExeception(" Medecin" + id + "non existant");
    }

    /**
     * methode pour modifirer un patient
     *
     * @param id             id du patien a modifier
     * @param medecinModifieDTO nouveau patient a remplacer
     * @return returne le patient modifie
     * @throws FindByNameOrPhoneNotFoundExeception
     */
    public ResponseEntity<MedecinDTO> update(long id, MedecinDTO medecinModifieDTO)
            throws FindByNameOrPhoneNotFoundExeception {
        log.info("Medecin Updating...");
        Optional<Medecin> optionalMedecin = medecinRepository.findById(id);
        if (optionalMedecin.isPresent()) {
            Medecin medecin = optionalMedecin.get();
            medecin.setId(id);
            medecin.setSpecialiste(medecinModifieDTO.getSpecialiste());
            medecin.setEmail(medecinModifieDTO.getEmail());
            medecin.setTelephone(medecinModifieDTO.getTelephone());
            medecin.setName(medecinModifieDTO.getName());

            Medecin medecinEnregistrer = medecinRepository.save(medecin);
            MedecinDTO medecinDTO = mapperMedecin.fromMedecin(Optional.of(medecinEnregistrer));
            return ResponseEntity.ok(medecinDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
