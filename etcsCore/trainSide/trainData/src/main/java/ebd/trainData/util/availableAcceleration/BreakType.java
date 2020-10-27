package ebd.trainData.util.availableAcceleration;

public enum BreakType {

    G("G", 0),

    P("P", 1),

    P_E("P+E", 1),

    P_MG("P+MG", 1),

    R("R", 2),

    R_E("R+E", 2),

    R_MG("R+MG", 2),

    R_WB("R+WB", 2),

    BREAK_CALCULATOR("bremsrechner", 2);

    private final String descriptor;
    private final int group;

    BreakType(String descriptor, int group){
        this.descriptor = descriptor;
        this.group = group;
    }

    public String getDescriptor(){
        return this.descriptor;
    }

    /**
     * @return Group ID (0 == g break, 1 == p break, 2 == r break)
     */
    public int getGroup() {
        return group;
    }
}
