package ebd.globalUtils.appTime;

import ebd.globalUtils.configHandler.ConfigHandler;

public class AppTime {
    static ConfigHandler ch;
    static {
        ch = ConfigHandler.getInstance();
    }

    static public long currentTimeMillis(){
        return (long)(System.currentTimeMillis() * ch.timeAccFactor);
    }

    static public long nanoTime(){
        return (long)(System.nanoTime() * ch.timeAccFactor);
    }
}
