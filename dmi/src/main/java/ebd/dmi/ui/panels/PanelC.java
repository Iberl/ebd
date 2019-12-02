package ebd.dmi.ui.panels;

import ebd.dmi.ui.templates.MyDummyLabel;
import ebd.dmi.ui.templates.MyLabel;
import ebd.dmi.ui.templates.MyPanel;
import ebd.dmi.ui.utility.DMIPictures;

/**
 * @author <i>Aron</i><br>
 *         MeinPanel erbt von JPanel und setzt Specs automatisch um.
 */
public class PanelC extends MyPanel {

	/**
	 * Generated ID der Klasse.
	 */
	private static final long serialVersionUID = 5304063459271383933L;
	final static int x = 0;
	final static int y = 315;
	final static int width = 334;
	final static int height = 50;


	/**
	 * Erstellt Panel C.
	 */
	public PanelC() {
		super(x, y, width, height);

		MyLabel lblC1 = new MyLabel(165, 0, 58, 50, "");
		this.add(lblC1);

		MyDummyLabel lblC2 = new MyDummyLabel(54, 0, 37, 50);
		this.add(lblC2);

		MyDummyLabel lblC3 = new MyDummyLabel(91, 0, 37, 50);
		this.add(lblC3);

		MyDummyLabel lblC4 = new MyDummyLabel(128, 0, 37, 50);
		this.add(lblC4);

		MyDummyLabel lblC5 = new MyDummyLabel(223, 0, 37, 50);
		this.add(lblC5);

		MyDummyLabel lblC6 = new MyDummyLabel(260, 0, 37, 50);
		this.add(lblC6);

		MyDummyLabel lblC7 = new MyDummyLabel(297, 0, 37, 50, DMIPictures.MO_03);
		this.add(lblC7);

		MyLabel lblC8 = new MyLabel(0, 0, 54, 25, DMIPictures.LE_05);
		this.add(lblC8);

		MyLabel lblC9 = new MyLabel(0, 25, 54, 25, "");
		this.add(lblC9);
	}
}
