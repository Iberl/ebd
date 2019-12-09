package ebd.globalUtils.events.trainStatusMananger;

import ebd.globalUtils.events.NormalEvent;

import java.util.List;

public class NewMaRequestParametersEvent extends NormalEvent {
    public NewMaRequestParametersEvent(String source, List<String> targets) {
        super(source,targets);
    }
}
