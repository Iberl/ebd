package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.SingleModeAdapter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 *  Mode das zu einer MA fuer das RBD gehoert
 */
@Entity(name = "Mode")
public class ModeDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Richtung der Gueltigkeit der Modis
     */
    public Integer q_dir;

    /**
     * Einheit der Laengenangabe der Gradienten
     * 0:= 10 cm
     * 1:= 1 m
     * 2:= 10 m
     * 3:= SPARE
     *
     */
    public Integer q_scale;

    /**
     * Liste von Modis dieses Profils
     */
    @OneToMany(fetch = FetchType.EAGER)
    public List<SingleModeDAO> modes;

}
