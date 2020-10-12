package de.ibw.tms.ma.net.elements;

import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.topologie.ApplicationDirection;

public interface IPositionedRelation {
    void createPositionedRelation(ILocatedNetEntity Tvia, ILocatedNetEntity Tfrom, ILocatedNetEntity Tto,
                                  boolean bNavigabilite, int vmax, ApplicationDirection Direction,
                                  TrackElementStatus ViaStatus);

    ILocatedNetEntity getVia();
    ILocatedNetEntity getFrom();
    ILocatedNetEntity getTo();
    int getVmax();
    ApplicationDirection getApplicationDirection();
    TrackElementStatus getViaElementStatus();
}
