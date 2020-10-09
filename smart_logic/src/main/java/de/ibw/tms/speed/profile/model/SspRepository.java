package de.ibw.tms.speed.profile.model;

import de.ibw.tms.ma.SpeedSegment;
import de.ibw.util.DefaultRepo;

import java.util.List;
/**
 * unused
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class SspRepository {





    // CStrecke String Id for each segement
    // Integer iMeter - Streckenkilometrierung
    public static DefaultRepo<String, DefaultRepo<Integer, SpeedSegment>> SpeedRepo = new DefaultRepo<>();

    public static void addSpeedSegment(String sTrackId, int iMeter, SpeedSegment Segment) {
        DefaultRepo<Integer, SpeedSegment> segmentByKilometric = SpeedRepo.getModel(sTrackId);
        if(segmentByKilometric == null) {
            segmentByKilometric = new DefaultRepo<Integer, SpeedSegment>();
        }
        segmentByKilometric.update(iMeter, Segment);
        SpeedRepo.update(sTrackId, segmentByKilometric);
    }

    public static List<SpeedSegment> getSegmentsOfTrack(String sTrackId) {
        DefaultRepo<Integer, SpeedSegment> segmentByKilometric = SpeedRepo.getModel(sTrackId);
        return segmentByKilometric.sortValues();
    }



}
