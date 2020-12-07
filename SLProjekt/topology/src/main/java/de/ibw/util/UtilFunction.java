package de.ibw.util;

import de.ibw.tms.ma.GeoCoordinates;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Uitilities Allgemeiner Art
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-09-14
 */
public class UtilFunction {

    /**
     * Gibt an ob das Modul als Smart-Logic oder als TMS gestartet wurde
     * true :=  SmartLogic
     * false := TMS
     */
    public static boolean IS_STARTED_AS_SL;

    /**
     * Berechnet die GeoCoordinate zu einer Topologischen Kante mit Bezug zu einem Knoten mit distanz.
     * @param TopKanteId {@link String} - Knoten Id PlanPro
     * @param b_fromA boolean - ist von A gemessen worden
     * @param distanceA1 double - Abstand zum Referenzknoten
     * @return GeoCoordinates - Geographischer Punkt
     */
    public static GeoCoordinates getGeoCoordinate(String TopKanteId, boolean b_fromA, double distanceA1) {
        // Get TopEdge
        HashMap edgeRepo = PlanData.topGraph.edgeRepo;
        TopologyGraph.Edge edge = (TopologyGraph.Edge) edgeRepo.get(TopKanteId);
        if(edge.dTopLength < distanceA1) throw new IllegalArgumentException("The desired point must lay on the top edge.");
        ArrayList<CGEOKante> geoEdgeList = edge.getPaintListGeo();

        double lengthOfGeoEdges = 0;
        for(CGEOKante geoEdge : geoEdgeList) {
            lengthOfGeoEdges += geoEdge.getGEOKanteAllg().getGEOLaenge().getWert().doubleValue();
        }

        if (geoEdgeList.isEmpty() || Math.abs(edge.dTopLength - lengthOfGeoEdges) > 1) {
            GeoCoordinates nodeA = edge.A.getGeoCoordinates();
            GeoCoordinates nodeB = edge.B.getGeoCoordinates();

            if(geoEdgeList.isEmpty()) return createGeoCoordinates(b_fromA, edge.dTopLength, distanceA1, nodeA, nodeB);
            else {
                distanceA1 = distanceA1 * lengthOfGeoEdges / edge.dTopLength;
            }


        }

        double    prevDistance  = 0;
        double    geoEdgeLength = 0;
        CGEOKante geoEdge       = null;

        int i = b_fromA ? 0 : geoEdgeList.size();
        for(; (b_fromA && i < geoEdgeList.size() || !b_fromA && i > 0); i = b_fromA ? (i + 1) : (i - 1)) {
            geoEdge = geoEdgeList.get(i);
            geoEdgeLength = geoEdge.getGEOKanteAllg().getGEOLaenge().getWert().doubleValue();
            if(distanceA1 <= prevDistance + geoEdgeLength) break;
            prevDistance += geoEdgeLength;
        }
        return getGeoCoordinate(geoEdge, b_fromA, distanceA1 - prevDistance);
    }

    /**
     * Holt die Geographischen Coordinaten eines Punktes auf einer Geo-Kante
     * @param geoEdge {@link CGEOKante} - Kante des Punktes
     * @param b_fromA boolean - Abstand vom Punkt A der Geo-Kante
     * @param distance double - Abstand von A in Meter
     * @return GeoCoordinates - Ergebnis als Coordinate auf der geoEdge
     */
    public static GeoCoordinates getGeoCoordinate(CGEOKante geoEdge, boolean b_fromA, double distance) {
        double geoEdgeLength = geoEdge.getGEOKanteAllg().getGEOLaenge().getWert().doubleValue();
        if(geoEdgeLength < distance) {
            throw new IllegalArgumentException("The desired point must lay on the geo edge.");
        }

        // Helper values for calculating the coordinates
        GeoCoordinates nodeA = PlanData.GeoNodeRepo.getModel(geoEdge.getIDGEOKnotenA().getWert());
        GeoCoordinates nodeB = PlanData.GeoNodeRepo.getModel(geoEdge.getIDGEOKnotenB().getWert());

        // Create a new Coordinates instance
        return createGeoCoordinates(b_fromA, geoEdgeLength, distance, nodeA, nodeB);
    }

    private static GeoCoordinates createGeoCoordinates(boolean b_fromA, double edgeLength, double distance, GeoCoordinates nodeA, GeoCoordinates nodeB) {
        GeoCoordinates coordinates = new GeoCoordinates();

        double ratio = distance / edgeLength;
        double dx = ratio * (b_fromA ?  nodeB.getX() - nodeA.getX() : nodeA.getX() - nodeB.getX());
        double dy = ratio * (b_fromA ?  nodeB.getY() - nodeA.getY() : nodeA.getY() - nodeB.getY());

        if(b_fromA) {
            coordinates.setX(nodeA.getX() + dx);
            coordinates.setY(nodeA.getY() + dy);
        } else {
            coordinates.setX(nodeB.getX() + dx);
            coordinates.setY(nodeB.getY() + dy);
        }
        return coordinates;
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
     * @param geo_A - {@link GeoCoordinates} A
     * @param geo_B {@link GeoCoordinates} B
     * @return ICoord - Ergebnis
     */
    public static ICoord<Double> calcTargetGeoByStartPoint(ICoord<Double> CalcTarget, double dA, GeoCoordinates geo_A, GeoCoordinates geo_B) {
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
}
