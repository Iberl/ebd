package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.position.Position;

import java.util.List;

/**
 * ONLY EVER LISTEN TO THIS EVENT WITH {@link org.greenrobot.eventbus.ThreadMode#ASYNC} !!
 */
public class PositionEvent extends NormalEvent {

    public Position position;

    /**
     * Constructs an Event
     *
     * @param source  ID from the module the event was sent by
     * @param targets ID from all modules the event is addressed to
     */
    public PositionEvent(String source, List<String> targets, Position position) {
        super(source, targets);
        this.position = position;
    }
}