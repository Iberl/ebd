package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "SpeedCategory")
public class SpeedCategoryDAO {

    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int q_diff;

    public int nc_cddiff;

    public int nc_diff;

    public int v_diff;


}
