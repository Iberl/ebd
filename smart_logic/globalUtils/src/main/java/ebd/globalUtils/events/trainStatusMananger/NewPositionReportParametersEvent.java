package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

public class NewPositionReportParametersEvent extends NormalEvent {
    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *
     * @param target ID from all modules the event is adressed to
     */
    public NewPositionReportParametersEvent(String source, String target) {
        super(source, target);
    }
}
