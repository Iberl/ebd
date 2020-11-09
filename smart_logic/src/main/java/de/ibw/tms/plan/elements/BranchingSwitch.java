package de.ibw.tms.plan.elements;

import de.ibw.tms.MainTmsSim;
import de.ibw.tms.intf.SmartClient;
import de.ibw.tms.intf.SmartClientHandler;
import de.ibw.tms.intf.TmsDbdCommand;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.ma.physical.*;
import de.ibw.tms.ma.net.elements.PositionedRelation;
import de.ibw.tms.plan.elements.interfaces.ICrossover;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.model.CrossoverEnumModel;
import de.ibw.tms.plan.elements.model.CrossoverMainModel;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.EnumModel;
import de.ibw.tms.trackplan.controller.CrossoverController;
import de.ibw.tms.trackplan.ui.SingleEnumSelectorComponent;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import ebd.ConfigHandler;
import ebd.rbc_tms.util.exception.MissingInformationException;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Flow;

/**
 * Branching Switch ein Modell einer Weiche Geographischer und Logischer Art
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-08-31
 */
public class BranchingSwitch extends Point2D.Double implements Shape, ICrossover, ITrack, Flow.Subscriber<CrossoverMainModel> {


    private static Logger logger = Logger.getLogger( BranchingSwitch.class );
    private Flow.Subscription CrossoverSubscription = null;
    private Rail PeekRail = null;
    private TopologyGraph.Node Node = null;

    /**
     * Setzt das Gleis an der Weichenspitze
     * @param PeekRail {@link Rail} - Gleis der Weichenspitze, das gesetzt wird
     */
    public void setPeekRail(Rail PeekRail) {
        this.PeekRail = PeekRail;
    }

    /**
     * Setzt Bezug zum Topologischen Knoten-Kanten-Listen-Modell
     * @param node {@link de.ibw.tms.plan_pro.adapter.topology.TopologyGraph.Node} - Der Topologische Knoten
     */
    public void setNode(TopologyGraph.Node node) {
        Node = node;
    }

    /**
     * Enum das definiert welches Bild f&uuml;r die Weiche benutzt werden soll
     */
    public enum ViewType {
        Branch_RLO, Branch_LRU, Branch_ORL, Branch_ULR
    }

    private static BufferedImage img = null;

    private ViewType BranchViewTypeCurrent;
    private CrossoverStatus LastState = CrossoverStatus.RIGHT;


    private String sBrachName;

    public void setsBrachName(String sName) {
        if(this.sBrachName == null || this.sBrachName.isEmpty() || this.sBrachName.equals("")) {
            JLabel LabName = new JLabel("<HTML><b><u>".concat(sName).concat("</u></b></HTML>"));


            uiList.add(0,LabName);
        }
        this.sBrachName = sName;
    }

    /**
     * Bild das die Weiche darsstellt. Es wird aus einer Datei geladen
     * @return BufferedImage - Bild
     * @throws IOException - Falls Datei nicht geladen werden konnte
     */
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

    /**
     * Gibt den Schlupf der Weiche wider. Dort ist abgelegt welche Enden der Weichen gerade verbunden sind.
     * @return SlipConnectionPoint - Schlupf der Weiche
     */
    public SlipConnectionPoint getBranchingPoint() {
        return BranchingPoint;
    }

    private ArrayList<JComponent> uiList = new ArrayList();
    private SingleEnumSelectorComponent<CrossoverEnumModel> BrachingStates = null;




    /**
     * Bereitet UI f&uuml;r die Weiche vor
     * @param Model {@link CrossoverEnumModel} - Auswahlm&ouml;glichkeit von Status einer Weiche
     */
    private void initUiList(CrossoverEnumModel Model) {


        setBranchingStatesUnit(Model);
        uiList.add(BrachingStates);

    }

    private void setBranchingStatesUnit(CrossoverEnumModel model) {
        this.BrachingStates = new SingleEnumSelectorComponent<CrossoverEnumModel>(model, this.controller,false);
        uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
        model.setSingleSelection(model.getEnumMappingList()[0]);
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendDbdCommandToSL();
            }
        };
        BrachingStates.addActionListener(al);
    }

    public void sendDbdCommandToSL() {
        long lPriority = ConfigHandler.getInstance().lCheckDbdCommand;
        Object OEnumField = BrachingStates.getSelectedItem();
        EnumModel.EnumField EF = (EnumModel.EnumField) OEnumField;
        if(((CrossingSwitch) this.Node.NodeImpl).isDKW()) {
            handleDKW();
            return;
        }
        String sEbdName = ((CrossingSwitch) this.Node.NodeImpl).getEbdTitle(0, true, true);
        String sId = ISwitchHandler.getNodeId(this.Node);
        CheckDbdCommand DbdCommandPayload =
                new CheckDbdCommand(sEbdName,sId, (CrossoverStatus) EF.Item, lPriority);
        TmsDbdCommand DbdCommand = new TmsDbdCommand(MainTmsSim.S_TMS_ID,"NoRbcTarget", DbdCommandPayload);
        try {
            SmartClientHandler.getInstance().sendCommand(DbdCommand);
        } catch (MissingInformationException missingInformationException) {
            missingInformationException.printStackTrace();
        }
    }

    private void handleDKW() {
        System.out.println("DKW is currently not supported");
    }

    private CrossoverController controller = null;

    /**
     * Gibt Controller, der das Kontextmenu, bei Userinteraktion, nach Auswahl, die entsprechende Aktion ausf&uuml;hrt wieder
     * @return CrossoverController - Der Controller zum Weichen-Kontextmenu
     */
    public CrossoverController getController() {
        return controller;
    }

    /**
     * Definiert die Ui-Elemente im Kontextmenu der Weiche
     * @return java.util.List - UI Elemente der Weiche
     */
    @Override
    public ArrayList<JComponent> getViewElements() {
        return uiList;
    }

    /**
     * Bezeichnung der Weiche im Menu und auch auf dem Trackplan
     * @return String - Bezeichnung der Weiche
     */
    @Override
    public String getViewName() {
        return this.sBrachName;
    }

    /**
     * Weichenmodel&auml;nderungen dieser Weiche, werden hier als bewacht angemeldet
     * @param subscription - Anmeldungsobject bei &Auml;nderungen
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.CrossoverSubscription = subscription;
        subscription.request(1);
    }


    /**
     * Eine Weichenmodel wurde ge&auml;ndert
     * @param item {@link CrossoverMainModel} Neues Model der Weiche
     */

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

    /**
     * Setzt die angegebene Output Relation als aktiv
     * @param outputRelation - neue Verbindung der drei Enden einer Weiche
     * @param remotePoint - der Schlupf der Weiche - speichert umschaltzeit noch unbenutzt
     */
    private void handleOutputRelation(PositionedRelation outputRelation, Point_RemoteOperated remotePoint) {
        String sNodeIdOutput = "";
        Trail Target = null;
        Trail From = (Trail) outputRelation.getFrom();

        Target = getTargetOfOutputChange(outputRelation, From);


        String sSrc = ISwitchHandler.getNodeId(Node);
        String sTarget;


        sTarget = getTargetOfOutputEdge(Target);




        logger.info("Switch: " + sSrc + " points to " + sTarget + " now.\n");

        ///


    }

    private String getTargetOfOutputEdge(Trail target) {
        String sTarget;
        try {

            TopologyGraph.Node ref = target.getRail().getEdge().B;
            CrossingSwitch CS = null;

            if(ref.TopNodeId.equals(Node.TopNodeId)) {
                CS = (CrossingSwitch) target.getRail().getEdge().A.NodeImpl;
                logger.info("Switched to " + target.getRail().getEdge().TopConnectFromB.value());

            } else {
                CS = (CrossingSwitch) ref.NodeImpl;
                logger.info("Switched to " + target.getRail().getEdge().TopConnectFromA.value());
            }
            sTarget = CS.getEbdTitle(3,false,false);

        } catch ( Exception E) {

                sTarget = target.getRail().getEdge().A.TopNodeId;

        }
        return sTarget;
    }

    private String getThisNode() {
        String sSrc;
        try {
            CrossingSwitch CS = (CrossingSwitch) Node.NodeImpl;
            sSrc = CS.getEbdTitle();
        }catch (Exception E){
            sSrc =  Node.TopNodeId;
        }
        return sSrc;
    }

    private Trail getTargetOfOutputChange(PositionedRelation outputRelation, Trail from) {
        Trail Target;
        if(from.getRail().equals(PeekRail)) {
            Target = (Trail) outputRelation.getTo();
        } else {
            Target = from;
        }
        return Target;
    }

    /**
     * neues Weichenmodel wirft Fehler
     * Bisher wird nur der Fehler in der Konsole angezeigt
     * @param throwable - Fehler der geworfen wird
     */

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * neues Weichenmodel wurde in onNext behandelt. Hier wird beschrieben was dann passiert.
     * Bisher keien Folgeaktionen
     */
    @Override
    public void onComplete() {

    }

    /**
     * Gibt einen Recheckbereich der GUI-Clickbaren-Gr&ouml;&szlig;e der Weiche an.
     * In diesem Rechteck wird das Kontextmenu aufrufbar
     * @return Rectangle - Clickausma&szlig; der Weiche
     */

    @Override
    public Rectangle getBounds() {

        double dToleranceLocal = dTolerance / TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom.getdZoomX();
        int ix = (int) Math.floor(this.getX() - dToleranceLocal);
        int iy = (int) Math.floor(this.getY() - dToleranceLocal);
        int iWidth = (int) Math.ceil(dToleranceLocal) * 2;
        int iHeight = (int) Math.ceil(dToleranceLocal) * 2;
        return new Rectangle(ix, iy, iWidth, iHeight);
    }

    /**
     * Gibt einen 2-D-Recheckbereich der GUI-Clickbaren-Gr&ouml;&szlig;e der Weiche an.
     * In diesem 2D-Rechteck wird das Kontextmenu aufrufbar
     * @return Rectangle - Clickausma&szlig; der Weiche
     */
    @Override
    public Rectangle2D getBounds2D() {
        return this.getBounds();
    }

    /**
     * unused
     */
    @Override
    public boolean contains(double x, double y) {
        return this.getBounds2D().contains(x,y);
    }

    /**
     * unused
     */
    @Override
    public boolean contains(Point2D p) {
        return this.getBounds2D().contains(p);
    }

    /**
     * unused
     */
    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    /**
     * unused
     */
    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }

    /**
     * unused
     */
    @Override
    public boolean contains(double x, double y, double w, double h) {
        return this.contains(x,y);
    }

    /**
     * unused
     */
    @Override
    public boolean contains(Rectangle2D r) {
        return r.contains(this.dX, this.dY);
    }

    /**
     * unused
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }

    /**
     * unused
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }

    /**
     * Gibt Schlupf der Weiche wider
     * @return TrackElement - {@link SlipConnectionPoint} Gipt Schlupf wider
     */
    @Override
    public TrackElement getTrackReference() {
        return this.BranchingPoint;
    }


    /**
     * Status die eine Weiche haben kann
     */
    public enum CrossoverStatus {
        RIGHT, LEFT, BUSY, UNSAFE, UNSAFE_RIGHT, UNSAFE_LEFT
    }


    /**
     * Factory Methode generiert ein Weichenmodell einer einzelnen Weiche
     * @param fLinkTime - {@link java.lang.Float} - dauer der Weichenstellung in ms
     * @param BranchPoint - {@link SingleSlip} - Schlupf der Weiche
     * @param dx double - X-Position auf geographischen Fenstern
     * @param dy double - Y-Position auf geographischen Fenstern
     * @param sName {@link String} - Name der Weiche
     * @param ViewType {@link ViewType} - Bild der Weiche
     * @return BranchingSwitch - Gibt Weichenmodell mit den Parametern wider.
     */
    public static BranchingSwitch createCrossover( java.lang.Float fLinkTime, SingleSlip BranchPoint,
                                                  double dx, double dy, String sName, ViewType ViewType) {

            if(fLinkTime == null) fLinkTime = 1000.0f;
            return new BranchingSwitch(fLinkTime, BranchPoint, dx, dy, sName, ViewType);



    }
    /*
    public static BranchingSwitch createCrossover( java.lang.Float fLinkTime, DoubleSlip BranchPoint,
        double dx, double dy, String sName) {

        if(fLinkTime == null) fLinkTime = 1000.0f;
        return new BranchingSwitch( fLinkTime, BranchPoint, dx, dy, sName);



    }*/


    private CrossoverStatus Status = CrossoverStatus.RIGHT;


    private float fLinkageTimeInMs = 1000.0f;

    private BranchingSwitch(float fLinkTime, SingleSlip BrachningPoint, double dx, double dy, String sName,
                           ViewType BranchType) {
        super(dx,dy);
        this.sBrachName = sName;
        this.BranchingPoint = BrachningPoint;
        this.BranchingPoint.setViewName(sName);
        this.BranchViewTypeCurrent = BranchType;

        init(fLinkTime);




    }

    private void init(float fLinkTime) {
        fLinkageTimeInMs = fLinkTime;

        CrossoverMainModel Model = new CrossoverMainModel();

        CrossoverEnumModel StatusModel = new CrossoverEnumModel();


        this.controller = new CrossoverController(Model, StatusModel, this);
        initUiList(StatusModel);
    }

    /**
     * Setzt die Umschaltdauer des Weichenmodells
     * @param fLinkageTimeInMs float - Umschaltzeit in ms
     */
    public void setfLinkageTimeInMs(float fLinkageTimeInMs) {
        this.fLinkageTimeInMs = fLinkageTimeInMs;
    }

    /**
     * Setzt den Weichenstatus
     * @param status - {@link CrossoverStatus} der neue Status der Weiche
     */
    public void setStatus(CrossoverStatus status) {
        Status = status;
    }

    /**
     * Hold den aktuellen Status der Weiche
     * @return CrossoverStatus - Weichenstatus der widergegeben wird
     */
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
