package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.controller.TmsController;

import java.io.Serializable;

public class MARequest implements Serializable {
    @Expose
    public MovementAuthority ma;
    private TrainMovement train;
    private TmsController tms;
    @Expose
    private Route route;

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
