package uy1.inf331.facturationservice;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import uy1.inf331.facturationservice.entities.Facturation;
import uy1.inf331.facturationservice.repository.FacturationRepository;

@SpringBootApplication
public class FacturationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FacturationRepository facturationRepository) {
		return args -> {
			facturationRepository.save(Facturation.builder()
					.createdAt(LocalDate.now())
					.id(null)
					.montant(2500.0)
					.patientId((long) 2)
					.build());
			facturationRepository.save(Facturation.builder()
					.createdAt(LocalDate.now())
					.id(null)
					.montant(4500.0)
					.patientId((long) 1)
					.build());
			facturationRepository.save(Facturation.builder()
					.createdAt(LocalDate.now())
					.id(null)
					.montant(8500.0)
					.patientId((long) 3)
					.build());
			facturationRepository.save(Facturation.builder()
					.createdAt(LocalDate.now())
					.id(null)
					.montant(24580.0)
					.patientId((long) 4)
					.build());
			facturationRepository.save(Facturation.builder()
					.createdAt(LocalDate.now())
					.id(null)
					.montant(10080.0)
					.patientId((long) 5)
					.build());
			facturationRepository.save(Facturation.builder()
					.createdAt(LocalDate.now())
					.id(null)
					.montant(25080.0)
					.patientId((long) 5)
					.build());
		};
	}
}
