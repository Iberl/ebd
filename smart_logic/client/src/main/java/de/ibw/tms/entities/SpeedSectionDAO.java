package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.SpeedCategoryAdapter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-26
 *
 *  Eine Geschwindigkeitssektion als Datenbankzugriffsklasse fuer ein Profil einer Movment Permission an das RBC
 */
@Entity(name = "SpeedSection")
public class SpeedSectionDAO {

    @Id
    private String id;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Inkrementelle !!!!!!! distanz zur naechsten Abweichung der Geschwindigkeit in diesem Profil
     * Einheit ist in bestimmt durch das q_scale
     */
    public int d_static;

    /**
     * Geschwindigkeit in 5 km/h-Schritten
     * 10 := 50 km/h
     *
     * Besondere Werte:
     * 121-126 := Spare
     * 127 := sagt aus, dass das static speed profile endet
     *
     */
    public int v_static;

    /**
     * Gibt an ob das Profil sich an der Zugfront orientiert
     * Ist dem nicht so, wird es eine Verzoegerung in Abhaengingkeit zur Zuglaenge geben
     *
     * false := Zuglaengen Verzeogerung
     * true := Keine Zuglaengen Verzoegerung
     */
    public boolean q_front;

    /**
     * Liste von Kategorien die diese Sektion aufweist
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    public List<SpeedCategoryDAO> categories;

}
