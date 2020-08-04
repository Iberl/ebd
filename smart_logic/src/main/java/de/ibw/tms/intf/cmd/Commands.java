package de.ibw.tms.intf.cmd;

import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import de.ibw.tms.intf.TmsMovementAuthority;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.io.Serializable;
import java.lang.reflect.Type;

public class Commands extends Payload implements Comparable<Commands>, Serializable {
    public static final String S_CHECK_MOVEMENT_AUTHORITY = "checkMa";


    public static Type getTypeByString(String sType) {
        if(sType.equals(S_CHECK_MOVEMENT_AUTHORITY)) {
            return new TypeToken<TmsMovementAuthority>(){}.getType();
        }
        return null;
    }

    public static Class getClassByString(String sType) {
        if(sType.equals(S_CHECK_MOVEMENT_AUTHORITY)) {
            return TmsMovementAuthority.class;
        }
        return null;
    }

    public Long lPriority = 100L;
    @Expose
    public String CommandType;


    public Commands(long lPriority) {
        this.lPriority = lPriority;
    }

    /**
     * Parse Command to String
     * @return String
     * @throws MissingInformationException
     */



    @Override
    public int compareTo(Commands commands) {
        return this.lPriority.compareTo(commands.lPriority);
    }
}
