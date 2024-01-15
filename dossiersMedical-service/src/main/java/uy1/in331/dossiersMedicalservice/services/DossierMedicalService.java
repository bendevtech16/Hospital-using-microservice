package uy1.in331.dossiersMedicalservice.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
private  DossierMedicalRepository dossierMedicalRepository;
    @Autowired
private MappeDossierMedical mappeDossierMedical;

    /**
     * returne la liste des dossier medicaux disponibles...
     * @return une liste de DTO
     * @throws DossierMedicalException
     */
    @Override
    public List<DossierMedicalDTO> getAllDossiersMedicaux() throws DossierMedicalException {
        log.info("Obtention de tous les dossiers medicaux...");
        //if (dossierMedicalRepository.findAll() != null){
        List<DossierMedical> dossierMedicals = new ArrayList<>();
            dossierMedicals = dossierMedicalRepository.findAll();
            List<DossierMedicalDTO>dossierMedicalDTOS =new ArrayList<>();
            for (DossierMedical d: dossierMedicals
                 ) {
                DossierMedicalDTO  dossierMedicalDTO = new DossierMedicalDTO();
                dossierMedicalDTO.setId(d.getId());
                dossierMedicalDTO.setNom(d.getNom());
                dossierMedicalDTO.setDiagnostique(d.getDiagnostique());
                dossierMedicalDTO.setAntecedents(d.getAntecedents());
                dossierMedicalDTO.setTraitement(d.getTraitement());
                dossierMedicalDTO.setDateCreation(d.getDateCreation());
                dossierMedicalDTO.setPatientId(d.getPatientId());
                dossierMedicalDTO.setPatient(d.getPatient());
                dossierMedicalDTOS.add(dossierMedicalDTO);
            }
            return dossierMedicalDTOS;
        //}
        /*else {
            System.out.println("************** error **********************");
            throw  new  DossierMedicalException("la liste des dossiers medicaux est vide.");
        }*/
    }

    @Override
    public DossierMedicalDTO getDossierMedicalById(Long id) {
      log.info("fetching dossierMedical...");
      if (dossierMedicalRepository.findById(id)!=null){
          DossierMedical dossierMedical = new DossierMedical();
          dossierMedical = dossierMedicalRepository.findById(id).get();
          DossierMedicalDTO medicalDTO = new DossierMedicalDTO();
          medicalDTO.setId(dossierMedical.getId());
          medicalDTO.setNom(dossierMedical.getNom());
          medicalDTO.setAntecedents(dossierMedical.getAntecedents());
          medicalDTO.setTraitement(dossierMedical.getTraitement());
          medicalDTO.setDiagnostique(dossierMedical.getDiagnostique());
          medicalDTO.setDateCreation(dossierMedical.getDateCreation());
          medicalDTO.setPatient(dossierMedical.getPatient());
          medicalDTO.setPatientId(dossierMedical.getPatientId());
         return medicalDTO;
      }
      else
          throw new RuntimeException("le dossier avec l'identifiant " + id + "est introuvable");
    }

    @Override
    public DossierMedicalDTO createDossierMedical(DossierMedicalDTO dossierMedicalDTO) {
        DossierMedicalDTO medicalDTO = new DossierMedicalDTO();
        medicalDTO.setId(dossierMedicalDTO.getId());
        medicalDTO.setNom(dossierMedicalDTO.getNom());
        medicalDTO.setDateCreation(dossierMedicalDTO.getDateCreation());
        medicalDTO.setDiagnostique(dossierMedicalDTO.getDiagnostique());
        medicalDTO.setTraitement(dossierMedicalDTO.getTraitement());
        medicalDTO.setAntecedents(dossierMedicalDTO.getAntecedents());
        medicalDTO.setPatientId(dossierMedicalDTO.getPatientId());
        medicalDTO.setPatient(dossierMedicalDTO.getPatient());

        DossierMedical dossierMedical1 = new DossierMedical();
        dossierMedical1.setId( medicalDTO.getId());
        dossierMedical1.setNom( medicalDTO.getNom());
        dossierMedical1.setDateCreation( medicalDTO.getDateCreation());
        dossierMedical1.setDiagnostique( medicalDTO.getDiagnostique());
        dossierMedical1.setTraitement( medicalDTO.getTraitement());
        dossierMedical1.setAntecedents( medicalDTO.getAntecedents());
        dossierMedical1.setPatientId( medicalDTO.getPatientId());
        dossierMedical1.setPatient( medicalDTO.getPatient());
        DossierMedical medical = dossierMedicalRepository.save(dossierMedical1);

        DossierMedicalDTO dossierMedicalDTO1 = new DossierMedicalDTO();
        dossierMedicalDTO1.setId(medical.getId());
        dossierMedicalDTO1.setNom(medical.getNom());
        dossierMedicalDTO1.setTraitement(medical.getTraitement());
        dossierMedicalDTO1.setDiagnostique(medical.getDiagnostique());
        dossierMedicalDTO1.setAntecedents(medical.getAntecedents());
        dossierMedicalDTO1.setDateCreation(medical.getDateCreation());
        dossierMedicalDTO1.setPatientId(medical.getPatientId());
        dossierMedicalDTO1.setPatient(medical.getPatient());
        //DossierMedical dossierMedical =mappeDossierMedical.fromDossierMedicalDTO(medicalDTO);
        //DossierMedical dossierMedical1 =dossierMedicalRepository.save(dossierMedical);
        return dossierMedicalDTO1;

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
