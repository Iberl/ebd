package ebd.globalUtils.events.dmi;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;

import java.util.List;

public class DMIUpdateEvent extends NormalEvent {

    private double currentSpeed;
    private double currentTargetSpeed;
    private int targetDistance;
    private double currentReleaseSpeed;
    private SpeedInterventionLevel speedInterventionLevel;
    private SpeedSupervisionState speedSupervisionState;
    private double currentIndSpeed;
    private double currentPermSpeed;
    private double currentWarnSpeed;
    private double currentIntervSpeed;


    /**
     * Constructs an Event
<<<<<<< HEAD
     * @param source ID from the module the event was sent by
     * @param target ID from the module the event is adressed to
=======
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is adressed to
     */
    /**
     *
     * @param source ID from the module the event was sent by
     * @param target ID from all modules the event is adressed to
>>>>>>> dev_trainSide
     * @param currentSpeed [m/s]
     * @param targetSpeed [m/s]
     * @param targetDistance
     * @param releaseSpeed [m/s]
     * @param speedInterventionLevel
     * @param speedSupervisionState
     * @param currentIndSpeed [m/s]
     * @param currentPermSpeed [m/s]
     * @param currentWarnSpeed [m/s]
     * @param currentIntervSpeed [m/s]
     */
    public DMIUpdateEvent(String source, String target, double currentSpeed, double targetSpeed, int targetDistance, double releaseSpeed,
                          SpeedInterventionLevel speedInterventionLevel, SpeedSupervisionState speedSupervisionState,
                          double currentIndSpeed, double currentPermSpeed, double currentWarnSpeed, double currentIntervSpeed) {
        super(source, target);
        this.currentSpeed = currentSpeed;
        this.currentTargetSpeed = targetSpeed;
        this.targetDistance = targetDistance;
        this.currentReleaseSpeed = releaseSpeed;
        this.speedInterventionLevel = speedInterventionLevel;
        this.speedSupervisionState = speedSupervisionState;
        this.currentIndSpeed = currentIndSpeed;
        this.currentPermSpeed = currentPermSpeed;
        this.currentWarnSpeed = currentWarnSpeed;
        this.currentIntervSpeed = currentIntervSpeed;
    }

    /**
     *
     * @return current speed [km/h]
     */
    public double getCurrentSpeed() {
        return this.currentSpeed*3.6;
    }

    /**
     *
     * @return current target speed [km/h]
     */
    public double getCurrentTargetSpeed() {
        return this.currentTargetSpeed*3.6;
    }


    public int getTargetDistance() {return this.targetDistance;}

    /**
     *
     * @return current release speed [km/h]
     */
    public double getCurrentReleaseSpeed() {
        return this.currentReleaseSpeed*3.6;
    }

    /**
     *
     * @return current indication speed [km/h]
     */
    public double getCurrentIndSpeed() {
        return this.currentIndSpeed*3.6;
    }

    /**
     *
     * @return current permitted speed [km/h]
     */
    public double getCurrentPermSpeed() {
        return this.currentPermSpeed*3.6;
    }

    /**
     *
     * @return current warning speed [km/h]
     */
    public double getCurrentWarnSpeed() {
        return this.currentWarnSpeed*3.6;
    }

    /**
     *
     * @return current intervention speed [km/h]
     */
    public double getCurrentIntervSpeed() {
        return this.currentIntervSpeed*3.6;
    }

    public SpeedInterventionLevel getSpeedInterventionLevel() {
        return this.speedInterventionLevel;
    }

    public SpeedSupervisionState getSpeedSupervisionState() {
        return speedSupervisionState;
    }


}
