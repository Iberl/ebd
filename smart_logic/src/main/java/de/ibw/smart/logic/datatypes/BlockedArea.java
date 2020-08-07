package de.ibw.smart.logic.datatypes;

import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
/**
 * Diese Klasse stellt Blockierte Gleisabschnitte dar.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public class BlockedArea {

    /**
     * Dieser Datentyp ist die Einheit der zugeordneten Distanzen von 10CM , 1M und 10M kann verwendet werden
     */
    public enum BLOCK_Q_SCALE {

        Q_SCALE_10CM(0), Q_SCALE_1M(1), Q_SCALE_10M(2);

        private final int iScaleValue;

        BLOCK_Q_SCALE (int i_scale) {
            this.iScaleValue = i_scale;
        }

        public int getiScaleValue() {
            return iScaleValue;
        }
    }

    /**
     * Single Element beeing blocked
     * it can not a track and an element be blocked in one Blocked Area
     */
    private TrackElement BlockedElement;
    /**
     * a longer Track beeing blocked
     * it can not a track and an element be blocked in one Blocked Area
     */
    private TopologyGraph.Edge Edge;
    /**
     * Scale Distance from Point A of Edge to Start Ma or Start of Edge
     */
    private BLOCK_Q_SCALE q_scale_block_To_StartMa;
    /**
     * Distance from Point A of Edge to Start Ma or Start of Edge
     */
    private int d_from_PointA_of_GeoEdge_to_BlockStartMa;
    /**
     * Scale Distance from Point A of Edge to End Ma or End of Edge
     */
    private BLOCK_Q_SCALE q_scale_block_To_EndMa;
    /**
     *  Distance from Point A of Edge to End Ma or End of Edge
     */
    private int d_from_PointA_of_GeoEdge_to_BlockEndMa;

    /**
     * Dieser Konstruktor instanziiiert eine Sperrzone auf einer Kante E von einem Startpunkt bis zu einem Endpunkt
     * @param E Edge beeing blocked
     * @param Start_Ma - Q_Scale Start
     * @param d_A_to_Block_Start - Distance a to Ma- or Block-Start
     * @param End_Ma - Q_Scale End
     * @param d_A_to_Block_End - Distence to Ma- or Block-End
     */
    public BlockedArea(TopologyGraph.Edge E, BLOCK_Q_SCALE Start_Ma, int d_A_to_Block_Start, BLOCK_Q_SCALE End_Ma,
                       int d_A_to_Block_End) {
        this.Edge = E;
        this.q_scale_block_To_StartMa = Start_Ma;
        this.d_from_PointA_of_GeoEdge_to_BlockStartMa = d_A_to_Block_Start;
        this.q_scale_block_To_EndMa = End_Ma;
        this.d_from_PointA_of_GeoEdge_to_BlockEndMa = d_A_to_Block_End;
    }

    /**
     * Dieser Konstruktor instanziiert eine Sperrzone auf ein einzelnes Element wie eine Weiche
     * @param Element beeing Blocked
     */
    public BlockedArea(TrackElement Element) {
        this.BlockedElement = Element;
    }

    public boolean compareIfIntersection(BlockedArea OtherArea) {
        boolean hasSameType = check4BeeingSameTrackElementType(OtherArea);
        if(!hasSameType) return false;
        else {
            if(this.Edge == null) {
                // both are no RailsType
                TopologyGraph.Node thisNode = (TopologyGraph.Node) this.BlockedElement;
                TopologyGraph.Node N2 = (TopologyGraph.Node) OtherArea.BlockedElement;
                // same -> then there oul be an intersection on node
                return thisNode.TopNodeId.equals(N2.TopNodeId);

            } else {

                if(!this.Edge.sId.equals(OtherArea.Edge.sId)) return false;
                else return this.intersects(this, OtherArea);


            }
        }
    }

    private boolean intersects(BlockedArea blockedArea, BlockedArea otherArea) {

        int iStart1 = (int) (blockedArea.d_from_PointA_of_GeoEdge_to_BlockStartMa * Math.pow(10, blockedArea.q_scale_block_To_StartMa.getiScaleValue()));
        int iEnd1 = (int) (blockedArea.d_from_PointA_of_GeoEdge_to_BlockStartMa * Math.pow(10, blockedArea.q_scale_block_To_EndMa.getiScaleValue()));
        int iStart2 = (int) (otherArea.d_from_PointA_of_GeoEdge_to_BlockStartMa * Math.pow(10, otherArea.q_scale_block_To_StartMa.getiScaleValue()));
        int iEnd2 = (int) (otherArea.d_from_PointA_of_GeoEdge_to_BlockStartMa * Math.pow(10, otherArea.q_scale_block_To_EndMa.getiScaleValue()));
        // one line is complet for other line
        return (iStart1 >= iStart2 || iEnd1 >= iStart2) && (iStart2 >= iStart1 || iEnd2 >= iStart1);

    }

    private boolean check4BeeingSameTrackElementType(BlockedArea otherArea) {
        if(this.Edge == null && otherArea.Edge != null) return false;
        if(otherArea != null && otherArea.Edge == null) return false;
        return true;
        // returns true when its same rail or both ar not a rail

    }

}
