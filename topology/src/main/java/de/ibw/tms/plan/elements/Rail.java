package de.ibw.tms.plan.elements;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Geographisches Gleis
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class Rail extends Line2D.Double implements Iinteractable, ITrack {

    /**
     * Click-Abstand dieses Gleises zum Clickpunkt
     */
    public static double dRailTolerance = 2.0d;

    /**
     * Name des Gleissegmentes
     */
    public String segmentName = " ";
    private TopologyGraph.Edge Edge;

    /**
     * Gibt die Topologiesche Kante dieses Gleis wider
     * @return {@link TopologyGraph.Edge}
     */
    public TopologyGraph.Edge getEdge() {
        return Edge;
    }

    /**
     * Setzt Topologische Kante
     * @param edge {@link TopologyGraph.Edge}
     */
    public void setEdge(TopologyGraph.Edge edge) {
        Edge = edge;
    }

    /**
     * Zeichendicke der Gleiskante
     */
    public int iStroke = 3;

    private Trail TrailModel;

    /**
     * Gibt logisches Model des Gleises wieder
     * @return Trail
     */
    public Trail getTrailModel() {
        return TrailModel;
    }

    /**
     * Verbindung eines TrackElments am Ende A
     */
    public IConnectable ConA;
    /**
     * Verbindung eines TrackElments am Ende B
     */
    public IConnectable ConB;

    /*
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2

    public Rail(float x1, float y1, float x2, float y2) {
        super(x1 *PlanData.f_STRETCH_X, y1, x2 * PlanData.f_STRETCH_X,
                y2);
    }

    @Deprecated
    public Rail(ElementConnectionPoint LeftPoint, ElementConnectionPoint RightPoint, ArrayList<Rail> addTo,
                Chainage C,  ApplicationDirection Navigal, int vmax, ApplicationDirection Direction, TrackElementStatus Status){
        super(LeftPoint.x, LeftPoint.y, RightPoint.x, RightPoint.y);
        addTo.add(this);

        if(y1 == y2) {
            this.iStroke = 10;
        }


    }


    public Rail(double x1, double y1, double x2, double y2, List<Rail> addTo, IConnectable IConA, IConnectable IConB,
                Chainage Cb, Chainage Cc,  ApplicationDirection Navigal, int vmax, ApplicationDirection Direction, TrackElementStatus Status,
                String sectionName
    ) {
        this(x1,y1,x2,y2,addTo,IConA, IConB,Cb, Cc, Navigal, vmax, Direction, Status);
        this.segmentName = sectionName;

    }
*/

    /**
     * Dieser Konstruktur erstellt ein Geographisches Gleis
     * @param x1 - xPosition 1
     * @param y1 - yPosition 1
     * @param x2 - xPosition 2
     * @param y2 - yPosition 2
     * @param addTo {@link List} - Liste von Gleisen, die diese Gleis zugeordnet werden, nach erstellung
     * @param IConA {@link TrackElement} - Anschluss A
     * @param IConB {@link TrackElement} - Anschluss B
     * @param Cb - not used
     * @param Cc - not used
     * @param Navigal - {@link ApplicationDirection} von A zu B, oder B zu A, oder beides
     * @param vmax int - maximale Geschwindigkeit auf diesem Gleis
     * @param Direction - {@link ApplicationDirection} Streckenrichtung von A zu B oder B zu A

     */
    public Rail(double x1, double y1, double x2, double y2, List<Rail> addTo, IConnectable IConA, IConnectable IConB,
                Chainage Cb, Chainage Cc, ApplicationDirection Navigal, int vmax, ApplicationDirection Direction, TrackElementStatus Status
    ) {
        super(x1 , y1, x2 ,  y2 );
        addTo.add(this);

        if(y1 == y2) {
            this.iStroke = 10;
        }

        ConA = IConA;
        ConB = IConB;
        TrailModel = new Trail(Cb, Cc, (TrackElement) ConA, (TrackElement) ConB, Navigal, vmax, Direction,  Status);
        PlanData.TrackElementPositionCalc.put(TrailModel, this);
    }


    /**
     * Kontextmenu-Elemente bei Rechtsklick am Gleis
     * @return List - Ui-Komponenten
     */

    @Override
    public ArrayList<JComponent> getViewElements() {
        ArrayList<JComponent> uiList = new ArrayList<JComponent>();
        uiList.add(new JLabel("<HTML><b><u>".concat(this.getViewName()).concat("</u></b></HTML>")));
        uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
        return uiList;
    }

    /**
     * Bezeichnung des Gleises
     * @return String
     */
    @Override
    public String getViewName() {
        return "Rail";
    }

    /**
     * Gibt Trail als Logik wider
     * @return Trail
     */
    @Override
    public TopologyGraph.Node getTrackReference() {
        return this.getTrackSection();
    }
}
