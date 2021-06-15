package de.ibw.tms.intf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ReconnectionTask implements Runnable, ChannelFutureListener {

    private final int iRetryTimeInSeconds;
    Channel previous;

        public ReconnectionTask(Channel c, int iRetrySeconds) {
            this.previous = c;
            this.iRetryTimeInSeconds = iRetrySeconds;
        }

        @Override
        public void run() {
            Bootstrap b = new Bootstrap();
            b.remoteAddress(previous.remoteAddress())
                    .connect()
                    .addListener(this);
        }

        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            if (!future.isSuccess()) {
                int iRetryTime = iRetryTimeInSeconds;

                // Will try to connect again in 100 ms.
                // Here you should probably use exponential backoff or some sort of randomization to define the retry period.
                previous.eventLoop()
                        .schedule(this, iRetryTime, SECONDS);
                return;
            }
            // Do something else when success if needed.
        }

}
