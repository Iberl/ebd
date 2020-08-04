package de.ibw.tms.ma;

import de.ibw.tms.ma.topologie.ApplicationDirection;

import java.io.Serializable;
import java.util.Comparator;



public class LinearLocation implements Serializable {

    private SpotLocation begin;

    private SpotLocation end;
    private ApplicationDirection Direction;

    public LinearLocation(SpotLocation begin, SpotLocation end, ApplicationDirection direction) {
        this.begin = begin;
        this.end = end;
        Direction = direction;
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

    public ApplicationDirection getDirection() {
        return Direction;
    }

    public void setDirection(ApplicationDirection direction) {
        Direction = direction;
    }
}
