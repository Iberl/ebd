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
 * Der Start-Waypoint einer Route einer Ma-Beantragung.
 * Wird durch Zug-Position ersetzt und eigentlich nicht mehr benutzt.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-12
 */
public class WaypointStart extends SpotLocation implements IWaypoint,IPaintable {


    private int x;
    private int y;

    private static BufferedImage img = null;
    private BufferedImage getImage() throws IOException {


        ClassLoader cl = this.getClass().getClassLoader();
        if(null == img) {
            img = UiTools.handleImaging(cl,"images/WaypointR.png");

        }
        return img;

    }
    /**
     * Generiert Start-Waypoint
     * @param C - unused
     * @param startElement - erstets Element der Route
     * @param Section - unused
     * @param xPixel int x-Zeichenpositon - nicht reale Position in der Streckenansicht.
     * @param yPixel int y-Zeichenpositon - nicht reale Position in der Streckenansicht.
     */
    public WaypointStart(Chainage C, TrackElement startElement, SectionOfLine Section, int xPixel, int yPixel ) {
        super(C,startElement,Section);

        this.x = xPixel;
        this.y = yPixel;


    }



    /** unused */

    @Override
    public Chainage getChainage() {
        return super.getChainage();
    }

    /**
     * Zeichnet Startpunkt
     * @param g2d {@link Graphics2D} - Zeichenutil
     */

    @Override
    public void paintImage(Graphics2D g2d) {

        try {
            BufferedImage Img = this.getImage();
            if(Img == null) {
                g2d.drawString("WayStart", this.x,this.y);
            } else {
                g2d.drawImage(Img, null, (int) Math.ceil(this.x * SingleTrainSubPanel.xFactor), this.y);
            }
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    /**
     * Gibt TrackElment wider
     * @return TrackElement
     */
    @Override
    public TrackElement getTrackElement() {
        return super.getTrackElement();
    }
}
