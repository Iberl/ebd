package ebd.trainData;

import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
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

    //Getter and setter

    public Position getCurrentPosition() {
        return currentPosition;
    }

    protected void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    protected void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getM_MODE() {
        return M_MODE;
    }

    protected void setM_MODE(int m_MODE) {
        M_MODE = m_MODE;
    }

    public List<Location> getPreviousLocations() {
        return previousLocations;
    }

    protected void setPreviousLocations(List<Location> previousLocations) {
        this.previousLocations = previousLocations;
    }

    public String getCurrentBreakingMode() {
        return currentBreakingMode;
    }

    protected void setCurrentBreakingMode(String currentBreakingMode) {
        this.currentBreakingMode = currentBreakingMode;
    }

    public ForwardSpline getCurrentBreakingPower() {
        return currentBreakingPower;
    }

    protected void setCurrentBreakingPower(ForwardSpline currentBreakingPower) {
        this.currentBreakingPower = currentBreakingPower;
    }
}
