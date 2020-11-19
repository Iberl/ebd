package ebd.globalUtils.configHandler;

import ebd.globalUtils.fileHandler.FileHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This singleton class contains the data over all values necessary to identify trains.<br>
 * It also provides and reads out the init file to provide a convenient way to initialize multiple trains.
 */
public class TrainsHandler {

    public static class Train {

        public final int etcsID;
        public final int trainConfigID;
        public final int infrastructureID;
        public final String trainScheduleID;
        public final int rbcID;

        public final int startingBaliseGroup;
        private final boolean startingMovementDir;
        public final String startingTrack;

        public final boolean startingDirection;
        private final int startingIncrement;

        /**
         * @param etcsID The etcs ID of the train
         * @param trainConfigID The train config ID used to communicate with the TrainConfig tool
         * @param infrastructureID The infrastructure ID used to communicate with the model train
         * @param trainScheduleID The train schedule ID
         * @param rbcID The ID of the RBC commanding this train
         * @param startingBaliseGroup The Balise Group at starting position.
         * @param startingMovementDir The direction of the starting balise group, true for nominal, false for reverse
         * @param startingTrack The starting Track on the ModelInfrastructure
         * @param startingDirection The direction of the train in relation to the starting balise group,
         * @param startingIncrement The starting increment (distance from the balise group) in [m]
         */
        public Train(int etcsID,
                     int trainConfigID,
                     int infrastructureID,
                     String trainScheduleID,
                     int rbcID,
                     int startingBaliseGroup,
                     boolean startingMovementDir, String startingTrack,
                     boolean startingDirection,
                     int startingIncrement) {
            this.etcsID = etcsID;
            this.trainConfigID = trainConfigID;
            this.infrastructureID = infrastructureID;
            this.trainScheduleID = trainScheduleID;
            this.rbcID = rbcID;
            this.startingBaliseGroup = startingBaliseGroup;
            this.startingMovementDir = startingMovementDir;
            this.startingTrack = startingTrack;
            this.startingDirection = startingDirection;
            this.startingIncrement = startingIncrement;
        }
    }

    private static final TrainsHandler instance = new TrainsHandler();
    private final Map<Integer, Train> map;

    /**
     * Set to private to prevent initiation
     */
    private TrainsHandler(){
        this.map = new HashMap<>();
        try {
            parseInitFile();
        } catch (IOException e) {
            System.err.println("Init File could not be loaded");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * TrainsHandler loads the initFile.txt in which the startup configuration is saved.
     * It further contains all identifying ID of a train and allows for trains to be added and removed.
     * Because of this, you can never assume that a train exists as it could have been removed between calls
     * @return A singleton Instance TrainsHandler
     */
    public static TrainsHandler getInstance() {
        return instance;
    }

    /**
     *  @param etcsID The etcs ID of the train
     * @param trainConfigID The train config ID used to communicate with the TrainConfig tool
     * @param infrastructureID The infrastructure ID used to communicate with the model train
     * @param trainScheduleID The train schedule ID
     * @param rbcID The ID of the RBC commanding this train
     * @param startingBaliseGroup The Balise Group at starting position.
     * @param startingMovementDir
     * @param startingTrack The starting Track on the ModelInfrastructure
     * @param startingDirection The direction on the track (true means forward)
     */
    public synchronized void addTrain(int etcsID,
                                      int trainConfigID,
                                      int infrastructureID,
                                      String trainScheduleID,
                                      int rbcID,
                                      int startingBaliseGroup,
                                      boolean startingMovementDir,
                                      String startingTrack,
                                      boolean startingDirection,
                                      int startingIncrement){
        this.map.put(etcsID, new Train(etcsID,
                trainConfigID,
                infrastructureID,
                trainScheduleID,
                rbcID,
                startingBaliseGroup,
                startingMovementDir,
                startingTrack,
                startingDirection,
                startingIncrement
        ));
    }

    /**
     * Removes the train specified under the ETCS ID from the {@link TrainsHandler}
     * @param etcsID The etcs ID of the train to be removed
     */
    public synchronized void removeTrain(int etcsID){
            this.map.remove(etcsID);
    }

    /**
     *
     * @return A set of all currently active ETCS IDs
     */
    public synchronized Set<Integer> getEtcsIDs(){
        return this.map.keySet();
    }

    /**
     * @param etcsID The ETCS ID
     * @return TrainConfiguratorID or {@code null} if the ETCS ID is not fond
     */
    public synchronized Integer getTrainConfiguratorID(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.trainConfigID : null;
    }

    /**
     * @param etcsID The etcsID
     * @return InfrastructureID or {@code null} if the ETCS ID is not fond
     */
    public synchronized Integer getInfrastructureID(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.infrastructureID : null;
    }

    /**
     * @param etcsID The etcsID
     * @return TrainScheduleID or {@code null} if the ETCS ID is not fond
     */
    public synchronized String getTrainScheduleID(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.trainScheduleID : null;
    }

    /**
     * @param etcsID The etcsID
     * @return RBC ID or {@code null} if the ETCS ID is not fond
     */
    public synchronized Integer getRBCID(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.rbcID : null;
    }

    /**
     * The starting balise group is the first balise group that the train is positioned on.
     * Used to initialize the train on the TMS infrastructure.
     * Has to be a valid starting balise group. If the EBD infrastructure is used, the starting track
     * and the starting balise group have to be at the <b>same</b> position
     * @param etcsID The etcsID
     * @return RBC ID or {@code null} if the ETCS ID is not fond
     */
    public synchronized Integer getStartingBaliseGroup(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.startingBaliseGroup : null;
    }

    /**
     * The direction of train movement at start in relation to the orientation of the starting balise, true for nominal, false for reverse
     * @param etcsID The etcsID
     * @return The direction of the starting balise group or {@code null} if the ETCS ID is not fond
     */
    public synchronized Boolean getStartingMovementDir(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.startingMovementDir : null;
    }

    /**
     * The starting track is the first track that the train is positioned on.
     * Used to initialize the train on the EBD infrastructure.
     * Has to be a valid starting track on the EBD infrastructure.
     * @param etcsID The etcsID
     * @return The starting track or {@code null} if the ETCS ID is not fond
     */
    public synchronized String getStartingTrack(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.startingTrack : null;
    }

    /**
     * Used to initialize the train on the EBD and TMS infrastructure.
     * Has to be a valid starting direction in both.
     * @param etcsID The etcsID
     * @return RBC ID or {@code null} if the ETCS ID is not fond
     */
    public synchronized Boolean getStartingDirection(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.startingDirection : null;
    }

    /**
     * The distance of the train from the starting balise group.
     * Used to initialize the train on the TMS infrastructure.
     * @param etcsID The etcsID
     * @return RBC ID or {@code null} if the ETCS ID is not fond
     */
    public synchronized Integer getStartingIncrement(int etcsID){
        Train train = this.map.get(etcsID);
        return (train != null) ? train.startingIncrement : null;
    }




    /**
     * Checks if a train under that etcsID is registered in {@link TrainsHandler}.
     * @param etcsID The etcsID
     * @return {@code true} if a ID is registered, {@code false} if not
     */
    public synchronized boolean isRegistered(int etcsID){
        return map.containsKey(etcsID);
    }

    /**
     * Checks if a train under that etcsID is registered in {@link TrainsHandler}.
     * @param etcsID The etcsID
     * @return {@code true} if a ID is registered, {@code false} if not, or if the String was not a number
     */
    public synchronized boolean isRegistered(String etcsID){
        try {
            return map.containsKey(Integer.valueOf(etcsID));
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Reads and parses the initFile.txt
     *
     * @throws IOException If there is an Exception reading the initFile
     */
    private void parseInitFile() throws IOException {
        String fileName = ConfigHandler.getInstance().pathToInitFile;

        String[] stringArray;
        try(BufferedReader reader = new BufferedReader(FileHandler.readConfigurationFile(fileName))){
            stringArray = reader.lines().toArray(String[]::new);
        }

        for(String string : stringArray){
            if(string.contains("#") || string.isBlank()) continue;
            string = string.replaceAll(" ", "");
            String[] split = string.split(";");
            int etcsID = 0;
            int trainConfigID = 0;
            int infrastructureID = 0;
            String trainScheduleID = "";
            int rbcID = 0;
            int startingBaliseGroup = 0;
            boolean startingMovementDir = true;
            String startingTrack = "";
            boolean startingDirection = true;
            int startingIncrement = 0;
            try{
                etcsID = Integer.parseInt(split[0]);
                trainConfigID = Integer.parseInt(split[1]);
                infrastructureID = Integer.parseInt(split[2]);
                trainScheduleID = split[3];
                rbcID = Integer.parseInt(split[4]);
                startingBaliseGroup = Integer.parseInt(split[5]);
                startingMovementDir = Boolean.parseBoolean(split[6]);
                startingTrack = split[7];
                startingDirection = Boolean.parseBoolean(split[8]);
                startingIncrement = Integer.parseInt(split[9]);

            }
            catch (NumberFormatException nfe){
                System.err.println("This line in initFile.txt had non numbers in a number variable: " + string);
                nfe.printStackTrace();
                System.exit(-1);
            }
            catch (IndexOutOfBoundsException ioobe){
                System.err.println("This line in initFile.txt had to few variables: " + string);
                ioobe.printStackTrace();
                System.exit(-1);
            }
            this.addTrain(etcsID,
                    trainConfigID,
                    infrastructureID,
                    trainScheduleID,
                    rbcID,
                    startingBaliseGroup,
                    startingMovementDir,
                    startingTrack,
                    startingDirection,
                    startingIncrement);
        }
    }
}
