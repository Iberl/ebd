package de.ibw.tms.intf;

import com.google.gson.annotations.Expose;
import de.ibw.tms.intf.cmd.CheckMovementPermission;
import de.ibw.tms.intf.cmd.Commands;

/**
 * Nachricht an die SL diese Ma-Nachricht zu pr&uuml;fen
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class TmsMovementPermissionRequest extends TmsMessage implements Comparable<TmsMessage> {

    /**
     *  Nachrichteninhalt
     */
    @Expose
    public CheckMovementPermission payload;

    /**
     * Konstruktur eine TMS-Ma-Nachricht an die SL
     * @param tms_id - eigene Id des TMS
     * @param rbc_id - Ziel-RBC-Id
     * @param payload - Inhalt der Nachricht
     */
    public TmsMovementPermissionRequest(String tms_id, String rbc_id, CheckMovementPermission payload) {
            super(tms_id, rbc_id,payload);
            this.payload = payload;
    }

    /**
     * String-Darstellung dieser Nachricht
     * @return String - String-Darstellung
     */
    @Override
    public String toString() {
            return "TmsMovementAuthority{" +
                    "payload=" + payload +
                    ", type=" + type +
                    ", tms_id='" + tms_id + '\'' +
                    ", rbc_id='" + rbc_id + '\'' +
                    '}';
    }

    /**
     * Vergleich von Priority von Nachrrichten
     * @param otherMessage - {@link TmsMessage} - andere Nachricht zum Vergliech
     * @return int - negativ, wenn diese Nachricht Vorrang als die Nachricht im Parameter hat.
     */

    @Override
    public int compareTo(TmsMessage otherMessage) {
            return this.payload.lPriority.compareTo(otherMessage.getPayload().lPriority);
    }

    /**
     * Holt aus dieser Nachricht den Nachrichteninhalt
     * @return Commands - Inhalt dieser Nachricht
     */
    @Override
    public Commands getPayload() {
            return this.payload;
        }
}



