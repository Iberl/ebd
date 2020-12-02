package de.ibw.tms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "EndTimer")
public class EndTimerDAO {

    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public int t_endtimer;
    public int d_endtimerstartloc;
}
