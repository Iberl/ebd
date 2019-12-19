package ebd.dmi.ui.panels;

import ebd.dmi.ui.templates.MyDummyLabel;
import ebd.dmi.ui.templates.MyLabel;
import ebd.dmi.ui.templates.MyPanel;
import ebd.dmi.ui.utility.DMIPictures;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author <i>Aron</i><br>
 *         MeinPanel erbt von JPanel und setzt Specs automatisch um.
 */
public class PanelG extends MyPanel {

	/**
	 * Generated ID der Klasse.
	 */
	private static final long serialVersionUID = 5304063459271383933L;
	final static int x = 334;
	final static int y = 315;
	final static int breite = 246;
	final static int hoehe = 150;
	public MyLabel lblG12;


	/**
	 * Erstellt Panel G.
	 */
	public PanelG() {
		super(x, y, breite, hoehe);

		MyDummyLabel lblG1 = new MyDummyLabel(0, 0, 245, 50);
		this.add(lblG1);

		MyDummyLabel lblG2 = new MyDummyLabel(0, 50, 245, 50);
		this.add(lblG2);

		MyLabel lblG11 = new MyLabel(0, 100, 63, 50, "");
		this.add(lblG11);

		this.lblG12 = new MyLabel(63, 100, 120, 50, DMIPictures.DR_03);
		this.add(this.lblG12);

		final MyLabel lblG13 = new MyLabel(183, 100, 63, 50, "");
		this.add(lblG13);

		final java.text.SimpleDateFormat hms = new java.text.SimpleDateFormat("HH:mm:ss");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Date now = Calendar.getInstance().getTime();
				lblG13.setText(hms.format(now));
			}
		}, 0, 1000);
	}
}
