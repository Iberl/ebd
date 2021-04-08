package de.ibw.tms.entities;

import de.ibw.main.MotisManager;
import de.ibw.main.SmartLogicClient;

import de.ibw.tms.MainTmsSim;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.ui.TmsFrameUtil;
import de.motis.config.TmsConfig;
import de.motis.producer.MotisProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.io.IOException;

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-03-10
 */

@SpringBootApplication
@EnableJpaRepositories()
public class TmsJpaApp {

	private static final Logger log = LoggerFactory.getLogger(TmsJpaApp.class);

	public static TmsConfig Config;

	public static TmsFramer TmsFramer = null;

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
	public CommandLineRunner TmsRunner(TimeTaskRepository repository, MotisProducer M, TmsConfig C) {
		return (args) -> {
			TmsJpaApp.Config = C;
			SmartLogicClient.MotisProducer = M;
			PlanData.getInstance();

			SmartLogicClient.proceedTmsLogic(repository);

			log.info("TMS is up");
			log.info("TMS send planed Train-Timetable");
			sendTrainTimeTable();
			log.info("Time-Table send");

			log.info("Finished");
			while (true) ;


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


	@RestController
	@EnableAutoConfiguration
	@Order(value=3)
	@Component
	public class TmsServiceController {
		/*@RequestMapping(value="/blade", method= RequestMethod.GET)
		public ModelAndView getProduct() {
			ConfigurableApplicationContext context = new SpringApplicationBuilder(TmsJpaApp.class).headless(false).run(null);
			TmsFrame tmsFrame = context.getBean(TmsFrame.class);

			ModelAndView modelAndView = new ModelAndView();

			modelAndView.setViewName("hallo");
			return modelAndView;


		}
	*/
		@GetMapping(path = "/")
		public String home() { // <== changed return type, added parameter



				SwingUtilities.invokeLater(() -> {
					if(TmsJpaApp.this.TmsFramer.tmsFrame == null) TmsJpaApp.this.TmsFramer.tmsFrame =
							TmsFrameUtil.createTmsFrame();
					TmsJpaApp.this.TmsFramer.tmsFrame.setVisible(true);


				});



			return "Hello world!"; // view name, aka template base name
		}


	}

	@Component
	@Order(value=2)
	public class TmsFramer implements CommandLineRunner {



		public JFrame tmsFrame = null;

		@Override
		public void run(String... args) throws Exception {
			TmsJpaApp.TmsFramer = this;
			System.setProperty("java.awt.headless", "false");
			System.out.println("Java can open Dialogs: " + java.awt.GraphicsEnvironment.isHeadless());
//			System.setProperty("java.awt.headless", "false");
//			SwingUtilities.invokeLater(() -> {
//				if(tmsFrame == null) tmsFrame = new JFrame();
//
//			});
		}

		public void repaint() {
			if(tmsFrame != null) {
				tmsFrame.repaint();
				TmsFrameUtil.updateSubViews();
			}
		}



	}
}