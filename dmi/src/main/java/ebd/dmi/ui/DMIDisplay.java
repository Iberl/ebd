package ebd.dmi.ui;

import ebd.dmi.ui.panels.*;
import ebd.dmi.ui.utility.DMIUtility;
import ebd.dmi.ui.utility.DMIColor;
import ebd.globalUtils.speedInterventionLevel.SpeedInterventionLevel;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DMIDisplay extends JFrame {

    private PanelA panelA;
    private PanelB panelB;
    private PanelC panelC;
    private PanelD panelD;
    private PanelE panelE;
    private PanelG panelG;

    /** Grund Panel, auf welchem alle anderen liegen. */
    private JPanel contentPane;

    /** Speichert alle Elemente, welche mit resize angepasst werden sollen. */
    private List<Scalable> scaleableObjects = new ArrayList<Scalable>();

    /** Speichert alle Elemente, welche mit resize angepasst werden sollen. */
    private List<Updatable> changeValues = new ArrayList<Updatable>();

    public DMIDisplay() {
        setResizable(true);
        setTitle("ETCS DMI - Main");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(DMIUtility.instance().getColor(DMIColor.DARK_BLUE));
        double skalierungsFaktor = DMIUtility.instance().getSkalierungsFaktor();
        getContentPane().setLayout(new BorderLayout());
        this.contentPane = new JPanel();
        this.contentPane.setBackground(DMIUtility.instance().getColor(DMIColor.DARK_BLUE));
        getContentPane().add(this.contentPane, BorderLayout.CENTER);
        this.contentPane.setLayout(null);
        this.contentPane.setPreferredSize(new Dimension((int) (640 * skalierungsFaktor), (int) (480 * skalierungsFaktor)));

        /*
        this.panelA = new PanelA();
        this.contentPane.add(this.panelA);
        this.scaleableObjects.add(this.panelA);
        this.panelA.addChildren(this);
        */


        this.panelB = new PanelB();
        this.contentPane.add(this.panelB);
        this.scaleableObjects.add(this.panelB);
        this.panelB.addChildren(this);

        /*
        this.panelC = new PanelC();
        this.contentPane.add(this.panelC);
        this.scaleableObjects.add(this.panelC);
        this.panelC.addChildren(this);

        this.panelD = new PanelD();
        this.contentPane.add(this.panelD);
        this.scaleableObjects.add(this.panelD);
        this.panelD.addChildren(this);

        this.panelE = new PanelE();
        this.contentPane.add(this.panelE);
        this.scaleableObjects.add(this.panelE);
        this.panelE.addChildren(this);
        */

        this.panelG = new PanelG();
        this.contentPane.add(this.panelG);
        this.scaleableObjects.add(this.panelG);
        this.panelG.addChildren(this);

        this.pack();
        this.setVisible(true);
    }

    /**
     * Fügt ein skalierbares Element zur entsprechenden Liste hinzu.
     *
     * @param c Das hinzufügende Element
     */
    public final void addScaleable(final Scalable c) {
        this.scaleableObjects.add(c);
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.panelB.getSpeedometer().setCurrentSpeed((int) currentSpeed);
    }

    public void setCurrentTargetSpeed(double currentTargetSpeed) {
        this.panelB.getSpeedometer().setCurrentTargetSpeed((int) currentTargetSpeed);
    }

    /*
    public void setTargetDistance(int targetDistance) {
        this.panelA.setTargetDistance(targetDistance);
    }
    */

    public void setSpeedInterventionLevel(SpeedInterventionLevel speedInterventionLevel) {
        this.panelB.getSpeedometer().setSpeedInterventionLevel(speedInterventionLevel);
    }

    public void setSpeedSupervisionLevel(SpeedSupervisionState speedInterventionState) {
        this.panelB.getSpeedometer().setSpeedSupervisionState(speedInterventionState);
    }

    public void setCurrentIndSpeed(double currentIndSpeed) {
        this.panelB.getSpeedometer().setCurrentIndSpeed((int) currentIndSpeed);
    }

    public void setCurrentPermSpeed(double currentPermSpeed) {
        this.panelB.getSpeedometer().setCurrentPermSpeed((int) currentPermSpeed);
    }

    public void setCurrentWarnSpeed(double currentWarnSpeed) {
        this.panelB.getSpeedometer().setCurrentWarnSpeed((int) currentWarnSpeed);
    }

    public void setCurrentIntervSpeed(double currentIntervSpeed) {
        this.panelB.getSpeedometer().setCurrentIntervSpeed((int) currentIntervSpeed);
    }
}