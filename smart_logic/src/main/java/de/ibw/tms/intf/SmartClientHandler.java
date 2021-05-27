package de.ibw.tms.intf;

import de.ibw.history.PositionData;
import de.ibw.history.PositionModul;
import de.ibw.history.TrackAndOccupationManager;
import de.ibw.history.data.ComposedRoute;
import de.ibw.history.data.PositionEnterType;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl;
import de.ibw.smart.logic.intf.impl.threads.TmsOuputWorker;
import de.ibw.smart.logic.intf.messages.DbdRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.ITypable;
import de.ibw.smart.logic.intf.messages.MaRequestReturnPayload;
import de.ibw.smart.logic.intf.messages.SmartServerMessage;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.intf.cmd.Commands;
import de.ibw.tms.ma.MovementAuthority;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.mob.common.NID_ENGINE;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import ebd.internal.Message;
import ebd.internal.payload.Payload_14;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainInfo;
import ebd.internal.util.exception.MissingInformationException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import org.apache.log4j.Logger;

import java.security.InvalidParameterException;
import java.util.UUID;
import java.util.concurrent.SynchronousQueue;

/**
 * Client-Handler im TMS. Er behandelt Interaktionen des TMS mit der SL und umgekehrt.
 * Beides wird in dieser Klasse nur f&uuml;r die TMS Seite definiert.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class SmartClientHandler extends SimpleChannelInboundHandler<SmartServerMessage> {


    private static SmartClientHandler instance = null;
    protected static Logger logger = Logger.getLogger( SmartClientHandler.class );

    /**
     * Singelton um den ClientHandler des TMS widerzugeben
     * @return SmartClientHandler - Handler der Interaktion im TMS
     */
    public static SmartClientHandler getInstance() {
        if(instance == null) instance = new SmartClientHandler();
        return instance;
    }



    protected SynchronousQueue<String> tmsCommandQueue;
    //private SendCommandThreadFromQueue sender;
    protected SmartClientHandler() {
        tmsCommandQueue = new SynchronousQueue<>();


        //sendDummyCommand();

    }
    /*private class SendCommandThreadFromQueue extends Thread {
        private PriorityBlockingQueue<TmsMessage> commandQueue;
        private ChannelHandlerContext channelHandlerContext;

        public SendCommandThreadFromQueue(PriorityBlockingQueue<TmsMessage> commandQueue, ChannelHandlerContext channelHandlerContext) {
            this.commandQueue = commandQueue;
            this.channelHandlerContext = channelHandlerContext;
            SendCommandThreadFromQueue CommandThread = new SendCommandThreadFromQueue(this.tmsCommandQueue, channelHandlerContext);

        }
        public void setCannelContext(ChannelHandlerContext context) {
            this.channelHandlerContext = context;
        }

        @Override
        public void run() {
            while (true) {
                TmsMessage Cmd = null;
                try {
                    Cmd = tmsCommandQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(Cmd.parseToJson());
                    channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(Cmd.parseToJson(), CharsetUtil.UTF_8));
                } catch (MissingInformationException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/


    /**
     * Definiert was das TMS unternimmt, solange eine Verbindung zur SL aktiv ist.
     * Bis jetzt wird konkret der Postausgang des TMS in den Channel gegeben.
     * @param channelHandlerContext - Netty-Context
     * @throws Exception - Fehler bei der Kommunikation zur SL
     */

    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelActive(channelHandlerContext);
        TmsOuputWorker.TmsToSmartWorker = new TmsOuputWorker<String>(tmsCommandQueue, channelHandlerContext);
        TmsOuputWorker.TmsToSmartWorker.start();




        System.out.println("tms to sl Channel active");




    }


    /**
     * Verhalten wenn Fehler zur SL Verbindung auftreten
     * @param channelHandlerContext - Netty-Context
     * @param cause - Fehler der auftrat
     */


    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause){
        cause.printStackTrace();
        channelHandlerContext.close();
    }

    /**
     *  Diese Methode wird bisher im smartLogicClient (TMS) komplett überschrieben
     *
     * Definiert, was das TMS unternimmt, wenn eine Nachricht der SL eintrifft.
     * Bisher wird hier unterschieden ob die SL eine Nachricht des RBC weitergegeben hat.
     * Oder eine Nachricht der SL eintrifft, weil eine MA akzeptiert oder verworfen wurde.
     * @param channelHandlerContext - Netty-Context
     * @param smartServerMessage {@link SmartServerMessage} - Nachricht von der SL
     * @throws Exception - Fehler in der Kommunikation zur SL
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, SmartServerMessage smartServerMessage) throws Exception {


        String received = smartServerMessage.toString();
        System.out.println("TMS received: " + received);
        try {



                new Thread() {
                    @Override
                    public void run() {

                        try {
                            if(!smartServerMessage.isbIsFromSL()) {
                                // is from RBC
                                Message Msg = Message.generateFrom(smartServerMessage.getMsg());
                                if(Msg.getHeader().type == 14) {
                                    handlePositionReport(Msg);

                                }
                            } else {
                                ITypable MsgFromSL = SmartServerMessage.generateFromSlJson(smartServerMessage.getMsg());
                                if(MsgFromSL.getType().equals(MaRequestReturnPayload.RETURN_TYPE)) {
                                    handleMaResponse((MaRequestReturnPayload)MsgFromSL);

                                } else if(MsgFromSL.getType().equals(DbdRequestReturnPayload.RETURN_TYPE)) {
                                    handleDbdResponse((DbdRequestReturnPayload) MsgFromSL);
                                }
                            }
                            ReferenceCountUtil.release(smartServerMessage);
                            //System.out.println("TMS received: " + received);

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                            ReferenceCountUtil.release(smartServerMessage);
                        }

                    }
                }.start();

            //channelHandlerContext.writeAndFlush("Acknowledged");

            //sendDummyCommand();
        } catch (Exception E) {
            E.printStackTrace();
        }


    }

    private void handleDbdResponse(DbdRequestReturnPayload msgFromSL) {
        if(msgFromSL.isDbdCommandSuccessfull()) {
            logger.info("Dbd Command successfull on Item: " + msgFromSL.getsDbdCommandTargetName() + "\n");
        } else logger.info("Dbd Command failed on Item: " + msgFromSL.getsDbdCommandTargetName() + "\n" +
                "DBD Command failed for Reason: " + msgFromSL.getsFailreason() + "\n");
    }

    private void handleMaResponse(MaRequestReturnPayload msgFromSL) {
        UUID maID = msgFromSL.getUuid();
        if(msgFromSL.isMaSuccessfull()) {
            logger.info("Ma successfull. UUID: " + maID.toString() + "\n");
        } else {
            if(msgFromSL.getFailureCodes().contains(SmartServer4TmsImpl.ELEMENT_RESERVATION_ERROR))
            logger.error("MA not successful. UUID: " + maID.toString() + " There were reserved elements accessed.\n");
            if(msgFromSL.getFailureCodes().contains(SmartServer4TmsImpl.NO_ACK))
                logger.error("MA not successful. UUID: " + maID.toString() + " Ma has not been Acknowledged.\n");

        }

    }

    private synchronized void handlePositionReport(Message msg) {
        try {
            Payload_14 PositonReport = (Payload_14) msg.getPayload();
            String sRbc = msg.getHeader().rbc_id;
            Message.Header header = msg.getHeader();
            TrainInfo TI = PositonReport.trainInfo;
            PositionInfo posInf = PositonReport.positionInfo;
            //PositionData PD = new PositionData(header.getTimestamp(), System.currentTimeMillis(),
            //        TI, posInf);
            //PositionModul.getInstance().addPositionData(PD, PositionEnterType.ENTERED_VIA_POSITION_REPORT);
            //PositionReportController.getInstance().servePositionReport(PositonReport, sRbc);
        } catch(Exception E) {
            E.printStackTrace();
        }


    }



    /**
     * Diese Methode gibt die TMS-Nachricht in den Postausgang an die SL.
     * @param TmsCmd {@link TmsMessage} - Nachricht die an die SL gesendet werden soll
     * @throws MissingInformationException - Fehler
     */
    public void sendCommand(TmsMessage TmsCmd) throws MissingInformationException {
        try {
            guardCommandSender(TmsCmd);
            if(TmsCmd.type == Commands.I_CHECK_MOVEMENT_PERMISSION) {
                markOccupationForBeeingRequested((TmsMovementPermissionRequest) TmsCmd);
            }

            this.tmsCommandQueue.put(TmsCmd.parseToJson());

        } catch (InterruptedException | InvalidParameterException e) {
            e.printStackTrace();
        }
    }

    private void guardCommandSender(TmsMessage tmsCmd) throws InvalidParameterException{
        if(tmsCmd == null) throw new InvalidParameterException("Command must not be null");
        if(tmsCmd.header == null) throw new InvalidParameterException("Header of Command must not be null");
        if(tmsCmd.header.uuid == null) throw new InvalidParameterException("UUID of Command-Message must not be null");
    }

    private void markOccupationForBeeingRequested(TmsMovementPermissionRequest TmsCmd) throws MissingInformationException {
        TmsMovementPermissionRequest tmpr = TmsCmd;
        NID_ENGINE nid_engine = new NID_ENGINE(tmpr.getTrainId());
        MovableObject mo = MovableObject.ObjectRepo.getModel(nid_engine);
        PositionData TrainPosition = PositionModul.getInstance().getCurrentPosition(tmpr.getTrainId());
        ETCS_DISTANCE noDistance = new ETCS_DISTANCE();
        noDistance.sDistance = 0;

        if(mo == null || TrainPosition == null)
            throw new MissingInformationException("Position of train id: " + tmpr.getTrainId() + " unknown.");
        if(tmpr.payload == null)
            throw new MissingInformationException("No Payload for Movement-Authority-Permission-Request given");

        if(tmpr.payload.route == null)
            throw new MissingInformationException("No Route for Movement-Authority-Permission-Request given");


        MovementAuthority movementAuthority = new MovementAuthority();
        movementAuthority.setMOB(mo);
        ComposedRoute CR = new ComposedRoute();
        try {
            CR.generateFromRoute(tmpr.payload.route, tmpr.getTrainId());
            PositionData Current = PositionModul.getInstance().getCurrentPosition(tmpr.getTrainId());
            if(Current == null) {
                throw new MissingInformationException("Zug #" + tmpr.getTrainId() + " cannot be located.");
            }
        } catch (SmartLogicException e) {
            e.printStackTrace();
            throw new MissingInformationException("Route cannot be created: " + e.getMessage());
        }
        TmsCmd.setMaRequestOccupation(new MARequestOccupation(CR, movementAuthority, true));
        // speichere request nach ACHTUNG! UUID der Kommunikation nicht nach UUID als Element der Occupation
        TrackAndOccupationManager.RequestManager.update(TmsCmd.header.uuid, TmsCmd);
    }





}
