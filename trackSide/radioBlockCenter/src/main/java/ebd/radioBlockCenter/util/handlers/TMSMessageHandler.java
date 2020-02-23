package ebd.radioBlockCenter.util.handlers;

import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.messageLibrary.message.trackmessages.Message_24;
import ebd.messageLibrary.message.trackmessages.Message_3;
import ebd.messageLibrary.message.trainmessages.*;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.*;
import ebd.messageLibrary.util.ETCSVariables;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.simple.JSONObject;

import java.util.*;

import static ebd.messageLibrary.util.ETCSVariables.M_LOC_NOT_AT_BALISE_GROUP;
import static ebd.messageLibrary.util.ETCSVariables.Q_DIR_NOMINAL;

public class TMSMessageHandler {

    private ArrayList<Integer> controlledTrainsByID;
    private EventBus localBus;
    private String rbcID;
    private List<int[]> speedsegments;
    private Map<Integer, Integer> trainToLRBGMap;
    private List<Message_3> msg3List = new ArrayList<>();

    private int scenario;
    private int nextSpeedSegment = 0;
    private double maDistance = 0;
    private int nid_lrbg = 0;
    private int d_lrbg = 0;
    private boolean trainShouldStop = false;
    private int[] balisePositions = new int[] {0, 400, 1000, 1400, 1900, 2200, 2400, 2500, 2800, 3000, 3600};

    public TMSMessageHandler(EventBus localBus, String rbcID, List<int[]> speedsegments, int scenario) {
        this.localBus = localBus;
        this.speedsegments = speedsegments;
        this.scenario = scenario;
        this.localBus.register(this);
        this.controlledTrainsByID = new ArrayList<>();
        this.rbcID = rbcID;
        this.trainToLRBGMap = new HashMap<>();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receivedMessage(ReceivedMessageEvent rme) {
        if(!validTarget(rme.targets)) return;
        String trainID = (rme.sender.split(";T="))[1];


        if(rme.message instanceof Message_132) { //MA Request
            Message_132 msg132 = (Message_132) rme.message;
            this.trainToLRBGMap.put(Integer.parseInt(trainID), msg132.PACKET_POSITION.NID_LRBG);
            String msg = String.format("Received MA request from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
            if(!trainShouldStop) {
                sendMessage3(makeM3(rme.sender.split(";T=")[1]), trainID);
            }
        } else if(rme.message instanceof Message_136) { //Position Report
            Message_136 msg136 = (Message_136) rme.message;
            String msg = String.format("Received position report from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));

            int nid_lrbg = msg136.PACKET_POSITION.NID_LRBG;
            int d_lrbg = msg136.PACKET_POSITION.D_LRBG;
            int q_scale = msg136.PACKET_POSITION.Q_SCALE;
            d_lrbg = (int) (Math.pow(10, q_scale - 1) * d_lrbg);

            if(trainShouldStop && this.nid_lrbg == nid_lrbg && d_lrbg == this.d_lrbg) {
                trainShouldStop = false;
                try {
                    msg = "Waiting until next MA Message can be send.";
                    this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
                    Thread.sleep(10000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                sendMessage3(makeM3(rme.sender.split(";T=")[1]), trainID);
            }
            this.nid_lrbg = nid_lrbg;
            this.d_lrbg = d_lrbg;

            this.trainToLRBGMap.put(Integer.parseInt(trainID), msg136.PACKET_POSITION.NID_LRBG);
        } else if(rme.message instanceof Message_146) {
            String msg = String.format("Received Acknowledge from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        } else if(rme.message instanceof Message_150) {
            String msg = String.format("Received Mission End message from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
        } else if(rme.message instanceof Message_155) {
            this.controlledTrainsByID.add(((Message_155) rme.message).NID_ENGINE);
            String msg = String.format("Received communication initiation from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
            sendMessage24withPackets57MARZEROAnd58(rme);

        }
    }

    private void sendMessage3(Message_3 msg3, String trainID) {
        this.localBus.post(new SendMessageEvent("rbc", Collections.singletonList("ms"), msg3, Collections.singletonList("mr;T=" + trainID)));
        this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), "Sending MA Message"));
    }

    private void sendMessage24withPackets57MARZEROAnd58(ReceivedMessageEvent rme) {
        String trainID = rme.sender.split(";T=")[1];
        List<TrackPacket> trackPackets = new ArrayList<>();
        trackPackets.add(makeP57(0));
        trackPackets.add(makeP58());
        Message_24 msg24 = makeMessage24(trackPackets);
        this.localBus.post(new SendMessageEvent("rbc", Collections.singletonList("ms"), msg24, Collections.singletonList("mr;T=" + trainID)));
        this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("ms"), "Sending MA Request Parameters and Position Report Parameters"));
    }

    private Message_3 makeM3(String trainID) {
        List<TrackPacket> packets = new ArrayList<>();

        List<Integer> gpList = new ArrayList<>();
        List<Integer> tspList = new ArrayList<>();
        int t_mar = 20;

        int p_lrbg = balisePositions[Math.min(nid_lrbg, balisePositions.length -1)];


        // first segment
        int prevDistance = 0;
        int beginPosition = speedsegments.get(nextSpeedSegment)[0] - p_lrbg;
        int v_static = speedsegments.get(nextSpeedSegment)[1];
        int endPosition = speedsegments.get(nextSpeedSegment)[2] - p_lrbg;

        System.out.println("P_lrbg " + p_lrbg + " begin " + beginPosition + " v " + v_static + " end " + endPosition);


        if(beginPosition > 0) {
            tspList.add(0);
            tspList.add(40);
            gpList.add(beginPosition);
            gpList.add(0);
            prevDistance = endPosition;
        } else {
            tspList.add(beginPosition);
            tspList.add(v_static);
            gpList.add(beginPosition);
            gpList.add(0);
            nextSpeedSegment++;
            prevDistance = endPosition - beginPosition;
        }


        for(; nextSpeedSegment < speedsegments.size(); nextSpeedSegment++) {
            beginPosition = speedsegments.get(nextSpeedSegment)[0] - p_lrbg;
            v_static = speedsegments.get(nextSpeedSegment)[1];
            endPosition = speedsegments.get(nextSpeedSegment)[2] - p_lrbg;

            //System.out.println("P_lrbg " + p_lrbg + " begin " + beginPosition + " v " + v_static + " end " + endPosition);

            if(beginPosition == endPosition && v_static == 0) {
                //System.out.println("train should halt");
                trainShouldStop = true;
                nextSpeedSegment++;
                t_mar = ETCSVariables.T_MAR_INFINITY;
                break;
            }

            tspList.add(prevDistance);
            tspList.add(v_static);
            gpList.add(prevDistance);
            gpList.add(0);

            prevDistance = endPosition - beginPosition;
        }

        if(nextSpeedSegment == speedsegments.size()) {
            t_mar = ETCSVariables.T_MAR_INFINITY;
            packets.add(makeP80());
        }
        packets.add(makeP57(t_mar));

        int[] gp = new int[gpList.size()];
        int[] tsp = new int[tspList.size()];

        for(int i = 0; i < gpList.size(); i++) {
            gp[i] = gpList.get(i);
        }
        for(int i = 0; i < tspList.size(); i++) {
            //System.out.println("tsp[" + i + "] " + tspList.get(i));
            tsp[i] = tspList.get(i);
        }

        packets.add(makeP21(gp));
        packets.add(makeP27(tsp));

        Message_3 msg3 = new Message_3();
        msg3.M_ACK = ETCSVariables.M_ACK_REQUIRED;
        msg3.NID_LRBG = nid_lrbg;

        //System.out.println("msg 3 LRBG: " + msg3.NID_LRBG);
        //System.out.println("eoa: " + endPosition);
        msg3.Packet_15 = makeP15(endPosition);
        msg3.packets = packets;
        return msg3;
    }

    private Message_24 makeMessage24(List<TrackPacket> trackPackets) {
        Message_24 m24 = new Message_24();
        m24.NID_LRBG = 0;
        m24.packets.addAll(trackPackets);
        return m24;
    }

    private Packet_15 makeP15(double d_EOA) {
        Packet_15 packet15 = new Packet_15();

        packet15.Q_SCALE = ETCSVariables.Q_SCALE_1M;
        packet15.endsection.L_SECTION = (int) d_EOA;
        packet15.V_LOA = 0;

        return packet15;
    }

    private Packet_21 makeP21(int[] gp) {
        //int[] gp = {0,1,750,0,550,-2,600,1}; //[m,0/00]
        Packet_21.Packet_21_Gradient gradient = new Packet_21.Packet_21_Gradient(gp[0], gp[1] >= 0, Math.abs(gp[1]));
        ArrayList<Packet_21.Packet_21_Gradient> gradients = new ArrayList<>();

        for(int i = 2; i < gp.length; i += 2) {
            Packet_21.Packet_21_Gradient tempgrad = new Packet_21.Packet_21_Gradient(gp[i], gp[i + 1] >= 0, Math.abs(gp[i + 1]));
            gradients.add(tempgrad);
        }
        Packet_21 packet21 = new Packet_21();
        packet21.Q_SCALE = ETCSVariables.Q_SCALE_1M;
        packet21.gradient = gradient;
        packet21.gradients = gradients;

        return packet21;
    }

    private Packet_27 makeP27(int[] tsp) {
        //int[] tsp = {0,100,900,80,700,120}; //[m,km/h]

        Packet_27 packet27 = new Packet_27();

        Packet_27.Packet_27_StaticSpeedProfile p27SSP = new Packet_27.Packet_27_StaticSpeedProfile(tsp[0], tsp[1] / 5, true);

        //System.out.println(tsp[1] / 5);

        ArrayList<Packet_27.Packet_27_StaticSpeedProfileSection> sectionList = new ArrayList<>();

        p27SSP.sections = sectionList;
        packet27.Q_SCALE = ETCSVariables.Q_SCALE_1M;
        packet27.speedProfile = p27SSP;

        ArrayList<Packet_27.Packet_27_StaticSpeedProfile> profileList = new ArrayList<>();

        for(int i = 2; i < tsp.length; i += 2) {

            p27SSP = new Packet_27.Packet_27_StaticSpeedProfile(tsp[i], tsp[i + 1] / 5, true);

            System.out.println(tsp[i + 1] / 5);
            sectionList = new ArrayList<>();
            p27SSP.sections = sectionList;
            profileList.add(p27SSP);
        }
        packet27.speedProfiles = profileList;

        return packet27;
    }

    private Packet_57 makeP57(int T_MAR) {
        Packet_57 packet57 = new Packet_57();
        packet57.T_CYCRQST = ETCSVariables.T_CYCRQST_INFINITY;
        packet57.T_MAR = T_MAR;
        packet57.T_TIMEOUTRQST = ETCSVariables.T_TIMEOUTRQST_INFINITY;
        return packet57;
    }

    private Packet_58 makeP58() {

        Packet_58 packet58 = new Packet_58();
        packet58.Q_DIR = Q_DIR_NOMINAL;
        packet58.T_CYCLOC = 10;
        packet58.M_LOC = M_LOC_NOT_AT_BALISE_GROUP;

        return packet58;
    }

    private Packet_80 makeP80() {
        Packet_80 packet_80 = new Packet_80();

        packet_80.mode.M_MAMODE = ETCSVariables.M_MAMODE_SHUNTING;
        return packet_80;
    }

    private boolean validTarget(List<String> targetList) {

        for(String target : targetList) {
            if(target.contains("tsm") || target.contains("all")) {
                if(!target.contains(";")) {
                    return true;
                } else if(target.contains(";R=" + this.rbcID)) {
                    return true;
                }
            }
        }
        return false;
    }


}
