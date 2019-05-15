package wawer.kamil;


import wawer.kamil.model.Account;
import wawer.kamil.model.Parser;
import wawer.kamil.service.AccountService;
import wawer.kamil.service.AccountServiceImpl;
import wawer.kamil.utils.Logging;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        App.startProgram();
    }

    private static void startProgram() throws IOException {
        Logging.createLogger();

        Parser parser = new Parser();
        Logging.LOGGER.info("Reading XML file...");

        List<Account> accounts = new LinkedList<>();
        boolean isFileHasFound = true;

        try {
            accounts = parser.readFromXML().getAccountList();
        }catch (FileNotFoundException e){
            isFileHasFound = false;
            Logging.LOGGER.info("XML file not found! Exit program!");
        }

        if(isFileHasFound) {
            AccountService service = new AccountServiceImpl();
            Logging.LOGGER.info("Starting validating accounts...");
            List<Account> validatedAccounts = service.validateEverySingleAccount(accounts);
            List<Account> sortedAccounts = service.sortValidatedAccountList(validatedAccounts);
            Logging.LOGGER.info("Writing to XML file...");
            parser.writeToXML(sortedAccounts);
            Logging.LOGGER.info("Finish program!");
        }
    }
}
