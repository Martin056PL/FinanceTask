package wawer.kamil.utils;

import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        LocalDateTime localDateTime = null;
        return "LEVEL: " + record.getLevel() + ", " +  LocalDateTime.now() + " - " + record.getMessage() + "\n";
    }

}
