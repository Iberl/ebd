package ebd.trainStatusManager.util;

import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.messageLibrary.message.Message;
import ebd.messageLibrary.message.trackmessages.Message_15;
import ebd.messageLibrary.message.trackmessages.Message_3;
import ebd.messageLibrary.packet.Packet;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.messageLibrary.packet.trackpackets.Packet_65;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import ebd.trainStatusManager.util.events.TsmExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MessageHandler {

    private EventBus localBus;
    private String etcsTrainID;


    public MessageHandler(EventBus localBus, String etcsTrainID) {
        this.localBus = localBus;
        this.localBus.register(this);
        this.etcsTrainID = etcsTrainID;
    }

    @Subscribe
    public void msgCollector(ReceivedMessageEvent rme){
        if(!validTarget(rme.targets)) return;

        switch (rme.message.NID_MESSAGE){
            case 3:
                handleMsg3(rme);
                break;
            default:
                IllegalArgumentException iAE = new IllegalArgumentException("This message ID could not be handled: " + rme.message.NID_MESSAGE);
                localBus.post(new TsmExceptionEvent("tsm", Arrays.asList("tsm"), rme, iAE, ExceptionEventTyp.CRITICAL));
        }
    }

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
        int nc_cdtrain = ETCSVariables.NC_CDTRAIN; //Not available in MVP
        int nc_train = ETCSVariables.NC_TRAIN; //Not available in MVP
        double l_train = trainDataPerma.getL_train();
        double currentMaxSpeed = trainDataVolatile.getCurrentMaxSpeed();
        double maxTrainSpeed = trainDataPerma.getV_maxtrain();

        Position refPosition;


        Message_3 msg3 = (Message_3)rme.message;
        Location refLocation = new Location(String.valueOf(msg3.NID_LRBG),null,null); //TODO check if viable
        refPosition = new Position(0,true, refLocation);

        packet15 = msg3.Packet_15;

        for (Packet packet : msg3.packets){
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
                    IllegalArgumentException iAE = new IllegalArgumentException("A Message_3 contained an unused " + pName);
                    localBus.post(new TsmExceptionEvent("tsm", Arrays.asList("tsm"), rme, iAE, ExceptionEventTyp.WARNING));
            }
        }

        if(packet15 == null || packet21 == null || packet27 == null){
            IllegalArgumentException iAE = new IllegalArgumentException("A Message_3 did not contain all necessary packets");
            localBus.post(new TsmExceptionEvent("tsm", Arrays.asList("tsm"), rme, iAE, ExceptionEventTyp.CRITICAL));
            return;
        }

        BreakingCurveRequestEvent bcre = new BreakingCurveRequestEvent("tsm", Arrays.asList("bcc"), id,breakingPower,
                packet15,packet21,currentGradient,refPosition, packet27,listOfPacket65s,nc_cdtrain,nc_train,
                l_train,currentMaxSpeed,maxTrainSpeed);
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
