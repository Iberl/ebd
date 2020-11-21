package de.ibw.tms;

import de.ibw.util.StatusMessageAppender;

import javax.swing.*;
import java.awt.*;
/**
 * Loggt Ausgaben des Benutzers.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class LoggingFrame extends JFrame {

    /**
     * Instanziiert das Logging in einem extra Fenster.
     */
    public LoggingFrame() {
        super("TMS Logs");
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        JTextArea TA = new JTextArea();
        getContentPane().add(TA, BorderLayout.CENTER);
        setSize(1000, 300);
        new StatusMessageAppender(TA);
        this.setVisible(true);
    }


}
