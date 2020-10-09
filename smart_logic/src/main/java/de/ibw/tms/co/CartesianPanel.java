package de.ibw.tms.co;

import javax.swing.*;
import java.awt.*;


/**
 * Diese Komponente ist ein Panel mit Koordinatensystem
 * Angepasst von: iberl@verkehrt.tu-darmstadt.de
 *
 *
 * @author Gemeinfreie Quelle
 *
 * @version 0.3
 * @since 2020-08-10
 */
public class CartesianPanel extends JPanel {
    // x-axis coord constants

    /**
     * Start der x-Achse vom linken Panelrand (Das ist auch der Ursprung der X-Coordinate)
     */
    public static final int X_AXIS_FIRST_X_COORD = 50;
    /**
     * Ende der X-Achse vom linken Panelrand
     */
    public static final int X_AXIS_SECOND_X_COORD = 600;
    /**
     * Abstand der x-Achse vom oberen Panelrand
     */
    public static final int X_AXIS_Y_COORD = 600;

    // y-axis coord constants

    /**
     * Ende der y-Achse vom oberen Panelrand
     */
    public static final int Y_AXIS_FIRST_Y_COORD = 50;
    /**
     * Start der y-Achse vom oberen Panelrand (Ursprung)
     */
    public static final int Y_AXIS_SECOND_Y_COORD = 600;
    /**
     * Abstand der y-Achse vom linke Panelrand
     */
    public static final int Y_AXIS_X_COORD = 50;

    //arrows of axis are represented with "hipotenuse" of
    //triangle
    // now we are define length of cathetas of that triangle
    /**
     * integers die die Pfeile der Achsen zeichnbar machen.
     * Pfeil&auml;nge auf der Achse.
     *
     * Der Pfeil erstreckt sich auf 10 Punkteinheiten der Achse.
     */
    public static final int FIRST_LENGHT = 10;
    /**
     * Abstand des Punktes auf dem Pfeilschenkel zur Achse.
     * Der Pfeil ist 5 Punkte von der Achse ausgedeht.
     * Er ist also auch 10 Punkte breit.
     */
    public static final int SECOND_LENGHT = 5;

    // size of start coordinate lenght
    /**
     * wie Dick ist der Punkt im Urspurng.
     */
    public static final int ORIGIN_COORDINATE_LENGHT = 6;

    // distance of coordinate strings from axis
    /**
     * wie weit ist die Beschriftung von der Achse entfernt.
     */
    public static final int AXIS_STRING_DISTANCE = 30;
    /**
     * Anzahl der x-Achsenbeschriftungen.
     * Die Achse startet mit 1 und es gibt xCoordNumbers als Anzahl.
     * Die Beschriftung ist auf der Achse Gleichverteilt.
     */
    public int xCoordNumbers;
    /**
     * Anzahl der y-Achsenbeschriftungen.
     * Die Achse startet mit 1 und es gibt yCoordNumbers als Anzahl.
     * Die Beschriftung ist auf der Achse Gleichverteilt.
     */
    public int yCoordNumbers;

    /**
     * Zeichnet das Koordinatensystem auf dem Panel.
     * @param g {@link Graphics} - java Zeichen object
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        drawAxis(g2);

        // draw text "X" and draw text "Y"
        g2.drawString("X", X_AXIS_SECOND_X_COORD - AXIS_STRING_DISTANCE / 2,
                X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        g2.drawString("Y", Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                Y_AXIS_FIRST_Y_COORD + AXIS_STRING_DISTANCE / 2);
        g2.drawString("(0, 0)", X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE,
                Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);




        int xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD)
                / xCoordNumbers;
        int yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD)
                / yCoordNumbers;

        // draw x-axis numbers
        for(int i = 1; i < xCoordNumbers; i++) {
            g2.drawLine(X_AXIS_FIRST_X_COORD + (i * xLength),
                    X_AXIS_Y_COORD - SECOND_LENGHT,
                    X_AXIS_FIRST_X_COORD + (i * xLength),
                    X_AXIS_Y_COORD + SECOND_LENGHT);
            g2.drawString(Integer.toString(i),
                    X_AXIS_FIRST_X_COORD + (i * xLength) - 3,
                    X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        }

        //draw y-axis numbers
        for(int i = 1; i < yCoordNumbers; i++) {
            g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
                    Y_AXIS_SECOND_Y_COORD - (i * yLength),
                    Y_AXIS_X_COORD + SECOND_LENGHT,
                    Y_AXIS_SECOND_Y_COORD - (i * yLength));
            g2.drawString(Integer.toString(i),
                    Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                    Y_AXIS_SECOND_Y_COORD - (i * yLength));
        }
    }

    /**
     * Algorthmus der die Achsen zeichnet.
     * @param g2 {@link Graphics2D} -  2d Zeichenfunktion
     */
    protected void drawAxis(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // x-axis
        g2.drawLine(X_AXIS_FIRST_X_COORD, X_AXIS_Y_COORD,
                X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
        // y-axis
        g2.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD,
                Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);

        // x-axis arrow
        g2.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT,
                X_AXIS_Y_COORD - SECOND_LENGHT,
                X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
        g2.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT,
                X_AXIS_Y_COORD + SECOND_LENGHT,
                X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);

        // y-axis arrow
        g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
                Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT,
                Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);
        g2.drawLine(Y_AXIS_X_COORD + SECOND_LENGHT,
                Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT,
                Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);

        // draw origin Point
        g2.fillOval(
                X_AXIS_FIRST_X_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
                Y_AXIS_SECOND_Y_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
                ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);
    }
}
