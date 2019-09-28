package ebd.drivingDynamics;

import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.ActionSelector;
import ebd.drivingDynamics.util.actions.NoAction;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
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
    private EventBus localBus;

    public DrivingProfile(String pathToProfile, EventBus localBus) throws DDBadDataException, IOException, ParseException {
        this.localBus = localBus;
        loadProfileFromFile(pathToProfile);
    }


    public Action actionToTake(){
        for(Action action : actions){
            if(action.eval()){
                return action;
            }
        }
        return new NoAction(localBus);
    }

    private void loadProfileFromFile(String pathToProfile) throws DDBadDataException, IOException, ParseException {
        InputStream inputStream;
        try{
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathToProfile);
        }
        catch (NullPointerException npe){
            IllegalArgumentException iAE = new IllegalArgumentException("This file could not be found: " + pathToProfile);
            this.localBus.post(new TrainDataExceptionEvent("td", Collections.singletonList("tsm"), new NotCausedByAEvent(), iAE));
            return;
        }

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            JSONParser jsonParser = new org.json.simple.parser.JSONParser();
            Object object = jsonParser.parse(bufferedReader);

            jsonToProfile((JSONObject)object);
        }
    }

    private void jsonToProfile(JSONObject jsonObject) throws DDBadDataException {

        if(jsonObject.containsKey("actions")){
            this.actions = new ArrayList<>();
            JSONArray jsonArray = (JSONArray)jsonObject.get("actions");
            for(Object object : jsonArray){
                JSONObject tempJSON = (JSONObject)object;
                this.actions.add(ActionSelector.select(tempJSON, this.localBus));
            }
        }
        else throw new DDBadDataException("The key 'actions' was missing from a DrivingProfile.");
    }

}
