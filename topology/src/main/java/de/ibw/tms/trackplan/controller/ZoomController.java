package de.ibw.tms.trackplan.controller;

import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.tms.trackplan.viewmodel.ZoomModel;
import de.ibw.tms.train.model.TrainModel;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
/**
 * Verwaltet das Zoomen in Karten
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-11
 */
public class ZoomController extends SubmissionPublisher implements IController {

    private static ZoomController instance = new ZoomController();

    /**
     * Singelton holt den Controller
     * @return ZoomController
     */
    public static ZoomController getInstance() {
        return instance;
    }

    /**
     * Setzt den Zoom in x Richtung auf xZoom
     * @param sXZoom {@link String} gesetzter Wert.
     */
    public void changeX(String sXZoom) {
        ZoomModel zoomModel = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        String toParse = sXZoom.replace(",", ".");
        try {

            double x = Double.parseDouble(toParse);
            zoomModel.setdZoomX(x);

        } catch(Exception E) {
            zoomModel.setsInfo("Bitte geben Sie für X eine Positive Zahl (0.5) als Zoom Faktor ein.");
        }
    }

    /**
     * Setzt Wert des Zooms in y-Richtung
     * @param sYZoom - Endwert des y-Zooms
     */
    public void changeY(String sYZoom) {
        ZoomModel zoomModel = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        String toParse = sYZoom.replace(",", ".");
        try {

            double y = Double.parseDouble(toParse);
            zoomModel.setdZoomY(y);

        } catch(Exception E) {
            zoomModel.setsInfo("Bitte geben Sie für Y eine Positive Zahl (0.5) als Zoom Faktor ein.");
        }
    }

    /**
     * Verdoppeln des Zoom-Faktors
     */
    public void zoomIn() {
        ZoomModel zoomModel = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        double x = zoomModel.getdZoomX() * 2.0d;
        double y = zoomModel.getdZoomY() * 2.0d;
        zoomModel.setdZoomX(x);
        zoomModel.setdZoomY(y);
        this.publish();
    }

    /**
     * Halbieren des Zoom-Faktors
     */
    public void zoomOut() {
        ZoomModel zoomModel = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        double x = zoomModel.getdZoomX() / 2.0d;
        double y = zoomModel.getdZoomY() / 2.0d;
        zoomModel.setdZoomX(x);
        zoomModel.setdZoomY(y);
        this.publish();
    }

    /**
     * Setzt einen Zug in Fokus
     * @param trainModel {@link TrainModel} - Zug zum Fokus
     */
    public void focusTrain(TrainModel trainModel) {
        TranslationModel Location = TranslationModel.getInstance();
        Line2D.Double TrainGeo = trainModel.getTrainUiLine();
        Location.setdMoveX(TrainGeo.x1);
        Location.setdMoveY(TrainGeo.y1);
        this.publish();
    }

    /**
     * Wendet Zoom an, der in der Gui eingestellt wurde.
     */
    public void applyZoom() {

        this.publish();
    }

    /**
     * Benachrichtig alle registrierten Komponenten, das es einen neuen Zoom Faktor gibt
     */

    @Override
    public void publish() {
        this.standardSubscription();
        this.submit("Apply Zoom");
    }

    /**
     * Liste aller Zoom-Nachrichten - Empf&auml;nger
     * @return
     */

    @Override
    public List<Flow.Subscriber> getSubscriberList() {

        ArrayList<Flow.Subscriber> returnList = new ArrayList<>();

        return returnList;
    }
}
