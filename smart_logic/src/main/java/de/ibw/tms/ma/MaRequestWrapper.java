package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.controller.TmsController;
import de.ibw.tms.ma.repo.MaRepository;
import de.ibw.tms.train.model.TrainModel;

import java.util.ArrayList;

/**
 *
 */
public class MaRequestWrapper {

    private static int iRequestCount = 0;

    @Expose
    public MARequest Request;
    @Expose
    public TrainModel Tm;


    public MaRequestWrapper(MARequest MAR) {
        this.Request = MAR;

        init();
    }

    private void init() {
        if(this.Request == null) {
            this.Request = new MARequest();
            this.Request.setRoute(new Route(new ArrayList<>()));
            this.Request.setMa(new MovementAuthority());
            this.Request.setTms(TmsController.getInstance());
            this.Request.setTrain(new TrainMovement());

        }
    }

    // is accepted by SL
    public void confirm() {
        MaRepository.confirmMaRequest(this);
    }

    public void save() {
        /*if(iId == -1) {
            iRequestCount = iRequestCount + 1;
            iId = iRequestCount;
        }*/
        MaRepository.update(this);
    }

    public void delete() {
        MaRepository.remove(this);
    }

    public Route getRoute() {
        return this.Request.getRoute();
    }
    public void setRoute(Route R) {
        this.Request.setRoute(R);
    }

    public TrainModel getTm() {
        return Tm;
    }

    public void setTm(TrainModel tm) {
        Tm = tm;
    }

    @Override
    public String toString() {
        return "MaRequestWrapper{" +
                "Request=" + Request +
                ", Tm=" + Tm +
                '}';
    }
}
