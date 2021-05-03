package de.ibw.handler;

import de.ibw.history.TrackAndOccupationManager;
import de.ibw.history.data.ComposedRoute;
import de.ibw.main.MotisManager;
import de.ibw.main.SmartLogicClient;
import de.ibw.modules.MaModul;
import de.ibw.schedule.TmsScheduler;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl;
import de.ibw.smart.logic.intf.messages.DbdRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.ITypable;
import de.ibw.smart.logic.intf.messages.MaRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.tms.entities.TmsJpaApp;
import de.ibw.tms.intf.SmartClientHandler;
import de.ibw.tms.intf.TmsMovementPermissionRequest;
import de.ibw.tms.intf.messenger.IMovementMessengerIntf;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.net.elements.INetElement;
import de.ibw.tms.ma.occupation.MAOccupation;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import de.ibw.tms.ui.PositionReportController;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.payload.Payload_14;
import ebd.rbc_tms.util.MA;
import ebd.rbc_tms.util.exception.MissingInformationException;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
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

    private void handleMaResponse(MaRequestReturnPayload msgFromSL) throws InvalidParameterException {
        UUID maID = msgFromSL.getUuid();


        TmsJpaApp.TmsMessenger.log(msgFromSL);

        //MaModul.getInstance().storeMaReturnPayload(msgFromSL);
        TmsMovementPermissionRequest moveRequest = TrackAndOccupationManager.RequestManager.getModel(maID);
        MARequestOccupation mao = moveRequest.getMaRequestOccupation();
        if(msgFromSL.isMaSuccessfull()) {
            int iTrainId = 0;
            logger.info("Ma successfull. UUID: " + maID.toString() + "\n");

            MovableObject mo = mao.getTargetMoveableObject();
            iTrainId = mo.getNid_Engine().getId();
            MA rbcMa = moveRequest.payload.MaAdapter.convertToRbcMA();
            Route R = moveRequest.payload.route;
            ComposedRoute CR = new ComposedRoute();
            try {
                CR.generateFromRoute(R, iTrainId);
            } catch (SmartLogicException e) {
                e.printStackTrace();
                System.err.println("Route cannot be transferred into connected Route-Element-List");
            }
            TrackAndOccupationManager.transferMaRequestBlockListIntoRealBlockList(iTrainId, mao, rbcMa, R, CR);


        } else {
            if(msgFromSL.getFailureCodes().contains(SmartServer4TmsImpl.ELEMENT_RESERVATION_ERROR))
                logger.error("MA not successful. UUID: " + maID.toString() + " There were reserved elements accessed.\n");
            if(msgFromSL.getFailureCodes().contains(SmartServer4TmsImpl.NO_ACK))
                logger.error("MA not successful. UUID: " + maID.toString() + " Ma has not been Acknowledged.\n");
            TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.RemoveOperation,
                    MARequestOccupation.class, mao);

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
        new Thread() {
            @Override
            public void run() {
                String received = smartServerMessage.toString();
                System.out.println("TMS received: " + received);
                if(!smartServerMessage.isbIsFromSL()) {
                    // is from RBC
                    Message<Payload> Msg = null;
                    try {
                        Msg = Message.generateFrom(smartServerMessage.getMsg());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    if (Msg.getHeader().type == 14) {
                        PositionReportController.getInstance().servePositionReport((Payload_14) Msg.getPayload(), Msg.getHeader());
                        if(!TmsScheduler.started) {
                            try {
                                MotisManager.sendMotisFiles();
                            } catch (IOException | URISyntaxException e) {
                                System.err.println("Motis files cannot be send: " + e.getMessage());
                                e.printStackTrace();
                            }
                            try {
                                ClientHandler.this.Client.startScheduler();
                            } catch (MissingInformationException e) {
                                System.err.println("Request Scheduler to smart Logic cannot be started: "
                                + e.getMessage());
                                e.printStackTrace();
                            }
                        }

                    }
                } else {
                    ITypable MsgFromSL = null;
                    try {
                        MsgFromSL = SmartServerMessage.generateFromSlJson(smartServerMessage.getMsg());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (MsgFromSL != null) {
                        if(MsgFromSL.getType().equals(MaRequestReturnPayload.RETURN_TYPE)) {

                            handleMaResponse((MaRequestReturnPayload)MsgFromSL);

                        } else if(MsgFromSL.getType().equals(DbdRequestReturnPayload.RETURN_TYPE)) {
                            handleDbdResponse((DbdRequestReturnPayload) MsgFromSL);
                        }
                    }
                }
            }
        }.start();


    }


}
