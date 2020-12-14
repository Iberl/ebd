package de.ibw.tms.entities;

import de.ibw.tms.ma.physical.TrackElementStatus;

import javax.persistence.*;
import java.util.*;

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

    @ElementCollection(fetch = FetchType.EAGER, targetClass=TrackElementStatus.Status.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tesc_status", joinColumns =  @JoinColumn(name = "dbd_command_id"))
    @OrderColumn()
    public List<TrackElementStatus.Status> statusList;



}
