package de.ibw.tms.entities;

import de.ibw.main.SmartLogicClient;

import de.motis.producer.MotisProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories()
public class TmsJpaApp {

	private static final Logger log = LoggerFactory.getLogger(TmsJpaApp.class);

	public static void main(String[] args) {
		SpringApplication.run(TmsJpaApp.class);
	}

	@Bean
	public MotisProducer getMotisProducer() {
		return new MotisProducer();
	}


	@Bean
	public CommandLineRunner TmsRunner(TimeTaskRepository repository, MotisProducer M) {
		return (args) -> {
			SmartLogicClient.MotisProducer = M;
			SmartLogicClient.proceedTmsLogic(repository);


			log.info("Finished");
			while (true);




		};
	}

	public void printPermission(CheckMovementPermissionDAO P) {
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
