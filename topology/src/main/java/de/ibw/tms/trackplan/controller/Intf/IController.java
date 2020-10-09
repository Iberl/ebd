package de.ibw.tms.trackplan.controller.Intf;

import java.util.List;
import java.util.concurrent.Flow;

public interface IController<T> extends Flow.Publisher<T> {
    public void publish();
    default void addSubscriber(Flow.Subscriber toSubscribe) {
        List<Flow.Subscriber<? super T>> subscribers = this.getSubscribers();
        if(!subscribers.contains(toSubscribe)) {
            subscribers.add((toSubscribe));
        }
    }
    List<Flow.Subscriber> getSubscriberList();

    public List<Flow.Subscriber<? super T>> getSubscribers();

    default void standardSubscription() {
        List targetList = (List) this.getSubscribers();
        List<Flow.Subscriber> shallList = (List<Flow.Subscriber>) this.getSubscriberList();

        for(Flow.Subscriber ShallSubscriber : shallList)
            if(!targetList.contains(ShallSubscriber)) {
                this.subscribe(ShallSubscriber);
            }
    }

}
