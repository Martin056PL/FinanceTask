package wawer.kamil.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {

    public static final Logger LOGGER = Logger.getLogger(Logging.class.getName());

    public static void createLogger() throws IOException {
        CustomFormatter customFormatter = new CustomFormatter();
        FileHandler fileHandler = new FileHandler("src/main/resources/logs.log");
        fileHandler.setFormatter(customFormatter);
        fileHandler.setLevel(Level.FINE);
        LOGGER.addHandler(fileHandler);
    }
}
