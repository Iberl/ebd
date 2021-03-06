package de.ibw.smart.logic.intf;

import com.google.gson.stream.MalformedJsonException;
import de.ibw.smart.logic.EventBusManager;
import ebd.SlConfigHandler;
import ebd.messageLibrary.util.exception.*;
import ebd.rbc_tms.message.Message;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.internal.Payload;
import ebd.internal.message.Message_00;
import ebd.internal.message.Message_21;
import ebd.internal.payload.Payload_00;
import ebd.internal.payload.Payload_21;
import ebd.internal.util.EOA;
import ebd.internal.util.MA;
import ebd.internal.util.TrainInfo;
import ebd.internal.util.exception.MissingInformationException;
import ebd.rbc_tms.message.general.Response;
import ebd.rbc_tms.util.exception.InvalidHashException;
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
import io.netty.handler.stream.ChunkedStream;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Logger;

import ebd.rbc_tms.Serializer;

import static io.netty.handler.codec.AsciiHeadersEncoder.NewlineType.CRLF;

/**
 * Ein RBC Modul sendet mithilfe des Netty-Framweorks an das RBC. Kann Nachrichten aus dem RBC erhalten. Wird deshalb zweimal instanziiert.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-08-26
 */
public class RbcModul extends Thread {

    /**
     * Die Smart Logic hat ein Modul das mit dieser Konstante Nachrichten logt, die an das RBC gehen
     */
    public static final String RBC_MODUL = "RBC-MODUL";
    /**
     * Die Smart Logic hat ein Modul, dass Nachrichten aus dem RBC bekommt. Dieses Modul ist der TMS Proxy.
     * Das ist die Modulbezeichnung im Log.
     */
    public static final String TMS_PROXY = "TMS-PROXY";
    private ebd.rbc_tms.message.Message Message = null;
    private PriorityBlockingQueue<PriorityMessage> outputQueue = new PriorityBlockingQueue<>();
    /**
     * Kommunikationstunnel in Netty
     */
    private ChannelFuture channelFuture;

    /**
     * Channelverwaltung in Netty
     */
    private EventLoopGroup group;

    public ChannelFuture getChannelFuture() {
        return channelFuture;
    }

    public EventLoopGroup getGroup() {
        return group;
    }

    /**
     * Gibt an wer f&uuml;r dieses Modul als TMS handelt
     * Bisher hat die SmartLogic einen Proxy, der so tut als sei er selbst das TMS
     * und alle Nachrichten zwischenliest
     * @param tmsHandler - Parameter der anzeigt woran das RBC
     *                   an welche Komonente, es Daten weiterleitet
     */
    public void setTmsHandler(TmsIntf tmsHandler) {
        TmsHandler = tmsHandler;
    }

    private volatile TmsIntf TmsHandler;
    private SimpleChannelInboundHandler CustomHandlerTcpClient = null;

    private int iSmartLogicID = 1;

    /**
     * generiert eine Antwort, auf vorher erhaltene Nachrichten.
     * @param iErrorCode - gibt an ob mit der vorherigen Nachricht ein Fehler verbunde ist
     * @param rbc_id - ID RBC
     * @param uuid - ID der Kommunikation
     * @param tms_id - ID des TMS
     * @param TI - Informationen zum Zug
     * @return Message_00 - eine Antwortnachricht
     */
    public static Response createResponseMessage(int iErrorCode, String rbc_id, UUID uuid, String tms_id, TrainInfo TI) {
            if(iErrorCode == 0) {
                return new Response(uuid,1,1);
            }
            Response R = new Response(uuid, 1, 1, iErrorCode, "Unknown error");


            return R;
    }

    /**
     * Gibt an ob das Instanziirte Modul horcht oder sendet
     */
    public Boolean isClient = false;
    /**
     * Name des Zielservers
     */
    public String sHost = "localhost";
    /**
     * Port als Integer
     */
    public int iPort = 22223;

    /**
     * Kann als Server oder als Client des RBCs instanziiert werden
     * @param bIsClient - boolean der definiert ob als Client instanziier.
     * @param sHost - String des Hostnamens
     * @param iPort - Port der Kommunikation
     */
    public RbcModul(boolean bIsClient, String sHost, int iPort) {
        if(sHost == null) sHost = "localhost";
        this.isClient = bIsClient;
        this.sHost = sHost;
        this.iPort = iPort;
    }

    /**
     * Senden einzelner Nachricht nur fr Testzwecke
     * @param M - Nachricht zu senden
     * @param sHost - host bezeichnung gibt es in netty auch als Angabe im ServerModus, was nur in netty geht
     * @param iPort - port auf dem gehorcht oder gesendet wird
     */
    public RbcModul(Message M, String sHost, int iPort) {
        if(sHost == null) sHost = "localhost";
        this.isClient = true;
        this.sHost = sHost;
        this.iPort = iPort;
        this.Message = M;

    }

    /**
     * Sendet Nachricht an das RBC
     * @param priorityMessage - Priority-Message, weil in Warteschlange Priority geachtet wird
     */
    public void sendMessage(PriorityMessage priorityMessage) {
        this.outputQueue.offer(priorityMessage);
    }

    /**
     * Startet dieses RBC Modul
     */
    public void start() {
        super.start();
    }


    /**
     * Es gibt zwei Instancen des RBC-Moduls.
     * Der SERVER
     * startet TMS Server innerhalb der SL f&uuml;r das RBC.
     * Dadurch stellt die SL einen Server f&uuml;r das RBC bereit.
     *
     * Der CLIENT
     * Wenn als Client gestartet dann sendet das RBC solange es lauuml;ft Nachrichten aus der Queue an das RBC.
     */
    public void run() {

        if(isClient) {
            try {


                if(this.Message != null) {
                   // no sense overjump as guard
                }
                if(this.CustomHandlerTcpClient == null) {
                    // use case sl rbc
                    EventBusManager EM = null;
                    try {
                        EM = EventBusManager.registerOrGetBus(iSmartLogicID,false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    boolean isReady = !SmartLogic.IS_STARTED_AS_SL || !SmartLogic.isInShutdown;
                    while(isReady) {

                        PriorityMessage PM = this.outputQueue.take();





                        SL_To_RBC_ClientThread SlThread = new SL_To_RBC_ClientThread(PM.getMsg(), this);

                        SlThread.start();
                        if(EM != null) {
                            try {
                                EM.log("Send Message to RBC: " + Serializer.serialize(PM.getMsg()), RBC_MODUL);
                            } catch (NotSerializableException | FieldTypeNotSupportedException | ebd.messageLibrary.util.exception.MissingInformationException e) {
                                e.printStackTrace();
                            }
                        }
                        isReady = !SmartLogic.IS_STARTED_AS_SL || !SmartLogic.isInShutdown;
                    }
                } else {
                    //unused
                    startTcpClient(this.sHost, this.iPort, this.CustomHandlerTcpClient, null, this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                startTmsServer(this.sHost);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Diese Klasse stellt einen Thread dar, der eine Nachricht an das RBC sendet
     */
    public static class SL_To_RBC_ClientThread extends Thread {
        private final String sHost;
        private final int iPort;
        private final Message M;
        private final RbcModul ExecutingModul;
        
        /**
         * Instanziierrt einen Thread mit einer Nachricht an das RBC
         * @param M - Nachricht zu verschicken
         * @param ExecutingModul - Ausf&uuml;hrendes Modul
         */
        public SL_To_RBC_ClientThread(Message M, RbcModul ExecutingModul) {
            this.sHost = SlConfigHandler.getInstance().ipOfRBCServer;
            this.iPort = Integer.parseInt(SlConfigHandler.getInstance().portOfRBCServer);
            this.M = M;
            this.ExecutingModul = ExecutingModul;

        }

        /**
         * Sendet Nachricht an das RBC
         */

        @Override
        public void run() {
            //startTcpClient(this.sHost, this.iPort, null,M, ExecutingModul);
            TmsServerHandler.getInstance().sendMessageToRbc(M);

        }
    }


    /**
     * Client in Netty der SL an das RBC.
     * Kann nur Senden
     */
    public static class TcpClientHandler extends SimpleChannelInboundHandler {

        private final int iSmartLogicId = 1;
        private Message M = null;
        private EventBusManager EM = null;

        /**
         * Netty Client handler zum Schicken von Nachrichten ans RBC
         * @param Msg - Nachricht die geschickt wird
         */
        public TcpClientHandler(Message Msg) {
            this.M = Msg;
            try {
                EM = EventBusManager.registerOrGetBus(iSmartLogicId, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Kanal in Netty durch den das RBC die Nachricht bekommt
         * @param channelHandlerContext
         * @throws MissingInformationException
         */

        @Override
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws MissingInformationException {
            if(M != null) {

                if(EM != null) EM.log("Successfully connected to RBC", SmartLogic.getsModuleId(RBC_MODUL));

                String sSend = null;
                try {
                    sSend = Serializer.serialize(M);
                    channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(sSend, CharsetUtil.UTF_8));
                    EM.log("SL has send message to RBC", SmartLogic.getsModuleId(RBC_MODUL));
                } catch (NotSerializableException | FieldTypeNotSupportedException | ebd.messageLibrary.util.exception.MissingInformationException e) {
                    e.printStackTrace();
                    if(EM != null) EM.log("SL cannot parse Message to RBC", SmartLogic.getsModuleId(RBC_MODUL));
                }


            } else {
                if(EM != null) EM.log("SL trys sending Message to RBC not working",
                        SmartLogic.getsModuleId(RBC_MODUL));

            }
        }


        /**
         * Handler wenn Fehler in Kommunikation zum RBC
         * @param channelHandlerContext
         * @param cause - Grund des Fehlers
         */

        @Override
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause){
            cause.printStackTrace();
            channelHandlerContext.close();
        }

        /**
         * Eigentlich unbenutzt, weil zum Empfang, eine andere Client Server Kommunikation verwendet wird.
         * @param channelHandlerContext
         * @param sJsonMsg
         * @throws Exception
         */

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object sJsonMsg) throws Exception {
            ByteBuf inBuffer = (ByteBuf) sJsonMsg;

            String received = inBuffer.toString(CharsetUtil.UTF_8);
            if(EM != null) EM.log("Client received: " + received , RBC_MODUL);
            inBuffer.release();
        }
    }

    /**
     * Netty Handler eines Servers der SL zur Kommunikation mit RBC
     * Nur Empfang
     */
    public class TmsServerHandler extends ChannelInboundHandlerAdapter {

        private static final Logger logger = Logger.getLogger(
                TmsServerHandler.class.getName());

        /**
         * Name in Log, wenn die SL als TMS gegen&uuml;ber des RBC auftritt
         */
        public static final String TMS_HANDLER = "TMS-HANDLER";
        public static TmsServerHandler instance = null;

        public static TmsServerHandler getInstance() { return instance; }

        private final int iSmartLogicId = 1;
        private EventBusManager EBM;
        private ChannelHandlerContext context;
        private SynchronousQueue<String> rbcOutputQueue = new SynchronousQueue<String>();
        private Channel C;

        public void setChannel(Channel Ch) {
            this.C = Ch;
        }


        public void sendMessageToRbc(Message M) {
            StringBuilder sMessage = new StringBuilder();
            try {
                sMessage.append(Serializer.serialize(M));
                sMessage.append(System.lineSeparator());
            } catch (NotSerializableException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(sMessage.toString());
                rbcOutputQueue.put(sMessage.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {

            new Thread() {
                @Override
                public void run() {
                    try {
                        EventBusManager EBM = null;


                        if (EBM == null) {
                            try {
                                EBM = EventBusManager.registerOrGetBus(1, false);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (EBM != null) EBM.log("Channel to RBC acitve", "RBC-OUTPUT-MODUL");
                        while ( true ) {
                            String rbcMessage = rbcOutputQueue.take();


                            System.out.println("SL sends to RBC message");
                            if (EBM != null) EBM.log("SL sends to RBC message", "RBC-OUTPUT-MODUL");

                            ctx.writeAndFlush(Unpooled.wrappedBuffer(rbcMessage.getBytes(StandardCharsets.UTF_8)));
                        }
                        } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        /**
         * Instanziieren eines TMS Empf&auml;ngers in der SL gegen&uuml;ber des RBCs
         */
        public TmsServerHandler() {
            super();
            instance = this;
            try {
                EBM = EventBusManager.registerOrGetBus(iSmartLogicID, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        /**
         * Definiert was passiert wenn Netty eine Nachricht vom RBC bekommt
         * @param ctx - Netty
         * @param msg - Die Nachricht aus dem Socket
         * @throws Exception - IO Error
         */

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
                        if(TmsServerHandler.this.context == null) {
                            TmsServerHandler.this.context  = ctx;
                        }

                        for(String singleJsonMsg : received.split(System.lineSeparator())) {
                            serverHandleJson(ctx, singleJsonMsg);
                        }
                        inBuffer.release();
                    } catch (ClassNotFoundException | MissingInformationException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        /**
         * Channel wird wieder geschlossen
         * @param ctx
         * @throws Exception
         */

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        }

        /**
         * Fehler Handler wenn der Netty Server gegen&uuml;ber dem RBC Fehler registriert
         * @param ctx - Netty IO
         * @param cause - Grund des Fehlers
         * @throws Exception - Error throwing
         */

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }

    private synchronized void serverHandleJson(ChannelHandlerContext writeCtx, String received) throws ClassNotFoundException, MissingInformationException {
        //Message<Payload> msgFromRbc = Message.generateFrom(received);
        ebd.rbc_tms.message.Message msgFromRbc = null;

        try {
            msgFromRbc = Serializer.deserialize(received);
        } catch (Exception e) {
            e.printStackTrace();
            Response responseError = new Response(1, 1, 2, "Message not deserialzable");
            SmartLogic.getRbcClient().sendMessage(new PriorityMessage(responseError, 3L));
            return;
        }

        if (msgFromRbc == null) return;
        int iType = msgFromRbc.type;
        ebd.rbc_tms.message.Message finalMsgFromRbc = msgFromRbc;
        new Thread() {
            @Override
            public void run() {
                switch (iType) {
                    case (0): {
                        Response RbyRBC = (Response) finalMsgFromRbc;
                        if(RbyRBC.errorCode == 0) {
                            TmsHandler.handleNoError(finalMsgFromRbc);
                        } else {
                            System.err.println("RBC send Error Message: " + RbyRBC.errorMessage);
                        }
                        break;
                    }
                    case (10): {
                        Message WriteBack = TmsHandler.handleRegister(finalMsgFromRbc);
                        SmartLogic.getRbcClient().sendMessage(new PriorityMessage(WriteBack, 3L));
                        //writeCtx.write(Unpooled.copiedBuffer(WriteBack.parseToJson(), CharsetUtil.UTF_8));
                        break;
                    }

                    case (12): {
                        Message WriteBack = TmsHandler.handleLogin(finalMsgFromRbc);
                        SmartLogic.getRbcClient().sendMessage(new PriorityMessage(WriteBack, 3L));
                        break;
                    }
                    case (30): {
                        Message WriteBack = TmsHandler.handlePositionReport(finalMsgFromRbc);
                        SmartLogic.getRbcClient().sendMessage(new PriorityMessage(WriteBack, 3L));
                        break;
                    }

                    default: {
                        Response ResOkay = new Response(finalMsgFromRbc.uuid, 1, finalMsgFromRbc.rbc_id);
                        SmartLogic.getRbcClient().sendMessage(new PriorityMessage(ResOkay, 3L));
                    }

                    /*case (15): {

                        Message WriteBack = TmsHandler.handleMaRequest(finalMsgFromRbc);
                        SmartLogic.getRbcClient().sendMessage(new PriorityMessage(WriteBack, 3L));

                        break;
                    }*/
                }
            }
        }.start();
    }

    /**
     * @deprecated
     * @param writeCtx
     * @param msgFromRbc
     * @throws MissingInformationException
     */
    private void handleMaRequest(ChannelHandlerContext writeCtx, Message msgFromRbc) throws MissingInformationException {
        //TODO save messages 4 rasking by UUID
        /*String rbc_id = msgFromRbc.getHeader().rbc_id;
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

         */
    }

    public void shutdown() {
        try {
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e ) {
            e.printStackTrace();
        }
        try {
            group.shutdownGracefully().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Netty TCP Client Builder Method
     * @param sHost - String of Host beeing called
     * @param iPort - int iPort
     * @param customHandlerTcpClient - std null
     * @param Msg - to be send
     * @param executingModul
     * @throws InterruptedException - netty communication error
     */
    public static void startTcpClient(String sHost, int iPort, SimpleChannelInboundHandler customHandlerTcpClient, Message Msg, RbcModul executingModul) throws InterruptedException {
        EventBusManager EM = null;
        try {
            EM = EventBusManager.registerOrGetBus(1, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sHost == null) sHost = "localhost";
        if(customHandlerTcpClient == null) customHandlerTcpClient = new TcpClientHandler(Msg);
        executingModul.group = new NioEventLoopGroup();
        try{
            Bootstrap clientBootstrap = new Bootstrap();

            clientBootstrap.group(executingModul.group);
            clientBootstrap.channel(NioSocketChannel.class);
            clientBootstrap.remoteAddress(new InetSocketAddress(sHost, iPort));
            SimpleChannelInboundHandler finalCustomHandlerTcpClient = customHandlerTcpClient;
            EventBusManager finalEM = EM;
            clientBootstrap.handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(finalCustomHandlerTcpClient);
                    if(finalEM != null) finalEM.log("Try to connect to RBC", SmartLogic.getsModuleId(RBC_MODUL));


                }
            });
            executingModul.channelFuture = clientBootstrap.connect().sync();
            executingModul.channelFuture.channel().closeFuture().sync();
        } finally {
            executingModul.group.shutdownGracefully().sync();
        }
    }


    /**
     * SL Server serving TMS
     * @param sHost - localhost nicht relevant bei server, aber netty hat diese option
     * @param iPort - port dieses servers
     * @param ServerHandler - definiert was netty als server tun soll
     * @throws InterruptedException - communication exception
     */
    public void startServer(String sHost, int iPort, ChannelInboundHandlerAdapter ServerHandler) throws InterruptedException {
        if(sHost == null) sHost = "localhost";
        EventBusManager EM = null;
        try {
            EM = EventBusManager.registerOrGetBus(1, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        group = new NioEventLoopGroup();


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
            channelFuture = serverBootstrap.bind(iPort).sync();
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



    /**
     * SL stellt Verbindung f&uuml;r das RBC als Server bereit
     * @param sHost - netty hat eine host definition auf server std localhost
     * @throws InterruptedException - Kommunikation hatte einen Fehler verursacht
     */
    public void startTmsServer(String sHost) throws InterruptedException {
        sHost = "0.0.0.0";
        this.iPort = Integer.parseInt(SlConfigHandler.getInstance().portOfTMSServer);
        EventBusManager EM = null;
        try {
            EM = EventBusManager.registerOrGetBus(1, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        group = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.localAddress(new InetSocketAddress(sHost, iPort ));

            EventBusManager finalEM = EM;
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ObjectEncoder());

                    socketChannel.pipeline().addLast(new TmsServerHandler());
                    TmsServerHandler.getInstance().setChannel(socketChannel);
                    if(finalEM != null) finalEM.log("TMS PROXY on Smart Logic Listening", TMS_PROXY);
                }
            }).childOption(ChannelOption.SO_KEEPALIVE, true);

            channelFuture = serverBootstrap.bind(iPort).sync();
            if(channelFuture.isSuccess()) {
                if(EM != null) EM.log("Tcp Server (for RBC) started successfully","SMART-RBC-SERVER");


            } else {
                if(EM != null) EM.log("Tcp Server (for RBC) starting failed","SMART-RBC-SERVER");
            }
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
            if(EM != null) EM.log("RBC Tcp Server on Smart Logic ShutDown", TMS_PROXY);
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

    /*
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
    */

}
