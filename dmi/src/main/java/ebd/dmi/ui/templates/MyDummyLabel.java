package ebd.dmi.ui.templates;

import ebd.dmi.ui.Scalable;
import ebd.dmi.ui.utility.DMIColor;
import ebd.dmi.ui.utility.DMIPictures;
import ebd.dmi.ui.utility.DMIUtility;

import javax.swing.*;
import java.awt.*;

/**
 * @author <i>Aron</i><br>
 *         MeinLabel erbt von JLabel und setzt Specs automatisch um.
 */
public class MyDummyLabel extends JLabel implements Scalable {

	/**
	 * Generated ID der Klasse.
	 */
	private static final long serialVersionUID = -1988667569944154860L;

	/**
	 * Speichert die ursprünglichen Ausmaße.
	 */
	private Rectangle oldBounds;


	/**
	 * Erwartet die Variablen für die setBounds Methode.
	 * 
	 * @param x Pos des Labels
	 * @param y Pos des Labels
	 * @param breite des Labels
	 * @param hoehe des Labels
	 * @param str des Labels
	 */
	public MyDummyLabel(final int x, final int y, final int breite, final int hoehe) {
		this.oldBounds = new Rectangle(x, y, breite, hoehe);
		Color bgColor = DMIUtility.instance().getColor(DMIColor.DARK_BLUE);

		// Color black = DMIUtility.instance().getColor(DMIColor.BLACK);
		// Color shadow = DMIUtility.instance().getColor(DMIColor.SHADOW);
		// Border myBorder = new CompoundBorder(
		// BorderFactory.createMatteBorder(1, 1, 0, 0, black),
		// BorderFactory.createMatteBorder(0, 0, 1, 1, shadow));
		// this.setBorder(new LineBorder(Color.WHITE));
		// this.setBorder(myBorder);

		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.WHITE);
		setBackground(bgColor);
		setOpaque(true);
		double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
		int nx = (int) (x * skalierungsFaktor);
		int ny = (int) (y * skalierungsFaktor);
		int nbreite = (int) (breite * skalierungsFaktor);
		int nhoehe = (int) (hoehe * skalierungsFaktor);
		this.setBounds(nx, ny, nbreite, nhoehe);

		// this.setText(str);
	}


	public MyDummyLabel(final int x, final int y, final int breite, final int hoehe, final DMIPictures pic) {
		this.oldBounds = new Rectangle(x, y, breite, hoehe);
		Color bgColor = DMIUtility.instance().getColor(DMIColor.DARK_BLUE);

		// Color black = DMIUtility.instance().getColor(DMIColor.BLACK);
		// Color shadow = DMIUtility.instance().getColor(DMIColor.SHADOW);
		// Border myBorder = new CompoundBorder(
		// BorderFactory.createMatteBorder(1, 1, 0, 0, black),
		// BorderFactory.createMatteBorder(0, 0, 1, 1, shadow));
		// this.setBorder(new LineBorder(Color.WHITE));
		// this.setBorder(myBorder);

		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.WHITE);
		setBackground(bgColor);
		setOpaque(true);
		double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
		int nx = (int) (x * skalierungsFaktor);
		int ny = (int) (y * skalierungsFaktor);
		int nbreite = (int) (breite * skalierungsFaktor);
		int nhoehe = (int) (hoehe * skalierungsFaktor);
		this.setBounds(nx, ny, nbreite, nhoehe);

		setIcon(DMIUtility.instance().getIcon(pic));
	}


	/**
	 * Ändert die Abmessungen des Labels an den neuen Skalierungsfaktor.
	 */
	public final void resize() {
		double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
		int nx = (int) (this.oldBounds.x * skalierungsFaktor);
		int ny = (int) (this.oldBounds.y * skalierungsFaktor);
		int nbreite = (int) (this.oldBounds.width * skalierungsFaktor);
		int nhoehe = (int) (this.oldBounds.height * skalierungsFaktor);
		Rectangle newBounds = new Rectangle(nx, ny, nbreite, nhoehe);
		this.setBounds(newBounds);
	}


	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		if (this.oldBounds != null) {
			resize();
		}
	}
}
