package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 *  Ein Modus einer Movement Authority, die MA kann mehrere dieser Modis haben
 */
@Entity(name = "SingleMode")
public class SingleModeDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Inkrementelle !!!!!!! distanz vom Start des Profils bis zum naechsten Profils
     *
     * Einheit bestimmt sich aus q_Scale
     */
    public int d_mamode;

    /**
     * Code des Modus der MA
     *
     * 0 := On Sight
     * 1 := Shunting
     * 2 := Limited Supervision
     * 3 := Spare
     */
    public int m_mamode;

    /**
     * Geschwindigkeitserfordernis dieses Modus (Einheit in 5 km/h Schritten)
     *
     * 10 := 50 km/h
     *
     * Spezielle Werte von v_mamode:
     *  121 - 125 := Spare
     *  127 : Nutzen des oertlichen Geschwindigkeitswertes für diesen Modus
     *
     *
     *
     */
    public int v_mamode;

    /**
     * Laenge des Bereichs diese Modus
     * Einheit ist in Abhaengigkteit von Q_Scale
     */
    public int l_mamode;

    /**
     * Laenge der Acknowledgement-Area am Ende dieses Modus
     */
    public int l_ackmamode;
    /**
     * Bestimmt die supervised location.
     *
     * false := leite die supervised loction von der MA ab
     * true := der Beginn des Mode-Profiles wird als supervised location angenommen
     */
    public boolean q_mamode;

}
