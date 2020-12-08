package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Link")
public class LinkDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public int d_link;
    
    public Integer nid_c;
    
    public int nid_bg;
    
    public boolean q_linkorientation;
    
    public int q_linkreaction;
    
    public int q_locacc;
    
    
}
