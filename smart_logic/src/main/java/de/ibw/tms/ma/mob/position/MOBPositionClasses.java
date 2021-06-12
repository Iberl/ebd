package de.ibw.tms.ma.mob.position;

import de.ibw.tms.ma.positioned.elements.LinearContiguousTrackArea;
import de.ibw.tms.ma.positioned.elements.train.TrainPositionSpots;
import de.ibw.util.intf.IToLogIntf;

/**
 * Track Area für eine Mobile
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2021-03-31
 *
 */
public class MOBPositionClasses extends LinearContiguousTrackArea implements IToLogIntf {
    private TrainPositionSpots begin;
    private TrainPositionSpots end;

    // wird im Konstruktor der Mobilen gesetzt; // wird wechselseitig referenziert
    private MOBPosition linkToMobileObject;


    public MOBPosition getLinkToMobileObject() {
        return linkToMobileObject;
    }

    public void setLinkToMobileObject(MOBPosition linkToMobileObject) {
        this.linkToMobileObject = linkToMobileObject;
    }

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

    @Override
    public String toString() {

        return "MOBPositionClasses{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }

    @Override
    public String log() {
        return "MOBPositionClasses{" +
                "begin=" + begin +
                ", end=" + end +
                super.log() +
                '}';
    }
}
