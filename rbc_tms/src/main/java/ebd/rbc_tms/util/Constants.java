package ebd.rbc_tms.util;

/**
 * Collection Of Useful Constants
 *
 * @author Christopher Bernjus
 */
public class Constants {

    public static final boolean debug = false;

    public static final int INT_NO_VALUE = -1;
    public static final long LONG_NO_VALUE = -1L;

    public static final String ID_PREFIX_RBC = "rbc_";
    public static final String ID_PREFIX_TMS = "tms_";
    public static final String ID_ALL = "all";


    // Versions

    public static final String VERSION_CURRENT = "1.0";


    // General Message Types

    public static final int MSG_ERROR = 0;

    public static final int MSG_REGISTER = 1;

    public static final int MSG_UNREGISTER = 2;


    // RBC Message Types

    public static final int MSG_LOGIN = 10;

    public static final int MSG_LOGOUT = 11;

    public static final int MSG_TIME_CHANGE = 12;

    public static final int MSG_TRAIN_DATA = 13;

    public static final int MSG_POSITION_REPORT = 14;

    public static final int MSG_MA_REQUEST = 15;

    public static final int MSG_SH_REQUEST = 16;


    // TMS Message Types

    public static final int MSG_POSITION_REPORT_REQUEST = 20;

    public static final int MSG_MA = 21;

    public static final int MSG_REQUEST_TO_SHORTEN_MA = 22;

    public static final int MSG_CONDITIONAL_EMERGENCY_STOP = 23;

    public static final int MSG_UNCONDITIONAL_EMERGENCY_STOP = 24;

    public static final int MSG_REVOCATION_OF_EMERGENCY_STOP = 25;


    // General Errors

    public static final int ERR_ACCEPTED = 0;

    public static final int ERR_REJECTED = 1;

    public static final int ERR_INVALID_MESSAGE = 2;

    public static final int ERR_UNMANAGED_TRAIN_NUMBER = 3;

    public static final int ERR_UNKNOWN = 4;


    // RBC Errors

    public static final int ERR_CONNECTION = 10;

}
