package de.ibw.tms.entities;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "RbcMovementAuthority")
public class MaDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean m_ack;

    public int nid_lrbg;

    public int q_dir;

    public int q_scale;

    @OneToOne
    public EoaDAO eoa;

    @OneToOne
    public GradientProfileDAO gradientProfile;

    @OneToOne
    public SpeedProfileDAO speedProfile;

    @OneToOne
    public ModeDAO modeProfile;
    @OneToOne
    public LinkingProfileDAO linkingProfile;
}
