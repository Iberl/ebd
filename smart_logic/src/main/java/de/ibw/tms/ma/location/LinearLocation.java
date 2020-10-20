package de.ibw.tms.ma.location;

import de.ibw.rtm.intf.*;
import de.ibw.tms.ma.SpeedSegment;
import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.ma.positioning.AssociatedPositioningSystem;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMAssociatedNetElement;
import org.railMl.rtm4rail.RTMGeometricCoordinate;
import org.railMl.rtm4rail.RTMLinearCoordinate;
import org.railMl.rtm4rail.TApplicationDirection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class LinearLocation extends EntityLocation implements IRTMLinearLocation, Serializable {
    private static final String CLASS_IDENTIFIER = "Linear_Location";


    private SpotLocation begin;

    private SpotLocation end;
    private TApplicationDirection applicationDirection;
    private List<IRTMPositioningNetElement> netElements; // needed?
    private List<OrderedAssociatedNetElement> associatedElements;



    public LinearLocation(SpotLocation begin, SpotLocation end, TApplicationDirection direction) {
        super(CLASS_IDENTIFIER);
        this.begin = begin;
        this.end = end;
        this.netElements = new ArrayList<>();
        this.associatedElements = new ArrayList<>();

    }




    public Comparator<SpeedSegment> SpeedComparator() {
        return new Comparator<SpeedSegment>() {
            @Override
            public int compare(SpeedSegment lhs, SpeedSegment rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                if (lhs.getBegin().getChainage().getiMeters() > rhs.getBegin().getChainage().getiMeters()) return 1;
                if (lhs.getBegin().getChainage().getiMeters() < rhs.getBegin().getChainage().getiMeters()) return -1;
                if (lhs.getBegin().getChainage().getiMeters() == rhs.getBegin().getChainage().getiMeters()) {
                    if (lhs.getV_STATIC().bSpeed == 0) return 1;
                    else return -1;
                }
                return 0;
            }
        };
    }
    public Comparator<LinearLocation> DefaultComparator() {
        return new Comparator<LinearLocation>() {
            @Override
            public int compare(LinearLocation lhs, LinearLocation rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return Integer.compare(lhs.getBegin().getChainage().getiMeters(), rhs.getBegin().getChainage().getiMeters());


            }
        };
    }

    public SpotLocation getBegin() {
        return begin;
    }

    public void setBegin(SpotLocation begin) {
        this.begin = begin;
    }

    public SpotLocation getEnd() {
        return end;
    }

    public void setEnd(SpotLocation end) {
        this.end = end;
    }


    public void addElement(List<IRTMPositioningNetElement> elementList) {
        for(IRTMPositioningNetElement Element : elementList) {
            if(!netElements.contains(Element)) {
                netElements.add(Element);
            }

        }
    }
    public void addAssociation(List<OrderedAssociatedNetElement> aElem) {
        for(OrderedAssociatedNetElement Element : aElem) {
            if(!associatedElements.contains(Element)) {
                associatedElements.add(Element);
            }

        }
    }

    public List<IRTMAssociatedNetElement> getOrderedAssociatedNetElement() {
        return new ArrayList<>(this.associatedElements);
    }

    public List<IRTMPositioningSystemCoordinate> getLinCoordinate() {
        boolean isLinear = true;
        return getCoordinate(isLinear);
    }

    public List<IRTMPositioningSystemCoordinate> getGeoCoordinate() {
        boolean isLinear = false;
        return getCoordinate(isLinear);
    }

    private List<IRTMPositioningSystemCoordinate> getCoordinate(boolean isLinear) {
        ArrayList<IRTMPositioningSystemCoordinate> result = new ArrayList<>();
        for(IRTMPositioningNetElement Element : this.netElements) {
            PositioningNetElement PosElement = (PositioningNetElement) Element;
            List<IRTMAssociatedPositioningSystem> posSystems = PosElement.getPositioningSystems();
            for(IRTMAssociatedPositioningSystem AsociatedSystem : posSystems) {
                AssociatedPositioningSystem AsociatedPosSystem = (AssociatedPositioningSystem) AsociatedSystem;
                List<IRTMIntrinsicCoordinate> coordinates = AsociatedPosSystem.getCoordinates();
                for(IRTMIntrinsicCoordinate IC : coordinates) {
                    if(isLinear) {
                        if(IC instanceof IRTMLinearCoordinate) {
                            result.add((IRTMPositioningSystemCoordinate) IC);
                        }
                    } else {
                        if (IC instanceof IRTMGeometricCoordinate) {
                            result.add((IRTMPositioningSystemCoordinate) IC);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<RTMAssociatedNetElement> getAssociatedNetElement() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public List<RTMLinearCoordinate> getLinearCoordinate() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public List<RTMGeometricCoordinate> getGeometricCoordinate() {
        throw new NotImplementedException("Converter needed");
    }

    @Override
    public TApplicationDirection getApplicationDirection() {
        return applicationDirection;
    }

    @Override
    public void setApplicationDirection(TApplicationDirection value) {
        applicationDirection = value;
    }
}
