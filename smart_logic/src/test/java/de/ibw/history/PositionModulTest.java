package de.ibw.history;

import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.plan.elements.model.PlanData;
import ebd.globalUtils.position.Position;
import ebd.rbc_tms.util.PositionInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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


    @BeforeEach
    public void initFunction() {
        MUT = new PositionModul();
        iDataAmount = 0;
        testNid = new ArrayList<>();
        testTrackName = new ArrayList<>();
    }
    private void generatePositionData(int iMin, int iMax) {

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


        for(int i = 0; i < iDataAmount; i++) {
            int iNidEngine = (int) pickRandom(testNid);
            String sTrackId = (String) pickRandom(testTrackName);
            PositionInfo PI = new PositionInfo(Q_SCALE.SCALE_1_M.flag, iNidEngine,null,1,-1,
                    -1,-1,-1, -1, -1, -1, -1 ,-1,
                    -1, -1);
            PositionData PD = new PositionData(1,1,iNidEngine, PI);
            PD.setsIdTopEdge(sTrackId);
            MUT.addPositionData(PD);
        }
    }

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
        generatePositionData(1,10000);
        assertEquals(iDataAmount, MUT.getAllPositions().size(), "Amount not hit");


    }
    @RepeatedTest(100)
    void testWithExtendedDataPositions() {
        initFunction();
        generatePositionData(7,10000);
        assertEquals(iDataAmount, MUT.getAllPositions().size(), "Amount not hit");
        assertEquals(7, MUT.getAllPositions(3).size(), "Nid ID 3 have to be 7 times");
        assertEquals(10, MUT.getAllPositions(null,"String3", null,null).size());
    }



    @Test
    void testWithFilter() {
    }

}