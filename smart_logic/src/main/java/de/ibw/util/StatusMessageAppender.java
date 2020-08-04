package de.ibw.util;

import javax.swing.JTextArea;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.spi.LoggingEvent;


public class StatusMessageAppender extends AppenderSkeleton {
    private final JTextArea jTextA;

    public StatusMessageAppender(JTextArea jTextArea) {
        jTextA = jTextArea;
        LogManager.getRootLogger().addAppender(this);
    }
    protected void append(LoggingEvent event)
    {
        if(event.getLevel().equals(Level.INFO) || event.getLevel().equals(Level.ERROR)){
            jTextA.append(event.getMessage().toString());
        }
    }
    public void close()
    {
    }
    public boolean requiresLayout()
    {
        return false;
    }
}