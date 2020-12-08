package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "EoaSection")
public class EoaSectionDAO {

    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public int l_section;
    public boolean q_sectiontimer;
    public Integer t_sectiontimer;
    public Integer d_sectiontimerstoploc;

}
