package de.ibw.tms.ma.net.elements;

import de.ibw.tms.ma.common.INetResource;
import de.ibw.tms.ma.net.elements.Relation;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.topologie.ApplicationDirection;

import java.util.List;

/**
 * Positioned Relation nach RTM Definition
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-12
 */
public class PositionedRelation extends Relation implements IPositionedRelation  {

    private INetResource elementA;
    private INetResource elementB;
    // ist Element A am Start mit B verlinkt : 0
    // ist Element A am Ende mit B verlinkt: 1
    private boolean positionOnA;
    // ist Element B am Start mit A verlinkt : 0
    // ist Element B am Ende mit A verlinkt: 1
    private boolean isPositionOnB;
    private Navigability navigability;
    private int vmax;
    private ApplicationDirection applicationDirection;
    private TrackElementStatus ViaElementStatus;

    /**
     * Relation muss mindestens ein Element enhalten
     *
     * @param elements - Liste mit mindestens einem Element
     */
    public PositionedRelation(List<NetElement> elements) {
        super(elements);
    }

    @Deprecated
    public void createPositionedRelation(ILocatedNetEntity Tvia, ILocatedNetEntity Tfrom, ILocatedNetEntity Tto,
                                         boolean bNavigabilite, int vmax, ApplicationDirection Direction,
                                         TrackElementStatus ViaStatus) {

        if(bNavigabilite) {
            this.navigability = Navigability.AB;
            this.elementA = Tfrom;
            this.elementB = Tto;

        } else return;

        this.vmax = vmax;
        this.applicationDirection = Direction;
        this.ViaElementStatus = ViaStatus;
    }
    public void createPositionedRelation(PositioningNetElement ElementA, PositioningNetElement ElementB,
                                         Navigability N, int vmax, ApplicationDirection Direction) {

        this.elementA = ElementA;
        this.elementB = ElementB;
        this.navigability = N;
        this.vmax = vmax;
        this.applicationDirection = Direction;

    }




    public ILocatedNetEntity getVia() {
        return new UnknownLocatedNetEntity();
    }

    public ILocatedNetEntity getFrom() {
        switch (this.navigability) {
            case AB: {
                return (ILocatedNetEntity) this.elementA;
            }
            case BA: {
                return (ILocatedNetEntity) this.elementB;
            }
            case BOTH: return (ILocatedNetEntity) this.elementA;
            case NONE: return new UnknownLocatedNetEntity();
        }
        return new UnknownLocatedNetEntity();
    }

    public ILocatedNetEntity getTo() {
        switch (this.navigability) {
            case AB: {
                return (ILocatedNetEntity) this.elementB;
            }
            case BA: {
                return (ILocatedNetEntity) this.elementA;
            }
            case BOTH: return (ILocatedNetEntity) this.elementB;
            case NONE: return new UnknownLocatedNetEntity();
        }
        return new UnknownLocatedNetEntity();
    }



    public int getVmax() {
        return vmax;
    }

    public ApplicationDirection getApplicationDirection() {
        return applicationDirection;
    }

    public TrackElementStatus getViaElementStatus() {
        return ViaElementStatus;
    }
}
