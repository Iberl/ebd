package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.etcs.Q_SCALE;
import ebd.rbc_tms.util.LinkingProfile;
import ebd.rbc_tms.util.MA;

import java.math.BigDecimal;

public class RbcMaAdapter extends MA {

    @Expose
    public boolean m_ack;
    @Expose
    public int nid_lrbg;
    @Expose
    public int q_dir;
    @Expose
    public int q_scale;
    @Expose
    public EoaAdapter eoa;
    @Expose
    public GradientProfileAdapter gradientProfile;
    @Expose
    public SpeedProfileAdapter speedProfile;
    @Expose
    public ModeAdapter modeProfile = null;
    @Expose
    public LinkingProfileAdapter linkingProfile;






    public RbcMaAdapter(MA ma) {
        super(ma.m_ack,ma.nid_lrbg, ma.q_dir, ma.q_scale, ma.eoa, ma.gradientProfile,ma.speedProfile, ma.modeProfile,
                ma.linkingProfile);

        this.m_ack = ma.m_ack;
        this.nid_lrbg = ma.nid_lrbg;
        this.q_dir = ma.q_dir;
        this.q_scale = ma.q_scale;
        this.eoa = new EoaAdapter(ma.eoa);
        this.gradientProfile = new GradientProfileAdapter(ma.gradientProfile);
        this.speedProfile = new SpeedProfileAdapter(ma.speedProfile);
        this.modeProfile = ma.modeProfile == null ? null : new ModeAdapter(ma.modeProfile);
        if(ma.linkingProfile == null) {
            linkingProfile = null;
        } else this.linkingProfile = new LinkingProfileAdapter(ma.linkingProfile);
    }

    @Override
    public String toString() {
        return "RbcMaAdapter{" +
                "m_ack=" + m_ack +
                ", nid_lrbg=" + nid_lrbg +
                ", q_dir=" + q_dir +
                ", q_scale=" + q_scale +
                ", eoa=" + eoa +
                ", speedProfile=" + speedProfile +
                ", linkingProfile=" + linkingProfile +
                '}';
    }

    public BigDecimal calcLengthOfSection() {
        BigDecimal dResult = new BigDecimal("0");
        BigDecimal dFactor = new BigDecimal("10");
        try {
            for(EoaSectionAdapter EoaSection: eoa.sections) {
                dResult = dResult.add(BigDecimal.valueOf(EoaSection.l_section));
            }
            if(this.q_scale == Q_SCALE.SCALE_10_CM.flag) dResult.divide(dFactor);
            if(this.q_scale == Q_SCALE.SCALE_10_M.flag) dResult.multiply(dFactor);
        } catch(Exception E) {
            return new BigDecimal("0");
        }
        return dResult;
    }

    public MA convertToRbcMA() {
        LinkingProfile LP = null;
        if(this.linkingProfile != null) {
            LP = this.linkingProfile.convert();
        }
        return new MA(this.m_ack,
                this.nid_lrbg,
                this.q_dir,
                this.q_scale,
                this.eoa.convert(),
                this.gradientProfile.convert(),
                this.speedProfile.convert(),
                this.modeProfile == null ? null : this.modeProfile.convert(),
                LP );
    }


}
