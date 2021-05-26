package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.positioning.GeometricCoordinate;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-08-28
 */
public class LinkedGeo {
    private GeometricCoordinate StartCoordinates;
    private GeometricCoordinate EndCoordinatees;

    private DefaultRepo<GeometricCoordinate, CGEOKante> linkage = new DefaultRepo<>();
    private DefaultRepo<CGEOKante, Boolean> isAccessedFromA = new DefaultRepo<>();
    private ArrayList<CGEOKante> usedEdges = new ArrayList<>();

    public ArrayList<CGEOKante> getUsedEdgesSorted() {
        return usedEdges;
    }

    /**
     * Verlinkt alle Geographischen Kanten vom Start eine Topologischen Kante bis zum Ende der Topologischen Kante
     * @param geoEdgeList - alle Kanten von edge
     * @param b_fromA - true := Startpunkt ist der Topologische Knoten A auf edge
     *                - false := Startpunkt ist der Topologische Knoten B auf edge
     * @param edge - Topologische Kanten fuer die die Geographie verknuepft werden soll
     * @throws Exception - wirft Fehler wenn vom Start nicht zum Ziel gelangt werden kann
     */
    public LinkedGeo(ArrayList<CGEOKante> geoEdgeList, boolean b_fromA, TopologyGraph.Edge edge) throws Exception {

        boolean isEndReached = false;
        GeometricCoordinate CurrentPos = null;
        if(b_fromA) {
           StartCoordinates = edge.A.getGeoCoordinates();
           EndCoordinatees = edge.B.getGeoCoordinates();
        } else {
           StartCoordinates = edge.B.getGeoCoordinates();
           EndCoordinatees = edge.A.getGeoCoordinates();
        }
        CurrentPos = StartCoordinates;
        while(!isEndReached) {
            boolean hasOneMatch = false;
            for(CGEOKante GeoEdge : geoEdgeList) {
                if(usedEdges.contains(GeoEdge)) continue;
                GeometricCoordinate nodeA = PlanData.GeoNodeRepo.getModel(GeoEdge.getIDGEOKnotenA().getWert());
                GeometricCoordinate nodeB = PlanData.GeoNodeRepo.getModel(GeoEdge.getIDGEOKnotenB().getWert());


                if(checkIfNear(CurrentPos, nodeA)) {
                    hasOneMatch = true;
                    usedEdges.add(GeoEdge);
                    isAccessedFromA.update(GeoEdge, true);
                    linkage.update(CurrentPos, GeoEdge);
                    if(checkIfNear(EndCoordinatees,nodeB)) return;
                    CurrentPos = nodeB;
                    continue;
                }
                if(checkIfNear(CurrentPos, nodeB)) {
                    hasOneMatch = true;
                    usedEdges.add(GeoEdge);
                    isAccessedFromA.update(GeoEdge, false);
                    linkage.update(CurrentPos, GeoEdge);
                    if(checkIfNear(EndCoordinatees,nodeA)) return;
                    CurrentPos = nodeA;
                    continue;
                }


            }
            if(!hasOneMatch) throw new Exception("Geo Linkage cannot be created.");
        }




    }

    /**
     * unused
     * @param geoCo
     * @return
     */
    public CGEOKante getNextEdge(GeometricCoordinate geoCo) {
        return this.linkage.getModel(geoCo);
    }

    /**
     * gibt für eine Geographische Kante an, ob die Kante von Geoknoten A von Richtung des Topologischen Knoten A
     * betreten wird
     * @param GeoEdge - die Geographische Kante die untersucht wird
     * @return true := GeoEdge wird von Geo-Knoten A durchlaufen
     *         false := GeoEdge wird von Geo-Knoten B durchlaufen
     */
    public boolean isNextAccessedFromA(CGEOKante GeoEdge) {
        return this.isAccessedFromA.getModel(GeoEdge);
    }

    private boolean checkIfNear(GeometricCoordinate currentPos, GeometricCoordinate otherGeo) {
        BigDecimal dx1 = new BigDecimal(currentPos.getX());
        BigDecimal dx2 = new BigDecimal(otherGeo.getX());
        BigDecimal dy1 = new BigDecimal(currentPos.getY());
        BigDecimal dy2 = new BigDecimal(otherGeo.getY());
        BigDecimal dFactor = new BigDecimal(1.0d);

        if(dx1.subtract(dx2).abs().compareTo(dFactor) <= 0 && dy1.subtract(dy2).abs().compareTo(dFactor) <= 0)
            return true;
        else return false;


    }


}
