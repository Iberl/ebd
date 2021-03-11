package de.ibw.handler;

import de.ibw.main.MotisManager;
import de.ibw.main.SmartLogicClient;
import de.ibw.schedule.TmsScheduler;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.tms.intf.SmartClientHandler;
import de.ibw.tms.ui.PositionReportController;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.util.exception.MissingInformationException;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Client Handler
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-12-03
 */
public class ClientHandler extends SmartClientHandler {

    SmartLogicClient Client = null;


    public ClientHandler(SmartLogicClient smartLogicClient) {
        Client = smartLogicClient;
    }

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
        if(!smartServerMessage.isbIsFromSL()) {
            // is from RBC
            Message Msg = Message.generateFrom(smartServerMessage.getMsg());
            if (Msg.getHeader().type == 14) {
                if(!TmsScheduler.started) {
                    MotisManager.sendMotisFiles();
                    this.Client.startScheduler();
                }
                PositionReportController.getInstance().servePositionReport((Payload_14) Msg.getPayload(), Msg.getHeader().rbc_id);
            }
        }

    }

    public void sendCommand(String sJson) throws MissingInformationException {
        try {
            this.tmsCommandQueue.put(sJson);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
}
