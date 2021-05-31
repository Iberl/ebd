package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.position.Position;

public class NewPositionEvent extends NormalEvent {

    public final Position newPosition;

    public NewPositionEvent(String source, String target, Position newPos) {
        super(source, target);
        this.newPosition = newPos;
    }
}
