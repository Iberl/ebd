package de.ibw.util;

import javax.swing.JTextArea;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Diese gibt das Logging in ein Textfeld.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class StatusMessageAppender extends AppenderSkeleton {
    private final JTextArea jTextA;

    /**
     * Intialisiert ein Textfeld f&uuml;r ein Logging.
     * @param jTextArea {@link JTextArea}
     */
    public StatusMessageAppender(JTextArea jTextArea) {
        jTextA = jTextArea;
        LogManager.getRootLogger().addAppender(this);
    }

    /**
     * Schreibt ein Log in das Textfeld
     * @param event {@link LoggingEvent} - Log Ereignis
     */
    protected void append(LoggingEvent event)
    {
        if(event.getLevel().equals(Level.INFO) || event.getLevel().equals(Level.ERROR)){
            jTextA.append(event.getMessage().toString());
        }
    }

    /**
     * Entfernt den Appender. Es werden keine Nachrichten mehr hierdurch in das Text-Feld gegeben.
     */
    public void close()
    {
    }

    /**
     * Siehe implemntiertes Interface
     * Signalisiert Appender ohne Layout.
     * @return boolean
     */
    public boolean requiresLayout()
    {
        return false;
    }
}