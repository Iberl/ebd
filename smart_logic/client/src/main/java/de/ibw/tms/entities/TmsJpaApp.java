package de.ibw.tms.entities;

import de.ibw.main.MotisManager;
import de.ibw.main.SmartLogicClient;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.tms.ColorProperties;
import de.ibw.tms.ConnectionProperties;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.intf.MovementMessengerIntf;
import de.ibw.tms.intf.messenger.IMovementMessengerIntf;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.ui.MovmentMessengerFrame;
import de.ibw.tms.ui.TmsFrameUtil;
import de.ibw.util.UtilFunction;
import de.motis.config.RabbitMQConfig;
import de.motis.config.TmsConfig;
import de.motis.producer.MotisProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
 * @version 1.0
 * @since 2021-05-26
 *
 * Hauptklasse des TMS
 */

@SpringBootApplication
@EnableJpaRepositories()
@EnableConfigurationProperties({ConnectionProperties.class, ColorProperties.class, RabbitMQConfig.class, TmsConfig.class})
public class TmsJpaApp implements ApplicationContextAware {


	private static ApplicationContext CONTEXT;

	public static void setConnectedTOsmartLogic(boolean connectedTOsmartLogic) {
		isConnectedTOsmartLogic = connectedTOsmartLogic;
		if(TmsFramer.tmsFrame != null) {
			if (connectedTOsmartLogic) TmsFramer.tmsFrame.setTitle("TMS SIM connected to smartLogic");
			else TmsFramer.tmsFrame.setTitle("!!TMS SIM offline off smartLogic!!");
		}
	}

	/**
	 * This method is called from within the ApplicationContext once it is
	 * done starting up, it will stick a reference to itself into this bean.
	 * @param context a reference to the ApplicationContext.
	 */
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		CONTEXT = context;
	}

	/**
	 * This is about the same as context.getBean("beanName"), except it has its
	 * own static handle to the Spring context, so calling this method statically
	 * will give access to the beans by name in the Spring application context.
	 * As in the context.getBean("beanName") call, the caller must cast to the
	 * appropriate target class. If the bean does not exist, then a Runtime error
	 * will be thrown.
	 * @param beanName the name of the bean to get.
	 * @return an Object reference to the named bean.
	 */
	public static Object getBean(String beanName) {
		return CONTEXT.getBean(beanName);
	}
	public static Object getBean(Class<?> beanClass) {
		return CONTEXT.getBean(beanClass);
	}

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
	 * Special connection settings
	 */
	public static ConnectionProperties connectionProperties = null;

	public static boolean isConnectedTOsmartLogic = false;


	/**
	 * main-Entry-Point
	 * @param args - unused
	 */
	public static void main(String[] args) {
		SpringApplication.run(TmsJpaApp.class);
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
	 * @param M - Sender-Logic for communication to Motis
	 * @param C - Default TMS Konfiguration
	 * @return CommandLineRunner - Konsolenanwendung starten
	 */
	@Bean
	public CommandLineRunner TmsRunner(TimeTaskRepository repository, MotisProducer M, TmsConfig C,
									   ColorProperties CP, ConnectionProperties Con) {
		return (args) -> {


			log.info("Starting TMS version" + UtilFunction.showVersionString());
			handleLogging();
			TmsJpaApp.connectionProperties = Con;
			TmsJpaApp.colorsOfEtcsTrains = CP;

			TmsJpaApp.Config = C;
			SmartLogicClient.MotisProducer = M;
			PlanData.getInstance();

			SmartLogicClient.proceedTmsLogic(repository);


			while (true) ;


		};
	}

	private void handleLogging() {
		try {
			SmartLogic.SL_UI_Server = EventBusManager.startLogGuiServer(true);
			EventBusManager.RootEventBusManger = EventBusManager.registerOrGetBus(1, true);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Logging Gui on SL cannot be started.");
		}


		log.info("Root Event Bus Manager registered for TMS");
		EventBusManager.RootEventBusManger.log("TEST", "TestModul");
	}

	public static void sendTrainTimeTable() {
		try {
			MotisManager.sendSzenarioToMotis("Scenario_1");
			EventBusManager.RootEventBusManger.log("Time-Table send", SmartLogic.getsModuleId("Motis-Manager"));
			//log.info("Time-Table send");
		} catch (IOException e) {
			e.printStackTrace();
			//log.error("Time-Table Error sending");
			EventBusManager.RootEventBusManger.log("Time-Table Error sending", SmartLogic.getsModuleId("Motis-Manager"));
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
	 * Modul, das einen Rest-Webservice zur TMS Verwaltung startet
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
		 * Startet Streckenansicht
		 * @return
		 */
		@GetMapping(path = "/")
		public String home() { // <== changed return type, added parameter


			startTmsUI();


			return "Hello world!"; // view name, aka template base name
		}


	}

	public static void startTmsUI() {
		SwingUtilities.invokeLater(() -> {
			if(TmsFramer.tmsFrame == null) TmsFramer.tmsFrame =
					TmsFrameUtil.createTmsFrame();
			assert TmsFramer.tmsFrame != null;
			TmsFramer.tmsFrame.setVisible(true);


		});
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