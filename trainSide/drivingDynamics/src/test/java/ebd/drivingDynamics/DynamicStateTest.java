package ebd.drivingDynamics;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.movementState.MovementState;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.routeData.RouteData;
import ebd.trainData.TrainData;
import ebd.trainData.util.availableAcceleration.AvailableAcceleration;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DynamicStateTest {
    @BeforeAll
    static void beforeAll(){
        Testhandler th = new Testhandler();
    }

    @Test
    void nextState() {
        EventBus eb = EventBus.getDefault();
        String target = "all";
        RouteData routeData = new RouteData(eb);
        ConfigHandler.getInstance().useTrainConfiguratorTool = true;
        TrainData trainData = new TrainData(eb, 1, 192, 3);

        eb.post(new RouteDataChangeEvent("test", target, "packet_21", getp21()));

        AvailableAcceleration aa = new AvailableAcceleration(eb);
        Location curLoc = new Location(ETCSVariables.NID_LRBG_UNKNOWN, ETCSVariables.NID_LRBG_UNKNOWN, ETCSVariables.Q_DIR_NOMINAL, 0d);
        List<Location> prevLoc = eb.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile.getPreviousLocations();
        if(prevLoc == null){
            prevLoc = new ArrayList<>();
        }
        prevLoc.add(curLoc);
        Position curPos = new Position(0, true, curLoc);

        eb.post(new TrainDataChangeEvent("test", target, "availableAcceleration", aa));
        eb.post(new TrainDataChangeEvent("test", target, "previousLocations", prevLoc));
        eb.post(new TrainDataChangeEvent("test", target, "currentPosition", curPos));

        DynamicState dynamicState = new DynamicState(curPos,aa);
        assertEquals(0d,dynamicState.getSpeed());
        dynamicState.setMovementState(MovementState.ACCELERATING);
        dynamicState.nextState(0.1);
        System.out.println(dynamicState.getSpeed());
        dynamicState.nextState(0.1);
        System.out.println(dynamicState.getSpeed());
        dynamicState.setMovementState(MovementState.BREAKING);
        dynamicState.setBreakingModification(0);
        dynamicState.nextState(0.1);
        System.out.println(dynamicState.getSpeed());
        dynamicState.setBreakingModification(1);
        dynamicState.nextState(0.1);
        System.out.println(dynamicState.getSpeed());
        dynamicState.nextState(0.1);
        System.out.println(dynamicState.getSpeed());
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