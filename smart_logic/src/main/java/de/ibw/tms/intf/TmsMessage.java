package de.ibw.tms.intf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;
import de.ibw.tms.intf.cmd.Commands;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.io.Serializable;
import java.lang.reflect.Type;
/**
 * Wrapper-Klasse zu einem Command.
 * Objekte dieser Klasse werden als Json gesendet.
 * Es werden alle Exposed Felder in das Json eingebettet.
 * Darunter sind auch Felder der Vaterklassen, die geerbt wurden, enthalten.
 * Diese Objekte werden eingesetzt um Nachrichten zur SL zu senden
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class TmsMessage extends Message<Commands> implements Serializable {
    /**
     * typ der Nachricht generell 0
     */
    @Expose
    public int type;
    /**
     * Eigene TMS-Id
     */
    @Expose
    public String tms_id;
    /**
     * Ziel RBC-Id
     */
    @Expose
    public String rbc_id;


    /**
     * Generelle Konstruktor-Definition f&uuml;r Kind-Klassen
     * @param tms_id {@link String} - Id des angefragten TMS
     * @param rbc_id {@link String} - Id des angefragten RBC
     * @param payload - {@link Commands} - Hat einen Payload eines TMS-Commands
     */
    protected TmsMessage(String tms_id, String rbc_id, Commands payload) {
        super(Commands.I_CHECK_MOVEMENT_PERMISSION, tms_id, rbc_id, payload);
        this.type = Commands.I_CHECK_MOVEMENT_PERMISSION;
        this.tms_id = tms_id;
        this.rbc_id = rbc_id;

    }



    /**
     * TMS sends message to smart logic. Then this method can parse the json
     * Tms sendet eine Nachricht an die SL. In der SL wird diese Methode aufgerufen um ankommende Json-Strings in
     * Objekte umsetzen zu k&ouml;nnen.
     * @param jsonString - {@link String} - Json String vom TMS an die SL
     * @return TmsMessage {@link TmsMessage} - es wird die Nachricht des TMS widergegeben.
     * @throws ClassNotFoundException - Fehler weil Nachrichtentyp nicht bekannt ist.
     */
    public static TmsMessage generateFromTms(String jsonString) throws ClassNotFoundException {
        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();

        // Read Message Type From JSON String
        JsonObject obj = JsonParser.parseString(jsonString).getAsJsonObject();
        String type = obj.get("payload").getAsJsonObject().get("CommandType").getAsString();
        Type TmsCommandClass = Commands.getTypeByString(type);



        // Find Class For Message Type


        // Deserialize JSON String
        return (TmsMessage) gson.fromJson(jsonString, TmsCommandClass);
    }

    /**
     * Konvertiert die Exposed-Felder einer Tms-Nachricht in einen Json-String
     * @return String - Json-String der Tms Nachricht
     * @throws MissingInformationException - Fehler bei Konvertierung in Json
     */
    public String parseToJson() throws MissingInformationException {
        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        // Check For Correct Values
        // Only Accordingly Annotated Fields Aan Hold The Null Value
        // Lists Must Have A Minimum Of 1 Element
        //ClassAnalysis.checkValues(this);

        // Serialize Message
        return gson.toJson(this);
    }

    /**
     * Generelle to String Methode
     * @return String - Darstelleung als Zeichenkette allgemein
     */

    @Override
    public String toString() {
        return super.toString();
    }
}
