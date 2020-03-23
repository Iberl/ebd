package ebd.szenario;

import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.szenario.RemoveTrainEvent;
import ebd.trainStatusManager.TrainStatusManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrainManager {

    public static class TrainDescriptions {

        private Map<Integer, Object[]> map;

        private TrainDescriptions() {
            this.map = new HashMap<>();
        }

        public void addTrain(int etcsID, int trainConfigID, int infrastructureID, String trainScheduleID, int rbcID){
            this.map.put(etcsID, new Object[]{trainConfigID, infrastructureID, trainScheduleID, rbcID});
        }

        public void removeTrain(int etcsID){
            this.map.remove(etcsID);
        }

        /**
         *
         * @return
         */
        public Set<Integer> getEtcsIDs(){
            return this.map.keySet();
        }

        /**
         * @param etcsID The etcsID
         * @return TrainConfiguratorID
         */
        public int getTrainConfiguratorID(int etcsID){
            return (int)this.map.get(etcsID)[0];
        }

        /**
         * @param etcsID The etcsID
         * @return InfrastructureID
         */
        public int getInfrastructureID(int etcsID){
            return (int)this.map.get(etcsID)[1];
        }

        /**
         * @param etcsID The etcsID
         * @return TrainScheduleID
         */
        public String getTrainScheduleID(int etcsID){
            return (String)this.map.get(etcsID)[2];
        }

        /** @param etcsID The etcsID
         * @return RBC ID
         */
        public int getRBCID(int etcsID){
            return (int)this.map.get(etcsID)[3];
        }
    }

    private final EventBus globalBus;
    private final ConfigHandler ch = ConfigHandler.getInstance();
    private Map<Integer, TrainStatusManager> trainMap;
    private TrainDescriptions td;


    public TrainManager() throws IOException {
        this.globalBus = EventBus.getDefault();
        this.td = new TrainDescriptions();
        this.trainMap = new HashMap<>();
        parseInitFile();
        addTrains();
    }

    public void addTrain(int etcsID, int trainConfigID, int infrastructureID, String trainScheduleID, int rbcID){
        this.td.addTrain(etcsID, trainConfigID, infrastructureID, trainScheduleID, rbcID);
        TrainStatusManager tsm = new TrainStatusManager(etcsID, trainConfigID, infrastructureID, rbcID);
        this.trainMap.put(etcsID, tsm);
    }

    public void removeTrain(int etcsID, boolean trainKill){
        this.td.removeTrain(etcsID);
        TrainStatusManager tsm = this.trainMap.remove(etcsID);
        if(tsm != null && trainKill) tsm.kill();
    }

    @Subscribe
    public void listenToRemoveTrain(RemoveTrainEvent rte){
        removeTrain(rte.etcsID, false);
    }

    private void addTrains(){
        Set<Integer> trains = this.td.getEtcsIDs();
        for(int etcsID : trains){
            TrainStatusManager tsm = new TrainStatusManager(etcsID, this.td.getTrainConfiguratorID(etcsID),
                    this.td.getInfrastructureID(etcsID), this.td.getRBCID(etcsID));
            this.trainMap.put(etcsID, tsm);
        }
    }

    private void parseInitFile() throws IOException {
        createInitFile();

        String[] stringArray;
        try(BufferedReader reader = new BufferedReader(new FileReader("configuration/initFile.txt"))){
            stringArray = reader.lines().toArray(String[]::new);
        }

        for(String string : stringArray){
            if(string.contains("#") || string.isBlank()) continue;
            String[] split = string.split(" ");
            int etcsID = 0;
            int infrastructureID = 0;
            int trainConfigID = 0;
            String trainScheduleID = "";
            int rbcID = 0;
            try{
                etcsID = Integer.parseInt(split[0]);
                infrastructureID = Integer.parseInt(split[1]);
                trainConfigID = Integer.parseInt(split[2]);
                trainScheduleID = split[3];
                rbcID = Integer.parseInt(split[4]);
            }
            catch (NumberFormatException nfe){
                System.err.println("The initFile had non numbers in a number variable: " + string);
                nfe.printStackTrace();
                System.exit(-1);
            }
            this.td.addTrain(etcsID,infrastructureID,trainConfigID,trainScheduleID, rbcID);
        }
    }

    private void createInitFile() throws IOException {
        /*
        Setting up initFile.txt file if it does not already exists
         */
        File initFile = new File("configuration/initFile.txt");

        if (initFile.length() == 0) {
            boolean createdDir = initFile.getParentFile().mkdir();
            boolean createdFile = initFile.createNewFile();
            if(!createdFile && !initFile.exists()){
                throw new IOException("initFile.txt could not be created");
            }

            try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("initFile")) {

                if(inputStream == null) {
                    throw new IOException("The stream initFile could not be found");
                }

                try (FileOutputStream outputStream = new FileOutputStream(initFile)) {
                    int length;
                    byte[] buffer = new byte[1024];
                    while ((length = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, length);
                    }
                }catch (IOException ioe){
                    throw new IOException("InitFile file could not be created. " + ioe.getMessage());
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
                try(FileInputStream inputStream = new FileInputStream("initFile")) {

                    try (FileOutputStream outputStream = new FileOutputStream("configuration/initFile.txt")) {
                        int length;
                        byte[] buffer = new byte[1024];
                        while ((length = inputStream.read(buffer)) != -1){
                            outputStream.write(buffer,0,length);
                        }
                    }catch (IOException ioe3){
                        throw new IOException("InitFile file could not be created: " + ioe3.getMessage());
                    }
                }catch (IOException ioe2){
                    throw new IOException(ioe2.getMessage());
                }
            }
        }
    }
}
