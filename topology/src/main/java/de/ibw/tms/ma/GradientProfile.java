package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(value = {
        "movementAuthority"

})
public class GradientProfile implements Serializable {
    private MovementAuthority movementAuthority;
    private List<GradientSegment> segmentList;

    public GradientProfile(MovementAuthority movementAuthority) {
        this.movementAuthority = movementAuthority;
        segmentList = new ArrayList<GradientSegment>();
    }
    public void addSegment(GradientSegment GS) {
        if(!this.segmentList.contains(GS)) {
            this.segmentList.add(GS);
            GS.addToProfile(this);
        }
    }

    public MovementAuthority getMovementAuthority() {
        return movementAuthority;
    }

    public void setMovementAuthority(MovementAuthority movementAuthority) {
        this.movementAuthority = movementAuthority;
    }

    public List<GradientSegment> getSegmentList() {
        return segmentList;
    }

    public void setSegmentList(List<GradientSegment> segmentList) {
        this.segmentList = segmentList;
    }
}
