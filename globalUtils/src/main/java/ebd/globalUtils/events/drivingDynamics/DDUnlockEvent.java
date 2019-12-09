package ebd.globalUtils.events.drivingDynamics;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class DDUnlockEvent extends NormalEvent {
    /**
     * Constructs an Event that unlocks DrivingDynamics, allowing execution of code
     * This will generate a new DynamicState
     * TrainDataVolatile and RoutDataVolatile have to be set completely befor unlocking!
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is adressed to
     */
    public DDUnlockEvent(String source, List<String> targets) {
        super(source, targets);
    }
}
