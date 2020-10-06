package ebd.dbd.client.extension;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class RealDbdClientTest {


    @Test
    public void testConnection() throws JAXBException, ParseException, IOException {
        RealDbdClient client = new RealDbdClient();
        client.connect("localhost");
        client.setValue("TEST", 25);
        System.out.println(client.getValue("TEST"));
        client.setValue("13W2S", 2);
        System.out.println(client.getValue("13W2I"));
    }
}