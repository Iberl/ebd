package de.ibw.tms.trackplan;

import de.ibw.tms.ma.MaRequestWrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Fenster in dem Ma Beantragt werden.
 * Es hat ein eigene Kartenasnicht.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class MaCreatingFrame extends JFrame {

    /**
     * Es sollte nur eine Instanz offen sein. Sie wird hier gespeichert.
     */
    public static MaCreatingFrame CurrentMaCreatingFrame = null;
    private MaRequestWrapper Request;

    private JFrame MainFrame;

    /**
     * Konstruktor diesers Ma-Erstellungsfensters
     * @param MovementAuthRequest - Zu bearbeitende MA
     * @param MainFrame - Zugeordnetes Vaterfenster
     */
    public MaCreatingFrame(MaRequestWrapper MovementAuthRequest, JFrame MainFrame) {
        super("MA beantragen");
        this.MainFrame = MainFrame;

        Request = MovementAuthRequest;

        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



        MaCreatingFrame.CurrentMaCreatingFrame = this;






        this.setSize(700, 350);

        this.MainFrame.setVisible(false);
        addCloseHandler();
        this.setVisible(true);
    }

    private void addCloseHandler() {
        this.addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                MaCreatingFrame.this.MainFrame.setVisible(true);
            }
        });
    }




}
