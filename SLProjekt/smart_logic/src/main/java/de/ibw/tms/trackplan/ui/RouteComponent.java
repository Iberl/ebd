package de.ibw.tms.trackplan.ui;

import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.ma.physical.ControlledTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.speed.profile.model.CartesianSpeedModel;
import de.ibw.tms.speed.profile.view.SpeedDialog;
import de.ibw.tms.trackplan.controller.RouteController;
import de.ibw.tms.train.controller.TrainController;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.tms.train.ui.SingleTrainSubPanel;
import de.ibw.util.UtilFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Flow;
/**
 * Dieses Panel stellt ein Kontextmenu dar.
 * Die Aktionen dieses Menus betreffen das Setzten der Waypoints einer MA Route
 * @deprecated
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-09
 */
public class RouteComponent extends JPanel implements Flow.Subscriber<Route> {

    /**
     * Stack zum Speichern der Reihenfolge in der Waypoints als TrackElement angelegt werden.
     * Er wird verwendet um den letzten Waypoint entfernen zu k&ouml;nnen, wenn der Benutzer dies anfordert.
     */
    //static public Stack<TrackElement> lastTrackElements = new Stack<TrackElement>();

    private String sInitialSpeedMessage = "Please Enter Initial Speed in km/h";
    private String sIntialSpeedTitle = "Set Intial Speed";
    private String sIntialSpeed = "160";
    /**
     * Kapselt das angeforderte Geschwindigkeitsprofil der gesamten Strecke.
     */
    public static CartesianSpeedModel CSM;
    /**
     * Subervised Location
     */
    public static SvL svl = null;



    /**
     * @Deprecated
     *
     * Berechnet die Streckenl&auml;nge in Metern des letzten Streckenabschnitts.
     * Wird ben&ouml;tigt um den Nutzer eine Auswahl zu geben, wo der Zug am letzten Streckenabschnitt enden soll.
     * Das ist dann das Ende der MA.
     * Die Entfernung von letzten Topologie-Knoten bis zum bestimmten Haltepunkt auf dieser letzen Kante der MA in Meter.
     * @param TrModel {@link TrainModel} - Zug Model des Zuges, dem die MA betrifft
     * @return double - Strecke in Meter
     */
    @Deprecated
    public static double calcTrackLengthUntilLastWayoint(TrainModel TrModel) {
        double dResult;
        dResult = TrModel.getdDistanceToNodeRunningTo();

        return dResult;
    }

    /**
     * Dies ist ein Knopf, der ein Kompontente des RoutenMenus darstellt.
     * Konkret wird zum Beispiel ein RoutenMenu-Popup ausgel&ouml;st.
     */
    static class RouteMenu extends JButton {
        private JPopupMenu popup;

        /**
         * Instanziiert den Knopf als ein Menu-Element
         * @param route_options - {@link String} - Beschriftung des Knopfes
         */
        public RouteMenu(String route_options) {
            super(route_options);
            popup = new JPopupMenu();
            addActionListener(new ActionHandler());

        }

        /**
         * Erstellung vor Anzeigen des Popups.
         * Das Popup hat mehrere Option zur Route. Hier wird eine Routenoption zum Ausl&ouml;se-Popup hinzugegeben.
         * @param c {@link JMenuItem} - Option (z.B. Letzten Waypoint entfernen)
         * @return
         */
        public JMenuItem add(JMenuItem c) {
            popup.add(c);
            return c;
        }

        /**
         * Entfernen eines Items des Popups bevor es angezeigt wird.
         * @param c
         */
        public void remove(Component c) {
            popup.remove(c);
        }
        private final class ActionHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                popup.show(RouteMenu.this,0,getHeight());
            }
        }
    }

    /**
     * @Waypoint
     */
    private PositioningNetElement TrackEl;
    private Flow.Subscription RouteSubscription = null;
    private RouteController RC;
    private ArrayList<JComponent> routeMenuItemList = new ArrayList<JComponent>();
    private static TrainModel StartingPointTrain = null;


    private static void generateRemoveWaypoint(RouteMenu menu, RouteComponent Component) {
        JMenuItem MenuItem = new JMenuItem("Remove Last Waypoint Set");
        MenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {






            }
        });
        menu.add(MenuItem);
    }

    private static void removeNewestWaypoint(ControlledTrackElement TE, Route routeModel, RouteComponent Component) {
        routeModel.removeWaypoint(TE);
        Component.RC.setRouteData(routeModel);

        Component.RC.publish();
    }

    private static void removeEndWaypoint(Route routeModel, RouteComponent Component) {
        routeModel.getLocation().setEnd(null);
        Component.RC.setRouteData(routeModel);

        Component.RC.publish();
    }

    private void generateRouteItems4AddWaypoint(RouteMenu menu) {

        boolean bIsEndpoint = false;
        if(this.RC.getRouteData().getLocation().getBegin() == null) {

                JMenuItem addWaypointItem = new JMenuItem("Set Train for Start-Waypoint");
                handleStartRoutingPoint(menu, addWaypointItem);


        } else {

            JMenuItem addWaypointItem = new JMenuItem("Set Trackelement for Waypoint");
            addWaypointItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Route R = RouteComponent.this.getRouteModel();


                    RouteComponent.this.RC.setRouteData(R);
                    RC.publish();
                    RouteComponent.this.closeTrackSubWindow();
                }
            });

            menu.add(addWaypointItem);
        }
        if (checkIfEndPointCanBeSet()) {
                JMenuItem addWaypointItem = new JMenuItem("Set Trackelement for End-Waypoint");


                addWaypointItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {

                                //if(!RouteComponent.START_POINT_MODE_ENABLED) {

                                Route R = RouteComponent.this.getRouteModel();
                                //Rail Rail0 = PlanData.getInstance().railList.get(0);
                                //TrackElement StartTrackElement = Rail0.getTrackReference();


                                RouteComponent.this.RC.setRouteData(R);
                                RC.publish();
                                final int[] iSpeed = new int[1];
                                try {
                                    iSpeed[0] = setInitialSpeed();


                                }catch (Exception E) {
                                    iSpeed[0] = 160;
                                }

                                CSM = new CartesianSpeedModel();
                                SSP SpeedProfile = new SSP();
                                de.ibw.tms.ma.location.SpotLocation SlEnd = R.getLocation().getEnd();
                                de.ibw.tms.ma.location.SpotLocation SlStart = R.getLocation().getBegin();


                            }
                        });




                    }
                });
                menu.add(addWaypointItem);

            }




    }

    public static void requestSVL(JFrame frame, SpotLocation slEnd) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame topFrame = frame;
                Integer iMeterOfSvl = null;
                while (iMeterOfSvl == null) {
                    String sMeterOfSvl = JOptionPane.showInputDialog(topFrame, "Please enter SVL-Meter from Endpoint selected",
                            "Define SVL in meter", JOptionPane.QUESTION_MESSAGE);
                    try {
                        iMeterOfSvl = Integer.parseInt(sMeterOfSvl);
                    } catch (NumberFormatException NFE) {
                        iMeterOfSvl = null;
                    }
                }
                int iSvlMeter = slEnd.chainage.iMeters + iMeterOfSvl;
                Chainage SvLCh = new Chainage(iSvlMeter);



            }
        });
    }

    private boolean checkIfEndPointCanBeSet() {
        boolean bIsEndpointCheck = true;
        boolean bEndPointAvail = RouteComponent.this.getRouteModel().getLocation().getEnd() == null &&
                RouteComponent.this.getRouteModel().getLocation().getBegin() != null;
        if(!bEndPointAvail) return false;


        return false;

    }



    private boolean handleRoutingOverWaypoint(ControlledTrackElement TrackEl, ControlledTrackElement lastTrackElement) {

        return false;
    }

    private int setInitialSpeed() {

        String sInputSpeed = showInitialSpeedDialog();

//If a string was returned, say so.
        try {
            if ((sInputSpeed != null) && (sInputSpeed.length() > 0)) {
                return UtilFunction.formatStringToInt(sInputSpeed);


            }
        } catch(NumberFormatException NFE) {
            return Integer.getInteger(sIntialSpeed);
        }

//If you're here, the return value was null/empty.
        return Integer.getInteger(sIntialSpeed);
    }



    private String showInitialSpeedDialog() {



        return (String) JOptionPane.showInputDialog(
                new JFrame(),
                sInitialSpeedMessage,
                sIntialSpeedTitle,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                sIntialSpeed);
    }

    private void handleStartRoutingPoint(RouteMenu menu, JMenuItem addWaypointItem) {
        addWaypointItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JPanel panel = new JPanel(new GridBagLayout());
                        Object[] trainModels = TrainModel.TrainRepo.getAll().toArray();
                        StartingPointTrain = null;


                        RC.publish();
                        closeTrackSubWindow();
                    }
            });
        };
        });
        menu.add(addWaypointItem);

    }

    public void closeTrackSubWindow() {
        Window W = SwingUtilities.getWindowAncestor(RouteComponent.this);
        W.setVisible(false);
        W.dispose();
    }







    private Route getRouteModel() {
        return this.RC.getRouteData();
    }

    /**
     * Schreibt sich ein &uuml;ber Routen&auml;nderungen informiert zu werden
     * @param subscription {@link java.util.concurrent.Flow.Subscription} - Einschreibung
     */

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.RouteSubscription = subscription;
        this.RouteSubscription.request(1);
    }

    /**
     * Routenver&auml;nderung trifft ein
     * @param item {@link Route}
     */
    @Override
    public void onNext(Route item) {
        //no duplicate update from RouteViewPort
        //this.RouteModel = item;

        this.RouteSubscription.request(1);
    }

    /**
     * Behandelt Fehler
     * @param throwable - Fehler
     */
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * Bei Routen&auml;nderungen wird neu gezeichnet.
     */

    @Override
    public void onComplete() {

        this.revalidate();
    }
}
