package ebd.logging.util.handler;


import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.logger.LogToGUIPipeEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class PipeHandler extends Handler {

    private ConfigHandler ch = ConfigHandler.getInstance();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[uuuu-MM-dd HH:mm:ss");
    private PipedOutputStream pos;
    private BufferedWriter out;


    public PipeHandler() throws IOException {
        super();
        PipedOutputStream pos = new PipedOutputStream();
        this.pos = pos;
        this.out = new BufferedWriter(new OutputStreamWriter(this.pos));
        PipedInputStream pis = new PipedInputStream(this.pos);
        EventBus.getDefault().postSticky(new LogToGUIPipeEvent("log", Collections.singletonList("szenario"), pis));
    }

    @Override
    public void publish(LogRecord record) {
        if(!record.getLevel().equals(Level.INFO) || !ch.allowGUI) {
            //TODO Connect Level with config.txt
            return;
        }
        LocalDateTime ldt = LocalDateTime.ofInstant(record.getInstant(), ZoneId.systemDefault());
        String msg = "[" + ldt.format(this.dtf) + "] " + record.getMessage();
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
