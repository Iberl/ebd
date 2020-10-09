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
    OVERSPEED(3),

    /**
     * Service breaks will intervene if speed is not reduced
     */
    WARNING(4),

    /**
     * Service break intervention is necessary, service breaks will be applied automatically
     */
    APPLY_SERVICE_BREAKS(5),

    /**
     * Speed is to far to high, danger point is passed, etc., emergency breaks will be applied automatically
      */
    APPLY_EMERGENCY_BREAKS(6);

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
