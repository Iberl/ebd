package de.ibw.tms.speed.profile.model;

import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.SpeedSegment;
import de.ibw.tms.ma.SpotLocation;
import de.ibw.tms.speed.profile.controller.SegmentAddController;

public class SpeedSegmentViewModel {
    private Chainage MinChainage = new Chainage(0);
    private Chainage MaxChainage = new Chainage(700);
    private int iSpeedMax = 350;
    private int iSpeedMin = 0;

    private SegmentAddController Ctrl;


    private SpeedSegment Segment;



    public void setCtrl(SegmentAddController ctrl) {
        Ctrl = ctrl;
    }

    public SpeedSegmentViewModel(SpeedSegment S) {
        this.Segment = S;
    }



    public SpeedSegment getSegment() {
        return Segment;
    }

    public Chainage getMinChainage() {
        return MinChainage;
    }

    public void setMinChainage(Chainage minChainage) {
        MinChainage = minChainage;
    }

    public Chainage getMaxChainage() {
        return MaxChainage;
    }

    public void setMaxChainage(Chainage maxChainage) {
        MaxChainage = maxChainage;
    }

    public int getiSpeedMax() {
        return iSpeedMax;
    }

    public void setiSpeedMax(int iSpeedMax) {
        this.iSpeedMax = iSpeedMax;
    }

    public int getiSpeedMin() {
        return iSpeedMin;
    }

    public void setiSpeedMin(int iSpeedMin) {
        this.iSpeedMin = iSpeedMin;
    }

    public void setStartMeter(int iResult) {
        SpotLocation spotLocation = this.Segment.getBegin();

        spotLocation.setChainage(new Chainage(iResult));
        this.Segment.setSpeedChangeBegin(spotLocation);
    }

    public void setEndMeter(int iResult) {
        SpotLocation spotLocation = this.Segment.getEnd();
        spotLocation.setChainage(new Chainage(iResult));
        this.Segment.setSpeedChangeEnd(spotLocation);
    }

    public void setSpeed(int iResult) {
        byte bSpeed = (byte) Math.floor(iResult / 5.0f);
        ETCS_SPEED etcsSpeed = new ETCS_SPEED();
        etcsSpeed.bSpeed = bSpeed;
        this.Segment.setV_STATIC(etcsSpeed);
    }
}
