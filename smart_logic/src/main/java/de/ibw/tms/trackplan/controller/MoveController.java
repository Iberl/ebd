package de.ibw.tms.trackplan.controller;

import de.ibw.tms.MainTmsSim;
import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.tms.trackplan.viewmodel.ZoomModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class MoveController extends SubmissionPublisher implements IController {

    private static MoveController instance = new MoveController();

    public static MoveController getInstance() {
        return instance;
    }

    public void applyMove() {

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

    public void setTranslation(int dx, int dy) {
        ZoomModel Zoom = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        TranslationModel Tm = TranslationModel.getInstance();
        double dOldX = Tm.getdMoveX();
        double dOldY = Tm.getdMoveY();
        Tm.setdMoveX(dOldX + dx / Zoom.getdZoomX());
        Tm.setdMoveY(dOldY + dy / Zoom.getdZoomY());
        this.publish();

    }
}
