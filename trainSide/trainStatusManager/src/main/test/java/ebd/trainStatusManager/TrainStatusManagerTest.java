package ebd.trainStatusManager;

import ebd.globalUtils.events.DisconnectEvent;
import ebd.globalUtils.events.messageReceiver.ReceivedMessageEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.message.trackmessages.Message_3;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.*;

class TrainStatusManagerTest {

    @Test
    public void tsmTest() throws InterruptedException {

        EventBus eventBus = new EventBus();
        Testhandler testhandler = new Testhandler(eventBus);
        TrainStatusManager trainStatusManager = new TrainStatusManager(eventBus, "192",
                "1", "u",
                "TestDrivingProfile.json");


        Thread.sleep(2000);
        HashMap<String,Location> prevLocs = new HashMap<>();
        Position prevPos = eventBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile.getCurrentPosition();
        prevLocs.put(prevPos.getLocation().getId(),prevPos.getLocation());
        Location curLoc = new Location("2","unknown", 10d);
        prevLocs.put(curLoc.getId(),curLoc);
        Position curPos = new Position(0d,true,curLoc,prevLocs);

        eventBus.post(new TrainDataChangeEvent("test", Collections.singletonList("td"), "currentPosition", curPos));
        eventBus.post(new ReceivedMessageEvent("test", Collections.singletonList("tsm"),makeMsg3()));

        //Thread.sleep(5000);
        trainStatusManager.join();
        eventBus.post(new DisconnectEvent("test", Collections.singletonList("tsm")));
    }

    private Message_3 makeMsg3(){
        List<TrackPacket> lop = new ArrayList<>();
        lop.add(makeP21());
        lop.add(makeP27());

        Message_3 msg3 = new Message_3();
        msg3.NID_LRBG = 2;
        msg3.Packet_15 = makeP15();
        msg3.packets = lop;



        return msg3;
    }

    private Packet_15 makeP15(){
        Packet_15 packet15 = new Packet_15();

        Packet_15.Packet_15_Section endsection = packet15.new Packet_15_Section();
        endsection.L_SECTION = 100; //m
        ArrayList<Packet_15.Packet_15_Section> sections = new ArrayList<>();

        packet15.Q_SCALE = 1;
        packet15.endsection = endsection;
        packet15.sections = sections;
        packet15.V_LOA = 0;
        return packet15;
    }

    private Packet_21 makeP21(){
        int[] gp = {0,1,100,2,100,0,100,-1}; //[m,0/00]
        Packet_21.Packet_21_Gradient gradient = new Packet_21.Packet_21_Gradient(gp[0], gp[1] >= 0, Math.abs(gp[1]));
        ArrayList<Packet_21.Packet_21_Gradient> gradients = new ArrayList<>();

        for (int i = 2; i < gp.length; i+=2) {
            Packet_21.Packet_21_Gradient tempgrad = new Packet_21.Packet_21_Gradient(gp[i], gp[i+1] >= 0, Math.abs(gp[i+1]));
            gradients.add(tempgrad);
        }
        Packet_21 packet21 = new Packet_21();
        packet21.Q_SCALE = 1;
        packet21.gradient = gradient;
        packet21.gradients = gradients;

        return packet21;
    }

    private Packet_27 makeP27(){
        int[] tsp = {0,130,900,70,900,100}; //[m,km/h]

        Packet_27 packet27 = new Packet_27();

        Packet_27.Packet_27_StaticSpeedProfile p27SSP = packet27.new Packet_27_StaticSpeedProfile(tsp[0], tsp[1] / 5, true);

        ArrayList<Packet_27.Packet_27_StaticSpeedProfileSection> sectionList = new ArrayList<>();

        p27SSP.sections = sectionList;
        packet27.Q_SCALE = 1;
        packet27.speedProfile = p27SSP;

        ArrayList<Packet_27.Packet_27_StaticSpeedProfile> profileList = new ArrayList<>();

        for (int i = 2; i < tsp.length; i+=2) {

            p27SSP = packet27.new Packet_27_StaticSpeedProfile(tsp[i],tsp[i+1] / 5,true);
            sectionList = new ArrayList<>();
            p27SSP.sections = sectionList;
            profileList.add(p27SSP);
        }
        packet27.speedProfiles = profileList;

        return packet27;
    }
}