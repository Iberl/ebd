package ebd.drivingDynamics;

import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.ActionParser;
import ebd.drivingDynamics.util.actions.NoAction;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.trainData.util.events.TrainDataExceptionEvent;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Driving Profile represents the driver of the train.
 * It takes a json file and parses it into a list of {@link Action}, every action containing a list of conditions.
 * @author LSF
 */
public class DrivingProfile {

    private List<Action> actions;
    private EventBus localEventBus;

    public DrivingProfile(EventBus localEventBus) throws DDBadDataException, IOException, ParseException {
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
        String pathToProfile = ConfigHandler.getInstance().pathToDriverProfileJson;
        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathToProfile)){
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
                JSONParser jsonParser = new org.json.simple.parser.JSONParser();
                Object object = jsonParser.parse(bufferedReader);

                jsonToProfile((JSONObject)object);
            }
        }
        catch (NullPointerException npe){
            IllegalArgumentException iAE = new IllegalArgumentException("This file could not be found: " + pathToProfile);
            this.localEventBus.post(new TrainDataExceptionEvent("td", Collections.singletonList("tsm"), new NotCausedByAEvent(), iAE));
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
        else throw new DDBadDataException("The key 'actions' was missing from a DrivingProfile.");
    }

}
