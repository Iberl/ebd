package ebd.etcsCore;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.configHandler.TrainsHandler;
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
    private TrainsHandler th = TrainsHandler.getInstance();
    private Map<Integer, TrainStatusManager> trainMap;


    public TrainManager() throws IOException {
        this.globalBus = EventBus.getDefault();
        this.trainMap = new HashMap<>();
        addTrains();
    }

    /**
    * @see TrainsHandler#addTrain(int, int, int, String, int, int, boolean, String, boolean, int)
    *
    * @param etcsID The etcs ID of the train
    * @param trainConfigID The train config ID used to communicate with the TrainConfig tool
    * @param infrastructureID The infrastructure ID used to communicate with the model train
    * @param trainScheduleID The train schedule ID
    * @param rbcID The ID of the RBC commanding this train
    * @param startingBaliseGroup The Balise Group at starting position.
    * @param startingTrack The starting Track on the ModelInfrastructure
    * @param startingDirection The direction on the track (true means forward)
    */
    public void addTrain(int etcsID,
                         int trainConfigID,
                         int infrastructureID,
                         String trainScheduleID,
                         int rbcID,
                         int startingBaliseGroup,
                         boolean startingDirectionDir,
                         String startingTrack,
                         boolean startingDirection,
                         int startingIncrement){
        this.th.addTrain(etcsID,
                trainConfigID,
                infrastructureID,
                trainScheduleID,
                rbcID,
                startingBaliseGroup,
                startingDirectionDir,
                startingTrack,
                startingDirection,
                startingIncrement);
        TrainStatusManager tsm = new TrainStatusManager(etcsID, trainConfigID, infrastructureID, rbcID);
        this.trainMap.put(etcsID, tsm);
    }

    public void removeTrain(int etcsID, boolean trainKill){
        this.th.removeTrain(etcsID);
        TrainStatusManager tsm = this.trainMap.remove(etcsID);
        if(tsm != null && trainKill) tsm.kill();
    }

    @Subscribe
    public void listenToRemoveTrain(RemoveTrainEvent rte){
        if(rte.source.contains(String.valueOf(rte.etcsID))) removeTrain(rte.etcsID, false);
        else removeTrain(rte.etcsID, true);
    }

    private void addTrains(){
        Set<Integer> trains = this.th.getEtcsIDs();
        for(int etcsID : trains){
            TrainStatusManager tsm = new TrainStatusManager(etcsID, this.th.getTrainConfiguratorID(etcsID),
                    this.th.getInfrastructureID(etcsID), this.th.getRBCID(etcsID));
            this.trainMap.put(etcsID, tsm);
        }
    }
}
