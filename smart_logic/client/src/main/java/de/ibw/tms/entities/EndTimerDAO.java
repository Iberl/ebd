package de.ibw.tms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 * Ein Datenbankobjekt, das angibt wie lange die Endsektion der Movement-Authority gueltig ist
 */
@Entity(name = "EndTimer")
public class EndTimerDAO {

    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Zeit in Sekunden in der die Endsektion in der Movement-Authority gueltig ist
     */
    public int t_endtimer;
    /**
     * Entfernung in der Einheit, die das Q-Scale definiert.
     * Die Entfernung von des Startpunktes dieses Timer relativ zur End of Movmement Authority
     */
    public int d_endtimerstartloc;
}
