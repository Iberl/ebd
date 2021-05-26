package de.ibw.tms.ma.occupation;

import de.ibw.history.data.ComposedRoute;
import de.ibw.tms.etcs.*;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.mob.common.NID_ENGINE;
import de.ibw.tms.ma.occupation.intf.IMoveable;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.ui.Route;
import ebd.internal.util.EOA;
import org.jetbrains.annotations.NotNull;
import org.railMl.rtm4rail.TApplicationDirection;

import java.security.InvalidParameterException;

/**
 * Ein von einer MA belegter Abschnitt
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-30
 */
public class MAOccupation extends Occupation implements IMoveable {
    public static final String CLASS_IDENTIFIER = "MA_Occupation";

    private MovementAuthority MA;


    public static MAOccupation generateMaOccupation(int trainId, MARequestOccupation MAO, ebd.internal.util.MA rbcMa,
                                                    Route r, ComposedRoute requestedTrackElementList,
                                                    TopologyGraph.Edge LastEdge, int q_scale)
                                                    throws InvalidParameterException {
        guardGenerator(MAO, rbcMa, r, requestedTrackElementList, LastEdge);
        MAOccupation MaoOccup = new MAOccupation();
        MaoOccup.setApplicationDirection(TApplicationDirection.BOTH);
        MaoOccup.setTrackEdgeSections(MAO.getTrackEdgeSections());
        MovementAuthority MA = new MovementAuthority();
        NID_ENGINE nid_engine = new NID_ENGINE(trainId);

        MovableObject movableObject = MovableObject.ObjectRepo.getModel(nid_engine);
        if(movableObject == null) throw new InvalidParameterException("Movable Object (Train) must exist");
        MA.setRouteOfMa(requestedTrackElementList);
        SpotLocationIntrinsic LastSpot = new SpotLocationIntrinsic();

        LastSpot.setIntrinsicCoord(r.getIntrinsicCoordOfTargetTrackEdge());
        LastSpot.setNetElementRef(LastEdge.getId());
        SpotLocationIntrinsic eoaSpot = null;
        SvL svl = new SvL(LastSpot);
        SSP ssp;


        boolean q_overlap = rbcMa.eoa.overlap != null;
        boolean qDangerPoint = rbcMa.eoa.dangerPoint != null;
        Overlap O = q_overlap ? genOverlap(rbcMa.eoa.overlap, q_scale, svl) : null;
        ETCS_DISTANCE d_etcs_eoa_to_last_spot = null;
        DangerPoint DP;

        if(O == null) {
            if(qDangerPoint) {
                DP =  genDangerPoint(rbcMa.eoa.dangerPoint, LastSpot);
                d_etcs_eoa_to_last_spot = new ETCS_DISTANCE();
                d_etcs_eoa_to_last_spot.sDistance = DP.getD_OL().sDistance;

            } else {
                DP = null;
                d_etcs_eoa_to_last_spot = new ETCS_DISTANCE();
                d_etcs_eoa_to_last_spot.sDistance = 0;

            }
        } else {
            if(qDangerPoint) {
                d_etcs_eoa_to_last_spot = new ETCS_DISTANCE();
                d_etcs_eoa_to_last_spot.sDistance = O.d_OL.sDistance;
                DP = genDangerPoint(rbcMa.eoa.dangerPoint, LastSpot, d_etcs_eoa_to_last_spot,
                        requestedTrackElementList, q_scale);
            } else {
                d_etcs_eoa_to_last_spot = new ETCS_DISTANCE();
                d_etcs_eoa_to_last_spot.sDistance = O.d_OL.sDistance;
                DP = null;
            }
        }
        eoaSpot = requestedTrackElementList.getPositionGoBackFromEndOfTrack(LastSpot, d_etcs_eoa_to_last_spot, q_scale);

        T_EMA t_ema = new T_EMA();
        t_ema.setTime((short) rbcMa.eoa.t_loa);

        boolean qEndTimer = rbcMa.eoa.endTimer != null;
        ETCS_DISTANCE D_ETCS_EndTimerStartLoc = qEndTimer ? genDistanceStartLoc(rbcMa.eoa.endTimer) : null;
        ETCS_TIMER t_End = qEndTimer ? genEndTime(rbcMa.eoa.endTimer) : null;


        Q_SCALE Q = Q_SCALE.getScale(q_scale);

        EoA eoa = new EoA(eoaSpot, rbcMa.eoa.v_loa, t_ema,qEndTimer, D_ETCS_EndTimerStartLoc, t_End,
                qDangerPoint, DP, q_overlap, O, Q);


        MA.setEndOfAuthority(eoa);
        MA.setSuperviesedLocation(svl);


        MA.setMOB(MovableObject.ObjectRepo.getModel(new NID_ENGINE(trainId)));

        MaoOccup.setMA(MA);
        return MaoOccup;
    }

    private static void guardGenerator(MARequestOccupation mao, ebd.internal.util.MA rbcMa, Route r,
                                       ComposedRoute requestedTrackElementList, TopologyGraph.Edge lastEdge)
                                        throws InvalidParameterException {
        if(mao == null) throw new InvalidParameterException("The request occupation must not be null");
        if(rbcMa == null) throw new InvalidParameterException("The Ma for RBC must not be null");
        if(rbcMa.eoa == null) throw new InvalidParameterException("The eoa for the train must not be null");
        if(r == null) throw new InvalidParameterException("The route must not be null");
        if(requestedTrackElementList == null) throw new InvalidParameterException("The route beeing checked must not be null");
        if(lastEdge == null) throw new InvalidParameterException("The edge route is ending must not be null");

    }

    /**
     * Overlap is last spot
     * @param dangerPoint
     * @param lastSpot
     * @param d_etcs_eoa_to_endOfOverlap
     * @param requestedTrackElementList
     * @param i_QScale
     * @return
     */
    private static DangerPoint genDangerPoint(EOA.DangerPoint dangerPoint, SpotLocationIntrinsic lastSpot,
                                              ETCS_DISTANCE d_etcs_eoa_to_endOfOverlap,
                                              ComposedRoute requestedTrackElementList,
                                              int i_QScale) throws InvalidParameterException {
        DangerPoint DP = defineDangerPoint(dangerPoint);
        ETCS_DISTANCE etcs_goBack = new ETCS_DISTANCE();
        etcs_goBack.sDistance = (short) (d_etcs_eoa_to_endOfOverlap.sDistance - dangerPoint.d_dp);


        DP.setLocation(requestedTrackElementList.getPositionGoBackFromEndOfTrack(lastSpot,etcs_goBack,i_QScale));
        return DP;

    }

    private static Overlap genOverlap(EOA.Overlap O_RBC, int q_scale, SvL svl) {
        ETCS_DISTANCE d_etcs_dOL = new ETCS_DISTANCE();
        ETCS_DISTANCE d_etcs_dStart = new ETCS_DISTANCE();
        ETCS_TIMER t_etcs_tOL = new ETCS_TIMER();
        ETCS_SPEED v_etcs_releaseOl = new ETCS_SPEED();


        t_etcs_tOL.sTimer = (short) O_RBC.t_ol;
        d_etcs_dOL.sDistance = (short) O_RBC.d_ol;
        d_etcs_dStart.sDistance = (short) O_RBC.d_startol;
        v_etcs_releaseOl.bSpeed = (byte) O_RBC.v_releaseol;

        Overlap O = new Overlap();
        O.setSvl(svl);
        O.q_OL = Q_SCALE.getScale(q_scale);
        O.d_OL = d_etcs_dOL;
        O.t_OL = t_etcs_tOL;
        O.q_STARTOL = Q_SCALE.getScale(q_scale);
        O.d_STARTOL = d_etcs_dStart;
        O.v_RELEASEOL = v_etcs_releaseOl;

        return O;

    }

    private static DangerPoint genDangerPoint(EOA.DangerPoint dangerPoint, SpotLocationIntrinsic lastSpot) {
        DangerPoint DP = defineDangerPoint(dangerPoint);
        DP.setLocation(lastSpot);
        return DP;
    }

    @NotNull
    private static DangerPoint defineDangerPoint(EOA.DangerPoint dangerPoint) {
        ETCS_DISTANCE d_etcs_danger_distance = new ETCS_DISTANCE();
        ETCS_SPEED s_etcs_release_speed = new ETCS_SPEED();
        d_etcs_danger_distance.sDistance = (short) dangerPoint.d_dp;
        s_etcs_release_speed.bSpeed = (byte) dangerPoint.v_releasedp;
        DangerPoint DP = new DangerPoint(d_etcs_danger_distance, s_etcs_release_speed);
        return DP;
    }

    private static ETCS_TIMER genEndTime(EOA.EndTimer endTimer) {
        ETCS_TIMER T = new ETCS_TIMER();
        T.sTimer = (short) endTimer.t_endtimer;
        return T;
    }

    private static ETCS_DISTANCE genDistanceStartLoc(EOA.EndTimer endTimer) {
        ETCS_DISTANCE d_StartLocTimer = new ETCS_DISTANCE();
        d_StartLocTimer.sDistance = (short) endTimer.d_endtimerstartloc;
        return d_StartLocTimer;
    }


    public MAOccupation() {
        super(CLASS_IDENTIFIER);
    }

    public MovementAuthority getMA() {
        return MA;
    }

    public void setMA(MovementAuthority MA) {
        this.MA = MA;
    }

    @Override
    public MovableObject getTargetMoveableObject() {
       return MA.getMOB();
    }




}
