package de.ibw.tms.ma.physical;

import de.ibw.tms.ma.topologie.PositionedRelation;
import de.ibw.tms.plan.elements.interfaces.IConnectable;

import java.io.Serializable;
import java.util.List;

public interface ITrackElement extends Serializable, IConnectable {
    void updatePositionedRelation(List<PositionedRelation> relationList);

    List<PositionedRelation> getPositionedRelations();
}
