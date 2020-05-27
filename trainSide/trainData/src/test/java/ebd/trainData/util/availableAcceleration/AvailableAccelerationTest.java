package ebd.trainData.util.availableAcceleration;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.movementState.MovementState;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.routeData.RouteData;
import ebd.trainData.TrainData;
import ebd.trainData.tests.TDTestHandler;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
    void aaTest() throws IOException {
        EventBus eb = EventBus.getDefault();
        String target = "all";
        RouteData routeData = new RouteData(eb);
        ConfigHandler.getInstance().useTrainConfiguratorTool = true;
        TrainData trainData = new TrainData(eb,1,192,3);

        eb.post(new RouteDataChangeEvent("test",target, "packet_21", getp21()));
        AvailableAcceleration aa = new AvailableAcceleration(eb);
        eb.post(new TrainDataChangeEvent("test", target, "availableAcceleration", aa));


        assertEquals(0.44,aa.getAcceleration(0,0, MovementState.ACCELERATING),0.001);
        assertEquals(0.43,aa.getAcceleration(50,150, MovementState.ACCELERATING),0.001);
        assertEquals(-0.73,aa.getAcceleration(40,200, MovementState.BREAKING),0.001);
        assertEquals(0.0,aa.getAcceleration(40,100, MovementState.CRUISE));
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