package de.ibw.tms;

import de.ibw.util.StatusMessageAppender;

import javax.swing.*;
import java.awt.*;

public class LoggingFrame extends JFrame {

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
