package de.ibw.handler;

import de.ibw.main.MotisManager;
import de.ibw.main.SmartLogicClient;
import de.ibw.modules.MaModul;
import de.ibw.schedule.TmsScheduler;
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl;
import de.ibw.smart.logic.intf.messages.DbdRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.ITypable;
import de.ibw.smart.logic.intf.messages.MaRequestReturnPayload;
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

import java.security.InvalidParameterException;
import java.util.UUID;

/**
 * Client Handler
 * sendet Nachricht über Vaterklasse SmartClientHandler
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 2021-04-13
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

    private void handleMaResponse(MaRequestReturnPayload msgFromSL) {
        UUID maID = msgFromSL.getUuid();

        //MaModul.getInstance().storeMaReturnPayload(msgFromSL);

        if(msgFromSL.isMaSuccessfull()) {
            logger.info("Ma successfull. UUID: " + maID.toString() + "\n");



        } else {
            if(msgFromSL.getFailureCodes().contains(SmartServer4TmsImpl.ELEMENT_RESERVATION_ERROR))
                logger.error("MA not successful. UUID: " + maID.toString() + " There were reserved elements accessed.\n");
            if(msgFromSL.getFailureCodes().contains(SmartServer4TmsImpl.NO_ACK))
                logger.error("MA not successful. UUID: " + maID.toString() + " Ma has not been Acknowledged.\n");

        }

    }

    private void handleDbdResponse(DbdRequestReturnPayload msgFromSL) {
        try {
            if (msgFromSL.isDbdCommandSuccessfull()) {
                logger.info("Dbd Command successfull on Item: " + msgFromSL.getsDbdCommandTargetName() + "\n");
            } else logger.info("Dbd Command failed on Item: " + msgFromSL.getsDbdCommandTargetName() + "\n" +
                    "DBD Command failed for Reason: " + msgFromSL.getsFailreason() + "\n");
        } catch(InvalidParameterException IPE) {
            IPE.printStackTrace();
        }
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
                PositionReportController.getInstance().servePositionReport((Payload_14) Msg.getPayload(), Msg.getHeader());
            }
        } else {
            ITypable MsgFromSL = SmartServerMessage.generateFromSlJson(smartServerMessage.getMsg());
            if(MsgFromSL.getType().equals(MaRequestReturnPayload.RETURN_TYPE)) {
                handleMaResponse((MaRequestReturnPayload)MsgFromSL);

            } else if(MsgFromSL.getType().equals(DbdRequestReturnPayload.RETURN_TYPE)) {
                handleDbdResponse((DbdRequestReturnPayload) MsgFromSL);
            }
        }

    }


}
