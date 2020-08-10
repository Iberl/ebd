package de.ibw.tms.plan.elements;

import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *  Not used anymore
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
@Deprecated
public class TopRailReturn implements Iinteractable, ITrack {

    public TopRailReturn(double dx_startNode, double dy_startNode, double dy_returnEdge, double dx_endNode, double dy_endNode) {
        if(dx_endNode == dx_startNode) {
            Line2D.Double LineA = new Line2D.Double(dx_startNode, dy_startNode, dx_startNode + 5.0d, dy_endNode + 5.0d);
            Line2D.Double VerticalLine = new Line2D.Double(dx_startNode + 5.0d, dy_endNode + 5.0d, dx_startNode + 5.0d, dy_endNode - 5.0d);
            Line2D.Double LineB = new Line2D.Double(dx_startNode + 5.0d, dy_endNode - 5.0d, dx_endNode, dy_endNode);
            lineList.add(LineA);
            lineList.add(VerticalLine);
            lineList.add(LineB);
        } else {
            Line2D.Double LineA = new Line2D.Double(dx_startNode, dy_startNode, dx_startNode - 5.0d, dy_returnEdge);
            Line2D.Double HorizontalLine = new Line2D.Double(dx_startNode - 5.0d, dy_returnEdge, dx_endNode + 5.0d, dy_returnEdge);
            Line2D.Double LineB = new Line2D.Double(dx_endNode + 5.0d, dy_returnEdge, dx_endNode, dy_endNode);
            lineList.add(LineA);
            lineList.add(HorizontalLine);
            lineList.add(LineB);

        }
    }

    public int iStroke = 3;

    @Override
    public TrackElement getTrackReference() {
        return null;
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        return null;
    }

    @Override
    public String getViewName() {
        return "Rail Return Topological";
    }

    public ArrayList<Line2D.Double> lineList = new ArrayList<>();


}
