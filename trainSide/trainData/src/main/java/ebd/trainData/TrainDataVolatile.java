package ebd.trainData;

import ebd.globalUtils.configHandler.ConfigHandler;
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
     * The current {@link Position}
     */
    @Nullable
    protected volatile Position currentPosition = null;

    /**
     * The distance already driven on the current trip in [m]
     */
    protected volatile double curTripDistance = 0d;

    /**
     * Time since the trip started in [s]
     */
    protected volatile double curTripTime = 0d;

    /**
     * The distance already driven on the current trip section in [m]
     */
    protected volatile double curTripSectionDistance = 0d;

    /**
     * The current trip profile provided to the train
     */
    @Nullable
    protected volatile Spline currentTripProfile = null;


    /**
     * The current speed of the train in [m/s]
     */
    protected volatile double currentSpeed = 0d;

    /**
     * The current max speed of the train in [m/s] based on
     * the service deceleration curve
     * Updated from the speed supervision module
     */
    protected volatile double currentMaximumSpeed = 0d;

    /**
     * The current emergency max speed of the train in [m/s] based on the
     * emergency deceleration curve
     * Updated from the speed supervision module
     */
    protected volatile double currentEmergencySpeed = 0d;

    /**
     * The current emergency intervention speed of the train in [m/s] based on
     * the service intervention curve
     * Updated from the speed supervision module
     */
    protected volatile double currentEmergencyInterventionSpeed = 0d;

    /**
     * The current service intervention speed of the train in [m/s] based on
     * the service intervention curve
     * Updated from the speed supervision module
     */
    protected volatile double currentServiceInterventionSpeed = 0d;

    /**
     * The current service warning speed of the train in [m/s] based on
     * the service warning curve
     * Updated from the speed supervision module
     */
    protected volatile double currentServiceWarningSpeed = 0d;

    /**
     * The current service permitted speed speed of the train in [m/s] based on
     * the service permitted speed curve
     * Updated from the speed supervision module
     */
    protected volatile double currentServicePermittedSpeed = 0d;

    /**
     * The current service indication speed of the train in [m/s] based on
     * the service indication curve
     * Updated from the speed supervision module
     */
    protected volatile double currentServiceIndicationSpeed = 0d;



    /**
     * The target speed of the train in [m/s] based on the trip profile.
     * Updated trough driving dynamics
     */
    protected volatile double currentTargetSpeed = 0d;


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
     * Wait time at stations in [s]
     */
    protected volatile int waitTimeAtStation = 0;


    //Constructor
    public TrainDataVolatile(EventBus localBus){
        this.currentBreakingPower = BreakingPowerCurveCalculator.calculateBreakingPower(localBus);
        this.currentEmergencyBreakingPower = BreakingPowerCurveCalculator.calculateEmergencyBreakingPower(localBus);
        this.currentAcceleratingPower = AccelerationPowerCurveCalculator.calculate(localBus);
        this.currentResistanceCurve = ResistanceCurveCalculator.calculate(localBus);
    }

    /**
     * only for testing!
     * @param currentPosition
     * @param currentSpeed
     * @param currentTargetSpeed
     * @param m_MODE
     * @param previousLocations
     * @param currentBreakingMode
     * @param currentBreakingPower
     * @param currentAcceleratingPower
     * @param currentResistanceCurve
     * @param availableAcceleration
     */
    @SuppressWarnings({"JavaDoc", "ConstantConditions"})
    public TrainDataVolatile(@Nullable Position currentPosition, @Nullable Double currentSpeed, @Nullable Double currentTargetSpeed, @Nullable Integer m_MODE,
                             @Nullable List<Location> previousLocations, @Nullable String currentBreakingMode, @Nullable ForwardSpline currentBreakingPower,
                             @Nullable ForwardSpline currentAcceleratingPower, @Nullable ForwardSpline currentResistanceCurve,
                             @Nullable AvailableAcceleration availableAcceleration) {
        if(!ConfigHandler.getInstance().useTrainConfiguratorTool){
            throw new RuntimeException("This Constructor is only for use in tests");
        }

        this.currentPosition = currentPosition;
        this.currentSpeed = currentSpeed;
        this.currentTargetSpeed = currentTargetSpeed;
        M_MODE = m_MODE;
        this.previousLocations = previousLocations;
        this.currentBreakingMode = currentBreakingMode;
        this.currentBreakingPower = currentBreakingPower;
        this.currentAcceleratingPower = currentAcceleratingPower;
        this.currentResistanceCurve = currentResistanceCurve;
        this.availableAcceleration = availableAcceleration;
    }

    //Getter and setter

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
     * @return current speed in [m/s]
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
     * The current emergency max speed of the train in [m/s] based on the
     * emergency deceleration curve
     * Updated from the speed supervision module
     */
    public double getCurrentEmergencySpeed() {
        return currentEmergencySpeed;
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
    public double getCurrentServiceWarningSpeed() {
        return currentServiceWarningSpeed;
    }

    /**
     * The current service permitted speed speed of the train in [m/s] based on
     * the service permitted speed curve
     * Updated from the speed supervision module
     */
    public double getCurrentServicePermittedSpeed() {
        return currentServicePermittedSpeed;
    }

    /**
     * The current service indication speed of the train in [m/s] based on
     * the service indication curve
     * Updated from the speed supervision module
     */
    public double getCurrentServiceIndicationSpeed() {
        return currentServiceIndicationSpeed;
    }

    /**
     * @return current maximum allowed speed in [m/s]
     */
    @NotNull
    public Double getCurrentTargetSpeed() {
        return currentTargetSpeed;
    }

    @Nullable
    public Integer getM_MODE() {
        return M_MODE;
    }

    @Nullable
    public List<Location> getPreviousLocations() {
        return previousLocations;
    }

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
     * @return wait time at stations in [s]
     */
    public int getWaitTimeAtStation(){
        return waitTimeAtStation;
    }
}
