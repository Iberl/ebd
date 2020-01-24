package ebd.globalUtils.events.dmi;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;

import java.util.List;

public class DMIUpdateEvent extends NormalEvent {

    private double currentSpeed;
    private double currentTargetSpeed;
    private int targetDistance;
    private SpeedInterventionLevel speedInterventionLevel;
    private double currentIndSpeed;
    private double currentWarnSpeed;
    private double currentIntervSpeed;


    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *                TODO: Define Format for IDs
     * @param targets ID from all modules the event is adressed to
     */
    public DMIUpdateEvent(String source, List<String> targets, double currentSpeed, double targetSpeed, int targetDistance, SpeedInterventionLevel speedInterventionLevel, double currentIndSpeed, double currentWarnSpeed, double currentIntervSpeed) {
        super(source, targets);
        this.currentSpeed = currentSpeed;
        this.currentTargetSpeed = targetSpeed;
        this.targetDistance = targetDistance;
        this.speedInterventionLevel = speedInterventionLevel;
        this.currentIndSpeed = currentIndSpeed;
        this.currentWarnSpeed = currentWarnSpeed;
        this.currentIntervSpeed = currentIntervSpeed;
    }


    public double getCurrentSpeed() {
        return this.currentSpeed*3.6;
    }

    public double getCurrentTargetSpeed() {
        return this.currentTargetSpeed*3.6;
    }

    public int getTargetDistance() {return this.targetDistance;}

    public SpeedInterventionLevel getSpeedInterventionLevel() {
        return this.speedInterventionLevel;
    }

    public double getCurrentIndSpeed() {
        return this.currentIndSpeed*3.6;
    }

    public double getCurrentWarnSpeed() {
        return this.currentWarnSpeed*3.6;
    }

    public double getCurrentIntervSpeed() {
        return this.currentIntervSpeed*3.6;
    }
}
