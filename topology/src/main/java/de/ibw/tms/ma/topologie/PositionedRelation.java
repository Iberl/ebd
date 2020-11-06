package de.ibw.tms.ma.topologie;

import de.ibw.tms.ma.physical.TrackElementStatus;


public class PositionedRelation extends Relation {
    private TrackElement Via;
    private TrackElement From;
    private TrackElement To;
    private boolean navigability;
    private int vmax;
    private ApplicationDirection applicationDirection;
    private TrackElementStatus ViaElementStatus;


    public void createPositionedRelation(TrackElement Tvia, TrackElement Tfrom, TrackElement Tto,
                                         boolean bNavigabilite, int vmax, ApplicationDirection Direction,
                                         TrackElementStatus ViaStatus) {
        this.Via = Tvia;
        this.From = Tfrom;
        this.To = Tto;
        this.navigability = bNavigabilite;
        this.vmax = vmax;
        this.applicationDirection = Direction;
        this.ViaElementStatus = ViaStatus;
    }


    public void setNavigability(boolean navigability) {
        this.navigability = navigability;
    }

    public TrackElement getVia() {
        return Via;
    }

    public TrackElement getFrom() {
        return From;
    }

    public TrackElement getTo() {
        return To;
    }

    public boolean isNavigability() {
        return navigability;
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
