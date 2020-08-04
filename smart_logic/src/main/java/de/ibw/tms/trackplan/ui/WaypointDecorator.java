package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.plan.elements.UiTools;
import de.ibw.tms.train.ui.SingleTrainSubPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WaypointDecorator extends Waypoint implements IWaypoint, IPaintable {


    private int x;
    private int y;

    private static BufferedImage img = null;
    public BufferedImage getImage() throws IOException {


        if(null == img) {
            ClassLoader cl = this.getClass().getClassLoader();
            img = UiTools.handleImaging(cl, "images/WaypointY.png");

        }
        return img;

    }

    public WaypointDecorator(TrackElement startElement, TrackElementStatus TeStatus, int xPixel, int yPixel ) {
        super( startElement, TeStatus);

        this.x = xPixel;
        this.y = yPixel;


    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
