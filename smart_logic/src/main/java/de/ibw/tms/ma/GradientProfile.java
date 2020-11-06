package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.ibw.tms.ma.positioned.elements.GradientSegment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(value = {
        "movementAuthority"

})
/**
 * Ein Profil als Gradient Segments
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-06
 */
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
