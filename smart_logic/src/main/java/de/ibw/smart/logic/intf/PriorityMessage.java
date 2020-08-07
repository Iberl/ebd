package de.ibw.smart.logic.intf;

import ebd.rbc_tms.Message;

import java.security.InvalidParameterException;
/**
 * Eine Nachricht die Priority einstellbarer Art hat
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public class PriorityMessage implements Comparable<PriorityMessage> {
    private Message Msg;
    // min is first
    private Long iPriority = 100L;

    /**
     * Holt die RBC-TMS-Nachricht aus dieser Klasse
     * @return Message - Naricht unwrapped
     */
    public Message getMsg() {
        return Msg;
    }

    /**
     * Konstruktor instanziiert Priority Nachricht mit Inhalt einer Nachricht an das oder aus dem RBC
     * @param M - Nachricht gekapselt
     * @param iPriority - Priority als Long-Value
     */
    public PriorityMessage(Message M, Long iPriority) {
        if(iPriority == null || M == null) throw new InvalidParameterException("Paramters must not be null");
        iPriority = iPriority;
        Msg = M;
    }

    /**
     * Gibt die Wichtigkeit der Nachricht als Long zur&uuml;ck
     * @return Long - priority
     */
    public Long getiPriority() {
        return iPriority;
    }

    public void setiPriority(Long iPriority) {
        this.iPriority = iPriority;
    }

    /**
     * Priority Vergleich
     * @param priorityMessage - zu vergleichende Nachricht
     * @return int
     */

    @Override
    public int compareTo(PriorityMessage priorityMessage) {
        return this.iPriority.compareTo(priorityMessage.iPriority);
    }
}
