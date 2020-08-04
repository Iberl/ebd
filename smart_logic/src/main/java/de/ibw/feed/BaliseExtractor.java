package de.ibw.feed;

import de.ibw.util.DefaultRepo;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CBalise;
import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektStrecke;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.geodaten._1_9_0.CStrecke;
import plan_pro.modell.geodaten._1_9_0.CTOPKante;
import plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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



    public static void main(String[] args) throws JAXBException {
        getBalisesFromFile("inputPlanPro.ppxml");
    }

    public static List<Balise> getBalisesFromFile(String sFile) throws JAXBException {




        JAXBContext jaxbContext = JAXBContext.newInstance(plan_pro.modell.planpro._1_9_0.ObjectFactory.class);

        //2. Use JAXBContext instance to create the Unmarshaller.
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
        JAXBElement<CPlanProSchnittstelle> unmarshalledObject =
                (JAXBElement<CPlanProSchnittstelle>)unmarshaller.unmarshal(
                        ClassLoader.getSystemResourceAsStream(sFile));

        //4. Get the instance of the required JAXB Root Class from the JAXBElement.
        CPlanProSchnittstelle expenseObj = unmarshalledObject.getValue();
        return getBalises(expenseObj, ExtractorModeEnum.DATAPOINT_ONLY);
    }

    public static List<Balise> getBalises(CPlanProSchnittstelle expenseObj, ExtractorModeEnum datapointOnly) {

            handleFileData(expenseObj);
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

    private static void handleFileData(CPlanProSchnittstelle expenseObj) {

        initRepos();

        List<CBalise> baliseList = expenseObj.getLSTZustand().getContainer().getBalise();
        List<CDatenpunkt> pointList = expenseObj.getLSTZustand().getContainer().getDatenpunkt();
        List<CTOPKante> topEdgeList = expenseObj.getLSTZustand().getContainer().getTOPKante();
        List<CStrecke> trackList = expenseObj.getLSTZustand().getContainer().getStrecke();

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
