package ebd.globalUtils.appTime;

import ebd.globalUtils.configHandler.ConfigHandler;

/**
 * This class provides the AppTime which is derived from real time by using a factor and a
 * pretended base time, both defined in the config file.
 * This makes is possible to accelerate and decelerate time to allow for more control over the simulation.
 * Every place that does not explicitly needs real time should use the AppTime.
 */
public class AppTime {

    private static ConfigHandler ch;
    private static double timeAccFactor;
    private static final long pretendTimeBaseMilli; //in ms
    private static final long actualTimeBaseMili; //in ms
    static {
        ch = ConfigHandler.getInstance();
        timeAccFactor = ch.timeAccFactor;
        pretendTimeBaseMilli = ch.timeBase;
        actualTimeBaseMili = System.currentTimeMillis();
    }

    /**
     * Returns a time in milliseconds since epoch based on configurable base time (see {@link ConfigHandler#timeBase},
     * and a configurable factor (see {@link ConfigHandler#timeAccFactor}).<br>
     * A Date calculated from this value will be the correct simulated Date of the simulated train or rbc.<br>
     * Example: If the pretended base time is 1000 ms and the simulation has run for 10 real ms with a timeAccFactor
     * of 2, this function will return 1020 ms.
     * @return pretended current time in ms since epoch
     */
    public static long currentTimeMillis(){
        return (long)(pretendTimeBaseMilli + (System.currentTimeMillis() - actualTimeBaseMili) * ch.timeAccFactor);
    }

    /**
     * Changes unit of {@link AppTime#currentTimeMillis()} into seconds
     * @return current app time in [s]
     */
    public static double currentTimeInS(){
        return currentTimeMillis() / 1000.0;
    }

    /**
     * see {@link System#nanoTime()}
     * @return System.nanoTime() * {@link ConfigHandler#timeAccFactor}
     */
    public static long nanoTime(){
        return (long)(System.nanoTime() * ch.timeAccFactor);
    }

    /**
     * see {@link Thread#sleep(long)}
     * @param milliSeconds Will sleep for milliSeconds / factor
     * @throws InterruptedException see {@link Thread#sleep(long)}
     */
    public static void sleep(long milliSeconds) throws InterruptedException {
        Thread.sleep((long)(milliSeconds / ch.timeAccFactor));
    }

    /**
     *
     * @return {@link ConfigHandler#timeAccFactor}
     */
    public static double getTimeAccFactor() {
        return timeAccFactor;
    }

    /**
     * @return The milli seconds since epoch defined in {@link ConfigHandler#timeBase} in [ms]
     */
    public static long getPretendTimeBaseMilli() {
        return pretendTimeBaseMilli;
    }

    /**
     * @return The {@link System#currentTimeMillis()} at program start in [ms]
     */
    public static long getActualTimeBaseMili() {
        return actualTimeBaseMili;
    }
}
