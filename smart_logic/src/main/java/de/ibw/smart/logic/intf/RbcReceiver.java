package de.ibw.smart.logic.intf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * fake RBC
 */
public class RbcReceiver extends Thread {

    private String sHost = "localhost";
    private int iPort = 22223;


    public class RbcReceiverHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf inBuffer = (ByteBuf) msg;

            String received = inBuffer.toString(CharsetUtil.UTF_8);
            System.out.println("RBC Receiver received: " + received);

            //ctx.write(Unpooled.copiedBuffer("Hello " + received, CharsetUtil.UTF_8));
            inBuffer.release();

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

    public void startRbcServer(String sHost, int iPort) throws InterruptedException {
        if (sHost == null) sHost = "localhost";

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.localAddress(new InetSocketAddress(sHost, iPort));

            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new RbcReceiverHandler());
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public RbcReceiver(String sHost, int i) {
        if(sHost != null) {
            this.sHost = sHost;
        }
        this.iPort = i;

    }

    @Override
    public void run() {
        try {
            this.startRbcServer(this.sHost, this.iPort);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
