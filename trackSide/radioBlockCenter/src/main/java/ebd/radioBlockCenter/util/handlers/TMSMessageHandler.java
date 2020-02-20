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
import ebd.radioBlockCenter.util.Route;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.*;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class TMSMessageHandler {

    private ArrayList<Integer> controlledTrainsByID;
    private EventBus localBus;
    private String rbcID;
    private List<JSONObject> maInfos;
    private Map<Integer, Integer> trainToLRBGMap;
    private List<Message_3> msg3List = new ArrayList<>();

    private int scenario;
    private int nextMaInfo = 0;
    private int nextSpeedSegment = 0;
    private double maDistance = 0;
    private int nid_lrbg = 0;
    private int d_lrbg = 0;
    private boolean trainShouldStop = false;

    public TMSMessageHandler(EventBus localBus, String rbcID, List<JSONObject> maInfos, int scenario) {
        this.localBus = localBus;
        this.maInfos = maInfos;
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
            int nid_lrbg = msg136.PACKET_POSITION.NID_LRBG;
            int d_lrbg = msg136.PACKET_POSITION.D_LRBG;
            int q_scale = msg136.PACKET_POSITION.Q_SCALE;
            d_lrbg = (int) (Math.pow(10, q_scale - 1) * d_lrbg);

            if(trainShouldStop && this.nid_lrbg == nid_lrbg && d_lrbg - this.d_lrbg == 0) {
                trainShouldStop = false;
                try {
                    System.out.println("Waiting ... 10s");
                    Thread.sleep(10000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sending next MA");
                sendMessage3(makeM3(rme.sender.split(";T=")[1]), trainID);
            } else {
                System.out.println(d_lrbg);
                System.out.println("qscale" + q_scale);
                this.nid_lrbg = nid_lrbg;
                this.d_lrbg = d_lrbg;
                System.out.println(this.nid_lrbg);
                System.out.println(this.d_lrbg);
            }
            this.trainToLRBGMap.put(Integer.parseInt(trainID), msg136.PACKET_POSITION.NID_LRBG);
            String msg = String.format("Received position report from train %s", trainID);
            this.localBus.post(new ToLogEvent("rbc", Collections.singletonList("log"), msg));
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
        //Route nextRoute = this.maInfos.get(Integer.parseInt(trainID)).remove(0);
        double nextMaDistance = 0;
        double d_eoa = 0;

        List<TrackPacket> packets = new ArrayList<>();

        List<Integer> gpList = new ArrayList<>();
        List<Integer> tspList = new ArrayList<>();

        for(; nextMaInfo < maInfos.size(); nextMaInfo++) {
            JSONObject maInfo = maInfos.get(nextMaInfo);
            JSONObject eoa = (JSONObject) maInfo.get("endOfAuthority");

            nextSpeedSegment = 0;

            int beginPosition = 0;
            int endPosition = 0;
            JSONObject sp = ((JSONObject) maInfo.get("speedProfile"));

            // Speed Profile
            boolean done = false;

            if(!(boolean) eoa.get("shunting")) {
                JSONArray speedSegmentsJSON = (JSONArray) sp.get("speedSegments");

                System.out.println(speedSegmentsJSON.size());
                for(;nextSpeedSegment < speedSegmentsJSON.size(); nextSpeedSegment++) {

                    JSONObject tspJSON = (JSONObject) speedSegmentsJSON.get(nextSpeedSegment);

                    beginPosition = ((Long) ((JSONObject) ((JSONObject) tspJSON.get("begin")).get("chainage")).get("iMeters")).intValue();
                    endPosition = ((Long) ((JSONObject) ((JSONObject) tspJSON.get("end")).get("chainage")).get("iMeters")).intValue();

                    int v_static = ((Long) ((JSONObject) tspJSON.get("v_STATIC")).get("bSpeed")).intValue() * 5;
                    tspList.add(beginPosition);
                    tspList.add(v_static);

                    JSONObject chainage = (JSONObject) eoa.get("chainage");
                    long iMeters = (Long) chainage.get("iMeters");
                    d_eoa = (double) iMeters;
                    //d_eoa = 100;

                    gpList.add(beginPosition);
                    gpList.add(0);

                    /*if(d_eoa - maDistance > 2000) {
                        nextSpeedSegment++;
                        done = true;
                        break;
                    }*/

                    System.out.println(beginPosition + " " + endPosition + " " + v_static);
                    if(beginPosition == endPosition && v_static == 0) {
                        System.out.println("train should halt");
                        trainShouldStop = true;
                        nextSpeedSegment++;
                        done = true;
                        break;
                    }
                }

            } else if(nextMaInfo == maInfos.size()) {
                tspList.add(beginPosition);
                tspList.add(0);
                gpList.add(beginPosition);
                gpList.add(0);
                break;
            }
            System.out.println("nach innerer schleife: " + nextMaInfo + ' ' + done);
            if(done) break;
        }

        nextMaDistance = (int) d_eoa;

        int[] gp = new int[gpList.size()];
        int[] tsp = new int[tspList.size()];

        for(int i = 0; i < gpList.size(); i++) {
            gp[i] = gpList.get(i);
        }
        for(int i = 0; i < tspList.size(); i++) {
            tsp[i] = tspList.get(i);
        }

        packets.add(makeP21(gp));
        packets.add(makeP27(tsp));
        if(nextMaInfo == maInfos.size()) {
            packets.add(makeP57(ETCSVariables.T_MAR_INFINITY));
            packets.add(makeP80());
        } else {
            packets.add(makeP57(20));
        }

        Message_3 msg3 = new Message_3();
        msg3.M_ACK = ETCSVariables.M_ACK_REQUIRED;
        msg3.NID_LRBG = this.trainToLRBGMap.get(Integer.parseInt(trainID));

        //System.out.println("msg 3 LRBG: " + msg3.NID_LRBG);
        msg3.Packet_15 = makeP15(nextMaDistance);
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

        ArrayList<Packet_27.Packet_27_StaticSpeedProfileSection> sectionList = new ArrayList<>();

        p27SSP.sections = sectionList;
        packet27.Q_SCALE = ETCSVariables.Q_SCALE_1M;
        packet27.speedProfile = p27SSP;

        ArrayList<Packet_27.Packet_27_StaticSpeedProfile> profileList = new ArrayList<>();

        for(int i = 2; i < tsp.length; i += 2) {

            p27SSP = new Packet_27.Packet_27_StaticSpeedProfile(tsp[i], tsp[i + 1] / 5, true);
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
