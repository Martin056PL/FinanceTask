package wawer.kamil;

import wawer.kamil.accountService.AccountServiceImpl;
import wawer.kamil.model.Account;
import wawer.kamil.model.AccountList;
import wawer.kamil.model.Parser;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser();
        AccountServiceImpl service = new AccountServiceImpl();
        AccountList list = parser.readFromXML();

        List<Account> listOfAccounts = list.getAccountList();
        List<Account> listOfValidatedAccounts = service.validateEverySingleAccount(listOfAccounts);
        List<Account> listOfSortedAccounts = service.sortValidatedAccountList(listOfValidatedAccounts);
        parser.writeToXML(listOfSortedAccounts);

        System.out.println("\n Lista na wejściu: " + listOfAccounts + "\n");
        System.out.println("\n Odfiltowana lista: " + listOfValidatedAccounts + "\n");
        System.out.println("\n posortowana lista: " + listOfSortedAccounts + "\n");

    }
}
