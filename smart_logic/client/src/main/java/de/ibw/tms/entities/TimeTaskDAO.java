package de.ibw.tms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "TimeTask")
public class TimeTaskDAO {
    @Id
    private String id;

    @OneToOne
    public CheckMovementPermissionDAO CheckPermission;

    @OneToOne
    public DbdCommandDAO CheckDbd;

    public double SendTimeSinceStartInSeconds;



    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
