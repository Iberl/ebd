package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.SpeedCategoryAdapter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "SpeedSection")
public class SpeedSectionDAO {

    @Id
    private String id;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int d_static;

    public int v_static;

    public boolean q_front;
    @OneToMany
    public List<SpeedCategoryDAO> categories;

}
