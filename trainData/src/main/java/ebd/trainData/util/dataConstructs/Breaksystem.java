package ebd.trainData.util.dataConstructs;

/**
 * Represents a breaksystem. All speeds are in [km/h] / 5.
 */
public class Breaksystem {

    private String name;

    /*
    Minimum speed in [km/h] / 5 see {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private int minSpeed;

    /*
    Maximum speed in [km/h] / 5 see {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    private int maxSpeed;

    /**
     *
     * @param name The name of the breaksystem
     *
     * @param minSpeed The minimum speed of the breaksystem in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     *
     * @param maxSpeed The maximum speed of the breaksystem in [km/h] / 5. See {@link ebd.messageLibrary.util.ETCSVariables#V_MAXTRAIN}
     */
    public Breaksystem(String name, int minSpeed, int maxSpeed){
        this.name = name;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }


    public String getName() {
        return name;
    }

    /**
     *
     * @return The minimum speed of the breaksystem in [km/h] / 5
     */
    public int getMinSpeed() {
        return minSpeed;
    }

    /**
     *
     * @return The maximum speed of the breaksystem in [km/h] / 5
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }
}
