package de.ibw.tms.ui.route.controller;

import de.ibw.history.PositionData;
import de.ibw.history.PositionModul;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.tms.intf.TmsDbdCommand;
import de.ibw.tms.intf.TmsMessage;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.intf.cmd.CheckMovementPermission;
import de.ibw.tms.ma.RbcMaAdapter;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.ui.route.model.EndTrainIntrinsicCoordModel;
import de.ibw.tms.ui.route.model.IsmartlocicSender;
import de.ibw.tms.ui.route.model.RouteModel;
import de.ibw.tms.ui.route.view.IntriniscCoordView;
import de.ibw.tms.ui.route.view.RouteModelUI;
import de.ibw.tms.ui.route.view.TrackWindow;
import ebd.internal.util.*;
import org.hibernate.annotations.Check;
import plan_pro.modell.bahnuebergang._1_9_0.TCOptikDurchmesser;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * Controller zur Ausfuehrung von Nutzerinteraktionen
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-30
 *
 */
public class RouteController {

    /**
     * Interface to Sending Routing of smartLogic-Client (TMS)
     */
    private static IsmartlocicSender ISender = null;

    public static IsmartlocicSender getIsender() {
        return ISender;
    }

    public static void setIsender(IsmartlocicSender ISender) {
        RouteController.ISender = ISender;
    }

    /**
     * Dialog der Intrinsischen Koordinate falls verfuegbar
     */
    public static IntriniscCoordView Current = null;

    /**
     * Schickt Request an die smartLogic
     */
    public static void sendMovementPermissionRequest() {
        RouteModel RM = RouteModel.routeRepository.getModel(RouteModel.FD_ROUTE);
        if(RM == null) return;
        if(RM.getRoute() == null) return;
        if(RM.getRoute().getLastEdge() == null) return;
        CheckMovementPermission CheckTask = new CheckMovementPermission(1);
        CheckTask.route = RM.getRoute();
        CheckTask.iTrainId = RM.getNid_engineId();
        CheckTask.uuid = UUID.randomUUID();
        CheckTask.tms_id = "1";
        CheckTask.rbc_id = "1";
        CheckTask.MaAdapter = generateMA(RM);

        TmsMessage MPR = new TmsMovementPermissionRequest("1", "1", CheckTask);

        ISender.sendMessageTosmartLogic(MPR);
        RouteModelUI.getInstance(false);


    }

    /**
     * Schickt Tesc-Comman an die smartLogic
     */
    public static void sendTESC_Request(CheckDbdCommand dbdCmd) {


        dbdCmd.uuid = UUID.randomUUID();
        TmsMessage TescRequest = new TmsDbdCommand("1", "1", dbdCmd);

        ISender.sendMessageTosmartLogic(TescRequest);
        TrackWindow.closeAllTrackWindows();


    }


    private static RbcMaAdapter generateMA(RouteModel rm) {
        int nid_engine_id = rm.getNid_engineId();
        PositionData PosDat = PositionModul.getInstance().getCurrentPosition(nid_engine_id);
        int nid_lrbg = PosDat.getPos().nid_lrbg;

        ComposedRoute CR = new ComposedRoute();
        BigDecimal dRouteMeter = BigDecimal.valueOf(300);
        try {
            CR.generateFromRoute(rm.getRoute(), nid_engine_id);
            dRouteMeter = CR.getRouteLength();
        } catch(SmartLogicException SLE) {

        }



        int q_dir = PosDat.getPos().q_dlrbg; // direction away from balisegroup
        int q_scale = 1; // 1m
        int v_loa = 0; // 50km/h
        int t_loa = 1023; // special value
        EOA.EndTimer T = new EOA.EndTimer(0, 1023);
        EOA.DangerPoint DP = new EOA.DangerPoint(100, 8); // database value CB & WI
        EOA.Overlap O = null;

        EOA.Section Section = new EOA.Section(dRouteMeter.intValue(),false,
                null, null);
        ArrayList<EOA.Section> eoaSections = new ArrayList();
        eoaSections.add(Section);


        EOA eoa = new EOA(q_dir, q_scale, v_loa, t_loa, T, DP, O );
        eoa.sections = eoaSections;
        GradientProfile.Gradient Grad = new GradientProfile.Gradient(0, true, 0);
        ArrayList<GradientProfile.Gradient> gradients = new ArrayList<>();
        gradients.add(Grad);
        GradientProfile GP = new GradientProfile(1,1, gradients);
        SpeedProfile.Section Sec = new SpeedProfile.Section(0, 10, true, new ArrayList<>()); // 50 km/h
        ArrayList<SpeedProfile.Section> speedSection = new ArrayList<>();
        speedSection.add(Sec);
        SpeedProfile SP = new SpeedProfile(1, 1, speedSection);
        ModeProfile.Mode M = new ModeProfile.Mode(dRouteMeter.intValue(),1, 0, 0, 32767,
                true);
        ArrayList<ModeProfile.Mode> modes = new ArrayList<>();
        modes.add(M);
        ModeProfile M_Prof = new ModeProfile(1,1, modes);
        LinkingProfile LP = null;
        MA ma = new MA(true, nid_lrbg, q_dir, q_scale
                , eoa, GP,SP,M_Prof,LP);
        RbcMaAdapter result = new RbcMaAdapter(ma);
        return result;
    }


    /**
     * akutalisiert die Meterzahl am letzten Abschnitt
     * @param iMeter - Meter der Anforderung (Jslider)
     */
    public static void updateIntrinsic(int iMeter) {
        RouteModel RM = RouteModel.routeRepository.getModel(RouteModel.FD_ROUTE);
        if(RM == null) return;
        if(RM.getRoute() == null) return;
        if(RM.getRoute().getLastEdge() == null) return;

        handleMeter(iMeter, RM);


    }

    private static void handleMeter(int iMeter, RouteModel RM) {
        TopologyGraph.Edge ScopedEdge = RM.getRoute().getLastEdge();
        double iMaxMeter = ScopedEdge.dTopLength;
        if(iMeter > iMaxMeter) {
            JOptionPane.showMessageDialog(new JFrame("Too large"), "Meter größer als Streckenabschnitt.");
            return;
        }
        if(iMeter < 0) {
            JOptionPane.showMessageDialog(new JFrame("Too small"), "Meter dürfen nur positiv sein.");
            return;
        }
        if(iMaxMeter <= 0) {
            RM.getRoute().setIntrinsicCoordOfTargetTrackEdge(1.0d);
        } else RM.getRoute().setIntrinsicCoordOfTargetTrackEdge(new BigDecimal(iMeter).
                divide(BigDecimal.valueOf(iMaxMeter), 14, RoundingMode.HALF_UP).doubleValue());

        if(Current != null) {
            Current.updateUI();
            updateRouteUI(RM);
        }
    }

    /**
     * Setzt Meter des letzten Abschnitts
     * @param sMeter (Texteingabe)
     */
    public static void setIntrinsicViaMeter(String sMeter) {
        RouteModel RM = RouteModel.routeRepository.getModel(RouteModel.FD_ROUTE);
        if(RM == null) return;
        if(RM.getRoute() == null) return;
        if(RM.getRoute().getLastEdge() == null) return;
        try {
            int iMeter = Integer.parseInt(sMeter);
            handleMeter(iMeter,RM);
        } catch(Exception E) {
            JOptionPane.showMessageDialog(new JFrame("Meter nicht gespeichert"),
                    "Bitte Meter in Ganzzahl eintragen.");
        }
    }

    /**
     * setzt Intrinsischen Abschnitt ueber Faktor
     * @param sIntrin - Faktor als Text
     */
    public static void setIntrinsic(String sIntrin) {
        RouteModel RM = RouteModel.routeRepository.getModel(RouteModel.FD_ROUTE);
        if(RM == null) return;
        if(RM.getRoute() == null) return;
        if(RM.getRoute().getLastEdge() == null) return;
        try {
        double dIntrin = Double.parseDouble(sIntrin);
            int iMeter = (int) (dIntrin * RM.getRoute().getLastEdge().dTopLength);
            handleMeter(iMeter,RM);
        } catch(Exception E) {
            JOptionPane.showMessageDialog(new JFrame("Intrinsischer Wert nicht gespeichert"),
                    "Bitte eine Zahl eintragen.");
        }

    }

    /**
     * Erstellt eine neue Fahranforderung (als Route) fuer den Zug (nid_engine Id)
     * @param TrainId - NidEngineId als Integer
     */
    public static void createMP_Request(Integer TrainId) {
        if (RouteModel.isRouteSelected()) return;
        if (TrainId == null) return;
        RouteModel RM = new RouteModel(RouteModel.FD_ROUTE);
        RM.setNid_engineId(TrainId);
        RouteModel.routeRepository.update(RouteModel.FD_ROUTE, RM);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                updateRouteUI(RM);
                if(Current != null) Current.dispose();
            };

        });
    }

    /**
     * fuegt eine Kante zur aktuellen Route hinzu
     * @param E - Kante die hnzugefuegt werden soll
     */
    public static void addEdge(TopologyGraph.Edge E) {
        if(E == null) return;
        if(!RouteModel.isRouteSelected()) return;
        RouteModel RM = RouteModel.routeRepository.getModel(RouteModel.FD_ROUTE);
        if(RM == null) return;
        try {
        RM.addEdgeToRoute(E);
        } catch(InvalidParameterException IPE) {
            IPE.printStackTrace();
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                updateRouteUI(RM);
                if(Current != null) Current.dispose();
            }
        });
    }

    private static void updateRouteUI(RouteModel RM) {
        RouteModelUI RouteUI = RouteModelUI.getInstance(false);
        RouteUI.setRM(RM);
        RouteModelUI.getInstance(true);
        TrackWindow.closeAllTrackWindows();
    }

    /**
     * Oeffnet einen Dialog zum Bestimmen, wei weit der Zug am letzten Abschnitt einfahren darf
     * @param routeModelUI - der Aufrufende Routen-Dialog als Referenz (modal)
     */
    public static void openIntrinsicDialog(RouteModelUI routeModelUI) {
        RouteModel RM = RouteModel.routeRepository.getModel(RouteModel.FD_ROUTE);
        if(RM == null) return;
        if(RM.getRoute() == null) return;
        if(RM.getRoute().getLastEdge() == null) {
            JOptionPane.showMessageDialog(new JFrame("Keine Kante definiert"),
                    "Bitte eine Kante hinzufügen.");
            return;
        }
        EndTrainIntrinsicCoordModel Model = new EndTrainIntrinsicCoordModel(RM);
        IntriniscCoordView ICV = new IntriniscCoordView(routeModelUI, Model);
    }
}
