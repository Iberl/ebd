package ebd.trainStatusManager.util.handlers;

import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.routeData.RouteDataMultiChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.message.trackmessages.Message_3;
import ebd.messageLibrary.message.trainmessages.Message_146;
import ebd.messageLibrary.packet.Packet;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.*;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.availableAcceleration.AvailableAcceleration;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.*;

/**
 * This class handles ETCS Messages for the {@link ebd.trainStatusManager.TrainStatusManager}.
 * Every messages has expected packages, without these the messages will be rejected. Many messages can also have
 * optional packages. These get forwarded to the {@link PacketHandler}.
 *<p>
 * Currently implemented messages per id: 3, 24<br>
 * Currently implemented optional packages per id: 5, 57, 58<br>
 *</p>
 *
 * @author Lars Schulze-Falck
 */
public class MessageHandler {
    //TODO: Respect SRS 3 A.3.3
    //TODO: Make rbcID updatetable, make RBC Event

    private EventBus localBus;
    private String exceptionTarget = "tsm";
    private int rbcID;
    private int etcsTrainID;


    public MessageHandler(EventBus localBus, int etcsTrainID, int rbcID) {
        this.localBus = localBus;
        this.localBus.register(this);
        this.rbcID = rbcID;
        this.etcsTrainID = etcsTrainID;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void msgCollector(ReceivedMessageEvent rme){
        if(!validTarget(rme.target)) return;
        if (!(rme.message instanceof TrackMessage)) {
            IllegalArgumentException iAE = new IllegalArgumentException("This Messages was not a TrackMessage");
            this.localBus.post(new TsmExceptionEvent("tsm", exceptionTarget, rme, iAE, ExceptionEventTyp.WARNING));
            return;
        }

        switch (rme.message.NID_MESSAGE){
            case 3:
                handleMsg3(rme);
                break;
            case 24:
                handleMsg24(rme);
                break;
            default:
                IllegalArgumentException iAE = new IllegalArgumentException("This message ID could not be handled: " + rme.message.NID_MESSAGE);
                localBus.post(new TsmExceptionEvent("tsm", "tsm", rme, iAE, ExceptionEventTyp.CRITICAL));
        }
    }

    /**
     * The purpose of this handler function is to take {@link ebd.messageLibrary.message.trackmessages.Message_24} and
     * react to the included packages.
     * @param rme
     */
    private void handleMsg24(ReceivedMessageEvent rme) {
        Message_24 message24 = (Message_24)rme.message;
        TrainDataVolatile trainDataVolatile = localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        Location curLoc = Objects.requireNonNull(trainDataVolatile.getCurrentPosition()).getLocation();
        /*Map<Integer, Location> previousLoc = Objects.requireNonNull(trainDataVolatile.getCurrentPosition()).getPreviousLocations();
        Location curLoc = Objects.requireNonNull(trainDataVolatile.getCurrentPosition()).getLocation();
        Location refLoc;
        if(!previousLoc.containsKey(message24.NID_LRBG)){
            if(curLoc.getId() != message24.NID_LRBG){
                String msg = "ETCS ID " + this.etcsTrainID + " received a Msg24 with a reference LRBG (" + message24.NID_LRBG +") that was not known to the train.";
                IllegalArgumentException iae = new IllegalArgumentException(msg);
                this.localBus.post(new TsmExceptionEvent("tsm", "tsm", rme, iae, ExceptionEventTyp.NONCRITICAL));
                return;
            }
            else refLoc = curLoc;

        }
        else refLoc = previousLoc.get(message24.NID_LRBG);

        boolean illegalPacket = false;
        for (Packet p : message24.packets){
            if (p instanceof TrackPacketDIR){
                TrackPacketDIR tp = (TrackPacketDIR)p;
                if (refLoc.getDirection() != tp.Q_DIR){
                    illegalPacket = true;
                    break;
                }
            }
        }
        if(illegalPacket){
            String msg = "Train " + this.etcsTrainID + " received a Msg3 that contained a packet with a non vaild direction.";
            IllegalArgumentException iae = new IllegalArgumentException(msg);
            this.localBus.post(new TsmExceptionEvent("tsm", "tsm", rme, iae, ExceptionEventTyp.NONCRITICAL));
            return;
        }*/

        Location refLoc = curLoc;

        /*
        Logging
         */
        String ids = " [Msg ID: 24 | Packets: ";
        for(TrackPacket tp : message24.packets){
            ids += " " + tp.NID_PACKET + ",";
        }
        if(ids.endsWith(",")){
            ids = ids.subSequence(0,ids.lastIndexOf(",")).toString();
        }
        ids += "]";
        /*
        /logging
         */


        this.localBus.post(new ToLogEvent("tsm", "log", "Received universal Message" + ids));

        for(TrackPacket tp : message24.packets){
            handleOptionalTrackPacket(rme,tp, refLoc);
        }
    }

    /**
     * The purpose of this handler function is to take a {@link Message_3} and<br>
     * a) update {@link RouteDataVolatile},<br>
     * b) update AvailableAcceleration in {@link TrainDataVolatile},<br>
     * c) calculate a new breaking curve,<br>
     * d) send Acknowledge if necessary,<br>
     * The order of this is important!
     * @param rme
     */
    private void handleMsg3(ReceivedMessageEvent rme) {
        TrainDataPerma trainDataPerma = localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        TrainDataVolatile trainDataVolatile = localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        RouteDataVolatile routeDataVolatile = localBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;

        Message_3 msg3 = (Message_3)rme.message;
        /*
        Check if message has a valid reference position and valid packet directions, set the reference location
         */
        Map<Integer, Location> previousLoc = Objects.requireNonNull(trainDataVolatile.getCurrentPosition()).getPreviousLocations();
        Location curLoc = Objects.requireNonNull(trainDataVolatile.getCurrentPosition()).getLocation();
        Location refLoc;
        if(!previousLoc.containsKey(msg3.NID_LRBG)){
            if(curLoc.getId() != msg3.NID_LRBG){
                String msg = "ETCS ID " + this.etcsTrainID + " received a Msg3 with a reference LRBG (" + msg3.NID_LRBG +") that was not known to the train.";
                IllegalArgumentException iae = new IllegalArgumentException(msg);
                this.localBus.post(new TsmExceptionEvent("tsm", "tsm", rme, iae, ExceptionEventTyp.NONCRITICAL));
                return;
            }
            else refLoc = curLoc;

        }
        else refLoc = previousLoc.get(msg3.NID_LRBG);

        boolean illegalPacket = false;
        for (Packet p : msg3.packets){
            if (p instanceof TrackPacketDIR){
                TrackPacketDIR tp = (TrackPacketDIR)p;
                if (refLoc.getDirection() != tp.Q_DIR){
                    illegalPacket = true;
                    break;
                }
            }
        }
        if(refLoc.getDirection() != msg3.packet_15.Q_DIR || illegalPacket){
            String msg = "Train " + this.etcsTrainID + " received a Msg3 that contained a packet with a non vaild direction.";
            IllegalArgumentException iae = new IllegalArgumentException(msg);
            this.localBus.post(new TsmExceptionEvent("tsm", "tsm", rme, iae, ExceptionEventTyp.NONCRITICAL));
            return;
        }

        /*
        Deleting old information that does not get overwritten elsewhere
         */
        localBus.post(new RouteDataChangeEvent("rsm", "rd", "packet_80", null));

        /*
        Information needed for a BreakingCurveRequestEvent
         */
        String id = "BreakingCurve";

        Packet_15 packet15;
        Packet_21 packet21 = null;
        Packet_27 packet27 = null;
        List<Packet_65> listOfPacket65s = new ArrayList<>();


        /*
        Logging
         */
        String ids = " [Msg ID: 3 | Packets: ";
        for(TrackPacket tp : msg3.packets){
            ids += " " + tp.NID_PACKET + ",";
        }
        if(ids.endsWith(",")){
            ids = ids.subSequence(0,ids.lastIndexOf(",")).toString();
        }
        ids += "]";
        this.localBus.post(new ToLogEvent("tsm", "log", "Received MA Message" + ids));

        /*
        check for complete message, save data and notify train
         */
        Position refPosition = new Position(0,true, refLoc);

        packet15 = msg3.packet_15;

        for (TrackPacket packet : msg3.packets){ //TODO Check LRBG reference consistency
            String pName = packet.getClass().getSimpleName();
            switch (pName) {
                case "Packet_21" -> packet21 = (Packet_21) packet;
                case "Packet_27" -> packet27 = (Packet_27) packet;
                case "Packet_65" -> listOfPacket65s.add((Packet_65) packet);
                default -> handleOptionalTrackPacket(rme, packet, refLoc);
            }
        }

        if(packet15 == null || packet21 == null || packet27 == null){
            IllegalArgumentException iAE = new IllegalArgumentException("A Message_3 did not contain all necessary packets");
            localBus.post(new TsmExceptionEvent("tsm", "tsm", rme, iAE, ExceptionEventTyp.CRITICAL));
            return;
        }

        Map<String, Object> changesForRouteData_2= new HashMap<>();
        changesForRouteData_2.put("refLocation", refLoc);
        changesForRouteData_2.put("packet_15",packet15);
        changesForRouteData_2.put("packet_21",packet21);
        changesForRouteData_2.put("packet_27",packet27);
        changesForRouteData_2.put("packet_65", listOfPacket65s);
        localBus.post(new RouteDataMultiChangeEvent("rsm", "rd", changesForRouteData_2));

        ForwardSpline normalBreakingPower = trainDataVolatile.getCurrentServiceBreakingPower();
        ForwardSpline serviceBreakingPower = trainDataVolatile.getCurrentServiceBreakingPower();
        ForwardSpline emergencyBreakingPower = trainDataVolatile.getCurrentEmergencyBreakingPower();
        double currentGradient = routeDataVolatile.getCurrentGradient();
        int nc_cdtrain = ETCSVariables.NC_CDTRAIN; //Not available in MVP TODO Add NC values to TrainDataPerma
        int nc_train = ETCSVariables.NC_TRAIN; //Not available in MVP
        double l_train = trainDataPerma.getL_train();
        double currentMaxSpeed = trainDataVolatile.getCurrentMaximumSpeed();
        int maxTrainSpeed = trainDataPerma.getV_maxtrain();

        AvailableAcceleration availableAcceleration = new AvailableAcceleration(localBus);
        localBus.post(new TrainDataChangeEvent("rsm","td", "availableAcceleration", availableAcceleration));

        BreakingCurveRequestEvent bcre = new BreakingCurveRequestEvent("tsm",
                "bcc",
                id,
                normalBreakingPower,
                serviceBreakingPower,
                emergencyBreakingPower,
                packet15,
                packet21,
                currentGradient,
                refPosition,
                packet27,
                listOfPacket65s,
                nc_cdtrain,
                nc_train,
                l_train,
                currentMaxSpeed,
                maxTrainSpeed);
        this.localBus.post(bcre);

        if(msg3.M_ACK){
            sendAck(msg3);
        }

        this.localBus.post(new ToLogEvent("tsm", "log",
                "Got a new MA Message and started calculating a new breaking curve"));
    }

    /**
     * The purpose of this handler function is to deal with optional {@link TrackPacket} that are not
     * used for the original function of the message.<br>
     * <p>
     * Can currently handle following {@link TrackPacket}: <br>
     * [5,57,58] <br>
     * TODO: Add additional packages
     * @param rme The {@link ReceivedMessageEvent} containing this package
     * @param trackPacket see {@link TrackPacket}
     */
    private void handleOptionalTrackPacket(ReceivedMessageEvent rme, TrackPacket trackPacket, Location refLoc) {

        switch (trackPacket.NID_PACKET){
            case 5:
                PacketHandler.p5(this.localBus,((TrackMessage)rme.message).NID_LRBG,(Packet_5)trackPacket);
                break;
            case 57:
                PacketHandler.p57(this.localBus,(Packet_57)trackPacket, refLoc);
                break;
            case 58:
                PacketHandler.p58(this.localBus,((TrackMessage)rme.message).NID_LRBG,(Packet_58)trackPacket, refLoc);
                break;
            case 72:
                PacketHandler.p72(this.localBus,(Packet_72)trackPacket);
                break;
            case 80:
                PacketHandler.p80(this.localBus,(Packet_80)trackPacket);
                break;
            default:
                IllegalArgumentException iAE = new IllegalArgumentException("TrackPacket is unhandelt or unknow, NID_PACKET:  " + trackPacket.NID_PACKET);
                localBus.post(new TsmExceptionEvent("tsm", "tsm", rme, iAE, ExceptionEventTyp.NONCRITICAL));
        }

    }

    private void sendAck(TrackMessage tm) {
        Message_146 message146 = new Message_146();
        message146.NID_ENGINE = this.etcsTrainID;
        long curTime = AppTime.currentTimeMillis() / 10L;
        message146.T_TRAIN = curTime % ETCSVariables.T_TRAIN_UNKNOWN;
        message146.T_TRAIN_MSG = tm.T_TRAIN;
        String destination = "mr;R=" + this.rbcID;
        this.localBus.post(new SendETCSMessageEvent("tsm", "ms", message146, destination ));
        this.localBus.post(new ToLogEvent("tsm", "log", "Sending Acknowledgment [Msg ID: 146]"));
    }

    /**
     * True if this Instance is a vaild target of the event
     * @param target the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(String target){

        if(target.contains("tsm") || target.contains("all")){
            if(!target.contains(";")){
                return true;

            }
            else if (target.contains(";T=" + this.etcsTrainID)){
                return true;

            }
        }
        return false;
    }

}
