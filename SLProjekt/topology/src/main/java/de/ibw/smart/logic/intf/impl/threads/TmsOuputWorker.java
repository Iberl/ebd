package de.ibw.smart.logic.intf.impl.threads;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

/**
 * Diese Klasse verwaltet die Senderoutine sowohl aus TMS zu SL als auch von SL zum TMS. Der Nachrichtentyp wird durch den Templateparameter T bestimmt
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
 */
public class TmsOuputWorker<T> extends Thread {

    /**
     * Bezeichnung dieses Moduls f&uuml;r das Logging
     */
    public static final String SENDING_MODUL = "SENDING-MODUL";
    /**
     * Senderoutine von SL zum TMS
     */
    public static TmsOuputWorker<SmartServerMessage> SmartToTmsWorker;
    /**
     * Senderoutine vom TMS zur SL
     */
    public static TmsOuputWorker<String> TmsToSmartWorker;

    private final SynchronousQueue<T> queue;
    private final ChannelHandlerContext ctx;

    /**
     * Konstruktor zum Instanziiern einer Senderoutine
     * @param queue - Warteschlange für Nachrichtenausgang
     * @param ctx - Kontext der Nachrichten einstellt
     */
    public TmsOuputWorker(SynchronousQueue<T> queue, ChannelHandlerContext ctx) {
        this.queue = queue;
        this.ctx = ctx;
    }


    /**
     * start der Senderoutine
     */
    public void run() {
        try {
            EventBusManager EBM = null;
            while ( true ) {
                T Message = queue.take();
                if(this == SmartToTmsWorker) {
                    if(EBM == null) {
                        try {
                            EBM = EventBusManager.registerOrGetBus(1,false);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("SL sends to TMS message");
                    if(EBM != null) EBM.log("SL sends to TMS message", SENDING_MODUL);
                } else {
                    if(EBM == null) {
                        try {
                            EBM = EventBusManager.registerOrGetBus(1,true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("TMS sends to SL message");
                    if(EBM != null) EBM.log("TMS sends to SL message", SENDING_MODUL);
                }

                if(EBM != null) EBM.log(Message.toString(), SENDING_MODUL);
                ctx.write(Message);
                ctx.flush();
            }
        }
        catch ( InterruptedException ie ) {
            ie.printStackTrace();
        }
    }
}
