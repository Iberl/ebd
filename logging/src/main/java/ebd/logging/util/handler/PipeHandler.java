package ebd.logging.util.handler;


import ebd.globalUtils.events.logger.LogToGUIPipeEvent;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Collections;
import java.util.logging.StreamHandler;

public class PipeHandler extends StreamHandler {

    public PipeHandler() throws IOException {
        super();
        System.out.println("Pipe Handler");
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
        pos.connect(pis);
        setOutputStream(pos);
        EventBus.getDefault().postSticky(new LogToGUIPipeEvent("log", Collections.singletonList("szenario"), pis));
    }
}
