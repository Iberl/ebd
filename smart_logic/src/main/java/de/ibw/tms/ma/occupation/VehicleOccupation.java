package de.ibw.tms.ma.occupation;

import de.ibw.feed.Balise;
import de.ibw.history.PositionModul;
import de.ibw.history.data.ComposedRoute;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.mob.common.NID_ENGINE;
import de.ibw.tms.ma.mob.position.MOBPosition;
import de.ibw.tms.ma.mob.position.SafeMOBPosition;
import de.ibw.tms.ma.occupation.intf.IMoveable;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.ma.positioned.elements.train.MaxSafeFrontEnd;
import de.ibw.tms.ma.positioned.elements.train.MinSafeFrontEnd;
import de.ibw.tms.ma.positioned.elements.train.MinSafeRearEnd;
import de.ibw.tms.ma.positioned.elements.train.TrainPositionSpots;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.UtilFunction;
import de.ibw.util.intf.IToLogIntf;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainInfo;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Belegung durch Fahrzeug
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2021-03-31
 *
 */
public class VehicleOccupation extends Occupation implements IMoveable {
    public static final String CLASS_IDENTIFIER = "Vehicle_Occupation";

    // TODO
    public static VehicleOccupation generateVehicleOccupation(PositionInfo Position, NID_ENGINE nid_engine, SafeMOBPosition SafePosition, ArrayList<TrackEdgeSection> sectionList, SpotLocationIntrinsic begin, SpotLocationIntrinsic end) {
        TrainPositionSpots beginTrain;
        TrainPositionSpots endTrain;
        VehicleOccupation VO = new VehicleOccupation();
        int nid_lrbg = Position.nid_lrbg;
        Balise LrbgBalise = Balise.baliseByNid_bg.getModel(nid_lrbg);
        if(LrbgBalise == null) throw new InvalidParameterException("LrbgBalise not found (Nid):" + nid_lrbg);
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(LrbgBalise.getTopPositionOfDataPoint().getIdentitaet()
                .getWert());
        begin.setNetElementRef(E.getId());
        end.setNetElementRef(E.getId());
        /*TrackEdgeSection TES = new TrackEdgeSection();
        TES.setTrackEdge(E);
        TES.setBegin(begin);
        TES.setEnd(end);
        sectionList.add(TES);*/
        beginTrain = new MinSafeRearEnd();
        beginTrain.setLocation(begin);
        endTrain = new MaxSafeFrontEnd();
        endTrain.setLocation(end);
        SafePosition.setTrackEdgeSections(sectionList);
        SafePosition.setBegin(beginTrain);
        SafePosition.setEnd(endTrain);
        MovableObject MO = MovableObject.ObjectRepo.getModel(nid_engine);
        MOBPosition P = new MOBPosition(SafePosition);
        if(MO == null) MO = new MovableObject(nid_engine, P);
        MO.setPosition(P);

        SafePosition.setOccupation(VO);
        return VO;
    }


    private SafeMOBPosition Position;

    /**
     * @deprecated
     * @param TI
     * @param Pos
     */
    public VehicleOccupation(TrainInfo TI, PositionInfo Pos) {
        super(CLASS_IDENTIFIER);
        Balise B = Balise.baliseByNid_bg.getModel(Pos.nid_lrbg);
        ComposedRoute RDSL = PositionModul.getInstance().getRouteOfNidEngine(TI.nid_engine);
        if(RDSL == null) {
            //handleVehicleWithoutMa(TI, Pos, B);
        } else {

        }
    }

    public MovableObject getTargetMoveableObject() {
        if(Position == null) return null;
        MOBPosition positionLink = Position.getLinkToMobileObject();
        if(positionLink == null) return null;
        return positionLink.getMovableObject();
    }

    @Deprecated
    private void handleVehicleWithoutMa(TrainInfo TI, PositionInfo Pos, Balise B) {
        int iDistanceFormBalise = Pos.d_lrbg;
        BigDecimal dDistanceFromA = new BigDecimal(0);
        BigDecimal dIntrinsicFactor;
        BigDecimal dRearEndIntrinsicFactor;
        int iDirLrbg = Pos.q_dirlrbg;
        int iDirTrainIsMoving = Pos.q_dirtrain;
        BigDecimal dTrainLength = new BigDecimal(Pos.l_trainint);
        boolean shallOccupateWholeEdge = false;
        if(iDirLrbg == 2 || iDirLrbg == 3 ) {
            /**
             * @TODO NPREP
             */
            //occupateBothDirections(iNidEngine, Pos, B);
        }
        if(iDirTrainIsMoving == 2 || iDirTrainIsMoving == 3) {
            /**
             * @TODO NPREP
             */
            shallOccupateWholeEdge = true;
        }
        boolean isTrainDrivingInNominalDirection = iDirLrbg == 1;
        //boolean isTrain
        CTOPKante TopE = B.getTopPositionOfDataPoint();
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(TopE.getIdentitaet().getWert());
        BigDecimal dBaliseDistanceFromA = B.getBalisenPositionFromNodeA();
        TopologyGraph.Node DirectionNode = B.getNodeInDirectionOfBaliseGroup(isTrainDrivingInNominalDirection);
        if(E.B.equals(DirectionNode)) {
            dDistanceFromA = dBaliseDistanceFromA.add(new BigDecimal(iDistanceFormBalise));
        } else {
            dDistanceFromA = dBaliseDistanceFromA.subtract(new BigDecimal(iDistanceFormBalise));
        }
        //if()
        dIntrinsicFactor =
                BigDecimal.valueOf(
                        UtilFunction.generateIntrinsic(
                                E.dTopLength, BLOCK_Q_SCALE.Q_SCALE_1M, dDistanceFromA.intValue()));
        if(dIntrinsicFactor.compareTo(new BigDecimal(0.1)) < 0) {
            /**
             * @TODO NPREP
             */
        }
        if(dIntrinsicFactor.compareTo(new BigDecimal(0.9)) > 0) {
            /**
             * @TODO NPREP
             */
        }
        if(shallOccupateWholeEdge)
            initVehicleOccupation(E, BLOCK_Q_SCALE.Q_SCALE_1M, 0, BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength);
        else {
            //initVehicleOccupation(E, BLOCK_Q_SCALE.Q_SCALE_1M, )
        }

    }

    private VehicleOccupation() {
        super(CLASS_IDENTIFIER);
    }

    /**
     * @deprecated
     * @param e
     * @param qScale1mStart
     * @param iStart
     * @param qScale1mEnd
     * @param iEnd
     */
    public VehicleOccupation(TopologyGraph.Edge e, BLOCK_Q_SCALE qScale1mStart,
                             int iStart, BLOCK_Q_SCALE qScale1mEnd, int iEnd) {
        super(CLASS_IDENTIFIER);
        initVehicleOccupation(e, qScale1mStart, iStart, qScale1mEnd, iEnd);


    }
    @Deprecated
    public void initVehicleOccupation(TopologyGraph.Edge e, BLOCK_Q_SCALE qScale1mStart, int iStart, BLOCK_Q_SCALE qScale1mEnd, int iEnd) {
        SafeMOBPosition SafePosition = new SafeMOBPosition();
        TrackEdgeSection TES = new TrackEdgeSection();
        SpotLocationIntrinsic BeginLocation = new SpotLocationIntrinsic();
        SpotLocationIntrinsic EndLocation = new SpotLocationIntrinsic();
        BeginLocation.setIntrinsicCoord(UtilFunction.generateIntrinsic(e.dTopLength, qScale1mStart, iStart));

        EndLocation.setIntrinsicCoord(UtilFunction.generateIntrinsic(e.dTopLength, qScale1mEnd, iEnd));
        MinSafeRearEnd TrainBeginSpot = new MinSafeRearEnd();
        MinSafeFrontEnd TrainEndSpot = new MinSafeFrontEnd();


        TrainBeginSpot.setLocation(BeginLocation);
        SafePosition.setBegin(TrainBeginSpot);
        TrainEndSpot.setLocation(EndLocation);
        SafePosition.setEnd(TrainEndSpot);
        this.setPosition(SafePosition);

        defineOccupatedSection(e,TES, BeginLocation, EndLocation);
    }

    public SafeMOBPosition getPosition() {
        return Position;
    }

    public void setPosition(SafeMOBPosition position) {
        Position = position;
    }

    public MinSafeRearEnd getBegin() {
        return (MinSafeRearEnd) Position.getBegin();
    }
    public MaxSafeFrontEnd getEnd() {
        return (MaxSafeFrontEnd) Position.getEnd();
    }

    @Override
    public String toString() {
        return "VehicleOccupation{" +
                "Position=" + Position +
                '}';
    }

    @Override
    public String log() {
        return "VehicleOccupation{" +
                "Position=" + Position +
                super.log() +
                '}';
    }
}
