package ebd.globalUtils.etcsModeAndLevel;

import ebd.messageLibrary.util.ETCSVariables;

public enum ETCSMode {

    /**
     * Null Replacement
     */
    NO_MODE(16),

    /**
     * ETCS Mode SB
     */
    STAND_BY (6),

    /**
     * ETCS Mode FS
     */
    FULL_SUPERVISION(0),

    /**
     * ETCS Mode SH
     */
    SHUNTING(3),
    /**
     * ETCS Mode SF
     */
    SYSTEM_FAILURE(9),

    /**
     * ETCS Mode TR
     */
    TRIP(7),

    /**
     * ETCS Mode PT
     */
    POST_TRIP(8),
    ;

    //Currently not used:

    /**
     * ETCS Mode SN
     */
    //STM_NATIONAL(13),

    /**
     * ETCS Mode NP
     */
    //NO_POWER(17),

    /**
     * ETCS Mode LS
     */
    //LIMITED_SUPERVISION(12),

    /**
     * ETCS Mode SR
     */
    //STAFFE_RESPONSIBLE(2),

    /**
     * ETCS Mode OS
     */
    //ON_SIGHT(1),

    /**
     * ETCS Mode SL
     */
    //SLEEPING(5),

    /**
     * ETCS Mode NL
     */
    //NON_LEADING(11),

    /**
     * ETCS Mode PH
     */
    //PASSIVE_SHUNTING(15),

    /**
     * ETCS Mode UN
     */
    //UNFFITED(4),

    /**
     * ETCS Mode IS
     */
    //ISOLATION(10),

    private final int valueForETCSPacket;

    ETCSMode(int valueForETCSPacket){
        this.valueForETCSPacket = valueForETCSPacket;
    }

    public int getValueForETCSPacket() { return valueForETCSPacket; }
}
