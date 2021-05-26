package de.ibw.tms.entities;

import de.ibw.tms.ma.SpeedSectionAdapter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-26
 *
 *  Ein Datenbankobjekt fuer das Geschwindigkeitsprofil des nach erfolgreicher Pruefung an das RBC gesendet wird
 *
 */
@Entity(name = "SpeedProfile")
public class SpeedProfileDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Richtung der Gueltigkeit dieses Profils
     * 0 Reverse
     * 1 Nominal
     * 2 Both directions
     * 3 Spare
     *
     */
    public Integer q_dir;

    /**
     * Einheit der Laengenangabe der Bereiche fuer Geschwindigkeiten
     * 0:= 10 cm
     * 1:= 1 m
     * 2:= 10 m
     * 3:= SPARE
     *
     */
    public Integer q_scale;

    /**
     * Geschwindigkeitsbereiche dieses Profils
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    public List<SpeedSectionDAO> sections = new ArrayList();


}
