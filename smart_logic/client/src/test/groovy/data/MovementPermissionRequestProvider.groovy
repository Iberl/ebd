package data

import de.ibw.tms.intf.TmsMovementPermissionRequest
import de.ibw.tms.intf.cmd.CheckMovementPermission
import de.ibw.tms.ma.RbcMaAdapter
import de.ibw.tms.ma.Route
import de.ibw.tms.ma.dynamic.RouteSection
import ebd.rbc_tms.util.*
import spock.lang.Specification

class MovementPermissionRequestProvider extends Specification {
    public TmsMovementPermissionRequest getTestRequest() {
        EOA.EndTimer Timer = new EOA.EndTimer(1023, 0);

        EOA.DangerPoint DP = new EOA.DangerPoint(252, 8);
        EOA eoa = new EOA(1, 1, 0, 1023, Timer,DP, null );
        GradientProfile.Gradient G = new GradientProfile.Gradient(0,true,0);
        ArrayList<GradientProfile.Gradient> gradients = new ArrayList<>();
        gradients.add(G);
        GradientProfile GP = new GradientProfile(1, 1, gradients);
        SpeedProfile.Section S = new SpeedProfile.Section(0,12, true);
        S.categories = new ArrayList<>();
        ArrayList<SpeedProfile.Section> sections = new ArrayList<>();
        sections.add(S);
        SpeedProfile SP = new SpeedProfile(1,1, sections);
        ModeProfile.Mode M = new ModeProfile.Mode(10050, 1, 0, 0, 32767, true);
        ArrayList<ModeProfile.Mode> modes = new ArrayList<>();
        modes.add(M);
        ModeProfile modeProfile = new ModeProfile(1,1, modes);
        MA ma = new MA(true, 12778, 1,1, eoa, GP, SP, modeProfile, null) ;
        RbcMaAdapter adapter = new RbcMaAdapter(ma);
        CheckMovementPermission permission = new CheckMovementPermission(1L);
        String[] sectionNames = new String[] {
                "11W10L", "11W13R", "11W40S", "11W41S", "11W42L",
                "11W43S", "13W1S", "13W1L", "13W2S", "13W3L",
                "13W4S"
        }
        ArrayList<String> routeSections = new ArrayList<>();
        routeSections.addAll(sectionNames);
        Route R = new Route(new ArrayList<RouteSection>());
        R.setElementListIds(routeSections);
        R.setIntrinsicCoordOfTargetTrackEdge(0.6634920635d);
        permission.iTrainId = 1;
        permission.lPriority = 1;
        permission.rbc_id = 1;
        permission.tms_id = 1;
        permission.uuid = UUID.randomUUID();
        permission.MaAdapter = adapter;
        permission.route = R;

        TmsMovementPermissionRequest request = new TmsMovementPermissionRequest("1", "1", permission)
        return request;
    }

}
