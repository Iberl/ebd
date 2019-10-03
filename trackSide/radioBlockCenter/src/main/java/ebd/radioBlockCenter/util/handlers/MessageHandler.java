package ebd.radioBlockCenter.util.handlers;

import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.message.trackmessages.Message_3;
import ebd.messageLibrary.message.trainmessages.Message_132;
import ebd.messageLibrary.message.trainmessages.Message_146;
import ebd.messageLibrary.message.trainmessages.Message_155;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.radioBlockCenter.util.Route;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.*;

public class MessageHandler {

    EventBus localBus;
    String rbcID;

    List<Integer> controlledTrainsByID;
    Map<Integer, List<Route>> trainIDsToRoute;

    public MessageHandler(EventBus localBus, List<Integer> controlledTrainIDs, String rbcID, Map<Integer, List<Route>> trainIDsToRoute) {
        this.localBus = localBus;
        this.trainIDsToRoute = trainIDsToRoute;
        this.localBus.register(this);
        this.controlledTrainsByID = controlledTrainIDs;
        this.rbcID = rbcID;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receivedMessage(ReceivedMessageEvent rme){
        if(!validTarget(rme.targets)) return;
        //TODO Rewrite
        if(rme.message instanceof Message_24){
            //TODO: Use "sender" of RME instead of controlledTrainsByID
            String msg = String.format("RBC -> ebd.logger.ebd.logging.Logging: RBC received position report from train %s", controlledTrainsByID.get(0));
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        }
        else if(rme.message instanceof Message_155){//TODO: Actual MA RequestMessage
            String msg = String.format("RBC -> ebd.logger.ebd.logging.Logging: RBC received 'MA request' from train %s", controlledTrainsByID.get(0));
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
            sendMessage3(rme);
        }
        else if(rme.message instanceof Message_146){
            String msg = String.format("RBC -> ebd.logger.ebd.logging.Logging: RBC received Acknowledge from train %s", controlledTrainsByID.get(0));
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        }
    }

    private void sendMessage3(ReceivedMessageEvent rme) {
        String trainID = rme.sender.split(";T=")[1];
        Route nextRoute = this.trainIDsToRoute.get(Integer.parseInt(trainID)).remove(0);
        double d_EOL = nextRoute.getDistance();

        List<TrackPacket> lop = new ArrayList<>();
        lop.add(makeP21());
        lop.add(makeP27());

        Message_3 msg3 = new Message_3();
        msg3.M_ACK = ETCSVariables.M_ACK_REQUIRED;
        msg3.NID_LRBG = 0;
        msg3.Packet_15 = makeP15(d_EOL);
        msg3.packets = lop;

        this.localBus.post(new SendMessageEvent("rbc", Collections.singletonList("ms"), msg3, Collections.singletonList("mr;T=" + trainID)));
    }

    private Packet_15 makeP15(double d_EOA){
        Packet_15 packet15 = new Packet_15();

        Packet_15.Packet_15_Section endsection = new Packet_15.Packet_15_Section();
        endsection.L_SECTION = (int)d_EOA; //m
        ArrayList<Packet_15.Packet_15_Section> sections = new ArrayList<>();

        packet15.Q_SCALE = ETCSVariables.Q_SCALE_1M;
        packet15.endsection = endsection;
        packet15.sections = sections;
        packet15.V_LOA = 0;
        return packet15;
    }

    private Packet_21 makeP21(){
        int[] gp = {0,1,750,0,550,-2,600,1}; //[m,0/00]
        Packet_21.Packet_21_Gradient gradient = new Packet_21.Packet_21_Gradient(gp[0], gp[1] >= 0, Math.abs(gp[1]));
        ArrayList<Packet_21.Packet_21_Gradient> gradients = new ArrayList<>();

        for (int i = 2; i < gp.length; i+=2) {
            Packet_21.Packet_21_Gradient tempgrad = new Packet_21.Packet_21_Gradient(gp[i], gp[i+1] >= 0, Math.abs(gp[i+1]));
            gradients.add(tempgrad);
        }
        Packet_21 packet21 = new Packet_21();
        packet21.Q_SCALE = ETCSVariables.Q_SCALE_1M;
        packet21.gradient = gradient;
        packet21.gradients = gradients;

        return packet21;
    }

    private Packet_27 makeP27(){
        int[] tsp = {0,100,900,80,700,120}; //[m,km/h]

        Packet_27 packet27 = new Packet_27();

        Packet_27.Packet_27_StaticSpeedProfile p27SSP = new Packet_27.Packet_27_StaticSpeedProfile(tsp[0], tsp[1] / 5, true);

        ArrayList<Packet_27.Packet_27_StaticSpeedProfileSection> sectionList = new ArrayList<>();

        p27SSP.sections = sectionList;
        packet27.Q_SCALE = ETCSVariables.Q_SCALE_1M;
        packet27.speedProfile = p27SSP;

        ArrayList<Packet_27.Packet_27_StaticSpeedProfile> profileList = new ArrayList<>();

        for (int i = 2; i < tsp.length; i+=2) {

            p27SSP = new Packet_27.Packet_27_StaticSpeedProfile(tsp[i],tsp[i+1] / 5,true);
            sectionList = new ArrayList<>();
            p27SSP.sections = sectionList;
            profileList.add(p27SSP);
        }
        packet27.speedProfiles = profileList;

        return packet27;
    }

    private boolean validTarget(List<String> targetList){

        for(String target : targetList){
            if(target.contains("tsm") || target.contains("all")){
                if(!target.contains(";")){
                    return true;
                }
                else if (target.contains(";R=" + this.rbcID)){
                    return true;
                }
            }
        }
        return false;
    }


}
