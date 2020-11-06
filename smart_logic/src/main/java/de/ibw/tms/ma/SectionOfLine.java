package de.ibw.tms.ma;

import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.ma.positioned.elements.GradientSegment;
import de.ibw.tms.plan.elements.Rail;
import org.apache.commons.lang3.NotImplementedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SectionOfLine implements Serializable {
    public List<GradientSegment> gradientLocations;
    public List<SpeedSegment> speedLocations;

    public List<PositioningNetElement> positioningNetElementList;

    public SectionOfLine() {
        gradientLocations = new ArrayList<GradientSegment>();
        speedLocations = new ArrayList<SpeedSegment>();
        this.positioningNetElementList = new ArrayList<>();

    }
    public void addRails(ArrayList<Rail> rails) {
        for(Rail R : rails) {
            TrackElement TE = R.getTrackReference();

            throw new NotImplementedException("add Rails of Section Of Line not implemented");

            /*PositioningNetElement PNE = new PositioningNetElement();
            EntityLocation EL = new EntityLocation();
            EL.setLocatedNetEntity(TE);
            EL.setMainNetElement(PNE);
            PNE.setEntityLocation(EL);
            this.positioningNetElementList.add(PNE);
            */

        }
    }

}
