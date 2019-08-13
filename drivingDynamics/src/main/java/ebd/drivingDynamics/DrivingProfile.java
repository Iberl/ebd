package ebd.drivingDynamics;

import ebd.drivingDynamics.util.actions.Action;
import ebd.drivingDynamics.util.actions.ActionSelector;
import ebd.drivingDynamics.util.actions.NoAction;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DrivingProfile {

    private List<Action> actions;
    private EventBus eventBus;

    public DrivingProfile(String pathToProfile, EventBus eventBus){
        this.eventBus = eventBus;
        loadProfileFromFile(pathToProfile);

    }


    public Action actionToTake(){
        for(Action action : actions){
            if(action.eval()){
                return action;
            }
        }
        return new NoAction(eventBus);
    }

    private void loadProfileFromFile(String pathToProfile){
        try(FileReader fileReader = new FileReader(pathToProfile)){
            JSONParser jsonParser = new org.json.simple.parser.JSONParser();
            Object object = jsonParser.parse(fileReader);

            jsonToProfile((JSONObject)object);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (DDBadDataException e) {
            e.printStackTrace();
        }
    }

    private void jsonToProfile(JSONObject jsonObject) throws DDBadDataException {

        if(jsonObject.containsKey("actions")){
            JSONArray jsonArray = (JSONArray)jsonObject.get("actions");
            for(Object object : jsonArray){
                JSONObject tempJSON = (JSONObject)object;
                this.actions.add(ActionSelector.select(tempJSON, this.eventBus));
            }
        }
        else throw new DDBadDataException("The key 'actions' was missing from a DrivingProfile.");
    }

}
