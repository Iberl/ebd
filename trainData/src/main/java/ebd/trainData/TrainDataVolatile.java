package ebd.trainData;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.trainData.util.availableAcceleration.AvailableAcceleration;
import org.greenrobot.eventbus.EventBus;
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
     * The current speed of the train in [m/s]
     */
    @Nullable
    protected volatile Double currentSpeed = null;

    /**
     * The current maximum allowed speed of the train in [m/s]
     */
    @Nullable
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
    @Nullable
    protected volatile ForwardSpline currentBreakingPower = null;

    /**
     * The current accelerating power curve a(v), a in [m/(s^2)], v in [m/s]
     */
    @Nullable
    protected volatile ForwardSpline currentAcceleratingPower = null;

    /**
     * The current resistance curve r(v), r in [m/(s^2)], v in [m/s]
     */
    @Nullable
    protected volatile ForwardSpline currentResistanceCurve = null;


    @Nullable
    protected volatile AvailableAcceleration availableAcceleration = null;


    //Constructor
    public TrainDataVolatile(){}

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
}
