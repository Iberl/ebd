package de.ibw.util;

import de.ibw.feed.Balise;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.ma.positioning.GeometricCoordinate;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.train.model.TrainDistance;
import de.ibw.tms.train.model.TrainModel;
import ebd.SlConfigHandler;
import ebd.internal.payload.Payload_14;
import ebd.internal.util.PositionInfo;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.geodaten._1_9_0.CGEOKnoten;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;
import plan_pro.modell.geodaten._1_9_0.CTOPKnoten;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.security.InvalidParameterException;

import static ebd.messageLibrary.util.ETCSVariables.Q_LENGTH_CONFIRMED_BY_DRIVER;
import static ebd.messageLibrary.util.ETCSVariables.Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE;


/**
 * Uitilities Allgemeiner Art
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.5
 * @since 2021-04-30
 */
public class UtilFunction {

    /**
     * @deprecated
     * @return
     * @throws IOException
     * @throws XmlPullParserException
     */
    public static Model getMavenModel() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        return reader.read(new FileReader("pom.xml"));
    }
    public static String getMavenVersion() throws IOException, XmlPullParserException {
        return SlConfigHandler.getInstance().app_version;
    }

    public static String getVersionDate() throws XmlPullParserException, IOException {
       return SlConfigHandler.getInstance().app_date;
    }

    public static String showVersionString() {
        String resultString = "";
        try {

            String date = getVersionDate();
            if(date == null) date = "";
            else date = "@" + date;
            resultString = getMavenVersion() + date;
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }

        return resultString;

    }







    private static BigDecimal calcNextTargetPointDistance(BigDecimal distanceToNextTargetPoint, TopologyGraph.Edge newTrainPositionEdge, TrainModel tm) {
        BigDecimal result = null;

        result = new BigDecimal(newTrainPositionEdge.dTopLength);
        return distanceToNextTargetPoint.add(result);



    }



    private static BigDecimal calcDistanceFromDP(int q_scale, BigDecimal distance_from_dp) {
        Q_SCALE Q_S = Q_SCALE.getScale(q_scale);

        switch (Q_S) {
            case SCALE_10_CM: {
                distance_from_dp = distance_from_dp.multiply(new BigDecimal(0.1d));
                break;
            }
            case SCALE_1_M: {

                break;
            }
            case SCALE_10_M: {
                distance_from_dp = distance_from_dp.multiply(new BigDecimal(10.0d));
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + q_scale);
        }
        return distance_from_dp;
    }

    private static TrainModel initTrainModel(Integer iEngineId) {
        TrainModel Tm;
        Tm = TrainModel.getDefaultModel();
        Tm.label = String.valueOf(iEngineId);
        Tm.iTrainId = iEngineId;
        Tm.category = "Freight";
        //Package Train Data
        Tm.iSpeedMax = 200;
        Tm.length = 100;
        return Tm;
    }

    /**
     * Verwaltet eingehenden PositionReport
     * @param PositonReport - {@link Payload_14} - Informationen des Position-Reports
     * @param sRBC {@link String} - Name des RBC
     */
    public static TrainModel servePositionReport(Payload_14 PositonReport, String sRBC) {

        Integer iEngineId = null;
        TrainModel Tm = null;





        try {
            boolean b_A_IsTarget = false;
            iEngineId = PositonReport.trainInfo.nid_engine;
            BigDecimal distanceToNextTargetPoint = null;
            Tm = TrainModel.TrainRepo.getModel(iEngineId);

            if (Tm == null) {
                Tm = initTrainModel(iEngineId);
            }
            int q_scale = PositonReport.positionInfo.q_scale;
            BigDecimal distance_from_dp = new BigDecimal(PositonReport.positionInfo.d_lrbg);
            System.out.println("TMS " + "Engine ID: " + iEngineId + " POS_REP_Distance: " + distance_from_dp);
            int bgId = PositonReport.positionInfo.nid_lrbg;
            Tm.setNid_lrbg(bgId);
            Tm.setsLastKnownRBC(sRBC);
            Tm.setQ_DIR(PositonReport.positionInfo.q_dirtrain);
            Balise B = Balise.baliseByNid_bg.getModel(bgId);
            CTOPKante CurrentTopKante = B.getTopPositionOfDataPoint();



            BigDecimal trackMeterOfBalise = new BigDecimal(B.getPlanProDataPoint().getPunktObjektTOPKante().get(0).getAbstand().getWert().doubleValue());




            /*if(BalisReferenc.equals(ENUMWirkrichtung.GEGEN)) {
                System.out.println("TMS " + "Engine ID: " + iEngineId + " Distance from Node B To Balise: " + dDistanceFromRefPointToBalise);
            } else System.out.println("TMS " + "Engine ID: " + iEngineId + " Distance from Node A To Balise: " + dDistanceFromRefPointToBalise);
            System.out.println("Before TOP_KANTE_ID: " + CurrentTopKante.getIdentitaet().getWert());
            */
            distance_from_dp = calcDistanceFromDP(q_scale, distance_from_dp);
            System.out.println("TMS " + "Engine ID: " + iEngineId + " POS_REP_Distance_RECOG_Q_SCALE: " + distance_from_dp);

            TopologyGraph topologyGraph = PlanData.topGraph;
            TopologyGraph.Node TargetNode = null;

            TopologyGraph.Edge NewTrainPositionEdge = topologyGraph.edgeRepo.get(CurrentTopKante.getIdentitaet().getWert());
            if(NewTrainPositionEdge == null) {
                throw new NullPointerException("Balise Not on Track in TopologyGraph");
            }
            BigDecimal dLengthOfEdge = new BigDecimal(NewTrainPositionEdge.dTopLength);
            /*boolean isNominal;
            if(iEngineId == 1) {

                isNominal = ConfigHandler.getInstance().train1StartingInTrackDirection;
            } else if(iEngineId == 2) {
                isNominal = ConfigHandler.getInstance().train2StartingInTrackDirection;

            } else return null;

            if(isNominal) {
                TargetNode = NewTrainPositionEdge.B;





                distanceToNextTargetPoint = dLengthOfEdge.subtract(trackMeterOfBalise);


                b_A_IsTarget = false;

            } else {
                TargetNode = NewTrainPositionEdge.A;

                distanceToNextTargetPoint = trackMeterOfBalise;

                b_A_IsTarget = true;
            }
            */
            Tm.setNodeTrainRunningTo(TargetNode);
            distanceToNextTargetPoint = distanceToNextTargetPoint.abs();
            Tm.setdDistanceToNodeRunningTo(distanceToNextTargetPoint.doubleValue());


            System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToNextWaypoint: " + distanceToNextTargetPoint);

            while(distance_from_dp.compareTo(distanceToNextTargetPoint) > 0 ) {

                TopologyGraph.Edge TempPosEdge = null;
                Tm.addPassedElement(NewTrainPositionEdge);
                Tm.addPassedElement(TargetNode);
                if(TempPosEdge.A == TargetNode) {
                    TargetNode = TempPosEdge.B;
                    b_A_IsTarget = false;
                } else if(TempPosEdge.B == TargetNode) {
                    TargetNode = TempPosEdge.A;
                    b_A_IsTarget = true;
                } else {
                    throw new Exception("Node missmatch, cannot find node connection");
                }
                NewTrainPositionEdge = TempPosEdge;
                //dDistanceToTrainFromReferencePoint = distance_from_dp.subtract(distanceToNextTargetPoint);

                //System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToTrainFromReferencePoint: " + dDistanceToTrainFromReferencePoint);
                distanceToNextTargetPoint = calcNextTargetPointDistance(distanceToNextTargetPoint, NewTrainPositionEdge, Tm);//distanceToNextTargetPoint + NewTrainPositionEdge.dTopLength;
                System.out.println("TMS " + "Engine ID: " + iEngineId + " DistanceToNextWaypoint: " + distanceToNextTargetPoint);


            }

            distanceToNextTargetPoint = distanceToNextTargetPoint.subtract(distance_from_dp);



            Tm.length = UtilFunction.getTrainLength(PositonReport.positionInfo).intValue();


            DoubleCoord CoordTrainFront = new DoubleCoord();
            DoubleCoord CoordTrainEnd = new DoubleCoord();
            //dDistanceToTrainFromReferencePoint = distanceToNextTargetPoint - distance_from_dp;



            DefaultRepo<String, CBasisObjekt> geoPointRepo = PlanData.getInstance().getGeoBundle().getModel(CGEOKnoten.class);
            DefaultRepo<String, CBasisObjekt> topNodeRepo = PlanData.getInstance().getGeoBundle().getModel(CTOPKnoten.class);

            //CTOPKante TopKante =  B.getTopPositionOfDataPoint();
            String sKnotenAid = NewTrainPositionEdge.A.TopNodeId;
            String sKnotenBid = NewTrainPositionEdge.B.TopNodeId;
            CTOPKnoten N_A = (CTOPKnoten) topNodeRepo.getModel(sKnotenAid);
            CTOPKnoten N_B = (CTOPKnoten) topNodeRepo.getModel(sKnotenBid);
            CGEOKnoten GeoNodeA = (CGEOKnoten) geoPointRepo.getModel(N_A.getIDGEOKnoten().getWert());
            CGEOKnoten GeoNodeB = (CGEOKnoten) geoPointRepo.getModel(N_B.getIDGEOKnoten().getWert());
            GeometricCoordinate Geo_A = PlanData.GeoNodeRepo.getModel(GeoNodeA.getIdentitaet().getWert());
            GeometricCoordinate Geo_B = PlanData.GeoNodeRepo.getModel(GeoNodeB.getIdentitaet().getWert());


            Tm.setEdgeTrainStandsOn(NewTrainPositionEdge);
            double distanceToBackOfTrain = distanceToNextTargetPoint.add(new BigDecimal(Tm.length)).doubleValue();
            if(distanceToBackOfTrain > NewTrainPositionEdge.dTopLength) {
                distanceToBackOfTrain = NewTrainPositionEdge.dTopLength -1;
            }
            TrainDistance TD = new TrainDistance(b_A_IsTarget, distanceToNextTargetPoint.doubleValue(), distanceToBackOfTrain);
            Tm.setNodeTrainRunningTo(TargetNode);
            /*

            MainGraphicPanel.getGeoCoordinate(NewTrainPositionEdge.sId, !b_A_IsTarget)


            Line2D.Double resultPainting = new Line2D.Double();
            double d_distance_from_referencePointToTrainEnd = dDistanceToTrainFromReferencePoint - Tm.length;
            double d_DistanceTrainToTargetPoint = 0d;
            if(TargetNode == NewTrainPositionEdge.A) {
                // TargetNode is A => Train comes from B

                // Geo_B is referencePoint
                CoordTrainFront = (DoubleCoord) UtilFunction.calcTargetGeoByStartPoint(CoordTrainFront,
                        -dDistanceToTrainFromReferencePoint, Geo_B, Geo_A);



                CoordTrainEnd = (DoubleCoord) UtilFunction.calcTargetGeoByStartPoint(CoordTrainEnd,
                        -d_distance_from_referencePointToTrainEnd, Geo_B, Geo_A);

                    if(dDistanceToTrainFromReferencePoint < 0) {
                        d_DistanceTrainToTargetPoint = NewTrainPositionEdge.dTopLength -1 ;
                    } else d_DistanceTrainToTargetPoint = dDistanceToTrainFromReferencePoint;



                Tm.setdDistanceToNodeRunningTo(d_DistanceTrainToTargetPoint);

            } else if(TargetNode == NewTrainPositionEdge.B) {
                // TargetNode is B => Train comes from A

                // Geo_A is referencePoint
                CoordTrainFront= (DoubleCoord) UtilFunction.calcTargetGeoByStartPoint(CoordTrainFront,
                        dDistanceToTrainFromReferencePoint, Geo_A, Geo_B);
                CoordTrainEnd = (DoubleCoord) UtilFunction.calcTargetGeoByStartPoint(CoordTrainEnd,
                        d_distance_from_referencePointToTrainEnd, Geo_A, Geo_B);

                    d_DistanceTrainToTargetPoint = NewTrainPositionEdge.dTopLength - dDistanceToTrainFromReferencePoint;

                Tm.setdDistanceToNodeRunningTo(d_DistanceTrainToTargetPoint);

            } else {
                throw new Exception("Node missmatch, cannot find node connection");
            }

            resultPainting = new Line2D.Double(CoordTrainEnd.getX(), CoordTrainEnd.getY(), CoordTrainFront.getX(),
                                    CoordTrainFront.getY());

            Tm.setTrainUiLine(resultPainting);
            Tm.setEdgeTrainStandsOn(NewTrainPositionEdge);
            System.out.println("Result TOP_KANTE: " + NewTrainPositionEdge.sId);
            Tm.setNodeTrainRunningTo(TargetNode);
            System.out.println(("Result TOP_NODE drivingTo: " + TargetNode.TopNodeId));
            TrainDistance TD = null;
            //DEBUG

            double d1 = NewTrainPositionEdge.dTopLength - d_DistanceTrainToTargetPoint;
            if(d1 > NewTrainPositionEdge.dTopLength) {
                d1 = NewTrainPositionEdge.dTopLength - 1;
            } else if(d1 < 0) d1 = 0;

            double d2 = d1 - Tm.length;
            if(d2 < 0) d2 = 0;


            TD = new TrainDistance(b_A_IsTarget ,d2, d1);
            */
            Tm.setDistanceRefPointOfEdge(TD);


        } catch(Exception E) {
            return null;
        }
        return Tm;

    }



    /**
     * Berechnet aus den positionInfo die L&auml;nge
     * @param positionInfo - {@link PositionInfo} Positonsangabe aus dem RBC
     * @return BigDecimal - L&auml;nge des Zuges
     */
    public static BigDecimal getTrainLength(PositionInfo positionInfo) {
        if(positionInfo.q_length == Q_LENGTH_CONFIRMED_BY_DRIVER ||
                positionInfo.q_length == Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE) {
           return new BigDecimal(positionInfo.l_trainint);
        } else {
            BigDecimal dLength = new BigDecimal(SlConfigHandler.getInstance().D_DEFAULT_MIN_LENGTH);
            if(dLength.compareTo(new BigDecimal("0")) < 0)
                throw new InvalidParameterException("The default length of trains must not be negative");
            return dLength;
        }

    }


    /**
     * Trennt Einheit von Wert. Gibt den Wert als int wider.
     * @param sInputSpeed {@link String} - Wert und Einheit
     * @return int
     * @throws NumberFormatException - Wenn Wert sich nciht als Integer dargestellt werden kann.
     */
    public static int formatStringToInt(String sInputSpeed) throws NumberFormatException {
        String[] arr = sInputSpeed.split(" ", 2);

        String firstWord = arr[0];
        int iInitialSpeed;
        try {
            iInitialSpeed = Integer.parseInt(firstWord);
        } catch(NumberFormatException e) {
            throw e;

        }
        return iInitialSpeed;
    }

    /**
     * Gegeben sind zwei Coordinaten. In der Linie auf den beiden Coordinate wird der Punkt widergegeben der den Abstand dA von Coordinate A hat.
     * @param CalcTarget {@link ICoord} Die ZielCoordinate, das Ergebnis
     * @param dA - Abstand zu Coordinate A
     * @param geo_A - {@link GeometricCoordinate} A
     * @param geo_B {@link GeometricCoordinate} B
     * @return ICoord - Ergebnis
     */
    public static ICoord<Double> calcTargetGeoByStartPoint(ICoord<Double> CalcTarget, double dA, GeometricCoordinate geo_A, GeometricCoordinate geo_B) {
        double dx_diff = geo_B.getX() - geo_A.getX();
        if(dx_diff == 0d) {
            double dYnew = geo_A.getY() + dA;
            CalcTarget.setX(geo_B.getX());
            CalcTarget.setY(dYnew);
        } else {

            double dYdiff = geo_B.getY() - geo_A.getY();

            double radians = Math.atan(dYdiff/dx_diff);
            double xAdd = Math.cos(radians) * dA;
            double yAdd = Math.sin(radians) * dA;
            CalcTarget.setX(geo_A.getX() + xAdd);
            CalcTarget.setY(geo_A.getY() + yAdd);
            //B.setX(Geo_A.getX());
            //B.setY(Geo_A.getY());

        }
        return CalcTarget;
    }

    /**
     * Intrinisic calculator
     * @param dTopLength - double whole edge length
     * @param scale {@link de.ibw.tms.ma.occupation.Occupation.BLOCK_Q_SCALE} - Q_Scale
     * @param iDistance int - distance in q_scale units
     * @return double - result in 0 - 1 as percents but not form 0 to 100, but form 0.0 to 1.0
     */
    public static double generateIntrinsic(double dTopLength, Occupation.BLOCK_Q_SCALE scale, int iDistance) {
        if(iDistance + 1 >= dTopLength) return 1;
        BigDecimal dTop = new BigDecimal(dTopLength);
        BigDecimal dDistance = new BigDecimal(iDistance);
        BigDecimal dExponent = new BigDecimal(scale.getiScaleValue() - 1);
        BigDecimal dPartDistance = dDistance.multiply(new BigDecimal(10).pow(dExponent.intValue()));
        if(dPartDistance.compareTo(new BigDecimal(0)) >= 0 && dPartDistance.compareTo(dTop) <= 0) {
           return dPartDistance.divide(dTop, MathContext.DECIMAL32).doubleValue();
        }
        throw new InvalidParameterException("Subdistance has to be larger than 0 but smaller than whole Edgelength");
    }
}
