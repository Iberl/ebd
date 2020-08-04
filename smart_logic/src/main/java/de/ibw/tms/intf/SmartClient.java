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

public class SmartClient extends RbcModul {

    public SmartClient(String sHost, int iPort) {
        super(true, sHost, iPort);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        try {
            startSmartLogicClient();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startSmartLogicClient() throws InterruptedException {
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


                    socketChannel.pipeline().addLast("handler", SmartClientHandler.getInstance());
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
