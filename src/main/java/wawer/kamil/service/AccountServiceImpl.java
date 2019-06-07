package wawer.kamil.service;

import wawer.kamil.model.Account;
import wawer.kamil.utils.Logging;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class AccountServiceImpl implements AccountService {

    private AccountValidatorsImpl validators;
    private Logger logging = Logging.getInstance();
    private Predicate<Account> validateAccount = a -> validators.checkAllValidators(a);
    private Consumer<Account> trimNameOfAccount = a -> trimNameOfAccount(a);

    public AccountServiceImpl() throws IOException {
        this.validators = new AccountValidatorsImpl();
    }

    @Override
    public List<Account> validateEverySingleAccount(List<Account> sourceAccountList) {
        logging.info("Start validation...");
        logging.info("----------------------------------------------------------------------");
        List<Account> validatedList = sourceAccountList.stream().peek(trimNameOfAccount)
                .filter(validateAccount).collect(Collectors.toList());
        logging.info("----------------------------------------------------------------------");
        logging.info("Finish validation...");
        return validatedList;
    }

    @Override
    public List<Account> sortValidatedAccountList(List<Account> validatedAccountList) {
        List<Account> sortedList = new LinkedList<>(validatedAccountList);
        logging.info("Start sorting...");
        Comparator<Account> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        sortedList.sort(comparator);
        logging.info("Finish sorting!");
        return sortedList;
    }

    private void trimNameOfAccount(Account account) {
        account.setName(account.getName().trim());
    }
}
