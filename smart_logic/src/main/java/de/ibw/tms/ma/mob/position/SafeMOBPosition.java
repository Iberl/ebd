package de.ibw.tms.ma.mob.position;

import de.ibw.feed.Balise;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.occupation.VehicleOccupation;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.ma.positioned.elements.train.MaxSafeFrontEnd;
import de.ibw.tms.ma.positioned.elements.train.MinSafeRearEnd;
import de.ibw.tms.ma.positioned.elements.train.TrainPositionSpots;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import ebd.rbc_tms.util.PositionInfo;
import org.railMl.rtm4rail.TApplicationDirection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Sicherheitsraum einer Mobile
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-04-07
 *
 */
public class SafeMOBPosition extends MOBPositionClasses {
    public static final String CLASS_IDENTIFIER = "Safe_MOB_Position";

    private VehicleOccupation Occupation = null;

    public SafeMOBPosition() {
        super(CLASS_IDENTIFIER);

    }

    public VehicleOccupation getOccupation() {
        return Occupation;
    }

    public void setOccupation(VehicleOccupation occupation) {
        Occupation = occupation;
        occupation.setPosition(this);
        occupation.setApplicationDirection(this.getApplicationDirection());
        occupation.setTrackEdgeSections(this.getTrackEdgeSections());
    }

    /**
     * Generiert aus der Route ein Sub-Bereich wo sich das Vehicle aufhalten muss, die SafeMobPosition
     * @param dVehicleEndOffset- offset des Routenende den das Vehicle noch nicht befahren hat
     * @param Route - Die Route die diesem Vehicle zugesprochen wurde
     * @param distanceDiff - space the vehicle has trespassed the route since initial position report
     *                          the initial position report is part of the composed route and refered as start location
     *                          of the ma
     *                     den Bereich den das Vehicle seit den Reference-Positonreport der MA bereits
     *                     beschritten hat
     * @param iScale - 0: 0,1 meter Skalenma&szlig;
     *               - 1: 1 meter Einheit
     *               - 2: 10 meter Einheit
     * @throws SmartLogicException
     */
    public void defineNewVehiclePosition(BigDecimal dVehicleEndOffset, ComposedRoute Route, ETCS_DISTANCE distanceDiff, int iScale) throws SmartLogicException {
        ETCS_DISTANCE d_vehicleEndDiff = new ETCS_DISTANCE();
        d_vehicleEndDiff.sDistance = dVehicleEndOffset.setScale(0, RoundingMode.HALF_DOWN).shortValueExact();
        SafeMOBPosition NewPosition = (SafeMOBPosition) Route.createSubRoute(distanceDiff, d_vehicleEndDiff, iScale, this);
        this.setTrackEdgeSections(NewPosition.getTrackEdgeSections());
        ArrayList<TrackEdgeSection> sections = new ArrayList<>(NewPosition.getTrackEdgeSections());
        TrackEdgeSection StartSection = sections.get(0);
        TrackEdgeSection EndSection = sections.get(sections.size() - 1);
        TrackEdge StartEdge = StartSection.getTrackEdge();
        TrackEdge EndEdge = EndSection.getTrackEdge();
        SpotLocation beginLocation = new SpotLocation(null, StartEdge, null );
        SpotLocation endLocation = new SpotLocation(null, EndEdge, null );
        beginLocation.setIntrinsicCoord(StartSection.getBegin().getIntrinsicCoord());
        endLocation.setIntrinsicCoord(EndSection.getEnd().getIntrinsicCoord());
        MinSafeRearEnd begin = new MinSafeRearEnd();
        MaxSafeFrontEnd end = new MaxSafeFrontEnd();
        begin.setLocation(beginLocation);
        end.setLocation(endLocation);
        this.setBegin(begin);
        this.setEnd(end);
        this.setApplicationDirection(TApplicationDirection.BOTH);

    }


    @Override
    public void setBegin(TrainPositionSpots begin) {
        if(!begin.getName().equals(MinSafeRearEnd.CLASS_IDENTIFIER)) {
            throw new InvalidParameterException("Begin has to be of Type MinSafeRearEnd");
        }
        super.setBegin(begin);
    }

    @Override
    public void setEnd(TrainPositionSpots end) {
        if(!end.getName().equals(MaxSafeFrontEnd.CLASS_IDENTIFIER)) {
            throw new InvalidParameterException("End has to be of Type MinSafeFrontEnd");
        }
        super.setEnd(end);
    }

    public void calcByOffset(BigDecimal newOffset, PositionInfo position) throws InvalidParameterException {
        Route R = new Route(null);
        R.setIntrinsicCoordOfTargetTrackEdge(1.0d);
        BigDecimal offsetPassed = new BigDecimal("0.0");
        int iLrbg = position.nid_lrbg;
        Balise B = Balise.baliseByNid_bg.getModel(iLrbg);
        if(B == null) throw new InvalidParameterException("Balised refered not available.");
        if(B.getTopPositionOfDataPoint() == null || B.getTopPositionOfDataPoint().getIdentitaet() == null ||
                B.getTopPositionOfDataPoint().getIdentitaet().getWert() == null) throw new InvalidParameterException("Balise " +
                "providing not enough information.");
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(B.getTopPositionOfDataPoint().getIdentitaet()
                .getWert());
        if(E == null) throw new InvalidParameterException("Edge of Balise not found");

        while(offsetPassed.compareTo(newOffset) < 0 ) {

        }



        ComposedRoute CR = new ComposedRoute();

    }
}
