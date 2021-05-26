package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 *  Datenbank-Zugriffs-Klasse eines Overlap
 */
@Entity(name = "Overlap")
public class OverlapDAO {


    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Entfernung von dem Startort des Overlap-Timers bis zum End of Authority
     * Die Einheit gibt das Q-Scale vor
     */
    public int d_startol;
    /**
     * Zeid in Sekunden in denen der Overlap valide ist 0 - 1022 s
     */
    public int t_ol;
    /**
     * Die Entfernung von End of Authority bis zum Ende des Overlap
     */
    public int d_ol;
    /**
     * Release Speed dieses Overlaps in 5 km/h (bsp. 10 := 50 km/h
     */
    public int v_releaseol;


}
