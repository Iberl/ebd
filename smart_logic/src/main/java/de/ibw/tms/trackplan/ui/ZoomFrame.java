package de.ibw.tms.trackplan.ui;

import de.ibw.tms.train.model.TrainModel;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.concurrent.Flow;

public class ZoomFrame extends JFrame {
    ZoomPanel zoomPanel;
    private ZoomFrame() {
        super("Zooming");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        zoomPanel = new ZoomPanel(this);
        this.getContentPane().add(zoomPanel);
        this.pack();
        this.setVisible(true);
    }

    public synchronized void setTrainModels(Collection<TrainModel> models) {
        getZoomFrame().zoomPanel.setTrainBoxEntries(models);
        this.repaint();
    }

    public static ZoomFrame zoomInstance = null;
    public static ZoomFrame getZoomFrame() {
        if(zoomInstance == null) {
            zoomInstance = new ZoomFrame();
        }
        return zoomInstance;
    }

    private static Flow.Subscriber TrainPositionSubscriber = null;
    private static Flow.Subscription PositionSubscription = null;

    public static Flow.Subscriber getPositionSubscriber() {
        if(TrainPositionSubscriber == null) {
            TrainPositionSubscriber = new Flow.Subscriber() {
                @Override
                public void onSubscribe(Flow.Subscription subscription) {
                    PositionSubscription = subscription;
                    PositionSubscription.request(1);
                }

                @Override
                public void onNext(Object item) {
                    Collection<TrainModel> models = TrainModel.TrainRepo.getAll();
                    getZoomFrame().setTrainModels(models);
                    getZoomFrame().repaint();
                    PositionSubscription.request(1);
                }
                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public void onComplete() {

                }
            };
        }
        return TrainPositionSubscriber;
    }




}
