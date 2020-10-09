package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(value = {
        "movementAuthority"
})
public class SSP implements Serializable {
    private MovementAuthority movementAuthority;
    @Expose
    public List<SpeedSegment> speedSegments;


    public MovementAuthority getMovementAuthority() {
        return movementAuthority;
    }

    public void setMovementAuthority(MovementAuthority movementAuthority) {
        this.movementAuthority = movementAuthority;
    }

    public List<SpeedSegment> getSpeedSegments() {
        return speedSegments;
    }

    public void setSpeedSegments(List<SpeedSegment> speedSegments) {
        this.speedSegments = speedSegments;
    }

    @Override
    public String toString() {
        return "SSP{" +
                "speedSegments=" + speedSegments +
                '}';
    }
}
