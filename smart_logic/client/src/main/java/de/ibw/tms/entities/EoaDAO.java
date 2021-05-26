package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.DangerPointAdapter;
import de.ibw.tms.ma.EndTimerAdapter;
import de.ibw.tms.ma.EoaSectionAdapter;
import de.ibw.tms.ma.OverlapApdapter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 * Diese Klasse realisiert Datenbank fuer die End of Movement Authority
 */
@Entity(name = "EOA")
public class EoaDAO {

    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Richtung in der die Nachrichtung gueltig ist
     * 0 := REVERSE
     * 1 := NOMINAL
     * 2 := Beide Richtungen
     * 3 := Spare
     */
    public Integer q_dir;

    /**
     * Einheitsangabe von Distanzangaben
     * 0:= 10 cm
     * 1:= 1  m
     * 2:= 10 m
     * 3:= SPARE
     */
    public Integer q_scale;

    /**
     * Geschwindigkeit in 5 km/h-Schrtten
     * Maximale End-Geschwindigkeit beim Verlassen der EOA
     */
    public int v_loa;

    /**
     * Zeit in Sekunden in der die maximale Endgeschwindigkeit gueltig ist
     */
    public int t_loa;

    /**
     * Sektionen der EOA
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    public List<EoaSectionDAO> sections;

    /**
     * End Timer die diese EOA aufweisen kann
     */
    @OneToOne
    public EndTimerDAO endTimer;
    /**
     * Eine EOA kann einen Danger Point haben
     */
    @OneToOne
    public DangerPointDAO dangerPoint;

    /**
     * Eine EOA kann einen Overlap haben
     */
    @OneToOne
    public OverlapDAO overlap;
}
