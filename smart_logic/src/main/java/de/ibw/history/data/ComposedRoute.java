package de.ibw.history.data;

import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.common.NetworkResource;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.positioned.elements.TrackArea;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.util.DefaultRepo;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.railMl.rtm4rail.TApplicationDirection;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Routendatenverarbeitung innerhalb der smartLogic
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-02-04
 */
public class ComposedRoute extends ArrayList<Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological>> {

    // Waypoints auf einer Kante innerhalb einer DKW
    public DefaultRepo<TrackEdge, Waypoint> dkwWaypointRepo = new DefaultRepo<>();
    // Waypoints zwischen zwei TrackEdges je String id
    public DefaultRepo<Pair<String, String>, Waypoint> waypointsBetweentTwoTrackEdges = new DefaultRepo<>();

    private SpotLocationIntrinsic lastSpot = null;

    private BigDecimal dRouteLength = null;



    /**
     *
     * Berechnet Ausdehnung der gesamten Strecke
     * @return BigDecimal - Streckenausdehnug
     */
    public BigDecimal getRouteLength() throws SmartLogicException {
        if(lastSpot == null)
            throw new SmartLogicException("The Last Spot on this Route has to be defined but it is null");
        if(dRouteLength != null) return dRouteLength;
        BigDecimal result = new BigDecimal("0");
        Iterator<Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological>> it = this.iterator();
        while(it.hasNext()) {
            Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological> element = it.next();
            if(element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                TopologyGraph.Edge E = (TopologyGraph.Edge) element.getValue();
                result.add(BigDecimal.valueOf(E.dTopLength));
            }
        }
        this.dRouteLength = result.subtract(getDistanceOfLastTopNodeToEndOfRoute());

        return dRouteLength;
    }


    /**
     * Method for calling without recognising TrackAreas
     * @param lastSpot - end point beeing refered
     * @param dMeterGoBack - distance to go back onto route
     * @param i_QScale - Skala für Meterangaben
     * @return SpotLocationIntrinsic - Spot on route when gone back for "dMeterGoBack" meter
     * @throws SmartLogicException - distance gone back is longer than track section in scope of last spot
     */
    public SpotLocationIntrinsic getPositionGoBackFromEndOfTrack(SpotLocationIntrinsic lastSpot,
                                                                 ETCS_DISTANCE dMeterGoBack,
                                                                 int i_QScale) throws SmartLogicException {
        return this.getPositionGoBackFromEndOfTrack(lastSpot, dMeterGoBack, i_QScale, null);
    }


    /**
     * This route will be gone back referenced on lastSpot on the last Trackedge
     * @param lastSpot - end point beeing refered
     * @param dMeterGoBack - distance to go back onto route
     * @param i_QScale - Skala für Meterangaben
     * @return SpotLocationIntrinsic - Spot on route when gone back for "dMeterGoBack" meter
     * @throws SmartLogicException - distance gone back is longer than track section in scope of last spot
     */
    public SpotLocationIntrinsic getPositionGoBackFromEndOfTrack(SpotLocationIntrinsic lastSpot,
                                                                 ETCS_DISTANCE dMeterGoBack,
                                                                 int i_QScale, TrackArea result) throws SmartLogicException {
        Q_SCALE QS = Q_SCALE.getScale(i_QScale);
        int i_Exponent = i_QScale - 1;
        if(QS.equals(Q_SCALE.SPARE)) {
            i_Exponent = 1;
        }
        this.lastSpot = lastSpot;
        TopologyGraph.Edge LastEdge = (TopologyGraph.Edge) this.get(this.size() - 1).getRight();
        TopologyGraph.Edge CurrentEdge = LastEdge;
        // distance from TopologicalNode to Last Spot of Track
        BigDecimal d_lastSpotInTrack = getDistanceOfLastTopNodeToEndOfRoute();


        // distance from dp to overlap (overlap is last spot)
        BigDecimal d_Meter_Go_Back = new BigDecimal(dMeterGoBack.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent));
        int index = 1;
        BigDecimal CurrentLength = d_lastSpotInTrack;
        BigDecimal percent_of_Track = new BigDecimal("0");
        while(d_Meter_Go_Back.compareTo(new BigDecimal(0)) > 0) {

            if(CurrentLength.compareTo(d_Meter_Go_Back) >= 0) {
                percent_of_Track = CurrentLength.subtract(d_Meter_Go_Back)
                        .divide(new BigDecimal(CurrentEdge.dTopLength), 14, RoundingMode.HALF_UP);
                break;
            } else {
                d_Meter_Go_Back = d_Meter_Go_Back.subtract(CurrentLength);
                index++;
            }



            if(this.size() - index < 0)
                throw new SmartLogicException("Route is not Long enough for going back: " + d_Meter_Go_Back.doubleValue());

            Pair<Route.TrackElementType, ITopological> CurrentElement = this.get(this.size() - index);
            while(!CurrentElement.getLeft().equals(Route.TrackElementType.RAIL_TYPE)) {
                index++;
                if(this.size() - index < 0)
                    throw new SmartLogicException("Route is not Long enough for going back: " + d_Meter_Go_Back.doubleValue());
                CurrentElement = this.get(this.size() - index);
            }
            CurrentEdge = (TopologyGraph.Edge) CurrentElement.getRight();
            CurrentLength = new BigDecimal(CurrentEdge.dTopLength);
        }
        SpotLocationIntrinsic Spot = new SpotLocationIntrinsic();
        Spot.setIntrinsicCoord(percent_of_Track.doubleValue());
        Spot.setNetElementRef(CurrentEdge.getId());
        return Spot;
    }

    @NotNull
    private BigDecimal getDistanceOfLastTopNodeToEndOfRoute() {
        TopologyGraph.Edge lastEdge = (TopologyGraph.Edge) this.get(this.size() - 1).getRight();
        return new BigDecimal(lastEdge.dTopLength)
                .multiply(BigDecimal.valueOf(lastSpot.getIntrinsicCoord()));
    }

    /**
     *
     * @param dStartMeter - Beginn des Streckenabschnitts auf der Route
     * @param dEndMeter - Ende des Streckenabschnitts auf der Route
     * @param i_QScale - Massfaktor
     * @param result - TrackArea dieser Berechnung
     * @return TrackArea - gibt berechnete Trackarea wieder zur&uuml;ck
     * throws SmartLogicException
     */
    public TrackArea createSubRoute(ETCS_DISTANCE dStartMeter,
                                    ETCS_DISTANCE dEndMeter,
                                    int i_QScale, TrackArea result) throws SmartLogicException {
        if(result == null) throw new SmartLogicException("Result is to be filled and must not be null");
        guardCreatingSubRoute(dStartMeter, dEndMeter, i_QScale);
        Q_SCALE QS = Q_SCALE.getScale(i_QScale);
        result.setApplicationDirection(TApplicationDirection.BOTH);

        int i_Exponent = i_QScale - 1;
        if(QS.equals(Q_SCALE.SPARE)) {
            i_Exponent = 1;
        }
        BigDecimal d_Start_Meter = new BigDecimal(dStartMeter.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent));
        BigDecimal d_End_Meter = new BigDecimal(dEndMeter.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent));
        // defines how many meters being iterater to find start edge
        BigDecimal d_Current = new BigDecimal(0);
        ArrayList<TrackEdgeSection> sections = new ArrayList<>();
        for(Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological> Current : this) {

            TopologyGraph.Edge CurrentEdge = (TopologyGraph.Edge) Current.getRight();
            BigDecimal d_Start = new BigDecimal(String.valueOf(d_Current));
            d_Current = d_Current.add(BigDecimal.valueOf(CurrentEdge.dTopLength));
            if(d_Start_Meter.compareTo(d_Current) < 0 && d_End_Meter.compareTo(d_Start) > 0) {
                BigDecimal dBeginPercent;
                BigDecimal dEndPercent;
                if(CurrentEdge.dTopLength == 0) {
                    dBeginPercent = BigDecimal.valueOf(0);
                    dEndPercent = BigDecimal.valueOf(1);
                } else {
                    //TODO
                }
                SpotLocationIntrinsic beginLocation = new SpotLocationIntrinsic();
                //beginLocation.setIntrinsicCoord(0.0d);
                SpotLocationIntrinsic endLocation = new SpotLocationIntrinsic();
                //beginLocation.setIntrinsicCoord(dEndPercent.doubleValue());
                TrackEdgeSection TES = new TrackEdgeSection();
                TES.setTrackEdge(CurrentEdge);
                TES.setBegin(beginLocation);
                TES.setEnd(endLocation);
                sections.add(TES);


            }
        }

        TopologyGraph.Edge LastEdge = (TopologyGraph.Edge) this.get(this.size() - 1).getRight();
        TopologyGraph.Edge CurrentEdge = LastEdge;
        // distance from Top_Node to Last Spot of Track
        BigDecimal d_lastSpotInTrack = getDistanceOfLastTopNodeToEndOfRoute();


        // distance from dp to overlap (overlap is last spot)
        return null;

    }

    private void guardCreatingSubRoute(ETCS_DISTANCE dStartMeter, ETCS_DISTANCE dEndMeter, int i_qScale) throws SmartLogicException {
        Q_SCALE QS = Q_SCALE.getScale(i_qScale);

        if(this.size() == 0) throw new InvalidParameterException("The Route has not any Edges");

        int i_Exponent = i_qScale - 1;
        if(QS.equals(Q_SCALE.SPARE)) {
            i_Exponent = 1;
        }
        if(dStartMeter == null) throw new InvalidParameterException("Start Meter must not be null");
        if(dEndMeter == null) throw new InvalidParameterException("End Meter must not be null");
        if(dStartMeter.sDistance < 0) throw new InvalidParameterException("Start Meter must not be negative");
        if(dEndMeter.sDistance < 0) throw new InvalidParameterException("End Meter must not be negative");

        BigDecimal start_meter = new BigDecimal(dStartMeter.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent));

        BigDecimal end_meter = new BigDecimal(dEndMeter.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent));


        BigDecimal RouteLength = this.getRouteLength();

        if(start_meter.compareTo(RouteLength) > 0)
            throw new InvalidParameterException("Start distance in Meter must not larger than Route Length");

        if(end_meter.compareTo(RouteLength) > 0)
            throw new InvalidParameterException("End distance in Meter must not larger than Route Length");


        if(dStartMeter.sDistance > dEndMeter.sDistance)
            throw new InvalidParameterException("Start Meter must be smaller than End Meter");





    }


}
