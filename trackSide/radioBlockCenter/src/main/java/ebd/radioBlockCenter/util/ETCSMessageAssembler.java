package ebd.radioBlockCenter.util;

import ebd.globalUtils.appTime.AppTime;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.message.trackmessages.Message_3;
import ebd.messageLibrary.message.trackmessages.Message_33;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.rbc_tms.util.*;

import java.util.ArrayList;
import java.util.List;

import static ebd.radioBlockCenter.util.ETCSPacketCreator.*;

public class ETCSMessageAssembler {

	public static Message_3 assembleMessage_3(boolean M_ACK, int NID_LRBG, int Q_DIR, int Q_SCALE, EOA eoa, SpeedProfile speedProfile, GradientProfile gradientProfile, LinkingProfile linkingProfile, ModeProfile modeProfile) {
		Message_3 message_3 = new Message_3(etcsFormattedTimeStamp(AppTime.currentTimeMillis()), M_ACK, NID_LRBG, createPacket_15(Q_DIR, Q_SCALE, eoa));

		List<TrackPacket> packets = listOptionalMAProfiles(Q_DIR, Q_SCALE, speedProfile, gradientProfile, linkingProfile, modeProfile);

		return message_3;
	}

	public static Message_24 assembleMessage_24(boolean M_ACK, int NID_LRBG, List<TrackPacket> packets) {
		Message_24 message_24 = new Message_24(etcsFormattedTimeStamp(AppTime.currentTimeMillis()), M_ACK, NID_LRBG);

		message_24.packets.addAll(packets);

		return message_24;
	}


	public static Message_33 assembleMessage_33(boolean M_ACK, int NID_LRBG, int Q_DIR, int Q_SCALE, int D_REF, EOA eoa, SpeedProfile speedProfile, GradientProfile gradientProfile, LinkingProfile linkingProfile, ModeProfile modeProfile) {
		Message_33 message_33 = new Message_33(etcsFormattedTimeStamp(AppTime.currentTimeMillis()), M_ACK, NID_LRBG, Q_SCALE, D_REF, createPacket_15(Q_DIR, Q_SCALE, eoa));

		List<TrackPacket> packets = listOptionalMAProfiles(Q_DIR, Q_SCALE, speedProfile, gradientProfile, linkingProfile, modeProfile);

		message_33.packets.addAll(packets);

		return message_33;
	}


	// Helper Functions

	private static List<TrackPacket> listOptionalMAProfiles(int Q_DIR, int Q_SCALE, SpeedProfile speedProfile, GradientProfile gradientProfile, LinkingProfile linkingProfile, ModeProfile modeProfile) {
		List<TrackPacket> packets = new ArrayList<>();

		if(speedProfile != null) {
			packets.add(createPacket_27(Q_DIR, Q_SCALE, speedProfile));
		}
		if(gradientProfile != null) {
			packets.add(createPacket_21(Q_DIR, Q_SCALE, gradientProfile));
		}
		if(linkingProfile != null) {
			packets.add(createPacket_5(Q_DIR, Q_SCALE, linkingProfile));
		}
		if(modeProfile != null) {
			packets.add(createPacket_80(Q_DIR, Q_SCALE, modeProfile));
		}

		return packets;
	}

	public static long etcsFormattedTimeStamp(long milliseconds) {
		return (milliseconds / 10) & 0x00000000ffffffffL;
	}
}
