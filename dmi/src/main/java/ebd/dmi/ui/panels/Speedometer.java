package ebd.dmi.ui.panels;

//import ebd.dmi.ui.MainFrame;
import ebd.dmi.ui.templates.MyLabel;
import ebd.dmi.ui.templates.MyPanel;
import ebd.dmi.ui.utility.DMIColor;
import ebd.dmi.ui.utility.DMISound;
import ebd.dmi.ui.utility.DMIUtility;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.*;

/**
 * @author <i>Aron</i><br>
 */
public class Speedometer extends MyPanel {

	private static final long serialVersionUID = -3594284079491224497L;

	protected static final int WIDTH = 280;
	protected static final int HEIGHT = 300;

	protected int majorTickCount;
	protected int majorTickValue;
	protected int minorTickCount;
	protected int minorTickStop;
	protected int maxVal;
	protected int[] array;
	protected Color colorForLowerArc;
	protected Color colorForUpperArc;
	protected Color colorForNeedle;
	protected Color colorForSpeed;
	protected Color bgColor;

	protected final MyLabel lblB11;
	protected final MyLabel lblB12;
	protected final MyLabel lblB13;

	protected Shape needle = createNeedle();

	protected int currentSpeed;
	protected int currentTargetSpeed;

	//default
	SpeedInterventionLevel speedInterventionLevel = SpeedInterventionLevel.NO_INTERVENTION;
	protected int currentIndSpeed;
	protected int currentWarnSpeed;
	protected int currentIntervSpeed;

	//	protected PanelMessages pm;
	protected boolean speedingOccured = false;


	public Speedometer(int[] array) {
		super(0, 0, WIDTH, HEIGHT);

		this.array = array;
		this.currentSpeed = 0;
		this.currentTargetSpeed = 0;
		this.majorTickCount = array[0];
		this.majorTickValue = array[1];
		this.minorTickCount = array[2];
		this.minorTickStop = array[3];
		this.maxVal = array[4];

		//TODO Farben ändern oder löschen
		this.bgColor = DMIUtility.instance().getColor(DMIColor.DARK_BLUE);
		this.colorForNeedle = DMIUtility.instance().getColor(DMIColor.WHITE);
		this.colorForLowerArc = DMIUtility.instance().getColor(DMIColor.RED);
		this.colorForUpperArc = DMIUtility.instance().getColor(DMIColor.RED);
		this.colorForSpeed = DMIUtility.instance().getColor(DMIColor.RED);

		Color black = DMIUtility.instance().getColor(DMIColor.BLACK);
		Color shadow = DMIUtility.instance().getColor(DMIColor.SHADOW);
		Border myBorder = new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, black), BorderFactory.createMatteBorder(0, 0, 1, 1, shadow));
		setBorder(new LineBorder(Color.WHITE));
		setBorder(myBorder);

		MyPanel panelB1 = new MyPanel(115, 125, 50, 50);
		panelB1.setOpaque(false);
		this.lblB11 = new MyLabel(0, 0, 16, 50, "");
		this.lblB11.setAlignmentY(RIGHT_ALIGNMENT);
		this.lblB11.setForeground(this.colorForSpeed);
		this.lblB11.setBorder(null);
		this.lblB11.setOpaque(false);
		panelB1.add(this.lblB11);
		this.lblB12 = new MyLabel(17, 0, 17, 50, "");
		this.lblB12.setAlignmentY(RIGHT_ALIGNMENT);
		this.lblB12.setForeground(this.colorForSpeed);
		this.lblB12.setBorder(null);
		this.lblB12.setOpaque(false);
		panelB1.add(this.lblB12);
		this.lblB13 = new MyLabel(33, 0, 17, 50, "");
		this.lblB13.setAlignmentY(RIGHT_ALIGNMENT);
		this.lblB13.setForeground(this.colorForSpeed);
		this.lblB13.setBorder(null);
		this.lblB13.setOpaque(false);
		panelB1.add(this.lblB13);
		panelB1.setBorder(null);
		this.add(panelB1);

		chooseColor();
	}


	private void chooseColor() {
		if (speedInterventionLevel.equals(SpeedInterventionLevel.NO_INTERVENTION)) {
			this.colorForNeedle = DMIUtility.instance().getColor(DMIColor.MEDIUM_GRAY);
			this.colorForLowerArc = DMIUtility.instance().getColor(DMIColor.DARK_GREY);
			this.colorForUpperArc = DMIUtility.instance().getColor(DMIColor.DARK_GREY);
			this.colorForSpeed = DMIUtility.instance().getColor(DMIColor.BLACK);
			this.lblB11.setBackground(this.colorForNeedle);
			this.lblB11.setForeground(this.colorForSpeed);
			this.lblB12.setBackground(this.colorForNeedle);
			this.lblB12.setForeground(this.colorForSpeed);
			this.lblB13.setBackground(this.colorForNeedle);
			this.lblB13.setForeground(this.colorForSpeed);
			//TODO: Abhängigkeiten von Message entfernen
			if (this.speedingOccured) {
//				if (this.pm != null) {
//					this.pm.addMessage("Reattained authorized speed");
//				}
				this.speedingOccured = false;
			}
		} else if (speedInterventionLevel.equals(SpeedInterventionLevel.INDICATION)) {
			this.colorForNeedle = DMIUtility.instance().getColor(DMIColor.YELLOW);
			this.colorForLowerArc = DMIUtility.instance().getColor(DMIColor.DARK_GREY);
			this.colorForUpperArc = DMIUtility.instance().getColor(DMIColor.YELLOW);
			this.colorForSpeed = DMIUtility.instance().getColor(DMIColor.BLACK);
			this.lblB11.setBackground(this.colorForNeedle);
			this.lblB11.setForeground(this.colorForSpeed);
			this.lblB12.setBackground(this.colorForNeedle);
			this.lblB12.setForeground(this.colorForSpeed);
			this.lblB13.setBackground(this.colorForNeedle);
			this.lblB13.setForeground(this.colorForSpeed);
			//TODO: Abhängigkeiten von Message entfernen
			if (this.speedingOccured) {
//				if (this.pm != null) {
//					this.pm.addMessage("Reattained authorized speed");
//				}
				this.speedingOccured = false;
			}
		} else if (speedInterventionLevel.equals(SpeedInterventionLevel.WARNING)) {
			//TODO: ändern
			this.colorForNeedle = DMIUtility.instance().getColor(DMIColor.ORANGE);
			this.colorForLowerArc = DMIUtility.instance().getColor(DMIColor.DARK_GREY);
			this.colorForUpperArc = DMIUtility.instance().getColor(DMIColor.YELLOW);
			this.colorForSpeed = DMIUtility.instance().getColor(DMIColor.BLACK);
			this.lblB11.setBackground(this.colorForNeedle);
			this.lblB11.setForeground(this.colorForSpeed);
			this.lblB12.setBackground(this.colorForNeedle);
			this.lblB12.setForeground(this.colorForSpeed);
			this.lblB13.setBackground(this.colorForNeedle);
			this.lblB13.setForeground(this.colorForSpeed);
			//TODO: Abhängigkeiten von Message entfernen
			if (this.speedingOccured) {
//				if (this.pm != null) {
//					this.pm.addMessage("Reattained authorized speed");
//				}
				this.speedingOccured = false;
			}
		} else if (speedInterventionLevel.equals(SpeedInterventionLevel.APPLY_SERVICE_BREAKS) || speedInterventionLevel.equals(SpeedInterventionLevel.APPLY_EMERGENCY_BREAKS)) {
			this.colorForNeedle = DMIUtility.instance().getColor(DMIColor.RED);
			this.colorForLowerArc = DMIUtility.instance().getColor(DMIColor.DARK_GREY);
			this.colorForUpperArc = DMIUtility.instance().getColor(DMIColor.YELLOW);
			this.colorForSpeed = DMIUtility.instance().getColor(DMIColor.WHITE);
			this.lblB11.setBackground(this.colorForNeedle);
			this.lblB11.setForeground(this.colorForSpeed);
			this.lblB12.setBackground(this.colorForNeedle);
			this.lblB12.setForeground(this.colorForSpeed);
			this.lblB13.setBackground(this.colorForNeedle);
			this.lblB13.setForeground(this.colorForSpeed);
			//TODO: Abhängigkeiten von Message entfernen
			if (!this.speedingOccured) {
//				if (this.pm != null) {
//					this.pm.addMessage("Speeding occured");
//				}
				this.speedingOccured = true;
				DMIUtility.instance().playSound(DMISound.TOO_FAST);
			}
		}
	}


	private void setSpeed(int value) {
		int hunderter = value / 100;
		int rest = value % 100;
		int zehner = rest / 10;
		int einer = rest % 10;

		lblB11.setFont(new Font("Chicago", Font.BOLD, 24));
		if(hunderter != 0) {
			this.lblB11.setText(String.valueOf(hunderter));
		} else {
			this.lblB11.setText("");

		}
		lblB12.setFont(new Font("Chicago", Font.BOLD, 24));
		if(hunderter != 0 || zehner != 0) {
			this.lblB12.setText(String.valueOf(zehner));
		} else {
			this.lblB12.setText("");

		}
		lblB13.setFont(new Font("Chicago", Font.BOLD, 24));
		this.lblB13.setText(String.valueOf(einer));
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = DMIUtility.instance().setupGrafik(g);
		double centerX = WIDTH / 2.0;
		double centerY = HEIGHT / 2.0;

		g2d.setColor(this.bgColor);
		g2d.fillRect(0, 0, WIDTH, HEIGHT);

		paintSpeedDial(g2d, this.array);
		paintCircularSpeedGauge(g2d, 125);

		g2d.setColor(this.colorForNeedle);
		double angle = getAngle(this.currentSpeed, this.maxVal);
		Shape needle = rotateShape(this.needle, angle, 0, 0);
		g2d.translate(centerX, centerY);
		g2d.fill(needle);
		g2d.draw(needle);
		g2d.translate(-centerX, -centerY);

		paintSpeedPointerCircle(g2d, centerX, centerY);

		g2d.dispose();
	}


	private void paintCircularSpeedGauge(Graphics2D g, int radius) {
		// Ellipse2D.Double kreisB0 = new Ellipse2D.Double(x - r, y - r, 2 * r,
		// 2 * r); g.draw(kreisB0);

		int startingAngle = 239;
		// Vsoll -> extend umwandeln = Vsoll * (288/400)
		double lowerArcExtend = -(this.currentIndSpeed * 0.72 + 4);
		double upperArcExtend = -((this.currentTargetSpeed - this.currentIndSpeed) * 0.72);

		if (this.currentSpeed > this.currentTargetSpeed) {
			drawUeberhang(g, startingAngle + lowerArcExtend + upperArcExtend, radius);
		}

		drawLowerArc(g, startingAngle, lowerArcExtend);
		drawUpperArc(g, startingAngle + lowerArcExtend, upperArcExtend);
		drawSpeedRectangle(g,startingAngle + lowerArcExtend + upperArcExtend);

	}


	private void drawLowerArc(Graphics2D g, double startingAngle, double extend) { ;
		g.setColor(this.colorForLowerArc);
		Area area = drawArc(137, 128, startingAngle, extend);
		g.fill(area);

	}


	private void drawUpperArc(Graphics2D g, double startingAngle, double extend) {
		g.setColor(this.colorForUpperArc);
		Area area = drawArc(137, 128, startingAngle, extend);
		g.fill(area);

//		double angle = Math.toRadians(-(startingAngle + extend - 90));
//		double mx = arc.getEndPoint().getX();
//		double my = arc.getEndPoint().getY();
//		Shape rect = new Rectangle2D.Double(mx - 2, my - 3, 6, 20);
//		rect = rotateShape(rect, angle, mx, my);
//		g.fill(rect);
//		g.draw(rect);
	}

	private void drawSpeedRectangle(Graphics2D g, double angle) {
        //double angle = Math.toRadians(-(startingAngle + extend - 90));
        Shape rect = new Rectangle2D.Double(140 + 117, 144, 20, 6);
        rect = rotateShape(rect, -Math.toRadians(angle), 140, 150);
        g.fill(rect);
    }


	private void drawUeberhang(Graphics2D g, double startingAngle, int radius) {
		g.setColor(colorForNeedle);
		double extend = -(this.currentSpeed - this.currentTargetSpeed) * 0.72;
		Area area = drawArc(137, 117, startingAngle, extend);
		g.fill(area);
	}


	private double getAngle(int kmh, int maxKmh) {
		final double delta = Math.toRadians(36);
		// 50 kmh = -125 + 290 * 0.5
		double currentSpeed = kmh;
		double Vsoll = maxKmh;
		double ratio = Math.toRadians(288) * (currentSpeed / Vsoll);
		// verhaeltnis zwischen: 0 - 4.913 ; war vorher 1.564 * Math.PI
		return delta + ratio;
	}


	private Shape rotateShape(final Shape base, final double angle, final double x, final double y) {
		if (base == null) {
			return null;
		}
		final AffineTransform rotate = AffineTransform.getRotateInstance(angle, x, y);
		return rotate.createTransformedShape(base);
	}


	private void paintSpeedPointerCircle(Graphics2D g, double x, double y) {
		final int d = 50;
		Ellipse2D.Double kreisB0 = new Ellipse2D.Double(x - d / 2, y - d / 2, d, d);
		g.fill(kreisB0);
		g.draw(kreisB0);
	}


	private void paintSpeedDial(Graphics2D g, int[] array) {
		g.setColor(Color.white);

		final int size = 280;
		final int offset = 30;
		int d = size - offset;
		int radius = d / 2 - 2;
		int mx = WIDTH / 2;
		int my = HEIGHT / 2;

		double delta = Math.toRadians(126);
		int majTickLength = 25;
		int minTickLength = 15;

		// TODO: variabel (je nach anzeige �ndern):
		int majorTickCount = array[0];
		int majorTickValue = array[1];
		int minorTickCount = array[2];
		int minorTickStop = array[3];
		int maxValue = array[4];

		final double majorTickAngle = Math.toRadians(288) / majorTickCount;
		final double minorTickAngle = Math.toRadians(288) / minorTickCount;
		final double RAD290 = Math.toRadians(290); // war 270

		// Major ticks
		for (int i = 0; i <= majorTickCount; i++) {
			double a = delta + i * majorTickAngle;
			if (a - delta > RAD290 || i * majorTickValue > maxValue) {
				break;
			}
			double cos = Math.cos(a);
			double sin = Math.sin(a);

			int x1 = (int) (cos * radius + mx);
			int y1 = (int) (sin * radius + my);

			int x2 = (int) (cos * (radius - majTickLength) + mx);
			int y2 = (int) (sin * (radius - majTickLength) + my);

			g.drawLine(x1, y1, x2, y2);

			// Draw labels
			String label = String.valueOf(i * majorTickValue);
			int fontWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), label);
			int x3 = (int) (cos * (radius - majTickLength - radius * 0.15) + mx);
			int y3 = (int) (sin * (radius - majTickLength - radius * 0.15) + my);
			g.drawString(label, x3 - fontWidth / 2f, y3);
		}

		// Minor ticks
		for (int i = 0; i <= minorTickCount; i++) {
			if (i % minorTickStop == 0) {
				continue;
			}
			double a = delta + i * minorTickAngle;
			if (a - delta > RAD290 || i * 10 > maxValue) {
				break;
			}
			double cos = Math.cos(a);
			double sin = Math.sin(a);

			int x1 = (int) (cos * radius + mx);
			int y1 = (int) (sin * radius + my);

			int x2 = (int) (cos * (radius - minTickLength) + mx);
			int y2 = (int) (sin * (radius - minTickLength) + my);

			g.drawLine(x1, y1, x2, y2);
		}
	}


	private Shape createNeedle() {
		final GeneralPath p0 = new GeneralPath();
		final int x = -4, y = 25;
		p0.moveTo(x, y);
		p0.lineTo(x + 9, y);
		p0.lineTo(x + 9, y + 57);
		p0.lineTo(x + 6, y + 65);
		p0.lineTo(x + 6, y + 80);

		p0.lineTo(x + 3, y + 80);
		p0.lineTo(x + 3, y + 65);
		p0.lineTo(x, y + 57);
		p0.lineTo(x, y);
		p0.closePath();

		return p0;
	}


	private Area drawArc(int outerRadius, int innerRadius, double startingAngle, double extent) {
		int centerX = 140;
		int centerY = 150;
		Shape outerArc = new Arc2D.Double(centerX - outerRadius, centerY - outerRadius, 2 * outerRadius, 2 * outerRadius, startingAngle, extent, Arc2D.PIE);
		Shape innerArc = new Arc2D.Double(centerX - innerRadius, centerY - innerRadius, 2 * innerRadius, 2 * innerRadius, startingAngle, extent, Arc2D.PIE);

		Area outerArcArea = new Area(outerArc);
		Area innerArcArea = new Area(innerArc);
		outerArcArea.subtract(innerArcArea);

		return outerArcArea;
	}

	/**
	 * @return currentSpeed
	 */
	public double getCurrentSpeed() {
		return this.currentSpeed;
	}


	/**
	 * @param currentSpeed
	 */
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
		setSpeed(currentSpeed);
		chooseColor();
		repaint();
	}


	/**
	 * @return currentTargetSpeed
	 */
	public int getCurrentTargetSpeed() {
		return this.currentTargetSpeed;
	}


	/**
	 * @param currentTargetSpeed
	 */
	public void setCurrentTargetSpeed(int currentTargetSpeed) {
		this.currentTargetSpeed = currentTargetSpeed;
		chooseColor();
		repaint();
	}

	public void setSpeedInterventionLevel(SpeedInterventionLevel speedInterventionLevel) {
		this.speedInterventionLevel = speedInterventionLevel;
		chooseColor();
		repaint();
	}

	public void setCurrentIndSpeed(int currentIndSpeed) {
		this.currentIndSpeed = currentIndSpeed;
		chooseColor();
		repaint();
	}

	public void setCurrentWarnSpeed(int currentWarnSpeed) {
		this.currentWarnSpeed = currentWarnSpeed;
		chooseColor();
		repaint();
	}

	public void setCurrentIntervSpeed(int currentIntervSpeed) {
		this.currentIntervSpeed = currentIntervSpeed;
		chooseColor();
		repaint();
	}
}
