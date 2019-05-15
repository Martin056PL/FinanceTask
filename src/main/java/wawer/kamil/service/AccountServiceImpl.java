package wawer.kamil.service;

import wawer.kamil.model.Account;
import wawer.kamil.utils.Logging;

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
        Logging.LOGGER.info("Start validation...");
        Logging.LOGGER.info("----------------------------------------------------------------------");
        for (Account account : sourceAccountList) {
            trimNameOfAccount(account);
            if (validators.checkAllValidators(account))
                validatedList.add(account);
        }
        Logging.LOGGER.info("----------------------------------------------------------------------");
        Logging.LOGGER.info("Finish validation...");
        return validatedList;
    }

    @Override
    public List<Account> sortValidatedAccountList(List<Account> validatedAccountList) {
        List<Account> sortedList = new LinkedList<>(validatedAccountList);
        Logging.LOGGER.info("Start sorting...");
        Comparator<Account> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

        sortedList.sort(comparator);
        Logging.LOGGER.info("Finish sorting!");
        return sortedList;
    }

    private void trimNameOfAccount(Account account) {
        account.setName(account.getName().trim());
    }
}
