package ebd.trainStatusManager.util;

import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
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

public class MessageHandler {
    //TODO: Respect SRS 3 A.3.3

    private EventBus localBus;
    private List<String> exceptionTarget = Collections.singletonList("tsm");
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
        if(!validTarget(rme.targets)) return;
        if (!(rme.message instanceof TrackMessage)) {
            IllegalArgumentException iAE = new IllegalArgumentException("This Messages was not a TrackMessage");
            this.localBus.post(new TsmExceptionEvent("tsm", exceptionTarget, rme, iAE, ExceptionEventTyp.WARNING));
            return;
        }

        switch (rme.message.NID_MESSAGE){
            case 3:
                this.localBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), "Received MA Message"));
                handleMsg3(rme);
                break;
            case 24:
                handleMsg24(rme);
                break;
            default:
                IllegalArgumentException iAE = new IllegalArgumentException("This message ID could not be handled: " + rme.message.NID_MESSAGE);
                localBus.post(new TsmExceptionEvent("tsm", Collections.singletonList("tsm"), rme, iAE, ExceptionEventTyp.CRITICAL));
        }
    }

    /**
     * The purpose of this handler function is to take {@link ebd.messageLibrary.message.trackmessages.Message_24} and
     * react to the included packages.
     * @param rme
     */
    private void handleMsg24(ReceivedMessageEvent rme) {
        Message_24 message24 = (Message_24)rme.message;
        for(TrackPacket tp : message24.packets){
            handleOptionalTrackPackages(rme,tp);
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

        /*
        Information needed for a BreakingCurveRequestEvent
         */
        String id = "BreakingCurve";

        Packet_15 packet15;
        Packet_21 packet21 = null;
        Packet_27 packet27 = null;
        List<Packet_65> listOfPacket65s = new ArrayList<>();


        ForwardSpline breakingPower = trainDataVolatile.getCurrentBreakingPower();
        double currentGradient = routeDataVolatile.getCurrentGradient();
        int nc_cdtrain = ETCSVariables.NC_CDTRAIN; //Not available in MVP TODO Add NC values to TrainDataPerma
        int nc_train = ETCSVariables.NC_TRAIN; //Not available in MVP
        double l_train = trainDataPerma.getL_train();
        double currentMaxSpeed = trainDataVolatile.getCurrentMaxSpeed();
        int maxTrainSpeed = trainDataPerma.getV_maxtrain();

        Position refPosition;


        Message_3 msg3 = (Message_3)rme.message;
        Location refLocation = new Location(msg3.NID_LRBG,ETCSVariables.NID_LRBG,null); //TODO check if viable
        refPosition = new Position(0,true, refLocation);

        packet15 = msg3.Packet_15;

        for (TrackPacket packet : msg3.packets){ //TODO Check LRBG reference consistency
            String pName = packet.getClass().getSimpleName();
            switch (pName){
                case "Packet_21":
                    packet21 = (Packet_21)packet;
                    break;
                case "Packet_27":
                    packet27 = (Packet_27)packet;
                    break;
                case "Packet_65":
                    listOfPacket65s.add((Packet_65)packet);
                    break;
                default:
                    handleOptionalTrackPackages(rme,packet);
            }
        }


        if(packet15 == null || packet21 == null || packet27 == null){
                IllegalArgumentException iAE = new IllegalArgumentException("A Message_3 did not contain all necessary packets");
                localBus.post(new TsmExceptionEvent("tsm", Collections.singletonList("tsm"), rme, iAE, ExceptionEventTyp.CRITICAL));
                return;
        }
        Map<String, Object> changesForRouteData= new HashMap<>();
        changesForRouteData.put("packet_15",packet15);
        changesForRouteData.put("packet_21",packet21);
        changesForRouteData.put("packet_27",packet27);
        changesForRouteData.put("packet_65", listOfPacket65s);
        localBus.post(new RouteDataMultiChangeEvent("rsm", Collections.singletonList("rd"), changesForRouteData));

        AvailableAcceleration availableAcceleration = new AvailableAcceleration(localBus);
        localBus.post(new TrainDataChangeEvent("rsm", Collections.singletonList("td"), "availableAcceleration", availableAcceleration));

        BreakingCurveRequestEvent bcre = new BreakingCurveRequestEvent("tsm", Collections.singletonList("bcc"), id,breakingPower,
        packet15,packet21,currentGradient,refPosition, packet27,listOfPacket65s,nc_cdtrain,nc_train,
        l_train,currentMaxSpeed,maxTrainSpeed);
        this.localBus.post(bcre);

        if(msg3.M_ACK){
            sendAck(msg3);
        }

        this.localBus.post(new ToLogEvent("tsm", Collections.singletonList("log"),
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
    private void handleOptionalTrackPackages(ReceivedMessageEvent rme, TrackPacket trackPacket) {

        switch (trackPacket.NID_PACKET){
            case 5:
                PackageResolver.p5(this.localBus,((TrackMessage)rme.message).NID_LRBG,(Packet_5)trackPacket);
                break;
            case 58:
                PackageResolver.p58(this.localBus,((TrackMessage)rme.message).NID_LRBG,(Packet_58)trackPacket);
                break;
            case 57:
                PackageResolver.p57(this.localBus,(Packet_57)trackPacket);
                break;
            default:
                IllegalArgumentException iAE = new IllegalArgumentException("TrackPacket is unhandelt or unknow, NID_PACKET:  " + trackPacket.NID_PACKET);
                localBus.post(new TsmExceptionEvent("tsm", Collections.singletonList("tsm"), rme, iAE, ExceptionEventTyp.NONCRITICAL));
        }

    }

    private void sendAck(TrackMessage tm) {
        Message_146 message146 = new Message_146();
        message146.NID_ENGINE = this.etcsTrainID;
        long curTime = System.currentTimeMillis() / 10L;
        message146.T_TRAIN = curTime % ETCSVariables.T_TRAIN_UNKNOWN;
        message146.T_TRAIN_MSG = tm.T_TRAIN;
        List<String> destination = Collections.singletonList("mr;R=" + this.rbcID);
        this.localBus.post(new SendMessageEvent("tsm", Collections.singletonList("ms"), message146, destination ));
        this.localBus.post(new ToLogEvent("tsm", Collections.singletonList("log"), "Sending Acknowledgment"));
    }

    /**
     * True if this Instance is a vaild target of the event
     * @param targetList the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(List<String> targetList){
        boolean result = false;

        for(String target : targetList){
            if(target.contains("tsm") || target.contains("all")){
                if(!target.contains(";")){
                    result = true;
                    break;
                }
                else if (target.contains(";T=" + this.etcsTrainID)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}
