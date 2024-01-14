package uy1.in331.dossiersMedicalservice.services;

import uy1.in331.dossiersMedicalservice.dto.DossierMedicalDTO;
import uy1.in331.dossiersMedicalservice.entities.DossierMedical;
import uy1.in331.dossiersMedicalservice.exceptions.DossierMedicalException;
import uy1.in331.dossiersMedicalservice.exceptions.FindByIdNotFoundExeception;

import java.util.List;
import java.util.Optional;

public interface InterfaceDossierMedical {
    List<DossierMedicalDTO> getAllDossiersMedicaux() throws DossierMedicalException;
    Optional<DossierMedical> getDossierMedicalById(Long id);
    DossierMedicalDTO createDossierMedical(DossierMedicalDTO dossierMedicalDTO);
    DossierMedicalDTO updateDossierMedical(Long id, DossierMedicalDTO dossierMedicalDTO);
    void deleteDossierMedical(Long id) throws FindByIdNotFoundExeception;
}
