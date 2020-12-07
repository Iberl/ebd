package de.ibw.smart.logic.intf;

import de.ibw.tms.trackplan.controller.Intf.IController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class SmartLogicLifecycleController extends SubmissionPublisher<String> implements IController<String> {

    private String sMsg = "Started";
    private List<Flow.Subscriber> subscriberList = new ArrayList<>();

    public void addSubscriber(Flow.Subscriber S) {
        if(!subscriberList.contains(S)) {
            subscriberList.add(S);
        }
    }


    @Override
    public void publish() {
        standardSubscription();
        this.submit(sMsg);
    }

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        return subscriberList;
    }
    public void sendMsg(String s) {
        sMsg = s;
        publish();
    }

}
