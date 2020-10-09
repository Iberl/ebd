package de.ibw.tms.ma;

import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.Rail;

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

            PositioningNetElement PNE = new PositioningNetElement();
            EntityLocation EL = new EntityLocation();
            EL.setLocatedNetEntity(TE);
            EL.setMainNetElement(PNE);
            PNE.setEntityLocation(EL);
            this.positioningNetElementList.add(PNE);


        }
    }

}
