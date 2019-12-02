package ebd.globalUtils.events.dmi;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.position.Position;

import java.util.List;

public class DMIUpdateEvent extends NormalEvent {

    public String msg;

    private double currentSpeed;
    private double currentTargetSpeed;
    private Position pos;


    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public DMIUpdateEvent(String source, List<String> targets, String msg, double currentSpeed, double targetSpeed) {
        super(source, targets);
        this.msg = msg;
        this.currentSpeed = currentSpeed;
        this.currentTargetSpeed = targetSpeed;
    }


    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public double getCurrentTargetSpeed() {
        return this.currentTargetSpeed;
    }
}
