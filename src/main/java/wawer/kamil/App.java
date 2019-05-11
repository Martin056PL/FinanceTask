package wawer.kamil;


import wawer.kamil.accountService.AccountService;
import wawer.kamil.accountService.AccountServiceImpl;
import wawer.kamil.model.Account;
import wawer.kamil.model.Parser;


import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        App.executeProgram();
    }

    private static void executeProgram() throws IOException {
        Parser parser = new Parser();
        List<Account> accounts = parser.readFromXML().getAccountList();

        AccountService service = new AccountServiceImpl();
        List<Account> validatedAccounts = service.validateEverySingleAccount(accounts);
        List<Account> sortedAccounts = service.sortValidatedAccountList(validatedAccounts);
        parser.writeToXML(sortedAccounts);
    }
}
