package ebd.drivingDynamics;

import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.ActionParser;
import ebd.drivingDynamics.util.actions.NoAction;
import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.globalUtils.fileHandler.FileHandler;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * DrivingStrategy represents the driver of the train.
 * It takes a json file and parses it into a list of {@link Action}, every action containing a list of conditions.
 * @author LSF
 */
public class DrivingStrategy {

    private List<Action> actions;
    private final EventBus localEventBus;

    static class SortByPriority implements Comparator<Action>{
        //Note: this comparator imposes orderings that are inconsistent with equals.
        @Override
        public int compare(Action a1, Action a2) {
            return a1.getPriority() - a2.getPriority();
        }
    }

    public DrivingStrategy(EventBus localEventBus) throws DDBadDataException, IOException, ParseException {
        this.localEventBus = localEventBus;
        loadProfileFromFile();
    }

    /**
     * Iterates through all actions saved in the driving profile and returns the first action that returns true, which
     * means that all conditions of this action returned true.
     * @return First {@link Action} that returns true
     */
    public Action actionToTake(){
        for(Action action : actions){
            if(action.eval()){
                return action;
            }
        }
        return new NoAction(localEventBus);
    }
    /**
     * Opens json file and parses the contends
     * @throws DDBadDataException Missing data in the file.
     * @throws IOException If the file can not be found or read
     * @throws ParseException If the file can not parsed, indicating faulty json formatting.
     */
    private void loadProfileFromFile() throws DDBadDataException, IOException, ParseException {
        String fileName = ConfigHandler.getInstance().pathToDriverStrategyJson;
        String pathToProfile = "strategies/" + fileName;



        try(FileReader fileReader = FileHandler.readerConfigurationFileOrDefault(pathToProfile, fileName)){
            try(BufferedReader input = new BufferedReader(fileReader)){

            /*
            Reading the input data into the variables
            */
                JSONParser parser = new JSONParser();
                Object object = parser.parse(input);
                JSONObject jsonObject = (JSONObject) object;

                jsonToProfile(jsonObject);
            }
        }
        catch (NullPointerException npe){
            IllegalArgumentException iAE = new IllegalArgumentException("This file could not be found: " + pathToProfile);
            this.localEventBus.post(new DrivingDynamicsExceptionEvent("td", "tsm", new NotCausedByAEvent(), iAE));
            return;
        }


    }


    /**
     * Parses a json object
     * @param jsonObject A {@link JSONObject}
     * @throws DDBadDataException Missing data in the file.
     */
    private void jsonToProfile(JSONObject jsonObject) throws DDBadDataException {

        if(jsonObject.containsKey("actions")){
            this.actions = new ArrayList<>();
            JSONArray jsonArray = (JSONArray)jsonObject.get("actions");
            for(Object object : jsonArray){
                JSONObject tempJSON = (JSONObject)object;
                this.actions.add(ActionParser.parse(tempJSON, this.localEventBus));
            }
        }
        else throw new DDBadDataException("The key 'actions' was missing from a DrivingStrategy.");

        actions.sort(new SortByPriority());
    }

}
