package de.ibw.tms.trackplan.ui;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.dynamic.RouteSection;
import de.ibw.tms.ma.location.LinearLocation;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.physical.ControlledTrackElement;
import de.ibw.tms.ma.physical.MovableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.positioned.elements.LinearContiguousTrackArea;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.tms.trackplan.ui.IWaypoint;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ThreadedRepo;
import de.ibw.util.intf.IToLogIntf;
import org.apache.commons.lang3.NotImplementedException;

import javax.persistence.Entity;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Eine Route auf einen Streckenabschnitt
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1
 * @since 2021-06-11
 *
 */

public class Route extends LinearContiguousTrackArea implements Cloneable, Serializable {
    public static final String CLASS_IDENTIFIER = "Route";

    /**
     * Dieses Repository Speichert eine Route unter einem Nutzerdefinierten Namen
     */
    public static DefaultRepo<String, Route> routeRepository = new DefaultRepo<>();



    private List<RouteSection> sections;
    private LinearLocation location = new LinearLocation(null,null,null);

    private List<Waypoint> waypointsList = new ArrayList<Waypoint>();

    @Override
    public String toString() {
        return "Route{" +
                "routeSectionIDs=" + routeSectionIDs +
                ", intrinsicCoordOfTargetTrackEdge=" + intrinsicCoordOfTargetTrackEdge +
                '}';
    }

    @Override
    public String log() {
        return "Route{" +
                "routeSectionIDs=" + routeSectionIDs +
                ", intrinsicCoordOfTargetTrackEdge=" + intrinsicCoordOfTargetTrackEdge +
                super.log() +
                '}';
    }

    public Route(List<RouteSection> sectionList) {
        super(CLASS_IDENTIFIER);
        this.sections = sectionList;
    }

    public enum TrackElementType {
        RAIL_TYPE, CROSSOVER_TYPE
    }


    @Expose
    private List<String> routeSectionIDs = new ArrayList<>();

    @Expose
    private double intrinsicCoordOfTargetTrackEdge;

    public double getIntrinsicCoordOfTargetTrackEdge() {
        return intrinsicCoordOfTargetTrackEdge;
    }

    public void setIntrinsicCoordOfTargetTrackEdge(double intrinsicCoordOfTargetTrackEdge) {
        this.intrinsicCoordOfTargetTrackEdge = intrinsicCoordOfTargetTrackEdge;
    }


    public TopologyGraph.Edge getLastEdge() {
        if(routeSectionIDs == null) return null;
        String sid = routeSectionIDs.get(routeSectionIDs.size() -1);
        if(sid == null) return null;
        return PlanData.EdgeIdLookupRepo.getModel(sid);
    }


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
        this.routeSectionIDs = elementListIds;
    }



    public List<String> getElementListIds() {
        return routeSectionIDs;
    }





    /**
     * @deprecated
     * @param trackElementOfEnd
     */
    public void handleEndWaypoint(MovableTrackElement trackElementOfEnd) {
        throw new NotImplementedException("deprecated");
        /*
        CrossoverModel EndModel;

        if(trackElementOfEnd instanceof ControlledTrackElement) {
            EndModel = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) trackElementOfEnd);
            trackElementOfEnd.
            String sId = ISwitchHandler.getNodeId(EndModel.getNode());
            this.addWaypointIntoTransmission(TrackElementType.CROSSOVER_TYPE, sId);
        } else {
            // no Crossover so it has to be a rail
            handleRailWaypoint(trackElementOfEnd);
        }
*/
    }

    /**
     * @deprecated
     * @param CTE
     */
    public void handleCrossoverWaypoint(MovableTrackElement CTE) {
        throw new NotImplementedException("deprecated");
        /*String sId;
        CrossoverModel M = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) CTE);
        sId = ISwitchHandler.getNodeId(M.getNode());
        this.addWaypointIntoTransmission(TrackElementType.CROSSOVER_TYPE, sId);
        */
    }

    /**
     * @deprecated
     * @param TE
     */
    public void handleRailWaypoint(MovableTrackElement TE) {
        throw new NotImplementedException("deprecated");

        //this.addWaypointIntoTransmission(TrackElementType.RAIL_TYPE, TE.getPlanProId());
    }



    /**
     * @deprecated
     * @return
     */
    private HashMap<ITopological, IWaypoint> generateWaypointOnTrackMap() {
        HashMap<ITopological, IWaypoint> resultMap = new HashMap<ITopological, IWaypoint>();
        SpotLocation BeginPoint = location.getBegin();


        if(BeginPoint != null) {
            resultMap.put((ITopological) BeginPoint.getElement(), (IWaypoint) BeginPoint);

        }
        SpotLocation EndPoint =  location.getEnd();
        if(EndPoint != null) {
            resultMap.put((ITopological) EndPoint.getElement(), (IWaypoint) EndPoint);
        }
        List<Waypoint> points = this.waypointsList;
        for(Waypoint W : points) {
           //Deprecated debug
        }
        return resultMap;
    }

    private ArrayList<Waypoint> getAllWaypointsInOrder(boolean withEndpoint) {
        ArrayList<Waypoint> resultList = new ArrayList<>();
        SpotLocation BeginPoint = location.getBegin();
        SpotLocation EndPoint = location.getEnd();
        /*WaypointDecorator BeginWayPoint =
                new WaypointDecorator(BeginPoint.getElement(), new TrackElementStatus(), -1, -1);
        WaypointDecorator EndWayPoint = null;
        if (withEndpoint) {
            EndWayPoint =
                new WaypointDecorator(EndPoint.getElement(), new TrackElementStatus(), -1, -1);
        }*/
        //resultList.add(BeginWayPoint);
        resultList.addAll(this.waypointsList);

        //if(withEndpoint) resultList.add(EndWayPoint);
        return resultList;

    }


    /**
     * @deprecated
     * @return
     */
    public IWaypoint retrieveWaypointOnTrack() {
        return null;
    }

    /**
     * @deprecated

     */
    public void setStartSpot() {
        throw new NotImplementedException("deprecated");


    }

    /**
     * @deprecated
     */
    private void setSpot() {
        throw new NotImplementedException("deprecated");

        /*int iBeginMeter = Element.getChainageBeginn().getiMeters();
        int iEndMeter = Element.getChainageEnd().getiMeters();
        boolean isValid = (iBeginMeter <= iMeters) && (iMeters <= iEndMeter);
        */
        /*
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
            }
        } else {
            throw new IndexOutOfBoundsException("Spot not in Tracks Chainage");
        }
        */
    }

    /**
     * @deprecated
     * @param TE
     * @param Status
     */
    public void addWaypoint(PositioningNetElement TE, TrackElementStatus Status) {
        throw new NotImplementedException("deprecated");
        /*
        Waypoint W = new Waypoint(TE, Status);
        int x = TrackController.ClickPoint.x;
        int y = TrackController.ClickPoint.y;

        Waypoint WayDecorated = new WaypointDecorator(TE, Status, x, y);
        if(waypointsList.contains(WayDecorated)) {
            throw new InvalidParameterException("Waypoint already added");
        } else {
            waypointsList.add(WayDecorated);
        }
        */
    }

    /**
     * @deprecated
     * @param TE
     */
    public void removeWaypoint(ControlledTrackElement TE) {
        throw new NotImplementedException("deprecated");
        /*
        for(Waypoint W : waypointsList)  {
            if(W.getTrackElement() == TE) {
                waypointsList.remove(W);
                return;


            }
        }
        throw new InvalidParameterException("Waypoint cannot be removed");
        */
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

    /**
     * @deprecated
     */
    public void setEndSpot() {
        throw new NotImplementedException("deprecated");
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
