package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.physical.ControlledTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.plan.elements.CrossoverModel;
import de.ibw.tms.trackplan.ui.IWaypoint;
import de.ibw.tms.trackplan.ui.WaypointDecorator;
import org.apache.commons.lang3.NotImplementedException;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Route implements Cloneable, Serializable {



    public enum TrackElementType {
        RAIL_TYPE, CROSSOVER_TYPE
    }

    private LinearLocation location = new LinearLocation(null,null,null);

    private List<Waypoint> waypointsList = new ArrayList<Waypoint>();
    @Expose
    private List<String> elementListIds = new ArrayList<>();
    @Expose
    private List<TrackElementType> elemetTypes = new ArrayList<>();


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
        TrackE TrackElementOfEnd = WayEnd.getTrackElement();
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



            TrackElement CTE = W.getTrackElement();
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

    public void handleCrossoverWaypoint(TrackElement CTE) {
        String sId;
        CrossoverModel M = CrossoverModel.BranchToCrossoverModelRepo.getModel((ControlledTrackElement) CTE);
        sId = M.getNode().TopNodeId;
        this.addWaypointIntoTransmission(TrackElementType.CROSSOVER_TYPE, sId);
    }

    public void handleRailWaypoint(TrackElement TE) {

        Trail T = (Trail) TE;
        this.addWaypointIntoTransmission(TrackElementType.RAIL_TYPE, T.getPlanProId());
    }

    private void addWaypointIntoTransmission(TrackElementType TrackType, String sId) {
        elemetTypes.add(TrackType);
        elementListIds.add(sId);
    }

    private HashMap<TrackElement, IWaypoint> generateWaypointOnTrackMap() {
        HashMap<TrackElement, IWaypoint> resultMap = new HashMap<TrackElement, IWaypoint>();
        SpotLocation BeginPoint = location.getBegin();


        if(BeginPoint != null) {
            resultMap.put(BeginPoint.getTrackElement(), (IWaypoint) BeginPoint);

        }
        SpotLocation EndPoint =  location.getEnd();
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
        SpotLocation BeginPoint = location.getBegin();
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

    /**
     * @deprecated
     * @param Element
     * @return
     */
    public IWaypoint retrieveWaypointOnTrack(TrackEdge Element) {
        throw new NotImplementedException("deprecated");
        //return (IWaypoint) generateWaypointOnTrackMap().get(Element);
    }


    public void setStartSpot(TrackElement Element, int iMeters) {
        setSpot(Element, iMeters, true);


    }

    private void setSpot(TrackElement Element, int iMeters, boolean isBegin) {

    }

    public void addWaypoint(ControlledTrackElement TE, TrackElementStatus Status) {


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
