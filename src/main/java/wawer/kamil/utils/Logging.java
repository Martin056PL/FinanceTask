package wawer.kamil.utils;

import javax.annotation.concurrent.ThreadSafe;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@ThreadSafe
public class Logging {

    private static Logger LOGGER;

    private Logging(){
        //constructor for singleton
    }

    public static Logger getInstance() throws IOException {
        if (LOGGER == null) {
            LOGGER = Logger.getLogger(Logging.class.getName());
            createLogger();
        }
        return LOGGER;
    }

    private static void createLogger() throws IOException {
        CustomFormatter customFormatter = new CustomFormatter();
        FileHandler fileHandler = new FileHandler("src/main/resources/logs.log");
        fileHandler.setFormatter(customFormatter);
        fileHandler.setLevel(Level.INFO);
        LOGGER.addHandler(fileHandler);
    }
}
