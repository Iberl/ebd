package ebd.trainData.util.dataConstructs;

/**
 * Represents a break system. A breaking system has minimum and maximum speed at which it can be used.
 * All speeds are in [km/h] / 5.
 */
public class Breaksystem {

    private String name;

    /*
    Minimum speed in [km/h]
     */
    private int minSpeed;

    /*
    Maximum speed in [km/h]
     */
    private int maxSpeed;

    /**
     * Constructor setting a break system.
     *
     * @param name The name of the breaksystem
     *
     * @param minSpeed The minimum speed of the breaksystem in [km/h]
     *
     * @param maxSpeed The maximum speed of the breaksystem in [km/h]
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
     * @return The minimum speed of the breaksystem in [km/h]
     */
    public int getMinSpeed() {
        return minSpeed;
    }

    /**
     *
     * @return The maximum speed of the breaksystem in [km/h]
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }
}
