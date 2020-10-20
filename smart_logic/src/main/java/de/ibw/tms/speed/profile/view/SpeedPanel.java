package de.ibw.tms.speed.profile.view;

import de.ibw.tms.co.CartesianPanel;
import de.ibw.tms.etcs.ETCS_SPEED;
import de.ibw.tms.ma.*;
import de.ibw.tms.ma.location.LinearLocation;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.speed.profile.controller.SegmentAddController;
import de.ibw.tms.speed.profile.model.CartesianSpeedModel;
import de.ibw.tms.speed.profile.model.SpeedSegmentViewModel;
import de.ibw.tms.trackplan.ui.WaypointEnd;
import de.ibw.tms.trackplan.ui.WaypointStart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
/**
 * Panel zum SSP Dialog
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-11
 */
public class SpeedPanel extends CartesianPanel {

    /**
     * Speichert aktuelles Speed UI
     */
    public static SpeedPanel CurrentSpeedPanel;
    /**
     * Sub Dialog, wenn man in die Zeichenebene clickt.
     * Er macht die Daten nacheditierbar.
     */
    public static AddSegmentDialog OpenAddDialog = null;

    private Route R = null;
    private WaypointStart WayStart = null;
    private WaypointEnd WayEnd = null;
    private CartesianSpeedModel SpeedModel;
    private float fPaintFactor = 0.1f;
    private int iYFactor = 40;


    /**
     * Dieser Konstruktor intiert Komponetnen des eigenen Dialogs
     * @param SpeedModel {@link CartesianSpeedModel} - Model der aktuellen Ansicht
     * @param RouteData {@link Route} - beantragte Route
     */
    public SpeedPanel(CartesianSpeedModel SpeedModel, Route RouteData) {
        if(RouteData != null) {
            R = RouteData;
        }

        this.SpeedModel = Objects.requireNonNullElseGet(SpeedModel, CartesianSpeedModel::new);
        LinearLocation L = R.getLocation();
        this.WayStart = (WaypointStart) L.getBegin();
        this.WayEnd = (WaypointEnd) L.getEnd();


        checkSpeedProfilSet();


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int x=mouseEvent.getX();
                int height = SpeedPanel.this.getHeight() ;
                int mY = mouseEvent.getY();
                int y= SpeedPanel.this.getHeight() - mouseEvent.getY();

                int iStart = SpeedPanel.this.WayStart.chainage.iMeters;
                int iEnd = SpeedPanel.this.WayEnd.chainage.iMeters;


                float fMeter = calcMeter(x, iStart, iEnd);

                System.out.println(fMeter);

                System.out.println(x+","+y);


                float fSpeed = calcSpeed(y);
                int iMeter = (int) fMeter;
                int iEndMeter = SpeedPanel.this.WayEnd.getChainage().getiMeters();
                TrackElement TeStart = SpeedPanel.this.WayStart.getTrackElement();
                TrackElement TeEnd = SpeedPanel.this.WayEnd.getTrackElement();
                int iSpeed = (int) fSpeed;

                if(SpeedPanel.OpenAddDialog == null) {
                    SpeedChange C1 = new SpeedChange(new Chainage(iMeter), TeStart, new SectionOfLine());
                    SpeedChange C2 = new SpeedChange(new Chainage(iEndMeter), TeEnd, new SectionOfLine());

                    SpeedSegment Segment = new SpeedSegment(C1,C2, ApplicationDirection.BOTH);
                    ETCS_SPEED etcsSpeed = new ETCS_SPEED();
                    etcsSpeed.bSpeed = (byte) (iSpeed / 5);
                    Segment.setV_STATIC(etcsSpeed);
                    SpeedSegmentViewModel Model = new SpeedSegmentViewModel(Segment);
                    Model.setMinChainage(SpeedPanel.this.WayStart.getChainage());
                    Model.setMaxChainage(SpeedPanel.this.WayEnd.getChainage());
                    SegmentAddController Ctrl = new SegmentAddController();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            SpeedPanel.OpenAddDialog = new AddSegmentDialog(Model, Ctrl);
                            SpeedPanel.OpenAddDialog = null;
                        }
                    });

                }

            }


        });

        CurrentSpeedPanel = this;


    }

    /**
     * Speichert ein neues Segment in das SSP ein
     * @param InsertSegment {@link SpeedSegment} - das Segment das angebaut wird
     */
    public void addSpeedSegment(SpeedSegment InsertSegment){
        SSP NewProfile = new SSP();
        List<SpeedSegment> segmentList = this.getSpeedSortedByXlocaton();
        List<SpeedSegment> newSegmentList = new ArrayList<SpeedSegment>();
        SpeedSegment BeginConnectSegment = null;
        SpeedSegment EndConnectSegment = null;
        for(SpeedSegment S : segmentList) {
            if( beginIsBeforeBeginOfInsert(InsertSegment, S) && endIsAfterBeginOfInsert(InsertSegment, S)) {
                BeginConnectSegment = S;
            }
            if(beginIsBeforeInsertEnd(InsertSegment, S) && endIsAfterEndOfInsert(InsertSegment, S)) {
                EndConnectSegment = S;
            }
        }
        if(BeginConnectSegment == null) {
            newSegmentList.add(InsertSegment);
            if(EndConnectSegment == null) {
                System.out.println("New Segment is whole track");
            } else {
                de.ibw.tms.ma.location.SpotLocation BeginOfSegment = EndConnectSegment.getBegin();
                BeginOfSegment.setChainage(InsertSegment.getSpeedChangeEnd().getChainage());
                EndConnectSegment.setSpeedChangeBegin(BeginOfSegment);
                newSegmentList.add(EndConnectSegment);
                addRestSegments(segmentList, newSegmentList, EndConnectSegment);
            }
        } else if(EndConnectSegment == null) {
            addAllUntilInsertBegins(segmentList, newSegmentList, BeginConnectSegment);

            de.ibw.tms.ma.location.SpotLocation EndOfSegment = BeginConnectSegment.getSpeedChangeEnd();
            EndOfSegment.setChainage(InsertSegment.getBegin().getChainage());
            BeginConnectSegment.setSpeedChangeEnd(EndOfSegment);

            newSegmentList.add(BeginConnectSegment);
            newSegmentList.add(InsertSegment);

        } else if(BeginConnectSegment == EndConnectSegment) {
            int iStart = BeginConnectSegment.getBegin().getChainage().getiMeters();
            int iMin = this.WayStart.getChainage().getiMeters();
            int iEnd = EndConnectSegment.getSpeedChangeEnd().getChainage().getiMeters();
            int iMax = this.WayEnd.getChainage().getiMeters();
            if(iStart != iMin) {
                addAllUntilInsertBegins(segmentList, newSegmentList, BeginConnectSegment);
            }
            de.ibw.tms.ma.location.SpotLocation EndOfSegment = BeginConnectSegment.getSpeedChangeEnd();
            SpeedChange ScBeginLocation = new SpeedChange(new Chainage(iStart), EndOfSegment.getTrackElement(),
                    new SectionOfLine());
            SpeedSegment NewBeginSegment = new SpeedSegment(ScBeginLocation, InsertSegment.getBegin(), ApplicationDirection.BOTH);
            NewBeginSegment.setV_STATIC(BeginConnectSegment.getV_STATIC());
            newSegmentList.add(NewBeginSegment);

            EndOfSegment.setChainage(InsertSegment.getBegin().getChainage());
            BeginConnectSegment.setSpeedChangeEnd(EndOfSegment);


            newSegmentList.add(InsertSegment);
            Chainage ChEnd = new Chainage(iEnd);
            SpeedChange SC = new SpeedChange(ChEnd, EndOfSegment.getTrackElement(), new SectionOfLine());
            SpeedSegment NewEndSegment = new SpeedSegment(InsertSegment.getSpeedChangeEnd(),SC, ApplicationDirection.BOTH);
            NewEndSegment.setV_STATIC(BeginConnectSegment.getV_STATIC());
            newSegmentList.add(NewEndSegment);
            if(iEnd != iMax) {
                addRestSegments(segmentList, newSegmentList, EndConnectSegment);
            }

        } else {

            addAllUntilInsertBegins(segmentList, newSegmentList, BeginConnectSegment);
            de.ibw.tms.ma.location.SpotLocation EndOfSegment = BeginConnectSegment.getSpeedChangeEnd();
            EndOfSegment.setChainage(InsertSegment.getBegin().getChainage());
            BeginConnectSegment.setSpeedChangeEnd(EndOfSegment);

            newSegmentList.add(BeginConnectSegment);
            newSegmentList.add(InsertSegment);

            SpotLocation BeginOfSegment = EndConnectSegment.getBegin();
            BeginOfSegment.setChainage(InsertSegment.getSpeedChangeEnd().getChainage());
            EndConnectSegment.setSpeedChangeBegin(BeginOfSegment);
            newSegmentList.add(EndConnectSegment);
            addRestSegments(segmentList, newSegmentList, EndConnectSegment);

        }
        NewProfile.setSpeedSegments(newSegmentList);
        this.SpeedModel.setStaticSpeedProfile(NewProfile);
        SpeedDialog.SpDialog.revalidate();
        SpeedDialog.SpDialog.repaint();
    }

    private void addAllUntilInsertBegins(List<SpeedSegment> segmentList, List<SpeedSegment> newSegmentList, SpeedSegment beginConnectSegment) {
        for(SpeedSegment S : segmentList) {
            if(S == beginConnectSegment) {
                break;
            } else {
                newSegmentList.add(S);
            }
        }
    }

    private void addRestSegments(List<SpeedSegment> segmentList, List<SpeedSegment> newSegmentList, SpeedSegment endConnectSegment) {
        boolean bEndConnectIsPassed = false;
        for(SpeedSegment S : segmentList) {
            if(bEndConnectIsPassed) {
                SpeedSegment LastSegmentInOutputList = newSegmentList.get(newSegmentList.size() -1);
                S.setSpeedChangeBegin(LastSegmentInOutputList.getSpeedChangeEnd());
                newSegmentList.add(S);
            } else {
                if(S == endConnectSegment) {
                    bEndConnectIsPassed = true;

                }
            }
        }
    }

    private boolean endIsAfterEndOfInsert(SpeedSegment InsertSegment, SpeedSegment S) {
        return S.getEnd().getChainage().getiMeters() > InsertSegment.getEnd().getChainage().getiMeters();
    }

    private boolean beginIsBeforeInsertEnd(SpeedSegment InsertSegment, SpeedSegment S) {
        return S.getBegin().getChainage().getiMeters() <= InsertSegment.getEnd().getChainage().getiMeters();
    }

    private boolean beginIsBeforeBeginOfInsert(SpeedSegment InsertSegment, SpeedSegment S) {
        return S.getBegin().getChainage().getiMeters() < InsertSegment.getBegin().getChainage().getiMeters();
    }

    private boolean endIsAfterBeginOfInsert(SpeedSegment InsertSegment, SpeedSegment end) {
        return end.getEnd().getChainage().getiMeters() >= InsertSegment.getBegin().getChainage().getiMeters();
    }

    private float calcSpeed(int y) {
        return ((y- iYFactor) / (float) Y_AXIS_FIRST_Y_COORD) * 350.0f / 10.0f;
    }

    private float calcMeter(int x, int iStart, int iEnd) {
        return iStart +  ((x - X_AXIS_FIRST_X_COORD) / (float) X_AXIS_FIRST_X_COORD - fPaintFactor) * (iEnd - iStart) / 10.0f;
    }

    private void checkSpeedProfilSet() {
        SSP SpeedProfile = SpeedModel.getStaticSpeedProfile();
        if(SpeedProfile == null) {
            SpeedProfile = new SSP();

        }
        if(SpeedProfile.getSpeedSegments() == null) {
            SpeedProfile.setSpeedSegments(new ArrayList<>());
        }
        List<SpeedSegment> segments = SpeedProfile.getSpeedSegments();
        if(segments.isEmpty()) {
            try {
                segments.add(initDefaultSpeed());
            }catch (Exception E) {
                E.printStackTrace();
                JOptionPane.showMessageDialog(null, "You must enter Route first, then you can set a Speed Profile");
                throw E;
            }
        }
        SpeedProfile.setSpeedSegments(segments);
        SpeedModel.setStaticSpeedProfile(SpeedProfile);
    }

    private SpeedSegment initDefaultSpeed() {
        SpeedChange BeginnChange = new SpeedChange(WayStart.getChainage(), WayStart.getTrackElement(), new SectionOfLine());
        //TODO SPEED Segment
        SpeedChange EndChange = new SpeedChange(WayEnd.getChainage(), WayEnd.getTrackElement(), new SectionOfLine());
        SpeedSegment Segment = new SpeedSegment(BeginnChange, EndChange, ApplicationDirection.BOTH);
        ETCS_SPEED speed = new ETCS_SPEED();
        speed.bSpeed = 32; // 160 km/h
        Segment.setV_STATIC(speed);
        return Segment;
    }
    private List<SpeedSegment> getSpeedSortedByXlocaton() {
        List<SpeedSegment> segments = new ArrayList<>();
        SSP Profile = this.SpeedModel.getStaticSpeedProfile();

        segments = Profile.getSpeedSegments();
        //noinspection ComparatorMethodParameterNotUsed
        segments.sort(SpeedComparator());
        return segments;

    }

    private Comparator<SpeedSegment> SpeedComparator() {
        return new Comparator<SpeedSegment>() {
            @Override
            public int compare(SpeedSegment lhs, SpeedSegment rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                if (lhs.getBegin().getChainage().getiMeters() > rhs.getBegin().getChainage().getiMeters()) return 1;
                if (lhs.getBegin().getChainage().getiMeters() < rhs.getBegin().getChainage().getiMeters()) return -1;
                if (lhs.getBegin().getChainage().getiMeters() == rhs.getBegin().getChainage().getiMeters()) {
                    if (lhs.getV_STATIC().bSpeed == 0) return 1;
                    else return -1;
                }
                return 0;
            }
        };
    }


    private void processWaypoints(List wayList) {



        this.WayStart = new WaypointStart(new Chainage(777),null,null,777,0);
        this.WayEnd = new WaypointEnd(new Chainage(7777),null,null, 7777,0);
    }

    @Override
    public void paintComponent(Graphics g) {

        this.xCoordNumbers = 10;
        this.yCoordNumbers = 10;

        Graphics2D g2 = (Graphics2D) g;
        drawAxis(g2);
        drawAxisDescriptor(g2);
        int xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD)
                / xCoordNumbers;
        int yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD)
                / yCoordNumbers;

        drawXdescription(g2, xLength);

        //draw y-axis numbers
        drawYdescription(g2, yLength);

        int iWayEnd = this.WayEnd.chainage.iMeters;

        paintSpeedGraph(g2, iWayEnd);


    }

    protected void paintSpeedGraph(Graphics2D g2, int iWayEnd) {
        List<SpeedSegment> segments = this.getSpeedSortedByXlocaton();
        int iSize = segments.size();
        g2.setColor(Color.RED);
        for(int i = 0; i< iSize; i++) {

            SpeedSegment Segment = segments.get(i);
            int iLastSpeed = -1;
            int iBeginnMeter = Segment.getBegin().getChainage().getiMeters();
            int iBeginnMeterNext = Segment.getEnd().getChainage().getiMeters();
            int iMeterNextPx = getiMeterFromSegment(iWayEnd, Segment);
            int iSpeed = Segment.getV_STATIC().bSpeed * 5;
            int iSpeedPx = getiSpeedPx(Segment);


            if(i == 0) {
                int xStringPosPx = (iMeterNextPx - SpeedPanel.X_AXIS_FIRST_X_COORD ) / 2 + SpeedPanel.X_AXIS_FIRST_X_COORD;
                g2.drawLine(SpeedPanel.X_AXIS_FIRST_X_COORD, iSpeedPx, iMeterNextPx ,  iSpeedPx);
                g2.drawString(iSpeed + " km/h", xStringPosPx, iSpeedPx - SpeedPanel.AXIS_STRING_DISTANCE );
            } else if(i + 1 == iSize) {
                SpeedSegment PreSegment = segments.get(i - 1);
                int iMeterPrePx = getiMeterFromSegment(iWayEnd, PreSegment);
                int xStringPosPx = (iMeterNextPx - iMeterPrePx) / 2 + iMeterPrePx;
                int iPreSpeedPx = getiSpeedPx(PreSegment);
                g2.drawLine(iMeterPrePx, iSpeedPx, iMeterNextPx, iSpeedPx);
                g2.drawString(iSpeed + "km/h", xStringPosPx, iSpeedPx - SpeedPanel.AXIS_STRING_DISTANCE );
                g2.drawLine(iMeterPrePx, iPreSpeedPx, iMeterPrePx, iSpeedPx);
            } else {
                SpeedSegment PreSegment = segments.get(i - 1);
                int iMeterPrePx = getiMeterFromSegment(iWayEnd, PreSegment);
                int xStringPosPx = (iMeterNextPx - iMeterPrePx) / 2 + iMeterPrePx;
                int iPreSpeedPx = getiSpeedPx(PreSegment);
                // changed direction from end axis to middle of diagram
                g2.drawLine(iMeterPrePx, iSpeedPx, iMeterNextPx, iSpeedPx);
                g2.drawString(iSpeed + "km/h", xStringPosPx, iSpeedPx - SpeedPanel.AXIS_STRING_DISTANCE );
                g2.drawLine(iMeterPrePx, iPreSpeedPx, iMeterPrePx, iSpeedPx);
            }
        }
        g2.setColor(Color.BLACK);
    }

    protected int getiSpeedPx(SpeedSegment S) {
        int iSpeed = S.getV_STATIC().bSpeed * 5;
        return this.getHeight() - (int) Math.floor(SpeedPanel.Y_AXIS_FIRST_Y_COORD + SpeedPanel.X_AXIS_Y_COORD * iSpeed / 350.0f);
    }

    protected int getiMeterFromSegment(float iWayEnd, SpeedSegment Segment) {
        int iBeginnMeterNext = Segment.getEnd().getChainage().getiMeters();
        return (int) Math.floor(SpeedPanel.X_AXIS_Y_COORD * iBeginnMeterNext / iWayEnd) + SpeedPanel.X_AXIS_FIRST_X_COORD;
    }


    protected void drawYdescription(Graphics2D g2, int yLength) {
        for(int i = 1; i < yCoordNumbers; i++) {
            float iSpeed = 350 * i / 10.0f;
            g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
                    Y_AXIS_SECOND_Y_COORD - (i * yLength),
                    Y_AXIS_X_COORD + SECOND_LENGHT,
                    Y_AXIS_SECOND_Y_COORD - (i * yLength));
            g2.drawString(String.valueOf(iSpeed),
                    Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                    Y_AXIS_SECOND_Y_COORD - (i * yLength));
        }
    }

    protected void drawXdescription(Graphics2D g2, int xLength) {
        // draw x-axis numbers
        for(int i = 1; i < xCoordNumbers; i++) {
            int xMeterEnd = this.WayEnd.getChainage().getiMeters();
            int xMeterStart = this.WayStart.getChainage().getiMeters();
            float iMeter = xMeterStart + i * (xMeterEnd - xMeterStart) / 10.0f;
            String sMeter = String.valueOf(Math.floor(iMeter));
            g2.drawLine(X_AXIS_FIRST_X_COORD + (i * xLength),
                    X_AXIS_Y_COORD - SECOND_LENGHT,
                    X_AXIS_FIRST_X_COORD + (i * xLength),
                    X_AXIS_Y_COORD + SECOND_LENGHT);
            g2.drawString(sMeter,
                    X_AXIS_FIRST_X_COORD + (i * xLength) - 3,
                    X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        }
    }

    protected void drawAxisDescriptor(Graphics2D g2) {
        String xStart = String.valueOf(this.WayStart.getChainage().getiMeters());
        g2.drawString("meter", X_AXIS_SECOND_X_COORD - AXIS_STRING_DISTANCE / 2,
                X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        g2.drawString("km/h", Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                Y_AXIS_FIRST_Y_COORD + AXIS_STRING_DISTANCE / 2);
        g2.drawString("(" + xStart + " , 0)", X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE,
                Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);
    }
}
