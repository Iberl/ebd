package de.ibw.tms.ma.net.elements;

import de.ibw.rtm.intf.IRTMPositioningNetElement;
import de.ibw.rtm.intf.IRTMRelation;
import de.ibw.tms.ma.common.DefaultObject;
import de.ibw.tms.ma.common.INetResource;
import de.ibw.tms.ma.common.NetworkResource;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import org.railMl.rtm4rail.TElementWithID;
import org.railMl.rtm4rail.TElementWithIDref;
import org.railMl.rtm4rail.TNavigability;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * Positioned Relation nach RTM Definition
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-14
 */
public class PositionedRelation extends NetworkResource implements IRTMRelation {
    public static final String CLASS_IDENTIFIER = "Positioned_Relation";


    private IRTMPositioningNetElement elementA;
    private IRTMPositioningNetElement elementB;
    // ist Element A am Start mit B verlinkt : 0
    // ist Element A am Ende mit B verlinkt: 1
    private boolean positionOnA;
    // ist Element B am Start mit A verlinkt : 0
    // ist Element B am Ende mit A verlinkt: 1
    private boolean positionOnB;
    private TNavigability navigability;
    private int vmax;
    private ApplicationDirection applicationDirection;
    private TrackElementStatus ViaElementStatus;

    /**
     * Relation muss mindestens ein Element enhalten
     *
     * @param elements - Liste mit mindestens einem Element
     */
    public PositionedRelation(List<INetElement> elements) {
        super(CLASS_IDENTIFIER);
        defaultInit("PositionedRelation");
    }

    @Deprecated
    public void createPositionedRelation(IRTMPositioningNetElement Tvia, IRTMPositioningNetElement Tfrom, IRTMPositioningNetElement Tto,
                                         boolean bNavigabilite, int vmax, ApplicationDirection Direction,
                                         TrackElementStatus ViaStatus) {

        if(bNavigabilite) {
            this.navigability = TNavigability.AB;
            this.elementA = Tfrom;
            this.elementB = Tto;

        } else return;

        this.vmax = vmax;
        this.applicationDirection = Direction;
        this.ViaElementStatus = ViaStatus;
    }
    public void createPositionedRelation(IRTMPositioningNetElement ElementA, IRTMPositioningNetElement ElementB,
                                         TNavigability N, int vmax, ApplicationDirection Direction) {

        this.elementA = ElementA;
        this.elementB = ElementB;
        this.navigability = N;
        this.vmax = vmax;
        this.applicationDirection = Direction;

    }




    public ILocatedNetEntity getVia() {
        return new UnknownLocatedNetEntity();
    }

    public IRTMPositioningNetElement getFrom() {
        switch (this.navigability) {
            case AB: {
                return this.elementA;
            }
            case BA: {
                return this.elementB;
            }
            case BOTH: return this.elementA;
            case NONE: return null;
        }
        return null;
    }

    public IRTMPositioningNetElement getTo() {
        switch (this.navigability) {
            case AB: {
                return  this.elementB;
            }
            case BA: {
                return  this.elementA;
            }
            case BOTH: return this.elementB;
            case NONE: return null;
        }
        return null;
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

    @Override
    public TElementWithIDref getElementA() {
        TElementWithIDref ResultElement = new TElementWithIDref();
        ResultElement.setRef(this.elementA.getId());
        return ResultElement;
    }

    @Override
    public void setElementA(TElementWithIDref value) {
        this.elementA =
                (IRTMPositioningNetElement) DefaultObject.topologyRepository.getModel(UUID.fromString(value.getRef()));

    }

    @Override
    public TElementWithIDref getElementB() {
        TElementWithIDref ResultElement = new TElementWithIDref();
        ResultElement.setRef(this.elementB.getId());
        return ResultElement;
    }

    @Override
    public void setElementB(TElementWithIDref value) {
        this.elementB =
                (IRTMPositioningNetElement) DefaultObject.topologyRepository.getModel(UUID.fromString(value.getRef()));

    }

    @Override
    public TNavigability getNavigability() {
        return this.navigability;
    }

    @Override
    public void setNavigability(TNavigability value) {
        this.navigability = value;
    }

    @Override
    public BigInteger getPositionOnA() {
        if(positionOnA) {
            return new BigInteger("1");
        } else return new BigInteger("0");
    }

    @Override
    public void setPositionOnA(BigInteger value) {
        this.positionOnA = !BigInteger.ZERO.equals(value);
    }

    @Override
    public BigInteger getPositionOnB() {
        if(positionOnB) {
            return new BigInteger("1");
        } else return new BigInteger("0");
    }

    @Override
    public void setPositionOnB(BigInteger value) {
        this.positionOnB = !BigInteger.ZERO.equals(value);
    }


}
