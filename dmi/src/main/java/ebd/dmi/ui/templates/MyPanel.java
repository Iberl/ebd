package ebd.dmi.ui.templates;

//import ebd.dmi.ui.MainFrame;
import ebd.dmi.ui.DMIDisplay;
import ebd.dmi.ui.Scalable;
import ebd.dmi.ui.utility.DMIColor;
import ebd.dmi.ui.utility.DMIUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * @author <i>Aron</i><br>
 *         MeinPanel erbt von JPanel und setzt Specs automatisch um.
 */
public class MyPanel extends JPanel implements Scalable {

	/**
	 * Generated ID der Klasse.
	 */
	private static final long serialVersionUID = 7060139973119981991L;
	/**
	 * Wird noch ersetzt durch Farbe von Utility-Klasse.
	 */
	private Color bgColor = DMIUtility.instance().getColor(DMIColor.DARK_BLUE);

	/**
	 * Speichert die ursprünglichen Abmessungen.
	 */
	private Rectangle originalBounds;


	/**
	 * Erwartet die Variablen für die setBounds Methode.
	 * 
	 * @param x Pos des Panels
	 * @param y Pos des Panels
	 * @param width breite des Panels
	 * @param height hoehe des Panels
	 */
	public MyPanel(final int x, final int y, final int width, final int height) {
		this(new Rectangle(x, y, width, height));
	}


	public MyPanel(final Rectangle bounds) {
		this.originalBounds = (Rectangle) bounds.clone();

		setBackground(this.bgColor);
		setLayout(null);
		setBorder(null);

		double scaleFactor = DMIUtility.instance().getSkalierungsFaktor();
		// int nx = (int) (bounds.getX() * scaleFactor);
		// int ny = (int) (bounds.getY() * scaleFactor);
		// int nbreite = (int) (bounds.getWidth() * scaleFactor);
		// int nhoehe = (int) (bounds.getHeight() * scaleFactor);
		// this.setBounds(nx, ny, nbreite, nhoehe);

		AffineTransform scaleAT = AffineTransform.getScaleInstance(scaleFactor, scaleFactor);
		setBounds(scaleAT.createTransformedShape(bounds).getBounds());
	}


	/**
	 * Ändert die Abmessungen des Panels an den neuen Skalierungsfaktor.
	 */
	public final void resize() {
		double scaleFactor = DMIUtility.instance().getSkalierungsFaktor();
		// int nx = (int) (this.originalBounds.x * scaleFactor);
		// int ny = (int) (this.originalBounds.y * scaleFactor);
		// int nbreite = (int) (this.originalBounds.width * scaleFactor);
		// int nhoehe = (int) (this.originalBounds.height * scaleFactor);
		// Rectangle newBounds = new Rectangle(nx, ny, nbreite, nhoehe);
		// setBounds(newBounds);

		AffineTransform scaleAT = AffineTransform.getScaleInstance(scaleFactor, scaleFactor);
		setBounds(scaleAT.createTransformedShape(this.originalBounds).getBounds());
	}


	/**
	 * Fügt die Kinder zu einem HauptFrame hinzu.
	 * 
	 * @param f Der Frame, zu dem die Kinder hinzugefügt werden sollen.
	 */
	//TODO: Abhängigkeiten von MainFrame entfernen
	public void addChildren(final DMIDisplay d) {
		for (Component c : getComponents()) {
			if (c instanceof Scalable) {
				d.addScaleable((Scalable) c);
				if (c instanceof MyPanel) {
					((MyPanel) c).addChildren(d);
				}
			}
		}
	}


	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}


	@Override
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}


	@Override
	public Dimension getPreferredSize() {
		double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
		int nbreite = (int) (this.originalBounds.width * skalierungsFaktor);
		int nhoehe = (int) (this.originalBounds.height * skalierungsFaktor);
		return new Dimension(nbreite, nhoehe);
	}
}
