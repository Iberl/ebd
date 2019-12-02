package ebd.globalUtils.events.dmi;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.position.Position;

import java.util.List;

public class DMIUpdateEvent extends NormalEvent {

    private double currentSpeed;
    private double currentTargetSpeed;
    private int targetDistance;


    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public DMIUpdateEvent(String source, List<String> targets, double currentSpeed, double targetSpeed, int targetDistance) {
        super(source, targets);
        this.currentSpeed = currentSpeed;
        this.currentTargetSpeed = targetSpeed;
        this.targetDistance = targetDistance;
    }


    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public double getCurrentTargetSpeed() {
        return this.currentTargetSpeed;
    }

    public int getTargetDistance() {return this.targetDistance;}
}
