package ebd.internal.util;

import ebd.internal.message.Message_21;
import ebd.internal.util.annotations.CanBeNull;

import java.util.Objects;

/**
 * Movement Authority Used In {@link Message_21}
 *
 * @author Christopher Bernjus
 */
public class MA extends GeneralMA {

    /** {@link ETCSVariables#D_REF} */
    @CanBeNull
    public Integer d_ref;

    /** {@link GradientProfile} */
    @CanBeNull
    public GradientProfile gradientProfile;

    /** {@link SpeedProfile} */
    @CanBeNull
    public SpeedProfile speedProfile;

    /** {@link ModeProfile} */
    @CanBeNull
    public ModeProfile modeProfile;

    /** {@link LinkingProfile} */
    @CanBeNull
    public LinkingProfile linkingProfile;


    // Constructors

    /**
     * Constructs A {@link MA} Object
     *
     * @param m_ack {@link GeneralMA#m_ack}
     * @param nid_lrbg {@link GeneralMA#nid_lrbg}
     * @param q_dir {@link GeneralMA#q_dir}
     * @param q_scale {@link GeneralMA#q_scale}
     * @param eoa {@link EOA}
     * @param gradientProfile {@link GradientProfile}
     * @param speedProfile {@link SpeedProfile}
     * @param modeProfile {@link ModeProfile}
     * @param linkingProfile {@link LinkingProfile}
     *
     * @author Christopher Bernjus
     */
    public MA(boolean m_ack, int nid_lrbg, int q_dir, int q_scale, EOA eoa, GradientProfile gradientProfile, SpeedProfile speedProfile,
              ModeProfile modeProfile, LinkingProfile linkingProfile) {
        super(m_ack, nid_lrbg, q_dir, q_scale, eoa);
        this.gradientProfile = gradientProfile;
        this.speedProfile = speedProfile;
        this.modeProfile = modeProfile;
        this.linkingProfile = linkingProfile;
    }

    /**
     * Constructs A {@link MA} Object With Shifted Location Reference
     *
     * @param m_ack {@link GeneralMA#m_ack}
     * @param nid_lrbg {@link GeneralMA#nid_lrbg}
     * @param q_dir {@link GeneralMA#q_dir}
     * @param q_scale {@link GeneralMA#q_scale}
     * @param d_ref {@link MA#d_ref}
     * @param eoa {@link EOA}
     * @param gradientProfile {@link GradientProfile}
     * @param speedProfile {@link SpeedProfile}
     * @param modeProfile {@link ModeProfile}
     * @param linkingProfile {@link LinkingProfile}
     *
     * @author Christopher Bernjus
     */
    public MA(boolean m_ack, int nid_lrbg, int q_dir, int q_scale, int d_ref, EOA eoa, GradientProfile gradientProfile, SpeedProfile speedProfile,
              ModeProfile modeProfile, LinkingProfile linkingProfile) {
        super(m_ack, nid_lrbg, q_dir, q_scale, eoa);
        this.d_ref = d_ref;
        this.gradientProfile = gradientProfile;
        this.speedProfile = speedProfile;
        this.modeProfile = modeProfile;
        this.linkingProfile = linkingProfile;
    }


    // Functions

    @Override
    public String toString() {
        return "MA{" + "m_ack=" + m_ack + ", nid_lrbg=" + nid_lrbg + ", q_dir=" + q_dir + ", q_scale=" + q_scale + ", eoa=" + eoa.toString() + ", d_ref=" + (d_ref == null ? "null" : d_ref) +
               ", gradientProfile=" + (gradientProfile == null ? "null" : gradientProfile.toString()) + ", speedProfile=" + (speedProfile == null ? "null" : speedProfile.toString()) +
               ", modeProfile=" + (modeProfile == null ? "null" : modeProfile.toString()) + ", linkingInfo=" + (linkingProfile == null ? "null" : linkingProfile.toString()) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        MA ma = (MA) o;
        return Objects.equals(gradientProfile, ma.gradientProfile) && Objects.equals(speedProfile, ma.speedProfile) &&
               Objects.equals(modeProfile, ma.modeProfile) && Objects.equals(linkingProfile, ma.linkingProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gradientProfile, speedProfile, modeProfile, linkingProfile);
    }

}
