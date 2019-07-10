package ebd.globalUtils.events.util;

import ebd.globalUtils.events.Event;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used to represent cases, where a {@link ebd.globalUtils.events.ExceptionEvent} is not caused by a Event.
 */
public final class NotCausedByAEvent extends Event {
    /**
     * This class is used to represent cases, where a {@link ebd.globalUtils.events.ExceptionEvent} is not caused by a Event.
     */
    public NotCausedByAEvent() {
        super("none", new ArrayList<String>(Arrays.asList("none")));
    }
}
