package ebd.drivingDynamics;

import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.ActionSelector;
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

public class DrivingProfile {

    private List<Action> actions;
    private EventBus localEventBusBus;

    public DrivingProfile(EventBus localEventBus) throws DDBadDataException, IOException, ParseException {
        this.localEventBusBus = localEventBus;
        loadProfileFromFile();
    }


    public Action actionToTake(){
        for(Action action : actions){
            if(action.eval()){
                return action;
            }
        }
        return new NoAction(localEventBusBus);
    }

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
            this.localEventBusBus.post(new TrainDataExceptionEvent("td", Collections.singletonList("tsm"), new NotCausedByAEvent(), iAE));
            return;
        }


    }

    private void jsonToProfile(JSONObject jsonObject) throws DDBadDataException {

        if(jsonObject.containsKey("actions")){
            this.actions = new ArrayList<>();
            JSONArray jsonArray = (JSONArray)jsonObject.get("actions");
            for(Object object : jsonArray){
                JSONObject tempJSON = (JSONObject)object;
                this.actions.add(ActionSelector.select(tempJSON, this.localEventBusBus));
            }
        }
        else throw new DDBadDataException("The key 'actions' was missing from a DrivingProfile.");
    }

}
