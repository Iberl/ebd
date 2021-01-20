package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.SingleModeAdapter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "Mode")
public class ModeDAO {
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

    @OneToMany(fetch = FetchType.EAGER)
    public List<SingleModeDAO> modes;

}
