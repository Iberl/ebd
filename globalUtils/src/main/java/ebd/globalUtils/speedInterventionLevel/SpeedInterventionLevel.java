package ebd.globalUtils.speedInterventionLevel;

/**
 * This represents the different kind of intervention level that the speed supervision module (SSM) can reach.
 */
public enum SpeedInterventionLevel {
    /**
     * Null replacement
     */
    NOT_SET(0),

    /**
     * Speed is uncritical
     */
    NO_INTERVENTION(1),

    /**
     * Permitted Speed is nearly reached
     */
    INDICATION(2),

    /**
     * Permitted speed is exceeded
     */
    PERMITTED_SPEED(3),

    /**
     * Service breaks will intervene if speed is not reduced
     */
    WARNING(4),

    /**
     * As required by SRS 3.13
     * Signals the need to cut of traction.
     */
    CUT_OFF_TRACTION(5),

    /**
     * Service break intervention is necessary, service breaks will be applied automatically
     */
    APPLY_SERVICE_BREAKS(6),

    /**
     * Speed is to far to high, danger point is passed, etc., emergency breaks will be applied automatically
      */
    APPLY_EMERGENCY_BREAKS(7);

    private Integer severity;

    SpeedInterventionLevel(int severity) {
        this.severity = severity;
    }

    public boolean isHigherThan(SpeedInterventionLevel other) {
        return this.severity > other.severity;
    }

    public boolean isLowerThan(SpeedInterventionLevel other) {
        return this.severity < other.severity;
    }
}
