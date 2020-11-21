package de.ibw.tms.plan.elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
/**
 * Liest Bild aus den Ressourcen
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class UiTools {
    /**
     * Gibt angegebenes Bild wider.
     * @param cl {@link ClassLoader} kann vom Klassenattribut bezuogen werden
     * @param s {@link String} - Bezeichnung in den Ressourcen
     * @return BufferedImage - Bild als Ergebnis oder null wenn nicht gefunden
     * @throws IOException - Falls eine Datei nicht zugreifbar ist
     */
    public static BufferedImage handleImaging(ClassLoader cl, String s) throws IOException {
        try {
            return ImageIO.read(Objects.requireNonNull(cl.getResource(s)));
        } catch (NullPointerException NPE) {
            return null;
        }
    }
}
