package ebd.globalUtils.events.logger;

import ebd.globalUtils.events.NormalEvent;

import java.io.PipedInputStream;
import java.util.List;

public class LogToGUIPipeEvent extends NormalEvent {

    public PipedInputStream logPipedInputStream;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     * @param pipedInputStream A connected {@link PipedInputStream}
     */
    public LogToGUIPipeEvent(String source, List<String> targets, PipedInputStream pipedInputStream) {
        super(source, targets);
        this.logPipedInputStream = pipedInputStream;
    }
}
