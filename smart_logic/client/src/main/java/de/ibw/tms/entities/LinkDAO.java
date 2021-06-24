package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 *  Eine Datenbankobjektklasse für Links im Linking-Profile
 */
@Entity(name = "Link")
public class LinkDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Inkrementierte !!!!!!! Distanz zur naechsten Balisengruppe
     */
    public int d_link;

    /**
     * Nummer zur Identifizierung des Landes oder der Region
     */
    public Integer nid_c;

    /**
     * Id der Balisengruppe dieses Linkings
     */
    public int nid_bg;

    /**
     * Gibt die Richtung zur Verlinkten Balisengruppe an
     * 0 := Die Balise ist in Richtung des Hecks
     * 1 := Die Balise befindet sich in der Richtung der Front des Zuges
     */
    public boolean q_linkorientation;

    /**
     * Reaktion am diesem "Link-Point"
     *
     * 0 Train trip
     * 1 Apply service brake
     * 2 No Reaction
     * 3 Spare
     *
     */
    public int q_linkreaction;

    /**
     * Spielraum in der sich die Balise befinden kann in Meter
     * 0-63 m
     */
    public int q_locacc;
    
    
}
