package de.ibw.tms.train.ui;

import de.ibw.tms.MainTmsSim;
import de.ibw.tms.gradient.profile.controller.GradientController;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.Route;
import de.ibw.tms.speed.profile.view.SpeedDialog;
import de.ibw.tms.trackplan.TrackplanGraphicPanel;
import de.ibw.tms.trackplan.controller.RouteController;
import de.ibw.tms.trackplan.ui.RouteComponent;
import de.ibw.tms.train.controller.TrainController;
import de.ibw.tms.train.model.TrainModel;
import ebd.rbc_tms.util.EOA;
import ebd.rbc_tms.util.ETCSVariables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.Flow;

public class SingleTrainSubPanel extends JPanel implements Flow.Subscriber<TrainModel> {

    public static SingleTrainSubPanel TrainPanel;

    private Flow.Subscription windowSubscription;
    private TrainModel Tm;
    public static float xFactor = 1.0f;


    JLabel TrainIdLabel;
    JComboBox<TrainModel> TrainBox;
    JTextField LabelField;

    public TrainController getSubController() {
        return SubController;
    }



    TrainController SubController;

    JButton ColorButton;
    JButton SetGradientProfile;
    JButton SetSpeedProfile;
    JButton NewTrainButton;
    JButton MaButton;
    JButton NewTrain;
    JLabel CategoryLabel;
    JComboBox CategoryComboBox;
    JLabel TrainLength;
    JTextField LengthField;
    JLabel SpeedLabel;
    JTextField SpeedField;
    SpeedProfilePanel SpeedPanel;
    TrackplanGraphicPanel TGP;
    public JFrame Parent;
    JPanel TopPanel;
    JPanel SecondPanel;

    public SingleTrainSubPanel(TrackplanGraphicPanel TGP, JFrame parentFrame) {
        super();
        TrainPanel = this;
        this.Parent = parentFrame;
        Collection<TrainModel> models = TrainModel.TrainRepo.getAll();
        int iInsertCount = models.size();
        if(iInsertCount == 0) {
            Tm = TrainModel.getDefaultModel();
        } else {
            Tm = models.iterator().next();
        }
        SubController = new TrainController(Tm,this);

        JPanel GraphicDescripturePanel = new JPanel();
        GraphicDescripturePanel.add(new JLabel("Branches: "));
        ClassLoader cl = this.getClass().getClassLoader();

        URL BranchLogoUrlA = cl.getResource("images/DefaultBranch.png");
        URL BranchLogoUrlB = cl.getResource("images/StreightBranch.png");
        JLabel DefaultBranching = null;
        JLabel StreightBranching = null;
        if(BranchLogoUrlA == null) {
            DefaultBranching = new JLabel("DB");
        } else {
            ImageIcon IconA = new ImageIcon(BranchLogoUrlA);
            DefaultBranching = new JLabel(IconA);
        }
        if(BranchLogoUrlB == null) {
            StreightBranching = new JLabel("SB");
        } else {
            ImageIcon IconB = new ImageIcon(BranchLogoUrlB);
            StreightBranching = new JLabel(IconB);
        }
        GraphicDescripturePanel.add(DefaultBranching);
        GraphicDescripturePanel.add(StreightBranching);
        TopPanel = new JPanel();

        SecondPanel = new JPanel();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS ));
        this.TGP = TGP;

        //TopPanel.setLayout(layout);
        //layout.setAutoCreateGaps(true);
        //layout.setAutoCreateContainerGaps(true);
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //GridLayout Layout = new GridLayout(0,7);

        //JPanel SecondPanel = new JPanel();
        genLabelfield();
        genColorButton();
        genGradientButton();
        genSpeedButton();
        //genNewTrainButton();
        genMabutton();
        genCategoryField();
        genTrainLengthField();
        genSpeedField();
        genTrainComboBox();
        //SpeedPanel = new SpeedProfilePanel(Tm, this);

        /*layout.setHorizontalGroup(
        layout.createSequentialGroup()

                    .addComponent(TrainIdLabel)
                    .addComponent(LabelField)
                    .addComponent(ColorButton)
                    .addComponent(MaButton)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(CategoryLabel)
                        .addComponent(CategoryField)
                        .addComponent(TrainLength)
                        .addComponent(LengthField)
                        .addComponent(SpeedLabel)
                        .addComponent(SpeedField)


                ).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(SpeedPanel)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TrainIdLabel)
                    .addComponent(LabelField)
                    .addComponent(ColorButton)
                    .addComponent(MaButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(CategoryLabel)
                        .addComponent(CategoryField)
                        .addComponent(TrainLength)
                        .addComponent(LengthField)
                        .addComponent(SpeedLabel)
                        .addComponent(SpeedField)
                ).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SpeedPanel))
        );*/






        TopPanel.add(TrainIdLabel);
        TopPanel.add(TrainBox);
        TopPanel.add(LabelField);
        TopPanel.add(ColorButton);
        TopPanel.add(SetGradientProfile);
        TopPanel.add(SetSpeedProfile);
        //TopPanel.add(NewTrainButton);
        SecondPanel.add(CategoryLabel);
        SecondPanel.add(CategoryComboBox);
        SecondPanel.add(TrainLength);
        SecondPanel.add(LengthField);
        SecondPanel.add(SpeedLabel);

        SecondPanel.add(SpeedField);
        SecondPanel.add(MaButton);
       this.add(GraphicDescripturePanel);
       this.add(TopPanel);
       this.add(SecondPanel);

        //this.add(SpeedPanel);
        manageComboBox();
        this.setVisible(true);

    }

    public void manageComboBox() {


        int iCurrentManagedTrains = TrainBox.getItemCount();
        Collection<TrainModel> models = TrainModel.TrainRepo.getAll();
        populateTrainBox(models, iCurrentManagedTrains);

    }

    public void populateTrainBox(Collection<TrainModel> models, int iCurrentManagedTrains) {
        for(int i = 0; i < iCurrentManagedTrains; i++ ) {
            TrainBox.remove(i);
        }
        for(TrainModel Tm: models) {
            TrainBox.addItem(Tm);
        }
    }

    public void genTrainComboBox() {
        TrainBox = new JComboBox<TrainModel>();

        TrainBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Combobox changed");
                TrainModel TmLocal = (TrainModel) TrainBox.getSelectedItem();
                setTrain(TmLocal);
                //SingleTrainSubPanel.this.repaint();


            }
        });
    }

    public void setTrain(TrainModel tmLocal) {
        if(tmLocal == null) return;
        SingleTrainSubPanel.this.Tm = tmLocal;
        SingleTrainSubPanel.this.SubController = new TrainController(SingleTrainSubPanel.this.Tm, SingleTrainSubPanel.this);
        //SingleTrainSubPanel.this.genTrainLengthField();
        //SingleTrainSubPanel.this.genSpeedField();
        //SingleTrainSubPanel.this.genLabelfield();
        SingleTrainSubPanel.this.applyModel();
        System.out.println("Label: " + SingleTrainSubPanel.this.Tm.label);
        RouteController RC = new RouteController(SingleTrainSubPanel.this.TGP.getRoutePort());
        RC.setRouteData(new Route());
        RC.publish();
        SingleTrainSubPanel.this.Parent.repaint();
    }

    private void genSpeedButton() {
        this.SetSpeedProfile = new JButton("Edit Speed Profile");
        this.SetSpeedProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Route R = SingleTrainSubPanel.this.TGP.getRouteModel();
                if(R == null) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            JOptionPane.showMessageDialog(new JFrame()
                                    ,"Es muss zuerst eine Route gesetzt werden.");
                        }
                    });

                } else {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {

                            SpeedDialog.displaySpeedDialog(RouteComponent.CSM,R);
                        }
                    });
                }
            }
        });
    }

    private void genGradientButton() {
        this.SetGradientProfile = new JButton("Edit Gradient Profile");
        this.SetGradientProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               new GradientController().showGradientSettings();
            }
        });
    }

    /**
     * @Deprecated
     */
    private void genNewTrainButton() {
        this.NewTrainButton = new JButton("Create New Train");
        this.NewTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //MainTmsSim.createTmsFrame();
            }
        });
    }

    private void sendMaToSmartLogic(Long lPrio, String tms_id, String rbc_id) {
        if(lPrio == null) {
            lPrio = 3L;
        }
        MaRequestWrapper RequestWrapper = SingleTrainSubPanel.this.TGP.getR();
        boolean m_ack = ETCSVariables.M_ACK_NOT_REQUIRED;
        int nid_lrbg


                ; int q_dir; int q_scale; EOA eoa;
        /*MA Ma = new MA(m_ack,nid_lrbg,q_dir,q_scale, eoa, null, null, null,
                null);
        RbcMaAdapter RbcMa = new RbcMaAdapter(Ma);

        CheckMovementAuthority MaToSend = MainTmsSim.generateMovementAuthority(RequestWrapper, lPrio);
        TmsMovementAuthority TMA = new TmsMovementAuthority(0, tms_id, rbc_id, MaToSend);
        SmartClientHandler ClientHandler = SmartClientHandler.getInstance();
        ClientHandler.sendCommand(TMA);

         */
    }

    private void genMabutton() {
        MaButton = new JButton("MA beantragen");
        MaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bIsShunting = false;
                UUID uuid = UUID.randomUUID();
                Route R = SingleTrainSubPanel.this.TGP.getRouteModel();
                MaRequestWrapper RequestWrapper = SingleTrainSubPanel.this.TGP.getR();
                RequestWrapper.setTm(SingleTrainSubPanel.this.Tm);
                String sRBC = SingleTrainSubPanel.this.Tm.getsLastKnownRBC();
                int iShuntingMode = JOptionPane.showConfirmDialog(null,
                        "Shall train go in shunting", "Enable Shunting Mode",
                        JOptionPane.YES_NO_OPTION);
                bIsShunting = iShuntingMode == JOptionPane.YES_OPTION;

                try {
                    R.saveWaypointIForTransmission();
                    SubController.requestMovementAuthority(RequestWrapper, R, sRBC, MainTmsSim.S_TMS_ID, uuid, bIsShunting);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    private void genColorButton() {
        this.ColorButton = new JButton("Choose Traincolor");
        this.ColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SubController.changeTraincolor(Tm.RepresentedColor);
            }
        });
    }

    private void genTrainLengthField() {
        TrainLength = new JLabel("Length(m):");
        LengthField = new JTextField(String.valueOf(Tm.length),7);
        LengthField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubController.changeLength(LengthField.getText());
            }
        });
    }

    private void genSpeedField() {
        SpeedLabel = new JLabel("Max. Speed(km/h):");
        SpeedField = new JTextField(String.valueOf(Tm.iSpeedMax), 10);
        SpeedField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubController.changeSpeed(SpeedField.getText());
            }
        });

    }


    private void genCategoryField() {
        CategoryLabel = new JLabel("Train Category:");
        initCategoryBox();

        CategoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubController.changeCategory((String) CategoryComboBox.getSelectedItem());
            }
        });
    }

    private void initCategoryBox() {
        CategoryComboBox = new JComboBox<String>();
        CategoryComboBox.addItem("Freight");
        CategoryComboBox.addItem("PAX regional");
        CategoryComboBox.addItem("PAX high-speed");
    }

    private void genLabelfield() {
        this.TrainIdLabel = new JLabel("Train Id");





        LabelField = new JTextField(Tm.label, 7);
        LabelField.setBackground(Tm.RepresentedColor);
        LabelField.setForeground(Color.WHITE);
        LabelField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SubController.changeLabel(LabelField.getText());
            }
        });
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

        this.windowSubscription = subscription;

        subscription.request(1);

    }

    @Override
    public void onNext(TrainModel item) {
        this.Tm = item;
        this.applyModel();

        this.windowSubscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {

        this.applyModel();
        MainTmsSim.MainFrame.revalidate();

    }

    private void applyModel() {
        this.LabelField.setText(Tm.label);
        this.LabelField.setBackground(Tm.RepresentedColor);
        if(Tm.category == null) {
            //TODO Package with TrainData;
            this.CategoryComboBox.setSelectedItem(Tm.category);
        }
        this.LengthField.setText(String.valueOf(Tm.length));
        this.SpeedField.setText(String.valueOf(Tm.iSpeedMax));



    }
}
