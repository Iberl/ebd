package ebd.trainData.util.dataConstructs;

/**
 * This class represents a Breaking Method. Every breaking method has different break weights, break weight measures the abillity to break.
 */
public class Breakmethod {

    private String name;

    /**
     * Breakweight in [kg]
     */
    private int breakweight;

    /**
     * Constructor to set the breaking method.
     *
     * @param name Name of the breakmethod
     *
     * @param breakweight Breakweight of the method in [kg]
     */
    public Breakmethod(String name, int breakweight){

        this.name = name;
        this.breakweight = breakweight;
    }

    public String getName() {
        return name;
    }

    /**
     * @return breakweight in [kg]
     */
    public int getBreakweight() {
        return breakweight;
    }
}
