package ebd.trainData.tests;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.util.exceptions.TDBadDataException;

import java.io.IOException;

class TrainDataPermaTest {

    @Test
    public void constructorTest() throws IOException, ParseException, TDBadDataException {

        TrainDataPerma trainDataPerma = new TrainDataPerma("http://localhost:8080/trainConfigurator","192");


    }

}