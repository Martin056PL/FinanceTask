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
import java.util.logging.Logger;

public class App {

    public App() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        App.startProgram();
    }

    private static void startProgram() throws IOException {

        Parser parser = new Parser();
        getInstance().info("Reading XML file...");

        List<Account> accounts = new LinkedList<>();
        boolean isFileHasFound = true;

        try {
            accounts = parser.readFromXML().getAccountList();
        }catch (FileNotFoundException e){
            isFileHasFound = false;
            getInstance().info("XML file not found! Exit program!");
        }

        if(isFileHasFound) {
            AccountService service = new AccountServiceImpl();
            getInstance().info("Starting validating accounts...");
            List<Account> validatedAccounts = service.validateEverySingleAccount(accounts);
            List<Account> sortedAccounts = service.sortValidatedAccountList(validatedAccounts);
            getInstance().info("Writing to XML file...");
            parser.writeToXML(sortedAccounts);
            getInstance().info("Finish program!");
        }
    }

    private static Logger getInstance() throws IOException {
        return Logging.getInstance();
    }
}
