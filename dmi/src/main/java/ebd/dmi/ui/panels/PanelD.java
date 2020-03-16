package ebd.dmi.ui.panels;

import ebd.dmi.ui.templates.MyButton;
import ebd.dmi.ui.templates.MyDummyLabel;
import ebd.dmi.ui.templates.MyLabel;
import ebd.dmi.ui.templates.MyPanel;
import ebd.dmi.ui.utility.DMIColour;
import ebd.dmi.ui.utility.DMIPictures;
import ebd.dmi.ui.utility.DMIUtility;

import java.awt.event.ActionEvent;

/**
 * @author <i>Aron</i><br>
 *         MeinPanel erbt von JPanel und setzt Specs automatisch um.
 */
public class PanelD extends MyPanel {

	/**
	 * Denerated ID der Klasse.
	 */
	private static final long serialVersionUID = 5304063459271383933L;
	final static int x = 334;
	final static int y = 15;
	final static int width = 246;
	final static int height = 300;

	//public DistanceScale panelDistanceScale;
	MyButton lblD9;
	MyButton lblD12;
	boolean scaleOnMax = false;
	boolean scaleOnMin = false;


	/**
	 * Erstellt Panel D.
	 */
	public PanelD() {
		super(x, y, width, height);
		//TODO: Abhängigkeiten von DistanceScale entfernen
		//this.panelDistanceScale = new DistanceScale();
		//this.add(this.panelDistanceScale);

		MyDummyLabel lblD8 = new MyDummyLabel(240, 15, 6, 270);
		lblD8.setBackground(DMIUtility.instance().getColour(DMIColour.PASP_DARK));
		this.add(lblD8);

		this.lblD9 = new MyButton(0, 285, 40, 15, "Zoom++", DMIPictures.NA_03) {

			private static final long serialVersionUID = 1L;


			@Override
			public void clickAction(ActionEvent e) {
				//TODO: Abhängigkeiten von DistanceScale entfernen
				//PanelD.this.scaleOnMax = !PanelD.this.panelDistanceScale.multiplikatorMM();
			//	PanelD.this.panelDistanceScale.repaint(50);
				if (PanelD.this.scaleOnMax) {
					setIcon(DMIUtility.instance().getIcon(DMIPictures.NA_05));
				} else if (PanelD.this.scaleOnMin) {
					PanelD.this.lblD12.setIcon(DMIUtility.instance().getIcon(DMIPictures.NA_04));
				}
			}
		};
		this.lblD9.setBorderPainted(false);
		this.add(this.lblD9);

		MyLabel lblD10 = new MyLabel(40, 285, 166, 15, "");
		lblD10.setBorder(null);
		this.add(lblD10);

		MyLabel lblD11 = new MyLabel(206, 285, 40, 15, "");
		lblD11.setBorder(null);
		this.add(lblD11);

		this.lblD12 = new MyButton(0, 0, 40, 15, "Zoom--", DMIPictures.NA_04) {

			private static final long serialVersionUID = 1L;


			@Override
			public void clickAction(ActionEvent e) {
				//TODO: Abhängigkeiten von DistanceScale entfernen
				//PanelD.this.scaleOnMin = !PanelD.this.panelDistanceScale.multiplikatorPP();
				//PanelD.this.panelDistanceScale.repaint(50);
				if (PanelD.this.scaleOnMin) {
					setIcon(DMIUtility.instance().getIcon(DMIPictures.NA_06));
				} else if (PanelD.this.scaleOnMax) {
					PanelD.this.lblD9.setIcon(DMIUtility.instance().getIcon(DMIPictures.NA_03));
				}
			}
		};
		this.lblD12.setBorderPainted(false);
		this.add(this.lblD12);

		MyLabel lblD13 = new MyLabel(40, 0, 166, 15, "");
		lblD13.setBorder(null);
		this.add(lblD13);

		MyLabel lblD14 = new MyLabel(206, 0, 40, 15, DMIPictures.NA_01);
		lblD14.setBorder(null);
		this.add(lblD14);
	}
}
