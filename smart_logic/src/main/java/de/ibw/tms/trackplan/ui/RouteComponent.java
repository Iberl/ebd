package de.ibw.tms.trackplan.ui;

import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.physical.ControlledTrackElement;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.physical.Trail;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.speed.profile.model.CartesianSpeedModel;
import de.ibw.tms.speed.profile.view.SpeedDialog;
import de.ibw.tms.trackplan.controller.RouteController;
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

public class RouteComponent extends JPanel implements Flow.Subscriber<Route> {
    static public Point FocusedPoint = null;
    static public Stack<TrackElement> lastTrackElements = new Stack<TrackElement>();

    static public boolean START_POINT_MODE_ENABLED = true;
    private String sInitialSpeedMessage = "Please Enter Initial Speed in km/h";
    private String sIntialSpeedTitle = "Set Intial Speed";
    private String sIntialSpeed = "160";
    public static CartesianSpeedModel CSM;
    public static SvL svl = null;
    static SpeedDialog speedDialog;


    private static TopologyGraph.Edge retrieveNextEdge(TrackElement LastTrackElement, TrackElement TrackEl) {

        CrossoverModel RootModel = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) LastTrackElement);
        CrossoverModel TargetModel = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) TrackEl);
        TopologyGraph.Node RootNode = RootModel.getNode();
        TopologyGraph.Node TargetNode = TargetModel.getNode();
        ArrayList<TopologyGraph.Edge> edges = new ArrayList<>();
        edges.addAll(RootNode.inEdges);
        edges.addAll(RootNode.outEdges);
        for(TopologyGraph.Edge E: edges) {
            if(E.A == TargetNode || E.B == TargetNode) {
                return E;
            }
        }
        return null;
    }

    public static double calcTrackLengthUntilLastWayoint(TrainModel TrModel) {
        double dResult = 0d;
        dResult = TrModel.getdDistanceToNodeRunningTo();
        for(int i = 2; i < lastTrackElements.size(); i++) {
            ControlledTrackElement LastTrackElement = (ControlledTrackElement) lastTrackElements.get(i - 1);
            ControlledTrackElement TrackEl = (ControlledTrackElement) lastTrackElements.get(i);
            TopologyGraph.Edge E = retrieveNextEdge(LastTrackElement,TrackEl);
            dResult += E.dTopLength;
        }
        return dResult;
    }


    static class RouteMenu extends JButton {
        private JPopupMenu popup;
        public Point p;
        public RouteMenu(String route_options, Point p) {
            super(route_options);
            popup = new JPopupMenu();
            addActionListener(new ActionHandler());
            this.p = p;
        }



        public JMenuItem add(JMenuItem c) {
            popup.add(c);
            return(c);
        }
        public void remove(Component c) {
            popup.remove(c);
        }
        private final class ActionHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                popup.show(RouteMenu.this,0,getHeight());
            }
        }
    }

    private TrackElement TrackEl;
    private Flow.Subscription RouteSubscription = null;
    private RouteController RC;
    private ArrayList<JComponent> routeMenuItemList = new ArrayList<JComponent>();
    private static TrainModel StartingPointTrain = null;

    public static TrainModel getStartingPointTrain() {
        return StartingPointTrain;
    }

    private static void generateRemoveWaypoint(RouteMenu menu, RouteComponent Component) {
        JMenuItem MenuItem = new JMenuItem("Remove Last Waypoint Set");
        MenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TrackElement TE = RouteComponent.lastTrackElements.peek();
                Route RouteModel = Component.RC.getRouteData();

                if(RouteModel.getLocation().getEnd() != null) {
                    removeEndWaypoint(RouteModel, Component);
                    return;
                }
                /*if(RouteModel.getLocation().getBegin() != null) {
                    if (RouteModel.getLocation().getBegin().getTrackElement() == TE) {
                        RouteModel.getLocation().setBegin(null);
                        Component.RC.setRouteData(RouteModel);
                        RouteComponent.lastTrackElements.pop();
                        Component.RC.publish();
                        return;
                    }
                }*/
                if(TE instanceof ControlledTrackElement) {
                    removeNewestWaypoint((ControlledTrackElement) TE, RouteModel, Component);
                    return;
                }
                if(RouteComponent.lastTrackElements.size() == 1) {
                    RouteModel.getLocation().setBegin(null);
                    Component.RC.setRouteData(RouteModel);
                    RouteComponent.lastTrackElements.pop();
                    Component.RC.publish();

                }






            }
        });
        menu.add(MenuItem);
    }

    private static void removeNewestWaypoint(ControlledTrackElement TE, Route routeModel, RouteComponent Component) {
        routeModel.removeWaypoint(TE);
        Component.RC.setRouteData(routeModel);
        RouteComponent.lastTrackElements.pop();
        Component.RC.publish();
    }

    private static void removeEndWaypoint(Route routeModel, RouteComponent Component) {
        routeModel.getLocation().setEnd(null);
        Component.RC.setRouteData(routeModel);
        RouteComponent.lastTrackElements.pop();
        Component.RC.publish();
    }

    public void generateRouteItems4AddWaypoint(RouteMenu menu) {
        FocusedPoint = menu.p;
        boolean bIsEndpoint = false;
        if(this.RC.getRouteData().getLocation().getBegin() == null) {
            if(RouteComponent.START_POINT_MODE_ENABLED) {
                JMenuItem addWaypointItem = new JMenuItem("Set Train for Start-Waypoint");
                handleStartRoutingPoint(menu, addWaypointItem);
            }

        } else if(checkIfPointIsAccessible(TrackEl, bIsEndpoint)) {

            JMenuItem addWaypointItem = new JMenuItem("Set Trackelement for Waypoint");
            addWaypointItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Route R = RouteComponent.this.getRouteModel();
                    R.addWaypoint((ControlledTrackElement) TrackEl, new TrackElementStatus());
                    RouteComponent.lastTrackElements.push(TrackEl);
                    RouteComponent.this.RC.setRouteData(R);
                    RC.publish();
                }
            });

            menu.add(addWaypointItem);
        }
        if (checkIfEndPointCanBeSet()) {
                JMenuItem addWaypointItem = new JMenuItem("Set Trackelement for End-Waypoint");


                addWaypointItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (TrackEl instanceof Trail) {

                            new LinearLocationWayointSetWindow(TrackEl,
                                    new JFrame(), new Point(150, 200), RC, StartingPointTrain);


                        } else if (TrackEl.getChainageBeginn().getiMeters() == TrackEl.getChainageEnd().getiMeters()) {
                            double dEnd = 0d;
                            Route R = RouteComponent.this.getRouteModel();
                            RouteComponent.lastTrackElements.push(TrackEl);

                            dEnd = RouteComponent.calcTrackLengthUntilLastWayoint(StartingPointTrain);

                            R.setEndSpot(RouteComponent.this.TrackEl, (int) dEnd);
                            RouteComponent.this.RC.setRouteData(R);
                            RC.publish();
                        } else {
                            new LinearLocationWayointSetWindow(TrackEl,
                                    new JFrame(), new Point(150, 200), RC, StartingPointTrain);
                        }
                        //if(!RouteComponent.START_POINT_MODE_ENABLED) {

                        Route R = RouteComponent.this.getRouteModel();
                        //Rail Rail0 = PlanData.getInstance().railList.get(0);
                        //TrackElement StartTrackElement = Rail0.getTrackReference();


                        RouteComponent.this.RC.setRouteData(R);
                        RC.publish();
                        int iSpeed;
                        try {
                            iSpeed = setInitialSpeed();
                        }catch (Exception E) {
                            iSpeed = 160;
                        }

                        CSM = new CartesianSpeedModel();
                        SSP SpeedProfile = new SSP();
                        SpotLocation SlEnd = R.getLocation().getEnd();
                        SpotLocation SlStart = R.getLocation().getBegin();
                        SpeedChange SpeedBegin = new SpeedChange(new Chainage(0), SlStart.getTrackElement(), new SectionOfLine());
                        SpeedChange SpeedEnd = new SpeedChange(SlEnd.getChainage(), SlEnd.getTrackElement(), new SectionOfLine());
                        SpeedSegment SpeedSeg = new SpeedSegment(SpeedBegin, SpeedEnd, ApplicationDirection.BOTH);
                        ETCS_SPEED etcsSpeed = new ETCS_SPEED();
                        etcsSpeed.bSpeed = (byte) Math.floor(iSpeed / 5.0f);
                        SpeedSeg.setV_STATIC(etcsSpeed);
                        ArrayList<SpeedSegment> segmentList = new ArrayList<SpeedSegment>();
                        segmentList.add(SpeedSeg);
                        SpeedProfile.setSpeedSegments(segmentList);
                        CSM.setStaticSpeedProfile(SpeedProfile);
                        //SpeedDialog SD = new SpeedDialog(CSM, MaCreatingFrame.CurrentMaCreatingFrame, RouteComponent.this.RC.getRouteData());
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                SpeedDialog.displaySpeedDialog(CSM, RouteComponent.this.RC.getRouteData());
                            }
                        });
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(RouteComponent.this);
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
                                int iSvlMeter = SlEnd.chainage.iMeters + iMeterOfSvl;
                                Chainage SvLCh = new Chainage(iSvlMeter);


                                RouteComponent.svl = new SvL(SvLCh, SlEnd.getTrackElement(), new SectionOfLine());
                            }
                        });




                    }
                });
                menu.add(addWaypointItem);

            }




    }

    public boolean checkIfEndPointCanBeSet() {
        boolean bIsEndpointCheck = true;
        boolean bEndPointAvail = RouteComponent.this.getRouteModel().getLocation().getEnd() == null &&
                RouteComponent.this.getRouteModel().getLocation().getBegin() != null;
        if(!bEndPointAvail) return false;


        return checkIfPointIsAccessible(TrackEl, bIsEndpointCheck);

    }



    public boolean checkIfPointIsAccessible(TrackElement TrackEl, boolean isEndpointCheck) {

        TrackElement LastTrackElement = null;
        if(RouteComponent.lastTrackElements.size() > 0) {
            LastTrackElement = RouteComponent.lastTrackElements.peek();
        }
        // checking Branchingpoints
        if(TrackEl instanceof ControlledTrackElement) {

            if(LastTrackElement == null || LastTrackElement == RouteComponent.lastTrackElements.get(0)) {

                TopologyGraph.Node TrainAheadNode = StartingPointTrain.getNodeTrainRunningTo();
                CrossoverModel TargetCrossoverModel = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) TrackEl);
                TopologyGraph.Node TargetNode = TargetCrossoverModel.getNode();

                /* rubbish N to 1 relation is not overwriten repository
                CrossoverModel CrossoverOfAheadNode = CrossoverModel.CrossoverRepo.getModel(TrainAheadNode);
                // no waypoint selected
                if(CrossoverOfAheadNode == null) {
                    return false;
                }
           */
                if(TrainAheadNode.TopNodeId.equals(TargetNode.TopNodeId)) return true;
                else return false;
            } else {
                if(LastTrackElement == null) {
                    // no waypoint checked so train must stand on trail
                    TopologyGraph.Edge CurrentEdge = StartingPointTrain.getEdgeTrainStandsOn();
                    return TrackEl == CurrentEdge.getRail().getTrailModel();
                }
                return handleRoutingOverWaypoint((ControlledTrackElement) TrackEl, (ControlledTrackElement) LastTrackElement);

            }
        } else {
            if(!isEndpointCheck) return false;
            if(LastTrackElement == null || LastTrackElement == RouteComponent.lastTrackElements.get(0)) {
                // Waypoint on trains current trail is true when no other waypoint is set
                // but it must then stand on this trail
                return StartingPointTrain.getEdgeTrainStandsOn().getRail() .getTrailModel()== TrackEl;
            } else {
                // is Endpoint routeable decides smart logic so the tms accept then any End Waypoint
                return true;
            }

        }
    }

    public boolean handleRoutingOverWaypoint(ControlledTrackElement TrackEl, ControlledTrackElement lastTrackElement) {
        CrossoverModel RootModel = CrossoverModel.BranchToCrossoverModelRepo.getModel(lastTrackElement);
        CrossoverModel TargetModel = CrossoverModel.BranchToCrossoverModelRepo.getModel(TrackEl);
        TopologyGraph.Node RootNode = RootModel.getNode();
        TopologyGraph.Node TargetNode = TargetModel.getNode();
        ArrayList<TopologyGraph.Edge> edges = new ArrayList<>();
        edges.addAll(RootNode.inEdges);
        edges.addAll(RootNode.outEdges);
        for(TopologyGraph.Edge E: edges) {
            if(E.A == TargetNode || E.B == TargetNode) {
                return true;
            }
        }
        return false;
    }

    protected int setInitialSpeed() {
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

    protected void handleStartRoutingPoint(RouteMenu menu, JMenuItem addWaypointItem) {
        addWaypointItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridBagLayout());
                Object[] trainModels = TrainModel.TrainRepo.getAll().toArray();
                StartingPointTrain = null;
                TrackElement TrackTrainStandsOn = null;
                if(trainModels.length == 0) {
                    StartingPointTrain = TrainModel.getDefaultModel();
                } else if(trainModels.length == 1) {
                    StartingPointTrain = (TrainModel) trainModels[0];
                } else {

                    StartingPointTrain = (TrainModel) JOptionPane.showInputDialog(new JFrame(),
                            "Please select Train", "Train Selection", JOptionPane.INFORMATION_MESSAGE,
                            null, trainModels, trainModels[0]);
                    if (StartingPointTrain == null) {
                        System.out.println("TMS: No Train Model available");
                        return;
                    } else {
                        SingleTrainSubPanel.TrainPanel.setTrain(StartingPointTrain);
                    }
                }
                try {
                    TopologyGraph.Edge ElementOnTrain = StartingPointTrain.getEdgeTrainStandsOn();
                    Rail RailTrainStandsOn = ElementOnTrain.getRail();
                    TrackTrainStandsOn = RailTrainStandsOn.getTrackReference();
                } catch(Exception E) {
                    System.out.println("Track Element of Train cannot be calculated.");
                    E.printStackTrace();
                }


                    Route R = RouteComponent.this.RC.getRouteData();
                    R.setStartSpot(TrackTrainStandsOn, 0);
                    RouteComponent.lastTrackElements = new Stack<>();
                    RouteComponent.lastTrackElements.push(TrackTrainStandsOn);
                    RouteComponent.this.RC.setRouteData(R);
                    RC.publish();

            }
        });
        menu.add(addWaypointItem);
    }

    public RouteComponent(TrackElement TrackEl, RouteController RC, Point p) {
        super();
        setLayout(new FlowLayout());
        RouteMenu menu = new RouteMenu("Route Options",p);
        initComponent(TrackEl, RC, menu);


    }

    private void initComponent(TrackElement TrackEl, RouteController RC, RouteMenu menu) {

        this.TrackEl = TrackEl;
        this.RC = RC;
        JPanel listPane = new JPanel();
        BoxLayout WindowLayout = new BoxLayout(listPane, BoxLayout.Y_AXIS);
        listPane.setLayout(WindowLayout);
        IWaypoint Waypoint = this.RC.getRouteData().retrieveWaypointOnTrack(TrackEl);
        if(Waypoint == null) {
            this.generateRouteItems4AddWaypoint(menu);
        } else {
            if(RC.getRouteData().getLocation().getBegin() != null) {
                this.generateRouteItems4AddWaypoint(menu);
            }
            generateRemoveWaypoint(menu,this);
        }
        this.add(menu);
    }

    public RouteComponent(String desc, TrackElement trackReference, RouteController routeCntrl, Point p) {
        RouteMenu menu = new RouteMenu(desc,p);
        initComponent(trackReference, routeCntrl, menu);
    }

    public Route getRouteModel() {
        return this.RC.getRouteData();
    }

    public RouteController getRC() {
        return RC;
    }



    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.RouteSubscription = subscription;
        this.RouteSubscription.request(1);
    }

    @Override
    public void onNext(Route item) {
        //no duplicate update from RouteViewPort
        //this.RouteModel = item;

        this.RouteSubscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {

        this.revalidate();
    }
}
