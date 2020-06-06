package ebd.szenario;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.configHandler.InitFileHandler;
import ebd.globalUtils.szenario.RemoveTrainEvent;
import ebd.trainStatusManager.TrainStatusManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrainManager {

    private final EventBus globalBus;
    private final ConfigHandler ch = ConfigHandler.getInstance();
    private InitFileHandler iFH = InitFileHandler.getInstance();
    private Map<Integer, TrainStatusManager> trainMap;


    public TrainManager() throws IOException {
        this.globalBus = EventBus.getDefault();
        this.trainMap = new HashMap<>();
        addTrains();
    }

    public void addTrain(int etcsID,
                         int trainConfigID,
                         int infrastructureID,
                         String trainScheduleID,
                         int rbcID,
                         int startingBaliseGroup,
                         String startingTrack,
                         boolean startingDirection){
        this.iFH.addTrain(etcsID,
                trainConfigID,
                infrastructureID,
                trainScheduleID,
                rbcID,
                startingBaliseGroup,
                startingTrack,
                startingDirection);
        TrainStatusManager tsm = new TrainStatusManager(etcsID, trainConfigID, infrastructureID, rbcID);
        this.trainMap.put(etcsID, tsm);
    }

    public void removeTrain(int etcsID, boolean trainKill){
        this.iFH.removeTrain(etcsID);
        TrainStatusManager tsm = this.trainMap.remove(etcsID);
        if(tsm != null && trainKill) tsm.kill();
    }

    @Subscribe
    public void listenToRemoveTrain(RemoveTrainEvent rte){
        removeTrain(rte.etcsID, false);
    }

    private void addTrains(){
        Set<Integer> trains = this.iFH.getEtcsIDs();
        for(int etcsID : trains){
            TrainStatusManager tsm = new TrainStatusManager(etcsID, this.iFH.getTrainConfiguratorID(etcsID),
                    this.iFH.getInfrastructureID(etcsID), this.iFH.getRBCID(etcsID));
            this.trainMap.put(etcsID, tsm);
        }
    }
}
