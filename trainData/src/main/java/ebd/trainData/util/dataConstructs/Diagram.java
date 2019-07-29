package ebd.trainData.util.dataConstructs;

import ebd.trainData.util.exceptions.TDBadDataException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Diagram showing the efficiency of a engine.
 * The data is saved in a List of {@link DiagramRow}
 */
public class Diagram {

    /**
     * Can be empty!
     */
    private List<DiagramRow> diagramRows;

    /**
     * Constructor setting the Diagram out of a jsonObject. Should the Diagram be empty, this Diagram only contains a
     * empty list.
     *
     * @param jsonObject {@link JSONObject} containing one full Diagram
     *
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
    public Diagram(JSONObject jsonObject) throws TDBadDataException {
        diagramRows = new ArrayList<>();
        fillFromJSON(jsonObject);
    }

    /**
     * Parses the jsonObject. The list of digramRows stays empty should the diagram be empty
     *
     * @param jsonObject containing one diagram
     * @throws TDBadDataException Gets thrown if expected data is missing in the JSONobject
     */
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
