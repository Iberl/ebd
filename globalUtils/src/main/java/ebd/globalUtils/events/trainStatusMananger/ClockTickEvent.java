package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.NormalEvent;

import java.util.List;

/**
 * This event signals a clock tick.
 * Because the clock sending these ticks can be paused and continued at any moment, the best way to measure
 * the time between two clock ticks is to use the provided deltaT or modifiedDeltaT.
 * When in doubt, use the modified DeltaT, which includes the time acceleration factor that speeds up or slows down
 * the time simulation.
 */
public class ClockTickEvent extends NormalEvent {
    /**
     * Time difference between this ClockTickEvent and the last ClockTickEvent in [s]
     */
    private double deltaT;

    /**
     * Time difference between this ClockTickEvent and the last ClockTickEvent in [s],
     * modified by the time acceleration factor {@link ebd.globalUtils.configHandler.ConfigHandler#timeAccFactor}.
     */
    public double modifiedDeltaT;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *
     * @param targets ID from all modules the event is adressed to
     *
     * @param deltaT Time difference between this ClockTickEvent and the last ClockTickEvent in [s]
     */
    public ClockTickEvent(String source, List<String> targets, double deltaT) {
        super(source, targets);
        this.deltaT = deltaT;
        this.modifiedDeltaT = deltaT * ConfigHandler.getInstance().timeAccFactor;
    }

    /**
     * Use only if you really need the unmodified time between clock tick events.
     * @return unmodified deltaT in [s]
     */
    public double getDeltaT() {
        return deltaT;
    }
}
