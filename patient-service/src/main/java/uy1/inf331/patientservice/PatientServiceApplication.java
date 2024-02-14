package uy1.inf331.patientservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.AllArgsConstructor;

import uy1.inf331.patientservice.config.GlobalConfig;
import uy1.inf331.patientservice.entities.Medecin;
import uy1.inf331.patientservice.entities.Patient;
import uy1.inf331.patientservice.enums.Specialiste;
import uy1.inf331.patientservice.repository.MedecinRepository;
import uy1.inf331.patientservice.repository.PatientRepository;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
@EnableTransactionManagement
@EnableAutoConfiguration
@AllArgsConstructor
public class PatientServiceApplication {

	private PatientRepository patientRepository;
	private MedecinRepository medecinRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientServiceApplication.class, args);
	}

		@Bean
	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository) {
		return args -> {
			patientRepository.save(Patient.builder()
					.name("benjamin ohandja")
					.email("bohandja16@gmail.com")
					.age(25)
					.telephone("677574775") 
					.build());

			patientRepository.save(Patient.builder()
					.name("francis nga")
					.email("kajai@gmail.com")
					.age(34)
					.telephone("689096789")
					.build());

			patientRepository.save(Patient.builder()
					.name("prosper-kamjou")
					.email("joel-bean@gmail.com")
					.age(13)
					.telephone("674173898")
					.build());

			patientRepository.save(Patient.builder()
					.name("virus de luxe")
					.email("virus5@gmail.com")
					.age(25)
					.telephone("687456789")
					.build());

			patientRepository.save(Patient.builder()
					.name("ebola magne")
					.email("eloboebola@gmail.com")
					.age(34)
					.telephone("683907722")
					.build());

			patientRepository.save(Patient.builder()
					.name("veratty duplex b")
					.email("duplex-pro@gmail.com")
					.age(13)
					.telephone("672224455")
					.build());

			medecinRepository.save(Medecin.builder()
					.name("Dr jean")
					.email("jeaen@gmail.com")
					.telephone("624567898")
					.specialiste(Specialiste.OPHTAMOLOGUE)
					.build());

			medecinRepository.save(Medecin.builder()
					.name("Dr KENMOGNE JOEL")
					.email("kenmogneJoel@gmail.com")
					.telephone("624567890")
					.specialiste(Specialiste.anatomie)
					.build());

			medecinRepository.save(Medecin.builder()
					.name("Dr ONGBA marie ")
					.email("ongbamarie@gmail.com")
					.telephone("624566898")
					.specialiste(Specialiste.allergologie)
					.build());

			medecinRepository.save(Medecin.builder()
					.name("Dr mekeutiboua tafeutsop")
					.email("mekeutiboua@gmail.com")
					.telephone("6245567458")
					.specialiste(Specialiste.chirurgie)
					.build());
		};
	}

}
