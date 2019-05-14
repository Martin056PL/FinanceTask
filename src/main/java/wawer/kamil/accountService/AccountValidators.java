package wawer.kamil.accountService;

import wawer.kamil.model.Account;

public interface AccountValidators {

    boolean checkAllValidators(Account account);

    boolean isCurrencyEqualsPLN(String currency);

    boolean isBalanceLowerThanZero(String balance);

    boolean isCloseDateIsBeforePresentDate(String closingDate);

    boolean isIbanHasCorrectFormat(String iban);

    boolean isNameNotNullAndIsNotEmpty(String name);
}
