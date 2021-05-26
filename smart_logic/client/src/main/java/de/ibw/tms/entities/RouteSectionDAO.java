package de.ibw.tms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 *  Datenbank-Zugriffs-Klasse einer Sektion einer Route
 */
@Entity(name = "RouteSection")
public class RouteSectionDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Bereichsbezeichnung einer Topologischen Kante, nach dem Gleis-Kanten-Modell
     */
    public String routeSectionId;

}
