package ebd.globalUtils.events.baliseTelegramGenerator;

import ebd.globalUtils.events.NormalEvent;

public class TriggerTelegramEvent extends NormalEvent {

    public String baliseId;
    public int    nid_operational;

    /**
     * Constructs an Event
     *
     * @param source
     *         ID from the module the event was sent by
     * @param nid_c
     *         ID of country
     * @param nid_bg
     *         ID of the balise group
     * @param n_pig
     *         Position of balise in group to trigger
     * @param nid_operational
     *         Running Train Number (etcsID) of the train which ran over the balise
     */
    public TriggerTelegramEvent(String source, int nid_c, int nid_bg, int n_pig, int nid_operational) {
        super(source, "btg");
        this.baliseId = nid_c + "-" + nid_bg + "-" + n_pig;
        this.nid_operational = nid_operational;
    }

}
