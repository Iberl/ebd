package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.ma.positioning.IntrinsicCoordinate;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import org.railMl.rtm4rail.TApplicationDirection;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;

/**
 *
 */
public class TrackArea extends LinearElement {
    TApplicationDirection applicationDirection;
    List<TrackEdgeSection> trackEdgeSections;

    public TrackArea(String sName) {
        super(sName);
    }

    public TApplicationDirection getApplicationDirection() {
        return applicationDirection;
    }

    public void setApplicationDirection(TApplicationDirection applicationDirection) {
        this.applicationDirection = applicationDirection;
    }

    public List<TrackEdgeSection> getTrackEdgeSections() {
        return trackEdgeSections;
    }

    public void setTrackEdgeSections(List<TrackEdgeSection> trackEdgeSections) {
        this.trackEdgeSections = trackEdgeSections;
    }

    public BigDecimal getMeterLength() {
        BigDecimal result = new BigDecimal(0);
        if(trackEdgeSections == null) return new BigDecimal(0);
        else {
            for(TrackEdgeSection TES : trackEdgeSections) {
                if(TES == null) throw new InvalidParameterException("Treck Edge Section of Track-Area is null");
                else {
                    if(TES.getBegin() == null) throw new InvalidParameterException("Track Edge Section having no begin specified.");
                    if(TES.getEnd() == null) throw new InvalidParameterException("Track Edge Section having no end specified.");
                    if(TES.getTrackEdge() == null) throw new InvalidParameterException("Track Edge is null");
                    TopologyGraph.Edge TE = (TopologyGraph.Edge) TES.getTrackEdge();
                    BigDecimal dEdgeLength = new BigDecimal(TE.dTopLength);


                    Double dStart = TES.getBegin().getIntrinsicCoord();
                    Double dEnd = TES.getEnd().getIntrinsicCoord();
                    if(dStart == null) throw new InvalidParameterException("Treck Edge Section begin-value is null.");
                    if(dEnd == null) throw new InvalidParameterException("Treck Edge Section end-value is null.");

                    BigDecimal startPercent = new BigDecimal(dStart);
                    BigDecimal endPercent = new BigDecimal(dEnd);
                    if(startPercent.compareTo(new BigDecimal(0)) < 0 ||
                            startPercent.compareTo(new BigDecimal(1)) > 0) {
                        throw new InvalidParameterException("Treck Edge Section begin-value have to be percentage.");
                    }
                    if(endPercent.compareTo(new BigDecimal(0)) < 0 ||
                            endPercent.compareTo(new BigDecimal(1)) > 0) {
                        throw new InvalidParameterException("Treck Edge Section end-value have to be percentage.");
                    }
                    BigDecimal usedFactor = endPercent.subtract(startPercent).abs();
                    result = result.add(dEdgeLength.abs().multiply(usedFactor));
                }
            }
        }
        return result;
    }

}
