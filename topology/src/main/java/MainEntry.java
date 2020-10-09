import de.ibw.feed.Balise;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;

/**
 * Diese Klasse Demonstriert Topologie und Balisen fetch
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-09-14
 */
public class MainEntry {

    public static void main(String[] args) {
        // füllt Balisen und Topologie
        PlanData.getInstance();
        System.out.println("Saved Edges: " + getGraph().EdgeRepo.size());
        System.out.println("Saved Balises " + getBalises().getAll().size());
        while(true);
    }

    /**
     * Holt kompletten Graph
     * @return TopologyGraph
     */
    public static TopologyGraph getGraph() {
        PlanData.getInstance();
        return PlanData.topGraph;
    }

    /**
     * Holt Balise mit key als Nid-Engine-Id; bis jetzt ein Hashwert der Balise
     * @return DefaultRepo - Repository von Balisen - eine erweiterte HashMap
     */
    public static DefaultRepo<Integer, Balise> getBalises() {
        PlanData.getInstance();
        return Balise.baliseByNid_bg;
    }

}
