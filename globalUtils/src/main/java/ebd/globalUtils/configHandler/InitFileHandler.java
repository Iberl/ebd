package ebd.globalUtils.configHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InitFileHandler {

    private static InitFileHandler instance = new InitFileHandler();
    private Map<Integer, Object[]> map;

    /**
     * Set to private to prevent initiation
     */
    private InitFileHandler(){
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
     * InitFileHandler loads the initFile.txt in which the startup configuration is saved.
     * It allows for trains to be added and removed.
     * Because of this, you can never assume that a train exists as it could have been removed between calls
     * @return A singleton Instance InitFileHandler
     */
    public static InitFileHandler getInstance() {
        return instance;
    }

    /**
     *
     * @param etcsID The etcs ID of the train
     * @param trainConfigID The train config ID used to communicate with the TrainConfig tool
     * @param infrastructureID The infrastructure ID used to communicate with the model train
     * @param trainScheduleID The train schedule ID
     * @param rbcID The ID of the RBC commanding this train
     */
    public synchronized void addTrain(int etcsID, int trainConfigID, int infrastructureID, String trainScheduleID, int rbcID){
        this.map.put(etcsID, new Object[]{trainConfigID, infrastructureID, trainScheduleID, rbcID});
    }

    /**
     * Removes the train specified under the ETCS ID from the {@link InitFileHandler}
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
        Object get = this.map.get(etcsID)[0];
        return (get != null) ? (int)get : null;
    }

    /**
     * @param etcsID The etcsID
     * @return InfrastructureID or {@code null} if the ETCS ID is not fond
     */
    public synchronized Integer getInfrastructureID(int etcsID){
        Object get = this.map.get(etcsID)[1];
        return (get != null) ? (int)get : null;
    }

    /**
     * @param etcsID The etcsID
     * @return TrainScheduleID or {@code null} if the ETCS ID is not fond
     */
    public synchronized String getTrainScheduleID(int etcsID){
        Object get = this.map.get(etcsID)[2];
        return (get != null) ? (String)get : null;
    }

    /** @param etcsID The etcsID
     * @return RBC ID or {@code null} if the ETCS ID is not fond
     */
    public synchronized Integer getRBCID(int etcsID){
        Object get = this.map.get(etcsID)[3];
        return (get != null) ? (int)get : null;
    }

    /**
     * Reads and parses the initFile.txt
     *
     * @throws IOException If there is an Exception reading the initFile
     */
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
            this.addTrain(etcsID,infrastructureID,trainConfigID,trainScheduleID, rbcID);
        }
    }

    /**
     * Creates the InitFile.txt out of the initFile default if it does not already exists.
     *
     * @throws IOException If there is an Exception reading the initFile
     */
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
