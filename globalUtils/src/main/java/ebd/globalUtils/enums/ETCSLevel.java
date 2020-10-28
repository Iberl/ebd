package ebd.globalUtils.enums;

public enum ETCSLevel {
    /**
     * Null replacement value
     */
    NO_LEVEL(5),

    NTC_PZBLZB(1),

    LEVEL_ZERO(0),

    LEVEL_ONE(2),

    LEVEL_TWO(3),

    LEVEL_THREE(4);

    private final int valueForETCSPacket;

    ETCSLevel(int valueForETCSPacket){
        this.valueForETCSPacket = valueForETCSPacket;
    }

    public int getValueForETCSPacket() { return valueForETCSPacket;}
}
