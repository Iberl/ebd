package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 * Datenbank-Objekt eines Danger Points in der Angabe eines MA-Requests
 */
@Entity(name = "DangerPoint")
public class DangerPointDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Distanz vom Ende der Movement-Authority zum Danger Point mit der Einheit von Q-SCALE
     */
    public int d_dp;

    /**
     * Geschwindigkeit in Verbindung mit dem Release-Speed in 5 km/h Einheit Schritten
     *
     * 10 := 50 km/h
     * 15 := 75 km/h etc.
     */
    public int v_releasedp;


}
