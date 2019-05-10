package wawer.kamil.accountService;

import wawer.kamil.model.Account;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountValidatorsImpl validators;

    public AccountServiceImpl() {
        this.validators = new AccountValidatorsImpl();
    }

    @Override
    public List<Account> validateEverySingleAccount(List<Account> sourceAccountList) {
        List<Account> validatedList = new LinkedList<>();
        for (Account account: sourceAccountList) {
            if(validators.checkAllValidators(account))
                validatedList.add(account);
        }
        return validatedList;
    }

    @Override
    public List<Account> sortValidatedAccountList(List<Account> validatedAccountList){
        List<Account> sortedList = new LinkedList<>(validatedAccountList);

        Comparator<Account> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

        sortedList.sort(comparator);
        return sortedList;
    }

}
