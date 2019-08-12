package ebd.breakingCurveCalculator.utils;

import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_15;

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
		if (p15.sections.size() > 0) {
			
			for (Packet_15.Packet_15_Section section : p15.sections) {
				d_ema += section.L_SECTION;
			}
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
		
		double offset = newRefPos.totalDistanceToPreviousPosition(oldrefPos);
		
		/*
		 * Return the distance to the end of the movement Authority modified by Q_SCALE
		 */
		return offset + (d_ema * Math.pow(10, p15.Q_SCALE - 1));
	}
}
