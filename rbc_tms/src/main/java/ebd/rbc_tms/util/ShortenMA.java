package ebd.rbc_tms.util;

import ebd.rbc_tms.util.annotations.CanBeNull;

import java.util.Objects;

/**
 * Movement Authority Used In {@link ebd.rbc_tms.message.Message_22}
 *
 * @author Christopher Bernjus
 */
public class ShortenMA extends GeneralMA {

    /** {@link ModeProfile} */
    @CanBeNull
    public ModeProfile modeProfile;

    /** {@link LinkingProfile} */
    @CanBeNull
    public LinkingProfile linkingProfile;


    // Constructor

    /**
     * Constructs A {@link ShortenMA} Object
     *
     * @param m_ack {@link GeneralMA#m_ack}
     * @param nid_lrbg {@link GeneralMA#nid_lrbg}
     * @param q_dir {@link GeneralMA#q_dir}
     * @param q_scale {@link GeneralMA#q_scale}
     * @param eoa {@link EOA}
     * @param modeProfile {@link ModeProfile}
     * @param linkingProfile {@link LinkingProfile}
     *
     * @author Christopher Bernjus
     */
    public ShortenMA(boolean m_ack, int nid_lrbg, int q_dir, int q_scale, EOA eoa, ModeProfile modeProfile, LinkingProfile linkingProfile) {
        super(m_ack, nid_lrbg, q_dir, q_scale, eoa);
        this.modeProfile = modeProfile;
        this.linkingProfile = linkingProfile;
    }


    // Functions

    @Override
    public String toString() {
        return "ShortenMA{" + "m_ack=" + m_ack + ", nid_lrbg=" + nid_lrbg + ", q_dir=" + q_dir + ", q_scale=" +
               q_scale + ", eoa=" + eoa + ", modeProfile=" + (modeProfile == null ? "null" : modeProfile.toString()) + ", linkingProfile=" + (linkingProfile == null ? "null" : linkingProfile.toString()) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        ShortenMA shortenMA = (ShortenMA) o;
        return Objects.equals(modeProfile, shortenMA.modeProfile) && Objects.equals(linkingProfile, shortenMA.linkingProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modeProfile, linkingProfile);
    }

}
