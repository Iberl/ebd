package ebd.logging.util.handler;


import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.logger.LogToGUIPipeEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * This Class extends {@link Handler}. It is registered by {@link ebd.logging.Logging}.
 * While constructing, the {@link PipedInputStream} linked to the local {@link PipedOutputStream} is send into the EventBus
 * in a {@link LogToGUIPipeEvent}. It is used by the GUI Server to receive logging information.
 * Every time publish is called, the {@link LogRecord} is used to send a String containing logging data
 * to the pipe.
 */
public class PipeHandler extends Handler {

    private ConfigHandler ch = ConfigHandler.getInstance();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[HH:mm:ss.SS]");
    private PipedOutputStream pos;
    private BufferedWriter out;

    /**
     * This Class extends {@link Handler}. It is registered by {@link ebd.logging.Logging}.
     * While constructing, the {@link PipedInputStream} linked to the local {@link PipedOutputStream} is send into the EventBus
     * in a {@link LogToGUIPipeEvent}.
     * Every time publish is called, the {@link LogRecord} is used to send a String containing logging data
     * to the pipe.
     *
     * @throws IOException should an underlying method or constructor throw {@link IOException}.
     */
    public PipeHandler() throws IOException {
        super();
        PipedOutputStream pos = new PipedOutputStream();
        this.pos = pos;
        this.out = new BufferedWriter(new OutputStreamWriter(this.pos));
        PipedInputStream pis = new PipedInputStream(this.pos);
        EventBus.getDefault().postSticky(new LogToGUIPipeEvent("log", "szenario", pis));
    }

    /**
     * Publishes the record by constructing a String and writing it to the {@link PipedOutputStream}.
     * This String can then be read by the owner of the {@link PipedInputStream}.
     * @param record {@link LogRecord}
     */
    @Override
    public void publish(LogRecord record) {
        if(!record.getLevel().equals(Level.INFO) || !ch.allowGUI) {
            //TODO Connect Level with config.txt
            return;
        }
        LocalTime ldt = LocalTime.ofInstant(record.getInstant(), ZoneId.systemDefault());

        String msg = "[" + ldt.format(this.dtf) + "] " + record.getMessage();
        msg = msg.replaceAll("\\[\\d+m", ""); //Removes logging color codes from string

        try {
            this.out.write(msg);
            this.out.newLine();
            this.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void flush() {
        try {
            this.out.flush();
            this.pos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SecurityException {
        flush();
        try {
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
