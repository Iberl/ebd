package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.SectionOfLine;
import de.ibw.tms.ma.SpotLocation;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.UiTools;
import de.ibw.tms.train.ui.SingleTrainSubPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * Der End-Waypoint einer Route einer Ma-Beantragung
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-12
 */
public class WaypointEnd extends SpotLocation implements IWaypoint, IPaintable {


    private int x;
    private int y;

    private static BufferedImage img = null;
    private BufferedImage getImage() throws IOException {


        ClassLoader cl = this.getClass().getClassLoader();
        if(null == img) {
            img = UiTools.handleImaging(cl,"images/WaypointG.png");

        }
        return img;

    }

    /**
     * Generiert End-Waypoint
     * @param C - unused
     * @param endElement - letztes Element der Route
     * @param Section - unused
     * @param xPixel int x-Zeichenpositon - nicht reale Position in der Streckenansicht.
     * @param yPixel int y-Zeichenpositon - nicht reale Position in der Streckenansicht.
     */
    public WaypointEnd(Chainage C, TrackElement endElement, SectionOfLine Section, int xPixel, int yPixel ) {
        super(C,endElement,Section);

        this.x = xPixel;
        this.y = yPixel;


    }

    /**
     * unused
     * @return
     */

    @Override
    public Chainage getChainage() {
        return super.getChainage();
    }

    /**
     * Zeichent Bild des End-Waypoints.
     * Fals das Bild nicht geladen werden kann wird ein Schriftzug geschrieben.
     * @param g2d {@link Graphics2D} - Zeichenutil
     */

    @Override
    public void paintImage(Graphics2D g2d) {

        try {
            BufferedImage Img = this.getImage();
            if(Img == null) {
                g2d.drawString("WayEnd", this.x,this.y);
            }
            g2d.drawImage(Img, null,  (int) Math.ceil(this.x * SingleTrainSubPanel.xFactor), this.y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gibt Element von Waypoint wider
     * @return TrackElement
     */

    @Override
    public TrackElement getTrackElement() {
        return super.getTrackElement();
    }

}
