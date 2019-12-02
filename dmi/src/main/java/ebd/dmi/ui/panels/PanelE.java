package ebd.dmi.ui.panels;

//import ebd.dmi.ui.MainFrame;
import ebd.dmi.ui.templates.MyButton;
import ebd.dmi.ui.templates.MyChangeableLabel;
import ebd.dmi.ui.templates.MyLabel;
import ebd.dmi.ui.templates.MyPanel;
import ebd.dmi.ui.utility.DMIPictures;
import ebd.dmi.ui.utility.DMIUtility;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author <i>Aron</i><br>
 *         MeinPanel erbt von JPanel und setzt Specs automatisch um.
 */
public class PanelE extends MyPanel {

	/**
	 * Generated ID der Klasse.
	 */
	private static final long serialVersionUID = 5304063459271383933L;

	private static final Rectangle AREA_BOUNDS = new Rectangle(0, 365, 334, 100);

	//public PanelMessages pMessages;


	/**
	 * Erstellt Panel E.
	 */
	public PanelE() {
		super(AREA_BOUNDS);

		//TODO: Abhängigkeiten von Message entfernen
		//this.pMessages = new PanelMessages();
		//this.add(this.pMessages);

		MyChangeableLabel lblE1 = new MyChangeableLabel(0, 0, 54, 25, DMIPictures.ST_03);
		lblE1.setIdentifier("network connection");
		lblE1.setSecondIcon(DMIPictures.ST_04);
		//TODO: Abhängigkeiten von MainFrame und Message entfernen
//		if (!MainFrame.getHauptFrame().getConnected()) {
//			lblE1.setIcon(DMIUtility.instance().getIcon(DMIPictures.ST_04));
//			this.pMessages.addMessage("Networkconnection lost");
//			this.repaint(50);
//		} else {
			//this.pMessages.addMessage("Networkconnection established");
//		}
		this.add(lblE1);

		MyLabel lblE2 = new MyLabel(0, 25, 54, 25, "");
		this.add(lblE2);

		MyLabel lblE3 = new MyLabel(0, 50, 54, 25, "");
		this.add(lblE3);

		MyLabel lblE4 = new MyLabel(0, 75, 54, 25, "");
		this.add(lblE4);

		MyButton btnE10 = new MyButton(288, 0, 46, 50, "msgUP", DMIPictures.NA_13) {

			private static final long serialVersionUID = 1L;


			@Override
			public void clickAction(ActionEvent e) {
				//TODO: Abhängigkeiten von Message entfernen
				//PanelE.this.pMessages.decreaseBase();
			}
		};
		this.add(btnE10);

		MyButton btnE11 = new MyButton(288, 50, 46, 50, "msgDown", DMIPictures.NA_14) {

			private static final long serialVersionUID = 1L;


			@Override
			public void clickAction(ActionEvent e) {

				//TODO: Abhängigkeiten von Message entfernen
				//PanelE.this.pMessages.increaseBase();
			}
		};
		this.add(btnE11);
	}
}
