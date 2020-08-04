package de.ibw.smart.logic.intf.ui;

import de.ibw.smart.logic.intf.Scenario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ScenarioPanel extends JPanel {
    JComboBox<Scenario> ScenarioSelectorBox = new JComboBox<Scenario>();
    JTextField PortField = new JTextField("22223");
    JButton RunButton;

    public ScenarioPanel() {
        super();
        List<Scenario> scenarios = Scenario.allSzenarios;
        for(Scenario S: scenarios) {
            ScenarioSelectorBox.addItem(S);
        }
        RunButton = new JButton("Starte Szenario");
        RunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String sPort = PortField.getText();
                Integer iPort;
                try {
                    iPort = Integer.parseInt(sPort);
                } catch(NumberFormatException E) {
                    PortField.setText("22223");
                    return;
                }
                    Scenario S = (Scenario) ScenarioSelectorBox.getSelectedItem();
                    S.iPort = iPort;
                    try {
                        S.runSzenario();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
        });
        initPanel();

    }

    private void initPanel() {
        this.add(new JLabel("Szenario: "));
        this.add(ScenarioSelectorBox);
        this.add(new JLabel("TMS Server Port: "));
        this.add(PortField);
        this.add(RunButton);

    }

}
