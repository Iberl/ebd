package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

public class NewMaRequestParametersEvent extends NormalEvent {
    public NewMaRequestParametersEvent(String source, String target) {
        super(source,target);
    }
}
