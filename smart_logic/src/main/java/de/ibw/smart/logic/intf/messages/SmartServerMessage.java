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
 * Nachricht an das TMS von der SmartLogic
 */
public class SmartServerMessage implements Comparable<SmartServerMessage>, Serializable {
    private String sMsg;
    // min is first
    private Long iPriority = 100L;

    private boolean bIsFromSL = false;

    public boolean isbIsFromSL() {
        return bIsFromSL;
    }

    public void setbIsFromSL(boolean bIsFromSL) {
        this.bIsFromSL = bIsFromSL;
    }

    public String getMsg() {
        return sMsg;
    }

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

    @Override
    public String toString() {
        return sMsg;
    }

    @Override
    public int compareTo(SmartServerMessage priorityMessage) {
        return this.iPriority.compareTo(priorityMessage.iPriority);
    }


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