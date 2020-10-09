package de.ibw.tms.trackplan.ui;

import de.ibw.tms.plan.elements.UiTools;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * unused
 */
public class WaypointImage {
    private double x;
    private double y;
    private static BufferedImage img = null;

    public BufferedImage getImage() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        if(null == img) {
            img = UiTools.handleImaging(cl,"images/WaypointR.png");

        }
        return img;

    }

}
