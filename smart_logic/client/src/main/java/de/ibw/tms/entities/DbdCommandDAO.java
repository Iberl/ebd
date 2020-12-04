package de.ibw.tms.entities;

import de.ibw.tms.ma.physical.TrackElementStatus;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "DbdCommand")
public class DbdCommandDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String CommandType;

    public String getId() {
        return id;
    }

    public UUID uuid;

    public String sId;

    public Long lPriority;

    @ElementCollection
    public List<TrackElementStatus.Status> statusList = new ArrayList<>();



}
