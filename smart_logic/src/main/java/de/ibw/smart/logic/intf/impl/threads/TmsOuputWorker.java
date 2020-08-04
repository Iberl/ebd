package de.ibw.smart.logic.intf.impl.threads;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

public class TmsOuputWorker<T> extends Thread {

    public static final String SENDING_MODUL = "SENDING-MODUL";
    public static TmsOuputWorker<SmartServerMessage> SmartToTmsWorker;
    public static TmsOuputWorker<String> TmsToSmartWorker;

    private final SynchronousQueue<T> queue;
    private final ChannelHandlerContext ctx;
    public TmsOuputWorker(SynchronousQueue<T> queue, ChannelHandlerContext ctx) {
        this.queue = queue;
        this.ctx = ctx;
    }



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
