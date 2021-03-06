package de.ibw.tms.gradient.profile.controller;

import de.ibw.tms.gradient.profile.GradientTrailModel;
import de.ibw.tms.gradient.profile.ui.GradientFrame;
import de.ibw.tms.ma.GradientProfile;
import de.ibw.tms.trackplan.controller.Intf.IController;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * Noch nicht implementiert
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class GradientController extends SubmissionPublisher<GradientProfile> implements IController<GradientProfile> {

    private static GradientController GC;

    public static GradientController getGC() {
        if(GC == null) {
            GC = new GradientController();
        }
        return GC;
    }


    GradientFrame Frame;

    public void selectGradientModel(GradientTrailModel GradientModel) {




        Frame.setCurrentTrailModel(GradientModel);
        Frame.revalidate();

        //Frame.windowViews();








    }

    @Override
    public void publish() {
        try {
            this.standardSubscription();

            this.submit(null);

        } catch(IllegalStateException Ex) {
            Ex.printStackTrace();
        }

    }

    public void showGradientSettings() {
        Frame.showFrame();

    }

    public GradientController() {

        if(Frame == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Frame = new GradientFrame("Set Gradient Profile");
                }
            });


        }

    }

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        return null;
    }


}
