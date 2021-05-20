package de.ibw.tms.entities.converter;

import de.ibw.tms.entities.*;
import de.ibw.tms.intf.cmd.CheckMovementPermission;
import ebd.rbc_tms.util.*;
import de.ibw.tms.ma.RbcMaAdapter;
import de.ibw.tms.trackplan.ui.Route;

import java.util.ArrayList;
import java.util.List;
/**
 * Ein Konverter - er setzt den Datenbank-Movement-Permission-Request-Befehl in eine Klasse um,
 * die ueber das Netzwerk and die smartLogic
 * geschickt werden kann
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 2021-05-20
 */
public class CheckPermissionConverter {
    /**
     * konvertiert das Datenbankobjekt eines Movement-Permission-Requests
     * @param CMP_DB - Datenbankobject des Movement-Permission-Requests
     * @return allgemeines Object des Movement-Permission-Requests
     */
    public static CheckMovementPermission convert(CheckMovementPermissionDAO CMP_DB) {
        CheckMovementPermission result = new CheckMovementPermission();
        Route R = convertRoute(CMP_DB.route);
        RbcMaAdapter Ma = convertMa(CMP_DB.MaAdapter);
        result.iTrainId = CMP_DB.iTrainId;
        result.uuid = CMP_DB.uuid;
        result.lPriority = CMP_DB.lPriority;
        result.tms_id = CMP_DB.tms_id;
        result.rbc_id = CMP_DB.rbc_id;
        result.CommandType = CMP_DB.CommandType;


        result.MaAdapter = Ma;
        result.route = R;
        return result;

    }

    private static RbcMaAdapter convertMa(MaDAO maDB) {
        if(maDB == null) return null;
        EOA eoa = convertEoa(maDB.eoa);
        GradientProfile GP = convertGradientProfile(maDB.gradientProfile);
        SpeedProfile SP = convertSpeedProfile(maDB.speedProfile);
        ModeProfile M_Prof = convertModeProf(maDB.modeProfile);
        LinkingProfile LP = convertLinkProf(maDB.linkingProfile);
        MA ma = new MA(maDB.m_ack, maDB.nid_lrbg, maDB.q_dir, maDB.q_scale
        , eoa, GP,SP,M_Prof,LP);
        return new RbcMaAdapter(ma);
    }

    private static LinkingProfile convertLinkProf(LinkingProfileDAO linkingProfile) {
        if(linkingProfile == null) return null;
        LinkingProfile LP = new LinkingProfile(linkingProfile.q_dir, linkingProfile.q_scale);
        LP.links = convertLinks(linkingProfile.links);
        return LP;

    }

    private static List<LinkingProfile.Link> convertLinks(List<LinkDAO> links) {
        List<LinkingProfile.Link> result = new ArrayList<>();
        if(links == null) return result;
        for(LinkDAO L : links) {
            result.add(new LinkingProfile.Link(L.d_link,L.nid_c,
                    L.nid_bg, L.q_linkorientation, L.q_linkreaction,
                    L.q_locacc));
        }
        return result;
    }

    private static ModeProfile convertModeProf(ModeDAO modeProfile) {
        if(modeProfile == null) return null;
        ModeProfile M_Prof = new ModeProfile(modeProfile.q_dir, modeProfile.q_scale);
        M_Prof.modes = convertModes(modeProfile.modes);
        return M_Prof;
    }

    private static List<ModeProfile.Mode> convertModes(List<SingleModeDAO> modes) {
        List<ModeProfile.Mode> result = new ArrayList<>();
        if(modes == null) return result;
        for(SingleModeDAO M_DB : modes) {
            result.add(convertM(M_DB));
        }
        return result;
    }

    private static ModeProfile.Mode convertM(SingleModeDAO m_db) {
        if(m_db == null) return null;
        return new ModeProfile.Mode(m_db.d_mamode, m_db.m_mamode, m_db.v_mamode, m_db.l_ackmamode, m_db.l_ackmamode,
                m_db.q_mamode);

    }


    private static SpeedProfile convertSpeedProfile(SpeedProfileDAO SP_DB) {
        if(SP_DB == null) return null;
        SpeedProfile SP = new SpeedProfile(SP_DB.q_dir, SP_DB.q_scale);
        SP.sections = convertSpeedSections(SP_DB.sections);
        return SP;
    }

    private static List<SpeedProfile.Section> convertSpeedSections(List<SpeedSectionDAO> sections) {
        List<SpeedProfile.Section> sectionList = new ArrayList<>();
        if(sections == null) return sectionList;
        for(SpeedSectionDAO S_DB : sections) {
            sectionList.add(convertSpeedSection(S_DB));
        }
        return sectionList;
    }

    private static SpeedProfile.Section convertSpeedSection(SpeedSectionDAO s_db) {
        if(s_db == null) return null;
        SpeedProfile.Section S = new SpeedProfile.Section(s_db.d_static,s_db.v_static,s_db.q_front);
        S.categories = convertCategories(s_db.categories);
        return S;



    }

    private static List<SpeedProfile.Section.Category> convertCategories(List<SpeedCategoryDAO> categories) {
        List<SpeedProfile.Section.Category> result = new ArrayList<>();
        if(categories == null) return result;
        for(SpeedCategoryDAO C_DB : categories) {
            result.add(new SpeedProfile.Section.Category(C_DB.q_diff, C_DB.nc_cddiff, C_DB.nc_diff, C_DB.v_diff));
        }
        return result;
    }

    private static GradientProfile convertGradientProfile(GradientProfileDAO gradientProfile) {
        if(gradientProfile == null) return null;
        GradientProfile GP = new GradientProfile(gradientProfile.q_dir,gradientProfile.q_scale);
        GP.gradients = convertGradients(gradientProfile.gradients);
        return GP;

    }

    private static List<GradientProfile.Gradient> convertGradients(List<GradientDAO> gradients) {
        List<GradientProfile.Gradient> result = new ArrayList<>();
        if(gradients == null) return result;
        for(GradientDAO G_DB : gradients) {
            result.add(new GradientProfile.Gradient(G_DB.d_gradient, G_DB.q_gdir, G_DB.g_a));
        }
        return result;
    }

    private static EOA convertEoa(EoaDAO Eoa_Db) {
        if(Eoa_Db == null) return null;
        EOA.EndTimer T = convertTimer(Eoa_Db.endTimer);
        EOA.DangerPoint DP = convertDP(Eoa_Db.dangerPoint);
        EOA.Overlap O = convertOverlap(Eoa_Db.overlap);
        EOA eoa = new EOA(Eoa_Db.q_dir, Eoa_Db.q_scale, Eoa_Db.v_loa, Eoa_Db.t_loa, T,DP,O );
        eoa.sections = convertEoaSections(Eoa_Db.sections);
        return eoa;

    }

    private static List<EOA.Section> convertEoaSections(List<EoaSectionDAO> sections_db) {
        List<EOA.Section> sections = new ArrayList<>();
        if(sections_db == null) return sections;
        for(EoaSectionDAO S_DB : sections_db) {
            EOA.Section S = converEoaSection(S_DB);
            sections.add(S);
        }
        return sections;

    }

    private static EOA.Section converEoaSection(EoaSectionDAO s_db) {
        if(s_db == null) return null;
        return new EOA.Section(s_db.l_section, s_db.q_sectiontimer,s_db.t_sectiontimer, s_db.d_sectiontimerstoploc);

    }

    private static EOA.Overlap convertOverlap(OverlapDAO overlap) {
        if(overlap == null) return null;
        return new EOA.Overlap(overlap.d_startol, overlap.t_ol, overlap.d_ol, overlap.v_releaseol);

    }

    private static EOA.DangerPoint convertDP(DangerPointDAO dangerPoint) {
        if(dangerPoint == null) return null;
        return new EOA.DangerPoint(dangerPoint.d_dp,dangerPoint.v_releasedp);

    }

    private static EOA.EndTimer convertTimer(EndTimerDAO endTimer) {
        if(endTimer == null) return null;
        return new EOA.EndTimer(endTimer.t_endtimer, endTimer.d_endtimerstartloc);

    }

    private static Route convertRoute(RouteDAO route) {
        if(route == null) return null;
        List<String> sectionIds = convertRouteSections(route.routeSections);
        Route R = new Route(new ArrayList<>());
        R.setElementListIds(sectionIds);
        R.setIntrinsicCoordOfTargetTrackEdge(route.intrinsicCoordOfTargetTrackEdge);
        return R;
    }

    private static List<String> convertRouteSections(List<RouteSectionDAO> routeSections) {
        List<String> resultSections = new ArrayList<>();
        if(routeSections == null) return resultSections;
        for(RouteSectionDAO RS_DB : routeSections) {
            resultSections.add(RS_DB.routeSectionId);
        }
        return resultSections;


    }


}
