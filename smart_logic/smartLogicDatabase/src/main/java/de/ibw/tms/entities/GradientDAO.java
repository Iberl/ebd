package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Gradient")
public class GradientDAO {


    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public int d_gradient;

    public boolean q_gdir;

    public int g_a;


}
