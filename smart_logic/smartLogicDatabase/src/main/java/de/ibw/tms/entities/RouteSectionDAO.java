package de.ibw.tms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    public String routeSectionId;

}
