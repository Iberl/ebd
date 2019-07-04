package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Diagram {

    List<DiagramRow> diagramRows;

    public Diagram(JSONObject jsonObject) throws TDBadDataException {
        diagramRows = new ArrayList<>();
        fillFromJSON(jsonObject);
    }

    private void fillFromJSON(JSONObject jsonObject) throws TDBadDataException {
        JSONArray jsonArray;

        //TODO Better solution for empty Diagrams
        if (jsonObject.keySet().isEmpty()){
            System.out.println("-Diagram was empty-");
            return;
        }

        if(jsonObject.containsKey("Zeilen")){
            jsonArray = (JSONArray)jsonObject.get("Zeilen");
        }
        else throw new TDBadDataException("The key 'Zeilen' was missing in the trainCar data send by the tool TrainConfigurator");

        for(Object item : jsonArray){
            this.diagramRows.add(new DiagramRow((JSONObject)item));
        }
    }

    /*
    Getter
     */
    public List<DiagramRow> getDiagramRows() {
        return diagramRows;
    }
}
