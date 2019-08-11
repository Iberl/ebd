package ebd.trainData;

import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.ForwardSpline;
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
     * The current breaking power
     */
    @Nullable
    protected volatile ForwardSpline currentBreakingPower = null;


    //Constructor
    public TrainDataVolatile(){}

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

    public ForwardSpline getCurrentBreakingPower() {
        return currentBreakingPower;
    }

}
