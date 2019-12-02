package ebd.dmi.ui.templates;

import ebd.dmi.ui.Scalable;
//import ebd.dmi.ui.panels.CardPanel;
import ebd.dmi.ui.utility.DMIColor;
import ebd.dmi.ui.utility.DMIPictures;
import ebd.dmi.ui.utility.DMISound;
import ebd.dmi.ui.utility.DMIUtility;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author <i>Aron</i><br>
 *         MeinButton erbt von JButton und setzt Specs automatisch um.
 */
public abstract class MyButton extends JButton implements Scalable {

	/**
	 * Generated ID der Klasse.
	 */
	private static final long serialVersionUID = 8206228694456460270L;

	/**
	 * Wird noch ersetzt durch schrift von Utility-Klasse.
	 */
	private Font schrift = new Font("Verdana", Font.PLAIN, 9);
	/**
	 * Wird noch ersetzt durch Farbe von Utility-Klasse.
	 */
	private Color bgColor = DMIUtility.instance().getColor(DMIColor.DARK_BLUE);

	/**
	 * Wird noch ersetzt durch Border von Utility-Klasse.
	 */
	private String name;
//	protected CardPanel parent;
	Border myBorder;

	/**
	 * Speichert die alten Abmessungen.
	 */
	private Rectangle oldBounds;


	/**
	 * Erwartet die Variablen für die setBounds Methode.
	 * 
	 * @param x Pos des Buttons
	 * @param y Pos des Buttons
	 * @param breite des Buttons
	 * @param hoehe des Buttons
	 * @param str des Buttons
	 */
	public MyButton(final int x, final int y, final int breite, final int hoehe, final String str) {
		this.name = str;
		//TODO: Abhängigkeiten von CardPanel entfernen
		//this.parent = CardPanel.getCp();
		setFont(this.schrift);
		double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
		int nx = (int) (x * skalierungsFaktor);
		int ny = (int) (y * skalierungsFaktor);
		int nbreite = (int) (breite * skalierungsFaktor);
		int nhoehe = (int) (hoehe * skalierungsFaktor);
		this.setBounds(nx, ny, nbreite, nhoehe);
		this.oldBounds = new Rectangle(x, y, breite, hoehe);
		setFocusable(false);
		setText(this.name);
		setBorder(DMIUtility.instance().getMyButtonBorder());
		setBackground(this.bgColor);
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		meinAddActionListener();
	}


	public MyButton(final int x, final int y, final int breite, final int hoehe, final String str, DMIPictures pic) {
		this.name = str;
		//TODO: Abhängigkeiten von CardPanel entfernen
		//this.parent = CardPanel.getCp();
		setFont(this.schrift);
		double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
		int nx = (int) (x * skalierungsFaktor);
		int ny = (int) (y * skalierungsFaktor);
		int nbreite = (int) (breite * skalierungsFaktor);
		int nhoehe = (int) (hoehe * skalierungsFaktor);
		this.setBounds(nx, ny, nbreite, nhoehe);
		this.oldBounds = new Rectangle(x, y, breite, hoehe);
		setFocusable(false);
		setBorder(DMIUtility.instance().getMyButtonBorder());
		setBackground(this.bgColor);
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		setIcon(DMIUtility.instance().getIcon(pic));
		meinAddActionListener();
	}


	@Override
	public final String toString() {
		return this.name;
	}


	/**
	 * Fügt ActionListener anhand des Types von Button hinzu. <br>
	 * -> wird wohl abstrakt werden
	 */
	public final void meinAddActionListener() {
		addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// System.out.println("Gedrücker Button: "
				// + e.getSource().toString());
				DMIUtility.instance().playSound(DMISound.CLICK);
				clickAction(e);
			}
		});
	}


	public abstract void clickAction(final ActionEvent e);


	/**
	 * Ändert die Abmessungen des Panels an den neuen Skalierungsfaktor.
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
