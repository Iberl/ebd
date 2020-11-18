package de.ibw.smart.logic.intf.messages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * Diese Klasse stellt eine Anwort des SL an das TMS f&uuml;r eine DBD-Anforderung dar.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-09-02
 */
public class DbdRequestReturnPayload implements ITypable {


    public static final String BLOCK_FAIL_REASON = "is blocked";


    /**
     * Definiert Nachrichtentyp, dadurch kann die Art der Nachricht vom TMS erkannt werden
     */
    public static final String RETURN_TYPE = "DBD_REQUEST_RETURN";


    /**
     * Typ der Nachricht die auch in Json gesendet wird
     */

    @Expose
    String type = RETURN_TYPE;


    /**
     * wurde der DBD Befehl erfolgriech an das Stellsystem abgesetzt, diese Info wird auch in Json an das TMS gesendet
     */

    @Expose
    boolean dbdCommandSuccessfull;

    @Expose
    String sDbdCommandTargetName;

    @Expose
    String sFailreason;


    public DbdRequestReturnPayload(String sId) {
        sDbdCommandTargetName = sId;
        sFailreason = "";
        dbdCommandSuccessfull = true;
    }


    /**
     * Diese Method settzt diese Nachricht auf eine Fehlerstatus, weil die DBD-Anforderung nicht erfolgreich war
     *
     */
    public void setErrorState(String sFailreason) {


        this.dbdCommandSuccessfull = false;
        this.sFailreason = sFailreason;

    }

    /**
     * DBD wurde erfolgreich an das Stellwerk abgesetzt
     *
     */
    public void setDbdSuccessfull() {

        this.dbdCommandSuccessfull = true;

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



    @Override
    public String getType() {
        return this.type;
    }

    public static String getReturnType() {
        return RETURN_TYPE;
    }

    public boolean isDbdCommandSuccessfull() {
        return dbdCommandSuccessfull;
    }

    public String getsDbdCommandTargetName() {
        return sDbdCommandTargetName;
    }

    public String getsFailreason() {
        return sFailreason;
    }
}
