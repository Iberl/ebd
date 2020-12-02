package de.ibw.tms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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

    public double intrinsicCoordOfTargetTrackEdge;

    @OneToMany
    public List<RouteSectionDAO> routeSections;


}
