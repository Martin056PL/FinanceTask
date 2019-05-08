package wawer.kamil.accountService;

import wawer.kamil.model.Account;
import wawer.kamil.model.AccountList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AccountService {

    //TODO Zrobic metode na porównywanie list i porzadkowanie ich;

    private AccountList list;
    private AccountValidators validators;

    public AccountService() {
        this.list = new AccountList();
        this.validators = new AccountValidators();
    }

    public List<Account> validateEverySingleAccount(List<Account> sourceAccountList) {
        List<Account> validatedList = new LinkedList<>();
        Iterator<Account> iterator = sourceAccountList.iterator();
        boolean hasNext = iterator.hasNext();
        while (hasNext) {
            Account account = iterator.next();
            if (validators.checkAllValidators(account)) {
                validatedList.add(account);
                continue;

            }
            hasNext = iterator.hasNext();

        }return validatedList;
    }

    public List<Account> sotrValidatedAccountList(List<Account> validatedAccountList){
        List<Account> sortededList = new LinkedList<>();
        sortededList.addAll(validatedAccountList);
        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortededList.sort(comparator);
        return sortededList;
    }

    private List<Account> getAccountList() {
        List<Account> repository = list.getAccountList();
        return repository;
    }

}
