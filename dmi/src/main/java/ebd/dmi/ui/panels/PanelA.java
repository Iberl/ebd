package ebd.dmi.ui.panels;

//import ebd.dmi.ui.MainFrame;
import ebd.dmi.ui.templates.MyChangeableLabel;
import ebd.dmi.ui.templates.MyLabel;
import ebd.dmi.ui.templates.MyPanel;
import ebd.dmi.ui.utility.DMIColor;
import ebd.dmi.ui.utility.DMIPictures;
import ebd.dmi.ui.utility.DMIUtility;

import javax.swing.*;
import java.awt.*;

/**
 * @author <i>Aron</i><br>
 *         MeinPanel erbt von JPanel und setzt Specs automatisch um.
 */
public class PanelA extends MyPanel {

	private static final long serialVersionUID = 5304063459271383933L;

	private static final Rectangle AREA_BOUNDS = new Rectangle(0, 15, 54, 300);

	private static final Stroke stroke1 = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);

	// private static final int normalDistanceBreite = 1;
	private static final int normalDistanceLaenge = 9;
	// private static final int specialDistanceBreite = 2;
	private static final int specialDistanceLaenge = 13;

	// Indicatoren Linien (x,y) position laut spezifikation + 84 (A3
	// platzierung)
	private static final int[] indicatorLine0 = { 12, 185 + 84 };
	private static final int[] indicatorLine100 = { 16, 152 + 84 };
	private static final int[] indicatorLine200 = { 16, 105 + 84 };
	private static final int[] indicatorLine300 = { 16, 79 + 84 };
	private static final int[] indicatorLine400 = { 16, 59 + 84 };
	private static final int[] indicatorLine500 = { 12, 45 + 84 };
	private static final int[] indicatorLine600 = { 16, 32 + 84 };
	private static final int[] indicatorLine700 = { 16, 22 + 84 };
	private static final int[] indicatorLine800 = { 16, 13 + 84 };
	private static final int[] indicatorLine900 = { 16, 6 + 84 };
	private static final int[] indicatorLine1000 = { 12, 0 + 84 };

	// Target Distance
	protected int targetDistance = 0;
	protected final MyLabel lblDistanceDigitalAnzeige;


	/**
	 * Erstellt Panel A.
	 */
	public PanelA() {
		super(AREA_BOUNDS);

		MyLabel lblA1 = new MyLabel(1, 1, 53, 53, "");
		this.add(lblA1);

		this.lblDistanceDigitalAnzeige = new MyLabel(1, 55, 42, 29, "0");
		this.lblDistanceDigitalAnzeige.setBorder(null);
		this.lblDistanceDigitalAnzeige.setFont(new Font("Arial", Font.BOLD, 10));
		this.lblDistanceDigitalAnzeige.setHorizontalAlignment(JLabel.RIGHT);
		this.lblDistanceDigitalAnzeige.setForeground(DMIUtility.instance().getColor(DMIColor.GREY));
		this.add(this.lblDistanceDigitalAnzeige);


		MyChangeableLabel lblA4 = new MyChangeableLabel(1, 275, 52, 25, DMIPictures.ST_02);
		lblA4.setIdentifier("slippery rail");
		//TODO: Abhängigkeiten von MainFrame entfernen
		//if (!MainFrame.getHauptFrame().getSlipperyRail()) {
		//	lblA4.setIcon(null);
		//}
		this.add(lblA4);

		setTargetDistance(0);

	}


	/**
	 * TargetBar zeichnen der Fl�chen A2/A3, Indicatoren, Target Distance
	 * Digital und TargetBar
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = DMIUtility.instance().setupGrafik(g);

		// Paint A2 & A3 area
		Color bgColor = DMIUtility.instance().getColor(DMIColor.DARK_BLUE);
		g2d.setColor(bgColor);
		g2d.fillRect(0, 54, 54, 220);

		// Paint target bar
		int targetBarHeight = computeTargetBarHeight(this.targetDistance);

		g2d.setColor(DMIUtility.instance().getColor(DMIColor.GREY));
		g2d.fillRect(29, 270 - targetBarHeight, 10, targetBarHeight);

		// Paint normal indicators
		g2d.drawLine(indicatorLine100[0], indicatorLine100[1], indicatorLine100[0] + normalDistanceLaenge, indicatorLine100[1]);
		g2d.drawLine(indicatorLine200[0], indicatorLine200[1], indicatorLine200[0] + normalDistanceLaenge, indicatorLine200[1]);
		g2d.drawLine(indicatorLine300[0], indicatorLine300[1], indicatorLine300[0] + normalDistanceLaenge, indicatorLine300[1]);
		g2d.drawLine(indicatorLine400[0], indicatorLine400[1], indicatorLine400[0] + normalDistanceLaenge, indicatorLine400[1]);
		g2d.drawLine(indicatorLine600[0], indicatorLine600[1], indicatorLine600[0] + normalDistanceLaenge, indicatorLine600[1]);
		g2d.drawLine(indicatorLine700[0], indicatorLine700[1], indicatorLine700[0] + normalDistanceLaenge, indicatorLine700[1]);
		g2d.drawLine(indicatorLine800[0], indicatorLine800[1], indicatorLine800[0] + normalDistanceLaenge, indicatorLine800[1]);
		g2d.drawLine(indicatorLine900[0], indicatorLine900[1], indicatorLine900[0] + normalDistanceLaenge, indicatorLine900[1]);

		// Paint special indicators
		g2d.setStroke(stroke1);

		g2d.drawLine(indicatorLine1000[0], indicatorLine1000[1], indicatorLine1000[0] + specialDistanceLaenge, indicatorLine1000[1]);
		g2d.drawLine(indicatorLine500[0], indicatorLine500[1], indicatorLine500[0] + specialDistanceLaenge, indicatorLine500[1]);
		g2d.drawLine(indicatorLine0[0], indicatorLine0[1], indicatorLine0[0] + specialDistanceLaenge, indicatorLine0[1]);

		g2d.dispose();
	}


	/**
	 * TargetDistance aktualisieren
	 * 
	 * @param targetDistance wert
	 */
	public void setTargetDistance(int targetDistance) {
		this.targetDistance = targetDistance;
		this.lblDistanceDigitalAnzeige.setText(String.valueOf(targetDistance));
	}


	private static final double LOG_START = log2(100);
	private static final double LOG_END = log2(1000);
	private static final double LOG_SCALE_RANGE = LOG_END - LOG_START;


	/**
	 * Diese Funktion soll die Distanz in der TargetBar darstellen Von 0 - 100m
	 * ist die Berechnung linear. Von 100-1000 soll diese logarithmisch erfolgen
	 * 
	 * @param distance
	 * @return
	 */
	int computeTargetBarHeight(int distance) {
		int barHeight = 0;
		double logDistance = log2(distance);

		if (distance >= 0 && distance < 100) {
			// lineare Berechnung
			barHeight = distance * 33 / 100;

		} else if (distance >= 100 && distance < 1000) {
			// Prozentualen Anteil
			double temp = 100.0 * (logDistance - LOG_START) / LOG_SCALE_RANGE;

			// umrechnen in Logarithmus skala
			barHeight = (int) (153 * temp / 100) + 33;

		} else if (distance >= 1000) {
			// full bar height
			barHeight = 186;
		}

		return barHeight;
	}


	/**
	 * Funktion berechnet den 2er-Logarithmus von der uebergebenen Zahl
	 * 
	 * @param x zahl x von der der Logarithmus berechnet werden soll
	 * @return berechneter Logarithmus Wert
	 */
	public static double log2(double x) {
		return Math.log(x) / Math.log(2);
	}
}
