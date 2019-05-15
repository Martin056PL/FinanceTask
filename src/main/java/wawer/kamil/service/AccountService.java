package wawer.kamil.service;

import wawer.kamil.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> validateEverySingleAccount(List<Account> sourceAccountList);

    List<Account> sortValidatedAccountList(List<Account> validatedAccountList);
}
