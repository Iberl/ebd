package de.ibw.tms.intf;

import com.google.gson.annotations.Expose;
import de.ibw.tms.intf.cmd.CheckMovementPermission;
import de.ibw.tms.intf.cmd.Commands;
import de.ibw.tms.intf.messenger.IMovementMessengerIntf;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import ebd.internal.util.exception.MissingInformationException;

/**
 * Nachricht an die SL diese Ma-Nachricht zu pr&uuml;fen
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-04-30
 *
 *
 */
public class TmsMovementPermissionRequest extends TmsMessage implements Comparable<TmsMessage>, IMovementMessengerIntf {

    /**
     *  Nachrichteninhalt
     */
    @Expose
    public CheckMovementPermission payload;

    // Belegung dieses Requests
    private MARequestOccupation maRequestOccupation = null;


    /**
     * Konstruktur eine TMS-Ma-Nachricht an die SL
     * @param tms_id - eigene Id des TMS
     * @param rbc_id - Ziel-RBC-Id
     * @param payload - Inhalt der Nachricht
     */
    public TmsMovementPermissionRequest(String tms_id, String rbc_id, CheckMovementPermission payload) {
            super(tms_id, rbc_id, Commands.I_CHECK_MOVEMENT_PERMISSION, payload);
            this.payload = payload;
            this.header.uuid = payload.uuid;
    }

    public int getTrainId() {
        return payload.iTrainId;
    }


    public MARequestOccupation getMaRequestOccupation() {
        return maRequestOccupation;
    }

    public void setMaRequestOccupation(MARequestOccupation maRequestOccupation) {
        this.maRequestOccupation = maRequestOccupation;
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

    @Override
    public String showOnMovementMessenger() {
        StringBuilder logEntry = new StringBuilder("-------\n");
        if(isValidMessage()) {
            logEntry.append("UUID: ").append(this.header.uuid);
            logEntry.append("\nMP-Request: Route: ");
            for(String sRouteId : this.payload.route.getElementListIds()) {
                logEntry.append("-->").append(sRouteId);
            }

        } else {
            try {
                logEntry.append("Message invalid: ").append(this.parseToJson());
            } catch (MissingInformationException MIE) {
                logEntry.append("Message invalid: ").append(MIE.getMessage());
            }
        }
        logEntry.append("\n-------\n");
        return logEntry.toString();
    }

    private boolean isValidMessage() {
        if(payload == null) return false;
        if(header == null) return false;
        if(header.uuid == null) return false;
        if(payload.route == null) return false;
        return true;
    }
}



