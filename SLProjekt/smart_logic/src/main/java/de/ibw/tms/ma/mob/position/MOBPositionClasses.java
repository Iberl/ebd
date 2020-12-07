package de.ibw.tms.ma.mob.position;

import de.ibw.tms.ma.positioned.elements.LinearContiguousTrackArea;
import de.ibw.tms.ma.positioned.elements.train.TrainPositionSpots;

public class MOBPositionClasses extends LinearContiguousTrackArea {
    private TrainPositionSpots begin;
    private TrainPositionSpots end;

    public MOBPositionClasses(String sName) {
        super(sName);
    }

    public TrainPositionSpots getBegin() {
        return begin;
    }

    public void setBegin(TrainPositionSpots begin) {
        this.begin = begin;
    }

    public TrainPositionSpots getEnd() {
        return end;
    }

    public void setEnd(TrainPositionSpots end) {
        this.end = end;
    }
}
