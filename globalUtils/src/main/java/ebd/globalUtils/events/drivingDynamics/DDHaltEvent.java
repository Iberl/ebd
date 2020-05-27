package ebd.globalUtils.events.drivingDynamics;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class DDHaltEvent extends NormalEvent {
    /**
     * Constructs an Event that locks DrivingDynamics, preventing it of executing code
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or "all" if more then one target should be reached.
     */
    public DDHaltEvent(String source, String target) {
        super(source, target);
    }
}
