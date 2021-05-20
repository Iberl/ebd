package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Eine aus der Datenbank bezogene Untersektion der EOA
 */
@Entity(name = "EoaSection")
public class EoaSectionDAO {

    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Laenge dieser Strecke in Meter
     */
    public int l_section;
    /**
     * Gibt an ob die Sektion eine zeitlich begrenzte Gueltigkeit aufweist
     */
    public boolean q_sectiontimer;

    /**
     * Zeit in Sekunden in der diese EOA-Sektion gueltig ist
     */
    public Integer t_sectiontimer;

    /**
     * Distanz in der Einheit von Q_Scale von Beginn dieser Sektion zum Time-Out-Stop-Ort
     */
    public Integer d_sectiontimerstoploc;

}
