package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.LinkAdapter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 *  Das Linking-Profil als Datenbank-Object-Klasse
 *
 */
@Entity(name = "LinkingProfile")
public class LinkingProfileDAO {

    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Richtungsangabe in der das Profil valide ist
     * 0 Reverse
     * 1 Nominal
     * 2 Both directions
     * 3 Spare
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
     * Links die in diesem Profil enthalten sind.
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    public List<LinkDAO> links = new ArrayList();
}
