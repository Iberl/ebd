package de.ibw.tms.train.controller;

import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.tms.train.ui.SpeedProfilePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class SpeedProfileController extends SubmissionPublisher<TrainModel> implements IController<TrainModel> {

    private TrainModel Model;
    private SpeedProfilePanel SpeedPanel;

    public SpeedProfileController(TrainModel Tm, SpeedProfilePanel SP) {
        this.Model = Tm;
        this.SpeedPanel = SP;
    }


    public void handleMousePress(Point point) {


    }

    @Override
    public void publish() {
        this.standardSubscription();
        this.submit(this.Model);
    }

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        ArrayList result = new ArrayList();
        result.add(this.SpeedPanel);
        return result;
    }
}
