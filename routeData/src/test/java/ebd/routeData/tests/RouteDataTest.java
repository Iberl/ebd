package ebd.routeData.tests;

import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.routeData.RouteDataMultiChangeEvent;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.routeData.RouteData;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class RouteDataTest {

    @Test
    public void mainTest() throws InterruptedException {

        RDTestHandler RDTestHandler = new RDTestHandler();

        RouteData trainData = new RouteData(EventBus.getDefault());

        Thread.sleep(100);

        RouteDataChangeEvent routeDataChangeEvent = new RouteDataChangeEvent("test",new ArrayList<String>(),"packet_21",new Packet_21());

        EventBus.getDefault().post(routeDataChangeEvent);

        HashMap<String,Object> nameToValue = new HashMap<>();
        nameToValue.put("packet_15", new Packet_15());
        nameToValue.put("packet_27", new Packet_27());

        EventBus.getDefault().post( new RouteDataMultiChangeEvent("test", new ArrayList<>(), nameToValue));


    }

}