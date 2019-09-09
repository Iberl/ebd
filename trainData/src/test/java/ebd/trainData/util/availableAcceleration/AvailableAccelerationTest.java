package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.routeData.RouteData;
import ebd.trainData.TrainData;
import ebd.trainData.tests.TDTestHandler;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AvailableAccelerationTest {

    @BeforeAll
    static void beforeAll(){
        TDTestHandler th = new TDTestHandler();
    }

    @Test
    void aaTest() {
        EventBus eb = EventBus.getDefault();
        List<String> targetList = Arrays.asList(new String[]{"all"});
        RouteData routeData = new RouteData(eb);
        TrainData trainData = new TrainData(eb, "test650.json");

        eb.post(new RouteDataChangeEvent("test",targetList, "packet_21", getp21()));
        eb.post(new TrainDataChangeEvent("test", targetList, "availableAcceleration", new AvailableAcceleration(eb)));

    }

    private Packet_21 getp21(){
        int[] gp = {0,1,100,2,100,0,100,-1};
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
}