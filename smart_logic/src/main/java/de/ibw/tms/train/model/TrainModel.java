package de.ibw.tms.train.model;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.ThreadedRepo;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
/**
 * Modell eines Zuges, das bei Positionreports neu angelegt wird.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-08-12
 */
public class TrainModel {

    /**
     * Verwaltet alle Z&uuml;ge als Repository, Keys sind die Nid-Engine-ID, Values das jeweilige Modell.
     */
    public static ThreadedRepo<Integer, TrainModel> TrainRepo = new ThreadedRepo<>();





    /**
     * Verwaltet benutzte Zugbezeichner als Liste
     */
    public static ArrayList<String> usedLabelList = new ArrayList<String>();
    /**
     * Verwaltet bentzte Zugfarben als Liste
     */
    public static ArrayList<Color> usedColorList = new ArrayList<Color>();


    /**
     * Gibt ein Standard-Zug wider
     * @return TrainModel
     */
    public static TrainModel getDefaultModel() {
        Color B = Color.BLUE;
        Color R = Color.RED;
        TrainModel Tm = new TrainModel();
        Tm.label = genLabel();
        Tm.iTrainId = Integer.parseInt((Tm.label));
        usedLabelList.add(Tm.label);
        Tm.category = "Freight";
        Tm.length = 700.0;
        Tm.iSpeedMax = 120;
        Color C = genColor();
        while(usedColorList.contains(C)) {
            C = genColor();
        }
        Tm.RepresentedColor = C;
        usedColorList.add(C);
        SpeedProfile DefaultProfile = new SpeedProfile();
        DefaultProfile.iSpeed = 100;
        DefaultProfile.waypoint = 0.0d;
        Tm.addSpeedProfile(DefaultProfile);
        return Tm;
    }

    private static Color genColor() {
        Random rand = new Random();
        float r = rand.nextFloat() / 2f;
        float g = rand.nextFloat() / 2f;
        float b = rand.nextFloat();
        return new Color(r,g,b);
    }

    private static String genLabel() {
        int iInitial = 1;
        String sInitial = "1";

        while(TrainModel.usedLabelList.contains(sInitial)) {
            iInitial++;
            sInitial = String.valueOf(iInitial);
        }
        return sInitial;
    }

    /**
     * Gibt den topologischen Knoten auf den sich der Zug hinbewegt wider.
     * @return TopologyGraph.Node
     */
    public TopologyGraph.Node getNodeTrainRunningTo() {
        return NodeTrainRunningTo;
    }

    /**
     * Setzt den Topologischen Ziel-Knoten auf den sich der Zug hinbewegt.
     * @param nodeTrainRunningTo - ToplogyGraph.Node
     */
    public void setNodeTrainRunningTo(TopologyGraph.Node nodeTrainRunningTo) {
        NodeTrainRunningTo = nodeTrainRunningTo;
        if(nodeTrainRunningTo != null) {
            this.sNodeIdTrainRunningTo = nodeTrainRunningTo.TopNodeId;
        } else this.sNodeIdTrainRunningTo = null;
    }

    /**
     * Unused
     * Misst Geschwindigkeit an Punkt
     */
    public static class SpeedProfile {
        double waypoint;
        int iSpeed;
    }

    /**
     * Nid Engine Id als Integer
     */

    @Expose
    public int iTrainId;


    /**
     * Label als String, normalerweise die Nid Engine Id als String
     */

    @Expose
    public String label;

    /**
     * Kategorie des Zuges
     */

    @Expose
    public String category;

    /**
     * Ausdehnung des Zuges
     */

    @Expose
    public double length;

    /**
     * Maximale Geschwindigkeit des Zuges
     */

    @Expose
    public int iSpeedMax = 120;

    /**
     * Farbe des Zuges auf der Zeichenebene
     */
    public Color RepresentedColor;

    /**
     * Topologische Kante auf der, der Zug sich gerade befindet
     */

    @Expose
    private TopologyGraph.Edge EdgeTrainStandsOn;

    /**
     * Abstand des Zuges auf der Topologischen Kante zum enthalteten Topologischen Knoten
     */

    @Expose
    private TrainDistance DistanceRefPointOfEdge;


    /**
     * Setzt den Abstand des Zuges auf der Toppologischen Kante zum angegebenen Topologischen Referenzknoten
     * @param distanceRefPointOfEdge
     */
    public void setDistanceRefPointOfEdge(TrainDistance distanceRefPointOfEdge) {
        DistanceRefPointOfEdge = distanceRefPointOfEdge;
    }

    /**
     * Gibt Abstand zum Topologischen Referenzknoten auf der Topologischen Zugkante wider
     * @return
     */
    public TrainDistance getDistanceRefPointOfEdge() {
        return DistanceRefPointOfEdge;
    }

    /**
     * Topologischer Knoten auf den sich der Zug hinbewegt.
     */
    @Expose
    private TopologyGraph.Node NodeTrainRunningTo;

    /**
     * Topologischer Knoten in nominaler Richtung
     * Gleichzeitg der erste Knoten der von der Balise angefahren wird, wenn der Zug nominal fahren soll.
     *
     * Durch diesen Knoten findet die Smart-Logic heraus, ob der Zug mit Front oder Heck dem Knoten nahe ist.
     *
     */
    @Expose
    private TopologyGraph.Node IntialNominalNodeInDirectionFromStartBalise;

    @Expose
    private String sNodeIdTrainRunningTo;

    public String getsNodeIdTrainRunningTo() {
        return sNodeIdTrainRunningTo;
    }

    private double dDistanceToNodeRunningTo;
    private Integer nid_lrbg = null;

    @Expose
    private ArrayList<TrackElement> passedTopologicalElements = new ArrayList<>();

    public boolean addPassedElement(TrackElement TE) {
        if(passedTopologicalElements.contains(TE)) return false;
        else passedTopologicalElements.add(TE);
        return true;
    }

    public ArrayList<TrackElement> getPassedTopologicalElements() {
        return passedTopologicalElements;
    }

    /**
     * Gibt die Id des Letzen bekannten RBCs dieses Zug-Models wider
     * @return String
     */
    public String getsLastKnownRBC() {
        return sLastKnownRBC;
    }

    /**
     * Setzt die Id des letzten bekannten RBC des Zuges
     * @param sLastKnownRBC {@link String} - RbcId
     */
    public void setsLastKnownRBC(String sLastKnownRBC) {
        this.sLastKnownRBC = sLastKnownRBC;
    }

    private String sLastKnownRBC = null;

    @Deprecated
    private Double dDistanceToBalise = null;

    public Integer getNid_lrbg() {
        return nid_lrbg;
    }

    public void setNid_lrbg(Integer nid_lrbg) {
        this.nid_lrbg = nid_lrbg;
    }
    @Deprecated
    public Double getdDistanceToBalise() {
        return dDistanceToBalise;
    }
    @Deprecated
    public void setdDistanceToBalise(Double dDistanceToBalise) {
        this.dDistanceToBalise = dDistanceToBalise;
    }

    private int Q_DIR = 2;

    /**
     * Gibt das ETCS Q_DIR_TRAIN aus dem Position-Report des Zuges wider
     * @return int
     */
    public int getQ_DIR() {
        return Q_DIR;
    }

    /**
     * Setzt das ETCS Q_DIR_TRAIN aus dem Position Report des Zuges
     * @param q_DIR
     */
    public void setQ_DIR(int q_DIR) {
        Q_DIR = q_DIR;
    }

    private Line2D.Double trainUiLine;

    /**
     * Gibt zu zeichnende Linde des Zuges wider
     * @return Line2D.Double
     */
    public Line2D.Double getTrainUiLine() {
        return trainUiLine;
    }

    /**
     * Setzt die Zeichenpostion des Zuges f&uuml;r die Karte
     * @param trainUiLine Line2D.Double - Zuglinie
     */
    public void setTrainUiLine(Line2D.Double trainUiLine) {
        this.trainUiLine = trainUiLine;
    }

    /**
     * Gibt die Toplogische Kante auf die der Zug sich befindet wider.
     * @return TopologyGraph.Edge - Kante
     */
    public TopologyGraph.Edge getEdgeTrainStandsOn() {
        return EdgeTrainStandsOn;
    }

    /**
     * Setzt die Topologische Kante auf die der Zug sich befindet.
     * @param edgeTrainStandsOn TopologyGraph.Edge - Kante
     */
    public void setEdgeTrainStandsOn(TopologyGraph.Edge edgeTrainStandsOn) {
        EdgeTrainStandsOn = edgeTrainStandsOn;
    }

    private ArrayList<SpeedProfile> requesedSpeedProfile = new ArrayList<SpeedProfile>();

    @Deprecated
    public void addSpeedProfile(SpeedProfile Profile) {
        this.requesedSpeedProfile.add(Profile);
    }

    /**
     * Gib Nid-Engine-ID wider
     * @return int
     */
    public int getTrainId() {
        return iTrainId;
    }


    /**
     * Gibt Distance zum Toplogischen Knoten wider, auf dem sich der Zug hinbewegt.
     * @return double
     */
    public double getdDistanceToNodeRunningTo() {
        return dDistanceToNodeRunningTo;
    }

    /**
     * Gemeint ist hier die Distanz von der Balise zum ersten topologischen Zielknoten
     * Setzt die Distanz zum Toplogischen Knoten auf dem sich der Zug hinbewegt.
     * @param dDistanceToNodeRunningTo double
     */
    public void setdDistanceToNodeRunningTo(double dDistanceToNodeRunningTo) {
        this.dDistanceToNodeRunningTo = dDistanceToNodeRunningTo;
    }

    /**
     *  Zug Nid-Engine-Id
     * @return String
     */
    @Override
    public String toString() {
        return this.label;
    }

    // etcs engine id
// onboard unit
//
}
