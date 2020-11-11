package de.ibw.hanlder;

import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.tms.intf.SmartClientHandler;
import de.ibw.tms.intf.TmsMessage;
import ebd.rbc_tms.util.exception.MissingInformationException;
import io.netty.channel.ChannelHandlerContext;
/**
 * Client Handler
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-11
 */
public class ClientHandler extends SmartClientHandler {



    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelActive(channelHandlerContext);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause) {
        super.exceptionCaught(channelHandlerContext, cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, SmartServerMessage smartServerMessage) throws Exception {
        String received = smartServerMessage.toString();
        System.out.println("TMS received: " + received);
    }

    public void sendCommand(String sJson) throws MissingInformationException {
        try {
            this.tmsCommandQueue.put(sJson);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
