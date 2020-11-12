package ebd.dbd.client.extension;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import de.ibw.util.DefaultRepo;
import ebd.ConfigHandler;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
public abstract class RealDbdClient implements IDbdClientInterface {







    private static IDbdClientInterface instance = null;


    /**
     * Gibt Instanz eines DBD-Client oder eines Fake wieder.
     * Darf erst aufgerufen werden, nachdem die Weichen in PlanPro gesetzt wurden.
     * Deshalb wird das Interface im PlanPro-Construktor über getInstance aufgerufen
     * @return IDbdClientInterface - der Client
     */
    public static IDbdClientInterface getInstance() {
        ConfigHandler ch  = ConfigHandler.getInstance();
        DefaultRepo<String, Integer> initStateRepo = null;
        if(instance == null) {
            if (ch.isSimulatingEbd) {
                initStateRepo = prompt4InitialStateSetting(ch);
                instance = new SimulateDbdClient(initStateRepo);
            } else {
                instance = null;
                if(ch.initCrossoversInRealdDbdClient) {
                    initStateRepo = prompt4InitialStateSetting(ch);

                }

            }
            updateUi4InitState(initStateRepo);
        }
        return instance;
    }

    private static void updateUi4InitState(DefaultRepo<String, Integer> initStateRepo) {
        //TODO

        //PlanData.getInstance().branchingSwitchList;

    }

    private static DefaultRepo<String, Integer> prompt4InitialStateSetting(ConfigHandler ch) {
        final DefaultRepo<String, Integer>[] fakeRepo = new DefaultRepo[]{new DefaultRepo<>()};
        if(ch.shallUserPrompt4SimulationFile) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    fakeRepo[0] = prompt4CsvFileLocation(fakeRepo[0]);
                }
            });

        } else {
            InputStream in = RealDbdClient.class.getClassLoader().getResourceAsStream("DbdClient/DBD.SIM.CSV");
            CSVReader reader = new CSVReader(new InputStreamReader(in));

            try {
                fillRepoByCsv(fakeRepo[0], reader);
            } catch (CsvValidationException | IOException e) {
                e.printStackTrace();
                fakeRepo[0] = new DefaultRepo<>();
            }
        }
        return fakeRepo[0];
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
