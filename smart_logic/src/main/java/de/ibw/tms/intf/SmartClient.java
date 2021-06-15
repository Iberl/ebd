package de.ibw.tms.intf;

import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.intf.RbcModul;
import de.ibw.smart.logic.intf.SmartLogic;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.ConnectException;

/**
 * Client des TMS zum Server in der SmartLogic
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1
 * @since 2020-08-10
 */
public class SmartClient extends RbcModul {

    private static String MODULE_NAME = "smartClient";

    protected volatile boolean isConnectedTOsmartLogic = false;

    private EventBusManager EBM = EventBusManager.RootEventBusManger;

    /**
     * Dieser Konstruktor erstellt den Client.
     * @param sHost - Host-ip der SmartLogic.
     * @param iPort - Port des SmartLogic-Host
     */
    public SmartClient(String sHost, int iPort) {
        super(true, sHost, iPort);
    }

    public boolean isConnectedTOsmartLogic() {
        return isConnectedTOsmartLogic;
    }

    public void setConnectedTOsmartLogic(boolean connectedTOsmartLogic) {
        isConnectedTOsmartLogic = connectedTOsmartLogic;
    }

    /**
     * Client Startet Verbindung zur SmartLogic
     */

    @Override
    public void start() {
        super.start();
    }

    /**
     * konkretes Verhalten beim Start des Clients
     */

    @Override
    public void run() {
        // overriden in child class SmartLogicClient

            try {
                startSmartLogicClient(SmartClientHandler.getInstance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }

    protected void startSmartLogicClient(SmartClientHandler ClientHandler) throws InterruptedException {
        if(sHost == null) sHost = "localhost";

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap clientBootstrap = new Bootstrap();
            // two hours timeout
            clientBootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 6400000);
            clientBootstrap.option(ChannelOption.SO_KEEPALIVE, true);

            clientBootstrap.group(group);
            clientBootstrap.channel(NioSocketChannel.class);
            //clientBootstrap.remoteAddress(new InetSocketAddress(sHost, iPort));

            clientBootstrap.handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //socketChannel.pipeline().addLast("idleStateHandler", new IdleStateHandler(0, 0, 0));
                    socketChannel.pipeline().addLast(new ObjectEncoder());
                    socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(
                            getClass().getClassLoader())));


                    socketChannel.pipeline().addLast("handler", ClientHandler);

                }
            });

            ChannelFuture channelFuture = clientBootstrap.connect(sHost, iPort).sync();
            if (channelFuture.isSuccess()) {
                this.isConnectedTOsmartLogic = true;
                if(EBM != null) EBM.log("TMS connected to SL", SmartLogic.getsModuleId(MODULE_NAME));
                //System.out.println("TMS connected to SL");
            }

            channelFuture.channel().closeFuture().sync();
        } catch(InterruptedException e) {
            if (EBM != null) EBM.log("TMS-Connection to SL failed", SmartLogic.getsModuleId(MODULE_NAME));
            this.isConnectedTOsmartLogic = false;
        } catch(Exception e) {
            if (EBM != null) EBM.log("TMS-Connection to SL failed", SmartLogic.getsModuleId(MODULE_NAME));
            this.isConnectedTOsmartLogic = false;


        } finally {
            group.shutdownGracefully().sync();
        }
    }

}
