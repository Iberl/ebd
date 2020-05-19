package ebd.logging.util.formatter;

import ebd.globalUtils.appTime.AppTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomizedFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String logTime = LocalDateTime.now().format(dateTimeFormatter);
        String simulationTime = String.valueOf(AppTime.currentTimeMillis());

        return "[" + logTime + "] [" + simulationTime +"] "+ record.getMessage() + "\n";
    }
}
