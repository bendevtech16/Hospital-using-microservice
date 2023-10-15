package cm.uy1.patientservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cm.uy1.patientservice.entities.Patient;
import cm.uy1.patientservice.service.PatientImpl;

@SpringBootApplication
public class PatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(PatientImpl patientImpl) {
		return args -> {
			Patient patient = new Patient(0, "benkpro", "12eme rue yaounde", "675453442", 34);
			patientImpl.savePatient(patient);
			Patient patient2 = new Patient(1, "benkpro", "Rue 16 yaounde", "675453442", 34);
			patientImpl.savePatient(patient2);
			Patient patient3 = new Patient(9, "toro", "obala", "675453442", 34);
			patientImpl.savePatient(patient3);
			Patient patient5 = new Patient(8, "pro", "12eme rue yaounde", "675453442", 34);
			patientImpl.savePatient(patient5);

		};
	}

}
