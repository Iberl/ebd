package de.ibw.tms.speed.profile.model;

import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.SpeedSegment;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.speed.profile.controller.SegmentAddController;
/**
 * Ein Modell eines Speed-Segmentes einer Anzeige.
 * Diese Anzeige hat nach der Ausdehnung des Endgleises einer MA, einen Minimalen und einen Maximalen Abstand.
 * Minimal entspricht der Position eines Zuges.
 * Maximal ist die Ausdehnung der MA.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class SpeedSegmentViewModel {
    private Chainage MinChainage = new Chainage(0);
    private Chainage MaxChainage = new Chainage(700);
    private int iSpeedMax = 350;
    private int iSpeedMin = 0;

    private SegmentAddController Ctrl;


    private SpeedSegment Segment;


    /**
     * Setzt bezug zu dem Controller
     * @param ctrl {@link SegmentAddController} - Gesetzter Controller
     */
    public void setCtrl(SegmentAddController ctrl) {
        Ctrl = ctrl;
    }

    /**
     * Instanziert eine Model eines SpeedSegmentes zu einer Ansicht
     * @param S {@link SpeedSegment} - das Segment dieses Models
     */
    public SpeedSegmentViewModel(SpeedSegment S) {
        this.Segment = S;
    }


    /**
     * gibt das Segment wider
     * @return SpeedSegment - Segment
     */
    public SpeedSegment getSegment() {
        return Segment;
    }

    /**
     * Minmaler Abstand ist die Positon des Zuges, dargestellt als Chainage
     * @return Chainage - Kapselt den minimalen Abstand in Meter
     */
    public Chainage getMinChainage() {
        return MinChainage;
    }

    /**
     * Setzt den minimalen Abstand zur Balise als Chainage
     * @param minChainage - hat Abstand nin Meter
     */
    public void setMinChainage(Chainage minChainage) {
        MinChainage = minChainage;
    }

    /**
     * Maximaler Abstand entspricht Ende der Ma
     * @return
     */
    public Chainage getMaxChainage() {
        return MaxChainage;
    }
    /**
     * Setzt die maximale Ausdehneung der Segmente im Profil
     */
    public void setMaxChainage(Chainage maxChainage) {
        MaxChainage = maxChainage;
    }

    /**
     * unused
     * @return
     */
    public int getiSpeedMax() {
        return iSpeedMax;
    }

    /**
     * unused
     * @param iSpeedMax
     */
    public void setiSpeedMax(int iSpeedMax) {
        this.iSpeedMax = iSpeedMax;
    }

    /**
     * unused
     * @return
     */
    public int getiSpeedMin() {
        return iSpeedMin;
    }

    /**
     * unused
     * @param iSpeedMin
     */
    public void setiSpeedMin(int iSpeedMin) {
        this.iSpeedMin = iSpeedMin;
    }

    /**
     * Start Meter des Models ab Start
     * @param iResult int - Meter
     */
    public void setStartMeter(int iResult) {
        SpotLocation spotLocation = this.Segment.getBegin();

        spotLocation.setChainage(new Chainage(iResult));
        this.Segment.setSpeedChangeBegin(spotLocation);
    }

    /**
     * End Meter des Models
     * @param iResult int - Meter
     */
    public void setEndMeter(int iResult) {
        SpotLocation spotLocation = this.Segment.getEnd();
        spotLocation.setChainage(new Chainage(iResult));
        this.Segment.setSpeedChangeEnd(spotLocation);
    }

    /**
     * Setzt die Geschwindigkeit als Eingabe in (km per h)
     * @param iResult - (km per h)
     */
    public void setSpeed(int iResult) {
        byte bSpeed = (byte) Math.floor(iResult / 5.0f);
        ETCS_SPEED etcsSpeed = new ETCS_SPEED();
        etcsSpeed.bSpeed = bSpeed;
        this.Segment.setV_STATIC(etcsSpeed);
    }
}
