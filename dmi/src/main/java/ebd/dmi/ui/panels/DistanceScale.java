//package ebd.dmi.ui.panels;
//
////import ebd.dmi.ui.MainFrame;
//import ebd.dmi.ui.RouteProfile;
//import ebd.dmi.ui.VelocityChange;
//import ebd.dmi.ui.templates.MyPanel;
//import ebd.dmi.ui.utility.DMIColor;
//import ebd.dmi.ui.utility.DMIUtility;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//
///**
// * @author <i>Aron</i><br>
// */
//public class DistanceScale extends MyPanel {
//
//	private static final long serialVersionUID = 1L;
//
//	private static Image IMG_PL21;
//	private static Image IMG_PL22;
//	private static Image IMG_PL23;
//
//	static {
//		try {
//			IMG_PL21 = ImageIO.read(new File("library 230/symbols/Planning/PL_21.png"));
//			IMG_PL21 = ImageIO.read(new File("library 230/symbols/Planning/PL_22.png"));
//			IMG_PL21 = ImageIO.read(new File("library 230/symbols/Planning/PL_23.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	int[] posOfLines = { 283 - 15, 250 - 15, 206 - 15, 182 - 15, 164 - 15, 150 - 15, 107 - 15, 64 - 15, 21 - 15 };
//	int[] range = { 0, 125, 250, 500, 1000, 0, 25, 50, 75, 100, 125, 250, 500, 1000 };
//	int multi = 4;
//	RouteProfile profil;
//	boolean first = true;
//	int xCoordinateOfLastImageDrawn = 0;
//	int yCoordinateOfLastImageDrawn = 0;
//	int speedOfLastImageDrawn = 0;
//	double prozentAlt = 0;
//	boolean log = false;
//
//	float posOfIndicationMarker = 0;
//
//
//	public DistanceScale(RouteProfile profil) {
//		super(0, 15, 240, 270);
//		this.profil = profil;
//	}
//
//
//	public DistanceScale() {
//		super(0, 15, 240, 270);
//	}
//
//
//	/**
//	 * Zeichnet die Distance Scale.
//	 */
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2d = DMIUtility.instance().setupGrafik(g);
//		if (this.profil != null) {
//			if (this.first) {
//				// System.out.println("Streckenprofil: \n" + profil.toString());
//				this.first = false;
//			}
//			drawPASP(g2d);
//			drawLines(g2d);
//		}
//	}
//
//
//	/**
//	 * Zeichnet die Querlinien der Distance Scale.
//	 *
//	 * @param g2d
//	 */
//	private void drawLines(Graphics2D g2d) {
//		Color mediumGray = DMIUtility.instance().getColor(DMIColor.MEDIUM_GRAY);
//		Color darkGray = DMIUtility.instance().getColor(DMIColor.DARK_GREY);
//		g2d.setColor(mediumGray);
//		BasicStroke wideStroke = new BasicStroke(2.0f);
//		BasicStroke normStroke = new BasicStroke(1.0f);
//
//		for (int i = 0; i < this.posOfLines.length; i++) {
//			String label;
//			switch (i) {
//				case 0:
//					label = String.valueOf(this.range[0]);
//					g2d.drawString(label, 25, this.posOfLines[i]);
//					g2d.setStroke(wideStroke);
//					g2d.drawLine(40, this.posOfLines[i], 240, this.posOfLines[i]);
//					g2d.setStroke(normStroke);
//					break;
//				case 5:
//					label = String.valueOf(this.range[1] * this.multi);
//					g2d.drawString(label, 5, this.posOfLines[i] + 5);
//					g2d.setStroke(wideStroke);
//					g2d.drawLine(40, this.posOfLines[i], 240, this.posOfLines[i]);
//					g2d.setStroke(normStroke);
//					break;
//				case 6:
//					label = String.valueOf(this.range[2] * this.multi);
//					g2d.drawString(label, 5, this.posOfLines[i] + 5);
//					g2d.drawLine(40, this.posOfLines[i], 240, this.posOfLines[i]);
//					break;
//				case 7:
//					label = String.valueOf(this.range[3] * this.multi);
//					g2d.drawString(label, 5, this.posOfLines[i] + 5);
//					g2d.drawLine(40, this.posOfLines[i], 240, this.posOfLines[i]);
//					break;
//				case 8:
//					label = String.valueOf(this.range[4] * this.multi);
//					g2d.drawString(label, 5, this.posOfLines[i] + 5);
//					g2d.setStroke(wideStroke);
//					g2d.drawLine(40, this.posOfLines[i], 240, this.posOfLines[i]);
//					g2d.setStroke(normStroke);
//					break;
//				default:
//					g2d.setColor(darkGray);
//					g2d.drawLine(40, this.posOfLines[i], 240, this.posOfLines[i]);
//					g2d.setColor(mediumGray);
//					break;
//			}
//		}
//	}
//
//
//	/**
//	 * Zeichnet das PASP.
//	 *
//	 * @param g2d
//	 */
//	@SuppressWarnings("null")
//	private void drawPASP(Graphics2D g2d) {
//		Shape rect = new Rectangle(147, 0, 93, 270);
//		Color darkPASP = DMIUtility.instance().getColor(DMIColor.PASP_DARK);
//		g2d.setColor(darkPASP);
//		g2d.fill(rect);
//		// g2d.draw(rect);
//
//		Color lightPASP = DMIUtility.instance().getColor(DMIColor.PASP_LIGHT);
//		g2d.setColor(lightPASP);
//
//		int currentPosition = MainFrame.getHauptFrame().getPosition();
//		VelocityChange nextWechsel = null;
//		VelocityChange oldWechsel = null;
//		VelocityChange wechsel = null;
//		VelocityChange lastWechsel = null;
//		boolean first = true;
//		int distanzAlt = 0;
//
//		for (int i = 0; i < this.profil.getList().size(); i++) {
//			// iterieren bis wechsel.km > aktuelle position
//			if (this.profil.getList().get(i).getMeter() > currentPosition) {
//				oldWechsel = this.profil.getList().get(i);
//
//				this.speedOfLastImageDrawn = this.profil.getList().get(i).getKmh();
//				continue;
//			}
//			if (this.log && first) {
//				System.out.println("oldWechsel: " + (oldWechsel != null ? oldWechsel.getMeter() : "null"));
//				System.out.println("speedOfLast: " + this.speedOfLastImageDrawn);
//			}
//			// damit keine nullpointer-exception kommt
//			if (oldWechsel == null) {
//				wechsel = this.profil.getList().get(i);
//				nextWechsel = this.profil.getList().get(i);
//				lastWechsel = this.profil.getList().get(i);
//			} else {
//				wechsel = oldWechsel;
//				nextWechsel = this.profil.getList().get(i);
//				lastWechsel = this.profil.getList().get(i - 1);
//			}
//			if (this.log) {
//				System.out.println("wechsel: " + (wechsel != null ? wechsel.getMeter() : "null"));
//				System.out.println("nextWechsel: " + nextWechsel.getMeter());
//				System.out.println("lastWechsel: " + lastWechsel.getMeter());
//			}
//
//			double prozent = 0;
//			// Der erste Balken ist immer 100%
//			if (first) {
//				prozent = 100;
//				// Danach wieviel % nach erreichen des nächsten VC noch
//				// gefahren
//				// werden darf
//			} else {
//				prozent = (double) lastWechsel.getKmh() / (double) wechsel.getKmh() * 100;
//				if (this.log) {
//					System.out.println("speedLast: " + wechsel.getKmh());
//					System.out.println("lastWechselSpeed: " + lastWechsel.getKmh() + ", " + prozent);
//				}
//				if (prozent > this.prozentAlt) {
//					prozent = this.prozentAlt;
//				}
//			}
//			if (this.log) {
//				System.out.println("prozent: " + prozent);
//				System.out.println();
//			}
//
//			int distanceStartToVC = Math.abs(currentPosition - nextWechsel.getMeter());
//			int distance = calculateDistance(distanceStartToVC);
//
//			int untergrenze = 270 - distance;
//			int alteUntergrenze = distanzAlt;
//			if (first) {
//				first = false;
//				alteUntergrenze = 270;
//			}
//			distanzAlt = untergrenze;
//			this.prozentAlt = prozent;
//			drawRectangles(g2d, prozent, untergrenze, alteUntergrenze);
//			drawPictures(g2d, wechsel, nextWechsel, currentPosition);
//		}
//		drawIndicationMarker(g2d);
//		this.log = false;
//	}
//
//
//	private void drawPictures(Graphics2D g2d, VelocityChange wechsel, VelocityChange nextWechsel, int currentPosition) {
//		Image img = null;
//		int offset = 0;
//
//		if (nextWechsel.getKmh() > this.speedOfLastImageDrawn) {
//			offset = 17;
//			img = IMG_PL21;
//		} else if (nextWechsel.getKmh() < this.speedOfLastImageDrawn) {
//			offset = 3;
//			img = IMG_PL22;
//		}
//		if (nextWechsel.getKmh() == 0) {
//			offset = 3;
//			img = IMG_PL23;
//		}
//
//		int distanceStartToVC = Math.abs(currentPosition - nextWechsel.getMeter());
//		if (img != null && distanceStartToVC <= this.range[4] * this.multi) {
//			int xCoordinateToDraw = 120;
//			int yCoordinateToDraw = 270 - offset - calculateDistance(distanceStartToVC);
//			if (this.xCoordinateOfLastImageDrawn == xCoordinateToDraw && yCoordinatesTooClose(yCoordinateToDraw, img.getHeight(null))) {
//				xCoordinateToDraw -= img.getWidth(null) + 10;
//			}
//			g2d.drawImage(img, xCoordinateToDraw, yCoordinateToDraw, null);
//			this.xCoordinateOfLastImageDrawn = xCoordinateToDraw;
//			this.yCoordinateOfLastImageDrawn = yCoordinateToDraw;
//			this.speedOfLastImageDrawn = nextWechsel.getKmh();
//		}
//	}
//
//
//	private boolean yCoordinatesTooClose(int yCoordinateToDraw, int imageHeight) {
//		int distance = Math.abs(yCoordinateToDraw + imageHeight - this.yCoordinateOfLastImageDrawn);
//		return distance < imageHeight;
//	}
//
//
//	private void drawRectangles(Graphics2D g2d, double prozent, int untergrenze, int alteUntergrenze) {
//		if (prozent == 100) {
//			Shape rect4 = new Rectangle(216, untergrenze, 23, alteUntergrenze);
//			g2d.fill(rect4);
//			g2d.draw(rect4);
//		}
//		if (prozent >= 75) {
//			Shape rect3 = new Rectangle(193, untergrenze, 23, alteUntergrenze);
//			g2d.fill(rect3);
//			g2d.draw(rect3);
//		}
//		if (prozent >= 50) {
//			Shape rect2 = new Rectangle(170, untergrenze, 23, alteUntergrenze);
//			g2d.fill(rect2);
//			g2d.draw(rect2);
//		}
//		if (prozent >= 1) {
//			Shape rect1 = new Rectangle(147, untergrenze, 23, alteUntergrenze);
//			g2d.fill(rect1);
//			g2d.draw(rect1);
//		}
//	}
//
//
//	private void drawIndicationMarker(Graphics2D g2d) {
//		// System.out.println(posOfIndicationMarker);
//		Graphics2D g = (Graphics2D) g2d.create();
//		g.setColor(DMIUtility.instance().getColor(DMIColor.YELLOW));
//		int currentPosition = MainFrame.getHauptFrame().getPosition();
//		int y = 270 - calculateDistance((int) (currentPosition - this.posOfIndicationMarker));
//		g.setStroke(new BasicStroke(3));
//		g.drawLine(147, y, 417, y);
//		g.dispose();
//	}
//
//
//	/**
//	 * Diese Funktion soll die Distanz in der TargetBar darstellen Von 0 - 100m
//	 * ist die Berechnung linear. Von 100-1000 soll diese logarithmisch erfolgen
//	 *
//	 * @param distanz in meter
//	 * @return int skalierte ergebnis
//	 */
//	protected int calculateDistance(int distanz) {
//		int ergebnis = 0;
//		double logDistanz = log2(distanz);
//
//		// lineare Berechnung
//		if (distanz >= 0 && distanz < this.range[6] * this.multi) {
//			ergebnis = distanz * 33 / 100;
//		}
//		// logarithmische Berechnung des Balkens
//		else if (distanz >= this.range[6] * this.multi && distanz < this.range[13] * this.multi) {
//			double anfang = log2(this.range[6] * this.multi);
//			double ende = log2(this.range[13] * this.multi);
//			double messSkala = ende - anfang;
//
//			// Prozentualen Anteil
//			double temp = 100 * (logDistanz - anfang) / messSkala;
//
//			// umrechnen in Logarithmus skala
//			ergebnis = (int) (229 * temp / 100) + 33;
//		}
//		// Volle Anzeige des Balkens
//		else if (distanz >= this.range[13] * this.multi) {
//			ergebnis = 262;
//		}
//
//		return ergebnis;
//	}
//
//
//	private static final double LOG2 = Math.log(2);
//
//
//	/**
//	 * Funktion berechnet den Logarithmus von der uebergebenen Zahl
//	 *
//	 * @param zahl x von der der Logarithmus berechnet werden soll
//	 * @return berechneter Logarithmus Wert
//	 */
//	public static double log2(double x) {
//		return Math.log(x) / LOG2;
//	}
//
//
//	/**
//	 * Bis multiplikator auf 32: multi++.
//	 */
//	public final boolean multiplikatorPP() {
//		if (this.multi < 16) {
//			this.multi *= 2;
//			return true;
//		} else if (this.multi == 16) {
//			this.multi *= 2;
//			return false;
//		}
//		return false;
//	}
//
//
//	/**
//	 * Bis multiplikator auf 1: multi--.
//	 */
//	public final boolean multiplikatorMM() {
//		if (this.multi > 2) {
//			this.multi /= 2;
//			return true;
//		} else if (this.multi == 2) {
//			this.multi /= 2;
//			return false;
//		}
//		return false;
//	}
//
//
//	public void setProfile(RouteProfile profile) {
//		this.profil = profile;
//	}
//
//
//	public void setIndicationMarker(float nextBreakingPoint) {
//		this.posOfIndicationMarker = nextBreakingPoint;
//	}
//}
