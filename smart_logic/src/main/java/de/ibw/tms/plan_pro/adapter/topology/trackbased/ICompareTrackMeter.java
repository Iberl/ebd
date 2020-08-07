package de.ibw.tms.plan_pro.adapter.topology.trackbased;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface ICompareTrackMeter {
    BigDecimal getTrackMeterByTrackId(String trackId);
    default Boolean thisHasLowerTrackMeter(ICompareTrackMeter other) {

        ArrayList<String> thisTracks = new ArrayList<>(getSupportedTracks());
        thisTracks.retainAll(other.getSupportedTracks());
        if(thisTracks.isEmpty()) return null;
        String sTrackId = thisTracks.get(0);
        boolean isThisLower = this.getTrackMeterByTrackId(sTrackId).compareTo(other.getTrackMeterByTrackId(sTrackId)) < 0;
        return isThisLower;

    }
    ArrayList<String> getSupportedTracks();

}
