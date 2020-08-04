package de.ibw.smart.logic.intf.messages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.util.ArrayList;
import java.util.UUID;

public class MaRequestReturnPayload implements ITypable {

    public static final String RETURN_TYPE = "MA_REQUEST_RETURN";

    @Expose
    UUID uuid;

    @Expose
    String type = RETURN_TYPE;

    @Expose
    boolean unlockElements;

    @Expose
    ArrayList<String> failureCodes = new ArrayList<>();

    @Expose
    boolean maSuccessfull;



    public void setErrorState(UUID uuid, boolean unlockElements, String sFailureCode) {
        this.uuid = uuid;
        this.failureCodes.add(sFailureCode);
        this.maSuccessfull = false;
        this.unlockElements = unlockElements;

    }

    public void setMaSuccessfull(UUID uuid) {
        this.uuid = uuid;
        this.maSuccessfull = true;
        this.unlockElements = true;
    }


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
}
