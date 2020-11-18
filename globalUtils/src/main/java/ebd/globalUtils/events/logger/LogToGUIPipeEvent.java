package ebd.globalUtils.events.logger;

import ebd.globalUtils.events.NormalEvent;

import java.io.PipedInputStream;

public class LogToGUIPipeEvent extends NormalEvent {

    public PipedInputStream logPipedInputStream;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or "all" if more then one target should be reached.
     * @param pipedInputStream A connected {@link PipedInputStream}
     */
    public LogToGUIPipeEvent(String source, String target, PipedInputStream pipedInputStream) {
        super(source, target);
        this.logPipedInputStream = pipedInputStream;
    }
}
