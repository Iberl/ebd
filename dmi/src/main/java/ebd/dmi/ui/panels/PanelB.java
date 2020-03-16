package ebd.dmi.ui.panels;

import ebd.dmi.ui.templates.MyChangeableLabel;
import ebd.dmi.ui.templates.MyLabel;
import ebd.dmi.ui.templates.MyPanel;
import ebd.dmi.ui.utility.DMIPictures;

import javax.swing.*;
import java.awt.*;

/**
 * @author <i>Bron</i><br>
 *         MeinPanel erbt von JPanel und setzt Specs automatisch um.
 */
public class PanelB extends MyPanel {

	private static final long serialVersionUID = 5304063459271383933L;

	private static final Rectangle AREA_BOUNDS = new Rectangle(54, 15, 280, 300);

	private final Speedometer speedometer;


	/**
	 * Erstellt Panel B.
	 */
	public PanelB() {
		super(AREA_BOUNDS);

		int[] array4 = { 8, 50, 40, 5, 400 };
		this.speedometer = new Speedometer(array4);

		MyLabel lblB3 = new MyLabel(86, 256, 36, 36, "");
		this.add(lblB3);

		MyLabel lblB4 = new MyLabel(122, 256, 36, 36, "");
		this.add(lblB4);

		MyLabel lblB5 = new MyLabel(158, 256, 36, 36, "");
		this.add(lblB5);

		MyLabel lblB6 = new MyLabel(8, 256, 36, 36, "");
		this.add(lblB6);

		MyChangeableLabel lblB7 = new MyChangeableLabel(236, 256, 36, 36, DMIPictures.MO_13);
		lblB7.setIdentifier("supervision mode");
		lblB7.setSecondIcon(DMIPictures.MO_11);
		this.add(lblB7);

		int currentTargetSpeed = 0;
		int currentSpeed = 0;
		this.speedometer.setCurrentTargetSpeed(currentTargetSpeed);
		this.speedometer.setCurrentSpeed(currentSpeed);
		this.add(this.speedometer);
	}


	public Speedometer getSpeedometer() {
		return this.speedometer;
	}
}
