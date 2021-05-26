package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 *  Movement Authority die an das RBC fuer den Zug geschickt wird
 */
@Entity(name = "RbcMovementAuthority")
public class MaDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Bestimmt ob eine Acknowledgement erforderlich ist
     * 0 := Keine Bestaetigung erforderlich
     * 1 := Bestaetigung wird angefordert
     */
    public boolean m_ack;

    /**
     * Id der Balisengruppe auf die sich die MA bezieht
     */
    public int nid_lrbg;

    /**
     * Richtungsangabe in der dise Movement Authority gueltig ist
     * 0 Reverse
     * 1 Nominal
     * 2 Both directions
     * 3 Spare
     */
    public int q_dir;
    /**
     * Einheit der Laengenangaben innerhalb dieser Movement Authority
     * 0:= 10 cm
     * 1:= 1 m
     * 2:= 10 m
     * 3:= SPARE
     *
     */
    public int q_scale;

    /**
     * Aus der Datenbank bezogene End Of Authority dieser MA
     */
    @OneToOne
    public EoaDAO eoa;
    /**
     * Gradientenprofil, das aus der Datenbank bezogen wurde
     */
    @OneToOne
    public GradientProfileDAO gradientProfile;

    /**
     * Geschwindigkeitsprofil, das aus der Datenbank bezogen wurde
     */
    @OneToOne
    public SpeedProfileDAO speedProfile;

    /**
     * Modis als Profil aus der Datenbank
     */
    @OneToOne
    public ModeDAO modeProfile;
    /**
     * Linking Profile aus der Datenbank
     */
    @OneToOne
    public LinkingProfileDAO linkingProfile;
}
