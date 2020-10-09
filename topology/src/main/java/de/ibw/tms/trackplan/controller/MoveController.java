package de.ibw.tms.trackplan.controller;

import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.tms.trackplan.viewmodel.ZoomModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
/**
 * Verwaltet Interaktion mit Nutzer, wenn dieser die Zeichnung verschiebt.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-11
 */
public class MoveController extends SubmissionPublisher implements IController {

    private static MoveController instance = new MoveController();

    /**
     * Singleton dieses Controllers
     * @return MoveController - Instanz des Controllers
     */
    public static MoveController getInstance() {
        return instance;
    }


    private void applyMove() {

        this.publish();
    }

    /**
     * Move wird an eingschriebene Komponenten benachrichtigt
     */

    @Override
    public void publish() {
        this.standardSubscription();
        this.submit("Apply Zoom");
    }

    /**
     * List aller Benachrichtigungs-Empf&auml;nger
     * @return List - Empf&auml;nger
     */

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        return null;
    }

    /**
     * Setzt eine Koordinatenverschiebung ab.
     * @param dx - wie weit wird X geschoben
     * @param dy - wie weit wird Y geschoben
     */
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
