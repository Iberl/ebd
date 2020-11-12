package de.ibw.smart.logic.intf;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.impl.threads.TmsOuputWorker;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.IOException;

/**
 * Der Smart Server ist ein Server f&uuml;r die Kommunikation der SL zum TMS. Die SL hat in dieser Kommunikation den Serverpart
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-09-08
 */
public class SmartServer extends RbcModul  {



    private static Channel tmsChannelInstance = null;


    public static void setTmsOutChannel(Channel C) {
        tmsChannelInstance = C;
    }



    /**
     * Commincation Handler to TMS
     */
    private SmartServerHandler SmartHandler = null;

    /**
     * Handling Requests
     */
    private SmartServerFromTmsIntf SmartTms;



    /**
     * Implements Communcationt to TMS
     */
    private class SmartServerHandler extends ChannelInboundHandlerAdapter {
        public static final String SMART_SERVER_INBOUND_HANDLER = "SMART-SERVER-INBOUND-HANDLER";
        ChannelHandlerContext SmartHandlerCtx = null;
        SmartServerFromTmsIntf ServingTms = null;
        EventBusManager EM = null;

        public SmartServerHandler(SmartServerFromTmsIntf ServerLogicServingTms) {
            ServingTms = ServerLogicServingTms;
            try {
                EM = EventBusManager.registerOrGetBus(1, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /**
         * Diese Methode verwaltet was getan wird, solange die Verbindung zum TMS von der SL besteht.
         * Sobald die SL eine Nachricht zum Senden hat, wird durch den TMS Output Worker die Nachricht gesendet
         *
         * @param ctx - Netty context
         */

        @Override
        public void channelActive(ChannelHandlerContext ctx)  {
            TmsOuputWorker.SmartToTmsWorker = new TmsOuputWorker<SmartServerMessage>( SmartLogic.outputQueue, ctx);
            TmsOuputWorker.SmartToTmsWorker.start();

            if(EM != null) EM.log("SmartLogic Channel to TMS active", SMART_SERVER_INBOUND_HANDLER);



                // sends Message in queue



        }

        /**
         * Verwaltet das Lesen von Nachrichten vom TMS
         * @param ctx - Netty Context
         * @param msg - Empfangene Nachricht
         * @throws Exception - Kommunikationsfehler
         */

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


        }


        /**
         * Verwatet was unternommen wird wenn ein Kanal fertig gelesen hat.
         * @param ctx - Netty Kontext
         */

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                    .addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }

        /**
         * Verwaltet was der Server unternimmt, wenn ein Fehler eintrifft.
         * Bisher wird die Verbindung geschlossen.
         * @param ctx - Netty Context
         * @param cause - Fehler der auftratt
         */
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }

    /**
     * Konstruktor zum Starten des Smart Servers zur Verwaltung von Anfrangen an das SL vom TMS.
     * @param sHost - shall be null
     * @param iPort - port listening for Requests
     */
    public SmartServer(String sHost, int iPort) {
        super(null, sHost, iPort);



        this.SmartTms = null;
        this.SmartHandler = new SmartServerHandler(SmartTms);
    }

    /**
     * Startet einen Netty Server mit dem SmartHandler
     */
    public void run() {

            try {
                startServer(this.sHost, this.iPort, this.SmartHandler);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    /**
     * Beendet die Socket-Communikation
     */
    public void shutdown() {
        try {
            getGroup().shutdownGracefully().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * startet diesen Server als Thread
     */
    @Override
    public void start() {
        super.start();
    }
}
