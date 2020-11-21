package de.ibw.tms.speed.profile.view;

import de.ibw.tms.ma.SpeedSegment;
import de.ibw.tms.speed.profile.controller.SegmentAddController;
import de.ibw.tms.speed.profile.model.SpeedSegmentViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Der Dailog der ein einzelnes Segment nachbearbeitbar macht.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class AddSegmentDialog extends JDialog {
    private JPanel AddPanel;

    private SpeedSegmentViewModel SegmentViewModel;

    private SegmentAddController AddController;
    private final JTextField beginField;
    private final JTextField endField;
    private final JTextField speedField;

    /**
     * Dieser Konstruktor intiiert den Dialog
     * @param SegmentViewModel {@link SpeedSegmentViewModel} - Model der Werte in der Ansicht
     * @param Ctrl {@link SegmentAddController} - Controller der Aktionen ausf&uuml;hrt
     */
    public AddSegmentDialog(SpeedSegmentViewModel SegmentViewModel, SegmentAddController Ctrl) {
        super(new JFrame(), "Add Segment", true);
        this.AddController = Ctrl;
        SegmentViewModel.setCtrl(Ctrl);
        Ctrl.setModel(SegmentViewModel);
        Ctrl.setView(this);
        this.SegmentViewModel = SegmentViewModel;
        SpeedSegment Segment = SegmentViewModel.getSegment();
        //int iMeterBegin = Segment.getBegin().getChainage().getiMeters();
        AddPanel = new JPanel();
        GroupLayout layout = new GroupLayout(AddPanel);
        AddPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        this.setLayout(new GridLayout(3,2));
        int iMinMeter = SegmentViewModel.getMinChainage().getiMeters();
        int iMaxMeter = SegmentViewModel.getMaxChainage().getiMeters();

        JLabel BeginLabel = new JLabel("Beginn in Meters (min: " + iMinMeter + " m):");
        JLabel EndLabel = new JLabel("End in Meters (max: " + iMaxMeter + " m):");
        JLabel SpeedLabel = new JLabel("Segment Speed ( 0-350 km/h):");
        JLabel Placeholder = new JLabel("");

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(BeginLabel).addComponent(EndLabel)
                .addComponent(SpeedLabel).addComponent(Placeholder));


        beginField = new JTextField();
        endField = new JTextField();
        speedField = new JTextField();

        //beginField.setText(String.valueOf(iMeterBegin));
        endField.setText(String.valueOf(iMaxMeter));
        speedField.setText(String.valueOf(Segment.getV_STATIC().bSpeed * 5));

        JButton SubmitButton = new JButton("Submit Segment");
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                AddSegmentDialog ThisDialog = AddSegmentDialog.this;
                String sBeginMeter = ThisDialog.beginField.getText();
                String sEndMeter = ThisDialog.endField.getText();
                String stringSpeed = ThisDialog.speedField.getText();
                AddSegmentDialog.this.AddController.submitSegment(sBeginMeter, sEndMeter, stringSpeed);
            }
        });

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(beginField).addComponent(endField)
                .addComponent(speedField).addComponent(SubmitButton)
        );
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(BeginLabel).addComponent(beginField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(EndLabel).addComponent(endField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(SpeedLabel).addComponent(speedField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(Placeholder).addComponent(SubmitButton));

        layout.setVerticalGroup(vGroup);
        getContentPane().add(AddPanel);
        pack();
        this.setVisible(true);
        //initUI(BeginLabel, EndLabel, SpeedLabel, Placeholder, beginField, endField, speedField, SubmitButton);

    }


    /*
    protected void initUI(JLabel beginLabel, JLabel endLabel, JLabel speedLabel, JLabel placeholder, JTextField beginField, JTextField endField, JTextField speedField, JButton submitButton) {
        getContentPane().add(beginLabel);
        getContentPane().add(beginField);
        getContentPane().add(endLabel);
        getContentPane().add(endField);
        getContentPane().add(speedLabel);
        getContentPane().add(speedField);
        getContentPane().add(placeholder);
        getContentPane().add(submitButton);

        this.setVisible(true);
    }
*/

}
