package de.ibw.tms.train.controller;

import de.ibw.tms.etcs.ETCS_GRADIENT;
import de.ibw.tms.intf.SmartClientHandler;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.tms.intf.cmd.CheckMovementPermission;
import de.ibw.tms.ma.GradientProfile;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.speed.profile.model.CartesianSpeedModel;
import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.trackplan.ui.RouteComponent;
import de.ibw.tms.train.model.TrainModel;
import de.ibw.tms.train.ui.SingleTrainSubPanel;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.rbc_tms.util.*;
import ebd.rbc_tms.util.ModeProfile.Mode;
import ebd.rbc_tms.util.exception.MissingInformationException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
/**
 * Controller der die Metadaten zu dem Zug verwaltet
 * Das kann im MA-Beantragungsfenster unterhalb der Karte editiert werden.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-08-25
 */
public class TrainController extends SubmissionPublisher implements IController {


    private TrainModel Model;
    private SingleTrainSubPanel TrainSubPanel;
    private CartesianSpeedModel CSM;

    private boolean isSubscribed = false;

    /**
     * Gibt Auskunft, dass ein Zug editiert wurde. Benachrichtigt als eingetragenen Empf&auml;nger
     */

    @Override
    public void publish() {

        this.standardSubscription();


        this.submit("");


    }

    /**
     * Definert welche Komponenten benachrichtigt werden.
     * Bisher ein UnterModul der Hauptklasse des TMS
     * @return List
     */

    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        ArrayList result = new ArrayList();
        //result.add(MainTmsSim.MainSubscriber);
        return result;
    }

    /**
     * Instanziert Controller zu einem Zugmodell und der Gui die Daten zum Zug &auml;ndern kann.
     * @param Tm
     * @param Tsp
     */
    public TrainController(TrainModel Tm, SingleTrainSubPanel Tsp) {
        this.Model = Tm;
        this.TrainSubPanel = Tsp;
    }

    /**
     * &Auml;ndert Name eines Zuges
     * @param sLabel
     */
    public void changeLabel(String sLabel) {
        if(TrainModel.usedLabelList.contains(sLabel)) {
            JOptionPane.showMessageDialog(null, "The trainid has to be unique.");
        } else {
            this.Model.label = sLabel;
        }
        this.publish();
    }

    /**
     * &Auml;ndert Farbe eines Zuges.
     * @param RepresentedColor {@link Color} Zielfarbe des Zuges
     */
    public void changeTraincolor(Color RepresentedColor) {
        Color TrainColor = JColorChooser.showDialog(
                this.TrainSubPanel, "Choose Train Color", RepresentedColor);
        if(null == TrainColor || TrainModel.usedColorList.contains(TrainColor)) {
            JOptionPane.showMessageDialog(null, "The traincolor was already chosen.");
        } else {
            this.Model.RepresentedColor = TrainColor;
        }
        this.publish();

    }

    /**
     * Schickt MA zur SmartLogic
     * @param requestWrapper {@link MaRequestWrapper} - Die Anfrage einer MA an die SL
     * @param R {@link Route} - die angeforderte Route
     * @param sRbcId {@link String} - Ziel RBC Id
     * @param sTmsId {@link String} - Eigene TMS Id
     * @param uuid - {@link UUID} - Kommunikations Id
     * @param bIsShunting boolean - Entscheidet ob Shunting am Schluss der SpotLocation der MA
     * @throws IOException - Fehler beim Senden an die SmartLogic
     */
    public void requestMovementAuthority(MaRequestWrapper requestWrapper, Route R, String sRbcId, String sTmsId, UUID uuid, boolean bIsShunting) throws IOException {
        boolean m_ack = true;
        RbcMaAdapter MaAdapter = null;
        Integer nid_lrbg = extractNidBaliseId(requestWrapper);

        EOA.EndTimer TimerEnd = new EOA.EndTimer(ETCSVariables.T_ENDTIMER_INFINITY, ETCSVariables.D_ENDTIMERSTARTLOC);
        LinkingProfileAdapter LPA = null;
        int Q_DIR = extractQ_DIR(requestWrapper);
        int Q_SCALE = ETCSVariables.Q_SCALE_1M;
        int EOA_Q_SCALE = ETCSVariables.Q_SCALE_1M;
        // Endgeschwindigkeit
        int V_LimitOfAuthority = 0;
                //extractMaxSpeed_V_LOA();
        int T_LOA = ETCSVariables.T_LOA_INFINITY;
        int L_SECTION = 0;
        ebd.rbc_tms.util.GradientProfile GradProfile = null;
        EOA eoaRbcIntf = null;
        MA SendMa = null;
        ArrayList<EOA.Section> eoaSections = new ArrayList<>();
        SpeedProfile RbcSpeedProfil = null;
        try {
            double dLengthOfEoaSectionsAsOnce = R.getLocation().getEnd().chainage.iMeters;
            if (dLengthOfEoaSectionsAsOnce > 32000) {
                EOA_Q_SCALE = ETCSVariables.Q_SCALE_10M;
                L_SECTION = (int) (dLengthOfEoaSectionsAsOnce / 10);
            } else {
                L_SECTION = (int) dLengthOfEoaSectionsAsOnce;
            }
            ArrayList<ebd.rbc_tms.util.GradientProfile.Gradient> gradients = new ArrayList<>();
            gradients.add(new ebd.rbc_tms.util.GradientProfile.Gradient(L_SECTION, ETCSVariables.Q_GDIR_UPHILL, 0));
            GradProfile = new ebd.rbc_tms.util.GradientProfile(Q_DIR, EOA_Q_SCALE, gradients);
            EOA.Section OneSection = new EOA.Section(L_SECTION, ETCSVariables.Q_SECTIONTIMER_NO_INFO, null, null);


            eoaSections.add(OneSection);

            RbcSpeedProfil = generateRbcSpeedProfile(Q_DIR);
        } catch(Exception E) {
            E.printStackTrace();
        }
        //ModeProfile DefaultMode = new ModeProfile(Q_DIR, Q_SCALE, new ArrayList<>());
        if(R.getLocation().getBegin() == null) {
            System.err.println("kein Startknoten");
            JOptionPane.showMessageDialog(TrainSubPanel.Parent, "Please select Start Train",
                    "Start Train Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(R.getLocation().getEnd() == null) {
            JOptionPane.showMessageDialog(TrainSubPanel.Parent, "Please create Route End Waypoint",
                    "Waypoint Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(R.getLocation().getBegin() != null && R.getLocation().getEnd() != null) {
            System.out.println("Track has start and end");
            requestWrapper.setRoute(R);
            requestWrapper.save();
            this.publish();




            // return to parent
            //parent.dispose();



            RbcMA Ma = new RbcMA(Model.label);
            SpotLocation SL = R.getLocation().getEnd();
            /*EoA Eoa = new EoA(SL.getChainage(), SL.getTrackElement(), new SectionOfLine());

            Eoa.setV_EMA(0);
            Eoa.setDangerPoint(null);
            Eoa.setQ_DANGERPOINT(false);
            Eoa.setQ_OVERLAP(false);
            Eoa.setOverlap(null);
            Eoa.setD_ENDTIMERSTARTLOC(null);
            Eoa.setT_ENDTIMER(null); // unendlich TODO
            Eoa.setQ_scale(null);

            Ma.setEndOfAuthority(Eoa);
*/
            GradientProfile GrProfile = new GradientProfile(Ma);
            ETCS_GRADIENT etcs_gradient = new ETCS_GRADIENT();
            etcs_gradient.bGradient = 0;

            /*GradientSegment GrSegment = new GradientSegment(R.getLocation().getBegin(), R.getLocation().getEnd(),
                    ApplicationDirection.BOTH);
            GrSegment.setGradient(etcs_gradient, false);
            GrProfile.addSegment(GrSegment);
*/
            Chainage EndCha =  SL.getChainage();
            //Chainage SvLCh = new Chainage(EndCha.getiMeters() + 400);



            // 0 vmax
            SvL SuperVL = RouteComponent.svl;
            if(SuperVL == null) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(TrainController.this.TrainSubPanel);

                        JOptionPane.showMessageDialog(topFrame, "Svl not found", "No Svl defined", JOptionPane.ERROR_MESSAGE );
                        return;
                    }
                });

            }

            SuperVL.setMovementAuthority(Ma);
            SuperVL.setVmax(0);
            Ma.setSuperviesedLocation(SuperVL);

            TrainMovement TM = new TrainMovement();

            Ma.setTrainMovement(TM);
            Ma.setSpeedProfile(CSM.getStaticSpeedProfile());
            Ma.setGradientProfile(GrProfile);

            ModeProfile MoProfile = handleModeProfile(bIsShunting, Q_DIR, Q_SCALE, EndCha);

            LPA = extractLinkingProfile(R);
            
            
            /*Scenario ScCustom = new Scenario("Custom");
            ScCustom.addMa(Ma);
            ScCustom.runCustomSzenario();
            */
            // send MA
            eoaRbcIntf = new EOA(Q_DIR, EOA_Q_SCALE, V_LimitOfAuthority,T_LOA,eoaSections, TimerEnd, null, null);


            SendMa = new MA(m_ack, nid_lrbg, Q_DIR, Q_SCALE, T_LOA, eoaRbcIntf, GradProfile, RbcSpeedProfil,
                    MoProfile, null);

            MaAdapter = new RbcMaAdapter(SendMa);
            CheckMovementPermission CheckMoveAuthCommand = new CheckMovementPermission(3L);

            CheckMoveAuthCommand.MaAdapter = MaAdapter;
            CheckMoveAuthCommand.rbc_id = sRbcId;
            CheckMoveAuthCommand.tms_id = sTmsId;
            CheckMoveAuthCommand.uuid = uuid;
            TopologyGraph.Edge E = null;
            E.sId = E.getRefId();
            //CheckMoveAuthCommand.MaRequest.Tm.setEdgeTrainStandsOn(E);
            //TopologyGraph.Node N = CheckMoveAuthCommand.MaRequest.Tm.getNodeTrainRunningTo();
            //CheckMoveAuthCommand.MaRequest.Tm.setsNodeIdTrainRunningTo(ISwitchHandler.getNodeId(N));
            //CheckMoveAuthCommand.MaRequest.Tm.unsetPassedElements();

            TmsMovementPermissionRequest Msg = new TmsMovementPermissionRequest(sTmsId, sRbcId,CheckMoveAuthCommand);



            try {

                SmartClientHandler.getInstance().sendCommand(Msg);
            } catch (MissingInformationException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * TODO
     * Linking in der MA
     * @param R
     * @return
     */
    public LinkingProfileAdapter extractLinkingProfile(Route R) {
        int q_dir = 0;
        int q_scale = 0;
        //TODO
        //LinkingProfile.Link Link = new LinkingProfile.Link();
        LinkingProfile LP = new LinkingProfile(q_dir, q_scale, new ArrayList<>());
        return new LinkingProfileAdapter(LP);
    }

    private ModeProfile handleModeProfile(boolean bIsShunting, int Q_DIR, int Q_SCALE, Chainage endCha) {
        if(!bIsShunting) return null;
        int iMeter = endCha.iMeters;
        if(Q_SCALE == ETCSVariables.Q_SCALE_10M) {
            iMeter = iMeter * 10;
        }
        if(Q_SCALE == ETCSVariables.Q_SCALE_10CM) {
            iMeter = (int) (iMeter * 0.1);
        }
        int iD_Mamode = iMeter; //start shunting immediately
        int iM_Mamode = 1; // ShuntingMode
        int iV_Mamode = 0; // no speed shunt
        int iL_Mamode = ETCSVariables.L_MAMODE_INFINITY;
        int iL_AckMaMode = 0;
        boolean bQ_Mamode = false;

        Mode M_SHUNTING = new Mode(iD_Mamode,iM_Mamode,iV_Mamode,iL_Mamode,iL_AckMaMode,bQ_Mamode);
        ArrayList modeList = new ArrayList();
        modeList.add(M_SHUNTING);
        ModeProfile MoProfile = new ModeProfile(Q_DIR, Q_SCALE, modeList);
        return MoProfile;

    }

    private SpeedProfile generateRbcSpeedProfile(int q_dir) {
        SSP SpeedProfGiven = CSM.getStaticSpeedProfile();
        SpeedProfile ResultProfile;
        ArrayList<SpeedSegment> speedSegList = new ArrayList<>(SpeedProfGiven.getSpeedSegments());
        int iQ_SCALE = ETCSVariables.Q_SCALE_1M;
        ArrayList<SpeedProfile.Section> etcsSpeedSectionList = new ArrayList<>();
        for(SpeedSegment SpSegment : speedSegList) {
            int iQ_SCALE_TEMP = addSpeedSegments(iQ_SCALE, etcsSpeedSectionList, SpSegment);
            if(iQ_SCALE_TEMP == ETCSVariables.Q_SCALE_10M) {
                iQ_SCALE = iQ_SCALE_TEMP;
            }
        }
        if(iQ_SCALE == ETCSVariables.Q_SCALE_10M) {
            ResultProfile = handleQ_Scale10(q_dir, iQ_SCALE, etcsSpeedSectionList);
        } else {
            ResultProfile = new SpeedProfile(q_dir, iQ_SCALE, etcsSpeedSectionList);
        }
        return ResultProfile;


    }

    private SpeedProfile handleQ_Scale10(int q_dir, int iQ_SCALE, ArrayList<SpeedProfile.Section> etcsSpeedSectionList) {
        SpeedProfile ResultProfile;
        ArrayList<SpeedProfile.Section> resultSpeedSectionList = new ArrayList<>();
        for(SpeedProfile.Section SpSection: etcsSpeedSectionList) {
            SpSection.d_static = SpSection.d_static / 10;
            resultSpeedSectionList.add(SpSection);
        }
        ResultProfile = new SpeedProfile(q_dir, iQ_SCALE, resultSpeedSectionList);
        return ResultProfile;
    }

    private int addSpeedSegments(int iQ_SCALE, ArrayList<SpeedProfile.Section> etcsSpeedSectionList, SpeedSegment SpSegment) {
        //int iStart = SpSegment.speedChangeBegin.chainage.iMeters;
        //int iEnd = SpSegment.speedChangeEnd.chainage.iMeters;
        //int v_Static = SpSegment.v_STATIC.bSpeed;
        //int i_D_STATIC = iStart;
        //if(i_D_STATIC > 32000) {
            iQ_SCALE = ETCSVariables.Q_SCALE_10M;
        //}
       // SpeedProfile.Section SpeedSection = new SpeedProfile.Section(i_D_STATIC,v_Static, ETCSVariables.Q_FRONT_TRAIN_FRONT, new ArrayList<>());
        //etcsSpeedSectionList.add(SpeedSection);
        //return iQ_SCALE;
        return 0;
    }

    /**
     * Extrahiert distanz von Referenzbalise Topologischen End-Knoten ACHTUNG nicht für letztes Wegst&uuml;ck gedacht.
     * Deshalb ohne letzten Gleisabschnitt
     * @param R {@link Route} - die angeforderte Route
     * @param TM {@link TrainModel} - der Zug auf der Route
     * @return BigDecimal - Entfernung
     */
    public static BigDecimal extractDistanceOfSelectedTrack(Route R, TrainModel TM) {
       return null;
    }

    private int extractMaxSpeed_V_LOA() {
        int iMaxResultSpeed = 1;
        try {

           SSP SpeedProfile = CSM.getStaticSpeedProfile();
           ArrayList<SpeedSegment> speedList = new ArrayList<>(SpeedProfile.getSpeedSegments());
           for(SpeedSegment Segment: speedList) {
               int i_V = Segment.getV_STATIC().bSpeed;
               if(iMaxResultSpeed < i_V) {
                   iMaxResultSpeed = i_V;
               }
           }
           return iMaxResultSpeed;

        } catch (Exception E) {
            return 1;
        }
    }

    private int extractQ_DIR(MaRequestWrapper requestWrapper) {
        try {
            return requestWrapper.Tm.getQ_DIR();
        }catch (Exception E) {
            E.printStackTrace();
        }
        return ETCSVariables.Q_DIR_BOTH;
    }



    private Integer extractNidBaliseId(MaRequestWrapper requestWrapper) {
        try {
            return requestWrapper.Tm.getNid_lrbg();
        } catch (Exception E) {
            E.printStackTrace();
        }
        return null;

    }


    /**
     * Setzt Art des Zuges auf den angegebenen Wert
     * @param sCategory {@link String}
     */
    public void changeCategory(String sCategory) {
        this.Model.category = sCategory;
    }

    /**
     * Setzt L&auml;nge des Zuges auf angebenen Wert in Meter
     * @param sLength {@link String} - neue L&auml;nge in Meter
     */
    public void changeLength(String sLength) {
        try {
            Double dLength = Double.parseDouble(sLength);
            Model.length = dLength;
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(null, "The length has to be a numeric double value");
        }
        this.publish();
    }

    /**
     * Setzt die maximale Geschwindigkeit des Zuges
     * @param sSpeed {@link String} - Speed in (km per h)
     */
    public void changeSpeed(String sSpeed) {
        try {
            int iSpeed = Integer.parseInt(sSpeed);
            Model.iSpeedMax = iSpeed;
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(null, "The speed has to be a numeric integer value");
        }
        this.publish();
    }

    /**
     * Setzt das Static Speed Profile des Zuges
     * @param CSM {@link CartesianSpeedModel} - Wrapper f&uuml;r SSP
     */
    public void setCSM(CartesianSpeedModel CSM) {
        this.CSM = CSM;
    }
}
