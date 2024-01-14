package uy1.in331.dossiersMedicalservice.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uy1.in331.dossiersMedicalservice.dto.DossierMedicalDTO;
import uy1.in331.dossiersMedicalservice.entities.DossierMedical;
import uy1.in331.dossiersMedicalservice.exceptions.DossierMedicalException;
import uy1.in331.dossiersMedicalservice.exceptions.FindByIdNotFoundExeception;
import uy1.in331.dossiersMedicalservice.mappers.MappeDossierMedical;
import uy1.in331.dossiersMedicalservice.repository.DossierMedicalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Slf4j
@Service
public class DossierMedicalService implements  InterfaceDossierMedical{
private  DossierMedicalRepository dossierMedicalRepository;
private MappeDossierMedical mappeDossierMedical;

    /**
     * returne la liste des dossier medicaux disponibles...
     * @return une liste de DTO
     * @throws DossierMedicalException
     */
    @Override
    public List<DossierMedicalDTO> getAllDossiersMedicaux() throws DossierMedicalException {
        log.info("Obtention de tous les dossiers medicaux...");
        if (dossierMedicalRepository.findAll() != null){
            List<DossierMedical> dossierMedicals = dossierMedicalRepository.findAll();
            List<DossierMedicalDTO>dossierMedicalDTOS =new ArrayList<>();
            for (DossierMedical doss: dossierMedicals
                 ) {
                DossierMedicalDTO  dossierMedicalDTO = new DossierMedicalDTO();
                dossierMedicalDTO.setId(doss.getId());
                dossierMedicalDTO.setNom(doss.getNom());
                dossierMedicalDTO.setDateCreation(doss.getDateCreation());
                dossierMedicalDTO.setDiagnostique(doss.getDiagnostique());
                dossierMedicalDTO.setAntecedents(doss.getAntecedents());
                dossierMedicalDTO.setTraitement(doss.getTraitement());
                dossierMedicalDTO.setPatientId(doss.getPatientId());
                dossierMedicalDTO.setPatient(doss.getPatient());
                //dossierMedicalDTO = mappeDossierMedical.fromDossierMedical(doss);
                dossierMedicalDTOS.add(dossierMedicalDTO);

            }
            return dossierMedicalDTOS;
        }
        else {
            throw  new  DossierMedicalException("la liste des dossiers medicaux est vide.");
        }
    }

    @Override
    public Optional<DossierMedical> getDossierMedicalById(Long id) {
      log.info("fetching dossierMedical...");
      if (dossierMedicalRepository.findById(id).isPresent()){
         return dossierMedicalRepository.findById(id);
      }
      else
          throw new RuntimeException("le dossier avec l'identifiant " + id + "est introuvable");
    }

    @Override
    public DossierMedicalDTO createDossierMedical(DossierMedicalDTO dossierMedicalDTO) {
        DossierMedicalDTO medicalDTO = new DossierMedicalDTO();
        medicalDTO = dossierMedicalDTO;
        DossierMedical dossierMedical =mappeDossierMedical.fromDossierMedicalDTO(medicalDTO);
        DossierMedical dossierMedical1 =dossierMedicalRepository.save(dossierMedical);
        return mappeDossierMedical.fromDossierMedical(dossierMedical1);

    }

    @Override
    public DossierMedicalDTO updateDossierMedical(Long id, DossierMedicalDTO dossierMedicalDTO) {
        DossierMedical existingDossierMedical = dossierMedicalRepository.findById(id).orElse(null);
        if (existingDossierMedical != null){
            DossierMedicalDTO dossierMedicalDTO1 = new DossierMedicalDTO();
            dossierMedicalDTO1 = dossierMedicalDTO;
            DossierMedical dossierMedical = mappeDossierMedical.fromDossierMedicalDTO(dossierMedicalDTO1);
            existingDossierMedical.setNom(dossierMedical.getNom());
            existingDossierMedical.setAntecedents(dossierMedical.getAntecedents());
            existingDossierMedical.setTraitement(dossierMedical.getTraitement());
            existingDossierMedical.setDateCreation(dossierMedical.getDateCreation());
            existingDossierMedical.setDiagnostique(dossierMedical.getDiagnostique());
            existingDossierMedical.setPatient(dossierMedical.getPatient());
            existingDossierMedical.setPatientId(dossierMedical.getPatientId());
            DossierMedical dossierMedicalEnregistrer = new DossierMedical();
            dossierMedicalEnregistrer =dossierMedicalRepository.save(existingDossierMedical);
        }
        return mappeDossierMedical.fromDossierMedical(existingDossierMedical) ;
    }

    @Override
    public void deleteDossierMedical(Long id) throws FindByIdNotFoundExeception {
        log.info("dossierMedical Deleting...");
        if (id != null)
            dossierMedicalRepository.deleteById(id);
        else
            throw new FindByIdNotFoundExeception(" patient" + id + "non existant");
    }
}
