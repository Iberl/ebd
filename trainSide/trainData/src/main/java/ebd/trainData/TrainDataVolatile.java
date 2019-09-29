package ebd.trainData;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.trainData.util.availableAcceleration.AccelerationPowerCurveCalculator;
import ebd.trainData.util.availableAcceleration.AvailableAcceleration;
import ebd.trainData.util.availableAcceleration.BreakingPowerCurveCalculator;
import ebd.trainData.util.availableAcceleration.ResistanceCurveCalculator;
import ebd.trainData.util.dataConstructs.IncrementalPositionReportDistances;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
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
    @NotNull
    protected volatile double curTripDistance = 0d;

    /**
     * Time since the trip started in [s]
     */
    @NotNull
    protected volatile double curTripTime = 0d;

    /**
     * The current speed of the train in [m/s]
     */
    @NotNull
    protected volatile Double currentSpeed = 0d;

    /**
     * The current maximum allowed speed of the train in [m/s]
     */
    @NotNull
    protected volatile Double currentMaxSpeed = 0d;


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
    @NotNull
    protected volatile int T_MAR = ETCSVariables.T_MAR;

    /**
     * {@link ETCSVariables#T_TIMEOUTRQST} in [s]
     * Do not trigger if equal to {@link ETCSVariables#T_TIMEOUTRQST_INFINITY}
     */
    @NotNull
    protected volatile int T_TIMEOUTRQST = ETCSVariables.T_TIMEOUTRQST;

    /**
     * {@link ETCSVariables#T_CYCRQST} in [s]
     * Do not trigger if equal to {@link ETCSVariables#T_CYCRQST_INFINITY}
     */
    @NotNull
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
    @NotNull
    protected volatile int T_CYCLOC = ETCSVariables.T_CYCLOC;

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#D_CYCLOC} in [m]
     * Do not cycle with distance if equal to {@link Double#MAX_VALUE} or
     * {@link ETCSVariables#INTEGER_NOVALUE}
     */
    @NotNull
    protected volatile double distanceCycleLocation = ETCSVariables.D_CYCLOC;

    /**
     * {@link ebd.messageLibrary.util.ETCSVariables#M_LOC}
     */
    @NotNull
    protected volatile int M_LOC = ETCSVariables.M_LOC;

    /**
     * {@link IncrementalPositionReportDistances}
     */
    @Nullable
    protected volatile IncrementalPositionReportDistances incrementalPositionReportDistances = null;



    //Constructor
    public TrainDataVolatile(EventBus localBus){
        this.currentBreakingPower = BreakingPowerCurveCalculator.calculateBreakingPower(localBus);
        this.currentAcceleratingPower = AccelerationPowerCurveCalculator.calculate(localBus);
        this.currentResistanceCurve = ResistanceCurveCalculator.calculate(localBus);
    }

    /**
     * only for testing!
     * @param currentPosition
     * @param currentSpeed
     * @param currentMaxSpeed
     * @param m_MODE
     * @param previousLocations
     * @param currentBreakingMode
     * @param currentBreakingPower
     * @param currentAcceleratingPower
     * @param currentResistanceCurve
     * @param availableAcceleration
     */
    public TrainDataVolatile(@Nullable Position currentPosition, @Nullable Double currentSpeed, @Nullable Double currentMaxSpeed, @Nullable Integer m_MODE,
                             @Nullable List<Location> previousLocations, @Nullable String currentBreakingMode, @Nullable ForwardSpline currentBreakingPower,
                             @Nullable ForwardSpline currentAcceleratingPower, @Nullable ForwardSpline currentResistanceCurve,
                             @Nullable AvailableAcceleration availableAcceleration) {

        NoSuchMethodException noSuchMethodException = new NoSuchMethodException("This Constructor is only for use in tests");
        ExceptionEvent exceptionEvent = new ExceptionEvent("TD", Arrays.asList(new String[]{"all"}), new NotCausedByAEvent(),noSuchMethodException, ExceptionEventTyp.WARNING);
        EventBus.getDefault().post(exceptionEvent);

        this.currentPosition = currentPosition;
        this.currentSpeed = currentSpeed;
        this.currentMaxSpeed = currentMaxSpeed;
        M_MODE = m_MODE;
        this.previousLocations = previousLocations;
        this.currentBreakingMode = currentBreakingMode;
        this.currentBreakingPower = currentBreakingPower;
        this.currentAcceleratingPower = currentAcceleratingPower;
        this.currentResistanceCurve = currentResistanceCurve;
        this.availableAcceleration = availableAcceleration;
    }

    //Getter and setter

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
     * @return current speed in [m/s]
     */
    public Double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return current maximum allowed speed in [m/s]
     */
    public Double getCurrentMaxSpeed() {
        return currentMaxSpeed;
    }

    public int getM_MODE() {
        return M_MODE;
    }

    public List<Location> getPreviousLocations() {
        return previousLocations;
    }

    public String getCurrentBreakingMode() {
        return currentBreakingMode;
    }

    /**
     * @return The current breaking power b(v), b in [m/(s^2)], v in [m/s]
     */
    public ForwardSpline getCurrentBreakingPower() {
        return currentBreakingPower;
    }

    /**
     * @return The current accelerating power curve a(v), a in [m/(s^2)], v in [m/s]
     */
    public ForwardSpline getCurrentAcceleratingPower() {
        return currentAcceleratingPower;
    }

    /**
     * @return The current resistance curve r(v), r in [m/(s^2)], v in [m/s]
     */
    public ForwardSpline getCurrentResistanceCurve() {
        return currentResistanceCurve;
    }

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
     * {@link IncrementalPositionReportDistances}
     */
    public IncrementalPositionReportDistances getIncrementalPositionReportDistances() {
        return incrementalPositionReportDistances;
    }
}
