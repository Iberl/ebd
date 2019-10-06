package ebd.radioBlockCenter.util.handlers;

import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.message.trackmessages.Message_3;
import ebd.messageLibrary.message.trainmessages.Message_132;
import ebd.messageLibrary.message.trainmessages.Message_136;
import ebd.messageLibrary.message.trainmessages.Message_146;
import ebd.messageLibrary.message.trainmessages.Message_155;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.*;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.radioBlockCenter.util.Route;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.*;

import static ebd.messageLibrary.util.ETCSVariables.M_LOC_AT_BALISE_GROUP;
import static ebd.messageLibrary.util.ETCSVariables.Q_DIR_NOMINAL;

public class MessageHandler {

    private ArrayList<Integer> controlledTrainsByID;
    EventBus localBus;
    String rbcID;
    Map<Integer, List<Route>> trainIDsToRoute;

    public MessageHandler(EventBus localBus, String rbcID, Map<Integer, List<Route>> trainIDsToRoute) {
        this.localBus = localBus;
        this.trainIDsToRoute = trainIDsToRoute;
        this.localBus.register(this);
        this.controlledTrainsByID = new ArrayList<>();
        this.rbcID = rbcID;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receivedMessage(ReceivedMessageEvent rme){
        if(!validTarget(rme.targets)) return;
        String trainID = (rme.sender.split(";T="))[1];
        if(rme.message instanceof Message_132){//TODO: Actual MA RequestMessage
            String msg = String.format("Received MA request from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
            sendMessage3(rme);
        }
        else if(rme.message instanceof Message_136){
            String msg = String.format("Received position report from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        }
        else if(rme.message instanceof Message_146){
            String msg = String.format("Received Acknowledge from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        }
        else if(rme.message instanceof Message_155){
            this.controlledTrainsByID.add(((Message_155) rme.message).NID_ENGINE);
            String msg = String.format("Received communication initiation from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
            sendMessage24withPackets57MARZEROAnd58(rme);

        }
    }

    private void sendMessage3(ReceivedMessageEvent rme) {
        String trainID = rme.sender.split(";T=")[1];
        Route nextRoute = this.trainIDsToRoute.get(Integer.parseInt(trainID)).remove(0);
        double d_EOL = nextRoute.getDistance();

        List<TrackPacket> lop = new ArrayList<>();
        lop.add(makeP21());
        lop.add(makeP27());
        lop.add(makeP57());

        Message_3 msg3 = new Message_3();
        msg3.M_ACK = ETCSVariables.M_ACK_REQUIRED;
        msg3.NID_LRBG = 0;
        msg3.Packet_15 = makeP15(d_EOL);
        msg3.packets = lop;

        this.localBus.post(new SendMessageEvent("rbc", Collections.singletonList("ms"), msg3, Collections.singletonList("mr;T=" + trainID)));
        this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), "Sending MA Message"));
    }

    private void sendMessage24withPackets57MARZEROAnd58(ReceivedMessageEvent rme){
        String trainID = rme.sender.split(";T=")[1];
        List<TrackPacket> trackPackets = new ArrayList<>();
        trackPackets.add(makeP57TMARZero());
        trackPackets.add(makeP58());
        Message_24 msg24 = makeMessage24(trackPackets);
        this.localBus.post(new SendMessageEvent("rbc", Collections.singletonList("ms"), msg24, Collections.singletonList("mr;T=" + trainID)));
        this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("ms"), "Sending MA Request Parameters and Position Report Parameters"));
    }

    private Message_24 makeMessage24(List<TrackPacket> trackPackets){
        Message_24 m24 = new Message_24();
        m24.NID_LRBG = 0;
        m24.packets.addAll(trackPackets);
        return m24;
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

    private Packet_57 makeP57(){
        Packet_57 packet57 = new Packet_57();
        packet57.T_CYCRQST = ETCSVariables.T_CYCRQST_INFINITY;
        packet57.T_MAR = ETCSVariables.T_MAR_INFINITY;
        packet57.T_TIMEOUTRQST = ETCSVariables.T_TIMEOUTRQST_INFINITY;
        return packet57;
    }

    private Packet_57 makeP57TMARZero(){
        Packet_57 packet57 = new Packet_57();
        packet57.T_CYCRQST = ETCSVariables.T_CYCRQST_INFINITY;
        packet57.T_MAR = 0;
        packet57.T_TIMEOUTRQST = ETCSVariables.T_TIMEOUTRQST_INFINITY;
        return packet57;
    }

    private Packet_58 makeP58(){

        Packet_58 packet58 = new Packet_58();
        packet58.Q_DIR = Q_DIR_NOMINAL;
        packet58.M_LOC = M_LOC_AT_BALISE_GROUP;

        return packet58;
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
