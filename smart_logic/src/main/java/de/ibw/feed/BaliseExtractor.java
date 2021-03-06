package de.ibw.feed;

import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.TopologyFactory;
import de.ibw.util.DefaultRepo;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CBalise;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektStrecke;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.geodaten._1_9_0.CStrecke;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;
import plan_pro.modell.planpro._1_9_0.CContainer;
import plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * Diese Klasse &uuml;bernimmt das Lesen des PlanProFormates und hinterlegt die dabei verarbeiteten Balisen.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1
 * @since 2021-06-16
 */
public class BaliseExtractor {

    private static DefaultRepo<String, CBalise> balisenRepo;
    private static DefaultRepo<String, CDatenpunkt> dataPointRepo;
    private static DefaultRepo<String, CTOPKante> topEdgeRepo;
    private static DefaultRepo<String, CStrecke> trackRepo;


    private static Object[] repos = new DefaultRepo[] {
            balisenRepo, dataPointRepo, topEdgeRepo, trackRepo
    };
    private enum RepoEnum {
        Balise, DataPoint, TopEdge, Track
    }

    /**
     * in entwicklung, kann verwednet werden, wenn man nur Datenpunkte haben will und keien Balisen
     */
    public enum ExtractorModeEnum {
        NORMAL, DATAPOINT_ONLY
    }
    private static DefaultRepo getRepo(RepoEnum RepoType) {
        switch (RepoType) {
            case Balise: return (DefaultRepo) repos[0];
            case DataPoint: return (DefaultRepo) repos[1];
            case TopEdge: return (DefaultRepo) repos[2];
            case Track: return (DefaultRepo) repos[3];
            default: return null;
        }

    }

    /**
     * generiert aus PlanPro Model eine Liste von Balisen
     *
     * @param datapointOnly - unterscheidung Datenpunkte oder Balisen (noch unbenutzt)
     * @return List
     */
    public static List<Balise> getBalises(ExtractorModeEnum datapointOnly) throws IllegalAccessException {

            handleFileData();
            List<Balise> baliseList = extractBaliseData();
            if (baliseList.size() > 0) {
                Balise B = baliseList.get(0);



            }
        //System.out.println(new ReflectionToStringBuilder(baliseList, new MultilineRecursiveToStringStyle()).toString());

        return baliseList;


    }

    private static List<Balise> extractBaliseData() {
        ArrayList<Balise> baliseResultList = new ArrayList<Balise>();
        Collection<CBalise> inputBalises = getRepo(RepoEnum.Balise).getAll();
        for(CBalise CB : inputBalises) {
            fillBalise(baliseResultList, CB);
        }
        System.out.println(Balise.baliseOnEdge.getKeys().size());
        return baliseResultList;
    }

    private static void fillBalise(ArrayList<Balise> baliseResultList, CBalise CB) {
        CDatenpunkt DataPoint;

        Balise ExtractedBalise = new Balise();
        ExtractedBalise.setPlanProBalise(CB);
        String sDataPointId = CB.getIDDatenpunkt().getWert();
        DataPoint = (CDatenpunkt) getRepo(RepoEnum.DataPoint).getModel(sDataPointId);
        if(null != DataPoint) {
            handleDataPoint(DataPoint, ExtractedBalise);
            storeBalisesByNid_Bg(ExtractedBalise);
        }
        baliseResultList.add(ExtractedBalise);



    }

    /**
     * Stellt bezug her welche Balisen zu welche Datenpunkt geh&ouml;ren
     * @param dataPoint - Datenpunkt
     * @param extractedBalise - der zu Balise gemappt wird
     */
    public static void mapBaliseToDataPoint(CDatenpunkt dataPoint, Balise extractedBalise) {
        storeBalisesByNid_Bg(extractedBalise);
        List<Balise> baliseList = Balise.balisesByBaliseGroup.getModel(dataPoint);
        if(baliseList == null) {
            baliseList = new ArrayList<>();
        }
        if(!baliseList.contains(extractedBalise)) {
            baliseList.add(extractedBalise);
        }
        Balise.balisesByBaliseGroup.update(dataPoint, baliseList);
    }

    private static void storeBalisesByNid_Bg(Balise extractedBalise) {
        // sets Hashcode into repository if new;
        extractedBalise.getHashcodeOfBaliseDp();
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(extractedBalise.getTopPositionOfDataPoint().getIdentitaet().getWert());
        ArrayList<Balise> balisesOnE = Balise.baliseOnEdge.getModel(E);
        if(balisesOnE == null) balisesOnE = new ArrayList<>();
        if(!balisesOnE.contains(extractedBalise)) {
            balisesOnE.add(extractedBalise);
        }
        Balise.baliseOnEdge.update(E, balisesOnE);
    }

    private static void handleDataPoint(CDatenpunkt dataPoint, Balise extractedBalise) {

        extractedBalise.setPlanProDataPoint(dataPoint);
        List<CPunktObjektTOPKante> edgeList = dataPoint.getPunktObjektTOPKante();
        List<CPunktObjektStrecke> trackList = dataPoint.getPunktObjektStrecke();
        if(edgeList.size() > 0) {
            retrieveTopologicalEdgeofBalise(extractedBalise, edgeList);
        }
        if(trackList.size() > 0) {
            retrieveTrackOfBalise(extractedBalise, trackList);
        }
    }

    private static void retrieveTopologicalEdgeofBalise(Balise extractedBalise, List<CPunktObjektTOPKante> edgeList) {
        String sTopEdgeId;
        CTOPKante TopologicalEdge;
        CPunktObjektTOPKante topEdge = edgeList.get(0);
        sTopEdgeId = topEdge.getIDTOPKante().getWert();
        TopologicalEdge = (CTOPKante) getRepo(RepoEnum.TopEdge).getModel(sTopEdgeId);
        extractedBalise.setTopPositionOfDataPoint(TopologicalEdge);
    }

    private static void retrieveTrackOfBalise(Balise extractedBalise, List<CPunktObjektStrecke> trackList) {
        String sTrackId;
        CStrecke Track;
        CPunktObjektStrecke TrackByPoint = trackList.get(0);
        sTrackId = TrackByPoint.getIDStrecke().getWert();
        Track = (CStrecke) getRepo(RepoEnum.Track).getModel(sTrackId);
        extractedBalise.setPlanProTrack(Track);
    }

    private static void initRepos() {

        for(int i = 0; i < repos.length; i++) {
            repos[i] = new DefaultRepo();
        }




    }

    private static void handleFileData() throws IllegalAccessException {

        initRepos();
        CContainer C = TopologyFactory.getContainer();
        List<CBalise> baliseList = C.getBalise();
        List<CDatenpunkt> pointList = C.getDatenpunkt();
        List<CTOPKante> topEdgeList = C.getTOPKante();
        List<CStrecke> trackList = C.getStrecke();

        List[] contents = new List[]  {
                baliseList, pointList, topEdgeList, trackList
        };

        for(int i = 0; i < repos.length; i++) {

            List contentList = contents[i];
            for(Object Content : contentList) {
                CBasisObjekt Basic = (CBasisObjekt) Content;
                String sid = Basic.getIdentitaet().getWert();
                ((DefaultRepo) repos[i]).update(sid, Basic);
            }
        }

    }

}
