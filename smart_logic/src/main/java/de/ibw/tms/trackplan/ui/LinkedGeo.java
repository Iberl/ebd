package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.GeoCoordinates;
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
    private GeoCoordinates StartCoordinates;
    private GeoCoordinates EndCoordinatees;

    private DefaultRepo<GeoCoordinates, CGEOKante> linkage = new DefaultRepo<>();
    private DefaultRepo<CGEOKante, Boolean> isAccessedFromA = new DefaultRepo<>();
    private ArrayList<CGEOKante> usedEdges = new ArrayList<>();

    public ArrayList<CGEOKante> getUsedEdgesSorted() {
        return usedEdges;
    }

    public LinkedGeo(ArrayList<CGEOKante> geoEdgeList, boolean b_fromA, TopologyGraph.Edge edge) throws Exception {

        boolean isEndReached = false;
        GeoCoordinates CurrentPos = null;
        if(b_fromA) {
           StartCoordinates = edge.A.TE.getGeoCoordinates();
           EndCoordinatees = edge.B.TE.getGeoCoordinates();
        } else {
           StartCoordinates = edge.B.TE.getGeoCoordinates();
           EndCoordinatees = edge.A.TE.getGeoCoordinates();
        }
        CurrentPos = StartCoordinates;
        while(!isEndReached) {
            boolean hasOneMatch = false;
            for(CGEOKante GeoEdge : geoEdgeList) {
                if(usedEdges.contains(GeoEdge)) continue;
                GeoCoordinates nodeA = PlanData.GeoNodeRepo.getModel(GeoEdge.getIDGEOKnotenA().getWert());
                GeoCoordinates nodeB = PlanData.GeoNodeRepo.getModel(GeoEdge.getIDGEOKnotenB().getWert());


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

    public CGEOKante getNextEdge(GeoCoordinates geoCo) {
        return this.linkage.getModel(geoCo);
    }

    public boolean isNextAccessedFromA(CGEOKante GeoEdge) {
        return this.isAccessedFromA.getModel(GeoEdge);
    }

    private boolean checkIfNear(GeoCoordinates currentPos, GeoCoordinates otherGeo) {
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
