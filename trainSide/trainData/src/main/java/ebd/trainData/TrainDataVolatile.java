package ebd.trainData;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsModeAndLevel.ETCSLevel;
import ebd.globalUtils.etcsModeAndLevel.ETCSMode;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Spline;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.trainData.util.availableAcceleration.AccelerationPowerCurveCalculator;
import ebd.trainData.util.availableAcceleration.AvailableAcceleration;
import ebd.trainData.util.availableAcceleration.BreakingPowerCurveCalculator;
import ebd.trainData.util.availableAcceleration.ResistanceCurveCalculator;
import ebd.trainData.util.dataConstructs.IncrPosRprtDist;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This class contains the volatile train data.
 * On initialisation of this class, this data is not known, so all values are set to {@code null}
 *
 * @author Lars Schulze-Falck
 */
public class TrainDataVolatile {

    /**
     * ETCS ID <br>
     *     Updated by TSM once on initialisation.
     */
    protected final int etcsID;

    /**
     * TrainConfig ID used to communicate with the TrainConfig tool.<br>
     *     Updated by TSM once on initialisation.     *
     */
    protected final int trainConfigID;

    /**
     * Infrastructure ID used to communicate with the model train infrastructure.<br>
     *    Updated by TSM once on initialisation.
     */
    protected final int infrastructureID;

    /**
     * Current connected RBC ID <br>
     *     Updated by TSM once on initialisation and on every rbc handover
     */
    protected volatile int rbcID;


    /**
     * The current {@link Position}
     */
    @Nullable
    protected volatile Position currentPosition = null;

    /**
     * The distance already driven on the current complete trip in [m]
     * Updated by DrivingDynamics
     */
    protected volatile double curTripDistance = 0d;

    /**
     * Time since the trip started in [s]
     * Updated by DrivingDynamics
     */
    protected volatile double curTripTime = 0d;

    /**
     * The distance already driven on the current trip section in [m]
     * A trip sections starts at the reference location of the current movement authority.
     * Updated by DrivingDynamics
     */
    protected volatile double curTripSectionDistance = 0d;

    /**
     * The current trip profile provided to the train
     */
    @Nullable
    protected volatile Spline currentTripProfile = null;

    /**
     * The target speed of the train in [m/s] based on the trip profile.
     * Updated trough driving dynamics.
     */
    protected volatile double currentProfileTargetSpeed = 0d;

    /**
     * The current speed of the train in [m/s].
     * Updated trough driving dynamics
     */
    protected volatile double currentSpeed = 0d;

    /**
     * The current max speed of the train in [m/s] based on
     * the permitted speed curve.
     * Updated by the speed supervision module.
     */
    protected volatile double currentMaximumSpeed = 0d;


    /**
     * The current emergency intervention speed of the train in [m/s] based on
     * the service intervention curve.
     * Updated by the speed supervision module.
     */
    protected volatile double currentEmergencyInterventionSpeed = 0d;

    /**
     * The current service intervention speed of the train in [m/s] based on
     * the service intervention curve.
     * Updated by the speed supervision module.
     */
    protected volatile double currentServiceInterventionSpeed = 0d;

    /**
     * The current service warning speed of the train in [m/s] based on
     * the service warning curve.
     * Updated by the speed supervision module.
     */
    protected volatile double currentWarningSpeed = 0d;

    /**
     * The current service indication speed of the train in [m/s] based on
     * the service indication curve.
     * Updated by the speed supervision module.
     */
    protected volatile double currentIndicationSpeed = 0d;

    /**
     * The current service coasting phase speed of the train in [m/s] based on
     * the service coasting phase curve.
     * Updated by the speed supervision module.
     */
    protected volatile double currentCoastingPhaseSpeed = 0d;


    /**
     * Target speed of the next breaking phase of the train in [m/s].
     * Updated by the speed supervision module.
     */
    protected volatile double targetSpeed = 0d;

    /**
     * Current release speed of the next breaking phase of the train in [m/s].<br>
     *     <b>0</b> if there is no release speed at the end of the next breaking phase <br>
     *     <b> Greater 0</b> if there is a release speed.<br>
     *     Updated by the speed supervision module.
     */
    protected volatile double currentApplicableReleaseSpeed = 0d;

    /**
     * The current {@link ebd.messageLibrary.util.ETCSVariables#M_MODE}
     */
    @Nullable
    protected volatile Integer M_MODE = null;

    /**
     * All locations that where crossed in order (last entry == last crossed location)
     */
    @Nullable
    protected volatile List<Location> previousLocations = null;

    /**
     * The current breaking mode
     */
    @Nullable
    protected volatile String currentBreakingMode = null;

    /**
     * The current breaking power b(v), b in [m/(s^2)], v in [m/s]
     */
    @NotNull
    protected volatile ForwardSpline currentBreakingPower;

    /**
     * The current emergency breaking power b(v), b in [m/(s^2)], v in [m/s]
     */
    @NotNull
    protected volatile ForwardSpline currentEmergencyBreakingPower;

    /**
     * The current accelerating power curve a(v), a in [m/(s^2)], v in [m/s]
     */
    @NotNull
    protected volatile ForwardSpline currentAcceleratingPower;

    /**
     * The current resistance curve r(v), r in [m/(s^2)], v in [m/s]
     */
    @NotNull
    protected volatile ForwardSpline currentResistanceCurve;

    /**
     * Will be first set after a gradient profile exists.
     */
    @Nullable
    protected volatile AvailableAcceleration availableAcceleration = null;

    /*
    Movement Authority Request Parameter
     */

    /**
     * {@link ETCSVariables#T_MAR} in [s]
     * Do not trigger if equal to {@link ETCSVariables#T_MAR_INFINITY}
     */
    protected volatile int T_MAR = ETCSVariables.T_MAR;

    /**
     * {@link ETCSVariables#T_TIMEOUTRQST} in [s]
     * Do not trigger if equal to {@link ETCSVariables#T_TIMEOUTRQST_INFINITY}
     */
    protected volatile int T_TIMEOUTRQST = ETCSVariables.T_TIMEOUTRQST;

    /**
     * {@link ETCSVariables#T_CYCRQST} in [s]
     * Do not trigger if equal to {@link ETCSVariables#T_CYCRQST_INFINITY}
     */
    protected volatile int T_CYCRQST = ETCSVariables.T_CYCRQST;

    /*
    Position Report Parameter
     */
    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#T_CYCLOC} in [s]
     * Do not cycle with time if equal to {@link ETCSVariables#T_CYCLOC_INFINITY} or
     * {@link ETCSVariables#INTEGER_NOVALUE}
     *
     */
    protected volatile int T_CYCLOC = ETCSVariables.T_CYCLOC;

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#D_CYCLOC} in [m]
     * Do not cycle with distance if equal to {@link Double#MAX_VALUE} or
     * {@link ETCSVariables#INTEGER_NOVALUE}
     */
    protected volatile double distanceCycleLocation = ETCSVariables.D_CYCLOC;

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#M_LOC}
     */
    protected volatile int M_LOC = ETCSVariables.M_LOC;

    /**
     * {@link IncrPosRprtDist}
     */
    @Nullable
    protected volatile IncrPosRprtDist incrPosRprtDist = null;

    /**
     * Current ETCS Level. Updated by tsm.ModeSupervisor
     */
    protected volatile ETCSLevel currentETCSLevel = ETCSLevel.LEVEL_TWO;

    /**
     * Current ETCS Mode. Updated by tsm.ModeSupervisor
     */
    protected volatile ETCSMode currentETCSMode = ETCSMode.STAND_BY;


    //Constructor
    public TrainDataVolatile(int etcsID, int trainConfigID, int infrastructureID, EventBus localBus){
        this.etcsID = etcsID;
        this.trainConfigID = trainConfigID;
        this.infrastructureID = infrastructureID;
        this.currentBreakingPower = BreakingPowerCurveCalculator.calculateBreakingPower(localBus);
        this.currentEmergencyBreakingPower = BreakingPowerCurveCalculator.calculateEmergencyBreakingPower(localBus);
        this.currentAcceleratingPower = AccelerationPowerCurveCalculator.calculate(localBus);
        this.currentResistanceCurve = ResistanceCurveCalculator.calculate(localBus);
    }

    //Getter and setter

    /**
     * @return ETCS ID
     */
    public int getEtcsID() {
        return etcsID;
    }

    /**
     * @return TrainConfig ID used to communicate with the TrainConfig tool.
     */
    public int getTrainConfigID() { return trainConfigID; }

    /**
     * @return Infrastructure ID used to communicate with the model train infrastructure.
     */
    public int getInfrastructureID() { return infrastructureID; }

    /**
     * @return The current RBC ID
     */
    public int getRbcID(){ return rbcID;}

    /**
     * @return The current position of the train, containing a location and a distance
     *          to this location.
     */
    @Nullable
    public Position getCurrentPosition() {
        return currentPosition;
    }

    /**
     * @return distance already driven on the current trip in [m]
     */
    public double getCurTripDistance(){return curTripDistance; }

    /**
     * @return time since the start of the trip in [s]
     */
    public double getCurTripTime(){return curTripTime;}

    /**
     * @return The distance already driven on the current trip section in [m]
     */
    public double getCurTripSectionDistance() {
        return curTripSectionDistance;
    }

    /**
     * The current trip profile provided to the train
     */
    public Spline getCurrentTripProfile() {
        return currentTripProfile;
    }

    /**
     * @return current maximum allowed speed in [m/s] based on the trip profile
     */
    @NotNull
    public Double getCurrentProfileTargetSpeed() {
        return currentProfileTargetSpeed;
    }

    /**
     * @return current speed of the train in [m/s]
     */
    @NotNull
    public Double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * The current max speed of the train in [m/s] based on the breaking curve
     */
    public Double getCurrentMaximumSpeed() {
        return currentMaximumSpeed;
    }

    /**
     * The current emergency intervention speed of the train in [m/s] based on
     * the service intervention curve
     * Updated from the speed supervision module
     */
    public double getCurrentEmergencyInterventionSpeed() {
        return currentEmergencyInterventionSpeed;
    }

    /**
     * The current service intervention speed of the train in [m/s] based on
     * the service intervention curve
     * Updated from the speed supervision module
     */
    public double getCurrentServiceInterventionSpeed() {
        return currentServiceInterventionSpeed;
    }

    /**
     * The current service warning speed of the train in [m/s] based on
     * the service warning curve
     * Updated from the speed supervision module
     */
    public double getCurrentWarningSpeed() {
        return currentWarningSpeed;
    }

    /**
     * The current service indication speed of the train in [m/s] based on
     * the service indication curve
     * Updated from the speed supervision module
     */
    public double getCurrentIndicationSpeed() {
        return currentIndicationSpeed;
    }

    /**
     * The current service coasting phase speed of the train in [m/s] based on
     * the service coasting phase curve
     * Updated from the speed supervision module
     */
    public double getCurrentCoastingPhaseSpeed() {
        return currentCoastingPhaseSpeed;
    }

    /**
     * @return Target speed of the next breaking phase of the train in [m/s].
     */
    public double getTargetSpeed() {
        return targetSpeed;
    }

    /**
     * Current release speed of the next breaking phase of the train in [m/s].<br>
     *     <b>0</b> if there is no release speed at the end of the next breaking phase <br>
     *     <b>ConfigHandler.releaseSpeed</b> if there is a release speed in ETCS Level 1.<br>
     *     <b>Calculated speed</b> if there is a release speed in ETCS Level 2.<br>
     *     Updated from the speed supervision module.
     */
    public double getCurrentApplicableReleaseSpeed() {
        return currentApplicableReleaseSpeed;
    }

    /**
     * The current {@link ebd.messageLibrary.util.ETCSVariables#M_MODE}
     */
    @Nullable
    public Integer getM_MODE() {
        return M_MODE;
    }

    /**
     * All locations that where crossed in order (last entry == last crossed location)
     */
    @Nullable
    public List<Location> getPreviousLocations() {
        return previousLocations;
    }

    /**
     * The current breaking mode
     */
    @Nullable
    public String getCurrentBreakingMode() {
        return currentBreakingMode;
    }

    /**
     * @return The current breaking power b(v), b in [m/(s^2)], v in [m/s]
     */
    @NotNull
    public ForwardSpline getCurrentBreakingPower() {
        return currentBreakingPower;
    }

    /**
     * @return The current breaking power b(v), b in [m/(s^2)], v in [m/s]
     */
    public ForwardSpline getCurrentEmergencyBreakingPower() {
        return currentEmergencyBreakingPower;
    }

    /**
     * @return The current accelerating power curve a(v), a in [m/(s^2)], v in [m/s]
     */
    @NotNull
    public ForwardSpline getCurrentAcceleratingPower() {
        return currentAcceleratingPower;
    }

    /**
     * @return The current resistance curve r(v), r in [m/(s^2)], v in [m/s]
     */
    @NotNull
    public ForwardSpline getCurrentResistanceCurve() {
        return currentResistanceCurve;
    }

    /**
     * @return Null before a gradient profile is received.<br>
     */
    @Nullable
    public AvailableAcceleration getAvailableAcceleration() {
        return availableAcceleration;
    }

    /**
     * {@link ETCSVariables#T_MAR} in [s]
     * Do not trigger if equal to {@link ETCSVariables#T_MAR_INFINITY}
     */
    public int getT_MAR() {
        return T_MAR;
    }

    /**
     * {@link ETCSVariables#T_TIMEOUTRQST} in [s]
     * Do not trigger if equal to {@link ETCSVariables#T_TIMEOUTRQST_INFINITY}
     */
    public int getT_TIMEOUTRQST() {
        return T_TIMEOUTRQST;
    }

    /**
     * {@link ETCSVariables#T_CYCRQST} in [s]
     * Do not trigger if equal to {@link ETCSVariables#T_CYCRQST_INFINITY}
     */
    public int getT_CYCRQST() {
        return T_CYCRQST;
    }

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#T_CYCLOC} in [s]
     */
    public int getT_CYCLOC() {
        return T_CYCLOC;
    }

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#D_CYCLOC} in [m]
     */
    public double getDistanceCycleLocation() {
        return distanceCycleLocation;
    }

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#M_LOC}
     */
    public int getM_LOC() {
        return M_LOC;
    }

    /**
     * {@link IncrPosRprtDist}
     */
    @Nullable
    public IncrPosRprtDist getIncrPosRprtDist() {
        return incrPosRprtDist;
    }

    /**
     * @return Current ETCS Level. Updated by tsm.ModeSupervisor
     */
    public ETCSLevel getCurrentETCSLevel() {
        return currentETCSLevel;
    }

    /**
     * @return Current ETCS Mode. Updated by tsm.ModeSupervisor
     */
    public ETCSMode getCurrentETCSMode() {
        return currentETCSMode;
    }
}
