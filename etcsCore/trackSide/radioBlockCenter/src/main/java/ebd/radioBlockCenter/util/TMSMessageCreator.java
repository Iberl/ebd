package ebd.radioBlockCenter.util;

import ebd.messageLibrary.message.trainmessages.Message_132;
import ebd.messageLibrary.packet.trainpackets.Packet_1;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.rbc_tms.util.PositionInfo;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class TMSMessageCreator {

	public static PositionInfo createPositionInfo(PositionPacket positionPacket) {
		return new PositionInfo(
				positionPacket.Q_SCALE,
				positionPacket.NID_LRBG,
				(positionPacket instanceof Packet_1) ? ((Packet_1) positionPacket).NID_PRVLRBG : null,
				positionPacket.D_LRBG,
				positionPacket.Q_DIRLRBG,
				positionPacket.Q_DLRBG,
				positionPacket.L_DOUBTOVER,
				positionPacket.L_DOUBTUNDER,
				positionPacket.Q_LENGTH,
				(positionPacket.Q_LENGTH == Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE || positionPacket.Q_LENGTH == Q_LENGTH_CONFIRMED_BY_DRIVER) ? positionPacket.L_TRAININT : null,
				positionPacket.V_TRAIN,
				positionPacket.Q_DIRTRAIN,
				positionPacket.M_MODE,
				positionPacket.M_LEVEL,
				(positionPacket.M_LEVEL == M_LEVEL_NTC) ? positionPacket.NID_NTC : null
		);
	}


}
