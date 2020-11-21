package de.ibw.history;

import de.ibw.util.DefaultRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PositionModulTest {

    private IPositionModul MUT = new PositionModul();

    private int iDataAmount = 0;

    private ArrayList<Integer> testNid = new ArrayList<>();
    private ArrayList<String> testTrackName = new ArrayList<>();



    private DefaultRepo<Integer, ArrayList<PositionData>> nidRepo  = new DefaultRepo<>();

    private PositionData Current3 = null;



    @BeforeEach
    public void initFunction() {
        MUT = new PositionModul();
        iDataAmount = 0;
        testNid = new ArrayList<>();
        testTrackName = new ArrayList<>();
        nidRepo = new DefaultRepo<>();
        Current3 = null;
    }

    /*private void generatePositionData(int iMin, int iMax) {

        iDataAmount = Math.abs(new Random().nextInt()) % (iMax - iMin) + iMin;
        for(int i = 0 ; i < 7; i++) testNid.add(3);
        while(testNid.size() < iDataAmount) {
            int iNid = Math.abs(new Random().nextInt()) % (27 - 4) + 4;
            testNid.add(iNid);
        }
        for(int i = 0; i < 10; i++) {
            testTrackName.add("String3");
        }
        while(testTrackName.size() < iDataAmount) {
            int iStringIndex = Math.abs(new Random().nextInt()) % (1000 - 4) + 4;
            testTrackName.add("String" + iStringIndex);
        }

        int iDistanceUsedCounter = 0;

        for(int i = 0; i < iDataAmount; i++) {
            int iNidEngine = (int) pickRandom(testNid);
            String sTrackId = (String) pickRandom(testTrackName);
            PositionInfo PI = new PositionInfo(Q_SCALE.SCALE_1_M.flag, iNidEngine,null,1,-1,
                    -1,-1,-1, -1, -1, -1, -1 ,-1,
                    -1, -1);
            PositionData PD = new PositionData(i,i,iNidEngine, PI);
            PD.setsIdTopEdge(sTrackId);
            if(iNidEngine == 3 && iDistanceUsedCounter < 3) {
                iDistanceUsedCounter++;
                PD.setdDistanceToTopNodeA(new BigDecimal("12"));
            } else {
                BigDecimal dDistance = new BigDecimal(new Random().nextDouble()).abs().remainder(new BigDecimal(122))
                        .add(new BigDecimal(12));
                PD.setdDistanceToTopNodeA(dDistance);
            }

            MUT.addPositionData(PD, );
            ArrayList<PositionData> data = nidRepo.getModel(iNidEngine);
            if(data == null) data = new ArrayList<>();
            data.add(PD);
            nidRepo.update(iNidEngine, data);
            if(iNidEngine == 3) {
                this.Current3 = PD;
            }
        }
    }
*/
    private Object pickRandom(ArrayList testNid) {
        int iR = Math.abs(new Random().nextInt()) % testNid.size();
        Object result = testNid.get(iR);
        testNid.remove(iR);
        return result;
    }

    @RepeatedTest(100)
    void testEmptyGetCurrentPositions() {
        initFunction();
        assertTrue(MUT.getAllPositions().size() == 0, "Modul is not initialised but not empty");
        Integer i = new Random().nextInt();
        BigDecimal d1 = BigDecimal.valueOf(new Random().nextDouble());
        BigDecimal d2 = BigDecimal.valueOf(new Random().nextDouble());
        if(d1.compareTo(d2) > 0) {
            BigDecimal temp = d1;
            d1 = d2;
            d2 = temp;
        }
        assertTrue(MUT.getAllPositions(i).size() == 0, "Modul is not initialised but not empty");
        assertTrue(MUT.getAllPositions(i,"test",  d1, d2).size() == 0, "Modul is not initialised but not empty");
        try {
            MUT.getCurrentPositions(i,"test2", d2, d1);
            assertFalse(true, "Method has to throw exception, but it isnt.");
        } catch(InvalidParameterException iEx) {

        }

        assertTrue(MUT.getCurrentPositions().size() == 0, "Modul is not initialised but not empty");
        assertTrue(MUT.getCurrentPosition(i) == null, "Modul having not data");
        assertTrue(MUT.getCurrentPositions(i, "test3", d1, d2). size() == 0, "Modul has to be empty");
        try {
            MUT.getCurrentPositions(i, "test3", d2,d1);
            assertFalse(true, "Method to throw exception, but it isnt.");
        }
        catch(InvalidParameterException IEx) {

        }



    }



    @RepeatedTest(100)
    void testWithDataPositions() {
        initFunction();
        //generatePositionData(1,10000);
        assertEquals(iDataAmount, MUT.getAllPositions().size(), "Amount not hit");


    }

    void WithExtendedDataPositions() {
        initFunction();
        //generatePositionData(7,10000);
        assertEquals(iDataAmount, MUT.getAllPositions().size(), "Amount not hit");
        assertEquals(7, MUT.getAllPositions(3).size(), "Nid ID 3 have to be 7 times");
        assertEquals(10, MUT.getAllPositions(null,"String3", null,null).size(), "Sring3 not found 10 times");
        assertEquals(7, MUT.getAllPositions(3, null, new BigDecimal(1), new BigDecimal(150)).size(), "Range test a not found 7 times");
        assertEquals(nidRepo.getKeys().size(),MUT.getCurrentPositions().size(), "keys not beeing CurrentPosition size");
        assertEquals(this.Current3, MUT.getCurrentPosition(3), "Position for nid engine 3 is not as expected.");
        MUT.getCurrentPositions();
    }



    //TODO TEST with filter

}