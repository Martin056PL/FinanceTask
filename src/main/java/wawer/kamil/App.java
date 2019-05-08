package wawer.kamil;

import wawer.kamil.accountService.AccountService;
import wawer.kamil.accountService.AccountValidators;
import wawer.kamil.model.Account;
import wawer.kamil.model.AccountList;
import wawer.kamil.model.Parser;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser();
        AccountService service = new AccountService();
        AccountList list = parser.readFromXML();

        List<Account> listOfAccounts = list.getAccountList();
        List<Account> listOfValidatedAccounts = service.validateEverySingleAccount(listOfAccounts);
        List<Account> listOfSortedAccounts = service.sotrValidatedAccountList(listOfValidatedAccounts);
        parser.writeToXML(listOfSortedAccounts);

        System.out.println("\n Lista na wejściu: " + listOfAccounts + "\n");
        System.out.println("\n Odfiltowana lista: " + listOfValidatedAccounts + "\n");
        System.out.println("\n posortowana lista: " + listOfSortedAccounts + "\n");

    }
}
