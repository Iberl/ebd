package de.ibw.tms.trackplan.controller;

import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.plan.elements.model.CrossoverEnumModel;
import de.ibw.tms.plan.elements.model.CrossoverMainModel;
import de.ibw.tms.trackplan.controller.Intf.IController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class CrossoverController extends SubmissionPublisher<CrossoverMainModel> implements IController<CrossoverMainModel> {

    private CrossoverMainModel Model;
    private CrossoverEnumModel CrossoverStatus;
    private BranchingSwitch C;

    private ArrayList<Flow.Subscriber> subscribers;


    public CrossoverController(CrossoverMainModel Model, CrossoverEnumModel CrossStatModel, BranchingSwitch C) {
        this.subscribers = new ArrayList<Flow.Subscriber>();
        this.Model = Model;
        this.CrossoverStatus = CrossStatModel;
        this.C = C;
        this.subscribers.add(C);

    }

    @Override
    public void addSubscriber(Flow.Subscriber toSubscribe) {
        if(!this.subscribers.contains(toSubscribe)) {
            this.subscribers.add((toSubscribe));
        }
    }

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        return this.subscribers;
    }

    @Override
    public void publish() {
        try {
            this.standardSubscription();
            Model.CrossoverStatus = (BranchingSwitch.CrossoverStatus) this.CrossoverStatus.getSingleSelection().Item;
            this.submit(Model);

        } catch(IllegalStateException Ex) {
            Ex.printStackTrace();
        }

            TrackController.getInstance(null).publish();


    }
}
