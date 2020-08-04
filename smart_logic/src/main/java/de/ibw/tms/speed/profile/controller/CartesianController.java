package de.ibw.tms.speed.profile.controller;

import de.ibw.tms.ma.SSP;
import de.ibw.tms.trackplan.controller.Intf.IController;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class CartesianController extends SubmissionPublisher<SSP> implements IController<SSP> {
    @Override
    public void publish() {
        this.standardSubscription();
    }

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        return null;
    }




}
