package de.ibw.tms.plan_pro.adapter.topology.trackbased;

import de.ibw.feed.Balise;
import de.ibw.feed.BaliseExtractor;
import de.ibw.tms.ma.GeoCoordinates;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.ui.MainGraphicPanel;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.geodaten._1_9_0.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

/**
 * Dieses Interface gibt den Rahmen vor, was einen Topologiegenerator ausmacht.
 */
public interface ITopologyFactory {

    DefaultRepo<String, CTOPKnoten> getGeoNodeToTopNodeRepo();

    DefaultRepo<String, CGEOKnoten> getTopNodeToGeoNodeRepo();

    DefaultRepo<String, CStrecke> getTrackRepo();
    void setTopLines(List<CTOPKante> topLines);

    DefaultRepo<Class<?>, DefaultRepo<String, CBasisObjekt>> getGeoBundle();
    void setGeoBundle(DefaultRepo<Class<?>, DefaultRepo<String, CBasisObjekt>> geoBundle);



     void setGeoNodeToGeoEdgesRepo(DefaultRepo<String, List<CGEOKante>> geoNodeToGeoEdgesRepo);
     TopologyGraph connectTopology();
     void handleBranchingPoints() throws ParseException;
    /**
     * @return List - eine Liste von Balisen aus der PlanProDatei
     */
     List<Balise> getBalises();
     void mapBalisesToCoordinate();

}
