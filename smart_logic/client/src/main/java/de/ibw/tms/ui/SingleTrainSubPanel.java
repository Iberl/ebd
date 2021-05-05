package de.ibw.tms.ui;

import de.ibw.tms.MainTmsSim;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.speed.profile.view.SpeedDialog;
import de.ibw.tms.trackplan.TrackplanGraphicPanel;
import de.ibw.tms.trackplan.controller.RouteController;
import de.ibw.tms.trackplan.ui.RouteComponent;
import de.ibw.tms.train.model.TrainModel;
import ebd.rbc_tms.util.EOA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.Flow;

/**
 * Das Panel unterhalb der Karte beim Erstellen einer MA
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.51
 * @since 2020-03-10
 */
public class SingleTrainSubPanel extends JPanel implements Flow.Subscriber<TrainModel> {

    /**
     * Die aktuelle Instanz des Panels
     */
    public static SingleTrainSubPanel TrainPanel;

    private Flow.Subscription windowSubscription;
    private TrainModel Tm;
    /**
     * PositonsSkalierung von Bilder sollte 1.0f bleiben
     */
    public static float xFactor = 1.0f;


    private JLabel TrainIdLabel;
    private JComboBox<TrainModel> TrainBox;
    private JTextField LabelField;

    /**
     * Gibt TrainController wider. Er verwaltet &Auml;nderungen des Nutzers am Zug durch die GUI dieses Subpanels
     * @return TrainController
     */
    public TrainController getSubController() {
        return SubController;
    }



    private TrainController SubController;

    private JButton ColorButton;
    private JButton SetGradientProfile;
    private JButton SetSpeedProfile;
    private JButton NewTrainButton;
    private JButton MaButton;
    private JButton NewTrain;
    private JLabel CategoryLabel;
    private JComboBox CategoryComboBox;
    private JLabel TrainLength;
    private JTextField LengthField;
    private JLabel SpeedLabel;
    private JTextField SpeedField;
    private TrackplanGraphicPanel TGP;
    /**
     * Frame der dieses Panel beinhaltet
     */
    public JFrame Parent;
    private JPanel TopPanel;
    private JPanel SecondPanel;

    /**
     * Instanziiert dieses Panel unterhalb der Streckenansicht bei MA beantragungs UIs.
     * @param TGP {@link TrackplanGraphicPanel} - das Panel behinhaltet die Karte und dieses Panel
     * @param parentFrame {@link JFrame} - Frame der &uuml;bergeordnet ist
     */
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

    private void manageComboBox() {


        int iCurrentManagedTrains = TrainBox.getItemCount();
        Collection<TrainModel> models = TrainModel.TrainRepo.getAll();
        populateTrainBox(models, iCurrentManagedTrains);

    }

    private void populateTrainBox(Collection<TrainModel> models, int iCurrentManagedTrains) {
        for(int i = 0; i < iCurrentManagedTrains; i++ ) {
            TrainBox.remove(i);
        }
        for(TrainModel Tm: models) {
            TrainBox.addItem(Tm);
        }
    }

    private void genTrainComboBox() {
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

    /**
     * Setzt das Model des Zuges, der durch dieses Panel bearbeitet werden kann
     * @param tmLocal {@link TrainModel}
     */
    public void setTrain(TrainModel tmLocal) {
        if(tmLocal == null) return;
        SingleTrainSubPanel.this.Tm = tmLocal;
        SingleTrainSubPanel.this.SubController = new TrainController(SingleTrainSubPanel.this.Tm, this);
        //SingleTrainSubPanel.this.genTrainLengthField();
        //SingleTrainSubPanel.this.genSpeedField();
        //SingleTrainSubPanel.this.genLabelfield();
        SingleTrainSubPanel.this.applyModel();
        System.out.println("Label: " + SingleTrainSubPanel.this.Tm.label);
        RouteController RC = new RouteController(SingleTrainSubPanel.this.TGP.getRoutePort());
        RC.setRouteData(new Route(new ArrayList<>()));
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

                //new GradientController().showGradientSettings();
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
        //boolean m_ack = ETCSVariables.M_ACK_NOT_REQUIRED;
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
                try {


                    RouteComponent.requestSVL(Parent, R.getLocation().getEnd());

                } catch(Exception E) {
                    E.printStackTrace();
                    JOptionPane.showMessageDialog(SingleTrainSubPanel.this.Parent,
                            "Die MA wurde nicht gesendet, da die SVL nicht gesetzt werden konnte, bitte Route prüfen.");
                    return;
                }

                MaRequestWrapper RequestWrapper = SingleTrainSubPanel.this.TGP.getR();
                RequestWrapper.setTm(SingleTrainSubPanel.this.Tm);
                String sRBC = SingleTrainSubPanel.this.Tm.getsLastKnownRBC();
                int iShuntingMode = JOptionPane.showConfirmDialog(null,
                        "Shall train go in shunting", "Enable Shunting Mode",
                        JOptionPane.YES_NO_OPTION);
                bIsShunting = iShuntingMode == JOptionPane.YES_OPTION;

                try {
                    //R.saveWaypointsForProcessing(true);
                    SubController.requestMovementAuthority(RequestWrapper, R, sRBC, MainTmsSim.S_TMS_ID, uuid, bIsShunting);
                    SingleTrainSubPanel.this.Parent.dispatchEvent(new WindowEvent(SingleTrainSubPanel.this.Parent, WindowEvent.WINDOW_CLOSING));
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(SingleTrainSubPanel.this.Parent,
                            "Die Ma wurde nicht gesendet, bitte Route prüfen.");
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
                /*SubController.changeLength(LengthField.getText());*/
            }
        });
    }

    private void genSpeedField() {
        SpeedLabel = new JLabel("Max. Speed(km/h):");
        SpeedField = new JTextField(String.valueOf(Tm.iSpeedMax), 10);
        SpeedField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SubController.changeSpeed(SpeedField.getText());
            }
        });

    }


    private void genCategoryField() {
        CategoryLabel = new JLabel("Train Category:");
        initCategoryBox();

        CategoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // SubController.changeCategory((String) CategoryComboBox.getSelectedItem());
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
        LabelField.setEditable(false);
        /* LabelField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SubController.changeLabel(LabelField.getText());
            }
        });*/
    }

    /**
     * Schreibt diese Klasse als horchend auf, wenn Zugdaten ankommen.
     * Das kann durch Position Reports passieren.
     * @param subscription Flow.Subscription
     */

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

        this.windowSubscription = subscription;

        subscription.request(1);

    }

    /**
     * Neue Daten des Zuges
     * @param item {@link TrainModel}
     */

    @Override
    public void onNext(TrainModel item) {
        this.Tm = item;
        this.applyModel();

        this.windowSubscription.request(1);
    }

    /**
     * Fehler bei verarbeitung ankommender Zugdaten
     * @param t {@link Throwable} - Fehler
     */

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    /**
     * Wenn Zugdaten ankommen wird das Hauptfenster mit allen Subkomponenten revalidiert.
     */

    @Override
    public void onComplete() {


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
