package de.ibw.tms.entities;

import de.ibw.main.MotisManager;
import de.ibw.main.SmartLogicClient;

import de.motis.config.TmsConfig;
import de.motis.producer.MotisProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;


@SpringBootApplication
@EnableJpaRepositories()
public class TmsJpaApp {

	private static final Logger log = LoggerFactory.getLogger(TmsJpaApp.class);

	public static TmsConfig Config;

	public static void main(String[] args) {
		SpringApplication.run(TmsJpaApp.class);
	}



	@Bean
	public TmsConfig getTmsConfig() {
		return new TmsConfig();
	}

	@Bean
	public MotisProducer getMotisProducer() {
		return new MotisProducer();
	}


	@Bean
	public CommandLineRunner TmsRunner(TimeTaskRepository repository, MotisProducer M, TmsConfig C ) {
		return (args) -> {
			TmsJpaApp.Config = C;
			SmartLogicClient.MotisProducer = M;
			SmartLogicClient.proceedTmsLogic(repository);

			log.info("TMS is up");
			log.info("TMS send planed Train-Timetable");
			sendTrainTimeTable();
			log.info("Time-Table send");

			log.info("Finished");
			while (true);




		};
	}

	private void sendTrainTimeTable() {
		try {
			MotisManager.sendSzenarioToMotis("Scenario_1");
			log.info("Time-Table send");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Time-Table Error sending");
		}

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
