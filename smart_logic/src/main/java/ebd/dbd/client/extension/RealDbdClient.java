package ebd.dbd.client.extension;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import de.ibw.util.DefaultRepo;
import ebd.ConfigHandler;
import info.dornbach.dbdclient.DBDClient;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Wrapper-Classe, sie benutzt den Anlagen-Client und dient nicht zur Simulation der Anlage
 * !Achtung die Anlage kann wirklich bedient werden.
 *
 * Es implementiert das Interface zum Wechsel zwischen Echtanwendung und Simulation der Anlage
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-08
 */
public class RealDbdClient extends DBDClient implements IDbdClientInterface {

    private static IDbdClientInterface instance = null;

    /**
     * Gibt Instanz eines DBD-Client oder eines Fake wieder.
     * @return IDbdClientInterface - der Client
     */
    public static IDbdClientInterface getInstance() {
        ConfigHandler ch  = ConfigHandler.getInstance();
        if(instance == null) {
            if (ch.isSimulatingEbd) {
                DefaultRepo<String, Integer> fakeRepo = useSimulatedDbdClient(ch);
                instance = new SimulateDbdClient(fakeRepo);
            } else {
                instance = new RealDbdClient();
            }
        }
        return instance;
    }

    private static DefaultRepo<String, Integer> useSimulatedDbdClient(ConfigHandler ch) {
        DefaultRepo<String, Integer> fakeRepo = new DefaultRepo<>();
        if(ch.shallUserPrompt4SimulationFile) {
            fakeRepo = prompt4CsvFileLocation(fakeRepo);
        } else {
            InputStream in = RealDbdClient.class.getResourceAsStream("DbdClient/DBD.SIM.CSV");
            CSVReader reader = new CSVReader(new InputStreamReader(in));
            try {
                fillRepoByCsv(fakeRepo, reader);
            } catch (CsvValidationException | IOException e) {
                e.printStackTrace();
                fakeRepo = new DefaultRepo<>();
            }
        }
        return fakeRepo;
    }

    private static DefaultRepo<String, Integer> prompt4CsvFileLocation(DefaultRepo<String, Integer> fakeRepo) {
        FileDialog fd = new FileDialog(new JFrame(), "Bitte DBD-CSV selektieren", FileDialog.LOAD);
        fd.setFile("*.sim.csv");
        String filename = fd.getFile();
        if(filename != null) {

            try {

                CSVReader reader = new CSVReader(new FileReader(filename));
                //Reading the contents of the csv file

                fillRepoByCsv(fakeRepo, reader);
            } catch (IOException | CsvValidationException e) {
                e.printStackTrace();
                fakeRepo = new DefaultRepo<>();
            }

        }
        return fakeRepo;
    }

    private static void fillRepoByCsv(DefaultRepo<String, Integer> fakeRepo, CSVReader reader) throws IOException, CsvValidationException {
        String[] line;
        while ((line = reader.readNext()) != null) {
            fakeRepo.update(line[0], Integer.valueOf(line[1]));

        }
    }

    /**
     * Erstellt echten Client
     */
    public RealDbdClient() {
        super();
    }

}
