package de.ibw.tms.plan.elements;

import de.ibw.tms.ma.physical.*;
import de.ibw.tms.ma.topologie.PositionedRelation;
import de.ibw.tms.plan.elements.interfaces.ICrossover;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.model.CrossoverEnumModel;
import de.ibw.tms.plan.elements.model.CrossoverMainModel;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.controller.CrossoverController;
import de.ibw.tms.trackplan.ui.SingleEnumSelectorComponent;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Flow;

public class BranchingSwitch extends Point2D.Double implements Shape, ICrossover, ITrack, Flow.Subscriber<CrossoverMainModel> {


    private static Logger logger = Logger.getLogger( BranchingSwitch.class );
    Flow.Subscription CrossoverSubscription = null;
    private Rail PeekRail = null;
    private TopologyGraph.Node Node = null;
    public void setPeekRail(Rail PeekRail) {
        this.PeekRail = PeekRail;
    }

    public void setNode(TopologyGraph.Node node) {
        Node = node;
    }

    public enum ViewType {
        Branch_RLO, Branch_LRU, Branch_ORL, Branch_ULR
    }

    public class ViewTypeConverter {

    }


    private static BufferedImage img = null;

    private ViewType BranchViewTypeCurrent;
    private CrossoverStatus LastState = CrossoverStatus.RIGHT;

    public void setBranchViewTypeCurrent(ViewType branchViewTypeCurrent) {
        BranchViewTypeCurrent = branchViewTypeCurrent;
    }

    private String sBrachName;



    public BufferedImage getImage() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        CrossoverStatus CurrentStatus = this.getStatus();

        try {
            if( CurrentStatus == CrossoverStatus.BUSY || CurrentStatus == CrossoverStatus.UNSAFE) {
                CurrentStatus = LastState;
                if(LastState == CrossoverStatus.BUSY || LastState == CrossoverStatus.UNSAFE ) {
                    return UiTools.handleImaging(cl, "images/StreightBranch.png");

                }
            }
            if(this.BranchViewTypeCurrent == null) {
                return UiTools.handleImaging(cl, "images/DefaultBranch.png");
            }
            switch(this.BranchViewTypeCurrent) {
                case Branch_LRU: {
                    if(CurrentStatus == CrossoverStatus.RIGHT || CurrentStatus == CrossoverStatus.UNSAFE_RIGHT) {
                        handleImaging(cl, "images/StreightBranch.png");
                    } else {
                        handleImaging(cl, "images/Branch_LRU.png");
                    }
                    break;
                }
                case Branch_ORL: {
                    if(CurrentStatus == CrossoverStatus.LEFT || CurrentStatus == CrossoverStatus.UNSAFE_LEFT) {
                        handleImaging(cl, "images/StreightBranch.png");
                    } else {
                        handleImaging(cl, "images/Branch_ORL.png");
                    }

                    break;
                }
                case Branch_RLO: {
                    if(CurrentStatus == CrossoverStatus.RIGHT || CurrentStatus == CrossoverStatus.UNSAFE_RIGHT) {
                        handleImaging(cl, "images/StreightBranch.png");
                    } else {
                        handleImaging(cl, "images/Branch_RLO.png");
                    }
                    break;
                }
                case Branch_ULR: {
                    if(CurrentStatus == CrossoverStatus.LEFT || CurrentStatus == CrossoverStatus.UNSAFE_LEFT) {
                        handleImaging(cl, "images/StreightBranch.png");
                    } else {
                        handleImaging(cl, "images/Branch_ULR.png");
                    }

                    break;
                }
                default: {

                    return UiTools.handleImaging(cl,"images/DefaultBranch.png");

                }
            }
            } catch(NullPointerException NPE) {
                return null;
            }


        return img;

    }

    private void handleImaging(ClassLoader cl, String s) throws IOException {
        img = ImageIO.read(Objects.requireNonNull(cl.getResource(s)));
    }


    static private double dTolerance = 7.0d;

    private double dX;
    private double dY;

    private SlipConnectionPoint BranchingPoint = null;

    public SlipConnectionPoint getBranchingPoint() {
        return BranchingPoint;
    }

    private ArrayList<JComponent> uiList = new ArrayList();
    private SingleEnumSelectorComponent<CrossoverEnumModel> BrachingStates = null;
    private void initUiList(CrossoverEnumModel Model) {
        uiList.add(new JLabel("<HTML><b><u>".concat(this.sBrachName).concat("</u></b></HTML>")));
        uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
        Model.setSingleSelection(Model.getEnumMappingList()[0]);
        this.BrachingStates = new SingleEnumSelectorComponent<CrossoverEnumModel>(Model, this.controller);
        uiList.add(BrachingStates);

    }

    private CrossoverController controller = null;

    public CrossoverController getController() {
        return controller;
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        return uiList;
    }

    @Override
    public String getViewName() {
        return this.sBrachName;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.CrossoverSubscription = subscription;
        subscription.request(1);
    }





    @Override
    public void onNext(CrossoverMainModel item) {
        if(item.CrossoverStatus != Status) {
            this.LastState = Status;
            Status = item.CrossoverStatus;
        }
        this.fLinkageTimeInMs = item.fLinkageTimeInMs;

        this.BrachingStates.update(this.Status);
        if(this.Status.equals(CrossoverStatus.RIGHT)) {
            SingleSlip BranchPoint = (SingleSlip) this.BranchingPoint;
            BranchPoint.setOutputRelation(BranchPoint.getRemotePoint().getRightPosition());
            handleOutputRelation(BranchPoint.getOutputRelation(), BranchPoint.getRemotePoint());

        }
        if(this.Status.equals(CrossoverStatus.LEFT)) {
            SingleSlip BranchPoint = (SingleSlip) this.BranchingPoint;
            BranchPoint.setOutputRelation(BranchPoint.getRemotePoint().getLeftPosition());

            handleOutputRelation(BranchPoint.getOutputRelation(), BranchPoint.getRemotePoint());
        }


        this.CrossoverSubscription.request(1);
    }

    private void handleOutputRelation(PositionedRelation outputRelation, Point_RemoteOperated remotePoint) {
        String sNodeIdOutput = "";
        Trail Target = null;
        Trail From = (Trail) outputRelation.getFrom();
        TopologyGraph.Node Ref = null;
        if(From.getRail().equals(PeekRail)) {
            Target = (Trail) outputRelation.getTo();
        } else {
            Target = (Trail) From;
        }
        Ref = Target.getRail().getEdge().B;
        if(Ref.TopNodeId.equals(Node.TopNodeId)) {
            sNodeIdOutput = Target.getRail().getEdge().A.TopNodeId;
        } else sNodeIdOutput = Ref.TopNodeId;

        logger.info("Switch: " + Node.TopNodeId + " points to " + sNodeIdOutput + " now.\n");

        ///


    }


    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {

    }

    @Override
    public Rectangle getBounds() {

        double dToleranceLocal = dTolerance / TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom.getdZoomX();
        int ix = (int) Math.floor(this.getX() - dToleranceLocal);
        int iy = (int) Math.floor(this.getY() - dToleranceLocal);
        int iWidth = (int) Math.ceil(dToleranceLocal) * 2;
        int iHeight = (int) Math.ceil(dToleranceLocal) * 2;
        return new Rectangle(ix, iy, iWidth, iHeight);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return this.getBounds();
    }

    @Override
    public boolean contains(double x, double y) {
        return this.getBounds2D().contains(x,y);
    }

    @Override
    public boolean contains(Point2D p) {
        return this.getBounds2D().contains(p);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return this.contains(x,y);
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return r.contains(this.dX, this.dY);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }

    @Override
    public TrackElement getTrackReference() {
        return this.BranchingPoint;
    }



    public enum CrossoverStatus {
        RIGHT, LEFT, BUSY, UNSAFE, UNSAFE_RIGHT, UNSAFE_LEFT
    }




    public static BranchingSwitch createCrossover( java.lang.Float fLinkTime, SingleSlip BranchPoint,
                                                  double dx, double dy, String sName, ViewType ViewType) {

            if(fLinkTime == null) fLinkTime = 1000.0f;
            return new BranchingSwitch(fLinkTime, BranchPoint, dx, dy, sName, ViewType);



    }
    public static BranchingSwitch createCrossover( java.lang.Float fLinkTime, DoubleSlip BranchPoint,
        double dx, double dy, String sName) {

        if(fLinkTime == null) fLinkTime = 1000.0f;
        return new BranchingSwitch( fLinkTime, BranchPoint, dx, dy, sName);



    }


    private CrossoverStatus Status = CrossoverStatus.RIGHT;


    private float fLinkageTimeInMs = 1000.0f;

    public BranchingSwitch(float fLinkTime, SingleSlip BrachningPoint, double dx, double dy, String sName,
                           ViewType BranchType) {
        super(dx,dy);
        this.sBrachName = sName;
        this.BranchingPoint = BrachningPoint;
        this.BranchingPoint.setViewName(sName);
        this.BranchViewTypeCurrent = BranchType;

        init(fLinkTime);




    }
    public BranchingSwitch( float fLinkTime, DoubleSlip BrachningPoint, double dx, double dy, String sName

        ) {
        super(dx,dy);
        this.sBrachName = sName;
        this.BranchingPoint = BrachningPoint;
        init(fLinkTime);






    }

    private void init(float fLinkTime) {
        fLinkageTimeInMs = fLinkTime;

        CrossoverMainModel Model = new CrossoverMainModel();

        CrossoverEnumModel StatusModel = new CrossoverEnumModel();


        this.controller = new CrossoverController(Model, StatusModel, this);
        initUiList(StatusModel);
    }

    public void setfLinkageTimeInMs(float fLinkageTimeInMs) {
        this.fLinkageTimeInMs = fLinkageTimeInMs;
    }

    public void setStatus(CrossoverStatus status) {
        Status = status;
    }

    public CrossoverStatus getStatus() {
        return this.Status;
    }


   /* @Override
    public Rectangle getBounds() {
        return getBounds2D().getBounds();
    }*/

    private double getX(boolean isLow) {
       /* double xResult = connectionPoints.get(0).x;
        for(ElementConnectionPoint El : connectionPoints) {
            if(isLow) {
                if (xResult > El.x) xResult = El.x;
            } else {
                if(xResult < El.x) xResult = El.x;
            }
        }*/
        return dX;
    }
    private double getY(boolean isLow) {
       /* double yResult = connectionPoints.get(0).y;
        for(ElementConnectionPoint El : connectionPoints) {
            if(isLow) {
                if (yResult > El.y) yResult = El.y;
            } else {
                if(yResult < El.y) yResult = El.y;
            }
        }*/
        return this.dY;
    }
/*
    @Override
    public Rectangle2D getBounds2D() {



        double x, y, w, h;
        double x1 = this.getX(true);
        double y1 = this.getY(true);
        double x2 = this.getX(false);
        double y2 = this.getY(false);

        if (x1 < x2) {
            x = x1;
            w = x2 - x1;
        } else {
            x = x2;
            w = x1 - x2;
        }
        if (y1 < y2) {
            y = y1;
            h = y2 - y1;
        } else {
            y = y2;
            h = y1 - y2;
        }
        return new Rectangle2D.Double(x, y, w, h);
    }

    @Override
    public boolean contains(double x, double y) {
        double tolerance = dTolerance;
        Rectangle2D R2dF = this.getBounds2D();
        double x1 = R2dF.getX();
        double x2 = R2dF.getX() + R2dF.getWidth();
        double y1 = R2dF.getY();
        double y2 = R2dF.getY() + R2dF.getHeight();

        boolean hasX = x1 -tolerance <= x && x2 + tolerance >= x;
        boolean hasY = y1 -tolerance <= y && y2 + tolerance >= y ;
        return hasX && hasY;
    }*/

    /*@Override
    public boolean contains(Point2D p) {
        Rectangle2D R2dF = this.getBounds2D();
        double x1 = R2dF.getX();
        double x2 = R2dF.getX() + R2dF.getWidth();
        double y1 = R2dF.getY();
        double y2 = R2dF.getY() + R2dF.getHeight();
        double px = p.getX();
        double py = p.getY();
        return this.contains(p.getX(), p.getY());


    }*/


}
