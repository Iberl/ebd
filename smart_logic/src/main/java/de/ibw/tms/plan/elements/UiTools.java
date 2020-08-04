package de.ibw.tms.plan.elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class UiTools {
    public static BufferedImage handleImaging(ClassLoader cl, String s) throws IOException {
        try {
            return ImageIO.read(Objects.requireNonNull(cl.getResource(s)));
        } catch (NullPointerException NPE) {
            return null;
        }
    }
}
