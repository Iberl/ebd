package de.ibw.tms.intf.cmd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ebd.rbc_tms.util.exception.MissingInformationException;

public interface IjsonParser {

    /**
     * Stellt den Befehl als Json dar.
     * Es werden nur Elmente mit @Expose verwendet.
     * @return String - Json-String
     * @throws MissingInformationException - Fehler beim parsen ins Json.
     */
    default public String parseToJson() throws MissingInformationException {


        Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        // Check For Correct Values
        // Only Accordingly Annotated Fields Aan Hold The Null Value
        // Lists Must Have A Minimum Of 1 Element
        //ClassAnalysis.checkValues(this);

        // Serialize Message
        return gson.toJson(this);

    }
}
