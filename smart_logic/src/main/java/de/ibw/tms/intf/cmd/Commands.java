package de.ibw.tms.intf.cmd;

import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import de.ibw.tms.intf.TmsMovementAuthority;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.exception.MissingInformationException;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Dieser Klasse stellt einen Befehl in allgemeiner Form vom TMS an die SL dar.
 * Bisher gibt es nur {@link CheckMovementAuthority}.
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class Commands extends Payload implements Comparable<Commands>, Serializable {
    /**
     * String-Id der CheckMovementAuthority.
     * Dient zum Identifizieren in der SL welcher Befehlsart empfangen wurde
     */
    public static final String S_CHECK_MOVEMENT_AUTHORITY = "checkMa";

    /**
     * Gibt den Typ zur String Id wider. Ist im Json wichtig
     * Genaue Art der Befehlsklasse ist dadurch aufrufbar.
     * @param sType {@link String} - String-Id des Befehls
     * @return Type - Typ mit Klasse zu dem jeweiligen Befehl
     */
    public static Type getTypeByString(String sType) {
        if(sType.equals(S_CHECK_MOVEMENT_AUTHORITY)) {
            return new TypeToken<TmsMovementAuthority>(){}.getType();
        }
        return null;
    }

    /**
     * Gibt die Klasse zur String Id wider. Wichtig für die SL
     * Genaue Art der Befehlsklasse ist dadurch aufrufbar.
     * @param sType {@link String} - String-Id des Befehls
     * @return Type - Typ mit Klasse zu dem jeweiligen Befehl
     */
    public static Class getClassByString(String sType) {
        if(sType.equals(S_CHECK_MOVEMENT_AUTHORITY)) {
            return TmsMovementAuthority.class;
        }
        return null;
    }

    /**
     * Priority wird aber in dem konkret vererbten Befehl definiert
     */
    public Long lPriority = 100L;

    /**
     * String Typ der Nachricht der auch gesendet wird, damit die SL den Typ des Befehlt kennt.
     */
    @Expose
    public String CommandType;

    /**
     * Erstellt einen Aufruf f&uuml;r Unterklassen bereit.
     * @param lPriority long - Priority dieses Befehls.
     */
    protected Commands(long lPriority) {
        this.lPriority = lPriority;
    }


    /**
     * Vergleicht zwei Commands und die niedrigere Priority erh&auml;lt den Vorrang
     * @param commands - Command der mit diesem Command verglichen wird.
     * @return int - Vergleichswert - negtive bedeutet dieser Befehl hat vorrang - nicht der des commands-Parameters.
     */



    @Override
    public int compareTo(Commands commands) {
        return this.lPriority.compareTo(commands.lPriority);
    }
}
