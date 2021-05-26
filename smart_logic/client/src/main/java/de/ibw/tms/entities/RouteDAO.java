package de.ibw.tms.entities;



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
 *  Datenbank-Zugriffs-Klasse der Route
 */
@Entity(name = "Route")
public class RouteDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Abstand von Quell-Topologieschen-Knoten von dem der Zug herkommt.
     * Die Koordinate wird in dieser Prozent-Angabe bestimmt
     * So ist 0.1 := ein Zehntel der Länge der letzten Topologischen Kante dieser Route
     *
     * Wertebereich: 0.0 - 1.0
     */
    public double intrinsicCoordOfTargetTrackEdge;

    /**
     * Alle Sektionen, die zu dieser Route gehoeren.
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    public List<RouteSectionDAO> routeSections;


}
