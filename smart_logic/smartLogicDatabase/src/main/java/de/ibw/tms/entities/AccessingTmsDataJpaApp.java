package de.ibw.tms.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class AccessingTmsDataJpaApp {

	private static final Logger log = LoggerFactory.getLogger(AccessingTmsDataJpaApp.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingTmsDataJpaApp.class);
	}


	@Bean
	public PermissionRepository getPermissionRepo(PermissionRepository repository) {
		return repository;
	}


	public CommandLineRunner demo(PermissionRepository repository) {
		return (args) -> {


			for(CheckMovmentPermissionDAO P : repository.findAll()) {
				printPermission(P);
			}

			log.info("Finished");
			while (true);



			// save a few customers

			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }

		};
	}

	public void printPermission(CheckMovmentPermissionDAO P) {
		log.info("P: " + P.getId());
		log.info(P.CommandType);
		log.info(P.rbc_id);
		log.info(P.tms_id);
		log.info(String.valueOf(P.lPriority));

		log.info(String.valueOf(P.iTrainId));
		log.info(String.valueOf(P.uuid));
		log.info(P.MaAdapter.getId());
		log.info(P.route.getId());
	}

}
