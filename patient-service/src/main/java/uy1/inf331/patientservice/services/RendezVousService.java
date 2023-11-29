package uy1.inf331.patientservice.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uy1.inf331.patientservice.dto.RendezVousDTO;
import uy1.inf331.patientservice.entities.Consultation;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.entities.Patient;
import uy1.inf331.patientservice.entities.RendezVous;
import uy1.inf331.patientservice.mappers.MapperRendezVous;
import uy1.inf331.patientservice.repository.ConsultationRepository;
import uy1.inf331.patientservice.repository.MedecinRepository;
import uy1.inf331.patientservice.repository.PatientRepository;
import uy1.inf331.patientservice.repository.RendezVousRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Builder
@Slf4j
public class RendezVousService implements IrendezVous {

    private final RendezVousRepository rendezVousRepository;
    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;
    private final ConsultationRepository consultationRepository;

    public RendezVousDTO ajouterRendezVous(RendezVousDTO rendezVousDTO) {
        // Créer une instance de RendezVous à partir du DTO
        RendezVous rendezVous = RendezVous.builder()
                .dateRDV(rendezVousDTO.getDateRDV())
                .build();
        Patient patient = patientRepository.findById(rendezVousDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient non trouvé"));

        // Récupérer le médecin à partir de l'ID
        Medecin medecin = medecinRepository.findById(rendezVousDTO.getMedecinId())
                .orElseThrow(() -> new IllegalArgumentException("Médecin non trouvé"));

        // Créer une instance de Consultation et l'associer au rendez-vous
        Consultation consultation = Consultation.builder()
                .build();
        consultation.setRendezVous(rendezVous);
        consultationRepository.save(consultation);

        // Associer le patient, le médecin et la consultation au rendez-vous
        rendezVous.setPatient(patient);
        rendezVous.setMedecin(medecin);
        rendezVous.setConsultation(consultation);


        // Enregistrer le rendez-vous dans la base de données
        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);

        // Retourner le DTO du rendez-vous enregistré
        return RendezVousDTO.builder()
                .dateRDV(savedRendezVous.getDateRDV())
                .patientId(savedRendezVous.getPatient().getId())
                .medecinId(savedRendezVous.getMedecin().getId())
                .build();
    }

    public void supprimerRendezVous(long rendezVousId) {
        // Vérifier si le rendez-vous existe
        RendezVous rendezVous = rendezVousRepository.findById(rendezVousId)
                .orElseThrow(() -> new IllegalArgumentException("Rendez-vous non trouvé"));

        // Supprimer le rendez-vous de la base de données
        rendezVousRepository.delete(rendezVous);
    }

    public RendezVousDTO modifierRendezVous(long rendezVousId, RendezVousDTO rendezVousDTO) {
        // Vérifier si le rendez-vous existe
        RendezVous rendezVous = rendezVousRepository.findById(rendezVousId)
                .orElseThrow(() -> new IllegalArgumentException("Rendez-vous non trouvé"));

        // Mettre à jour les informations du rendez-vous à partir du DTO
        rendezVous.setDateRDV(rendezVousDTO.getDateRDV());

        // Enregistrer les modifications dans la base de données
        RendezVous updatedRendezVous = rendezVousRepository.save(rendezVous);

        // Retourner le DTO du rendez-vous mis à jour
        return RendezVousDTO.builder()
                .dateRDV(updatedRendezVous.getDateRDV())
                .patientId(updatedRendezVous.getPatient().getId())
                .medecinId(updatedRendezVous.getMedecin().getId())
                .build();
    }

    public List<RendezVousDTO> recupererListeRendezVous() {
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();

        // Convertir la liste des rendez-vous en une liste de DTO
        List<RendezVousDTO> rendezVousDTOList = rendezVousList.stream()
                .map(rendezVous -> RendezVousDTO.builder()
                        .id(rendezVous.getId())
                        .dateRDV(rendezVous.getDateRDV())
                        .patientId(rendezVous.getPatient().getId())
                        .medecinId(rendezVous.getMedecin().getId())
                        .build())
                .collect(Collectors.toList());

        return rendezVousDTOList;
    }
    public RendezVousDTO rechercherRendezVous(long rendezVousId) {
        // Rechercher le rendez-vous par son identifiant
        RendezVous rendezVous = rendezVousRepository.findById(rendezVousId)
                .orElseThrow(() -> new IllegalArgumentException("Rendez-vous non trouvé"));

        // Créer un DTO à partir du rendez-vous trouvé
        RendezVousDTO rendezVousDTO = RendezVousDTO.builder()
                .id(rendezVous.getId())
                .dateRDV(rendezVous.getDateRDV())
                .patientId(rendezVous.getPatient().getId())
                .medecinId(rendezVous.getMedecin().getId())
                .build();

        return rendezVousDTO;
    }


}
