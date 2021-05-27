package de.ibw.smart.logic.intf.messages;

import ebd.internal.util.GradientProfile;
import ebd.internal.util.ModeProfile;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.SpeedProfile;
import ebd.messageLibrary.message.Message;
import ebd.messageLibrary.packet.Packet;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.messageLibrary.packet.trackpackets.Packet_80;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import org.glassfish.jaxb.runtime.v2.runtime.reflect.Lister;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;

public class Converter {

    public static final String POSITION_PACKET = "positionPacket";

    public static Packet_21 convertGradientProfile(GradientProfile gradientProfile) throws InvalidParameterException {
        checkGradientProfile(gradientProfile);
        int q_dir = gradientProfile.q_dir  == null ? 1 : gradientProfile.q_dir;
        if(q_dir < 0 || q_dir > 3) throw new InvalidParameterException("q_dir must be between 0-3");
        int q_scale = gradientProfile.q_scale == null ? 1 : gradientProfile.q_scale;
        if(q_scale < 0 || q_scale > 3) throw new InvalidParameterException("q_scale must be between 0-3");
        Packet_21.Packet_21_Gradient FirstGradient = convertGradient(gradientProfile.gradients.get(0));

        Packet_21 GradientResult  = new Packet_21(q_dir, q_scale, FirstGradient);
        for(int i = 1; i < gradientProfile.gradients.size() ; i++) {
            // laesst erstes Ergebnis aus, da bereits in First-Gradient
            GradientResult.gradients.add(convertGradient(gradientProfile.gradients.get(i)));


        }
        return GradientResult;


    }

    private static Packet_21.Packet_21_Gradient convertGradient(GradientProfile.Gradient gradient)
            throws InvalidParameterException {
        if(gradient == null) throw new InvalidParameterException("Gradient must not be null");
        return new Packet_21.Packet_21_Gradient(gradient.d_gradient, gradient.q_gdir, gradient.g_a);
    }

    private static void checkGradientProfile(GradientProfile gradientProfile) throws InvalidParameterException {
        if(gradientProfile == null) throw new InvalidParameterException("Gradient Profile must not be null");
        if(gradientProfile.gradients == null)
            throw new InvalidParameterException("Gradients within Profile must not be null");
        if(gradientProfile.gradients.isEmpty()) throw new InvalidParameterException("Gradients List must not be empty");
    }

    public static Packet_80 convertModeProfile(ModeProfile modeProfile) {
        checkModeProile(modeProfile);
        int q_dir = modeProfile.q_dir  == null ? 1 : modeProfile.q_dir;
        int q_scale = modeProfile.q_scale == null ? 1 : modeProfile.q_scale;

        if(q_dir < 0 || q_dir > 3) throw new InvalidParameterException("q_dir must be between 0-3");
        if(q_scale < 0 || q_scale > 3) throw new InvalidParameterException("q_scale must be between 0-3");

        Packet_80.Packet_80_MAMode FirstMode = convertMode(modeProfile.modes.get(0));


        Packet_80 ModeProfileResult = new Packet_80(q_dir, q_scale, FirstMode );
        for(int i = 1; i < modeProfile.modes.size() ; i++) {
            // laesst erstes Ergebnis aus, da bereits in First-Gradient
            ModeProfileResult.modes.add(convertMode(modeProfile.modes.get(i)));


        }
        return ModeProfileResult;

    }

    private static Packet_80.Packet_80_MAMode convertMode(ModeProfile.Mode mode) {
        return new Packet_80.Packet_80_MAMode(mode.d_mamode, mode.m_mamode, mode.v_mamode, mode.l_mamode,
                mode.l_ackmamode, mode.q_mamode);
    }

    private static void checkModeProile(ModeProfile modeProfile) throws InvalidParameterException {
        if(modeProfile == null) throw new InvalidParameterException("Mode Profile must not be null");
        if(modeProfile.modes == null) throw new InvalidParameterException("Mode-List in Profile must not be null");
        if(modeProfile.modes.isEmpty()) throw new InvalidParameterException("Mode-List must not be empty");
    }

    public static Packet_27 convertSpeedProfile(SpeedProfile speedProfile) {
        checkSpeedProfile(speedProfile);

        int q_dir = speedProfile.q_dir  == null ? 1 : speedProfile.q_dir;
        int q_scale = speedProfile.q_scale == null ? 1 : speedProfile.q_scale;

        if(q_dir < 0 || q_dir > 3) throw new InvalidParameterException("q_dir must be between 0-3");
        if(q_scale < 0 || q_scale > 3) throw new InvalidParameterException("q_scale must be between 0-3");

        Packet_27.Packet_27_Section FirstSpeedSection = convertSpeedSection(speedProfile.sections.get(0));

        Packet_27 ResultSpeedProfile = new Packet_27(q_dir,q_scale, FirstSpeedSection);
        for(int i = 1; i < speedProfile.sections.size() ; i++) {
            // laesst erstes Ergebnis aus, da bereits in First-Gradient
            ResultSpeedProfile.sections.add(convertSpeedSection(speedProfile.sections.get(i)));


        }

        return ResultSpeedProfile;


    }

    private static Packet_27.Packet_27_Section convertSpeedSection(SpeedProfile.Section section)
            throws InvalidParameterException {
        if(section == null) throw new InvalidParameterException("Speed Section must not be null");
        Packet_27.Packet_27_Section ResultSection = new Packet_27.Packet_27_Section(section.d_static,
                section.v_static, section.q_front);
        for(SpeedProfile.Section.Category C : section.categories) {
            ResultSection.categories.add(convertCategory(C));
        }
        return ResultSection;
    }

    private static Packet_27.Packet_27_Category convertCategory(SpeedProfile.Section.Category C)
            throws InvalidParameterException {
        if(C == null) throw  new InvalidParameterException("Category must not be null");
        return new Packet_27.Packet_27_Category(C.q_diff, C.nc_cddiff, C.nc_diff, C.v_diff);
    }

    private static void checkSpeedProfile(SpeedProfile speedProfile) throws InvalidParameterException {
        if(speedProfile == null) throw new InvalidParameterException("Speed profile must not be null");
        if(speedProfile.sections == null) throw new InvalidParameterException("Speed section list must not be null");
        if(speedProfile.sections.isEmpty()) throw new InvalidParameterException("Speed section list must not be empty");

    }

    public static PositionPacket retrievePosPacket(ebd.messageLibrary.message.Message libMessage) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends Object> c = libMessage.getClass();
        Field field = c.getDeclaredField(POSITION_PACKET);
        field.setAccessible(true);
        return (PositionPacket) field.get(libMessage);

    }

    public static PositionInfo generateByPositionPacke(PositionPacket positionReport) {
        PositionInfo PI = new PositionInfo(positionReport.Q_SCALE, positionReport.NID_LRBG, null,
                positionReport.D_LRBG,positionReport.Q_DIRLRBG, positionReport.Q_DLRBG,
                positionReport.L_DOUBTOVER, positionReport.L_DOUBTUNDER, positionReport.Q_LENGTH,
                positionReport.L_TRAININT, positionReport.V_TRAIN, positionReport.Q_DIRTRAIN,
                positionReport.M_MODE, positionReport.M_LEVEL, positionReport.NID_NTC);
        return PI;
    }
}
