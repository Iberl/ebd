package ebd.radioBlockCenter.util;

import ebd.messageLibrary.packet.trackpackets.*;
import ebd.rbc_tms.util.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class ETCSPacketCreator {

	public static <T> T coalesce(T value, T defaultValue) {
		return value != null ? value : defaultValue;
	}

	public static int coalesce(Integer value, Integer defaultValue) {
		return value != null ? value : defaultValue;
	}

	public static long coalesce(Long value, Long defaultValue) {
		return value != null ? value : defaultValue;
	}

	public static Packet_5 createPacket_5(int Q_DIR, int Q_SCALE, @NotNull LinkingProfile linkingProfile) {
		if(linkingProfile.links.isEmpty())
			throw new IllegalArgumentException("The given linking information has no links.");

		List<Packet_5.Packet_5_Link> links = new ArrayList<>();

		for(LinkingProfile.Link link : linkingProfile.links) {
			links.add(new Packet_5.Packet_5_Link(
					link.d_link,
					(link.nid_c != null),
					coalesce(link.nid_c, ETCSVariables.NID_C),
					link.nid_bg, link.q_linkorientation,
					link.q_linkreaction,
					link.q_locacc));
		}

		Packet_5 packet_5 = new Packet_5(coalesce(linkingProfile.q_dir, Q_DIR), coalesce(linkingProfile.q_scale, Q_SCALE), links.remove(0));

		packet_5.links = links;

		return packet_5;
	}

	public static Packet_15 createPacket_15(int Q_DIR, int Q_SCALE, @NotNull EOA eoa) {
		if(eoa.sections.isEmpty()) throw new IllegalArgumentException("The given EOA has no sections");

		List<Packet_15.Packet_15_Section> sections = new ArrayList<>();

		for(EOA.Section section : eoa.sections) {
			//TODO if q_sectiontimer true and t_sectiontimer/d_sectiontimerstoploc null then throw error
			sections.add(new Packet_15.Packet_15_Section(section.l_section,
					section.q_sectiontimer,
					section.t_sectiontimer == null ? 0 : section.t_sectiontimer,
					section.d_sectiontimerstoploc == null ? 0 : section.d_sectiontimerstoploc));
		}

		EOA.EndTimer endTimer = eoa.endTimer;
		EOA.DangerPoint dangerPoint = eoa.dangerPoint;
		EOA.Overlap overlap = eoa.overlap;

		Packet_15 packet_15 = new Packet_15(
				coalesce(eoa.q_dir, Q_DIR),
				coalesce(eoa.q_scale, Q_SCALE),
				eoa.v_loa,
				eoa.t_loa,
				sections.remove(sections.size() - 1),
				(endTimer != null),
				coalesce((endTimer != null ? endTimer.t_endtimer : null), ETCSVariables.T_ENDTIMER),
				coalesce((endTimer != null ? endTimer.d_endtimerstartloc : null), ETCSVariables.D_ENDTIMERSTARTLOC),
				(dangerPoint != null),
				coalesce((dangerPoint != null ? dangerPoint.d_dp : null), ETCSVariables.D_DP),
				coalesce((dangerPoint != null ? dangerPoint.v_releasedp : null), ETCSVariables.V_RELEASEDP),
				(overlap != null),
				coalesce((overlap != null ? overlap.d_startol : null), ETCSVariables.D_STARTOL),
				coalesce((overlap != null ? overlap.t_ol : null), ETCSVariables.T_OL),
				coalesce((overlap != null ? overlap.d_ol : null), ETCSVariables.D_OL),
				coalesce((overlap != null ? overlap.v_releaseol : null), ETCSVariables.V_RELEASEOL));

		packet_15.sections = sections;

		return packet_15;
	}

	public static Packet_21 createPacket_21(int Q_DIR, int Q_SCALE, @NotNull GradientProfile gradientProfile) {
		if(gradientProfile.gradients.isEmpty())
			throw new IllegalArgumentException("The given gradient profile has no gradients.");

		List<Packet_21.Packet_21_Gradient> gradients = new ArrayList<>();

		for(GradientProfile.Gradient gradient : gradientProfile.gradients) {
			gradients.add(new Packet_21.Packet_21_Gradient(gradient.d_gradient, gradient.q_gdir, gradient.g_a));
		}

		Packet_21 packet_21 = new Packet_21(coalesce(gradientProfile.q_dir, Q_DIR), coalesce(gradientProfile.q_scale, Q_SCALE), gradients.remove(0));

		packet_21.gradients = gradients;

		return packet_21;
	}

	public static Packet_27 createPacket_27(int Q_DIR, int Q_SCALE, @NotNull SpeedProfile speedProfile) {
		if(speedProfile.sections.isEmpty())
			throw new IllegalArgumentException("The given speed profile has no sections.");

		List<Packet_27.Packet_27_Section> sections = new ArrayList<>();

		for(SpeedProfile.Section section : speedProfile.sections) {
/*			if(section.categories.isEmpty())
				throw new IllegalArgumentException("A section in the given speed profile has no categories.");*/

			List<Packet_27.Packet_27_Category> categories = new ArrayList<>();

			for(SpeedProfile.Section.Category category : section.categories) {
				categories.add(new Packet_27.Packet_27_Category(category.q_diff, category.nc_cddiff, category.nc_diff, category.v_diff));
			}

			Packet_27.Packet_27_Section newSection = new Packet_27.Packet_27_Section(section.d_static, section.v_static, section.q_front);

			newSection.categories = categories;

			sections.add(newSection);
		}

		Packet_27 packet_27 = new Packet_27(coalesce(speedProfile.q_dir, Q_DIR), coalesce(speedProfile.q_scale, Q_SCALE), sections.remove(0));

		packet_27.sections = sections;

		return packet_27;
	}

	/**
	 * Shortcut
	 */
	public static Packet_57 createPacket_57(int T_MAR) {
		return new Packet_57(Q_DIR_NOMINAL, T_MAR, T_TIMEOUTRQST_INFINITY, T_CYCRQST_INFINITY);
	}

	/**
	 * Shortcut
	 */
	public static Packet_58 createPacket_58() {
		return new Packet_58(Q_DIR_NOMINAL, Q_SCALE_1M, 10, 0, M_LOC_NOT_AT_BALISE_GROUP);
	}

	public static Packet_80 createPacket_80(int Q_DIR, int Q_SCALE, @NotNull ModeProfile modeProfile) {
		if(modeProfile.modes.isEmpty())
			throw new IllegalArgumentException("The given mode profile has no profile.");

		List<Packet_80.Packet_80_MAMode> modes = new ArrayList<>();

		for(ModeProfile.Mode mode : modeProfile.modes) {
			modes.add(new Packet_80.Packet_80_MAMode(mode.d_mamode, mode.m_mamode, mode.v_mamode, mode.l_mamode, mode.l_ackmamode, mode.q_mamode));
		}

		Packet_80 packet_80 = new Packet_80(coalesce(modeProfile.q_dir, Q_DIR), coalesce(modeProfile.q_scale, Q_SCALE), modes.remove(0));

		packet_80.modes = modes;

		return packet_80;
	}

}
