package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.physical.TrackElement;

import java.io.Serializable;
@JsonIgnoreProperties(value = {
        "movementAuthority",
        "trackElement"
})
public class SvL extends SpotLocation implements Serializable {

    public MovementAuthority movementAuthority;
    @Expose
    public int vmax = 0;

    @Override
    public String toString() {
        return "SvL{" +
                "movementAuthority=" + movementAuthority +
                ", vmax=" + vmax +
                ", chainage=" + chainage +
                '}';
    }

    public SvL(Chainage chainage, TrackElement trackElement, SectionOfLine lineSection) {
        super(chainage, trackElement, lineSection);
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
