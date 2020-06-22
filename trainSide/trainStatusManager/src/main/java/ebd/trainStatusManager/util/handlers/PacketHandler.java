package ebd.trainStatusManager.util.handlers;

import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.routeData.RouteDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.SwitchInfrastructureDirectionEvent;
import ebd.globalUtils.events.trainStatusMananger.NewMaRequestParametersEvent;
import ebd.globalUtils.events.trainStatusMananger.NewPositionReportParametersEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.*;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.util.StringUtil;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.dataConstructs.IncrPosRprtDist;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;

import java.util.*;

/**
 * This class deals with optional packages that come up in {@link MessageHandler}
 *
 *
 * @author Lars Schulze-Falck
 */
public class PacketHandler {

    /**
     * //TODO Check if nid_lrbg == link.NID_BG
     * @param localBus
     * @param nid_lrbg
     * @param trackPacket
     */
    public static void p5(EventBus localBus, int nid_lrbg, Packet_5 trackPacket) {
        double scale = Math.pow(10, trackPacket.Q_DIR - 1);
        HashMap<Integer, Location> linkingMap = new HashMap<>();
        Location tempLoc = new Location(trackPacket.link.NID_BG, nid_lrbg, trackPacket.link.D_LINK * scale );
        linkingMap.put(trackPacket.link.NID_BG,tempLoc);
        int prevLoc = trackPacket.link.NID_BG;
        for(Packet_5.Packet_5_Link link : trackPacket.links){
            tempLoc = new Location(link.NID_BG,prevLoc,link.D_LINK * scale);
            linkingMap.put(link.NID_BG, tempLoc);
            prevLoc = link.NID_BG;
        }
        localBus.post(new RouteDataChangeEvent("tsm", "rd", "linkingInformation", linkingMap));
        localBus.post(new ToLogEvent("tsm", "log", "Received new Linking Information [Packet 5]"));
    }

    public static void p57(EventBus localBus, Packet_57 p57){
        TrainDataVolatile trainDataVolatile = localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        Position curPos = trainDataVolatile.getCurrentPosition();

        if((curPos.isDirectedForward() && p57.Q_DIR == 0) //Only react to the package if it is orientated in the same direction as the train
                || (!curPos.isDirectedForward() && p57.Q_DIR == 1)){
            return;
        }

        int t_mar = p57.T_MAR;
        int t_timeoutrqst = p57.T_TIMEOUTRQST;
        int t_cycrqst = p57.T_CYCRQST;

        Map<String,Object> changes = new HashMap<>();
        changes.put("T_MAR", t_mar);
        changes.put("T_CYCRQST", t_cycrqst);
        changes.put("T_TIMEOUTRQST", t_timeoutrqst);
        localBus.post(new TrainDataMultiChangeEvent("tsm", "td", changes));
        localBus.post( new NewMaRequestParametersEvent("tsm", "all"));
        localBus.post(new ToLogEvent("tsm", "log", "Got new MA Request Parameters [Packet 57]"));

    }

    public static void p58(EventBus localBus, int nid_lrbg, Packet_58 p58){
        TrainDataVolatile trainDataVolatile = localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        Position curPos = trainDataVolatile.getCurrentPosition();

        if((curPos.isDirectedForward() && p58.Q_DIR == 0) //Only react to the package if it is orientated in the same direction as the train
                || (!curPos.isDirectedForward() && p58.Q_DIR == 1)){
            return;
        }

        double scale = Math.pow(10, p58.Q_SCALE - 1); //Sets the scale to convert to [m]
        int t_cycle;
        double d_cycle;
        int m_loc;

        if(p58.T_CYCLOC < ETCSVariables.T_CYCLOC_INFINITY){
            t_cycle = p58.T_CYCLOC;
        }
        else {
            t_cycle = Integer.MAX_VALUE;
        }
        if(p58.D_CYCLOC < ETCSVariables.D_CYCLOC_NO_CYCLIC_REPORT){
            d_cycle = p58.D_CYCLOC * scale;
        }
        else {
            d_cycle = Double.MAX_VALUE;
        }
        m_loc = p58.M_LOC;

        IncrPosRprtDist iprd = new IncrPosRprtDist(String.valueOf(nid_lrbg), p58.intervals);

        Map<String,Object> changes = new HashMap<>();
        changes.put("T_CYCLOC", t_cycle);
        changes.put("distanceCycleLocation", d_cycle);
        changes.put("M_LOC", m_loc);
        changes.put("incrPosRprtDist", iprd);
        localBus.post(new TrainDataMultiChangeEvent("tsm", "td", changes));
        localBus.post( new NewPositionReportParametersEvent("tsm", "all"));
        localBus.post(new ToLogEvent("tsm", "log", "Got new Position Report Parameters [Packet 58]"));
    }

    public static void p72(EventBus localBus, Packet_72 trackPacket) {
        List<Packet_72.Packet_72_Character> charList = trackPacket.X_TEXT;
        StringBuilder sb = new StringBuilder();
        for(Packet_72.Packet_72_Character letter : charList){
            byte temp = (byte)letter.X_TEXT;
            sb.append(StringUtil.toISO88591_Char(temp));

        }
        String xText = sb.toString();

        if("rich".equalsIgnoreCase(xText)){
            localBus.post(new SwitchInfrastructureDirectionEvent("tsm", "tsm"));
        }
        localBus.post(new ToLogEvent("tsm", "log", "Got a text message [Paket 72]: " + xText));
    }

    public static void p80(EventBus localBus, Packet_80 p80){
        localBus.post(new RouteDataChangeEvent("tsm", "rd", "packet_80", p80));
    }
}
