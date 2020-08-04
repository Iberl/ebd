package de.ibw.smart.logic.intf;

import de.ibw.smart.logic.EventBusManager;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.message.Message_00;
import ebd.rbc_tms.message.Message_15;
import ebd.rbc_tms.message.Message_21;
import ebd.rbc_tms.payload.Payload_00;
import ebd.rbc_tms.payload.Payload_15;
import ebd.rbc_tms.payload.Payload_21;
import ebd.rbc_tms.util.*;
import ebd.rbc_tms.util.exception.MissingInformationException;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.PriorityBlockingQueue;

public class RbcModul extends Thread {

    public static final String RBC_MODUL = "RBC-MODUL";
    public static final String TMS_PROXY = "TMS-PROXY";
    private ebd.rbc_tms.Message Message = null;
    private PriorityBlockingQueue<PriorityMessage> outputQueue = new PriorityBlockingQueue<>();

    public void setTmsHandler(TmsIntf tmsHandler) {
        TmsHandler = tmsHandler;
    }

    private volatile TmsIntf TmsHandler;
    private SimpleChannelInboundHandler CustomHandlerTcpClient = null;

    private int iSmartLogicID = 1;

    public static Message_00 createResponseMessage(int iErrorCode, String rbc_id, UUID uuid, String tms_id, TrainInfo TI) {

            Payload_00 Error = new Payload_00(iErrorCode,TI);
            return new Message_00(uuid, tms_id, rbc_id, Error);
    }

    public Boolean isClient = false;
    public String sHost = "localhost";
    public int iPort = 22223;

    public RbcModul(boolean bIsClient, String sHost, int iPort) {
        if(sHost == null) sHost = "localhost";
        this.isClient = bIsClient;
        this.sHost = sHost;
        this.iPort = iPort;
    }

    public RbcModul(Message M, String sHost, int iPort) {
        if(sHost == null) sHost = "localhost";
        this.isClient = true;
        this.sHost = sHost;
        this.iPort = iPort;
        this.Message = M;

    }

    public void sendMessage(PriorityMessage priorityMessage) {
        this.outputQueue.offer(priorityMessage);
    }

    public void start() {
        super.start();
    }

    public void run() {

        if(isClient) {
            try {

                if(this.Message != null) {
                    startTcpClient(this.sHost, this.iPort, null, this.Message);
                }
                if(this.CustomHandlerTcpClient == null) {

                    EventBusManager EM = null;
                    try {
                        EM = EventBusManager.registerOrGetBus(iSmartLogicID,false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    while(true) {

                        PriorityMessage PM = this.outputQueue.take();
                        Message M = PM.getMsg();




                        SL_To_RBC_ClientThread SlThread = new SL_To_RBC_ClientThread(this.sHost, this.iPort, PM.getMsg());

                        SlThread.start();
                        if(EM != null) {
                            try {
                                EM.log("Send Message to RBC: " + M.parseToJson(), RBC_MODUL);
                            } catch (MissingInformationException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    startTcpClient(this.sHost, this.iPort, this.CustomHandlerTcpClient, null);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                startTmsServer(this.sHost, this.iPort);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class SL_To_RBC_ClientThread extends Thread {
        private final String sHost;
        private final int iPort;
        private final Message M;
        public SL_To_RBC_ClientThread(String sHost, int iPort, Message M) {
            this.sHost = sHost;
            this.iPort = iPort;
            this.M = M;
        }

        @Override
        public void run() {
            try {
                startTcpClient(this.sHost, this.iPort, null,M);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        //boolean b4Show;
        /*boolean bIsClient = true;
        RbcModul TmsServer = new RbcModul(!bIsClient, null, 22223);
        TmsIntf TestTms = new TestTms();
        TmsServer.setTmsHandler(TestTms);
        TestTms.setTmsServer(TmsServer);
        RbcModul TmsClient = new RbcModul(bIsClient, null, 22224);
        TmsServer.start();
        TmsClient.start();
        */

        RbcModul RbcClient = null;
        TrainInfo Info = new TrainInfo(0, 0, 0L);
        PositionInfo PosInfo = new PositionInfo(0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0);
        Payload_15 MaRequestLoad = new Payload_15(Info, PosInfo, 0);
        Message_15 RbcMaRequest = new Message_15(UUID.randomUUID(), "TMS_A1", "RBC_1", MaRequestLoad);

        RbcClient = new RbcModul(RbcMaRequest, null, 22223);

        RbcClient.start();
    }



    public static class TcpClientHandler extends SimpleChannelInboundHandler {

        private final int iSmartLogicId = 1;
        private Message M = null;
        private EventBusManager EM = null;


        public TcpClientHandler(Message Msg) {
            this.M = Msg;
            try {
                EM = EventBusManager.registerOrGetBus(iSmartLogicId, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws MissingInformationException {
            if(M != null) {
                if(EM != null) EM.log("SL trys sending Message to RBC", RBC_MODUL);

                String sSend = M.parseToJson() + "\n";
                channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(sSend, CharsetUtil.UTF_8));
                EM.log("SL has send message to RBC", RBC_MODUL);

            } else {
                if(EM != null) EM.log("SL trys sending Message to RBC", RBC_MODUL);

            }
        }




        @Override
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause){
            cause.printStackTrace();
            channelHandlerContext.close();
        }

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object sJsonMsg) throws Exception {
            ByteBuf inBuffer = (ByteBuf) sJsonMsg;

            String received = inBuffer.toString(CharsetUtil.UTF_8);
            if(EM != null) EM.log("Client received: " + received , RBC_MODUL);
            inBuffer.release();
        }
    }


    public class TmsServerHandler extends ChannelInboundHandlerAdapter {

        public static final String TMS_HANDLER = "TMS-HANDLER";
        private final int iSmartLogicId = 1;
        private EventBusManager EBM;

        public TmsServerHandler() {
            super();
            try {
                EBM = EventBusManager.registerOrGetBus(iSmartLogicID, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


            if(EBM != null) EBM.log("Received Message from RBC", TMS_HANDLER);
            //ctx.write(Unpooled.copiedBuffer("Hello " + received, CharsetUtil.UTF_8));

            new Thread() {
                @Override
                public void run() {
                    try {
                        if(EBM != null) EBM.log("Run TMS Handler Thread", TMS_HANDLER);
                        ByteBuf inBuffer = (ByteBuf) msg;

                        String received = inBuffer.toString(CharsetUtil.UTF_8);
                        if(EBM != null) EBM.log("SL received from RBC: " + received, TMS_HANDLER);

                        serverHandleJson(ctx, received);
                        inBuffer.release();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (MissingInformationException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                    .addListener(ChannelFutureListener.CLOSE);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }

    private synchronized void serverHandleJson(ChannelHandlerContext writeCtx, String received) throws ClassNotFoundException, MissingInformationException {
        Message<Payload> msgFromRbc = Message.generateFrom(received);
        if(msgFromRbc == null) return;
        int iType = msgFromRbc.getHeader().type;
        new Thread(() -> {
            switch (iType) {
                case (0): {

                    TmsHandler.handleNoError(msgFromRbc);
                    break;
                }
                case (1): {
                    Message WriteBack = TmsHandler.handleRegister(msgFromRbc);
                    SmartLogic.getRbcClient().sendMessage(new PriorityMessage(WriteBack, 3L));
                    //writeCtx.write(Unpooled.copiedBuffer(WriteBack.parseToJson(), CharsetUtil.UTF_8));
                    break;
                }

                case (10): {
                    Message WriteBack = TmsHandler.handleLogin(msgFromRbc);
                    SmartLogic.getRbcClient().sendMessage(new PriorityMessage(WriteBack, 3L));
                    break;
                }
                case (14): {
                    Message WriteBack = TmsHandler.handlePositionReport(msgFromRbc);
                    SmartLogic.getRbcClient().sendMessage(new PriorityMessage(WriteBack, 3L));
                    break;
                }
                case (15): {

                    Message WriteBack = TmsHandler.handleMaRequest(msgFromRbc);
                    SmartLogic.getRbcClient().sendMessage(new PriorityMessage(WriteBack, 3L));

                    break;
                }

            }
        }).start();
    }

    private void handleMaRequest(ChannelHandlerContext writeCtx, Message<Payload> msgFromRbc) throws MissingInformationException {
        //TODO save messages 4 rasking by UUID
        String rbc_id = msgFromRbc.getHeader().rbc_id;
        int i15KMh = 3;
        int d300 = 300; // 300 meter bei Qscale 1m
        EOA.EndTimer EoaTimer = new EOA.EndTimer(ETCSVariables.T_ENDTIMER_INFINITY, d300 );
        EOA.DangerPoint DangerPoint = new EOA.DangerPoint(ETCSVariables.INTEGER_NOVALUE, ETCSVariables.V_RELEASEDP_ONBOARD);
        EOA.Overlap Overlap = new EOA.Overlap(ETCSVariables.INTEGER_NOVALUE, ETCSVariables.T_OL_INFINITY,
                ETCSVariables.INTEGER_NOVALUE, ETCSVariables.V_RELEASEOL_ONBOARD);

        EOA EoaEmpty = new EOA(ETCSVariables.Q_DIR_BOTH, ETCSVariables.Q_SCALE_1M, i15KMh, ETCSVariables.T_LOA_INFINITY,
                EoaTimer, DangerPoint,Overlap);
        MA Ma = new MA(true, ETCSVariables.NID_LRBG_UNKNOWN,ETCSVariables.Q_DIR_BOTH, ETCSVariables.Q_SCALE_1M,
                EoaEmpty, null, null, null, null);
        Payload_21 SendMaPayload = new Payload_21(0,Ma);
        Message_21 SendMA = new Message_21(UUID.randomUUID(), "TMS_A1", rbc_id, SendMaPayload);
        writeCtx.write(Unpooled.copiedBuffer(SendMA.parseToJson(), CharsetUtil.UTF_8));
    }

    public static void startTcpClient(String sHost, int iPort, SimpleChannelInboundHandler customHandlerTcpClient, Message Msg) throws InterruptedException {
        EventBusManager EM = null;
        try {
            EM = EventBusManager.registerOrGetBus(1, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sHost == null) sHost = "localhost";
        if(customHandlerTcpClient == null) customHandlerTcpClient = new TcpClientHandler(Msg);
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap clientBootstrap = new Bootstrap();

            clientBootstrap.group(group);
            clientBootstrap.channel(NioSocketChannel.class);
            clientBootstrap.remoteAddress(new InetSocketAddress(sHost, iPort));
            SimpleChannelInboundHandler finalCustomHandlerTcpClient = customHandlerTcpClient;
            EventBusManager finalEM = EM;
            clientBootstrap.handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(finalCustomHandlerTcpClient);
                    if(finalEM != null) finalEM.log("SL opened Channel to RBC", RBC_MODUL);


                }
            });
            ChannelFuture channelFuture = clientBootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }


    //SL Server
    public void startServer(String sHost, int iPort, ChannelInboundHandlerAdapter ServerHandler) throws InterruptedException {
        if(sHost == null) sHost = "localhost";
        EventBusManager EM = null;
        try {
            EM = EventBusManager.registerOrGetBus(1, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventLoopGroup group = new NioEventLoopGroup();


        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.localAddress(new InetSocketAddress(sHost, iPort));

            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ObjectEncoder());
                    socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(
                            getClass().getClassLoader())));
                    socketChannel.pipeline().addLast(ServerHandler);
                    SmartServer.setTmsOutChannel(socketChannel);
                }
            }).childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture channelFuture = serverBootstrap.bind(iPort).sync();
            if(channelFuture.isSuccess()) {
                if(EM != null) EM.log("Smart Tcp Server (for TMS) started successfully","SMART-TMS-SERVER");


            } else {
                if(EM != null) EM.log("Smart Tcp Server (for TMS) starting failed","SMART-TMS-SERVER");
            }
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
            if(EM != null) EM.log("Smart Tcp Server (for TMS) shutdown","SMART-TMS-SERVER");
        }

    }

    public void startTmsServer(String sHost, int iPort) throws InterruptedException {
        if(sHost == null) sHost = "localhost";
        EventBusManager EM = null;
        try {
            EM = EventBusManager.registerOrGetBus(1, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.localAddress(new InetSocketAddress(sHost, iPort));

            EventBusManager finalEM = EM;
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new TmsServerHandler());
                    if(finalEM != null) finalEM.log("TMS PROXY on Smart Logic Listening", TMS_PROXY);
                }
            });

            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
        /*
        @Override
        public String processRequest (String Req){

            RbcMA NextMA = serveMaForRbc();


            try {
                return NextMA.toJson();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }*/
    }


    public static class TestTms implements TmsIntf {

        private RbcModul TestServerMod;

        @Override
        public void setTmsServer(RbcModul TmsServer) {
            this.TestServerMod = TmsServer;
        }

        @Override
        public Message handleMaRequest(Message<Payload> msgFromRbc) {
            String rbc_id = msgFromRbc.getHeader().rbc_id;
            int i15KMh = 3;
            int d300 = 300; // 300 meter bei Qscale 1m
            EOA.EndTimer EoaTimer = new EOA.EndTimer(ETCSVariables.T_ENDTIMER_INFINITY, d300 );
            EOA.DangerPoint DangerPoint = new EOA.DangerPoint(ETCSVariables.INTEGER_NOVALUE, ETCSVariables.V_RELEASEDP_ONBOARD);
            EOA.Overlap Overlap = new EOA.Overlap(ETCSVariables.INTEGER_NOVALUE, ETCSVariables.T_OL_INFINITY,
                    ETCSVariables.INTEGER_NOVALUE, ETCSVariables.V_RELEASEOL_ONBOARD);

            EOA EoaEmpty = new EOA(ETCSVariables.Q_DIR_BOTH, ETCSVariables.Q_SCALE_1M, i15KMh, ETCSVariables.T_LOA_INFINITY,
                    EoaTimer, DangerPoint,Overlap);
            MA Ma = new MA(true, ETCSVariables.NID_LRBG_UNKNOWN,ETCSVariables.Q_DIR_BOTH, ETCSVariables.Q_SCALE_1M,
                    EoaEmpty, null, null, null, null);
            Payload_21 SendMaPayload = new Payload_21(0,Ma);
            Payload_00 NoError = new Payload_00(0,null);
            UUID uuid = msgFromRbc.getHeader().uuid;
            Message_21 SendMA = new Message_21(uuid, "TMS_A1", rbc_id, SendMaPayload);
            this.TestServerMod.outputQueue.offer(new PriorityMessage(SendMA, 1L));
            return createDummyNoErrorMsg(rbc_id, uuid);
        }

        private Message_00 createDummyNoErrorMsg(String rbc_id, UUID uuid) {
            Payload_00 NoError = new Payload_00(0,null);
            return new Message_00(uuid, "TMS_A1", rbc_id, NoError);
        }



        @Override
        public ebd.rbc_tms.Message handleRegister(ebd.rbc_tms.Message<Payload> msgFromRbc) {
            String rbc_id = msgFromRbc.getHeader().rbc_id;
            return createDummyNoErrorMsg(rbc_id,msgFromRbc.getHeader().uuid);
        }

        @Override
        public ebd.rbc_tms.Message handleLogin(ebd.rbc_tms.Message<Payload> msgFromRbc) {
            String rbc_id = msgFromRbc.getHeader().rbc_id;
            return createDummyNoErrorMsg(rbc_id,msgFromRbc.getHeader().uuid);
        }



        @Override
        public void handleNoError(ebd.rbc_tms.Message<Payload> msgFromRbc) {
            return;
        }

        @Override
        public ebd.rbc_tms.Message handlePositionReport(ebd.rbc_tms.Message<Payload> msgFromRbc) {
            String rbc_id = msgFromRbc.getHeader().rbc_id;
            return createDummyNoErrorMsg(rbc_id,msgFromRbc.getHeader().uuid);
        }
    }
}
