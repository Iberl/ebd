package de.ibw.tms.trackplan.ui;

import de.ibw.tms.train.model.TrainModel;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.concurrent.Flow;
/**
 * Fenster zum Einstellen des Zoom-Faktors
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-12
 */
public class ZoomFrame extends JFrame {
    private ZoomPanel zoomPanel;


    private ZoomFrame() {
        super("Zooming");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        zoomPanel = new ZoomPanel(this);
        this.getContentPane().add(zoomPanel);
        this.pack();
        this.setVisible(true);
    }

    private synchronized void setTrainModels(Collection<TrainModel> models) {
        getZoomFrame().zoomPanel.setTrainBoxEntries(models);
        this.repaint();
    }

    private static ZoomFrame zoomInstance = null;

    /**
     * Singelton - Gibt Zoom Fenster wider
     * @return ZoomFrame - Das Zoom-Fenster
     */
    public static ZoomFrame getZoomFrame() {
        if(zoomInstance == null) {
            zoomInstance = new ZoomFrame();
        }
        return zoomInstance;
    }

    private static Flow.Subscriber TrainPositionSubscriber = null;
    private static Flow.Subscription PositionSubscription = null;

    /**
     * Horcht auf Positionswechsel von Z&uuml;gen, damit das Auswahlfeld der Zugreferenz aktuell bleibt.
     * @return Subscriber - ein Listener der Positiosnswechsel
     */
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
