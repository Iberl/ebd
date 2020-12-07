package de.ibw.tms.intf;

import de.ibw.smart.logic.intf.RbcModul;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Client des TMS zum Server in der SmartLogic
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class SmartClient extends RbcModul {

    /**
     * Dieser Konstruktor erstellt den Client.
     * @param sHost - Host-ip der SmartLogic.
     * @param iPort - Port des SmartLogic-Host
     */
    public SmartClient(String sHost, int iPort) {
        super(true, sHost, iPort);
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

            clientBootstrap.group(group);
            clientBootstrap.channel(NioSocketChannel.class);
            //clientBootstrap.remoteAddress(new InetSocketAddress(sHost, iPort));

            clientBootstrap.handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ObjectEncoder());
                    socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(
                            getClass().getClassLoader())));


                    socketChannel.pipeline().addLast("handler", ClientHandler);
                }
            });

            ChannelFuture channelFuture = clientBootstrap.connect(sHost, iPort).sync();
            if (channelFuture.isSuccess()) System.out.println("TMS connected to SL");

            channelFuture.channel().closeFuture().sync();
        } catch(InterruptedException e) {
            System.out.println("TMS-Connection to SL failed");

        } finally {
            group.shutdownGracefully().sync();
        }
    }

}
