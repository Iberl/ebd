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

public class TmsMessage extends Message<Commands> implements Serializable {
    @Expose
    public int type;
    @Expose
    public String tms_id;
    @Expose
    public String rbc_id;


    public TmsMessage(String tms_id, String rbc_id, Commands payload) {
        super(0, tms_id, rbc_id, payload);
        this.type = 0;
        this.tms_id = tms_id;
        this.rbc_id = rbc_id;

    }



    /**
     * TMS sends message to smart logic. Then this method can parse the json
     * @param jsonString
     * @return TmsMessage<Commands>
     * @throws ClassNotFoundException
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
    public String parseToJson() throws MissingInformationException {
        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        // Check For Correct Values
        // Only Accordingly Annotated Fields Aan Hold The Null Value
        // Lists Must Have A Minimum Of 1 Element
        //ClassAnalysis.checkValues(this);

        // Serialize Message
        return gson.toJson(this);
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
