package de.ibw.tms.trackplan.controller;

import de.ibw.tms.plan.elements.BranchingSwitch;
import de.ibw.tms.plan.elements.model.CrossoverEnumModel;
import de.ibw.tms.plan.elements.model.CrossoverMainModel;
import de.ibw.tms.trackplan.controller.Intf.IController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
/**
 * Verwaltet den Status einer Weiche
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-11
 */
public class CrossoverController extends SubmissionPublisher<CrossoverMainModel> implements IController<CrossoverMainModel> {

    private CrossoverMainModel Model;
    private CrossoverEnumModel CrossoverStatus;
    private BranchingSwitch C;

    private ArrayList<Flow.Subscriber> subscribers;

    /**
     * Dieser Konstruktor hat ein Weiche als Model, den Status und die geographische Weiche
     * @param Model {@link de.ibw.tms.plan.elements.CrossoverModel} - Modell der Weiche
     * @param CrossStatModel - {@link CrossoverEnumModel} - Status der Weiche
     * @param C {@link BranchingSwitch} - Position der Weiche
     */
    public CrossoverController(CrossoverMainModel Model, CrossoverEnumModel CrossStatModel, BranchingSwitch C) {
        this.subscribers = new ArrayList<Flow.Subscriber>();
        this.Model = Model;
        this.CrossoverStatus = CrossStatModel;
        this.C = C;
        this.subscribers.add(C);

    }

    /**
     * Schreibt sich eine Komponente ein, werden Information bei Statuswechsel gesendet.
     * Das ist die Methode zum einschreiben.
     * @param toSubscribe - Komponente die sich einschreibt
     */

    @Override
    public void addSubscriber(Flow.Subscriber toSubscribe) {
        if(!this.subscribers.contains(toSubscribe)) {
            this.subscribers.add((toSubscribe));
        }
    }

    /**
     * gibt alle eingeschriebenen Komponenten wider
     * @return List - Komponentenliste
     */
    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        return this.subscribers;
    }

    /**
     * Benachrichtigt alle eingeschriebenen Komponenten
     */
    @Override
    public void publish() {
        try {
            this.standardSubscription();
            Model.CrossoverStatus = (BranchingSwitch.CrossoverStatus) this.CrossoverStatus.getSingleSelection().Item;
            this.submit(Model);

        } catch(IllegalStateException Ex) {
            Ex.printStackTrace();
        }





    }
}
