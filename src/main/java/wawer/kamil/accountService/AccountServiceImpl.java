package wawer.kamil.accountService;

import wawer.kamil.model.Account;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountValidatorsImpl validators;

    public AccountServiceImpl() {
        this.validators = new AccountValidatorsImpl();
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
            } hasNext = iterator.hasNext();
        }return validatedList;
    }

    public List<Account> sortValidatedAccountList(List<Account> validatedAccountList){
        List<Account> sortedList = new LinkedList<>(validatedAccountList);

        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortedList.sort(comparator);
        return sortedList;
    }

}