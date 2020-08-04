package de.ibw.tms.trackplan.controller;

import de.ibw.tms.MainTmsSim;
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

public class ZoomController extends SubmissionPublisher implements IController {

    private static ZoomController instance = new ZoomController();

    public static ZoomController getInstance() {
        return instance;
    }

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


    public void zoomIn() {
        ZoomModel zoomModel = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        double x = zoomModel.getdZoomX() * 2.0d;
        double y = zoomModel.getdZoomY() * 2.0d;
        zoomModel.setdZoomX(x);
        zoomModel.setdZoomY(y);
        this.publish();
    }

    public void zoomOut() {
        ZoomModel zoomModel = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        double x = zoomModel.getdZoomX() / 2.0d;
        double y = zoomModel.getdZoomY() / 2.0d;
        zoomModel.setdZoomX(x);
        zoomModel.setdZoomY(y);
        this.publish();
    }

    public void focusTrain(TrainModel trainModel) {
        TranslationModel Location = TranslationModel.getInstance();
        Line2D.Double TrainGeo = trainModel.getTrainUiLine();
        Location.setdMoveX(TrainGeo.x1);
        Location.setdMoveY(TrainGeo.y1);
        this.publish();
    }

    public void applyZoom() {

        this.publish();
    }

    @Override
    public void publish() {
        this.standardSubscription();
        this.submit("Apply Zoom");
    }

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        ArrayList<JPanel> panels = MainTmsSim.trackPanelRepository;
        ArrayList<Flow.Subscriber> returnList = new ArrayList<>();
        for(JPanel P: panels) {
            if(P != null) {
                if(P.isVisible()) {
                    returnList.add((Flow.Subscriber) P);
                }
            }
        }
        return returnList;
    }
}
