package de.ibw.smart.logic.intf.messages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import ebd.rbc_tms.Message;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.security.InvalidParameterException;

/**
 * Diese Klasse stellt eine Nachricht von SL zum TMS dar oder umgekehrt
 * Sie ist Priorisierbar und implmentiert de&szlig;halb Comparable
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public class SmartServerMessage implements Comparable<SmartServerMessage>, Serializable {
    private String sMsg;
    // min is first
    private Long iPriority = 100L;

    private boolean bIsFromSL = false;

    /**
     * Gibt an ob Nachricht zum TMS gesendet wird oder an die SmartLogic
     * @return boolean
     */
    public boolean isbIsFromSL() {
        return bIsFromSL;
    }

    public void setbIsFromSL(boolean bIsFromSL) {
        this.bIsFromSL = bIsFromSL;
    }

    /**
     * Holt die Nachricht als Json-Zeichenkette aus diesen Wrapper
     * @return String - als Json
     */
    public String getMsg() {
        return sMsg;
    }

    /**
     * Dieser Konstrukter instanziiert die Nachricht mit Json-String M und einer Priority
     * @param M String - json to send
     * @param iPriority Log - priority value
     */
    public SmartServerMessage(String M, Long iPriority) {
        if(iPriority == null || M == null) throw new InvalidParameterException("Paramters must not be null");
        iPriority = iPriority;
        sMsg = M;
    }

    public Long getiPriority() {
        return iPriority;
    }

    public void setiPriority(Long iPriority) {
        this.iPriority = iPriority;
    }

    /**
     * als Zeichkette wird der Json-String widergegeben
     * @return String
     */

    @Override
    public String toString() {
        return sMsg;
    }

    /**
     * Vergleich welche Nachricht mehr Priority hat
     * @param priorityMessage - Andere Nachricht zum Vergleich
     * @return int
     */
    @Override
    public int compareTo(SmartServerMessage priorityMessage) {
        return this.iPriority.compareTo(priorityMessage.iPriority);
    }

    /**
     * Diese Methode gibt den Json-String typgerecht als Nachrichtenobjekt wider.
     * @param jsonString - String der zu einer Nachricht erstellt wird
     * @return ITypable
     * @throws ClassNotFoundException - falls eine Nachricht mit Typ angefordert wird, der nicht darstellbar ist
     */
    public static ITypable generateFromSlJson(String jsonString) throws ClassNotFoundException {

        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();

        JsonObject obj = JsonParser.parseString(jsonString).getAsJsonObject();
        String type = obj.get("type").getAsString();
        Type ReturnType = null;
        if(type.equals(MaRequestReturnPayload.RETURN_TYPE)) {

            ReturnType = new TypeToken<MaRequestReturnPayload>(){}.getType();
            return (MaRequestReturnPayload) gson.fromJson(jsonString, ReturnType);
        }
        return null;
    }

}