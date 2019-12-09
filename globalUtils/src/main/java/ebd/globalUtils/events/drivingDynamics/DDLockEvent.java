package ebd.globalUtils.events.drivingDynamics;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class DDLockEvent extends NormalEvent {
    /**
     * Constructs an Event that locks DrivingDynamics, preventing it of executing code
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is adressed to
     */
    public DDLockEvent(String source, List<String> targets) {
        super(source, targets);
    }
}
