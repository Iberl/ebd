package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.dynamic.RouteSection;
import de.ibw.tms.ma.location.LinearLocation;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.physical.ControlledTrackElement;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.positioned.elements.LinearContiguousTrackArea;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.trackplan.controller.TrackController;
import de.ibw.tms.trackplan.ui.IWaypoint;
import de.ibw.tms.trackplan.ui.WaypointDecorator;
import de.ibw.tms.trackplan.ui.WaypointEnd;
import de.ibw.tms.trackplan.ui.WaypointStart;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Route extends LinearContiguousTrackArea implements Cloneable, Serializable {
    public static final String CLASS_IDENTIFIER = "Route";

    private List<RouteSection> sections;
    private LinearLocation location = new LinearLocation(null,null,null);

    private List<Waypoint> waypointsList = new ArrayList<Waypoint>();

    public Route(List<RouteSection> sectionList) {
        super(CLASS_IDENTIFIER);
        this.sections = sectionList;
    }

    public enum TrackElementType {
        RAIL_TYPE, CROSSOVER_TYPE
    }


    @Expose
    private List<String> elementListIds = new ArrayList<>();
    @Expose
    private List<TrackElementType> elemetTypes = new ArrayList<>();

    public List<RouteSection> getSections() {
        return sections;
    }

    public void setSections(List<RouteSection> sections) {
        this.sections = sections;
    }

    public void setLocation(LinearLocation location) {
        this.location = location;
    }

    public void setWaypointsList(List<Waypoint> waypointsList) {
        this.waypointsList = waypointsList;
    }

    public void setElementListIds(List<String> elementListIds) {
        this.elementListIds = elementListIds;
    }

    public void setElemetTypes(List<TrackElementType> elemetTypes) {
        this.elemetTypes = elemetTypes;
    }

    public List<String> getElementListIds() {
        return elementListIds;
    }

    public List<TrackElementType> getElemetTypes() {
        return elemetTypes;
    }

    public void saveWaypointsForProcessing(boolean withEndpoint) {
        elemetTypes = new ArrayList<>();
        elementListIds = new ArrayList<>();
        int iCountWaypoints = 0;
        ArrayList<Waypoint> waypoints = getAllWaypointsInOrder(withEndpoint);
        WaypointDecorator WayBeginn = (WaypointDecorator) waypoints.get(0);
        WaypointDecorator WayEnd = (WaypointDecorator) waypoints.get(waypoints.size() -1);
        PositioningNetElement TrackElementOfEnd = WayEnd.getTrackElement();
        TrackElementType TypeOfWaypoint = null;
        TypeOfWaypoint = TrackElementType.RAIL_TYPE;
        CrossoverModel EndModel = null;
        handleRailWaypoint(WayBeginn.getTrackElement());
        iCountWaypoints = waypoints.size() - 1;


        // lastElement is regular BranchingPoint
        if(!withEndpoint) iCountWaypoints++;


        handleAllCrossoverWaypoints(iCountWaypoints, waypoints);
        if(withEndpoint) handleEndWaypoint(TrackElementOfEnd);


    }

    private void handleAllCrossoverWaypoints(int iCountWaypoints, ArrayList<Waypoint> waypoints) {
        for(int i = 1; i < iCountWaypoints; i++) {
            Waypoint W = waypoints.get(i);



            PositioningNetElement CTE = W.getTrackElement();
            handleCrossoverWaypoint(CTE);
        }
    }

    public void handleEndWaypoint(TrackElement trackElementOfEnd) {
        CrossoverModel EndModel;

        if(trackElementOfEnd instanceof ControlledTrackElement) {
            EndModel = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) trackElementOfEnd);

            String sId = EndModel.getNode().TopNodeId;
            this.addWaypointIntoTransmission(TrackElementType.CROSSOVER_TYPE, sId);
        } else {
            // no Crossover so it has to be a rail
            handleRailWaypoint(trackElementOfEnd);
        }

    }

    public void handleCrossoverWaypoint(PositioningNetElement CTE) {
        String sId;
        CrossoverModel M = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) CTE);
        sId = M.getNode().TopNodeId;
        this.addWaypointIntoTransmission(TrackElementType.CROSSOVER_TYPE, sId);
    }

    public void handleRailWaypoint(PositioningNetElement TE) {


        this.addWaypointIntoTransmission(TrackElementType.RAIL_TYPE, TE.getPlanProId());
    }

    private void addWaypointIntoTransmission(TrackElementType TrackType, String sId) {
        elemetTypes.add(TrackType);
        elementListIds.add(sId);
    }

    private HashMap<TrackElement, IWaypoint> generateWaypointOnTrackMap() {
        HashMap<TrackElement, IWaypoint> resultMap = new HashMap<TrackElement, IWaypoint>();
        de.ibw.tms.ma.location.SpotLocation BeginPoint = location.getBegin();


        if(BeginPoint != null) {
            resultMap.put(BeginPoint.getTrackElement(), (IWaypoint) BeginPoint);

        }
        de.ibw.tms.ma.location.SpotLocation EndPoint =  location.getEnd();
        if(EndPoint != null) {
            resultMap.put(EndPoint.getTrackElement(), (IWaypoint) EndPoint);
        }
        List<Waypoint> points = this.waypointsList;
        for(Waypoint W : points) {
            resultMap.put(W.getTrackElement(), (IWaypoint) W);
        }
        return resultMap;
    }

    private ArrayList<Waypoint> getAllWaypointsInOrder(boolean withEndpoint) {
        ArrayList<Waypoint> resultList = new ArrayList<>();
        de.ibw.tms.ma.location.SpotLocation BeginPoint = location.getBegin();
        SpotLocation EndPoint = location.getEnd();
        WaypointDecorator BeginWayPoint =
                new WaypointDecorator(BeginPoint.getTrackElement(), new TrackElementStatus(), -1, -1);
        WaypointDecorator EndWayPoint = null;
        if (withEndpoint) {
            EndWayPoint =
                new WaypointDecorator(EndPoint.getTrackElement(), new TrackElementStatus(), -1, -1);
        }
        resultList.add(BeginWayPoint);
        resultList.addAll(this.waypointsList);

        if(withEndpoint) resultList.add(EndWayPoint);
        return resultList;

    }

    public IWaypoint retrieveWaypointOnTrack(TrackElement Element) {
        return (IWaypoint) generateWaypointOnTrackMap().get(Element);
    }


    public void setStartSpot(TrackElement Element, int iMeters) {
        setSpot(Element, iMeters, true);


    }

    private void setSpot(TrackElement Element, int iMeters, boolean isBegin) {
        System.out.println("not implemented");

        /*int iBeginMeter = Element.getChainageBeginn().getiMeters();
        int iEndMeter = Element.getChainageEnd().getiMeters();
        boolean isValid = (iBeginMeter <= iMeters) && (iMeters <= iEndMeter);
        */
        boolean isValid = true;
        if(isValid) {
            int x = TrackController.ClickPoint.x;
            int y = TrackController.ClickPoint.y;
           // if(RouteComponent.FocusedPoint == null) {
                if(isBegin){
                    Chainage C = new Chainage(iMeters);
                    try {
                        location.setBegin(new WaypointStart(C, Element, null
                                , x,y));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Chainage C = new Chainage(iMeters);
                    try {
                        location.setEnd(new WaypointEnd(C, Element, null
                                , x,y));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
           /* } else {
                if (isBegin) {
                    location.setBegin(new WaypointStart(new Chainage(iMeters), Element, null
                            , RouteComponent.FocusedPoint.x, RouteComponent.FocusedPoint.y));
                    System.out.println("StartPoint set");
                } else {
                    location.setEnd(new WaypointEnd(new Chainage(iMeters), Element, null
                            , RouteComponent.FocusedPoint.x, RouteComponent.FocusedPoint.y));
                }
            }*/
        } else {
            throw new IndexOutOfBoundsException("Spot not in Tracks Chainage");
        }
    }

    public void addWaypoint(PositioningNetElement TE, TrackElementStatus Status) {
        Waypoint W = new Waypoint(TE, Status);
        int x = TrackController.ClickPoint.x;
        int y = TrackController.ClickPoint.y;

        Waypoint WayDecorated = new WaypointDecorator(TE, Status, x, y);
        if(waypointsList.contains(WayDecorated)) {
            throw new InvalidParameterException("Waypoint already added");
        } else {
            waypointsList.add(WayDecorated);
        }

    }
    public void removeWaypoint(ControlledTrackElement TE) {
        for(Waypoint W : waypointsList)  {
            if(W.getTrackElement() == TE) {
                waypointsList.remove(W);
                return;


            }
        }
        throw new InvalidParameterException("Waypoint cannot be removed");

    }
    public void addWaypoint(Waypoint W) {

        if(waypointsList.contains(W)) {
            throw new InvalidParameterException("Waypoint already added");
        } else {
            waypointsList.add(W);
        }

    }
    public void removeWaypoint(Waypoint W) {
        if (!waypointsList.contains(W)) {
            throw new InvalidParameterException("Waypoint cannot be removed");
        } else{
            waypointsList.remove(W);
        }
    }

    public void setEndSpot(TrackElement Element, int iMeters) {
        setSpot(Element, iMeters, false);

    }

    public LinearLocation getLocation() {
        return location;
    }

    public List<Waypoint> getWaypointsList() {
        return waypointsList;
    }
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}
