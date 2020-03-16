package ebd.dmi.ui.utility;

//import ebd.dmi.ui.LoginWindow;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

/**
 * Diese Klasse liefert allgemeine Hilfsmethoden zur Darstellung des DMI. Dies
 * ist ein Singelton nach dem gleichnamigen GoF-Pattern.
 * 
 * @author Simon Weiler
 */
public final class DMIUtility {

	/**
	 * Dieses Feld speichert die eine Instanz der Klasse.
	 */
	private static DMIUtility instanz;

	/**
	 * Der skalierungsFaktor gibt an, wie viele Pixel eine Cell breit ist.
	 */
	private double skalierungsFaktor = 1.2;

	/**
	 * Array, in dem alle Farben, die vorkommen können gespeichert werden.
	 */
	private Color[] farben = new Color[DMIColour.values().length];

	/**
	 * Enthält alle abspielbaren Sounds als Array
	 */
	private AudioClip[] sounds = new AudioClip[DMISound.values().length];

	/**
	 * Enthält die Bilder für das DMI
	 */
	private ImageIcon[] pictures = new ImageIcon[DMIPictures.values().length];

	/**
	 * Selbst erstellte Border für Label.
	 */
	private Border myLabelBorder;

	/**
	 * Selbst erstellte Border für Buttons.
	 */
	private Border myButtonBorder;


	/**
	 * Der Konstruktor ist privat, damit nur über die instance-Methode auf die
	 * Instanz zugegriffen werden kann. Hier werden auch die Farben in das
	 * entsprechende Array geladen.
	 */
	private DMIUtility() {
		// Hier wird das Array farben initialisiert.
		this.farben[DMIColour.WHITE.ordinal()] = new Color(255, 255, 255);
		this.farben[DMIColour.BLACK.ordinal()] = new Color(0, 0, 0);
		this.farben[DMIColour.GREY.ordinal()] = new Color(195, 195, 195);
		this.farben[DMIColour.MEDIUM_GREY.ordinal()] = new Color(150, 150, 150);
		this.farben[DMIColour.DARK_GREY.ordinal()] = new Color(85, 85, 85);
		this.farben[DMIColour.DARK_BLUE.ordinal()] = new Color(3, 17, 34);
		this.farben[DMIColour.SHADOW.ordinal()] = new Color(8, 24, 57);
		this.farben[DMIColour.YELLOW.ordinal()] = new Color(223, 223, 0);
		this.farben[DMIColour.ORANGE.ordinal()] = new Color(234, 145, 0);
		this.farben[DMIColour.RED.ordinal()] = new Color(191, 0, 2);
		this.farben[DMIColour.PASP_DARK.ordinal()] = new Color(33, 49, 74);
		this.farben[DMIColour.PASP_LIGHT.ordinal()] = new Color(41, 74, 107);

		// Borders werden erstellt
		Color black = getColour(DMIColour.BLACK);
		Color shadow = getColour(DMIColour.SHADOW);
		Border myTempBorder = new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, black), BorderFactory.createMatteBorder(0, 0, 1, 1, shadow));
		this.myLabelBorder = myTempBorder;
		Border myInnerBorder = new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, black), BorderFactory.createMatteBorder(0, 0, 1, 1, shadow));
		Border myOuterBorder = new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, shadow), BorderFactory.createMatteBorder(0, 0, 1, 1, black));
		this.myButtonBorder = new CompoundBorder(myInnerBorder, myOuterBorder);

		// musik und bilder werden geladen
		try {
			File soundFile = new File("../sounds/click.wav");
			AudioClip sound1 = Applet.newAudioClip(soundFile.toURI().toURL());
			this.sounds[DMISound.CLICK.ordinal()] = sound1;

			soundFile = new File("../sounds/S1_toofast.wav");
			sound1 = Applet.newAudioClip(soundFile.toURI().toURL());
			this.sounds[DMISound.TOO_FAST.ordinal()] = sound1;

			soundFile = new File("../sounds/S2_warning.wav");
			sound1 = Applet.newAudioClip(soundFile.toURI().toURL());
			this.sounds[DMISound.WARNING.ordinal()] = sound1;

			soundFile = new File("../sounds/S_info.wav");
			sound1 = Applet.newAudioClip(soundFile.toURI().toURL());
			this.sounds[DMISound.INFO.ordinal()] = sound1;

			ImageIcon ii = new ImageIcon("library 230/symbols/Setting/SE_04.png");
			this.pictures[DMIPictures.SE_04.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Setting/SE_03.png");
			this.pictures[DMIPictures.SE_03.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Setting/SE_02.png");
			this.pictures[DMIPictures.SE_02.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Setting/SE_01.png");
			this.pictures[DMIPictures.SE_01.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Mode/MO_03.png");
			this.pictures[DMIPictures.MO_03.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Mode/MO_11.png");
			this.pictures[DMIPictures.MO_11.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Mode/MO_13.png");
			this.pictures[DMIPictures.MO_13.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Level/LE_05.png");
			this.pictures[DMIPictures.LE_05.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_01.png");
			this.pictures[DMIPictures.NA_01.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_03.png");
			this.pictures[DMIPictures.NA_03.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_04.png");
			this.pictures[DMIPictures.NA_04.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_05.png");
			this.pictures[DMIPictures.NA_05.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_06.png");
			this.pictures[DMIPictures.NA_06.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_07.png");
			this.pictures[DMIPictures.NA_07.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_08.png");
			this.pictures[DMIPictures.NA_08.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_11.png");
			this.pictures[DMIPictures.NA_11.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_13.png");
			this.pictures[DMIPictures.NA_13.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_14.png");
			this.pictures[DMIPictures.NA_14.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_17.png");
			this.pictures[DMIPictures.NA_17.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_18.png");
			this.pictures[DMIPictures.NA_18.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_18.2.png");
			this.pictures[DMIPictures.NA_18_2.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_19.png");
			this.pictures[DMIPictures.NA_19.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Navigation/NA_21.png");
			this.pictures[DMIPictures.NA_21.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/DriverRequest/DR_03.png");
			this.pictures[DMIPictures.DR_03.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Status/ST_02.png");
			this.pictures[DMIPictures.ST_02.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Status/ST_03.png");
			this.pictures[DMIPictures.ST_03.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Status/ST_04.png");
			this.pictures[DMIPictures.ST_04.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Planning/PL_21.png");
			this.pictures[DMIPictures.PL_21.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Planning/PL_22.png");
			this.pictures[DMIPictures.PL_22.ordinal()] = ii;

			ii = new ImageIcon("library 230/symbols/Planning/PL_23.png");
			this.pictures[DMIPictures.PL_23.ordinal()] = ii;

		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Error bei Laden von Ressourcen!");
		}
	}


	/**
	 * Diese Klassenmethode liefert eine Instanz der Klasse. Existiert bisher
	 * noch keine Instanz, so wird eine neue erzeugt. Andernfalls wird die
	 * existierende zurückgeliefert.
	 * 
	 * @return Die eine Instanz dieser Klasse
	 */
	public static DMIUtility instance() {
		if (instanz == null) {
			instanz = new DMIUtility();
		}
		return instanz;
	}


	/**
	 * Setzt ein Grafik-Objekt auf, welches automatisch korrekt skaliert ist.
	 * Außerdem wird Antialiasing eingeschaltet.
	 * 
	 * @param g Das Grafik-Objekt, auf dem diese Methode aufbaut
	 * @return Eine neue Graphics2D-Instanz, mit richtiger Skalierung und
	 *         Antialiasing
	 */
	public Graphics2D setupGrafik(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.scale(this.skalierungsFaktor, this.skalierungsFaktor);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		return g2d;
	}


	/**
	 * Liefert ein Color-Objekt für die angegebene Farbe.
	 * 
	 * @param color Der DMIColor-Wert der gesuchten Farbe
	 * @return Ein Color-Objekt, das die RGB-Darstellung der Farbe enthält.
	 */
	public Color getColour(final DMIColour color) {
		try {
			// Das Array farben ist so aufgebaut, dass es genau
			// an dieser Stelle die gesuchte Farbe enthält.
			return this.farben[color.ordinal()];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Die Farbe " + color.name() + " ist nicht in DMIUtility vorhanden!");
		}
	}


	/**
	 * Spielt den geforderten Sound ab.
	 * 
	 * @param sound Der Sound, als Element von DMISound, der abgespielt werden
	 *            soll
	 * @throws Exception
	 */
	public void playSound(final DMISound sound) {
		this.sounds[sound.ordinal()].play();
	}


	/**
	 * Zum Bild holen
	 * 
	 * @param pic DMIPicture das man haben will
	 * @return angefordertes Bild
	 */
	public ImageIcon getIcon(final DMIPictures pic) {
		return this.pictures[pic.ordinal()];
	}


	/**
	 * Fügt die Toolbar zu einem Frame hinzu.
	 */
	public void addToolbar(JFrame frame) {
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
		toolBar.setFloatable(false);
		JButton button;

		button = new JButton("Logout");
		toolBar.add(button);
		button.setActionCommand("Toolbar_Logout");
		button.addActionListener((ActionListener) frame);

		button = new JButton("Emergency Stop");
		toolBar.add(button);
		button.setActionCommand("Toolbar_Nothalt");
		button.addActionListener((ActionListener) frame);

		//TODO: Abhängigkeiten von LoginWindow entfernen
		/*if (LoginWindow.getUserRights() == 2) {
			button = new JButton("Manual");
			toolBar.add(button);
			button.setActionCommand("Toolbar_Manuell");
			button.addActionListener((ActionListener) frame);
		}*/

		button = new JButton("Exit");
		toolBar.add(button);
		button.setActionCommand("Toolbar_Beenden");
		button.addActionListener((ActionListener) frame);
	}


	// Getter/Setter
	// ------------------------------------------------------------------
	/**
	 * Gibt den Skalierungs-Faktor zurück, der aktuell eingestellt ist.
	 * 
	 * @return Der Wert, um den aktuell skaliert wird.
	 */
	public double getSkalierungsFaktor() {
		return this.skalierungsFaktor;
	}


	/**
	 * Setzt den Wert, um den die Darstellung skaliert wird.
	 * 
	 * @param skalierungsFaktor2 Der neue Faktor
	 */
	public void setSkalierungsFaktor(final double skalierungsFaktor2) {
		this.skalierungsFaktor = skalierungsFaktor2;
	}


	/**
	 * @return the myLabelBorder
	 */
	public Border getMyLabelBorder() {
		return this.myLabelBorder;
	}


	/**
	 * @return the myButtonBorder
	 */
	public Border getMyButtonBorder() {
		return this.myButtonBorder;
	}
}
