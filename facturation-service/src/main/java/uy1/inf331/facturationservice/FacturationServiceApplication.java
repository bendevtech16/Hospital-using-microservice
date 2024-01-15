package uy1.inf331.facturationservice;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import uy1.inf331.facturationservice.clients.PatientRestClient;
import uy1.inf331.facturationservice.entities.Facturation;
import uy1.inf331.facturationservice.repository.FacturationRepository;

@EnableFeignClients
@SpringBootApplication
public class FacturationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FacturationRepository facturationRepository, PatientRestClient patientRestClient) {
		return args -> {
		patientRestClient.allPatient().forEach(patient->{
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
				facturationRepository.save(Facturation.builder()
						.createdAt(LocalDate.now())
						.id(null)
						.montant(Math.random()*80000)
						.patientId(patient.getId())
						.build());
			});
		};
	}
}
