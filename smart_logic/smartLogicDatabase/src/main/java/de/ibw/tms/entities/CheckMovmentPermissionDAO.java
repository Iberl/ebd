package de.ibw.tms.entities;

import de.ibw.tms.intf.cmd.CheckMovementPermission;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "CheckMovementPermission")
public class CheckMovmentPermissionDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String CommandType;

    @OneToOne
    public RouteDAO route;

    @OneToOne
    public MaDAO MaAdapter;

    public int iTrainId;

    public UUID uuid;


    public String tms_id;

    public String rbc_id;

    public Long lPriority;



}
