package de.ibw.tms.ma;

import de.ibw.tms.etcs.Q_FRONT;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.positioned.elements.InformationPoint;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import org.railMl.rtm4rail.TApplicationDirection;

import java.io.Serializable;

public class SpeedChange extends InformationPoint implements Serializable {

    public static final String CLASS_IDENTIFIER = "Speed_Segment";
    // anders als in specification
    // jetzt ETCS 4 Werte 2 Bits

    private Q_FRONT q_FRONT;
    private byte q_DIFF;

    public SpeedChange(TrackEdge Edge, SpotLocationIntrinsic SLI, TApplicationDirection AppDir, Q_FRONT Q_F, byte q_DIFF) {
        super(CLASS_IDENTIFIER);
        this.setTrackEdge(Edge);
        this.setIntrinsicCoord(SLI);
        this.setApplicationDirection(AppDir);
        this.q_FRONT = Q_F;
        this.q_DIFF = q_DIFF;
    }


    public byte getQ_DIFF() {
        return q_DIFF;
    }

    public void setQ_DIFF(byte q_DIFF) {
        this.q_DIFF = q_DIFF;
    }
}
