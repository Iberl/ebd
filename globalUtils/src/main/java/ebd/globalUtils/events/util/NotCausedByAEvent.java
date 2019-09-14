package ebd.globalUtils.events.util;

import ebd.globalUtils.events.Event;

import java.util.Collections;

/**
 * This class is used to represent cases, where a {@link ebd.globalUtils.events.ExceptionEvent} is not caused by a Event.
 */
public final class NotCausedByAEvent extends Event {
    /**
     * This class is used to represent cases, where a {@link ebd.globalUtils.events.ExceptionEvent} is not caused by a Event.
     */
    public NotCausedByAEvent() {
        super("none", Collections.singletonList("none"));
    }
}
