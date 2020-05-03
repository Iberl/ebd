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
     * Time difference between this ClockTickEvent and the last ClockTickEvent in [s],
     * modified by the time acceleration factor {@link ebd.globalUtils.configHandler.ConfigHandler#timeAccFactor}.
     */
    public double deltaT;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     *
     * @param target ID from from the target module or 'all' if more then one target should be reached.
     *
     * @param deltaT Time difference between this ClockTickEvent and the last ClockTickEvent in [s]
     */
    public ClockTickEvent(String source, String target, double deltaT) {
        super(source, target);
        this.deltaT = deltaT;
    }

}
