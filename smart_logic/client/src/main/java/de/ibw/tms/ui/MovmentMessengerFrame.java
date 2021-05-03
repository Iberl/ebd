package de.ibw.tms.ui;

import de.ibw.tms.entities.TmsJpaApp;
import de.ibw.tms.intf.MovementMessengerIntf;
import de.ibw.tms.intf.messenger.IMovementMessengerIntf;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-01-30
 */
public class MovmentMessengerFrame extends JFrame {


    private final TextArea messageArea;


    private static MovmentMessengerFrame instance;

    public static MovmentMessengerFrame getInstance() {
        if(instance == null) {
            instance = new MovmentMessengerFrame();
        }
        return instance;
    }

    private MovmentMessengerFrame() {
        super("Movement Messenger");
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        messageArea = new TextArea(7,10);
        this.add(messageArea);
        messageArea.setEditable(false);
        this.setSize(700, 300);
        this.setVisible(true);
    }

    public void log(IMovementMessengerIntf msg) {
        messageArea.append(msg.showOnMovementMessenger());
    }

}
