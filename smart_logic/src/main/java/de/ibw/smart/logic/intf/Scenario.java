package de.ibw.smart.logic.intf;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.ibw.tms.MainTmsSim;
import de.ibw.tms.etcs.ETCS_GRADIENT;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.etcs.ETCS_TIMER;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.physical.EdgeOfMap;
import de.ibw.tms.ma.physical.RailConnector;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.model.PlanData;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * veralteter Code
 */
public class Scenario {

    public static String sTrainName = null;

    public static void main(String[] args) {




    }



    public static boolean isObject = false;

    private String sName = "";

    public Scenario(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Scenario " + sName;
    }

    private static Scenario RunningSzenario = null;
    public  static List<Scenario> allSzenarios = new ArrayList<Scenario>();
    private static void generateScenarios() {
        RbcMA Ma1Sz1and3 = new RbcMA("ICE 12");
        RbcMA Ma2Sz1 = new RbcMA("ICE 12");
        //---
        RbcMA Ma1Sz2 = new RbcMA("ICE 12");
        RbcMA Ma2Sz2 = new RbcMA("ICE 12");
        RbcMA Ma3Sz2 = new RbcMA("ICE 12");


        ETCS_SPEED Speed80 = new ETCS_SPEED();
        Speed80.bSpeed = 15;
        ETCS_SPEED Speed120 = new ETCS_SPEED();
        Speed120.bSpeed = 23;
        ETCS_SPEED Speed140 = new ETCS_SPEED();
        Speed140.bSpeed = 27;
        ETCS_SPEED Speed100 = new ETCS_SPEED();
        Speed100.bSpeed = 19;



        Chainage LeftCh = new Chainage(0);
        Chainage RightCh = new Chainage(2848);
        Chainage Balise2Ch = new Chainage(584);
        Chainage Balise4Ch = new Chainage(1328);
        Chainage Balise5Ch = new Chainage(1511);
        Chainage Between5To6Ch = new Chainage(2000);
        Chainage Unused = new Chainage(2000);
        Chainage Balise7 = new Chainage(2440);
        Chainage Balise8 = new Chainage(2565);
        Chainage Between9To10 = new Chainage(2650);
        ISwitchHandler PlanDat = PlanData.getInstance();
        EoA Eoa1Sz1and3 = new EoA(Balise2Ch, PlanData.connectorList.get(2), new SectionOfLine());
        setDefaultAuthority(Eoa1Sz1and3, Speed80.bSpeed);

        EoA Eoa2Sz1 = new EoA(Balise4Ch, PlanData.connectorList.get(4), new SectionOfLine());
        setDefaultAuthority(Eoa2Sz1, 0);

        EoA Eoa1Sz2 = new EoA(Balise2Ch, PlanData.connectorList.get(4), new SectionOfLine());
        setDefaultAuthority(Eoa1Sz2, Speed80.bSpeed);

        EoA Eoa2Sz2 = new EoA(Balise7, PlanData.connectorList.get(7), new SectionOfLine());
        setDefaultAuthority(Eoa2Sz2, Speed100.bSpeed);

        EoA Eoa3Sz2 = new EoA(RightCh, PlanData.RightEnd, new SectionOfLine());
        setDefaultAuthority(Eoa3Sz2,0);

        SpotLocation SLBegin = new SpotLocation(LeftCh, PlanData.connectorList.get(0), new SectionOfLine());
        SpotLocation SL2 = new SpotLocation(Balise2Ch, PlanData.connectorList.get(2), new SectionOfLine());
        SpotLocation SL4 = new SpotLocation(Balise4Ch, PlanData.connectorList.get(4), new SectionOfLine());
        SpotLocation SL5 = new SpotLocation(Balise5Ch, PlanData.connectorList.get(5), new SectionOfLine());
        //Between 5 and 6
        SpotLocation SL5Half = new SpotLocation(Between5To6Ch, PlanData.ConnectorBetween5To6, new SectionOfLine());
        SpotLocation SL6 = new SpotLocation(Unused, PlanData.connectorList.get(6),new SectionOfLine());
        SpotLocation SL7 = new SpotLocation(Balise7, PlanData.connectorList.get(7), new SectionOfLine());
        SpotLocation SL8 = new SpotLocation(Balise8, PlanData.connectorList.get(8), new SectionOfLine());
        SpotLocation SL9Half = new SpotLocation(Between9To10, PlanData.ConnectorBetween9To10, new SectionOfLine());
        SpotLocation SLEnd = new SpotLocation(RightCh, PlanData.RightEnd, new SectionOfLine());

        SpeedSegment Segment0To2 = new SpeedSegment(SLBegin, SL2, ApplicationDirection.BOTH);
        Segment0To2.setV_STATIC(Speed120);
        SpeedSegment Segment2To4 = new SpeedSegment(SL2, SL4, ApplicationDirection.BOTH);
        Segment2To4.setV_STATIC(Speed80);

        ETCS_SPEED etcsHalt =  new ETCS_SPEED();
        etcsHalt.bSpeed = 0;

        SpeedSegment SegmentHalt4 = new SpeedSegment(SL4, SL4, ApplicationDirection.BOTH);
        SegmentHalt4.setV_STATIC(etcsHalt);

        SpeedSegment Segment4To5Half = new SpeedSegment(SL4,SL5Half, ApplicationDirection.BOTH);
        Segment4To5Half.setV_STATIC(Speed140);
        SpeedSegment Segment5HalfTo7 = new SpeedSegment(SL5Half, SL7, ApplicationDirection.BOTH);
        Segment5HalfTo7.setV_STATIC(Speed120);
        SpeedSegment Segment7ToEnd = new SpeedSegment(SL7, SLEnd, ApplicationDirection.BOTH);
        Segment7ToEnd.setV_STATIC(Speed100);

        List<SpeedSegment> speedSegments = new ArrayList<SpeedSegment>();
        speedSegments.add(Segment0To2);
        SSP SSP1Sz1and3 = new SSP();
        copySegmentsToProfile(speedSegments, SSP1Sz1and3);
        copySpeedProfileIntoMA(SSP1Sz1and3, Ma1Sz1and3);
        GradientProfile GradProf = new GradientProfile(Ma1Sz1and3);

        GradientSegment Seg = new GradientSegment(SLBegin, SL2, ApplicationDirection.BOTH);
        ETCS_GRADIENT etcsGrad = new ETCS_GRADIENT();
        etcsGrad.bGradient = 0;
        Seg.setGradient(etcsGrad, false);
        GradProf.addSegment(Seg);
        Ma1Sz1and3.setGradientProfile(GradProf);
        Ma1Sz1and3.setEndOfAuthority(Eoa1Sz1and3);
        Ma1Sz1and3.setTrainMovement(new TrainMovement());

        speedSegments = new ArrayList<SpeedSegment>();
        speedSegments.add(Segment2To4);
        SSP SSP2Sz1and3 = new SSP();
        copySegmentsToProfile(speedSegments, SSP2Sz1and3);
        copySpeedProfileIntoMA(SSP2Sz1and3, Ma2Sz1);
        SSP2Sz1and3.setSpeedSegments(speedSegments);
        Ma2Sz1.setEndOfAuthority(Eoa2Sz1);


        SSP SSP1Sz2 = new SSP();
        speedSegments = new ArrayList<SpeedSegment>();
        speedSegments.add(Segment0To2);
        speedSegments.add(Segment2To4);
        copySegmentsToProfile(speedSegments, SSP1Sz2);
        copySpeedProfileIntoMA(SSP1Sz2, Ma1Sz2);
        Ma1Sz2.setEndOfAuthority(Eoa1Sz2);



        SSP SSP2Sz2 = new SSP();
        speedSegments = new ArrayList<SpeedSegment>();
        speedSegments.add(Segment4To5Half);
        speedSegments.add(Segment5HalfTo7);
        copySegmentsToProfile(speedSegments, SSP2Sz2);
        copySpeedProfileIntoMA(SSP2Sz2, Ma2Sz2);
        Ma2Sz2.setEndOfAuthority(Eoa2Sz2);

        SSP SSP3Sz2 = new SSP();
        speedSegments = new ArrayList<SpeedSegment>();
        speedSegments.add(Segment7ToEnd);
        copySegmentsToProfile(speedSegments, SSP3Sz2);
        copySpeedProfileIntoMA(SSP3Sz2, Ma3Sz2);
        Ma3Sz2.setEndOfAuthority(Eoa3Sz2);



        Scenario S1 = new Scenario("1 A-B");
        S1.addMa(Ma1Sz1and3);
        S1.addMa(Ma2Sz1);
        allSzenarios.add(S1);
        //-----------------------------------------------------------------------------------
        //SpotLocation location4 = new SpotLocation(Balise4Ch, PlanData.connectorList.get(4), new SectionOfLine());
        SpotLocation location5 = new SpotLocation(Balise5Ch, PlanData.connectorList.get(5), new SectionOfLine());
        SpeedSegment Speed4To5Between6 = new SpeedSegment(SL4, location5, ApplicationDirection.BOTH);

        Scenario S2 = new Scenario("2 A-C");
        S2.addMa(Ma1Sz2);
        S2.addMa(Ma2Sz2);
        S2.addMa(Ma3Sz2);
        allSzenarios.add(S2);

        //------------------------------------
        Scenario S3 = new Scenario("3 A-B-C");
        S3.addMa(Ma1Sz1and3);

        RbcMA Ma2Sz3 = new RbcMA("ICE 12");
        SSP SSP2Sz3 = new SSP();
        speedSegments = new ArrayList<SpeedSegment>();
        speedSegments.add(Segment2To4);
        speedSegments.add(SegmentHalt4);
        copySegmentsToProfile(speedSegments, SSP2Sz3);
        copySpeedProfileIntoMA(SSP2Sz3, Ma2Sz3);
        EoA Eoa2Sz3 = new EoA(Balise4Ch, PlanData.connectorList.get(4), new SectionOfLine());
        setDefaultAuthority(Eoa2Sz3, 0);
        Ma2Sz3.setEndOfAuthority(Eoa2Sz3);

        RbcMA Ma3Sz3 = new RbcMA("ICE 12");
        SSP SSP3Sz3 = new SSP();
        speedSegments = new ArrayList<SpeedSegment>();
        SpeedSegment Segment4To5 = new SpeedSegment(SL4,SL5,ApplicationDirection.BOTH);
        Segment4To5.setV_STATIC(Speed140);
        speedSegments.add(Segment4To5);
        copySegmentsToProfile(speedSegments, SSP3Sz3);
        copySpeedProfileIntoMA(SSP3Sz3, Ma3Sz3);
        EoA Eoa3Sz3 = new EoA(Balise5Ch, PlanData.connectorList.get(5), new SectionOfLine());
        setDefaultAuthority(Eoa3Sz3, Speed140.bSpeed);
        Ma3Sz3.setEndOfAuthority(Eoa3Sz3);

        RbcMA Ma4Sz3 = new RbcMA("ICE 12");
        SSP SSP4Sz3 = new SSP();
        speedSegments = new ArrayList<SpeedSegment>();
        SpeedSegment Segment5To5Half = new SpeedSegment(SL5,SL5Half, ApplicationDirection.BOTH);
        Segment5To5Half.setV_STATIC(Speed140);
        speedSegments.add(Segment5To5Half);
        speedSegments.add(Segment5HalfTo7);
        copySegmentsToProfile(speedSegments,SSP4Sz3);
        copySpeedProfileIntoMA(SSP4Sz3, Ma4Sz3);
        EoA Eoa4Sz3 = new EoA(Balise7, PlanData.connectorList.get(7), new SectionOfLine());
        setDefaultAuthority(Eoa4Sz3, Speed120.bSpeed);
        Ma4Sz3.setEndOfAuthority(Eoa4Sz3);

        RbcMA Ma5Sz3 = new RbcMA("ICE 12");
        SSP SSP5Sz3 = new SSP();
        speedSegments = new ArrayList<SpeedSegment>();
        SpeedSegment Segment7To8 = new SpeedSegment(SL7, SL8, ApplicationDirection.BOTH);
        Segment7To8.setV_STATIC(Speed100);
        speedSegments.add(Segment7To8);
        copySegmentsToProfile(speedSegments, SSP5Sz3);
        copySpeedProfileIntoMA(SSP5Sz3, Ma5Sz3);
        EoA Eoa5Sz3 = new EoA(Balise8, PlanData.connectorList.get(8), new SectionOfLine());
        setDefaultAuthority(Eoa5Sz3, Speed100.bSpeed);
        Ma5Sz3.setEndOfAuthority(Eoa5Sz3);

        RbcMA Ma6Sz3 = new RbcMA("ICE 12");
        SSP SSP6Sz3 = new SSP();
        speedSegments = new ArrayList<SpeedSegment>();
        SpeedSegment Segment8ToEnd = new SpeedSegment(SL8, SLEnd, ApplicationDirection.BOTH);
        Segment8ToEnd.setV_STATIC(Speed100);
        speedSegments.add(Segment8ToEnd);
        copySegmentsToProfile(speedSegments, SSP6Sz3);
        copySpeedProfileIntoMA(SSP6Sz3, Ma6Sz3);
        EoA Eoa6Sz3 = new EoA(RightCh, PlanData.RightEnd, new SectionOfLine());
        setDefaultAuthority(Eoa6Sz3, 0);
        Ma6Sz3.setEndOfAuthority(Eoa6Sz3);

        S3.addMa(Ma2Sz3);
        S3.addMa(Ma3Sz3);
        S3.addMa(Ma4Sz3);
        S3.addMa(Ma5Sz3);
        S3.addMa(Ma6Sz3);

        allSzenarios.add(S3);



    }

    private static void setDefaultAuthority(EoA eoa, int speedAtEnd) {
        eoa.setQ_OVERLAP(false);
        eoa.setQ_DANGERPOINT(false);
        eoa.setQ_ENDTIMER(false);
        eoa.setQ_scale(Q_SCALE.SCALE_1_M);
        eoa.setT_ENDTIMER(new ETCS_TIMER());
        eoa.setOverlap(null);
        eoa.setDangerPoint(null);
        eoa.setD_ENDTIMERSTARTLOC(null);
        eoa.setV_EMA(speedAtEnd);
    }

    private static void copySpeedProfileIntoMA(SSP Ssp, RbcMA Ma) {
        SSP SspCopy = new SSP();
        SspCopy.setSpeedSegments(Ssp.getSpeedSegments());
        SspCopy.setMovementAuthority(Ma);
        Ma.setSpeedProfile(SspCopy);
    }

    private static void copySegmentsToProfile(List<SpeedSegment> speedSegments, SSP ssp) {
        ArrayList<SpeedSegment> copyList = new ArrayList<SpeedSegment>();
        for(SpeedSegment Segment : speedSegments) {
            SpeedSegment CopySegment = new SpeedSegment(Segment.getBegin(), Segment.getEnd(), Segment.getDirection());
            CopySegment.setV_STATIC(Segment.getV_STATIC());
            CopySegment.setNc_DIFF(Segment.getNc_DIFF());
            CopySegment.setNc_CDDIFF(Segment.getNc_CDDIFF());
            CopySegment.setSpeedChangeEnd(Segment.getSpeedChangeEnd());
            CopySegment.setSsp(ssp);
            copyList.add(CopySegment);

        }
        ssp.setSpeedSegments(copyList);



    }

    static {
        generateScenarios();
    }

    public String ScenarioName;
    public int iPort = 22223;
    public List<Scenario> getListSzenario() {
        return allSzenarios;
    }
    private LinkedBlockingQueue<RbcMA> MaQueue = new LinkedBlockingQueue<RbcMA>();



    public void addMa(RbcMA Ma) {
        this.MaQueue.add(Ma);
    }

    public RbcMA getNext() {
        return this.MaQueue.poll();
    }
    public boolean isEmpty() {
        return this.MaQueue.isEmpty();
    }

    public void runCustomSzenario() throws IOException {
        this.iPort = 22223;
        RunningSzenario = this;
        useStringServing();
    }

    public void runSzenario() throws IOException {
        if(RunningSzenario == null) {
            MainTmsSim.MainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            MainTmsSim.MainFrame.setTitle("TMS SIM running - take care");
            RunningSzenario = this;
            if(isObject) {
                useObjectServing();
            } else {
                useStringServing();
            }
        } else {
            System.err.println("One Scenario already running");
        }
    }

    private void useObjectServing() throws IOException {
        SocketServer<String, RbcMA> ServeRbc = new SocketServer<String, RbcMA>(iPort) {
            @Override
            public RbcMA processRequest(String Req) {

                RbcMA NextMA = serveMaForRbc();
                if (NextMA == null) return null;
                    return NextMA;

            }
        };
    }

    private void useStringServing() throws IOException {
        SocketServer<String, String> ServeRbc = new SocketServer<String, String>(iPort) {
            @Override
            public String processRequest(String Req) {

                RbcMA NextMA = serveMaForRbc();


                try {
                    return NextMA.toJson();
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    private RbcMA serveMaForRbc() {
        if(RunningSzenario == null) {
            MainTmsSim.MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            MainTmsSim.MainFrame.setTitle("TMS SIM (finished)");
            return prepareShuntingMa();
        }
        RbcMA NextMA = RunningSzenario.getNext();

        if(NextMA == null && RunningSzenario.isEmpty()) {

            NextMA = prepareShuntingMa();

        }
        if(RunningSzenario.isEmpty()) {
            RunningSzenario = null;
            MainTmsSim.MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            MainTmsSim.MainFrame.setTitle("TMS SIM (finished)");

        }
        if(sTrainName == null) {
            sTrainName = NextMA.sTrainId;
        }
        EoA eoa = NextMA.getEndOfAuthority();
        TrackElement TRC = eoa.getTrackElement();
        if(TRC instanceof RailConnector) {
            TrackElement Trail = TRC.getPositionedRelations().get(0).getFrom();
            ArrayList<TrackElement> markOccupiedList = new ArrayList<TrackElement>();
            markOccupiedList.add(Trail);
            PlanData.trainOccupiedList = (ArrayList<TrackElement>) markOccupiedList;
        }  else if(TRC instanceof EdgeOfMap) {
            TrackElement Trail = TRC.getPositionedRelations().get(0).getFrom();
            ArrayList<TrackElement> markOccupiedList = new ArrayList<TrackElement>();
            markOccupiedList.add(Trail);
            PlanData.trainOccupiedList = (ArrayList<TrackElement>) markOccupiedList;
        }
        MainTmsSim.updateSubViews();
        return NextMA;
    }

    private RbcMA prepareShuntingMa() {
        RbcMA NextMA;
        EoA ShuntingEoA = new EoA(null,null,null);

        RbcMA ShuntingMa = new RbcMA(sTrainName);
        ShuntingMa.setEndOfAuthority(ShuntingEoA);
        NextMA = ShuntingMa;
        return NextMA;
    }


}
