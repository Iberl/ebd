package de.ibw.tms.gradient.profile.ui;

import de.ibw.tms.etcs.ETCS_GRADIENT;
import de.ibw.tms.gradient.profile.GradientTrailModel;
import de.ibw.tms.gradient.profile.controller.GradientController;
import de.ibw.tms.gradient.profile.viewmodel.GradientTableModel;
import de.ibw.tms.ma.GradientSegment;
import de.ibw.tms.ma.SectionOfLine;
import de.ibw.tms.ma.SpotLocation;
import de.ibw.tms.ma.physical.Trail;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.model.PlanData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class GradientFrame extends JFrame {

    private JList<GradientTrailModel> TrailList;
    private JTable GradientTable;
    private GradientTrailModel CurrentTrailModel = null;

    JPanel MainPanel;


    public GradientTrailModel getCurrentTrailModel() {
        return CurrentTrailModel;
    }

    public void setCurrentTrailModel(GradientTrailModel currentTrailModel) {

        CurrentTrailModel = currentTrailModel;
        ArrayList<GradientSegment> gradientList = PlanData.getInstance().GradientMap.get(CurrentTrailModel);

        GradientTableModel GTM = new GradientTableModel(CurrentTrailModel);

        GradientTable.setModel(GTM.getTableModel());
        GTM.getTableModel().fireTableDataChanged();

        System.out.println("Fired Data: " .concat(String.valueOf(GTM.getSegmentList().size())));







        /*this.ScrollPane = new JScrollPane(GradientTable);
        this.ScrollPane.repaint();
        this.MainPanel.revalidate();
        this.MainPanel.repaint();
        this.revalidate();
        this.repaint(); */
    }

    public GradientFrame(String title) throws HeadlessException {
        super(title);

        TrailList = new JList<GradientTrailModel>();



        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        initData();
        windowViews();
        //initGradientTable();


    }
    @Deprecated
    public void initGradientTable() {
        GradientTableModel GTM;
        ArrayList<GradientSegment> segments = null;
        if(CurrentTrailModel != null) {
            segments = PlanData.getInstance().GradientMap.get(CurrentTrailModel);

        }
        if(segments == null) segments = new ArrayList<GradientSegment>();
        System.out.println("Segmentprint" + segments.size());



        MainPanel = new JPanel();

        this.add(MainPanel, BorderLayout.CENTER);



//        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
//        renderer.setPreferredSize(new Dimension(0, 0));
//        GradientTable.getTableHeader().setDefaultRenderer(renderer);
    }

    public void showFrame() {


        this.setVisible(true);
    }

    public void windowViews() {

        this.getContentPane().add(TrailList,BorderLayout.WEST);
        TrailList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TrailList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                GradientTableModel GTM;
                GradientTrailModel GradientModel = GradientFrame.this.TrailList.getSelectedValue();

                GradientController.getGC().selectGradientModel(GradientModel);
                GTM = new GradientTableModel(CurrentTrailModel);
                GradientTable = new JTable(GTM.getTableModel());
                GTM.getTableModel().fireTableDataChanged();
                GradientFrame.this.getContentPane().remove(GradientTable);
                GradientFrame.this.getContentPane().add(GradientTable);
            }
        });
        GradientTableModel GTM;
        ArrayList<GradientSegment> segments = null;
        if(CurrentTrailModel != null) {
            segments = PlanData.getInstance().GradientMap.get(CurrentTrailModel);

        }
        if(segments == null) segments = new ArrayList<GradientSegment>();
        System.out.println("Segmentprint" + segments.size());
        GTM = new GradientTableModel(CurrentTrailModel);
        GradientTable = new JTable(GTM.getTableModel());


        this.getContentPane().remove(GradientTable);
        this.getContentPane().add(GradientTable);

        this.setSize(700, 350);


    }

    private void initData() {
        ArrayList<Rail> railList = PlanData.getInstance().railList;
        DefaultListModel<GradientTrailModel> TrailListModel = new DefaultListModel<GradientTrailModel>();
        ArrayList<GradientSegment> segmentList;

        System.out.println("Rail size");
        System.out.println(railList.size());

        for(int i = 0; i < railList.size(); i++) {
            GradientSegment Segment;
            segmentList = new ArrayList<GradientSegment>();
            Rail R = railList.get(i);
            Trail T = R.getTrailModel();
            ETCS_GRADIENT defaultGrdient = new ETCS_GRADIENT();
            defaultGrdient.bGradient = 0;
            GradientTrailModel TrailModel = new GradientTrailModel(R);
            if(i == 1) {
                CurrentTrailModel = TrailModel;
            }
            SectionOfLine S = new SectionOfLine();

            SpotLocation BeginLocation = new SpotLocation(T.getChainageBeginn(), T, S);

            SpotLocation EndLocation = new SpotLocation(T.getChainageEnd(), T, S);


            // Test Values
            if(i != 0) {
                Segment = new GradientSegment(BeginLocation, EndLocation, ApplicationDirection.BOTH);

                Segment.setGradient(defaultGrdient, true);

                segmentList.add(Segment);
                S.gradientLocations.add(Segment);
                Segment = new GradientSegment(BeginLocation, EndLocation, ApplicationDirection.BOTH);
                Segment.setGradient(defaultGrdient, false);
                segmentList.add(Segment);
                S.gradientLocations.add(Segment);
            } else {
                Segment = new GradientSegment(BeginLocation, EndLocation, ApplicationDirection.BOTH);

                Segment.setGradient(defaultGrdient, false);

                segmentList.add(Segment);
                S.gradientLocations.add(Segment);

            }
            TrailListModel.add(i, TrailModel);


            PlanData.putGradientData(TrailModel, segmentList);

        }


        this.TrailList.setModel(TrailListModel);
    }
}
