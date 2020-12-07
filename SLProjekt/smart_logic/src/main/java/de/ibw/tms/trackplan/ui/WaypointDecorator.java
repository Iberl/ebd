package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.physical.MovableTrackElement;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.plan.elements.UiTools;
import de.ibw.tms.train.ui.SingleTrainSubPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Ein Wrapper von Wapoints.
 * Start und Endpunkt sind nicht als Waypoints modeliert worden.
 * Diese Klasse macht auch für Start- oder End-Knoten  - Waypoint-Funktionen verf&uuml;gbar.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-12
 */
public class WaypointDecorator extends Waypoint implements IWaypoint, IPaintable {


    private int x;
    private int y;

    private static BufferedImage img = null;

    public WaypointDecorator(MoveableTrackElement trackElement, TrackElementStatus elementStatus) {
        super(trackElement, elementStatus);
    }

    private BufferedImage getImage() throws IOException {


        if(null == img) {
            ClassLoader cl = this.getClass().getClassLoader();
            img = UiTools.handleImaging(cl, "images/WaypointY.png");

        }
        return img;

    }



    /**
     * Zeichnet Bild des Decorators mit Beschriftung.
     * @param g2d {@link Graphics2D} Zeichenutil.
     */

    @Override
    public void paintImage(Graphics2D g2d) {

        try {
            BufferedImage Image = this.getImage();
            if(Image == null) {
                g2d.drawString("W",this.x, this.y);
            } else {
                g2d.drawImage(this.getImage(), null, (int) Math.ceil(this.x * SingleTrainSubPanel.xFactor), this.y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
