package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.DangerPointAdapter;
import de.ibw.tms.ma.EndTimerAdapter;
import de.ibw.tms.ma.EoaSectionAdapter;
import de.ibw.tms.ma.OverlapApdapter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity(name = "EOA")
public class EoaDAO {

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

    public int v_loa;

    public int t_loa;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    public List<EoaSectionDAO> sections;

    @OneToOne
    public EndTimerDAO endTimer;
    @OneToOne
    public DangerPointDAO dangerPoint;

    @OneToOne
    public OverlapDAO overlap;
}
