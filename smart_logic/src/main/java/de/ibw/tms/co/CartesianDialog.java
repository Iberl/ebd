package de.ibw.tms.co;

import javax.swing.*;

/**
 * Diese Komponente ist ein modales Dialog-Fenster.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public abstract class CartesianDialog extends JDialog {

    /**
     * Dieser Construktur startet den Modalen Dialog
     * @param parentFrame {@link JFrame} - gibt den Frame der wegen der Modalit&auml;t gespertt wird, bis der Dialog geschlossen wird.
     * @param sFrameTitle {@link String} - Titel des Dialgosfensters
     */
    public CartesianDialog(JFrame parentFrame, String sFrameTitle) {
        super(parentFrame, sFrameTitle, true);



    }


}
