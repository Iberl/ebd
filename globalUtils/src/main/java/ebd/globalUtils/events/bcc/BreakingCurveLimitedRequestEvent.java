package ebd.globalUtils.events.bcc;


import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_15;

/**
 * @author Lars Schulze-Falck
 *
 */
public class BreakingCurveLimitedRequestEvent extends NormalEvent {
	
	
	/**
	 * Constructor setting all required fields
	 * @param packet15
	 * 			{@link Packet_15}
	 * @param referencePosition
	 * 			Reference {@link Position} to the data
	 */
	public BreakingCurveLimitedRequestEvent(String source, String target, String id, Packet_15 packet15, Position referencePosition) {
		super(source, target);
		this.id = id;
		this.packet15 = packet15;
		this.referencePosition = referencePosition;
	}
	
	/**
	 * ID of the resulting breaking curve
	 */
	public String id = "No ID";																		
	
	//Information for BCC
	/**
	 * Movement Authority Packet {@link Packet_15}
	 */
	public Packet_15 packet15;
	
	
	/**
	 * Reference {@link Position} to the data
	 */
	public Position referencePosition; 
}
