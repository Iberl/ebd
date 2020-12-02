package de.ibw.tms.entities;

import de.ibw.tms.ma.SpeedSectionAdapter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "SpeedProfile")
public class SpeedProfileDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Integer q_dir;

    public Integer q_scale;

    @OneToMany
    public List<SpeedSectionDAO> sections = new ArrayList();


}
