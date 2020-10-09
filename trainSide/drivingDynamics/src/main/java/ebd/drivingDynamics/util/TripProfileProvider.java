package ebd.drivingDynamics.util;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.BreakingCurveGroup;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.drivingDynamics.DDUpdateTripProfileEvent;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.globalUtils.spline.Spline;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripProfileProvider {

    private final EventBus localEventBus;

    private enum Mode {
        FROM_BREAKINGCURVE,
        FROM_FILE, //TODO Implement
        FROM_SOCKET //TODO Implement
    }

    ConfigHandler ch = ConfigHandler.getInstance();
    TrainDataVolatile trainDataVolatile;

    private Mode mode;
    private Spline profile = null;
    private Location refLocation = new InitalLocation();

    public TripProfileProvider(EventBus localBus){
        this.localEventBus = localBus;
        this.localEventBus.register(this);
        this.trainDataVolatile = this.localEventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        switch(ch.tripProfileMode){
            case("breakkingcurve"):
                this.mode = Mode.FROM_BREAKINGCURVE;
                break;
            case("file"):
                this.mode = Mode.FROM_FILE;
                break;
            case("socket"):
                this.mode = Mode.FROM_SOCKET;
                break;
            default:
                this.mode = Mode.FROM_BREAKINGCURVE;
        }
    }

    @Subscribe
    public void newBreakingCurveEvent(NewBreakingCurveEvent nbce){
        if(this.mode != Mode.FROM_BREAKINGCURVE) {
            getProfilefromSource(nbce.breakingCurveGroup.getPermittedSpeedCurve());
        }
        else {
            getProfileFromBreakingCurveGroup(nbce.breakingCurveGroup);
        }


        this.localEventBus.post(new DDUpdateTripProfileEvent("dd",
                                "dd",
                                this.profile,
                                refLocation.getId()));

    }

    /**
     * Because the way breaking curves are calculated, the permitted speed curve have higher
     * speeds then the service intervention breaks.
     * This leads to an undesirable behavior of the driving dynamic class. This method takes numeric
     * approach to produce the minimum curve of both by sampling both curves with a 0.5 m resolution and taking the minimal value.
     * @param breakingCurveGroup A {@link BreakingCurveGroup} from a {@link NewBreakingCurveEvent}
     */
    private void getProfileFromBreakingCurveGroup(BreakingCurveGroup breakingCurveGroup) {
        //TODO Check Performance inpact. Should be low (only done once per MA)
        BreakingCurve psc = breakingCurveGroup.getPermittedSpeedCurve();
        this.refLocation = psc.getRefLocation();

        BreakingCurve sic = breakingCurveGroup.getServiceInterventionCurve();

        final double maxX = Math.min(psc.getHighestXValue(),sic.getHighestXValue());
        final int xSteps = (int)maxX * 2;
        final double deltaX = maxX / xSteps;

        List<double[]> pointList = new ArrayList<>();
        pointList.add(new double[]{0,Math.min(psc.getPointOnCurve(0d),sic.getPointOnCurve(0d))});
        double [] carryPoint = {-1,-1}; //Needed to preserve areas of constant speed on the curve, will be used to mark the endpoint of such an area

        for(double x = deltaX; x<=maxX; x += deltaX){
            double y = Math.min(psc.getPointOnCurve(x),sic.getPointOnCurve(x));

            if(y == pointList.get(pointList.size() - 1)[1]) {
                carryPoint = new double[]{x,y};
            }
            else {
                if(carryPoint[0] > -1){
                    pointList.add(carryPoint);
                    carryPoint = new double[]{-1,-1};
                }
                pointList.add(new double[]{x, y});
            }
        }

        this.profile = new BackwardSpline(1,"tripProfileFromBreakingCurve");
        double[] point = pointList.get(0);
        this.profile.addKnotToCurve(new Knot(point[0],new double[]{point[1],0}));

        for(int i = 1; i < pointList.size(); i++){
            double[] lastPoint = point;
            point = pointList.get(i);
            double slope = (point[1] - lastPoint[1])/(point[0] - lastPoint[0]);
            this.profile.addKnotToCurve(new Knot(point[0],new double[]{point[1],slope}));
        }
    }


    public Spline getProfile() {
        return profile;
    }

    private void getProfilefromSource(BreakingCurve breakingCurve) {

        int etcsID = trainDataVolatile.getEtcsID();
        int refLocID = breakingCurve.getRefLocation().getId();

        if(this.mode == Mode.FROM_FILE) getProfilefromFile(etcsID, refLocID);
        else if (this.mode == Mode.FROM_SOCKET) getProfilefromSocket(etcsID, refLocID);

    }

    private void getProfilefromFile(int etcsID, int refLocID) {
        //TODO Implement after Spline File Format is determined
    }

    private void getProfilefromSocket(int etcsID, int refLocID) {
        //TODO Implement after Spline File Format is determined
    }
}
