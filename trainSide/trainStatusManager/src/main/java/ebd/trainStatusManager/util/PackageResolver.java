package ebd.trainStatusManager.util;

import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.NewPositionReportParametersEvent;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_58;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.dataConstructs.IncrementalPositionReportDistances;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;

import java.util.*;

public class PackageResolver {

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

        if(p58.T_CYCLOC < ETCSVariables.T_CYCLOC){
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

        IncrementalPositionReportDistances iprd = new IncrementalPositionReportDistances(String.valueOf(nid_lrbg), p58.intervals);

        Map<String,Object> changes = new HashMap<>();
        changes.put("T_CYCLOC", t_cycle);
        changes.put("D_CYCLOC", d_cycle);
        changes.put("M_LOC", m_loc);
        changes.put("incremetalPositionReportDistances", iprd);
        localBus.post(new TrainDataMultiChangeEvent("tsm", Collections.singletonList("td"), changes));
        localBus.post( new NewPositionReportParametersEvent("tsm", Collections.singletonList("all")));
    }
}
