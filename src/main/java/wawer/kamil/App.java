package wawer.kamil;


import wawer.kamil.model.Account;
import wawer.kamil.model.Parser;
import wawer.kamil.service.AccountService;
import wawer.kamil.service.AccountServiceImpl;
import wawer.kamil.utils.Logging;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        App.executeProgram();
    }

    private static void executeProgram() throws IOException {
        Logging.createLogger();

        Parser parser = new Parser();
        Logging.LOGGER.info("Reading XML file...");
        List<Account> accounts = parser.readFromXML().getAccountList();

        AccountService service = new AccountServiceImpl();
        Logging.LOGGER.info("Starting validating accounts...");
        List<Account> validatedAccounts = service.validateEverySingleAccount(accounts);
        List<Account> sortedAccounts = service.sortValidatedAccountList(validatedAccounts);
        Logging.LOGGER.info("Writing to XML file...");
        parser.writeToXML(sortedAccounts);
        Logging.LOGGER.info("Finish program!");
    }
}
