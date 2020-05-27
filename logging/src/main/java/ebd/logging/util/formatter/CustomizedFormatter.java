package ebd.logging.util.formatter;

import ebd.globalUtils.appTime.AppTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomizedFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String logTime = LocalDateTime.now().format(dateTimeFormatter);

        Instant simI = Instant.ofEpochMilli(AppTime.currentTimeMillis());
        LocalDateTime ldt = simI.atZone(ZoneId.systemDefault()).toLocalDateTime();
        String simulationTime = ldt.format(dateTimeFormatter);

        return "[" + logTime + "] [" + simulationTime +"] "+ record.getMessage() + "\n";
    }
}
