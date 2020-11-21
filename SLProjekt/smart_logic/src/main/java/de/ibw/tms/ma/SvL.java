package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.spotsma.MASpots;

import java.io.Serializable;
@JsonIgnoreProperties(value = {
        "movementAuthority",
        "trackElement"
})
public class SvL extends MASpots implements Serializable {
    public static final String CLASS_IDENTIFIER = "Supervised_Location";
    public MovementAuthority movementAuthority;
    @Expose
    public int vmax = 0;

    @Expose
    public Chainage chainage;

    @Override
    public String toString() {
        return "SvL{" +
                "movementAuthority=" + movementAuthority +
                ", vmax=" + vmax +
                ", chainage=" + chainage +
                '}';
    }

    public SvL(SpotLocationIntrinsic SpotLoc) {
        super(CLASS_IDENTIFIER);
        this.setLocation(SpotLoc);
        this.chainage = SpotLoc.chainage;
    }

    public MovementAuthority getMovementAuthority() {
        return movementAuthority;
    }

    public void setMovementAuthority(MovementAuthority movementAuthority) {
        this.movementAuthority = movementAuthority;
    }

    public int getVmax() {
        return vmax;
    }

    public void setVmax(int vmax) {
        this.vmax = vmax;
    }
}
