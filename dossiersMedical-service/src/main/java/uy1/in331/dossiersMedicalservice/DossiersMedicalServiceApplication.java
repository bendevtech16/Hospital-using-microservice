package uy1.in331.dossiersMedicalservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import uy1.in331.dossiersMedicalservice.client.PatientRestClient;
import uy1.in331.dossiersMedicalservice.entities.DossierMedical;
import uy1.in331.dossiersMedicalservice.repository.DossierMedicalRepository;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
public class DossiersMedicalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DossiersMedicalServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(DossierMedicalRepository dossierMedicalRepository, PatientRestClient patientRestClient) {
	return  args -> {
		patientRestClient.allPatient().forEach(patient->{
			dossierMedicalRepository.save(DossierMedical.builder()
				.dateCreation(LocalDate.now())
				.nom("tchuente togola")
				.antecedents("vos antecedents")
				.diagnostique("le diagnostique est negatif")
				.traitement("le paludisme et typhoide")
				.patientId(patient.getId())
				.build());
			dossierMedicalRepository.save(DossierMedical.builder()
					.dateCreation(LocalDate.now())
					.nom("patrice ngueyap")
					.antecedents("presence d'une fievre typhoide")
					.diagnostique("le diagnostique mitige")
					.traitement("lorem ipsum dolor amet")
					.patientId(patient.getId())
					.build());
			dossierMedicalRepository.save(DossierMedical.builder()
					.dateCreation(LocalDate.now())
					.nom("tounkap jeanno")
					.antecedents("R.A.S")
					.diagnostique("Aucun resultat")
					.traitement("lorem ipsum dolor amet")
					.patientId(patient.getId())
					.build());
			dossierMedicalRepository.save(DossierMedical.builder()
					.dateCreation(LocalDate.now())
					.nom("george bouche")
					.antecedents("presence d'une fievre typhoide, presence d'une molecule non hydratente")
					.diagnostique("le diagnostique accomplie a 95%")
					.traitement("rougeole, paludisme, hepatite")
					.patientId(patient.getId())
					.build());
			dossierMedicalRepository.save(DossierMedical.builder()
					.dateCreation(LocalDate.now())
					.nom("tounde jean")
					.antecedents("allergique d'anana")
					.diagnostique("12kal de protide, 11kal de glucide")
					.traitement("consommation de la pasteque...")
					.patientId(patient.getId())
					.build());
		    });
	 };
	}
}

