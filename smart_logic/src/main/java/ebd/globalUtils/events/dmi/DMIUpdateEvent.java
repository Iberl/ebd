package ebd.globalUtils.events.dmi;

import ebd.globalUtils.events.NormalEvent;

public class DMIUpdateEvent extends NormalEvent {

    public final String dmiUpdateString;

    public DMIUpdateEvent(String source, String target, String dmiUpdateString) {
        super(source, target);
        this.dmiUpdateString = dmiUpdateString;
    }
}
