package ebd.trainData.tests;

import ebd.globalUtils.configHandler.ConfigHandler;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.util.exceptions.TDBadDataException;

import java.io.IOException;

class TrainDataPermaTest {

     /*@Test
    public void urlTest() throws IOException, ParseException, TDBadDataException {
        ConfigHandler.getInstance().testing = false;
        TrainDataPerma trainDataPerma = new TrainDataPerma(192);


    }*/

    @Test
    public void fileTest() throws IOException, ParseException, TDBadDataException {
        ConfigHandler.getInstance().useTrainConfiguratorTool = true;
        TrainDataPerma trainDataPerma = new TrainDataPerma();
    }

}