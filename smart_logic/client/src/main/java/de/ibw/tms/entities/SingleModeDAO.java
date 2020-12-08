package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "SingleMode")
public class SingleModeDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    
    public int d_mamode;
    
    public int m_mamode;
    
    public int v_mamode;
    
    public int l_mamode;
    
    public int l_ackmamode;
    
    public boolean q_mamode;

}
