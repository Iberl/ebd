package ebd.globalUtils.speedInterventionLevel;

/**
 * This represents the different kind of intervention level that the speed supervision module (SSM) can reach.
 */
public enum SpeedInterventionLevel {
    /**
     * Null replacement
     */
    NOT_SET,

    /**
     * Speed is uncritical
     */
    NO_INTERVENTION,

    /**
     * Permitted Speed is nearly reached
     */
    INDICATION,

    /**
     * Permitted speed is exceeded
     */
    PERMITTED_SPEED,

    /**
     * Service breaks will intervene if speed is not reduced
     */
    WARNING,

    /**
     * As required by SRS 3.13
     * Signals the need to cut of traction.
     */
    CUT_OFF_TRACTION,

    /**
     * Service break intervention is necessary, service breaks will be applied automatically
     */
    APPLY_SERVICE_BREAKS,

    /**
     * Speed is to far to high, danger point is passed, etc., emergency breaks will be applied automatically
      */
    APPLY_EMERGENCY_BREAKS
}
