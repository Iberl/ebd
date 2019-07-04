package ebd.trainData.util.dataConstructs;

public class Breakmethod {

    private String name;

    /**
     * Breakweight in [kg]
     */
    private int breakweight;

    /**
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
     *
     * @return breakweight in [kg]
     */
    public int getBreakweight() {
        return breakweight;
    }
}
