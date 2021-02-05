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
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.util.DefaultRepo;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.transaction.reactive.TransactionalOperatorExtensionsKt;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    /**
     * @deprecated
     * Berechnet Ausdehnung der gesamten Strecke
     * @return BigDecimal - Streckenausdehnug
     */
    public BigDecimal getRouteLength() {
        BigDecimal result = new BigDecimal("0");
        Iterator<Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological>> it = this.iterator();
        while(it.hasNext()) {
            Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological> element = it.next();
            if(element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                TopologyGraph.Edge E = (TopologyGraph.Edge) element.getValue();
                result.add(BigDecimal.valueOf(E.dTopLength));
            }
        }
        return result;

    }

    /**
     * This route will be gone back referenced on lastSpot on the last Trackedge
     * @param lastSpot - end point beeing refered
     * @param dMeterGoBack - distance to go back onto route
     * @param i_QScale
     * @return SpotLocationIntrinsic - Spot on route when gone back for "dMeterGoBack" meter
     * @throws SmartLogicException - distance gone back is longer than track section in scope of last spot
     */
    public SpotLocationIntrinsic getPositionGoBackFromEndOfTrack(SpotLocationIntrinsic lastSpot,
                                                                 ETCS_DISTANCE dMeterGoBack,
                                                                 int i_QScale) throws SmartLogicException {
        Q_SCALE QS = Q_SCALE.getScale(i_QScale);
        int i_Exponent = i_QScale - 1;
        if(QS.equals(Q_SCALE.SPARE)) {
            i_Exponent = 1;
        }
        TopologyGraph.Edge LastEdge = (TopologyGraph.Edge) this.get(this.size() - 1).getRight();
        TopologyGraph.Edge CurrentEdge = LastEdge;
        // distance from Top_Node to Last Spot of Track
        BigDecimal d_lastSpotInTrack = new BigDecimal(LastEdge.dTopLength)
                .multiply(new BigDecimal(lastSpot.getIntrinsicCoord()));


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

    /**
     * retrives Subroute as Trackarea, result - TrackArea "result" determines subtype of Trackarea beeing returned
     * @param lastSpot
     * @param dMeterGoBack
     * @param i_QScale
     * @param result
     * @return
     */
    public TrackArea createSubRoute(SpotLocationIntrinsic lastSpot,
                                    ETCS_DISTANCE dMeterGoBack,
                                    int i_QScale, TrackArea result) {
        return result;
    }


}
