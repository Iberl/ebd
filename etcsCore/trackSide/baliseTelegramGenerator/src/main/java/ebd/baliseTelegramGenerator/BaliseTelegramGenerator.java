package ebd.baliseTelegramGenerator;

import com.google.gson.Gson;
import ebd.messageLibrary.message.Telegram;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static ebd.baliseTelegramGenerator.BaliseTelegramCreator.createTelegramsForBaliseGroup;

public class BaliseTelegramGenerator {

    // IF no Map already exists
    // THEN [x] Read TelegramByBalise Map
    // ELSE [ ] Create Telegrams for every balise in list
    // AND  [x] Save TelegramByBalise Map

    // [ ] Error Messages

    Gson   gson    = new Gson();
    String dirPath = "configuration/balises/";

    private final BaliseTelegramSender sender;
    private String balisePositioningId;

    public BaliseTelegramGenerator(String balisePositioningId) {
        this.balisePositioningId = balisePositioningId;
        Map<String, Telegram[]> telegramsByBalise = null;

        if(Files.isReadable(Paths.get(dirPath + balisePositioningId + ".json"))) {
            try {
                telegramsByBalise = loadTelegramMap();
            } catch(IOException e) {
                // TODO Error: can't be loaded
                System.out.println("telegram map could not be loaded");
                e.printStackTrace();
            }
        } else if(Files.isReadable(Paths.get(dirPath + balisePositioningId + ".xlxs"))) {
            try {
                telegramsByBalise = createTelegramMap();
            } catch(Exception e) {
                // TODO Error: can't be created
                System.out.println("telegram map could not be created");
                e.printStackTrace();
            }
            saveTelegramMap(telegramsByBalise);
        }

        sender = new BaliseTelegramSender(telegramsByBalise);
    }

    private Map<String, Telegram[]> createTelegramMap() {
        File file = new File(dirPath + balisePositioningId + ".xlsx");
        Map<String, Telegram[]> telegramsByBalise = new HashMap<>();

        try {
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // File must be of form:
            // ___|   A   |   B    |    C    |    D    | ... // Coordinates
            //  1 | nid_c | nid_bg | n_total | dp_type | ... // Header
            //  2 |  1..  |  1..   |   1..   |   1..   | ... // First Data Line

            // Skip header
            rowIterator.next();

            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                try {
                    int nid_c   = (int) row.getCell(0).getNumericCellValue();
                    int nid_bg  = (int) row.getCell(1).getNumericCellValue();
                    int n_total = (int) row.getCell(2).getNumericCellValue();
                    int type    = (int) row.getCell(3).getNumericCellValue();
                    Map<String, Telegram[]> telegrams = createTelegramsForBaliseGroup(nid_c, nid_bg, n_total, type);
                    telegramsByBalise.putAll(telegrams);
                } catch(IllegalStateException | NumberFormatException e) {
                    // TODO Fatal Error?
                    System.out.println("malformed datapoint in row " + row.getRowNum());
                }
            }

        } catch(FileNotFoundException e) {
            // TODO Error: no file for creation
            e.printStackTrace();
        } catch(IOException e) {
            // TODO Error: can't read file
            e.printStackTrace();
        }

        return telegramsByBalise;
    }

    private Map<String, Telegram[]> loadTelegramMap() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(dirPath + balisePositioningId + "_telegrams.json"));
        Map<String, Telegram[]> map = gson.fromJson(reader, Map.class);
        reader.close();
        return map;
    }

    private void saveTelegramMap(Map<String, Telegram[]> telegramsByBalise) {
        // TODO Try vs Throw
        try {
            gson.toJson(telegramsByBalise, new FileWriter(dirPath + balisePositioningId + "_telegrams.json"));
        } catch(IOException e) {
            // TODO Error: TelegramMap can't be saved
            System.out.println("telegram map could not be saved");
            e.printStackTrace();
        }
    }

    public String getBalisePositioningId() { return balisePositioningId; }

}
