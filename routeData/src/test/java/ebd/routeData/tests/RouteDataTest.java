package ebd.routeData.tests;

import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.routeData.RouteData;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class RouteDataTest {

    @Test
    public void mainTest() throws InterruptedException {

        RDTestHandler RDTestHandler = new RDTestHandler();

        RouteData trainData = new RouteData(EventBus.getDefault());

        Thread.sleep(100);

        RouteDataChangeEvent routeDataChangeEvent = new RouteDataChangeEvent("test",new ArrayList<String>(),"packet_21",new Packet_21());

        EventBus.getDefault().post(routeDataChangeEvent);




    }

}