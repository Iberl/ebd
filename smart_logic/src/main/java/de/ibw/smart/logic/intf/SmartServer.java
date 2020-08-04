package de.ibw.smart.logic.intf;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl;
import de.ibw.smart.logic.intf.impl.threads.TmsOuputWorker;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.tms.intf.TmsMessage;
import de.ibw.tms.intf.TmsMovementAuthority;
import de.ibw.tms.intf.cmd.CheckMovementAuthority;
import de.ibw.tms.intf.cmd.Commands;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import javax.swing.tree.ExpandVetoException;
import java.io.IOException;

public class SmartServer extends RbcModul  {



    private static Channel tmsChannelInstance = null;
    public static Channel getTmsOutChannel() {
        return tmsChannelInstance;
    }
    public static void setTmsOutChannel(Channel C) {
        tmsChannelInstance = C;
    }


    /**
     * Receives Requests from TMS
     */
    private static SmartServer SmartServForTms;
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



        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            TmsOuputWorker.SmartToTmsWorker = new TmsOuputWorker<SmartServerMessage>( SmartLogic.outputQueue, ctx);
            TmsOuputWorker.SmartToTmsWorker.start();

            if(EM != null) EM.log("SmartLogic Channel to TMS active", SMART_SERVER_INBOUND_HANDLER);



                // sends Message in queue



        }

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
            }
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                    .addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }

    /**
     * Server to TMS constructor
     * @param sHost - shall be null
     * @param iPort - port listening for Requests
     */
    public SmartServer(String sHost, int iPort) {
        super(null, sHost, iPort);



        this.SmartTms = new SmartServer4TmsImpl(SmartLogic.getRbcClient(),this);
        this.SmartHandler = new SmartServerHandler(SmartTms);
    }

    public void run() {

            try {
                startServer(this.sHost, this.iPort, this.SmartHandler);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    @Override
    public void start() {
        super.start();
    }
}
