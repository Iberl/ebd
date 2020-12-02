package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Overlap")
public class OverlapDAO {


    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int d_startol;
    public int t_ol;
    public int d_ol;
    public int v_releaseol;


}
