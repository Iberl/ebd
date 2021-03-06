package de.ibw.smart.logic.intf.messages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import de.ibw.tms.intf.messenger.IMovementMessengerIntf;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Diese Klasse stellt eine Anwort des SL an das TMS f&uuml;r eine Ma-Anforderung dar.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-04-30
 */
public class MaRequestReturnPayload implements ITypable, IMovementMessengerIntf {

    /**
     * Definiert Nachrichtentyp, dadurch kann die Art der Nachricht vom TMS erkannt werden
     */
    public static final String RETURN_TYPE = "MPERM_REQUEST_RETURN";

    /**
     * UUID die auch in Json gesendet wird
     */

    @Expose
    UUID uuid;

    /**
     * Typ der Nachricht die auch in Json gesendet wird
     */

    @Expose
    String type = RETURN_TYPE;

    /**
     * gibt an ob die reservierte Element von der SL wieder freigegeben wurden: Info die auch in Json gesendet wird
     */

    @Expose
    boolean unlockElements;

    /**
     * String Liste von Fehlercodes, die auch in Json gesendet wird
     */

    @Expose
    ArrayList<String> failureCodes = new ArrayList<>();

    /**
     * wurde die Ma erfolgriech an das RBC abgesetzt, diese Info wird auch in Json an das TMS gesendet
     */

    @Expose
    boolean maSuccessfull;


    /**
     * Diese Method settzt diese Nachricht auf eine Fehlerstatus, weil die Ma-Anforderun g nicht erfolgreich war
     * @param uuid - Id zum Kommunikationsverlauf
     * @param unlockElements - wurden Elemente freigegeben
     * @param sFailureCode - gibt art des Fehlers and
     */
    public void setErrorState(UUID uuid, boolean unlockElements, String sFailureCode) {
        this.uuid = uuid;
        this.failureCodes.add(sFailureCode);
        this.maSuccessfull = false;
        this.unlockElements = unlockElements;

    }

    /**
     * Ma wurde erfolgreich an das RBC abgesetzt
     * @param uuid - ID zum Komminikationsverlauf mit dem RBC
     */
    public void setMaSuccessfull(UUID uuid) {
        this.uuid = uuid;
        this.maSuccessfull = true;
        this.unlockElements = true;
    }

    /**
     * baut eine Json-Zeichenkette aus exposed Felder dieser Klasse
     * @return String - Json dieser Nachricht
     */
    public String parseToJson() {
        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        // Check For Correct Values
        // Only Accordingly Annotated Fields Aan Hold The Null Value
        // Lists Must Have A Minimum Of 1 Element
        //ClassAnalysis.checkValues(this);

        // Serialize Message
        return gson.toJson(this);
    }




    public String getType() {
        return this.type;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isUnlockElements() {
        return unlockElements;
    }

    public ArrayList<String> getFailureCodes() {
        return failureCodes;
    }

    public boolean isMaSuccessfull() {
        return maSuccessfull;
    }

    @Override
    public String showOnMovementMessenger() {
        String logEntry = "-------\n";
        if(isValidMessage()) {
            logEntry = logEntry + "UUID: " + this.uuid;
            if(isMaSuccessfull()) {
                logEntry = logEntry + " Movement-Request was successful";
            } else {
                logEntry = logEntry + " Movement-Request failed, because:";
                for(String sCode : getFailureCodes()) {
                    logEntry = logEntry + " [" + sCode + "] ";
                }
            }

        } else {
            logEntry = logEntry + "Message invalid: " + this.parseToJson();
        }
        logEntry = logEntry + "\n-------\n";
        return logEntry;
    }

    private boolean isValidMessage() {
        if(uuid == null) return false;
        return true;
    }
}
