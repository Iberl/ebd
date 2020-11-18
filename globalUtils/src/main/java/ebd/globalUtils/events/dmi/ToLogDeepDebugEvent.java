package ebd.globalUtils.events.dmi;

import ebd.globalUtils.events.NormalEvent;

public class ToLogDeepDebugEvent extends NormalEvent {

    public final String msg;

    /**
     * Constructs an Event
     *  @param source ID from the module the event was sent by
     * @param target ID from the module the event is addressed to or 'all' if more than on target should be reached
     * @param msg Message to log
     */
    public ToLogDeepDebugEvent(String source, String target, String msg) {
        super(source, target);
        this.msg = msg;
    }
}
