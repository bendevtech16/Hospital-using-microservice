package uy1.inf331.patientservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.AllArgsConstructor;

import uy1.inf331.patientservice.repository.MedecinRepository;
import uy1.inf331.patientservice.repository.PatientRepository;

@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
@AllArgsConstructor
public class PatientServiceApplication {

	private PatientRepository patientRepository;
	private MedecinRepository medecinRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientServiceApplication.class, args);
	}

}
