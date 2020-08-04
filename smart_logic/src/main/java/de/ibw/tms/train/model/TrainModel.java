package de.ibw.tms.train.model;

import com.google.gson.annotations.Expose;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.ThreadedRepo;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class TrainModel {


    public static ThreadedRepo<Integer, TrainModel> TrainRepo = new ThreadedRepo<>();



    public static ArrayList<String> usedLabelList = new ArrayList<String>();
    public static ArrayList<Color> usedColorList = new ArrayList<Color>();



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

    public TopologyGraph.Node getNodeTrainRunningTo() {
        return NodeTrainRunningTo;
    }

    public void setNodeTrainRunningTo(TopologyGraph.Node nodeTrainRunningTo) {
        NodeTrainRunningTo = nodeTrainRunningTo;
    }


    public static class SpeedProfile {
        double waypoint;
        int iSpeed;
    }

    @Expose
    public int iTrainId;
    @Expose
    private double x;

    @Expose
    private double y;

    @Expose
    public String label;
    @Expose
    public String category;
    @Expose
    public double length;
    @Expose
    public int iSpeedMax = 120;
    public Color RepresentedColor;
    @Expose
    private TopologyGraph.Edge EdgeTrainStandsOn;

    @Expose
    private TrainDistance DistanceRefPointOfEdge;

    public void setDistanceRefPointOfEdge(TrainDistance distanceRefPointOfEdge) {
        DistanceRefPointOfEdge = distanceRefPointOfEdge;
    }

    public TrainDistance getDistanceRefPointOfEdge() {
        return DistanceRefPointOfEdge;
    }

    @Expose
    private TopologyGraph.Node NodeTrainRunningTo;
    private double dDistanceToNodeRunningTo;
    private Integer nid_lrbg = null;

    public String getsLastKnownRBC() {
        return sLastKnownRBC;
    }

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

    public Double getdDistanceToBalise() {
        return dDistanceToBalise;
    }

    public void setdDistanceToBalise(Double dDistanceToBalise) {
        this.dDistanceToBalise = dDistanceToBalise;
    }

    private int Q_DIR = 2;

    public int getQ_DIR() {
        return Q_DIR;
    }

    public void setQ_DIR(int q_DIR) {
        Q_DIR = q_DIR;
    }

    private Line2D.Double trainUiLine;

    public Line2D.Double getTrainUiLine() {
        return trainUiLine;
    }

    public void setTrainUiLine(Line2D.Double trainUiLine) {
        this.trainUiLine = trainUiLine;
    }


    public TopologyGraph.Edge getEdgeTrainStandsOn() {
        return EdgeTrainStandsOn;
    }

    public void setEdgeTrainStandsOn(TopologyGraph.Edge edgeTrainStandsOn) {
        EdgeTrainStandsOn = edgeTrainStandsOn;
    }

    private ArrayList<SpeedProfile> requesedSpeedProfile = new ArrayList<SpeedProfile>();

    public void addSpeedProfile(SpeedProfile Profile) {
        this.requesedSpeedProfile.add(Profile);
    }
    public void resetProfile() {
        requesedSpeedProfile = new ArrayList<SpeedProfile>();
    }
    public int getTrainId() {
        return iTrainId;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getdDistanceToNodeRunningTo() {
        return dDistanceToNodeRunningTo;
    }

    public void setdDistanceToNodeRunningTo(double dDistanceToNodeRunningTo) {
        this.dDistanceToNodeRunningTo = dDistanceToNodeRunningTo;
    }

    @Override
    public String toString() {
        return this.label;
    }

    // etcs engine id
// onboard unit
//
}
