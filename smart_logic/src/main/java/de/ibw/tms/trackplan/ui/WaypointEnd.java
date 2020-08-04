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

public class WaypointEnd extends SpotLocation implements IWaypoint, IPaintable {


    private int x;
    private int y;

    private static BufferedImage img = null;
    public BufferedImage getImage() throws IOException {


        ClassLoader cl = this.getClass().getClassLoader();
        if(null == img) {
            img = UiTools.handleImaging(cl,"images/WaypointG.png");

        }
        return img;

    }

    public WaypointEnd(Chainage C, TrackElement startElement, SectionOfLine Section, int xPixel, int yPixel ) {
        super(C,startElement,Section);

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
    public Chainage getChainage() {
        return super.getChainage();
    }

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

    @Override
    public TrackElement getTrackElement() {
        return super.getTrackElement();
    }

}
