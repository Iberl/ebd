package ebd.dmi.ui.templates;

import ebd.dmi.ui.Scalable;
import ebd.dmi.ui.utility.DMIColor;
import ebd.dmi.ui.utility.DMIUtility;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

/**
 * @author <i>Aron</i><br>
 *         MeinLabel erbt von JLabel und setzt Specs automatisch um.
 */
public class MyTextField extends JTextField implements Scalable {

	private static final long serialVersionUID = -6443538307084046059L;

	/**
	 * Speichert die ursprünglichen Ausmaße.
	 */
	private Rectangle oldBounds;


	/**
	 * Erwartet die Variablen für die setBounds Methode.
	 * 
	 * @param x Pos des TextFields
	 * @param y Pos des TextFields
	 * @param breite des TextFields
	 * @param hoehe des TextFields
	 * @param str des TextFields
	 */
	public MyTextField(final int x, final int y, final int breite, final int hoehe, final String str) {
		this.oldBounds = new Rectangle(x, y, breite, hoehe);
		Color bgColor = DMIUtility.instance().getColor(DMIColor.DARK_BLUE);
		Color fontColor = DMIUtility.instance().getColor(DMIColor.GREY);
		Color black = DMIUtility.instance().getColor(DMIColor.BLACK);
		Color shadow = DMIUtility.instance().getColor(DMIColor.SHADOW);
		Border myBorder = new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, black), BorderFactory.createMatteBorder(0, 0, 1, 1, shadow));
		setBorder(myBorder);

		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(fontColor);
		setBackground(bgColor);
		double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
		int nx = (int) (x * skalierungsFaktor);
		int ny = (int) (y * skalierungsFaktor);
		int nbreite = (int) (breite * skalierungsFaktor);
		int nhoehe = (int) (hoehe * skalierungsFaktor);
		this.setBounds(nx, ny, nbreite, nhoehe);
		setText(str);
	}


	public MyTextField(final int x, final int y, final int breite, final int hoehe) {
		super();
		this.oldBounds = new Rectangle(x, y, breite, hoehe);
		Color bgColor = DMIUtility.instance().getColor(DMIColor.DARK_BLUE);
		Color fontColor = DMIUtility.instance().getColor(DMIColor.GREY);
		setBorder(DMIUtility.instance().getMyLabelBorder());
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(fontColor);
		setBackground(bgColor);
		double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
		int nx = (int) (x * skalierungsFaktor);
		int ny = (int) (y * skalierungsFaktor);
		int nbreite = (int) (breite * skalierungsFaktor);
		int nhoehe = (int) (hoehe * skalierungsFaktor);
		this.setBounds(nx, ny, nbreite, nhoehe);
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
