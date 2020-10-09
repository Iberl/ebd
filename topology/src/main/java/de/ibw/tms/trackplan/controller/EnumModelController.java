package de.ibw.tms.trackplan.controller;

import de.ibw.tms.trackplan.EnumModel;
import de.ibw.tms.trackplan.controller.Intf.IController;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

@Deprecated
public class EnumModelController extends SubmissionPublisher<EnumModel> implements IController<EnumModel> {

    @Override
    public void publish() {

    }

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        return null;
    }
}
