package ebd.trainData;

import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;

import java.util.List;

/**
 * @author Lars Schulze-Falck
 */
public class TrainDataVolatile {


    /**
     * The current {@link Position}
     */
    protected volatile Position currentPosition;

    /**
     * The current speed of the train in [m/s]
     */
    protected volatile double currentSpeed;

    /**
     * The current {@link ebd.messageLibrary.util.ETCSVariables#M_MODE}
     */
    protected volatile int M_MODE;

    /**
     * All locations that where crossed in order (last entry == last crossed location)
     */
    protected volatile List<Location> previousLocations;

    /**
     * The current breaking mode
     */
    protected volatile String currentBreakingMode;

    /**
     * The current breaking power
     */
    protected volatile ForwardSpline currentBreakingPower;

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
