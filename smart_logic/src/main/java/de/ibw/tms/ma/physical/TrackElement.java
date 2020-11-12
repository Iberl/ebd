package de.ibw.tms.ma.physical;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.ibw.tms.ma.DangerZone;
import de.ibw.tms.ma.Occupation;
import de.ibw.tms.ma.SpotLocation;
import de.ibw.tms.ma.topologie.PositionedRelation;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {
        "positionedRelations",
        "spotLocationList",
        "dangerZones",
        "occupations"
})

public abstract class TrackElement extends LocatedNetEntity implements ITrackElement {



    private List<PositionedRelation> positionedRelations = new ArrayList<PositionedRelation>();

    private List<SpotLocation> spotLocationList = new ArrayList<SpotLocation>();

    List<DangerZone> dangerZones;
    List<Occupation> occupations;
    boolean isSyncState;
    //TODO Positioned Relation Update

    @Override
    public void updatePositionedRelation(List<PositionedRelation> relationList) {
        this.positionedRelations = relationList;
    }

    @Override
    public List<PositionedRelation> getPositionedRelations() {
        return positionedRelations;
    }



}
