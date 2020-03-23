package ebd.globalUtils.appTime;

import ebd.globalUtils.configHandler.ConfigHandler;

/**
 * This class provides the AppTime which is derived from real time by using a factor defined in the config file.
 * This makes is possible to accelerate and decelerate time to allow for more control over the simulation.
 * Every place that does not explicitly needs real time should use the AppTime.
 */
public class AppTime {
    static ConfigHandler ch;
    static {
        ch = ConfigHandler.getInstance();
    }

    /**
     * see {@link System#currentTimeMillis()}
     * @return System.currentTimeMillis() * factor
     */
    static public long currentTimeMillis(){
        return (long)(System.currentTimeMillis() * ch.timeAccFactor);
    }

    /**
     * see {@link System#nanoTime()}
     * @return System.nanoTime() * factor
     */
    static public long nanoTime(){
        return (long)(System.nanoTime() * ch.timeAccFactor);
    }

    /**
     * see {@link Thread#sleep(long)}
     * @param milliSeconds Will sleep for milliSeconds / factor
     * @throws InterruptedException see {@link Thread#sleep(long)}
     */
    static public void sleep(long milliSeconds) throws InterruptedException {
        Thread.sleep((long)(milliSeconds / ch.timeAccFactor));
    }
}
