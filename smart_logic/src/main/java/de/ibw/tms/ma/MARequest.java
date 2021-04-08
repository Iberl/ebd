package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.controller.TmsController;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.occupation.MARequestOccupation;

import java.io.Serializable;


public class MARequest implements Serializable {


    public MovementAuthority ma;
    private TrainMovement train;
    private TmsController tms;
    @Expose
    private Route route;

    private MovableObject trainId;
    private MARequestOccupation occupation;

    public MARequest(MovementAuthority ma, MARequestOccupation occupation) {
        this.ma = ma;
        this.occupation = occupation;
        if(occupation != null) {
            occupation.setR(this);
        }

    }

    public MovementAuthority getMa() {
        return ma;
    }

    public void setMa(MovementAuthority ma) {
        this.ma = ma;
    }

    public TrainMovement getTrain() {
        return train;
    }

    public void setTrain(TrainMovement train) {
        this.train = train;
    }

    public TmsController getTms() {
        return tms;
    }

    public void setTms(TmsController tms) {
        this.tms = tms;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "MARequest{" +
                "ma=" + ma +
                '}';
    }
}
