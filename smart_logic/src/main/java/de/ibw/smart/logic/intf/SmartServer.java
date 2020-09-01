package de.ibw.smart.logic.intf;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl;
import de.ibw.smart.logic.intf.impl.threads.TmsOuputWorker;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.tms.intf.TmsDbdCommand;
import de.ibw.tms.intf.TmsMessage;
import de.ibw.tms.intf.TmsMovementAuthority;
import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.intf.cmd.CheckMovementAuthority;
import de.ibw.tms.intf.cmd.Commands;
import ebd.rbc_tms.util.exception.MissingInformationException;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import javax.swing.tree.ExpandVetoException;
import java.io.IOException;

/**
 * Der Smart Server ist ein Server f&uuml;r die Kommunikation der SL zum TMS. Die SL hat in dieser Kommunikation den Serverpart
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-07
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


            String received = (String) msg;
            if(EM != null) EM.log("SL received from TMS: " + received, "SMART_SERVER_INBOUND_HANDLER");
            TmsMessage TmsCommand = TmsMessage.generateFromTms(received);

            handleCommand(TmsCommand);
            ReferenceCountUtil.release(msg);



            //ctx.write(Unpooled.copiedBuffer("Hello " + received, CharsetUtil.UTF_8));



                // init communication to tms


        }

        private void handleCommand(TmsMessage tmsCommand) {
            SmartServer4TmsImpl ServerImpl = SmartServer4TmsImpl.instance;
            String sType = tmsCommand.getPayload().CommandType;
            Class CmdType = Commands.getClassByString(sType);
            if(CmdType.equals(TmsMovementAuthority.class)) {
                CheckMovementAuthority CMA = (CheckMovementAuthority) tmsCommand.getPayload();
                new Thread() {
                    @Override
                    public void run() {
                        ServerImpl.checkMovementAuthority(CMA.MaRequest, CMA.MaAdapter, CMA.uuid, CMA.tms_id, CMA.rbc_id,
                                CMA.lPriority);
                    }
                }.start();
            } else if(CmdType.equals(TmsDbdCommand.class)) {
                CheckDbdCommand CDC = (CheckDbdCommand) tmsCommand.getPayload();
                System.out.println("RESULT");
                try {
                    System.out.println(CDC.parseToJson());
                } catch (MissingInformationException e) {
                    e.printStackTrace();
                }
                System.out.println("RESULT_END");
            }
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



        this.SmartTms = new SmartServer4TmsImpl(SmartLogic.getRbcClient(),this);
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
     * startet diesen Server als Thread
     */
    @Override
    public void start() {
        super.start();
    }
}
