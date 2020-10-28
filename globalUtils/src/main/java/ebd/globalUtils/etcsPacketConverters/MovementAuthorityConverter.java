package ebd.globalUtils.etcsPacketConverters;

import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * Converts a {@link Packet_15} into a double value representing the total distance to the End of Authority.<br>
 * The MA data is treated as continuous profile data, because, while it has a possible overlap value, this value
 * can only appear in the last section and has a different functionality compared to the overlap value in
 * non continuous profile data.<br>
 *
 * @author Lars Schulze-Falck
 *
 */
public class MovementAuthorityConverter {

    /**
     * Converts a {@link Packet_15} into a double value representing the total distance to the End of Authority.
     * Ignores Dangerpoint and Overlap
     *
     * @param p15
     * 		{@link Packet_15}
     * @return
     *		Distance to end or limit of movement authority in [m]
     * @author Lars Schulze-Falck
     */

    public static double p15ToD_EMA(Packet_15 p15) {

        double d_ema = p15.endsection.L_SECTION;

        /*
         * Iterate through the entire package to add up all the individual lengths
         */

        for (Packet_15.Packet_15_Section section : p15.sections) {
            d_ema += section.L_SECTION;
        }

        /*
         * Return the distance to the end of the movement Authority modified by Q_SCALE
         */
        return d_ema * Math.pow(10, p15.Q_SCALE - 1);
    }

    /**
     * Converts a {@link Packet_15} into a double value representing the total distance to the End of Movement Authority. Adds the offset produced by a shifted location reference
     * Ignores Dangerpoint and Overlap
     *
     * @param p15 {@link Packet_15}
     *
     * @return Distance to the End of Movement Authority
     *
     * @author Lars Schulze-Falck
     */
    public static double p15ToD_EMAwithShiftedLocation(Packet_15 p15, Position oldrefPos, Position newRefPos) {
        double d_ema = p15.endsection.L_SECTION;

        /*
         * Iterate through the entire package to add up all the individual lengths
         */
        if (p15.sections.size() > 0) {

            for (Packet_15.Packet_15_Section section : p15.sections) {
                d_ema += section.L_SECTION;
            }
        }

        /*
         * Get the offset from the old reference location
         */

        double offset = newRefPos.estimatedDistanceToPreviousPosition(oldrefPos);

        /*
         * Return the distance to the end of the movement Authority modified by Q_SCALE
         */
        return offset + (d_ema * Math.pow(10, p15.Q_SCALE - 1));
    }

    public static double p15GetDangerPointDistance(Packet_15 p15){
        if(p15.Q_DANGERPOINT == ETCSVariables.Q_DANGERPOINT_NO_INFO){
            return 0;
        }
        return p15.D_DP * Math.pow(10, p15.Q_SCALE - 1);
    }

    /**
     * @param p15 A {@link Packet_15}
     * @return The danger point release speed in m/s or 0 if there is no such value.
     */
    public static double p15GetDangerPointReleaseSpeed(Packet_15 p15){
        if(p15.Q_OVERLAP == ETCSVariables.Q_OVERLAP_NO_INFO){
            return 0;
        }
        return p15.V_RELEASEDP * 5 / 3.6;
    }

    /**
     * @param p15 A {@link Packet_15}
     * @return The overlap distance in [m] or 0 if there is no overlap
     */
    public static double p15GetOverlapDistance(Packet_15 p15){
        if(p15.Q_OVERLAP == ETCSVariables.Q_OVERLAP_NO_INFO){
            return 0;
        }
        return p15.D_OL * Math.pow(10, p15.Q_SCALE - 1);
    }

    /**
     * @param p15 A {@link Packet_15}
     * @return The distance to EOA in [m] at which the overlap timer starts or 0 if there is no such distance.
     */
    public static double p15GetStartTimerDistance(Packet_15 p15){
        if(p15.Q_OVERLAP == ETCSVariables.Q_OVERLAP_NO_INFO){
            return 0;
        }
        return p15.D_STARTOL * Math.pow(10, p15.Q_SCALE - 1);
    }

    /**
     * @param p15 A {@link Packet_15}
     * @return The time from crossing D_STARTOL until the overlap is no longer valid in [s]. <br>
     *     Returns if there is no such value or Double.MAX_VALUE if the time is infinit.
     */
    public static double p15GetOverlapTime(Packet_15 p15){
        if(p15.Q_OVERLAP == ETCSVariables.Q_OVERLAP_NO_INFO){
            return 0;
        }
        else if(p15.T_OL == ETCSVariables.T_OL_INFINITY){
            return Double.MAX_VALUE;
        }
        return p15.T_OL;
    }

    /**
     * @param p15 A {@link Packet_15}
     * @return The overlap release speed in m/s or 0 if there is no such value.
     */
    public static double p15GetOverlapReleaseSpeed(Packet_15 p15){
        if(p15.Q_OVERLAP == ETCSVariables.Q_OVERLAP_NO_INFO){
            return 0;
        }
        return p15.V_RELEASEOL * 5 / 3.6;
    }
}
