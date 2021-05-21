package de.ibw.tms.entities;

import de.ibw.main.MotisManager;
import de.ibw.main.SmartLogicClient;

import de.ibw.tms.ColorProperties;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.intf.MovementMessengerIntf;
import de.ibw.tms.intf.messenger.IMovementMessengerIntf;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.ui.MovmentMessengerFrame;
import de.ibw.tms.ui.TmsFrameUtil;
import de.ibw.util.UtilFunction;
import de.motis.config.TmsConfig;
import de.motis.producer.MotisProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
 * @since 2021-05-19
 *
 * Hauptklasse des TMS
 */

@SpringBootApplication
@EnableJpaRepositories()
@EnableConfigurationProperties(ColorProperties.class)
public class TmsJpaApp {

	private static final Logger log = LoggerFactory.getLogger(TmsJpaApp.class);

	/**
	 * Configurationen aus dem SL-Config-Handler
	 */
	public static TmsConfig Config;

	/**
	 * Verwaltet die Nicht-Html-Oberflaeche des TMS
	 */
	public static TmsFramer TmsFramer = null;

	/**
	 * Verwaltet des Fenster fuer Movement-Authority Nachrichten an das smartLogic
	 * Visualisiert Antworten der smartLogic
	 */
	public static TmsMessenger TmsMessenger = null;

	/**
	 * Colors of EtcsTrain
	 */
	public static ColorProperties colorsOfEtcsTrains = null;

	/**
	 * main-Entry-Point
	 * @param args - unused
	 */
	public static void main(String[] args) {
		SpringApplication.run(TmsJpaApp.class);
	}


	/**
	 * Default Bean zum Erstellen der TMS-Konfiguration
	 * @return TmsConfig - Default Konfigurations-Modul
	 */
	@Bean
	public TmsConfig getTmsConfig() {
		return new TmsConfig();
	}

	/**
	 * Erstellt eine Senderoutine fuer den Motis-Fahrplan-Service
	 * @return MotisProducer - Standard Sende-Modul fuer Motis
	 */
	@Bean
	public MotisProducer getMotisProducer() {
		return new MotisProducer();
	}


	/**
	 * Hauptprogramm des TMS, das neben der UI laeuft
	 * @param repository - Szenario, das zeitgesteuert abgearbeitet wird, es wird damit auf die TMS-Datenbank
	 *                   zugegriffen
	 * @param M - Senderouting an Motis
	 * @param C - Default TMS Konfiguration
	 * @return CommandLineRunner - Konsolenanwendung starten
	 */
	@Bean
	public CommandLineRunner TmsRunner(TimeTaskRepository repository, MotisProducer M, TmsConfig C,
									   ColorProperties CP) {
		return (args) -> {


			log.info("Starting TMS version" + UtilFunction.showVersionString());

			TmsJpaApp.colorsOfEtcsTrains = CP;

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

	/**
	 * unused
	 * @param P
	 */
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


	/**
	 * Modul, das eine Rest-Webservice zur TMS Verwaltung startet
	 */
	@RestController
	@EnableAutoConfiguration
	@Order(value=4)
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

		/**
		 * Rest-Web-Service, Hauptpfad
		 * @return
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

	/**
	 * Oberflaeche des TMS (Swing-basiert)
	 */
	@Component
	@Order(value=2)
	public class TmsFramer implements CommandLineRunner {


		/**
		 * Hauptfenster des TMS
		 */
		public JFrame tmsFrame = null;

		/**
		 * Bereitstellen der Oberflaeche zum spaeteren oeffnen.
		 * @param args - unused
		 * @throws Exception - kann eine Fehler werfen (noch nicht aufgetreten)
		 */
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

		/**
		 * Zeichnet Hauptfenster neu
		 */
		public void repaint() {
			if(tmsFrame != null) {
				tmsFrame.repaint();
				TmsFrameUtil.updateSubViews();
			}
		}



	}

	/**
	 * Nachrichtenverwaltung TMS - smartLogic
	 */
	@Component
	@Order(value=3)
	public class TmsMessenger implements CommandLineRunner {


		/**
		 * loggt eine Nachricht in den Messenger ein
		 * @param msg - Nachricht die eingeloggt werden soll
		 */
		public void log(IMovementMessengerIntf msg) {

				SwingUtilities.invokeLater(() -> {
					logAndRepaint(msg);
				});



		}

		private void logAndRepaint(IMovementMessengerIntf msg) {
			MovmentMessengerFrame.getInstance().log(msg);
			MovmentMessengerFrame.getInstance().setVisible(true);
			MovmentMessengerFrame.getInstance().repaint();
		}

		/**
		 * Bereitet Messenger Window fuer spaeteren Abruf vor
		 * @param args - unused
		 * @throws Exception - kann Fehler werfen (nicht aufgetreten)
		 */
		@Override
		public void run(String... args) throws Exception {
			TmsJpaApp.TmsMessenger = this;
			System.setProperty("java.awt.headless", "false");
			System.out.println("Java can open Dialogs: " + java.awt.GraphicsEnvironment.isHeadless());
//			System.setProperty("java.awt.headless", "false");
//			SwingUtilities.invokeLater(() -> {
//				if(tmsFrame == null) tmsFrame = new JFrame();
//
//			});
		}





	}
}